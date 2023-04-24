package ru.project.examtest.ui.terms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.project.examtest.databinding.ItemTermBinding;
import ru.project.examtest.domain.models.Term;
import ru.project.examtest.ui.term.TermActivity;

public class    AdapterTerms extends RecyclerView.Adapter<AdapterTerms.HolderView> {
    ArrayList<Term> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemTermBinding binding;

        public HolderView(
                ItemTermBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Term term) {
            binding.title.setText(term.getTitle());
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemTermBinding.inflate(
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
                                TermActivity.class
                        ).putExtra("term", array.get(position))
                );
            }
        });

    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addTerm(Term term) {
        array.remove(term);
        array.add(term);
        notifyDataSetChanged();
    }
}
