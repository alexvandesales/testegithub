package com.github.teste.testegithub.model;

import android.os.Parcel;
import android.os.Parcelable;

public class PullItem implements  Parcelable{

    @SuppressWarnings("unused")
    private static final Parcelable.Creator<PullItem> CREATOR = new Parcelable.Creator<PullItem>() {
        @Override
        public PullItem createFromParcel(Parcel in) {
            return new PullItem(in);
        }

        @Override
        public PullItem[] newArray(int size) {
            return new PullItem[size];
        }
    };

    private String usuario;
    private String dataCriacao;
    private String url;
    private String estado;
    private String titulo;
    private String body;
    private String img_perfil;


    //constructor
    public PullItem() {
    }


    protected PullItem(Parcel in) {
        this.setUrl(in.readString());
        this.setEstado(in.readString());
        this.setTitulo(in.readString());
        this.setBody(in.readString());
        this.setDataCriacao(in.readString());
        this.setUsuario(in.readString());
        this.setImg_Perfil(in.readString());
    }

    public static Parcelable.Creator<PullItem> getCREATOR() {
        return CREATOR;
    }

    public static PullItem create(Pull item) {
        PullItem pull = new PullItem();
        pull.setImg_Perfil(item.getUsuario().getImg_Perfil());
        pull.setBody(item.getBody());
        pull.setDataCriacao(item.getDataCriacao());
        pull.setUrl(item.getUrl());
        pull.setUsuario(item.getUsuario().getUsuario());
        pull.setTitulo(item.getTitulo());
        pull.setEstado(item.getEstado());

        return pull;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getImg_perfil() {
        return img_perfil;
    }

    public void setImg_Perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getUrl());
        dest.writeString(getEstado());
        dest.writeString(getTitulo());
        dest.writeString(getBody());
        dest.writeString(getDataCriacao());
        dest.writeString(getUsuario());
        dest.writeString(getImg_perfil());
    }
}
