## v1.0.1

### 1.0.1.346

- Fixed an issue that could cause an app failure when rendering overlay text with the `WZText` API class.
- Fixed an issue causing audio-only streams to be broadcast with an improperly added video configuration.
- Added addt'l error checking and logging to to trap improper use of the lower level encoder classes.
- Added a warning to the log output if an `WZRenderAPI.VideoFrameRenderer` implementation attempts to call `onWZVideoFrameRendererDraw()` before `onWZVideoFrameRendererInit()` has been called.

### 1.0.1.340

- Fixed an issue in `WZMP4Writer` that could cause a crash or indeterminate state when capturing an MP4 while streaming
- Added a screenshot example to the sample app demonstrating the registration and usage of a video frame listener with the `WZCameraView` class

### 1.0.1.333

- The `WZMP4Writer` and `WZMP4Broadcaster` classes now support writing and broadcasting audio tracks respectively.
- Fixed an issue that could cause an app to hand if the server connection failed.
- Fixed an issue that could cause a crash if a camera device had been locked by another app.

### 1.0.1.318

- Addition of a `WZGLBroadcaster` class to capture and stream from video sources other than the `WZCameraView` and simplify the process of integrating any OpenGL ES-based app.
- Expanded constructors are now available for the `WZGLES.EglEnv` OpenGL ES utility class that can be used with a wide variety of OpenGL ES configurations
- Expanded and updated the javadocs

### 1.0.1.292

#### SDK Updates

- Improvements in the encoder I/O pipeline providing better performance and reliability in low bandwidth situations
- Fixed an issue intermittently causing a crash when streaming was stopped
- Fixed an issue that could cause the display to flash after streaming for an extended period of time
- Fixed an issue that could cause the display to become out of sync if the device was rotated rapidly

### 1.0.1.259

#### SDK Updates

- Fixed an issue causing `WZCameraView.getCamera()` to return `null` after an app returned to the foreground
- `WZCameraView.getStatus()` has been deprecated in favor of `WZCameraView.getPreviewStatus()`
- `WZCameraView.isPaused()` has been deprecated in favor of `WZCameraView.isPreviewPaused()`
- The `WZAudioDevice` class now includes the methods `getSamplingConfig()` / `setSamplingConfig(WZBroadcastConfig)` to specify custom audio properties from the audio sampler.
- Added the `WZVideoFrameRenderer` class to separate frame renderers from frame listeners (`WZVideoFrameListener`) enabling a simpler integration model for developing plugins

#### Sample App Updates

- A new activity class has been added (`BluetoothActivity`) demonstrating the use of a Bluetooth mic as the audio capture device

### 1.0.1.248

- Fixed an issue causing the aspect ratio of the camera preview to be displayed incorrectly on certain devices
- Fixed an issue activating the camera on single-camera devices
- When attempting to publish to a stream that is already active on a WSE server configured to disallow it,  the error is now correctly reported.
- Several methods of the `WZCamera` class that were previously `protected` are not `public` to aid development of apps wishing to access the camera through methods other than `WZCameraView`.

### 1.0.1.230

#### SDK Updates

- Added a `setAudioSource()` method to the `WZAudioDevice` class for specifying a specific device as the source for the audio stream. See the documentation for Android's <a href="https://developer.android.com/reference/android/media/MediaRecorder.AudioSource.html">android.media.MediaRecorder.AudioSource</a> class for a list of the values that can be specified.

#### Issues Fixed

- Fixed a critical bug that was causing the camera preview to be resized to the video stream's frame size once a streaming broadcast was initiated.
- Updated the API documentation to remove outdated references to the camera direction specifier also being used as the unique camera id
- Improved error detection and reliability in the audio encoder framework
- Fixed a bug in the sample app that occurred on single camera devices

#### Outstanding Issues
- If the frame size of the camera preview has a different aspect ratio than the size of the `WZCameraView` containing the preview, the preview may not fill the view completely on certain devices.
- If the frame size of the camera preview has a different aspect ratio than the frame size specified in the broadcast configuration, the aspect ratio of the video stream may be incorrect on certain devices.

_A fix for both of these issues is in progress and will be available in the next SDK build to be released within the next couple of days._

### 1.0.1.219

* Added support for adaptive bitrate control settings to the `WZMediaConfig` class.
* Added support for displaying text overlays in the video stream via the `WZText` and `WZTextManager` classes.
* Added `setPreviewReadyListener` to `WZCameraView` as a callback to be invoked when the camera preview display is fully initialized.

## v1.0.0

### 1.0.0.177

* Fixed an issue that could cause the camera preview to become unresponsive when streaming over a low bandwidth connection.
* Improved compatibility with devices running Android APIs 19 thru 21.

### 1.0.0.172

* Fixed an issue in the `WZBitmap` class causing a crash when returning to a paused activity

### 1.0.0.167

* Fixed a problem causing the camera preview to not start on occasion after the device wakes up

### 1.0.0.163

* Methods `onResume()` and `onPause()` have been added to the `WZCameraView` class that should be called from the corresponding Android activity lifecycle. See the `CameraActivity` and `CameraActivityBase` classes in the sample app for examples of their use.

* A `WZBitmap` class has been added enabling the rendering of bitmap as overlays in the camera preview display.
* An `OverlayBitmapActivity` has been added to the sample app demonstrating the use of the new `WZBitmap` features.

* The `WZRenderAPI.FrameListener` interface has been renamed `WZRenderAPI.VideoFrameListener`.

* A `WZAudioDevice.AudioSampleListener` interface has been added for building audio sample listener classes, replacing the `SampleListener` interface.
* A `WZAudioDevice.registerAudioSampleListener(...)` method has been added for registering audio sample listener classes, replacing the `registerFrameListener` method.
* Methods `startAudioSampler()` and `stopAudioSampler()` have been added to the `WZAudioDevice` class to enable sampling the audio input device when not streaming.
* Note that the support audio sample rates are limited to 8000, 11025, 22050, 44100, and 48000. If another value is specified via `WZMediaConfig.setAudioSampleRate` the actual rate selected will be the next highest value.
* An `AudioMeterActivity` has been added to the sample app demonstrating the use of the audio sample listener updates.

### 1.0.0.141

* Fixed an issue causing the camera preview to always be cropped for frames sizes not matching the aspect ratio of the screen.
* Fixed a crash that occur when stopping the broadcast before it has reached RUNNING state.

### 1.0.0.121

* A bug was fixed that was causing the key frame interval to be calculated incorrectly for the video stream
* A bug was fixed that prohibited errors from being reported correctly that occurred while streaming.
* The `WZCamera` and `WZCameraView` classes were updated with improved error reporting capabilities. See the `onResume()` method of the `CameraActivity` class in the sample app for examples of their use.
    * The `WZCamera` now includes additional methods that can be used to detect if an error occurred when the SDK was attempting to open the camera:
        * `boolean isAvailable()`
        * `getLastError()`
        * `WZStatus getStatus()`
    * The `WZCameraView` now includes a method entitled `getAvailableDeviceCameras()` that can be used to return only those camera that can be successfully opened and accessed without error.
* The `WZError` class now includes a method entitled `getException()` that will return any Java exception that was associated with the SDK error.
* The `toString()` method for the `WZMediaConfig` and it's subclasses now returns a detailed listing of the configuration properties.
* Two classes were added to the SDK for working with the video track in MP4 files (audio track support coming soon). See the `MP4CaptureActivity` and `MP4BroadcastActivity` classes in the sample app for examples of their use.
    * `WZMP4Writer` can be used to write an MP4 to local storage of the video stream
    * `WZMP4Broadcaster` can be used to stream the video from an MP4 file
* Experimental support has been added for H.264 profiles and profile levels. See the `onSettings` method of `CameraActivity` class in the sample app for an example of querying the profiles and profile levels available.
    * The `WZMediaConfig` class now includes a profile level property for specifying the profile and profile levels (`setVideoProfileLevel` / `getVideoProfileLevel`).
    * `int[] WZEncoderAPI.getProfiles()` returns an array of H.264 profile identifiers supported by the current device's H.264 encoder.
    * `WZProfileLevel[] WZEncoderAPI.getProfileLevels()` returns an array of the `WZProfileLevel` instances describing the H.264 profiles and profile levels supported by the current device's H.264 encoder.

### 1.0.0.82

* Fixed an SDK bug that could cause a crash when a device went to sleep.
* Added `getDefaultBroadcastConfig()` method to `WowzaGoCoder` class
* Added abstract base activity class `GoCoderSDKActivity` to the sample app to consolidate common Activity code

### 1.0.0.75

* Added a subclass of the Android `SurfaceTexture` class named `WZSurfaceTexture` that provides a seamless API to render, encode, and stream OpenGL ES output.
* Added an example of using the `WZSurfaceTexture` class to the sample app
* Added an option to loop the playback and streaming to the sample app MP4 broadcast example
* Added audio and video bitrate settings to the sample app preferences dialogs

### 1.0.0.65

#### Changes

* In the **WZStatusCallback** interface, the following method signatures have been changed in order to reduce the chance of collision with identically named methods in other sources/libraries.

    - **onSuccess** is now named **onWZStatus**
    - **onError** is now named **onWZError**

**PLEASE NOTE: THIS IS A BREAKING CHANGE, AND YOUR CODE WILL NEED TO BE UPDATED TO USE THESE NEW METHOD NAMES**

* The abstract **WZRenderAPI** class has been added for developing rendering plugins
* The **WZSurfaceRenderer** class has been renamed to **WZTextureRenderer**
* Rendering plugin registration methods **registerRenderPlugin** and **unregisterRenderPlugin** are available from the  top-level **WowzaGoCoder** API.
* The encoder-related and rendering-related classes have been placed in packages names **encoder** and **render**, respectively.
* A package containing the **gles** utility classes from **[Grafika](https://github.com/google/grafika)**, Google's suite of OpenGL ES examples, have been added.
* The default scaling mode is now **WZMedia.FILL_FRAME**
* An example of saving the video stream to a local MP4 file (**MP4CaptureActivity**) has been added to the sample app

#### Issues fixed

* Streaming portrait video is now supported

### 1.0.0.51

#### Changes

* The sample app has been updated to manually check and query for required permissions per the new permissions model in 6.0 (Marshmallow)

#### Issues fixed

* Fixed a bug setting the status of the broadcast status causing a periodic crash
* Fixed an aspect ratio mis-calculation
* Fixed a periodic crash on startup on Android 6.0
* Fixed an issue that caused the front camera preview to be flipped
* Fixed an issue causing auto focus to fail on some devices

#### Known issues

* Video sent with the device in portrait orientation will be sent as landscape and letterboxes. This will be fixed in the next beta release.
