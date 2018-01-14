package yncrea.pw01.controller;

import yncrea.pw01.model.Drug;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/drugs")
public class DrugsServlet extends HttpServlet {
    private List<Drug> drugs;

    public void init() throws ServletException{
        this.drugs = new ArrayList<>();
        this.drugs.add(new Drug("Drug1", "Lab1"));
        this.drugs.add(new Drug("Drug2", "Lab2"));
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("drugs", drugs);
        req.getRequestDispatcher("/DrugsList.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String lab = request.getParameter("lab");
        this.drugs.add(new Drug(name, lab));
        response.sendRedirect(request.getServletContext().getContextPath() + "/drugs");
    }
}
