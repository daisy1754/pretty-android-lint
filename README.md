# android-pretty-lint
Simple tool to pretty print Android lint result.

android-pretty-lint is a simple Java program that parses an output from Android lint and prints
errors in console. This is written in Java so no additional environment setup is needed.

## Setup with Travis CI
Add below to your `.travis.yml`

```
after_failure:
  - git clone --depth 1 https://github.com/daisy1754/pretty-android-lint.git
  - cd $TRAVIS_BUILD_DIR/pretty-android-lint; ./gradlew -q run -Dexec.args="$TRAVIS_BUILD_DIR/app/build/reports/lint-results.xml"
```

You'll now see lint error summary in travis log
![TravisOutput](screenshots/travisci_20170913.png)

## LICENSE
MIT