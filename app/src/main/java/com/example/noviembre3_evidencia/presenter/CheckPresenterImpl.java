package com.example.noviembre3_evidencia.presenter;

import android.os.Bundle;

import com.example.noviembre3_evidencia.interfaz.CheckPresenter;
import com.example.noviembre3_evidencia.interfaz.CheckView;
import com.example.noviembre3_evidencia.model.Apartment;

public class CheckPresenterImpl implements CheckPresenter {
    private CheckView view;
    Apartment apartment;
    int puntaje;

    public CheckPresenterImpl(CheckView view) {
        this.view = view;
    }


    @Override
    public void obtenerApartment(Bundle bundle) {
        apartment = (Apartment) bundle.getSerializable("apartment");
        view.llenarViews(apartment.getBuildingName(), apartment.getUnitId(), apartment.getUrlImageBuilding());
    }

    @Override
    public void calcularPuntaje() {
        puntaje = 0;
        if(view.isLucesCheckrf()){
            puntaje +=10;
        }
        if(view.isDormitorioCheckrf()){
            puntaje +=20;
        }
        if(view.isCocinaCheckrf()){
            puntaje +=30;
        }
        if(view.isBanioCheckrf()){
            puntaje +=40;
        }

        switch (view.getRadioPosition()){
            case 0: puntaje *= 3; break;
            case 1: puntaje *= 2; break;
        }
        view.mostrarPuntaje(String.valueOf(puntaje));

        if (puntaje < 130){
            view.activarBoton();
        }
    }

    @Override
    public void generarAlerta() {
        view.enviarMail(apartment.getBuildingName(),apartment.getUnitId(),puntaje);
    }

}
