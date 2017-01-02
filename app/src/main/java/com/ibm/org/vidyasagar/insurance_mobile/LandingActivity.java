package com.ibm.org.vidyasagar.insurance_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibm.org.vidyasagar.adapters.MenuItemsAdapter;
import com.ibm.org.vidyasagar.utils.CircleTransform;
import com.ibm.org.vidyasagar.utils.MD5Util;
import com.squareup.picasso.Picasso;

/**
 * Created by Vidyasagar MSC on 27/12/16.
 */

public class LandingActivity extends AppCompatActivity {
    private static final String TAG = "LandingActivity";

    ImageView imageView;
    TextView  personName;
    TextView  id;
    String email;
    String firstName;
    String lastName;
    String cookie;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        imageView =(ImageView) findViewById(R.id.person_photo);
        personName = (TextView) findViewById(R.id.person_name);
        id = (TextView) findViewById(R.id.id);

        //Get the bundle content
        bundle = getIntent().getExtras();

        //Extract the data from bundle
       if(bundle!=null) {
           email = bundle.getString("email");
           firstName = bundle.getString("fname");
           lastName = bundle.getString("lname");
           cookie = bundle.getString("cookie");

           //Gravatar url and email conversion to Hash
           String hash = MD5Util.md5Hex(email);
           String url = "https://www.gravatar.com/avatar/" + hash + "?s=200&d=mm";
           Log.d(TAG,"gravatarUrl"+ url);

           //Setting the values of person profile
           Picasso.with(getApplicationContext()).load(url).transform(new CircleTransform()).into(imageView);
           personName.setText(firstName + " " + lastName);
           id.setText("ID: " + email);
       }

        /**
         * Acquiring and Setting gridview parameters.
         */
        GridView gridView = (GridView)findViewById(R.id.gridview);
        MenuItemsAdapter menuItemsAdapter = new MenuItemsAdapter(this);
        gridView.setAdapter(menuItemsAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position)
                {
                    // Setting ChatActivity to Health in the gridview
                    case 1:
                    {
                        Intent intent = new Intent(LandingActivity.this,ChatActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("email",email);
                        bundle.putString("fname",firstName);
                        bundle.putString("lname",lastName);
                        bundle.putString("cookie",cookie);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        break;
                    }
                    default:
                        break;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Set logout action
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


    /** Called when the user clicks the "ASK Question" button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("fname",firstName);
        bundle.putString("lname",lastName);
        bundle.putString("cookie",cookie);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
