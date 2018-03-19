/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diogo.felix
 */
@WebServlet(name = "Rota", urlPatterns = {"/Rota","/ListarProd","/CadastrarProd","/PaginaInicial"})
public class Rota extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        switch(destino){
            case "/Rota":
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
                requestDispatcher.forward(request, response);
            break;
            case "/ListarProd":
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp");
                requestDispatcher.forward(request, response);
            break;
             case "/CadastrarProd":
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
                requestDispatcher.forward(request, response);
            break;
            case "/PaginaInicial":
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
            break;
        }

    }
}