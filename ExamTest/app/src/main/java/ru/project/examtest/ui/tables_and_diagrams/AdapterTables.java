package ru.project.examtest.ui.tables_and_diagrams;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ru.project.examtest.data.models.RoomTables;
import ru.project.examtest.databinding.ItemTableBinding;


public class AdapterTables extends RecyclerView.Adapter<AdapterTables.HolderView> {
    ArrayList<RoomTables> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemTableBinding binding;

        public HolderView(
                ItemTableBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RoomTables table) {
            Glide.with(itemView.getContext()).load(table.link).into(binding.iv);
            binding.title.setText(table.title);
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemTableBinding.inflate(
                        LayoutInflater.from(parent.getContext())
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(array.get(position));
    }

    @Override
    public int getItemCount() {
        return array.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addImage(RoomTables table) {
        array.remove(table);
        array.add(table);
        notifyDataSetChanged();
    }
}
