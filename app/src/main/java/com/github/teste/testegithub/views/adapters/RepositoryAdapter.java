package com.github.teste.testegithub.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.teste.testegithub.model.Repository;

import java.util.List;

@SuppressWarnings("CanBeFinal")
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryHolder> {
    private List<Repository> repositories;

    public RepositoryAdapter(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new RepositoryHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.setValues(repository);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public void add(Repository repo) {
        repositories.add(repo);
        notifyDataSetChanged();
    }

    public List<Repository> getListRepository() {
        return this.repositories;
    }
}