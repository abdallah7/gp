package com.example.abdallah.smart_city;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class update_profile extends AppCompatActivity implements View.OnClickListener
{


    private EditText f_name, l_name, email, phone, city;
    private Button update ;
    private String blockCharacterSet = "~#^|$%&*!:;.,><[]{}%'/";

    private InputFilter filter = new InputFilter() {

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

            if (source != null && blockCharacterSet.contains(("" + source))) {
                return "";
            }
            return null;
        }
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        update = (Button) findViewById(R.id.button_update_personal_info);
        //Toast.makeText(this , "test .", Toast.LENGTH_SHORT ).show();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        update();
    }

    public void update() {
        f_name = (EditText) findViewById(R.id.edit_user_fname);
        l_name = (EditText) findViewById(R.id.edit_user_lname);
        email = (EditText) findViewById(R.id.edit_user_email);
        phone = (EditText) findViewById(R.id.edit_user_phone);
        city = (EditText) findViewById(R.id.edit_user_city);
        f_name.setFilters(new InputFilter[]{filter});
        l_name.setFilters(new InputFilter[]{filter});
        email.setFilters(new InputFilter[]{filter});
        city.setFilters(new InputFilter[]{filter});


        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_SHORT;
                        if (f_name.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your First Name Correctly .", duration).show();
                        } else if (l_name.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Last Name Correctly .", duration).show();
                        } else if (email.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Email .", duration).show();
                        } else if (phone.getText().toString().trim().length() == 0) {
                            Toast.makeText(context, "Please Enter Your Phone .", duration).show();
                        }


                    }
                }
        );
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "update_profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.abdallah.smart_city/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "update_profile Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.abdallah.smart_city/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}







