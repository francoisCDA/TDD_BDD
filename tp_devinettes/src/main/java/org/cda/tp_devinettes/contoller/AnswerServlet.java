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

@WebServlet(name = "answer", value = "/answer")
public class AnswerServlet extends HttpServlet {

    private DevinetteService devinetteService;

    private Devinette riddle;

    private Reponse userAnswer;

    @Override
    public void init() throws ServletException {
        devinetteService = DevinetteService.get();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int riddleId = Integer.parseInt(req.getParameter("id"));

        riddle = devinetteService.getRiddleById(riddleId);

        if (riddle != null) {
            req.setAttribute("riddle",riddle);
            req.getRequestDispatcher(PathViews.find("guess.jsp")).forward(req,resp);
        } else {
            String error = "Devinette non trouvée";
            req.setAttribute("error",error);
            req.getRequestDispatcher(PathViews.find("errorpage.jsp")).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idRiddle = Integer.parseInt(req.getParameter("id"));
        String userGuess = req.getParameter("useranswer");

        if(riddle == null) {
            riddle = devinetteService.getRiddleById(idRiddle);
        }

        Reponse userAnswer = Reponse.builder().devinette(riddle).userAnswer(userGuess).build();

        if (!devinetteService.saveUserAnswer(userAnswer)) {
            String error = "problème d'enregistrement";
            req.setAttribute("error",error);
            req.getRequestDispatcher(PathViews.find("errorpage.jsp")).forward(req,resp);
        }

        String resultat = "perdu";
        if (devinetteService.userTry(userAnswer)) {
            resultat = "bien joué";
        }

        req.setAttribute("result",resultat);

    }
}
