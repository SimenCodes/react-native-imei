# react-native-imei

A react native library for Android, will return IMEI when app is being run on an Android device and has READ_PHONE_STATE permission.
Rejects if permission is missing, and returns null if run on a non-Android device. 

```
# Remember to link after install
react-native link react-native-imei
```

Based on rebeccahughes/react-native-device-info