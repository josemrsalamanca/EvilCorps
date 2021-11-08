package com.example.noviembre3_evidencia.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.noviembre3_evidencia.R;
import com.example.noviembre3_evidencia.adapter.ApartmentAdapter;
import com.example.noviembre3_evidencia.databinding.FragmentHomeBinding;
import com.example.noviembre3_evidencia.interfaz.HomeView;
import com.example.noviembre3_evidencia.presenter.HomePresentertImpl;

public class HomeFragment extends Fragment implements HomeView {

    private FragmentHomeBinding b;
    private HomePresentertImpl presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        b = FragmentHomeBinding.inflate(inflater,container,false);
        presenter = new HomePresentertImpl(this);
        presenter.generarAdapater();
        return b.getRoot();
    }

    @Override
    public void llenarRecycler(ApartmentAdapter adapter) {
        b.rvDpto.setLayoutManager(new LinearLayoutManager(getContext()));
        b.rvDpto.setAdapter(adapter);

        adapter.setListener(apartment -> {
            presenter.generarBundle(apartment);
        });
    }
    @Override
    public void seleccionarItem(Bundle bundle) {
        Navigation.findNavController(getView()).navigate(R.id.action_homeFragment_to_checkFragment,bundle);
    }
}