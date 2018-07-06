package com.appnucleus.loginandregisteruser;

import helper.SQLiteHandler;
import helper.SessionManager;

import java.util.HashMap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Main extends Activity {

    private static final String TAG="Activity_Main";

    private static final int ERROR_DIALOG_REQUEST= 9001;

    @Override
    protected void OnCreate(Bundle savedInstanceState){
        super.OnCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isServiceOkay()){
            init();
        }


        if (isServiceOkay()){
            init();
        }



    }
    private void init(){

    }

    public boolean isServiceOkay(){
        Log.d(TAG, "isServiceOkay:checking google service version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Activity_Main.this);
        if (available== ConnectionResult.SUCCESS){
            //APP REQUESTS CAN RUN NOW
            Log.d(TAG, "isServiceOkay: Google Play Service is Working");
            return true;
        }else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error
            Log.d(TAG, "isServiceOkay: an error occured");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Activity_Main.this, available, ERROR_DIALOG_REQUEST);
            Dialog.show();
            
        }else {
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


}