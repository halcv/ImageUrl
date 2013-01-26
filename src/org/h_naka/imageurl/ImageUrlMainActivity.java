package org.h_naka.imageurl;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.widget.Toast;

public class ImageUrlMainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        AsyncImageDownloadTask task = new AsyncImageDownloadTask(this);
        final String picURL = "https://fbcdn-sphotos-d-a.akamaihd.net/hphotos-ak-ash4/303372_343242992424624_358712013_n.jpg";
        task.execute(picURL);
    }

    public void drawBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            ImageView imgView = (ImageView)findViewById(R.id.imageView);
            imgView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this,R.string.dl_error,Toast.LENGTH_LONG).show();
        }
    }
}
