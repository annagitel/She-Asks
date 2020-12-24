package com.example.sheasks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.RVAdapterHolder> {

    private final LayoutInflater inflater;
    Context context;
    private ArrayList<Question> questionsList;

    public QuestionsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        questionsList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RVAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.question_search_item, parent, false);
        return new RVAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapterHolder holder, int position) {
        Question rvData = questionsList.get(position);

        holder.category.setText(rvData.getCategory());
        holder.question.setText(rvData.getText());
        holder.date.setText(new SimpleDateFormat("HH:mm MM/dd/yy").format(new Date(rvData.getDate())));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO - go to question answers activity
                Intent intent = new Intent(context, AnswersActivity.class);
                intent.putExtra("question", questionsList.get(holder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questionsList = questions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public static class RVAdapterHolder extends RecyclerView.ViewHolder {

        TextView category;
        TextView question;
        TextView date;

        public RVAdapterHolder(View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.categoryText);
            question = (TextView) itemView.findViewById(R.id.questionText);
            date = (TextView) itemView.findViewById(R.id.dateText);
        }
    }
}