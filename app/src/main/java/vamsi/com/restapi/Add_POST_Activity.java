package vamsi.com.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Add_POST_Activity extends AppCompatActivity {

    EditText fname,lname;
    TextView res;
    Button submit;
    private static final String url_data="https://reqres.in/api/users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        fname=(EditText)findViewById(R.id.fnameet);
        lname=(EditText)findViewById(R.id.lnameet);
        res=(TextView)findViewById(R.id.responsetv);
        submit=(Button)findViewById(R.id.submitbtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="{\n" +
                        "\"first_name\": \" " + fname.getText().toString() +"\",\n" +
                        "\"last_name\": \" " + lname.getText().toString() +"\"\n" +
                        "}";
                submitPost(data);



            }
        });
    }
    private void submitPost(String data){

        final String savedata=data;
        RequestQueue postrequestqueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest poststringRequest=new StringRequest(Request.Method.POST, url_data, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //JSONObject postobj= null;
                try {
                    JSONObject postobj = new JSONObject(response);
                    res.setText(postobj.toString());

                    Toast.makeText(getApplicationContext(),postobj.toString(),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    //e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Server error",Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return savedata == null ? null : savedata.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    //Log.v("Unsupported Encoding while trying to get the bytes", data);
                    return null;
                }
            }

        };
        postrequestqueue.add(poststringRequest);

    }
}
