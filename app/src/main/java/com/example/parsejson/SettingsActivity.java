package com.example.parsejson;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Owner on 3/22/2018.
 */

public class SettingsActivity extends Activity {
    private String realLink;
    private String brokenLink;
    private String[] list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings_layout);
        list = getResources().getStringArray(R.array.JSON_URL_NAME);
        realLink = list[0];
        brokenLink = list[1];
    }
    public void doClick(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //lll
            }
        });
     alert.show();
    }

}
