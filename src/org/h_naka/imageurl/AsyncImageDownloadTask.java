package org.h_naka.imageurl;

import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AsyncImageDownloadTask extends AsyncTask<String,Void,Bitmap> {
    private ImageUrlMainActivity m_Activity;

    public AsyncImageDownloadTask(ImageUrlMainActivity parent) {
        m_Activity = parent;
    }
    
    protected Bitmap doInBackground(String... params) {
        InputStream is = null;
        // 画像を表すオブジェクト
        Bitmap bitmap = null;
        try {
            // ネットワーク上からInputStreamを取得
            URL url = new URL(params[0]);
            is = url.openStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap result) {
        m_Activity.drawBitmap(result);
    }
}

