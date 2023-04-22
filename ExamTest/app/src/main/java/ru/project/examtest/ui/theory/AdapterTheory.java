package ru.project.examtest.ui.theory;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.project.examtest.databinding.ItemTheoryBinding;
import ru.project.examtest.domain.models.Theory;

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
            binding.textView3.setText(theory.getText());
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
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        holder.bind(array.get(position));
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
