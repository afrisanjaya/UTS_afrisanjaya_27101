package umn.ac.id.uts_afrisanjaya_27101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PuterLagu extends AppCompatActivity {
    TextView judul;
    ImageButton prev,next,playTIpause;
    SeekBar PahaUeno;
    MediaPlayer Hutao;
    ArrayList<LaguWibu> Ganyu  = new ArrayList();
    int mPosisi;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puter_lagu);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        PahaUeno = (SeekBar) this.findViewById(R.id.PutihMulus);
        Ganyu = (ArrayList<LaguWibu>) bundle.getSerializable("PahaLisa");
        mPosisi = (int) bundle.getSerializable("RajaLele");
        prev = (ImageButton) this.findViewById(R.id.prev);
        next = (ImageButton) this.findViewById(R.id.next);
        playTIpause = (ImageButton) this.findViewById(R.id.play);
        judul = (TextView) this.findViewById(R.id.judul);
        
        Qiqi();

        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPosisi --;
                if(mPosisi<0){
                    mPosisi++;
                }else{
                    Qiqi();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mPosisi++;
                if(mPosisi>=Ganyu.size()){
                    mPosisi--;
                }else{
                    Qiqi();
                }
            }
        });
        playTIpause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(Hutao.isPlaying()){
                    Hutao.pause();
                    playTIpause.setImageResource(R.drawable.play);
                } else {
                    Hutao.start();
                    playTIpause.setImageResource(R.drawable.pause);
                }
            }
        });

        PahaUeno.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar PahaUeno, int progress, boolean fromUser){
                if(fromUser){
                    Hutao.seekTo(progress);
                    PahaUeno.setProgress(progress);
                }

            }
            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (Hutao != null) {
            Hutao.pause();
            if (isFinishing()) {
                Hutao.stop();
                Hutao.release();
            }
        }
    }


    public void Qiqi(){
        try{
            Hutao.release();
        } catch (Exception e){ };
        Log.i("kuntul",Ganyu.get(mPosisi).getLaguURI());
        Hutao = Hutao.create(this,Uri.parse(Ganyu.get(mPosisi).getLaguURI()));
        playTIpause.setImageResource(R.drawable.pause);
        judul.setText(Ganyu.get(mPosisi).getJudul());
        PahaUeno.setMax(Hutao.getDuration());
        Hutao.start();
        updateSeebar();
    }

    private void updateSeebar() {
        int currPos = Hutao.getCurrentPosition();
        PahaUeno.setProgress(currPos);

        runnable = new Runnable(){
            @Override
            public void run(){
                updateSeebar();
            }
        };
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(Hutao.isPlaying()){
                    Hutao.stop();
                }
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (Hutao!=null){
            Hutao.release();
        }
    }
}