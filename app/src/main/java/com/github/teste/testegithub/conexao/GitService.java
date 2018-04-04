package com.github.teste.testegithub.conexao;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.github.teste.testegithub.BuildConfig;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitService {

    private final HttpLoggingInterceptor intercept =
              new HttpLoggingInterceptor().setLevel((BuildConfig.DEBUG) ?
                  HttpLoggingInterceptor.Level.BODY :
                  HttpLoggingInterceptor.Level.NONE);

    private final OkHttpClient cliente =
              new OkHttpClient.Builder()
                 .readTimeout(60, TimeUnit.SECONDS)
                 .addInterceptor(intercept).build();

    private final Retrofit retrofit =
            new Retrofit.Builder().client(cliente)
               .baseUrl("https://api.github.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

    public IGitService create() {
        return retrofit.create(IGitService.class);
    }
}