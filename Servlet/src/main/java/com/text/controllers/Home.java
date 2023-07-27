package com.text.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/"},loadOnStartup = 1)
public class Home extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hellooooooooo");

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/com" +
                "/text/view/index.html");

        requestDispatcher.forward(req, resp);
    }
}
