/**
 * @providesModule react-native-imei
 */

var ReactNative = require('react-native');

if (ReactNative.Platform.OS === "android") {
    module.exports = {
        getImei: function () {
            return ReactNative.NativeModules.IMEI.getImei();
        }
    };
} else {
    module.exports = {
        getImei: function () {
            throw new Error("Not supported");
        }
    }
}
