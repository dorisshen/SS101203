package com.test.tt101203;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.imageView);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        ImageRequest request = new ImageRequest("https://farm3.staticflickr.com/2194/1893036291_2ec9abc7f4_o_d.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        img.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.RGB_565 , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("NET", error.toString());
            }
        });
        queue.add(request);
        queue.start();

    }
}
