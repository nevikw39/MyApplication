package tk.kevinwneg.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsr, editTextPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsr = (EditText)findViewById(R.id.editTextUsr);
        editTextPwd = (EditText)findViewById(R.id.editTextPwd);
    }
    public void buttonOnClick(View view)
    {
        Button button = (Button) view;
        Toast toast = Toast.makeText(this, "學號：" + editTextUsr.getText().toString().trim() + "\n密碼：" + editTextPwd.getText().toString().trim(), Toast.LENGTH_SHORT);
        toast.show();
    }
}
