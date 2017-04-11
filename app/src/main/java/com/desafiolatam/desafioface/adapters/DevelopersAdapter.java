package com.desafiolatam.desafioface.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.desafiolatam.desafioface.background.PostFavorite;
import com.desafiolatam.desafioface.data.DevelopersData;
import com.desafiolatam.desafioface.models.Developer;

import java.util.List;

/**
 * Created by karan_000 on 31-03-2017.
 */

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {

    private List<Developer> developers = new DevelopersData().developers();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Developer developer = developers.get(position);
        TextView textView = (TextView) holder.itemView;
        textView.setText(developer.getEmail());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Developer auxDeveloper = developers.get(holder.getAdapterPosition());
                new PostFavorite().execute(auxDeveloper.getServer_id());
            }
        });

    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
