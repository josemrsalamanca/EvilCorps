package com.example.noviembre3_evidencia.presenter;

import android.os.Bundle;

import com.example.noviembre3_evidencia.adapter.ApartmentAdapter;
import com.example.noviembre3_evidencia.interfaz.HomePresenter;
import com.example.noviembre3_evidencia.interfaz.HomeView;
import com.example.noviembre3_evidencia.model.Apartment;
import com.example.noviembre3_evidencia.model.ApartmentData;

import java.util.ArrayList;

public class HomePresentertImpl implements HomePresenter {
    private HomeView view;

    public HomePresentertImpl(HomeView view) {
        this.view = view;
    }

    @Override
    public void generarAdapater() {
        ApartmentAdapter adapter = new ApartmentAdapter((ArrayList<Apartment>) ApartmentData.apartmentList());
        view.llenarRecycler(adapter);
    }

    @Override
    public void generarBundle(Apartment apartment) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("apartment",apartment);
        view.seleccionarItem(bundle);
    }
}
