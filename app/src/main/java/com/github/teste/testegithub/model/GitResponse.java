package com.github.teste.testegithub.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/*
    Criada por: Leonardo
    Classe criada com o objetivo de recuperar resultados do repositorio GIT
 */
public class GitResponse {

    @SerializedName("items")
    private List<Item> items;

    @SerializedName("total_count")
    private Integer total;

    @SerializedName("incomplete_results")
    private Boolean incomplete;

    public List<Item> getItems() {
        return items;
    }
}
