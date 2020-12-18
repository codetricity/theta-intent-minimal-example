# Broadcast Intent Minimal Example for RICOH THETA

https://community.theta360.guide/t/simple-explanation-of-broadcast-intent-for-ricoh-theta-development/4201

## Close Camera

To use the CameraAPI, you’ll need to close the main RICOH camera app.

```java
    Intent closeCameraIntent = new Intent("com.theta360.ACTION_MAIN_CAMERA_CLOSE");
    sendBroadcast(closeCameraIntent);
```

## Open Camera

```java
@Override
protected void onPause() {
    super.onPause();

    Intent openCameraIntent = new Intent("com.theta360.plugin.ACTION_CAMERA_OPEN");
    sendBroadcast(openCameraIntent);
}
```