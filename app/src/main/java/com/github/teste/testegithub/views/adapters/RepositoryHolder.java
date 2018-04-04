package com.github.teste.testegithub.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.teste.testegithub.R;
import com.github.teste.testegithub.model.Repository;
import com.github.teste.testegithub.views.MainActivity;


public class RepositoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context contexto;
    private TextView nome;
    private TextView descricao;
    private TextView nomeCompleto;
    private TextView usuario;
    private ImageView img;
    private TextView fork;
    private TextView stargazer;
    private Repository repository;

    public RepositoryHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.repository_list_item, parent, false));

        contexto = itemView.getContext();

        itemView.setOnClickListener(this);

        nome = (TextView) itemView.findViewById(R.id.text_title);
        descricao = (TextView) itemView.findViewById(R.id.text_body);
        img = (ImageView) itemView.findViewById(R.id.image_author);
        usuario = (TextView) itemView.findViewById(R.id.text_user_name);
        nomeCompleto = (TextView) itemView.findViewById(R.id.text_full_name);
        stargazer = (TextView) itemView.findViewById(R.id.text_num_start);
        fork = (TextView) itemView.findViewById(R.id.text_num_fork);
    }

    protected void setValues(Repository repo) {
        this.repository = repo;

        nome.setText(this.repository.getNome());
        descricao.setText(this.repository.getDescricao());
        nomeCompleto.setText(this.repository.getNomeCompleto());
        usuario.setText(this.repository.getUsuario());
        Glide.with(contexto).load(this.repository.getImg_perfil()).apply(RequestOptions.circleCropTransform()).into(img);
        fork.setText(String.valueOf(this.repository.getFork()));
        stargazer.setText(String.valueOf(this.repository.getStargazer()));
    }

    @Override
    public void onClick(View view) {
        MainActivity.openDetailsRepository(contexto, repository);
    }
}