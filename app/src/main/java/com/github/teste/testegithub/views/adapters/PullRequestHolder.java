package com.github.teste.testegithub.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.teste.testegithub.R;
import com.github.teste.testegithub.model.PullItem;

public class PullRequestHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;

    private TextView titulo;
    private TextView body;
    private TextView dataCriacao;
    private TextView login;
    private ImageView img;
    private TextView nomeCompleto;
    private PullItem item;

    public PullRequestHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.pull_requests_list_item, parent, false));

        context = itemView.getContext();

        itemView.setOnClickListener(this);

        login = (TextView) itemView.findViewById(R.id.text_author);
        img = (ImageView) itemView.findViewById(R.id.image_author);
        titulo = (TextView) itemView.findViewById(R.id.text_title);
        dataCriacao = (TextView) itemView.findViewById(R.id.text_created_at);
        body = (TextView) itemView.findViewById(R.id.text_body);
    }

    public void bind(PullItem pull, int opened, int closed) {
        this.item = pull;

        login.setText(this.item.getUsuario());
        Glide.with(context).load(this.item.getImg_perfil()).apply(RequestOptions.circleCropTransform()).into(img);
        titulo.setText(this.item.getTitulo());
        dataCriacao.setText(pull.getDataCriacao());
        body.setText(this.item.getBody());
    }

    @Override
    public void onClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getUrl()));
        context.startActivity(browserIntent);
    }
}
