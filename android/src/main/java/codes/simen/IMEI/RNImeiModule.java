package codes.simen.IMEI;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

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
        ArrayList imei = new ArrayList();
        String imei1;
        String imei2;

        TelephonyManager tm = (TelephonyManager) this.reactContext.getSystemService(Context.TELEPHONY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= 26) {
            imei1 = tm.getImei(0);
            imei2 = tm.getImei(1);
        } else {
            imei1 = tm.getDeviceId(0);
            imei2 = tm.getDeviceId(1);
        }

        imei.add(imei1);

        if (imei2 != null) {
            imei.add(imei2);
        }

        if (imei.size() == 0 || imei1.isEmpty()) {
            throw new RuntimeException("Failed to read IMEI (imei is empty!)");
        }

        constants.put("imei", imei1);
	constants.put("dualImei", imei);

        return constants;
    }

}
