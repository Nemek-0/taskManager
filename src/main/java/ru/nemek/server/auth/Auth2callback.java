package ru.nemek.server.auth;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfoplus;
import com.google.api.services.sheets.v4.Sheets;
import ru.nemek.server.ServerUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.nemek.server.ServerUtils.APPLICATION_NAME;

@SuppressWarnings("serial")
public class Auth2callback extends HttpServlet {





    public  Credential credential;



    protected void logininGoogle(HttpServletResponse resp) throws IOException { //функция которая отправляет первый get запрос

        try {
            System.out.println(CredentialManager.getAuthorizationUrl(true));
            resp.sendRedirect(CredentialManager.getAuthorizationUrl(true));

        } catch (IOException e) {
            throw new RuntimeException("Can't redirect to auth page");
        }
    }


    //@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");//Получаем параметр code из get ответа гугла


        Credential credential = CredentialManager.retrieveCredential(code);
        Oauth2 outh2Service = ServerUtils.getOauth2Service(credential);
        Userinfoplus about = outh2Service.userinfo().get().execute();

        System.out.println(about);

        resp.sendRedirect("/#home"); //пересылка пользователя на начальную страниц
    }

    public static Sheets getSheetsService(String id) throws IOException {
        System.out.println("id : " + id);
        return new Sheets.Builder(CredentialManager.TRANSPORT, CredentialManager.JSON_FACTORY, CredentialManager.getCredential(id)).setApplicationName(APPLICATION_NAME).build();
    }



}

