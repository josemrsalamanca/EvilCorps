package com.example.noviembre3_evidencia.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.noviembre3_evidencia.R;
import com.example.noviembre3_evidencia.databinding.FragmentCheckBinding;
import com.example.noviembre3_evidencia.interfaz.CheckView;
import com.example.noviembre3_evidencia.presenter.CheckPresenterImpl;

public class CheckFragment extends Fragment implements CheckView {
    private FragmentCheckBinding b;
    private CheckPresenterImpl presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b=  FragmentCheckBinding.inflate(inflater,container,false);
        presenter = new CheckPresenterImpl(this);


        assert getArguments() != null;
        getArguments().getSerializable("apartment");
        presenter.obtenerApartment(getArguments());

        b.btGuardar.setOnClickListener(view -> {
            presenter.calcularPuntaje();
        });

        b.btAlerta.setOnClickListener(view -> {
            presenter.generarAlerta();
        });

        return b.getRoot();
    }

    @Override
    public void llenarViews(String buildingName, String unitId, String urlImageBuilding) {
        b.tvCondominio.setText(buildingName);
        b.tvNumeroDpto.setText(unitId);

        Glide.with(this).load(urlImageBuilding).into(b.imageViewGlide);
    }

    @Override
    public boolean isLucesCheckrf() {
        return b.chkLuces.isChecked();
    }

    @Override
    public boolean isDormitorioCheckrf() {
        return b.chkDormitorio.isChecked();
    }

    @Override
    public boolean isCocinaCheckrf() {
        return b.chkCocina.isChecked();
    }

    @Override
    public boolean isBanioCheckrf() {
        return b.chkBaO.isChecked() ;
    }

    @Override
    public int getRadioPosition() {
        int radioButtonId = b.rdgButon.getCheckedRadioButtonId();
        View radioButton = b.rdgButon.findViewById(radioButtonId);
        int idx = b.rdgButon.indexOfChild(radioButton);
        return idx;
    }

    @Override
    public void mostrarPuntaje(String puntaje) {
        String t = getString(R.string.puntos) + " " + puntaje;
        b.tvResultado.setText(t);
    }

    @Override
    public void enviarMail(String buildName, String unitId, int puntaje) {
        String email = "josemrsalamanca@gmail.com";
        String subject = "josemrsalamanca@gmail.com";
        String body = String.format("Estimado: el dpto &s del edificio %s obtuvo $s puntaje, favor reportarlo, saludos"
                ,buildName,unitId,String.valueOf(puntaje));

        // que paso ahora !!!  )
        String chooserTitle = "null";

        Uri uri = Uri.parse("mailto:" + email)
                .buildUpon()
                .appendQueryParameter("subject", subject)
                .appendQueryParameter("body", body)
                .build();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(Intent.createChooser(emailIntent, chooserTitle));

    }

    @Override
    public void activarBoton() {
        b.btAlerta.setEnabled(true);
    }
}