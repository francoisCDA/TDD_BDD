package org.cda.tp_devinettes.contoller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cda.tp_devinettes.entity.Devinette;
import org.cda.tp_devinettes.entity.Reponse;
import org.cda.tp_devinettes.service.DevinetteService;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // proposition de réponse


    }
}
