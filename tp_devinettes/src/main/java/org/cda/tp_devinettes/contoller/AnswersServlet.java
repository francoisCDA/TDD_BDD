package org.cda.tp_devinettes.contoller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.service.DevinetteService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "answers", value ="/answers")
public class AnswersServlet extends HttpServlet {

    private DevinetteService devinetteService;

    private List<Reponse> answerList;

    @Override
    public void init() throws ServletException {
        devinetteService = DevinetteService.get();
        answerList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idRiddle = Integer.parseInt(req.getParameter("id"));

        answerList = devinetteService.getAnswersByRiddleId(idRiddle);



    }
}
