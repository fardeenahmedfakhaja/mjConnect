package in.ac.mjcet.mjconnect.Utils;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by KHAJA FARDEEN AHMED on 3/15/2017.
 */

public class mjConnectOffline extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //offline capability of firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }

}
