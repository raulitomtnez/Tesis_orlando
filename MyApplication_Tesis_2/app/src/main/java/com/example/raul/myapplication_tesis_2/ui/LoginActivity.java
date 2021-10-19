package com.example.raul.myapplication_tesis_2.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.raul.myapplication_tesis_2.R;
import com.example.raul.myapplication_tesis_2.helper.InputValidations;
import com.example.raul.myapplication_tesis_2.networking.generator.RetrofitClient;
import com.example.raul.myapplication_tesis_2.networking.response.LoginRequest;
import com.example.raul.myapplication_tesis_2.networking.response.LoginResponse;
import com.example.raul.myapplication_tesis_2.preferences.AppPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    // UI
    private TextInputLayout inputUserName, inputPassword;
    private EditText etUserName, etPassword;
    // Validations
    private InputValidations inputValidations;
    // ProgressDialog
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initDialog();
        initViews();
        initObjects();

    }

    /**
     * Initialize objects
     */
    private void initObjects() {
        inputValidations = new InputValidations(this);
    }

    /**
     * Initialize Views
     */
    private void initViews() {
        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // UI
        inputUserName = (TextInputLayout) findViewById(R.id.inputUserName);
        inputPassword = (TextInputLayout) findViewById(R.id.inputPassword);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    /**
     * Login event
     *
     * @param view View
     */
    public void login(View view) {
        verifyData();
    }

    /**
     * Validations
     */
    private void verifyData() {
        // validate is empty
        if (!inputValidations.isInputEditTextFilled(etUserName, inputUserName, getString(R.string.empty))) {
            etUserName.requestFocus();
            return;
        } else if (!inputValidations.isInputEditTextFilled(etPassword, inputPassword, getString(R.string.empty))) {
            etPassword.requestFocus();
            return;
        } else if (!inputValidations.isInputEditUserName(etUserName, inputUserName, getString(R.string.valid_user_name))) {
            etUserName.requestFocus();
            return;
        } else {
            // get data
            final String userName = etUserName.getText().toString().trim();
            final String password = etPassword.getText().toString().trim();
            // hide keyboard
            inputValidations.hideKeyboardFrom(getCurrentFocus());
            // submit data
            submitData(userName, password);
        }
    }

    /**
     * Submit data from inputs
     */
    private void submitData(String userName, String password) {
        showDialog();

        LoginRequest loginRequest = new LoginRequest(userName, password);

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                hideDialog();

                if (!response.isSuccessful()) {
                    showDialogErr401();
                    return;
                }

                if (response.code() == 200) {
                    // Response data
                    final String username = response.body().getUser().getUsername();
                    final String role = response.body().getUser().getRoles().get(0);
                    final String name = response.body().getUser().getNombreCompleto();

                    // Save app preferences
                    AppPreferences.saveLoginStatus(true, getApplicationContext());
                    AppPreferences.saveUserName(username, getApplicationContext());
                    AppPreferences.saveRole(role, getApplicationContext());
                    AppPreferences.saveName(name, getApplicationContext());

                    // startActivity Main
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("LoginActivity", "onFailure: ", t);
                hideDialog();
                showDialogOnFailure();
            }
        });
    }

    /**
     * Dialog 401
     */
    private void showDialogErr401() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setTitle(R.string.dialog_err_title)
                .setMessage(R.string.dialog_401)
                /*.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        *//**
         * TODO QUITAR ESTO
         *//*
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                })*/
                .show();
    }

    /**
     * Dialog OnFailure
     */
    private void showDialogOnFailure() {
        new AlertDialog.Builder(this)
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
        pDialog = new ProgressDialog(this);
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

}

