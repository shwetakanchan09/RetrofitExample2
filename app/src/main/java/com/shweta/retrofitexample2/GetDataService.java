package com.shweta.retrofitexample2;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/v1/employees")
    Call<EmpInfo> getEmpInfo();

}