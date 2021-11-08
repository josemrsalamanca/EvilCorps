package com.example.noviembre3_evidencia.interfaz;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.noviembre3_evidencia.adapter.ApartmentAdapter;

public interface HomeView {
    void llenarRecycler(ApartmentAdapter adapter);
    void seleccionarItem(Bundle bundle);
}

