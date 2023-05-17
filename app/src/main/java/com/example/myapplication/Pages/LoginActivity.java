package com.example.myapplication.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.myapplication.Core.BaseActivity;
import com.example.myapplication.Pages.Presenters.LoginPresenter;
import com.example.myapplication.databinding.ActivityLoginBinding;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        LoginPresenter loginPresenter=new LoginPresenter(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.lgBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.Login(binding.loginEtUsername.getText().toString(),binding.loginEtPassword.getText().toString());
            }
        });
    }

  public void loginSuccessfull(){
       Intent intent=new Intent(LoginActivity.this,NavHostActivity.class);
       startActivity(intent);
   }
   public void loginFail(String massage){

       Toasty.error(this, massage, Toast.LENGTH_SHORT, true).show();
    }
}