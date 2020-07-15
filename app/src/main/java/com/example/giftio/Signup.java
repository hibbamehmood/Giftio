package com.example.giftio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    Button callLogin, regBtn;
    TextInputLayout regName, regUserName, regEmail, regPhoneNo, regPassword;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        callLogin = findViewById(R.id.reg_login_btn);
        regName=findViewById(R.id.reg_name);
        regUserName=findViewById(R.id.reg_username);
        regEmail=findViewById(R.id.reg_email);
        regPhoneNo=findViewById(R.id.reg_phoneNo);
        regPassword=findViewById(R.id.reg_password);
        regBtn=findViewById(R.id.reg_btn);




        callLogin.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View v) {
                                             rootnode= FirebaseDatabase.getInstance();
                                             reference = rootnode.getReference("users");
                                             //Get all the values
                                             String name= regName.getEditText().getText().toString();
                                             String username= regUserName.getEditText().getText().toString();
                                             String email= regEmail.getEditText().getText().toString();
                                             String phoneNo= regPhoneNo.getEditText().getText().toString();
                                             String password= regPassword.getEditText().getText().toString();

                                             UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
                                             reference.child(phoneNo).setValue(helperClass);
                                         }
                                     }
        );


    }

    private Boolean validateName()
    {
        String val= regName.getEditText().getText().toString();
        if(val.isEmpty()){
            regName.setError("Field cannot be empty");
            return false;
        }
        else
        {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername()
    {
        String val= regUserName.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            regUserName.setError("Field cannot be empty");
            return false;
        } else if(val.length()>=15){
            regUserName.setError("Username too long");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            regUserName.setError("White Spaces are not allowed");
            return false;
        }
        else
        {
            regUserName.setError(null);
            regUserName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail()
    {
        String val= regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            regEmail.setError("Field cannot be empty");
            return false;
        } else if(!val.matches(emailPattern)){
            regEmail.setError("Invalid email address");
            return false;
        }


        else
        {
            regName.setError(null);
            return true;
        }
    }

    private Boolean validatePhoneNo()
    {
        String val= regPhoneNo.getEditText().getText().toString();
        if(val.isEmpty()){
            regPhoneNo.setError("Field cannot be empty");
            return false;
        }
        else
        {
            regPhoneNo.setError(null);
            return true;
        }
    }

    private Boolean validatePassword()
    {
        String val= regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[a-zA-Z])" +  //any letter
                "(?=.*[@#$%^&+=])" +   //at least 1 special character
                "(?=\\S+$)" +       //no white spaces
                ".{5,}" +    //at least 5 characters
        "$";

        if(val.isEmpty()){
            regPassword.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(passwordVal)){
            regPassword.setError("Password is too weak");
            return false;
        }
        else
        {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }



    public void userRegister(View view) {
        if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername())
        {
            return;
        }

        String name= regName.getEditText().getText().toString();
        String username= regUserName.getEditText().getText().toString();
        String email= regEmail.getEditText().getText().toString();
        String phoneNo= regPhoneNo.getEditText().getText().toString();
        String password= regPassword.getEditText().getText().toString();

        UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);
        reference.child(username).setValue(helperClass);
    }
}
