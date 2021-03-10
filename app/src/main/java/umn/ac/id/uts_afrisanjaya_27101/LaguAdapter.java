package umn.ac.id.uts_afrisanjaya_27101;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class LaguAdapter extends RecyclerView.Adapter<LaguAdapter.ItemLaguViewHolder>{
    private LinkedList<LaguWibu> mLaguWibus;
    private LayoutInflater mInflater;
    private Context mContext;

    public LaguAdapter(Context context,LinkedList<LaguWibu> daftarVideo){
        this.mContext = context;
        this.mLaguWibus =daftarVideo;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemLaguViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.layout_lagu,parent,false);
        return new ItemLaguViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LaguAdapter.ItemLaguViewHolder holder, int position){
        LaguWibu mSumberLaguWibu = mLaguWibus.get(position);
        holder.JudulLagu.setText(mSumberLaguWibu.getJudul());
    }
    @Override
    public int getItemCount() {
        return mLaguWibus.size();
    }

    public class ItemLaguViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView JudulLagu;
        private LaguAdapter mAdapter;
        private int mPosisi;
        private LaguWibu mSumberWibu;
        public ItemLaguViewHolder(@NonNull View itemView, LaguAdapter adapter){
            super(itemView);
            mAdapter = adapter;
            JudulLagu = (TextView) itemView.findViewById(R.id.judullagu);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            mPosisi = getLayoutPosition();
            //mSumberWibu = mLaguWibus.get(mPosisi);
            Intent detilInten = new Intent(mContext,PuterLagu.class);
            Bundle bundle = new Bundle();
            Log.i("kuntul2",mLaguWibus.get(mPosisi).getLaguURI());
            bundle.putSerializable("PahaLisa", mLaguWibus);
            bundle.putSerializable("RajaLele",mPosisi);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }

    }
}
