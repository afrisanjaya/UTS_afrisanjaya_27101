package umn.ac.id.uts_afrisanjaya_27101;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.LinkedList;

public class ListLagu extends AppCompatActivity {
    RecyclerView rvDaftarVideo;
    LaguAdapter mAdapter;
    LinkedList<LaguWibu> daftarVideo = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lagu);
        rvDaftarVideo = (RecyclerView) findViewById(R.id.listlagu);
        isiDaftarVideo();
        mAdapter = new LaguAdapter(this,daftarVideo);
        rvDaftarVideo.setAdapter(mAdapter);
        rvDaftarVideo.setLayoutManager(new LinearLayoutManager(this));

    }
    public void isiDaftarVideo(){
        daftarVideo.add(new LaguWibu("Jaret","android.resource://"+getPackageName()+"/"+R.raw.wibu_a));
        daftarVideo.add(new LaguWibu("Bawang","android.resource://"+getPackageName()+"/"+R.raw.wibu_b));
        daftarVideo.add(new LaguWibu("Ecchi","android.resource://"+getPackageName()+"/"+R.raw.wibu_c));
        daftarVideo.add(new LaguWibu("Venti","android.resource://"+getPackageName()+"/"+R.raw.wibu_d));
        daftarVideo.add(new LaguWibu("Klee","android.resource://"+getPackageName()+"/"+R.raw.wibu_e));
        daftarVideo.add(new LaguWibu("AkuDapatHutao","android.resource://"+getPackageName()+"/"+R.raw.wibu_f));
        daftarVideo.add(new LaguWibu("Ayaka-chan","android.resource://"+getPackageName()+"/"+R.raw.wibu_g));
    }
    


}