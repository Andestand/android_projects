package ru.project.examtest.ui.theorys;

import ru.project.examtest.databinding.ItemTheoryBinding;
import ru.project.examtest.ui.theory.TheoryActivity;
import androidx.recyclerview.widget.RecyclerView;
import ru.project.examtest.domain.models.Theory;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import android.view.ViewGroup;
import android.content.Intent;
import java.util.ArrayList;
import android.view.View;

public class AdapterTheory extends RecyclerView.Adapter<AdapterTheory.HolderView> {
    ArrayList<Theory> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemTheoryBinding binding;

        public HolderView(
                ItemTheoryBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Theory theory) {
            binding.textView.setText(theory.getText());
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemTheoryBinding.inflate(
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
                                TheoryActivity.class
                        ).putExtra("theory", array.get(position))
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addTheory(Theory theory) {
        array.remove(theory);
        array.add(theory);
        notifyDataSetChanged();
    }
}
