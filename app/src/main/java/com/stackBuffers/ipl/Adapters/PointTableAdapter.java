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
import com.stackBuffers.ipl.Models.PointTableModel;
import com.stackBuffers.ipl.R;

import java.util.List;

public class PointTableAdapter extends RecyclerView.Adapter<PointTableAdapter.modelViewHolder> {

    List<PointTableModel> list;
    Context context;

    public PointTableAdapter(List<PointTableModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public modelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card, parent, false);
        return new modelViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull modelViewHolder holder, int position) {
        holder.pos.setText(list.get(position).getPosition());
        holder.pld.setText(list.get(position).getMatches());
        holder.w.setText(list.get(position).getWin());
        holder.loss.setText(list.get(position).getLoss());
        holder.nr.setText(list.get(position).getTie());
        holder.p.setText(list.get(position).getPoints());
        Picasso.with(context).load(list.get(position).getImage()).placeholder(R.drawable.cricket).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class modelViewHolder extends RecyclerView.ViewHolder {
        TextView pos, pld, w, loss, nr, p;
        ImageView image;

        public modelViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.pt_team_image);
            pos = itemView.findViewById(R.id.pt_pos);
            pld = itemView.findViewById(R.id.pt_pld);
            w = itemView.findViewById(R.id.pt_w);
            loss = itemView.findViewById(R.id.pt_loss);
            nr = itemView.findViewById(R.id.pt_nr);
            p = itemView.findViewById(R.id.pt_p);
        }
    }
}