package com.github.teste.testegithub.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Repository implements Parcelable {

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
    private String nome;
    private String descricao;
    private String nomeCompleto;
    private String usuario;
    private String img_perfil;
    private int fork;
    private int stargazer;

    //constructor
    public Repository() {
    }

    protected Repository(Parcel in) {
        nome = in.readString();
        descricao = in.readString();
        nomeCompleto = in.readString();
        usuario = in.readString();
        img_perfil = in.readString();
        fork = in.readInt();
        stargazer = in.readInt();
    }

    public static Repository create(Item item) {
        Repository rep = new Repository();
        rep.setUsuario(item.getOwner().getUsuario());
        rep.setImg_perfil(item.getOwner().getImg_perfil());
        rep.setStargazer(item.getStargazer());
        rep.setFork(item.getFork());
        rep.setNomeCompleto(item.getNomeCompleto());
        rep.setDescricao(item.getDescricao());
        rep.setNome(item.getNome());

        return rep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public void setImg_perfil(String img_perfil) {
        this.img_perfil = img_perfil;
    }

    public int getFork() {
        return fork;
    }

    public void setFork(int fork) {
        this.fork = fork;
    }

    public int getStargazer() {
        return stargazer;
    }

    public void setStargazer(int stargazer) {
        this.stargazer = stargazer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeString(descricao);
        parcel.writeString(nomeCompleto);
        parcel.writeString(usuario);
        parcel.writeString(img_perfil);
        parcel.writeInt(fork);
        parcel.writeInt(stargazer);
    }
}
