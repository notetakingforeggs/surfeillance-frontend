package com.example.surfeillancefrontend.model.data.DTO;

public class TokenHolder {
    private static TokenHolder instance;
    private String token;

    private TokenHolder() {
    }

    public static synchronized TokenHolder getInstance() {
        if (instance == null) {
            instance = new TokenHolder();

        }
          return instance;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        System.out.println("this is the token on setting" + token);
        this.token = token;
    }
}
