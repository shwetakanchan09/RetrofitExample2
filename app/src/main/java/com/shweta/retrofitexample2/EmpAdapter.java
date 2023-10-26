package com.shweta.retrofitexample2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {

    Context context;
    EmpInfo empInfoList;

    public EmpAdapter(Context context, EmpInfo empInfoList) {
        this.context = context;
        this.empInfoList = empInfoList;
    }

    @NonNull
    @Override
    public EmpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_emp_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpAdapter.ViewHolder holder, int position) {

        holder.txtId.setText(""+empInfoList.getData().get(position).getId());
        holder.txtName.setText(""+empInfoList.getData().get(position).getEmployeeName());
        holder.txtSal.setText(""+empInfoList.getData().get(position).getEmployeeSalary());
//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(empInfoList.getData().get(position).getProfileImage())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.idPic);

    }

    @Override
    public int getItemCount() {
        return empInfoList.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView txtId, txtName, txtSal;
        private ImageView idPic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            txtId = mView.findViewById(R.id.idEmp);
            txtName = mView.findViewById(R.id.name);
            txtSal = mView.findViewById(R.id.salary);
            idPic = mView.findViewById(R.id.empPic);

        }
    }
}
