package umn.ac.id.uts_afrisanjaya_27101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPage extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        username = (EditText) this.findViewById(R.id.Username);
        password = (EditText) this.findViewById(R.id.Password);
        login = (Button) this.findViewById(R.id.button2);


        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if((username.getText().toString().equals("uasmobile"))&&(password.getText().toString().equals("uasmobilegenap"))){
                    Intent intentSatu = new Intent(LoginPage.this, ListLagu.class);
                    startActivity(intentSatu);
                }
            }
        });
    }
}