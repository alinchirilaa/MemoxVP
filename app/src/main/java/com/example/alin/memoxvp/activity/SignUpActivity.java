package com.example.alin.memoxvp.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alin.memoxvp.R;

public class SignUpActivity extends AppCompatActivity {

    EditText emailText;
    EditText confirmEmailText;
    EditText cuiText;
    EditText usernameText;
    EditText phoneText;
    EditText passwordText;
    EditText confirmPasswordText;
    Button signupButton;
    TextView loginLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailText = (EditText) findViewById(R.id.input_email);
        confirmEmailText = (EditText) findViewById(R.id.input_email_confirm);
        cuiText = (EditText) findViewById(R.id.input_CUI);
        usernameText = (EditText) findViewById(R.id.input_user_name);
        phoneText = (EditText) findViewById(R.id.input_phone_number);
        passwordText = (EditText) findViewById(R.id.input_password_sign_up);
        confirmPasswordText = (EditText) findViewById(R.id.input_password_sign_up_confirm);
        signupButton = (Button) findViewById(R.id.button_signup);
        loginLink = (TextView) findViewById(R.id.link_login);

        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                signUp();
            }
        });


        loginLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //return to LoginActivity
                finish();
            }
        });

    }


    public void signUpSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void signUpFailed() {
        Toast.makeText(getBaseContext(), "Înregistrare eșuată", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    public boolean validateInput() {
        boolean valid = true;

        String email = emailText.getText().toString();
        String confirmEmail = confirmEmailText.getText().toString();
        String CUI = cuiText.getText().toString();
        String username = usernameText.getText().toString();
        String phone = phoneText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Email address not valid");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (confirmEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(confirmEmail).matches()) {
            confirmEmailText.setError("Email address not valid");
            valid = false;
        } else {
            confirmEmailText.setError(null);
        }

        if (CUI.isEmpty() || CUI.length() > 10) {
            cuiText.setError("Enter valid CUI");
            valid = false;
        } else {
            cuiText.setError(null);
        }


        if (username.isEmpty() || username.length() < 3) {
            usernameText.setError("at least 3 characters");
            valid = false;
        } else {
            usernameText.setError(null);
        }


        if (phone.isEmpty() || !phone.matches("\\d{10}") || !phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            phoneText.setError("at least 3 characters");
            valid = false;
        } else {
            phoneText.setError(null);
        }


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("password should be between 4 and 10 characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        if (confirmPassword.isEmpty() || confirmPassword.length() < 4 || confirmPassword.length() > 10) {
            confirmPasswordText.setError("password should be between 4 and 10 characters");
            valid = false;
        } else {
            confirmPasswordText.setError(null);
        }

        return valid;
    }


    public void signUp() {
        if (!validateInput()) {
            signUpFailed();
            //return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creare cont ...");
        progressDialog.show();


        //TODO: Implement signUp logic

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                signUpSuccess();
                progressDialog.dismiss();
            }
        }, 3000);

    }

}
