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
import com.stackBuffers.ipl.Models.SechduleModel;
import com.stackBuffers.ipl.R;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.modelViewHolder> {

    private List<SechduleModel> sechdulelist;
    Context context;

    public ScheduleAdapter(List<SechduleModel> sechdulelist, Context context) {
        this.sechdulelist = sechdulelist;
        this.context = context;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_schedule, parent, false);
        return new modelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {

        holder.sMatchNum.setText(sechdulelist.get(position).getsMatchNum());
        holder.sNameStadium.setText(sechdulelist.get(position).getS_StadiumName());
        holder.sDate.setText(sechdulelist.get(position).getsDate());
        holder.sTime.setText(sechdulelist.get(position).getsTime());
        Picasso.with(context).load(String.valueOf(sechdulelist.get(position).getS_imgTeamA())).placeholder(R.drawable.cricket).into(holder.sTeamA);
        Picasso.with(context).load(String.valueOf(sechdulelist.get(position).getS_imgTeamB())).placeholder(R.drawable.cricket).into(holder.sTeamB);


    }

    @Override
    public int getItemCount() {
        return sechdulelist.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder {

        TextView sMatchNum, sDate, sTime, sNameStadium;
        ImageView sTeamA, sTeamB;

        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            sMatchNum = itemView.findViewById(R.id.item_schedule_matchNum);
            sDate = itemView.findViewById(R.id.txtView_schedule_date);
            sTime = itemView.findViewById(R.id.txtView_schedule_time);
            sNameStadium = itemView.findViewById(R.id.txtView_schedule_stadiumName);
            sTeamA = itemView.findViewById(R.id.item_schedule_pic_TeamA);
            sTeamB = itemView.findViewById(R.id.item_schedule_pic_TeamB);
        }
    }
}
