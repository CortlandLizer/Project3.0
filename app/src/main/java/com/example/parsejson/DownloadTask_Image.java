package com.example.parsejson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by matt on 3/25/18.
 */

public class DownloadTask_Image extends AsyncTask<String,Void, Bitmap> {
    private static final String     TAG = "DownloadTask";
    private static final int        TIMEOUT = 1000;    // 1 second
    private String                  myQuery = "";
    protected int                   statusCode = 0;
    protected String                myURL;

    MainActivity myActivity;


    DownloadTask_Image(MainActivity activity) {
        attach(activity);
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        myActivity.processBitmap(bitmap);

    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        String param = strings[0];

        try {
            URL url = new URL(param);

            // this does no network IO
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // can further configure connection before getting data
            // cannot do this after connected
            connection.setRequestMethod("GET");
            connection.setReadTimeout(TIMEOUT);
            connection.setConnectTimeout(TIMEOUT);
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            // wrap in finally so that stream bis is sure to close
            // and we disconnect the HttpURLConnection
            InputStream is = null;
            Bitmap bitmap = null;
            try {

                // this opens a connection, then sends GET & headers
                connection.connect();

                // lets see what we got make sure its one of
                // the 200 codes (there can be 100 of them
                // http_status / 100 != 2 does integer div any 200 code will = 2
                statusCode = connection.getResponseCode();

                //setStatusCode(statusCode);
                if (statusCode / 100 != 2) {
                    Log.e(TAG, "Error-connection.getResponseCode returned "
                            + Integer.toString(statusCode));
                    return null;
                }

                is = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(is);
                bitmap  = Bitmap.createScaledBitmap(bitmap,600,600, true);
                return bitmap;
            } finally {
                // close resource no matter what exception occurs
                is.close();
                connection.disconnect();
            }
        } catch (Exception exc) {
            return null;
        }

    }
    /**
     * important do not hold a reference so garbage collector can grab old
     * defunct dying activity
     */
    void detach() {
        myActivity = null;
    }

    /**
     * @param activity
     *            grab a reference to this activity, mindful of leaks
     */
    void attach(MainActivity activity) {
        this.myActivity = activity;
    }
}
