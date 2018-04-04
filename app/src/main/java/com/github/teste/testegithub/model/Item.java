package com.github.teste.testegithub.model;

import com.google.gson.annotations.SerializedName;

/*
    Criada por: Leonardo
    Classe craida com o objetivo de descrever os items do repositorio GIT
 */

public class Item {

    @SerializedName("name")
    private String nome;

    @SerializedName("description")
    private String descricao;

    @SerializedName("full_name")
    private String nomeCompleto;

    @SerializedName("forks")
    private int fork;

    @SerializedName("stargazers_count")
    private int stargazer;

    @SerializedName("owner")
    private Owner owner;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public int getFork() {
        return fork;
    }

    public int getStargazer() {
        return stargazer;
    }

    public Owner getOwner() {
        return owner;
    }
}
