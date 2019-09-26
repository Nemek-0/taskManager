package ru.nemek.server.auth;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Auth2callback extends HttpServlet {

    protected void loginInGoogle(HttpServletResponse resp) throws IOException { //функция которая отправляет первый get запрос

        System.out.println("Тут вывод");
    }
}
