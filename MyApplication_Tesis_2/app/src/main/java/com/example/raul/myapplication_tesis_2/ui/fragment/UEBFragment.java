package com.example.raul.myapplication_tesis_2.ui.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.adapter.UEBAdapter;
import com.example.raul.myapplication_tesis_2.networking.generator.RetrofitClient;
import com.example.raul.myapplication_tesis_2.networking.model.UEB;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UEBFragment extends Fragment {

    private View rootView;
    private OnFragmentInteractionListener mListener;

    // ProgressDialog
    private ProgressDialog pDialog;

    // UI
    private RecyclerView recyclerView;

    public UEBFragment() {
        // Required empty public constructor
    }

    public static UEBFragment newInstance() {
        UEBFragment fragment = new UEBFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_ueb, container, false);

        initDialog();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_ueb);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setHasFixedSize(true);

        // MOSTRAR LOS DATOS
        displayData();

        return rootView;
    }

    /**
     * Display data from DB
     */
    private void displayData() {

        showDialog();

        Call<List<UEB>> call = RetrofitClient.getInstance().getApi().getUEBS();
        call.enqueue(new Callback<List<UEB>>() {
            @Override
            public void onResponse(Call<List<UEB>> call, Response<List<UEB>> response) {
                // ocultar el cargando
                hideDialog();
                if (response.code() == 200) {
                    // lleno la lista
                    List<UEB> body = response.body();

                    UEBAdapter adapter = new UEBAdapter(body);

                    recyclerView.setAdapter(adapter);

                } else {
                    showDialogOnFailure();
                }
            }

            @Override
            public void onFailure(Call<List<UEB>> call, Throwable throwable) {
                Log.e("ERROR:", "onFailure: ", throwable);
                hideDialog();
                showDialogOnFailure();
            }
        });
    }

    /**
     * Dialog OnFailure
     */
    private void showDialogOnFailure() {
        new AlertDialog.Builder(getContext())
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setTitle(R.string.dialog_err_title)
                .setMessage(R.string.dialog_on_failure)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> dialog.dismiss())
                .show();
    }

    /**
     * Initialize dialog
     */
    private void initDialog() {
        pDialog = new ProgressDialog(getContext());
        pDialog.setTitle(getString(R.string.loading));
    }

    /**
     * Show dialog
     */
    private void showDialog() {
        if (!pDialog.isShowing()) pDialog.show();
    }

    /**
     * Hide dialog
     */
    private void hideDialog() {
        if (pDialog.isShowing()) pDialog.dismiss();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
