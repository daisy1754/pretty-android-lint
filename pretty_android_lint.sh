#!/bin/bash
# Run pretty-android-lint tool to parse and this play the result of Android lint tool.

# Only parse lint result if there is any result.
if [ -f "$TRAVIS_BUILD_DIR/app/build/reports/lint-results.xml" ]; then
  git clone --depth 1 https://github.com/daisy1754/pretty-android-lint.git
  cd $TRAVIS_BUILD_DIR/pretty-android-lint; ./gradlew -q run -Dexec.args="$TRAVIS_BUILD_DIR/app/build/reports/lint-results.xml"
else
  echo "Lint result file does not exist. Exiting."
fi
