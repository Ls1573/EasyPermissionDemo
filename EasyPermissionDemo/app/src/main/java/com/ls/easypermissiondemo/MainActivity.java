package com.ls.easypermissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ls.easypermissiondemo.permission.AfterPermissionGranted;

import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 文件读取
     */
    @AfterPermissionGranted(101)
    protected void requestWRITEPermission() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "11111", Toast.LENGTH_SHORT).show();
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "请求访问你的文件",
                    101, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    }

    @OnClick({R.id.btn1})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                requestWRITEPermission();
                break;
        }
    }
}
