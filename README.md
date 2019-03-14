## react-native-imei

A react native library for Android, will return IMEI (International Mobile Equipment Identity) when app is being run on an Android device and has READ_PHONE_STATE permission.

IMEI is guaranteed to be non-empty string, otherwise you will get an exception.

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

## Examples

```javascript
// JavaScript
const IMEI = require('react-native-imei');
IMEI.getImei().then(imeiList => {
	console.log(imeiList)
});
```

## Google Play

Google Play has fairly strict rules regarding the use of hardware identifiers such as IMEI numbers. Make sure your use of this library is compliant with [current policies](https://play.google.com/about/developer-content-policy) if you plan to distribute your Android app using Google Play.

## iOS

This library does not support iOS devices. Apple does not allow apps to access device identiying information such as IMEI. For more information please look at [this StackOverflow question](https://stackoverflow.com/a/19927376).
