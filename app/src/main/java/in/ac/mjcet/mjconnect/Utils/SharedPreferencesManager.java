package in.ac.mjcet.mjconnect.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aleem on 28/01/17.
 */

public class SharedPreferencesManager {
    private static final String SharedPreferencesName = "com.example.aleem";
    private static SharedPreferences sharedPreferences;

    public static synchronized SharedPreferences getInstance(Context context){
        if(sharedPreferences == null){
            sharedPreferences = context.getSharedPreferences(SharedPreferencesName,Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

}
