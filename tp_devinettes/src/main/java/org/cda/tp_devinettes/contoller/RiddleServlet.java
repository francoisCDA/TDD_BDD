package org.cda.tp_devinettes.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.service.DevinetteService;
import org.cda.tp_devinettes.util.PathViews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "riddle", value = "/riddle")
public class RiddleServlet extends HttpServlet {

    private DevinetteService devinetteService;

    private List<Devinette> riddleList;
    private Devinette riddle;

    @Override
    public void init() throws ServletException {
        devinetteService = DevinetteService.get();
        riddleList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // affichage des devinettes

        riddleList = devinetteService.getAllRiddles();
        req.setAttribute("riddles",riddleList);
        req.getRequestDispatcher(PathViews.find("riddle.jsp")).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // gestion formulaire nouvelle devinette
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String newRiddle = req.getParameter("question");
        String newAnswer = req.getParameter("answer");

        String error = devinetteService.newRiddle(newRiddle,newAnswer);

        if (error == null) {
            doGet(req,resp);
        } else {
            req.setAttribute("error",error);
            req.getRequestDispatcher(PathViews.find("errorpage.jsp")).forward(req,resp);
        }

    }


}
