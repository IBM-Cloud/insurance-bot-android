package com.ibm.org.vidyasagar.insurance_mobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ibm.org.vidyasagar.adapters.ChatAdapter;
import com.ibm.org.vidyasagar.models.ChatResponse;
import com.ibm.org.vidyasagar.models.Message;
import com.ibm.org.vidyasagar.utils.Check;
import com.ibm.org.vidyasagar.utils.PostOkHttp;


import java.util.ArrayList;


/**
 * Created by Vidyasagar MSC on 27/12/16.
 */

public class ChatActivity  extends AppCompatActivity {
    private static final String TAG = "ChatActivity";

    private RecyclerView recyclerView;
    private ChatAdapter mAdapter;
    private ArrayList messageArrayList;
    private EditText inputMessage;
    private ImageButton btnSend;
    private Bundle bundle;
    private String cookie;
    private com.ibm.org.vidyasagar.models.Context context;
    private boolean initialRequest;
    private Context mContext;
    private Check genericCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatwithana_custom);

        inputMessage = (EditText) findViewById(R.id.message);
        btnSend = (ImageButton) findViewById(R.id.btn_send);

        //Setting the ActionBar.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chat with Ana");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        bundle = getIntent().getExtras();
        cookie = bundle.getString("cookie");


        messageArrayList = new ArrayList<>();
        mAdapter = new ChatAdapter(messageArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        this.inputMessage.setText("");
        this.initialRequest = true;
        sendMessage();

        genericCheck = new Check(this);
        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Check Internet Connection
                if(genericCheck.checkInternetConnection()) {
                    sendMessage();
                }
            }
        });
    };


    // Send a message to Watson Conversation Service
    private void sendMessage() {
        final String requestMessage = this.inputMessage.getText().toString().trim();
        final boolean initialrequest = this.initialRequest;
        if(! this.initialRequest && genericCheck.checkText(requestMessage)) {
            Message inputMessage = new Message();
            inputMessage.setMessage(requestMessage);
            inputMessage.setId("1");
            messageArrayList.add(inputMessage);
        }
        else if (this.initialRequest)
        {
            Message inputMessage = new Message();
            inputMessage.setMessage(requestMessage);
            inputMessage.setId("100");

        }
        else {
            Toast.makeText(this, "Enter a request", Toast.LENGTH_LONG).show();
            this.initialRequest = false;
        }

        mAdapter.notifyDataSetChanged();

        Thread thread = new Thread(new Runnable(){
            public void run() {
                try {
                    String json;
                    String response = "";

                    PostOkHttp okHttpPost = new PostOkHttp();
                    
                    //One more check as this is a new thread
                    json = okHttpPost.textJson(requestMessage, context,initialrequest);
                    Log.i(TAG,"JSON Request"+json);

                    //Pull the url and other API routes.
                    mContext = getApplicationContext();
                    String hosted_url = mContext.getString(R.string.hosted_url);
                    String ana_route = mContext.getString(R.string.ana);

                    response = okHttpPost.post(hosted_url+ana_route, json, cookie);
                    Log.i(TAG,"JSON Response"+response);

                    //Gson Initialization for Json to Java Object and Vice Versa
                    Gson gson =new Gson();

                    if(genericCheck.checkText(response)) {
                        ChatResponse gsonOutput = gson.fromJson(response, ChatResponse.class);
                        Message outMessage=new Message();
                        //Watson Conversation Service Context to be added to the following request.
                        if (gsonOutput.getContext() != null) {
                            context =  new com.ibm.org.vidyasagar.models.Context();
                            context = gsonOutput.getContext();
                            Log.i(TAG,gson.toJson(context));
                        }

                        final String outputmessage = gsonOutput.getOutput().getText();
                        outMessage.setMessage(outputmessage);
                        outMessage.setId("2");
                        messageArrayList.add(outMessage);

                    }

                    runOnUiThread(new Runnable() {
                        public void run() {
                            mAdapter.notifyDataSetChanged();
                            if (mAdapter.getItemCount() > 1) {
                                recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, mAdapter.getItemCount()-1);

                            }

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        this.inputMessage.setText("");
        this.initialRequest=false;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), LandingActivity.class);
        myIntent.putExtras(bundle);
        startActivityForResult(myIntent, 0);
        return true;

    }


}

