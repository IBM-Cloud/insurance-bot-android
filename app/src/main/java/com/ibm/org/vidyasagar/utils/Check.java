package com.ibm.org.vidyasagar.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Vidyasagar Machupalli on 02/01/17.
 */

public class Check {
    private Context _context;

    public Check(Context context){
        this._context = context;
    }

    public boolean checkInternetConnection() {
        // get Connectivity Manager object to check connection
        ConnectivityManager cm =
                (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        // Check for network connections
        if (isConnected){
            return true;
        }
        else {
            Toast.makeText(this._context, " No Internet Connection available ", Toast.LENGTH_LONG).show();
            return false;
        }

    }


    public boolean checkText(String text)
    {
        if(text != null && !text.isEmpty() && !text.equals("null"))
            return true;

        else
            return false;
    }
}
