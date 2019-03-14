package codes.simen.IMEI;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNImeiModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private TelephonyManager tm;

    public RNImeiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        tm = (TelephonyManager) reactContext.getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Override
    public String getName() {
        return "IMEI";
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    @ReactMethod
    public void getImei(Promise promise) {
        if (!hasPermission()) {
            promise.reject(new RuntimeException("Missing permission " + Manifest.permission.READ_PHONE_STATE));
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                int count = tm.getPhoneCount();
                String[] imei = new String[count];
                for (int i = 0; i < count; i++) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        imei[i] = tm.getImei(i);
                    } else {
                        imei[i] = tm.getDeviceId(i);
                    }
                }
                promise.resolve(Arguments.fromJavaArgs(imei));
            } else {
                promise.resolve(Arguments.fromJavaArgs(new String[]{tm.getDeviceId()}));
            }
        }
    }

    private boolean hasPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return reactContext.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
        } else return true;
    }

}
