package ru.nemek.server.auth;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Auth2callback extends HttpServlet {

    protected void loginInGoogle(HttpServletResponse resp) throws IOException { //функция которая отправляет первый get запрос
        System.out.println("Тут вывод");
    }

}
