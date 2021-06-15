package com.healthpod.healthsense;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

private Executor executor = Executors.newSingleThreadExecutor();
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};

    private static final int RC_SIGN_IN = 123;
    private String mVisitID = "";
    private final String mPodID = "AinShamsPod";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // already signed in
            Toast.makeText(this, "current Firebase User = "+auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        } else {
            // not signed in
            startActivityForResult(
                    // Get an instance of AuthUI based on the default app
                    AuthUI.getInstance().createSignInIntentBuilder().build(),
                    RC_SIGN_IN);
        }

//mPreviewView = findViewById(R.id.previewView);
//captureImage = findViewById(R.id.captureImg);

        if(allPermissionsGranted()){
            //startCamera(); //start camera if permission has been granted by user
        } else{
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }
    }



    private boolean allPermissionsGranted(){

        for(String permission : REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
                Toast.makeText(this, "Sign in Failed. Error = " + response.getError().getErrorCode(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_PERMISSIONS){
            if(allPermissionsGranted()){
                //startCamera();
            } else{
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }

    public void onClickBloodPressureImageView(View view) {
        Intent camIntent = new Intent(this, camera.class);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        if(mVisitID == "") mVisitID = "visit-number-" + mDateFormat.format(new Date());
        camIntent.putExtra("visitID", mVisitID);
        camIntent.putExtra("podID", mPodID);
        camIntent.putExtra("deviceID", "bloodPressure");


        startActivity(camIntent);
    }

    public void onClickSPO2ImageView(View view) {
        Intent camIntent = new Intent(this, camera.class);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        if(mVisitID == "") mVisitID = "visit-number-" + mDateFormat.format(new Date());
        camIntent.putExtra("visitID", mVisitID);
        camIntent.putExtra("podID", mPodID);
        camIntent.putExtra("deviceID", "SPO2");


        startActivity(camIntent);
    }


    public void onClickGlucoseImageView(View view) {
        Intent camIntent = new Intent(this, camera.class);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        if(mVisitID == "") mVisitID = "visit-number-" + mDateFormat.format(new Date());
        camIntent.putExtra("visitID", mVisitID);
        camIntent.putExtra("podID", mPodID);
        camIntent.putExtra("deviceID", "Glucose");


        startActivity(camIntent);
    }

    public void onClickTemperatureImageView(View view) {
        Intent camIntent = new Intent(this, camera.class);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        if(mVisitID == "") mVisitID = "visit-number-" + mDateFormat.format(new Date());
        camIntent.putExtra("visitID", mVisitID);
        camIntent.putExtra("podID", mPodID);
        camIntent.putExtra("deviceID", "Temperature");


        startActivity(camIntent);
    }

    public void onClickOtoscopeImageView(View view) {
        Intent camIntent = new Intent(this, OtoscopeUSB.class);

        SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        if(mVisitID == "") mVisitID = "visit-number-" + mDateFormat.format(new Date());
        camIntent.putExtra("visitID", mVisitID);
        camIntent.putExtra("podID", mPodID);
        camIntent.putExtra("deviceID", "Otoscope");


        startActivity(camIntent);
    }

//private void startCamera() {
//
//    final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);
//
//    cameraProviderFuture.addListener(new Runnable() {
//        @Override
//        public void run() {
//            try {
//
//                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
//                bindPreview(cameraProvider);
//
//            } catch (ExecutionException | InterruptedException e) {
//                // No errors need to be handled for this Future.
//                // This should never be reached.
//            }
//        }
//    }, ContextCompat.getMainExecutor(this));
//}

//    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
//
//        Preview preview = new Preview.Builder()
//                .build();
//
//        CameraSelector cameraSelector = new CameraSelector.Builder()
//                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
//                .build();
//
//        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
//                .build();
//
//        ImageCapture.Builder builder = new ImageCapture.Builder();
//
//        //Vendor-Extensions (The CameraX extensions dependency in build.gradle)
//        HdrImageCaptureExtender hdrImageCaptureExtender = HdrImageCaptureExtender.create(builder);
//
//        // Query if extension is available (optional).
//        if (hdrImageCaptureExtender.isExtensionAvailable(cameraSelector)) {
//            // Enable the extension if available.
//            hdrImageCaptureExtender.enableExtension(cameraSelector);
//        }
//
//        final ImageCapture imageCapture = builder
//                .setTargetRotation(this.getWindowManager().getDefaultDisplay().getRotation())
//                .build();
//
//        preview.setSurfaceProvider(mPreviewView.createSurfaceProvider());
//
//        Camera camera = cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, preview, imageAnalysis, imageCapture);
//
//        captureImage.setOnClickListener(v -> {
//
//            SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
//            File file = new File(getBatchDirectoryName(), mDateFormat.format(new Date())+ ".jpg");
//
//            ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(file).build();
//            imageCapture.takePicture(outputFileOptions, executor, new ImageCapture.OnImageSavedCallback () {
//                @Override
//                public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
//                    new Handler(Looper.getMainLooper()).post(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(MainActivity.this, "Image Saved successfully", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }
//                @Override
//                public void onError(@NonNull ImageCaptureException error) {
//                    error.printStackTrace();
//                }
//            });
//        });
//    }

    //    public String getBatchDirectoryName() {
//
//        String app_folder_path = "";
//        app_folder_path = Environment.getExternalStorageDirectory().toString() + "/images";
//        File dir = new File(app_folder_path);
//        if (!dir.exists() && !dir.mkdirs()) {
//
//        }
//
//        return app_folder_path;
//    }
}
