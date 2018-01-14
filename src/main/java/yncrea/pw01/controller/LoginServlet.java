package yncrea.pw01.controller;

import yncrea.pw01.model.Pharmacist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private List<Pharmacist> pharmacists;

    public void init() throws ServletException {
        this.pharmacists = new ArrayList<>();
        this.pharmacists.add(new Pharmacist("pharm1", "password1"));
        this.pharmacists.add(new Pharmacist("pharm2", "password2"));
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if(req.getQueryString().equals("logout")){
            HttpSession session = req.getSession();
            session.removeAttribute("loggedPharmacist");
            resp.sendRedirect("contextPath/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Pharmacist pharmacist = new Pharmacist(login, password);
        if(pharmacists.contains(pharmacist)){
            request.removeAttribute("loginError");
            request.getSession().setAttribute("loggedPharmacist", pharmacist);
            response.sendRedirect(request.getServletContext().getContextPath() + "/drugs");
        } else{
            request.setAttribute("loginError", "Invalid credentials!");
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
