package ru.project.examtest.ui.basic_formulas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import ru.project.examtest.data.models.RoomBasicFormula;
import ru.project.examtest.databinding.ItemBasicFormulasBinding;

public class AdapterBasicFormulas extends RecyclerView.Adapter<AdapterBasicFormulas.HolderView> {
    ArrayList<RoomBasicFormula> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemBasicFormulasBinding binding;

        public HolderView(
                ItemBasicFormulasBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RoomBasicFormula basic_formula) {
            binding.formula.setText(basic_formula.getFormula());
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemBasicFormulasBinding.inflate(
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
                                BFPageActivity.class
                        ).putExtra("basic_formula", array.get(position))
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addBasicFormula(RoomBasicFormula theory) {
        array.remove(theory);
        array.add(theory);
        notifyDataSetChanged();
    }
}
