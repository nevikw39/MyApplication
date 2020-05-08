package tk.kevinwneg.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsr, editTextPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsr = (EditText) findViewById(R.id.editTextUsr);
        editTextPwd = (EditText) findViewById(R.id.editTextPwd);
    }

    public void buttonOnClick(View view) {
        Button button = (Button) view;
        Toast toast = Toast.makeText(this, "學號：" + editTextUsr.getText().toString().trim() + "\n密碼：" + editTextPwd.getText().toString().trim(), Toast.LENGTH_SHORT);
        toast.show();
        CookieManager cm = new CookieManager();
        CookieHandler.setDefault(cm);
        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest login = new StringRequest(Request.Method.POST, "https://tcfsh.feverpass.life/login", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Login", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("Login", error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> m = new HashMap<String, String>();
                m.put("username", editTextUsr.getText().toString().trim());
                m.put("password", editTextPwd.getText().toString().trim());
                return m;
            }
        };
        rq.add(login);
        StringRequest temp = new StringRequest(Request.Method.POST, "https://tcfsh.feverpass.life/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Temp", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("Temp", error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> m = new HashMap<String, String>();
                m.put("temperature", "36.0");
                m.put("type", "2");
                return m;
            }
        };
        rq.add(temp);
    }
}
