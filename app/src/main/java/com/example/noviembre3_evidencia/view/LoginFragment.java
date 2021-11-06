package com.example.noviembre3_evidencia.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.noviembre3_evidencia.R;
import com.example.noviembre3_evidencia.databinding.FragmentLoginBinding;
import com.example.noviembre3_evidencia.interfaz.LoginView;
import com.example.noviembre3_evidencia.presenter.LoginPresenterImpl;

public class LoginFragment extends Fragment implements LoginView {
    private FragmentLoginBinding b;
    private LoginPresenterImpl presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentLoginBinding.inflate(inflater,container,false);
        val();
        presenter = new LoginPresenterImpl(this);
        return b.getRoot();
    }

    private void val() {
        b.btnIngresar.setOnClickListener(view -> {
            String mail = b.etMail.getText().toString();
            String clave = b.etClave.getText().toString();
            presenter.validarUsuario(mail,clave);
        });
    }

    @Override
    public void mostrarError() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cambiarVentana() {
        Navigation.findNavController(b.getRoot()).navigate(R.id.action_loginFragment_to_homeFragment);
    }

    @Override
    public void bloquearBoton() {
        b.btnIngresar.setEnabled(false);
    }
}