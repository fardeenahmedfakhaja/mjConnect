package in.ac.mjcet.mjconnect.Utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import in.ac.mjcet.mjconnect.Constants.NumberConstants;
import in.ac.mjcet.mjconnect.Constants.StringConstants;

/**
 * Created by test on 09/03/17.
 */

public class Helper {
    public static boolean checkCameraPermission(Context context){
        int permissionCheck = ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    public static void  askCameraPermission(Activity context){
        ActivityCompat.requestPermissions(context,
                new String[]{Manifest.permission.CAMERA}, NumberConstants.CAMERA_PERMISSION);
    }
}
