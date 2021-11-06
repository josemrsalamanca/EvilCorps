package com.example.noviembre3_evidencia.interfaz;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

public interface HomeView {
    void llenarRecycler(RecyclerView.Adapter adapter);
    void seleccionarItem(Bundle bundle);
}

