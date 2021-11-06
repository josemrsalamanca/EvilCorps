package com.example.noviembre3_evidencia.presenter;

import com.example.noviembre3_evidencia.interfaz.LoginPresenter;
import com.example.noviembre3_evidencia.interfaz.LoginView;

public class LoginPresenterImpl implements LoginPresenter{
    private LoginView view;
    private int cont = 0;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
    }

    @Override
    public void validarUsuario(String mail, String clave) {
        if(mail.equals("hola") && clave.equals("123")){
            view.cambiarVentana();
        }else{
            cont ++;
            view.mostrarError();
        }
        if(cont ==3){
            view.bloquearBoton();
        }
    }
}
