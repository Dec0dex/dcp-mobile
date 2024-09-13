BRANCH=$(git rev-parse --abbrev-ref HEAD)
REGEX="^(build|chore|hotfix|bugfix|documentation|merge|feature|refactor|revert|style)\.([a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*)$"

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'
set -e
echo "Branch name: ${GREEN}$BRANCH${NC}"
if ! echo "$BRANCH" | grep -qE "$REGEX"; then
  echo "${RED}Your commit was rejected due to branching name"
  echo "Please rename your branch with '(build|chore|hotfix|bugfix|documentation|merge|feature|refactor|revert|style)(.<ticket>?).<subject-example>' syntax${NC}"
  exit 1
fi
./gradlew lint detekt ktlintCheck spotlessCheck
./gradlew dokkaHtml dokkaGfm
