package com.example.raul.myapplication_tesis_2.helper;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.regex.Pattern;

public class InputValidations {
    // Context
    private Context context;
    // User name reg-e
    private static final Pattern USER_NAME_PATTERN =
            Pattern.compile("^[a-zA-ZÁÉÍÓÚñáéíóúÑ]+(([',. -][a-zA-Z ÁÉÍÓÚñáéíóúÑ])?[a-zA-ZÁÉÍÓÚñáéíóúÑ]*)*$");

    /**
     * constructor
     *
     * @param context
     */
    public InputValidations(Context context) {
        this.context = context;
    }

    /**
     * method to check InputEditText filled.
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    public boolean isInputEditTextFilled(EditText textInputEditText, TextInputLayout textInputLayout, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditUserName(EditText textInputEditText, TextInputLayout textInputLayout, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !USER_NAME_PATTERN.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * method to check InputEditText length
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @param length
     * @return
     */
    public boolean isInputEditTextLength(EditText textInputEditText, TextInputLayout textInputLayout, String message, int length) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || value.length() < length) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * method to check InputEditText has valid email.
     *
     * @param textInputEditText
     * @param textInputLayout
     * @param message
     * @return
     */
    public boolean isInputEditTextEmail(EditText textInputEditText, TextInputLayout textInputLayout, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isInputEditTextPhone(EditText textInputEditText, TextInputLayout textInputLayout, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.PHONE.matcher(value).matches()) {
            textInputLayout.setError(message);
            hideKeyboardFrom(textInputEditText);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * method to check InputEditText matches
     *
     * @param textInputEditText1
     * @param textInputEditText2
     * @param textInputLayout2
     * @param message
     * @return
     */
    public boolean isInputEditTextMatches(EditText textInputEditText1, EditText textInputEditText2, TextInputLayout textInputLayout2, String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            textInputLayout2.setError(message);
            hideKeyboardFrom(textInputEditText2);
            return false;
        } else {
            textInputLayout2.setErrorEnabled(false);
        }
        return true;
    }

    /**
     * method to hide keyboard
     *
     * @param view
     */
    public void hideKeyboardFrom(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * method to clear InputEditTexts
     *
     * @param textInputEditTexts
     */
    public void clearInputEditTexts(EditText... textInputEditTexts) {
        for (EditText textInputEditText : textInputEditTexts) {
            textInputEditText.setText(null);
        }
    }

}
