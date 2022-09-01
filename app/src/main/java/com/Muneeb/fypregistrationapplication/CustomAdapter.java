package com.Muneeb.fypregistrationapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Muneeb.fypregistrationapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList form_no, stu_name, fat_name, major, project, supervisor, email, github;


    CustomAdapter(Activity activity, Context context, ArrayList form_no, ArrayList stu_name, ArrayList fat_name, ArrayList major, ArrayList project, ArrayList supervisor, ArrayList email, ArrayList github){

        this.activity = activity;
        this.context = context;
        this.form_no = form_no;
        this.stu_name = stu_name;
        this.fat_name = fat_name;
        this.major = major;
        this.project = project;
        this.supervisor = supervisor;
        this.email = email;
        this.github = github;

    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.form_no_txt.setText(String.valueOf(form_no.get(position)));
        holder.stu_name_txt.setText(String.valueOf(stu_name.get(position)));
        holder.fat_name_txt.setText(String.valueOf(fat_name.get(position)));
        holder.major_txt.setText(String.valueOf(major.get(position)));
        holder.project_txt.setText(String.valueOf(project.get(position)));
        holder.supervisor_txt.setText(String.valueOf(supervisor.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
        holder.github_txt.setText(String.valueOf(github.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("form_no", String.valueOf(form_no.get(position)));
                intent.putExtra("stu_name", String.valueOf(stu_name.get(position)));
                intent.putExtra("fat_name", String.valueOf(fat_name.get(position)));
                intent.putExtra("major", String.valueOf(major.get(position)));
                intent.putExtra("project", String.valueOf(project.get(position)));
                intent.putExtra("supervisor", String.valueOf(supervisor.get(position)));
                intent.putExtra("email", String.valueOf(email.get(position)));
                intent.putExtra("github", String.valueOf(github.get(position)));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return form_no.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView form_no_txt, stu_name_txt, fat_name_txt, major_txt, project_txt, supervisor_txt, email_txt, github_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            form_no_txt = itemView.findViewById(R.id.form_no_txt);
            stu_name_txt = itemView.findViewById(R.id.stu_name_txt);
            fat_name_txt = itemView.findViewById(R.id.fat_name_txt);
            major_txt = itemView.findViewById(R.id.major_txt);
            project_txt = itemView.findViewById(R.id.project_txt);
            supervisor_txt = itemView.findViewById(R.id.supervisor_txt);
            email_txt = itemView.findViewById(R.id.email_txt);
            github_txt = itemView.findViewById(R.id.github_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
