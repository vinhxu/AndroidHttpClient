package com.example.vinhxu.httpclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private static Button button_get;
    private static Button button_post;
    private static Button button_put;
    private static Button button_delete;
    private static Button button_patch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set Scroll to textView
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        //add RESTful methods
        onClick_buttonGET();
        onClick_buttonPOST();
        onClick_buttonPUT();
        onClick_buttonDELETE();
        onClick_buttonPATCH();
    }

    public void onClick_buttonGET() {
        button_get = (Button)findViewById(R.id.button_get);
        button_get.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RequestPackage p = new RequestPackage();
                        p.setMethod("GET");
                        //test GET request on http://httpbin.org/get
                        //p.setUri("http://httpbin.org/get");
                        //p.setParam("shallow", "true");
                        p.setUri("https://fiery-torch-8721.firebaseio.com/.json");


                        HttpClientTask task = new HttpClientTask();
                        task.execute(p);
                    }
                }
        );
    }

    public void onClick_buttonPOST() {
        button_post = (Button)findViewById(R.id.button_post);
        button_post.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RequestPackage p = new RequestPackage();
                        p.setMethod("POST");
                        p.setUri("https://fiery-torch-8721.firebaseio.com/test.json");
                        //p.setUri("http://httpbin.org/post");
                        p.setParam("param1", "value1");
                        p.setParam("param2", "value2");

                        HttpClientTask task = new HttpClientTask();
                        task.execute(p);
                    }
                }
        );
    }

    public void onClick_buttonPUT() {
        button_put = (Button)findViewById(R.id.button_put);
        button_put.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RequestPackage p = new RequestPackage();
                        p.setMethod("PUT");
                        p.setUri("https://fiery-torch-8721.firebaseio.com/put.json");

                        p.setParam("hello", "world");
                        p.setParam("vinhxu", "true");

                        HttpClientTask task = new HttpClientTask();
                        task.execute(p);
                    }
                }
        );
    }

    public void onClick_buttonDELETE() {
        button_delete = (Button)findViewById(R.id.button_delete);
        button_delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RequestPackage p = new RequestPackage();
                        p.setMethod("DELETE");
                        p.setUri("https://fiery-torch-8721.firebaseio.com/put.json");

                        HttpClientTask task = new HttpClientTask();
                        task.execute(p);
                    }
                }
        );
    }

    public void onClick_buttonPATCH() {
        button_patch = (Button)findViewById(R.id.button_patch);
        button_patch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RequestPackage p = new RequestPackage();
                        p.setMethod("PATCH");
                        p.setUri("https://fiery-torch-8721.firebaseio.com/put.json");

                        p.setParam("human", "err");
                        p.setParam("devine", "merciful");

                        HttpClientTask task = new HttpClientTask();
                        task.execute(p);
                    }
                }
        );
    }

    private class HttpClientTask extends AsyncTask<RequestPackage, String, String> {

        @Override
        protected String doInBackground(RequestPackage... params) {
            String content =  HttpManager.getData(params[0]);
            //content = "[" + content + "]";
            try {

                //JSONArray ar = new JSONArray(content);
                //JSONObject obj = ar.getJSONObject(0);

                JSONObject obj = new JSONObject(content);
                JSONArray ar = obj.names();
                return ar.getString(3);

                /*
                List<UserProfile> userProfileList = new ArrayList<>();
                for (int i = 0; i < ar.length(); i++) {
                    JSONObject obj = ar.getJSONObject(i);
                    UserProfile newUser = new UserProfile();

                    newUser.setStartWeight(obj.getDouble("startWeight"));
                    newUser.setDaysToTarget(obj.getInt("targetDays"));
                    newUser.setTargetWeight(obj.getDouble("targetWeight"));

                    userProfileList.add(newUser);
                }

                JSONObject info = new JSONObject(obj.getString("vx"));
                return info.getString("targetWeight");
                */

            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(s);
        }


    }

}
