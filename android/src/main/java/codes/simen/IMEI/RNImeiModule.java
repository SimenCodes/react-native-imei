package codes.simen.IMEI;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;

public class RNImeiModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;

    public RNImeiModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "IMEI";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();

        TelephonyManager tm = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);
        String imei="";
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            imei = tm.getImei().trim();
        } else {
            imei= tm.getDeviceId();
        }

        if (imei.isEmpty()) {
            throw new RuntimeException("Failed to read IMEI (imei is empty!)");
        }
        constants.put("imei", imei);

        return constants;
    }

}
