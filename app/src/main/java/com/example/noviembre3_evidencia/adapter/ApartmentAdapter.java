package com.example.noviembre3_evidencia.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noviembre3_evidencia.R;
import com.example.noviembre3_evidencia.databinding.ItemLayoutBinding;
import com.example.noviembre3_evidencia.model.Apartment;

import java.util.ArrayList;

public class ApartmentAdapter extends RecyclerView.Adapter<ApartmentAdapter.CustomViewHolder> {

    private ArrayList<Apartment> deptos;
    private OnClickListener listener;

    public ApartmentAdapter(ArrayList<Apartment> deptos) {
        this.deptos = deptos;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new CustomViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ApartmentAdapter.CustomViewHolder holder, int position) {
        holder.binData(deptos.get(position));
    }

    @Override
    public int getItemCount() {
        return deptos.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private ItemLayoutBinding b;
        private OnClickListener listener;
        public CustomViewHolder(@NonNull View itemView,OnClickListener listener) {
            super(itemView);
            b = ItemLayoutBinding.bind(itemView);
            this.listener = listener;
        }

        public void binData(Apartment apartment){
            b.tvEd.setText(apartment.getProjectName());
            b.tvDpto.setText(apartment.getUnitId());
            b.tvDirecc.setText(apartment.getAddress());
            itemView.setOnClickListener(view -> {
                listener.onApartmentClick(apartment);
            });
        }
    }

    public interface OnClickListener{
        void onApartmentClick(Apartment apartment);
    }

    public ApartmentAdapter setListener(OnClickListener listener) {
        this.listener = listener;
        return this;
    }
}
