# android-pretty-lint
Simple tool to pretty print Android lint result.

[![Build Status](https://travis-ci.org/daisy1754/pretty-android-lint.svg?branch=master)](https://travis-ci.org/daisy1754/pretty-android-lint)
[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT)


android-pretty-lint is a simple Java program that parses an output from Android lint and prints
errors in console. This is written in Java so no additional environment setup is needed.

## Setup with Travis CI

1. Copy pretty_android_lint.sh to your project
2. Make it executable by 
`chmod +x pretty_android_lint.sh`
3. Modify your `.travis.yml`

```
after_failure:
  - ./pretty_android_lint 
```

You'll now see lint error summary in travis log
![TravisOutput](screenshots/travisci_20170913.png)
