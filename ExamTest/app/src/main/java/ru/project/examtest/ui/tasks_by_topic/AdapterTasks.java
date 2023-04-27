package ru.project.examtest.ui.tasks_by_topic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.project.examtest.data.models.RoomTasks;
import ru.project.examtest.databinding.ItemTasksBinding;
import ru.project.examtest.ui.basic_formulas.BFPageActivity;


public class AdapterTasks extends RecyclerView.Adapter<AdapterTasks.HolderView> {
    ArrayList<RoomTasks> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemTasksBinding binding;

        public HolderView(
                ItemTasksBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RoomTasks tasks) {
            binding.title.setText(tasks.title);
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemTasksBinding.inflate(
                        LayoutInflater.from(parent.getContext())
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(array.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.itemView.getContext().startActivity(
                        new Intent(
                                holder.itemView.getContext(),
                                TaskActivity.class
                        ).putExtra("task", array.get(position))
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addTasks(RoomTasks tasks) {
        array.remove(tasks);
        array.add(tasks);
        notifyDataSetChanged();
    }
}
