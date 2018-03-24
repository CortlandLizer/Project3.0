/*
package com.example.parsejson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.HttpURLConnection;

*/
/**
 * Created by cortland on 3/23/2018.
 *//*


public class ImageLoader extends AsyncTask<URI, Integer, Bitmap> {
    private URI imageUri;

    private ImageView imageView;

    private int preferredWidth = 80;
    private int preferredHeight = 80;

    public ImageLoader( URI uri, ImageView imageView, int scaleWidth, int scaleHeight ) {
        this.imageUri = uri;
        this.imageView = imageView;
        this.preferredWidth = scaleWidth;
        this.preferredHeight = scaleHeight;
    }

    public Bitmap doInBackground(URI... params) {
        if( imageUri == null ) return null;
        String url = imageUri.toString();
        if( url.length() == 0 ) return null;
        HttpGet httpGet = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute( httpGet );
        InputStream is = new BufferedInputStream( response.getEntity().getContent() );
        try {
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            if( preferredWidth > 0 && preferredHeight > 0 && bitmap.getWidth() > preferredWidth && bitmap.getHeight() > preferredHeight ) {
                return Bitmap.createScaledBitmap(bitmap, preferredWidth, preferredHeight, false);
            } else {
                return bitmap;
            }
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

    public void onPostExecute(Bitmap drawable ) {
        imageView.setImageBitmap( drawable );
    }
}*/
