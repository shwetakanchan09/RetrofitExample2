package com.shweta.retrofitexample2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EmpAdapter empAdapter;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        Call<EmpInfo> call = RetrofitClientInstance.getTryCatchInterface().getEmpInfo();
        call.enqueue(new Callback<EmpInfo>() {
            @Override
            public void onResponse(Call<EmpInfo> call, Response<EmpInfo> response) {
                progressDoalog.dismiss();

                if (response.code()==200 && response.body()!=null) {
                    Toast.makeText(MainActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    showEmpData(response.body());

                }
            }

            @Override
            public void onFailure(Call<EmpInfo> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void showEmpData(EmpInfo empInfoList){
        empAdapter = new EmpAdapter(this,empInfoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(empAdapter);
    }
}