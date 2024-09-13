#!/bin/sh
set -e

BRANCH=$(git rev-parse --abbrev-ref HEAD)
REGEX="^(build|chore|hotfix|bugfix|documentation|merge|feature|refactor|revert|style)\.([a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*)$"

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'
echo "Branch name: ${GREEN}$BRANCH${NC}"
if ! echo "$BRANCH" | grep -qE "$REGEX"; then
  echo "${RED}Your commit was rejected due to branching name"
  echo "Please rename your branch with '(build|chore|hotfix|bugfix|documentation|merge|feature|refactor|revert|style)(.<ticket>?).<subject-example>' syntax${NC}"
  exit 1
fi
./gradlew lint detekt spotlessCheck
./gradlew dokkaHtml dokkaGfm

git add docs/*

######## KTLINT-GRADLE HOOK START ########

CHANGED_FILES="$(git --no-pager diff --name-status --no-color --cached | awk '$1 != "D" && $NF ~ /\.kts?$/ { print $NF }')"

if [ -z "$CHANGED_FILES" ]; then
    echo "No Kotlin staged files."
    exit 0
fi;

echo "Running ktlint over these files:"
echo "$CHANGED_FILES"

diff=.git/unstaged-ktlint-git-hook.diff
git diff --color=never > $diff
if [ -s $diff ]; then
  git apply -R $diff
fi

./gradlew --quiet ktlintFormat -PinternalKtlintGitFilter="$CHANGED_FILES"
gradle_command_exit_code=$?

echo "Completed ktlint run."

echo "$CHANGED_FILES" | while read -r file; do
    if [ -f $file ]; then
        git add $file
    fi
done


if [ -s $diff ]; then
  git apply --ignore-whitespace $diff
fi
rm $diff
unset diff

echo "Completed ktlint hook."
exit $gradle_command_exit_code
######## KTLINT-GRADLE HOOK END ########