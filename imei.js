/**
 * @providesModule react-native-imei
 */

var ReactNative = require('react-native');

if (ReactNative.Platform.OS === "android") {
    module.exports = {
        getIMEI: function () {
            return ReactNative.NativeModules.IMEI.getIMEI();
        }
    };
} else {
    module.exports = {
        getIMEI: function () {
            return new Promise((resolve, reject) => {
                resolve(null);
            });
        }
    }
}
