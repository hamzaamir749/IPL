package com.stackBuffers.ipl.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.stackBuffers.ipl.Models.RecentMatchesModel;
import com.stackBuffers.ipl.R;

import java.util.List;

public class RecentMatchesAdapter extends RecyclerView.Adapter<RecentMatchesAdapter.modelViewHolder> {

    private List<RecentMatchesModel> recentMatcheslist;
    Context context;

    public RecentMatchesAdapter(List<RecentMatchesModel> recentMatcheslist, Context context) {
        this.recentMatcheslist = recentMatcheslist;
        this.context = context;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recentmatches, parent, false);
        return new modelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {

        holder.rMatchNum.setText(recentMatcheslist.get(position).getrMatchNum());
        holder.rStatusResult.setText(recentMatcheslist.get(position).getrStatusResult());
        Picasso.with(context).load(String.valueOf(recentMatcheslist.get(position).getrPicTeamA())).placeholder(R.drawable.cricket).into(holder.rPicTeamA);
        Picasso.with(context).load(String.valueOf(recentMatcheslist.get(position).getrPicTeamB())).placeholder(R.drawable.cricket).into(holder.rPicTeamB);
    }

    @Override
    public int getItemCount() {
        return recentMatcheslist.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder {

        TextView rMatchNum, rStatusResult;
        ImageView rPicTeamA, rPicTeamB;

        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            rMatchNum = itemView.findViewById(R.id.recent_match_num);
            rStatusResult = itemView.findViewById(R.id.recent_txtView_StatusResult);
            rPicTeamA = itemView.findViewById(R.id.recent_pic_TeamA);
            rPicTeamB = itemView.findViewById(R.id.recent_pic_TeamB);

        }
    }
}
