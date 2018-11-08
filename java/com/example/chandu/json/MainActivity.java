package com.example.chandu.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
TextView t1;
String jstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        t1=(TextView) findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request=new StringRequest(Request.Method.POST, "http://192.168.43.139/ras5/json.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        jstring=response;
                        JSONObject jb,jb2;
                        JSONArray ja;
                        num nu[];
                        try
                        {
                           jb =new JSONObject(jstring);
                           ja=jb.getJSONArray("server_response");
                           int c=0;
                           String k="";
                           nu=new num[ja.length()];

                           while(c<ja.length())
                           {
                               jb2=ja.getJSONObject(c);
                               nu[c]=new num(jb2.getInt("num1"),jb2.getInt("num2"));

                           k=k+"num1="+nu[c].n1+"\n num2="+nu[c].n2+"\n";
                           c++;
                           }
                            t1.setText(k);

                        }
                        catch (Exception e)
                        {

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(request);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
