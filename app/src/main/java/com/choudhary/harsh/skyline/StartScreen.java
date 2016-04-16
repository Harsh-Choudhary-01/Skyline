package com.choudhary.harsh.skyline;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.net.URI;
import java.util.Calendar;
import java.util.StringTokenizer;

public class StartScreen extends AppCompatActivity
{
    Calendar rightNow = Calendar.getInstance();
    public  String imageName;
    static  final  int camRequest = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }
    public void StartCamera(View view)
    {
        Button soup = ((Button) view);
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = GetFile();
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT , Uri.fromFile(file));
        startActivityForResult(camera_intent , camRequest);
    }
    public void RunSettings(View view)
    {

    }
    private File GetFile()
    {
        File folder = new File("sdcard/skyline");
        if(!folder.exists())
            folder.mkdir();
        rightNow = Calendar.getInstance();
        imageName = ("image" + rightNow.get(Calendar.HOUR) +
                rightNow.get(Calendar.MINUTE) + rightNow.get(Calendar.SECOND) + rightNow.get(Calendar.MILLISECOND) + ".jpg");
        File image_file = new File(folder, imageName);
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        String path = ("sdcard/skyline/" + imageName);
    }
}
