#!/bin/sh
set -e

GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'
changed_files=$(git diff --name-only HEAD HEAD~ -- '*.kt')
if [ -n "$changed_files" ]; then
  echo "${BLUE}Running tests due to changes in the following Kotlin files:${NC}"
  echo "$changed_files"
  ./gradlew test
else
  echo "${GREEN}No Kotlin files have been changed. Skipping tests.${NC}"
fi
./gradlew build