package com.shweta.retrofitexample2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitClientInstance {

    public static TryCatchInterface tryCatchInterface;
    public static TryCatchInterface getTryCatchInterface(){
        if (tryCatchInterface == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(80, TimeUnit.SECONDS)
                    .connectTimeout(80, TimeUnit.SECONDS)
                    .build();
            Gson gson = new GsonBuilder()
                    .setLenient().create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com")
                    // .addConverterFactory(ScalerConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            tryCatchInterface = retrofit.create(TryCatchInterface.class);
        }
        return tryCatchInterface;
    }
    public interface TryCatchInterface {
        @GET("/api/v1/employees")
        Call<EmpInfo> getEmpInfo();
    }

    }

