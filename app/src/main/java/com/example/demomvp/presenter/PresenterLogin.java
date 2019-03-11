package com.example.demomvp.presenter;

import com.example.demomvp.model.ModelLogin;
import com.example.demomvp.model.ModelReponsePresenterLisener;
import com.example.demomvp.view.ViewLoginListener;

public class PresenterLogin implements ModelReponsePresenterLisener {
    private ViewLoginListener callback;
    private ModelLogin modelLogin;

    public PresenterLogin(ViewLoginListener callback) {
        this.callback = callback;
    }

    public void receiveRequireLogin(String username, String password) {
        modelLogin = new ModelLogin(this);
        modelLogin.handleLogin(username, password);
    }

    @Override
    public void onLoginSuccess() {
        callback.onLoginSuccess();
    }

    @Override
    public void onLoginFail() {
        callback.onLoginFail();
    }
}
