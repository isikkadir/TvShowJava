package com.info.tvshowjava.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.info.tvshowjava.R;
import com.info.tvshowjava.databinding.TvshowLayoutItemBinding;
import com.info.tvshowjava.listeners.TvShowListener;
import com.info.tvshowjava.models.PopularTvShows;

import java.util.List;

public class PopularTvShowsAdapter extends RecyclerView.Adapter<PopularTvShowsAdapter.PopularTvShowsViewHolder>{

    private List<PopularTvShows> tvShowsList;
    private LayoutInflater inflater;
    private TvShowListener listener;
    public PopularTvShowsAdapter(List<PopularTvShows> TvShowList , TvShowListener listener){
        this.tvShowsList = TvShowList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PopularTvShowsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        TvshowLayoutItemBinding tvshowLayoutItemBinding = DataBindingUtil.inflate(inflater, R.layout.tvshow_layout_item,parent,false);

        return new PopularTvShowsViewHolder(tvshowLayoutItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularTvShowsViewHolder holder, int position) {
        holder.tvshowLayoutItemBinding.setPopularTvShows(tvShowsList.get(position));
        holder.tvshowLayoutItemBinding.getRoot().setOnClickListener(v -> {
            Log.e("MSg" , "Tıklandı" + tvShowsList.get(position).getName());
            listener.onClickTvShow(tvShowsList.get(position));
        });
        holder.tvshowLayoutItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return tvShowsList.size();
    }

    class PopularTvShowsViewHolder extends RecyclerView.ViewHolder{
        private TvshowLayoutItemBinding tvshowLayoutItemBinding;
        public PopularTvShowsViewHolder(@NonNull TvshowLayoutItemBinding tvshowLayoutItemBinding) {
            super(tvshowLayoutItemBinding.getRoot());
            this.tvshowLayoutItemBinding = tvshowLayoutItemBinding;
        }
    }

}
