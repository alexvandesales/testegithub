package com.github.teste.testegithub.model;

import com.google.gson.annotations.SerializedName;

/*
    Criada por: Leonardo
    Classe criada para descrever o Owner
 */
public class Owner {

    @SerializedName("login")
    private String usuario;

    @SerializedName("avatar_url")
    private String img_perfil;

    public String getUsuario() {
        return usuario;
    }

    public String getImg_perfil() {
        return img_perfil;
    }
}
