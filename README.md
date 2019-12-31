## react-native-imei

A library for React Native apps to easily get the IMEI (International Mobile Equipment Identity) for both single- and multi-SIM devices running Android 4.1+.

IMEI is guaranteed to be non-empty string, otherwise you will get an exception.

Exception is thrown if:
  * Permission is missing
  * Fails to get non-empty imei
  * Device is not Android device

## Warning!

In almost all cases, you do not want to be using the IMEI. It is only available on Android devices with a SIM slot, and [Android 10+ requires special permissions to read it](https://developer.android.com/about/versions/10/privacy/changes#non-resettable-device-ids).

### Google Play

Google Play has strict rules regarding the use of hardware identifiers such as IMEI numbers. Make sure your use of this library is compliant with [current policies](https://play.google.com/about/developer-content-policy) if you plan to distribute your Android app using Google Play.

_Hint: if you are not 100% sure your use case is allowed, the answer is usually no._

### iOS

Apple does not allow apps to access device identiying information such as IMEI. For more information please look at [this StackOverflow question](https://stackoverflow.com/a/19927376).

## Installation

```
npm install react-native-imei --save

# or with yarn
yarn add react-native-imei

# Remember to link after install!
react-native link react-native-imei
```

## Example

```javascript
const IMEI = require('react-native-imei');
IMEI.getImei().then(imeiList => {
	console.log(imeiList); // prints ["AABBBBBBCCCCCCD"]
});
```
