package com.example.sheasks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.RVAdapterHolder> {

    private final LayoutInflater inflater;
    Context context;
    private ArrayList<Answer> answersList;

    public AnswersAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        answersList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RVAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.answer_item, parent, false);
        return new RVAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapterHolder holder, int position) {
        Answer rvData = answersList.get(position);

        holder.data.setText(rvData.getData());
        holder.date.setText(new SimpleDateFormat("HH:mm MM/dd/yy").format(new Date(rvData.getDate())));
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answersList = answers;
        notifyDataSetChanged();
    }

    public void addAnswer(Answer answer) {
        this.answersList.add(answer);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return answersList.size();
    }


    public static class RVAdapterHolder extends RecyclerView.ViewHolder {

        TextView data;
        TextView date;

        public RVAdapterHolder(View itemView) {
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.dataText);
            date = (TextView) itemView.findViewById(R.id.dateText);
        }
    }
}