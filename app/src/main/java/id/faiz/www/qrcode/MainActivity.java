package id.faiz.www.qrcode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISION_ALL = 1;

    private Class<?> mAClass;
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
    }

    public void launchScanner(View v){
        launcActivity(scan_qr.class);
    }

    private void launcActivity(Class<?> clss) {
        String[] PERMISSIONS = {Manifest.permission.INTERNET,Manifest.permission.CAMERA,Manifest.permission.ACCESS_NETWORK_STATE};
        if (ContextCompat.checkSelfPermission(this, String.valueOf(PERMISSIONS))
                != PackageManager.PERMISSION_GRANTED) {
            mAClass = clss;
            ActivityCompat.requestPermissions(this,
                    PERMISSIONS, PERMISION_ALL);
        }else{
            Intent intent = new Intent(this, clss);
            startActivity(intent);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISION_ALL){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, mAClass);
                startActivity(intent);
            }else{
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Activityjson(View view) {
        launcActivity(jsonChecker.class);
    }
}
