package ru.project.examtest.ui.tables_and_diagrams;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ru.project.examtest.data.models.RoomDiagrams;
import ru.project.examtest.databinding.ItemDiagramsBinding;
import ru.project.examtest.databinding.ItemTableBinding;


public class AdapterDiagrams extends RecyclerView.Adapter<AdapterDiagrams.HolderView> {
    ArrayList<RoomDiagrams> array = new ArrayList<>();

    public static class HolderView extends RecyclerView.ViewHolder {
        ItemDiagramsBinding binding;

        public HolderView(
                ItemDiagramsBinding binding
        ) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RoomDiagrams diagram) {
            Glide.with(itemView.getContext()).load(diagram.link).into(binding.iv);
            binding.title.setText(diagram.title);
        }
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HolderView(
                ItemDiagramsBinding.inflate(
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
    public void addImage(RoomDiagrams diagram) {
        array.remove(diagram);
        array.add(diagram);
        notifyDataSetChanged();
    }
}
