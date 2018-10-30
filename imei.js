/**
 * @providesModule react-native-imei
 */

var ReactNative = require('react-native');

if (ReactNative.Platform.OS === "android") {
    module.exports = {
        getImei: function () {
            return ReactNative.NativeModules.IMEI.imei;
        },
        getDualImei: function () {
            return ReactNative.NativeModules.IMEI.dualImei;
        }
    };
} else {
    module.exports = {
        getImei: function () {
            throw new Error("Not implemented");
        }
    }
}
