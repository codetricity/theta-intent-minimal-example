package org.codecakes.broadcastintent;

import android.content.Intent;
import android.os.Bundle;

import com.theta360.pluginlibrary.activity.PluginActivity;
import com.theta360.pluginlibrary.values.LedColor;
import com.theta360.pluginlibrary.values.LedTarget;

public class MainActivity extends PluginActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  setAutoClose(true);


        // this is not needed
        Intent led3Intent = new Intent("com.theta360.plugin.ACTION_LED_SHOW");
        led3Intent.putExtra("target", LedTarget.LED3.toString());
        led3Intent.putExtra("color", LedColor.MAGENTA.toString());
        sendBroadcast(led3Intent);

        // use the library
//        notificationLed3Show(LedColor.YELLOW);  // this works

//        Intent closeCameraIntent = new Intent("com.theta360.ACTION_MAIN_CAMERA_CLOSE");
//        sendBroadcast(closeCameraIntent);

        Intent openCameraIntent = new Intent("com.theta360.plugin.ACTION_CAMERA_OPEN");
        sendBroadcast(openCameraIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

        Intent openCameraIntent = new Intent("com.theta360.plugin.ACTION_CAMERA_OPEN");
        sendBroadcast(openCameraIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // not needed
        Intent finishIntent =  new Intent("com.theta360.plugin.ACTION_FINISH_PLUGIN");
        finishIntent.putExtra("packageName", "org.codecakes.broadcastintent");
        finishIntent.putExtra("exitStatus", "success");
        sendBroadcast(finishIntent);
    }
}
