## react-native-imei

A react native library for Android, will return IMEI when app is being run on an Android device and has READ_PHONE_STATE permission.

Imei is guaranteed to be non-empty string, otherwise you will get an exception.

Exception is thrown if:
  * Permission is missing
  * Fails to get non-empty imei
  * Device is not Android device


## Installation

```
npm install react-native-imei --save

# or with yarn
yarn add react-native-imei

# Remember to link after install!
react-native link react-native-imei
```

Based on [rebeccahughes/react-native-device-info](https://github.com/rebeccahughes/react-native-device-info)

## Examples

```javascript
// JavaScript
const IMEI = require('react-native-imei');
IMEI.getImei();
```

```clojure
; ClojureScript
(def imei-module (js/require "react-native-imei"))
(def imei (.getImei imei-module))
```
