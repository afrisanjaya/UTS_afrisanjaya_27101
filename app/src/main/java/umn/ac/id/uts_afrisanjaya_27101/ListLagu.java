package umn.ac.id.uts_afrisanjaya_27101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;

public class ListLagu extends AppCompatActivity {
    RecyclerView rvDaftarVideo;
    LaguAdapter mAdapter;
    LinkedList<LaguWibu> daftarVideo = new LinkedList<>();
    Dialog dialog;
    public static final int PERMISSION_READ = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        permission();
        setContentView(R.layout.activity_list_lagu);
        dialog = new Dialog(this);
        Toolbar toolbar = findViewById(R.id.my_toolbar);

        setSupportActionBar(toolbar);
        rvDaftarVideo = (RecyclerView) findViewById(R.id.listlagu);
        //isiDaftarVideo();
        mAdapter = new LaguAdapter(this,daftarVideo);
        rvDaftarVideo.setAdapter(mAdapter);
        rvDaftarVideo.setLayoutManager(new LinearLayoutManager(this));
        openDialog();

    }

    private boolean permission() {
        if(ContextCompat.checkSelfPermission(ListLagu.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(ListLagu.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(ListLagu.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                ActivityCompat.requestPermissions(ListLagu.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        } else {
            setAudio();
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setAudio();
            }
            else {
                ActivityCompat.requestPermissions(ListLagu.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}
                        , 1);
            }
        }
    }
    public void setAudio() {
        ContentResolver contentResolver = getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        Cursor cursor = contentResolver.query(uri, null, null, null, null);

        //looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {

                String judul = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String laguUri = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                daftarVideo.add( new LaguWibu(judul,laguUri));

            } while (cursor.moveToNext());
        }}


    /*public void isiDaftarVideo(){
        daftarVideo.add(new LaguWibu("Jaret","android.resource://"+getPackageName()+"/"+R.raw.wibu_a));
        daftarVideo.add(new LaguWibu("Bawang","android.resource://"+getPackageName()+"/"+R.raw.wibu_b));
        daftarVideo.add(new LaguWibu("Ecchi","android.resource://"+getPackageName()+"/"+R.raw.wibu_c));
        daftarVideo.add(new LaguWibu("Venti","android.resource://"+getPackageName()+"/"+R.raw.wibu_d));
        daftarVideo.add(new LaguWibu("Klee","android.resource://"+getPackageName()+"/"+R.raw.wibu_e));
        daftarVideo.add(new LaguWibu("AkuDapatHutao","android.resource://"+getPackageName()+"/"+R.raw.wibu_f));
        daftarVideo.add(new LaguWibu("Ayaka-chan","android.resource://"+getPackageName()+"/"+R.raw.wibu_g));
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menulist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.profile:
                Intent intentSatu = new Intent(ListLagu.this, ProfilSaya.class);
                startActivity(intentSatu);;
                return true;
            case R.id.logout:
                Intent intentDua = new Intent(ListLagu.this, MainActivity.class);
                startActivity(intentDua);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openDialog() {
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow();
        Button btnOk = dialog.findViewById(R.id.button);
        dialog.show();

        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dialog.dismiss();
            }
        });
    }


    


}