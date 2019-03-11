package com.example.demomvp.model;

public class ModelLogin {
    ModelReponsePresenterLisener callback;

    public ModelLogin(ModelReponsePresenterLisener callback) {
        this.callback = callback;
    }

    public void handleLogin(String username, String password) {
        if ("quyetcuong@gmail.com".equals(username) & "vanthe010".equals(password)) {
            callback.onLoginSuccess();
        } else {
            callback.onLoginFail();
        }
    }
}

