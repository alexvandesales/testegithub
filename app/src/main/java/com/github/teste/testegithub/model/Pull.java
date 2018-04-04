package com.github.teste.testegithub.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pull {

    private User usuario;
    private Date dataCriacao;
    private String url;
    private String estado;
    private String titulo;
    private String body;

    public User getUsuario() {
        return usuario;
    }
    public String getDataCriacao() {
        Format data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return data.format(dataCriacao);
    }
    public String getUrl() { return url; }
    public String getEstado() {
        return estado;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getBody() {
        return body;
    }



}
