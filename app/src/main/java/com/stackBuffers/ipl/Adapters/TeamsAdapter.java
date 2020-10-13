package com.stackBuffers.ipl.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.stackBuffers.ipl.Models.TeamModel;
import com.stackBuffers.ipl.R;
import com.stackBuffers.ipl.TeamDetailActivity;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.modelViewHolder> {

    List<TeamModel> teamslist;
    Context context;

    public TeamsAdapter(List<TeamModel> teamslist, Context context) {
        this.teamslist = teamslist;
        this.context = context;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_teams, parent, false);
        return new modelViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, final int position) {

        holder.teamName.setText(teamslist.get(position).getT_name());

        Picasso.with(context).load(String.valueOf(teamslist.get(position).getT_Image())).placeholder(R.drawable.cricket).into(holder.teamImage);
        holder.btn_teamDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context.getApplicationContext(), TeamDetailActivity.class);
                i.putExtra("image", teamslist.get(position).getT_Image());
                i.putExtra("id", teamslist.get(position).getId());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return teamslist.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder {
        ImageView teamImage;
        TextView teamName;
        RelativeLayout btn_teamDetail;


        public modelViewHolder(@NonNull View itemView) {
            super(itemView);

            teamImage = itemView.findViewById(R.id.item_Team_img);
            teamName = itemView.findViewById(R.id.item_Team_name);
            btn_teamDetail = itemView.findViewById(R.id.relativelayout_item_team);

        }
    }
}
