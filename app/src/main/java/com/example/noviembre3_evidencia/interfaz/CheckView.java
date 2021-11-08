package com.example.noviembre3_evidencia.interfaz;

import android.os.Bundle;

public interface CheckView {
    void llenarViews(String buildingName, String unitId, String urlImageBuilding);

    boolean isLucesCheckrf();
    boolean isDormitorioCheckrf();
    boolean isCocinaCheckrf();
    boolean isBanioCheckrf();

    int getRadioPosition();

    void mostrarPuntaje(String puntaje);

    void enviarMail(String buildName, String unitId, int puntaje);
    void activarBoton();
}
