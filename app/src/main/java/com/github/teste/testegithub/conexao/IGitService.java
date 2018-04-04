package com.github.teste.testegithub.conexao;

import java.util.List;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.github.teste.testegithub.model.GitResponse;
import com.github.teste.testegithub.model.Pull;



public interface IGitService {

    @GET("/repos/{user}/{name}/pulls?state=all")
    Single<List<Pull>> getPullRepository(@Path("user") String user, @Path("name") String name);


    @GET("/search/repositories?q=language:Java&sort=stars")
    Single<GitResponse> getRemotesRepository(@Query("page") int page_number);
}
