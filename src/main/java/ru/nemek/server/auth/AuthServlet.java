package ru.nemek.server.auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends Auth2callback {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logininGoogle(resp);

    }
}
