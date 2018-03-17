/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.Servlets;

import br.com.produto.DAOs.ProdutoDAO;
import br.com.produto.Models.ProdutoModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diogo
 */
@WebServlet(name = "ListarProduto", urlPatterns = {"/listarTodosProdutos"})
public class ListarProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        ProdutoDAO daoProduto = new ProdutoDAO();
        List<ProdutoModel> produtos;
        ProdutoModel produto;
        
            // direciono a url chamada para a classe correta
            switch(destino){
//                case "/exibirProduto":
//                     System.out.println("entrei exibir Produto");
//                    try{
//                        
//                        String nomePesquisaProduto = request.getParameter("Nome");
//                        
//                        if(nomePesquisaProduto != null){
//                            produtos = daoProduto.procurar(nomePesquisaProduto);
//                            request.setAttribute("pesquisa", produtos);
//                            
//                        }else{
//                            request.setAttribute("msgErroBusca", "Sua busca não gerou resultados!");
//                                   
//                        }
//                        
//                        request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp").forward(request, response);
//                        
//                    }catch(SQLException | ServletException | IOException e){
//                        System.out.println("Erro -> " + e);
//                    } catch (Exception ex) {
//                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                break;   
                case "/listarTodosProdutos":
                    
                    try {

                        produtos = ProdutoDAO.listar();
                         
                        if(produtos != null){
                            request.setAttribute("pesquisa", produtos);
                            
                        }else{
                            request.setAttribute("msgErroBusca", "Sua busca no gerou resultado");
                            
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/jsp/listarProduto.jsp").forward(request, response);
                        
                    } catch(SQLException | ServletException | IOException e){
                        System.out.println("Erro -> " + e);
                    } catch (Exception ex) {
//                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                break;  
                    }
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
