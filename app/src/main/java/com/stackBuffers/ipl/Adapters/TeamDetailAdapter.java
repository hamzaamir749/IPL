package com.stackBuffers.ipl.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stackBuffers.ipl.Models.TeamDetailModel;
import com.stackBuffers.ipl.R;

import java.util.List;

public class TeamDetailAdapter extends RecyclerView.Adapter<TeamDetailAdapter.modelViewHolder> {

    List<TeamDetailModel> list;
    Context context;

    public TeamDetailAdapter(List<TeamDetailModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team_detail, parent, false);
        return new modelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {
        holder.name.setText(list.get(position).getPlayername());
        if (list.get(position).getIsforginer().toLowerCase().equals("yes")) {
            holder.tdforginer.setVisibility(View.VISIBLE);
        }
        if (list.get(position).getType().toLowerCase().equals("batsman")) {
            holder.tdbatsman.setVisibility(View.VISIBLE);
        } else if (list.get(position).getType().toLowerCase().equals("keeper")) {
            holder.tdkepper.setVisibility(View.VISIBLE);
        } else if (list.get(position).getType().toLowerCase().equals("baller")) {
            holder.tdballer.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class modelViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView tdforginer, tdbatsman, tdballer, tdkepper;

        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.td_name);
            tdforginer=itemView.findViewById(R.id.td_forigner);
            tdbatsman=itemView.findViewById(R.id.td_batsman);
            tdballer=itemView.findViewById(R.id.td_baller);
            tdkepper=itemView.findViewById(R.id.td_keeper);
        }
    }
}
