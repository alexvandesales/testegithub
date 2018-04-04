package com.github.teste.testegithub.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.teste.testegithub.model.PullItem;

import java.util.List;



public class PullRequestAdapter extends RecyclerView.Adapter<PullRequestHolder> {

    private final List<PullItem> pull_items;
    private int opened = 0;
    private int closed = 0;

    public PullRequestAdapter(List<PullItem> repositories) {
        this.pull_items = repositories;
    }

    @Override
    public PullRequestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new PullRequestHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(PullRequestHolder holder, int position) {

        PullItem pullItem = pull_items.get(position);
        holder.bind(pullItem, opened, closed);

    }

    @Override
    public int getItemCount() {
        return pull_items.size();
    }

    public void add(PullItem items) {
        if (items.getEstado().equals("open")) {
            opened++;
        } else if (items.getEstado().equals("closed")) {
            closed++;
        }

        pull_items.add(items);
        notifyDataSetChanged();
    }

    public List<PullItem> getPulls() {
        return this.pull_items;
    }
}
