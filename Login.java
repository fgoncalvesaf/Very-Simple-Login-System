package com.example.goncalves.simplelogin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private String emailTest;
    private String passwordTest;
    private EditText email;
    private EditText password;
    private Button singInButton;
    private AlertDialog confirmation;
    private AlertDialog failure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //example of a signed email
        emailTest = "example@gmail.com";
        passwordTest = "1234";

        //getting references
        email = (EditText) findViewById(R.id.emailInput);
        password = (EditText) findViewById(R.id.passwordInput);
        singInButton = (Button) findViewById(R.id.singInButton);

        //Success Alert
        confirmation = new AlertDialog.Builder(this).create();
        confirmation.setTitle("Status");
        confirmation.setMessage("Done.");
        confirmation.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        //Failure Alert
        failure = new AlertDialog.Builder(this).create();
        failure.setTitle("Status");
        failure.setMessage("Failed");
        failure.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        //Button Sing in pressed
        singInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals(emailTest) && password.getText().toString().equals(passwordTest))
                    confirmation.show();

                else
                    failure.show();
            }
        });
    }
}
