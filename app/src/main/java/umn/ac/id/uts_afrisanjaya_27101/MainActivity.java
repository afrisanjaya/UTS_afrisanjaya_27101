package umn.ac.id.uts_afrisanjaya_27101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnPageLogin, btnPageProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPageLogin = findViewById(R.id.LoginPage);
        btnPageProfil = findViewById(R.id.ProfilPage);

        btnPageLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentSatu = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intentSatu);
            }
        });
        btnPageProfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentDua = new Intent(MainActivity.this, ProfilSaya.class);
                startActivity(intentDua);
            }
        });
    }
}