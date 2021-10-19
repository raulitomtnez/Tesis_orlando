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
import com.example.raul.myapplication_tesis_2.adapter.SiembraAdapter;
import com.example.raul.myapplication_tesis_2.networking.generator.RetrofitClient;
import com.example.raul.myapplication_tesis_2.networking.response.SiembraResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiembraFragment extends Fragment {

    private View rootView;
    private OnFragmentInteractionListener mListener;

    // ProgressDialog
    private ProgressDialog pDialog;

    // UI
    private RecyclerView recyclerView;

    public SiembraFragment() {
        // Required empty public constructor
    }

    public static SiembraFragment newInstance() {
        SiembraFragment fragment = new SiembraFragment();
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
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_siembra, container, false);

        initDialog();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_siembra);
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

        Call<List<SiembraResponse>> call = RetrofitClient.getInstance().getApi().getSiembras();
        call.enqueue(new Callback<List<SiembraResponse>>() {
            @Override
            public void onResponse(Call<List<SiembraResponse>> call, Response<List<SiembraResponse>> response) {
                // ocultar el cargando
                hideDialog();
                if (response.code() == 200) {
                    // lleno la lista
                    List<SiembraResponse> body = response.body();

                    SiembraAdapter adapter = new SiembraAdapter(body);

                    recyclerView.setAdapter(adapter);

                } else {
                    showDialogOnFailure();
                }
            }

            @Override
            public void onFailure(Call<List<SiembraResponse>> call, Throwable throwable) {
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
