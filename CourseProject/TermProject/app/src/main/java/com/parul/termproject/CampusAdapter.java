package com.parul.termproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CampusAdapter extends RecyclerView.Adapter<CampusAdapter.ViewHolder> {
    List<CampusOut> students;

    public CampusAdapter () {

    }

    public CampusAdapter (List<CampusOut> students) {
        this.students = students;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showstudentsoutcampus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CampusOut st = students.get(position);
        holder.name.setText(st.getName());
        holder.rollNo.setText(st.getRollNO());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, rollNo;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            rollNo = itemView.findViewById(R.id.rollno);
        }
    }
}

