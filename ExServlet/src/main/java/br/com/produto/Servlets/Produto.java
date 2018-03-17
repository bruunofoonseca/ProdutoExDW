//package br.com.produto.Servlets;
//
//import br.com.produto.DAOs.ProdutoDAO;
//import br.com.produto.Models.ProdutoModel;
//import java.io.IOException;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author diogo.sfelix
// */
//@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto"})
//public class Produto extends HttpServlet {
//    
//    String data;
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        RequestDispatcher requestDispatcher;
//
//        if(!request.getParameter("idProduto").isEmpty()){
//            int idProduto = Integer.parseInt(request.getParameter("idProduto"));
//
//            ProdutoModel produto = null;
//            try {
//                produto = ProdutoDAO.obter(idProduto);
//            } catch(Exception e) {
//                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
//            }
//
//            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
//            data = dt1.format(produto.getDtFabricacao());
//
//            request.setAttribute("data", data);
//            request.setAttribute("produto", produto);
//
//            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
//            requestDispatcher.forward(request, response);
//        }
//        
//        
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // pego a url chamada pelo menuPrincipal
//        String destino = request.getServletPath();
//        RequestDispatcher requestDispatcher;
//        
//        ProdutoModel produto;
//        
//        if(request.getParameter("idProd").isEmpty()){
////            System.out.println("Vou inserir");
//            try{  
//                String nome = request.getParameter("Nome");
//                String fabricante = request.getParameter("Fabricante");
//                String tipoProduto = request.getParameter("TipoProduto");
//                int qtdProduto = Integer.parseInt(request.getParameter("qtdProduto"));
//                float valorProduto = Float.parseFloat(request.getParameter("valor"));
//                Date dtFabricacao = Date.valueOf(request.getParameter("dtFabricacao"));
//                int garantia = Integer.parseInt(request.getParameter("garantia"));
//
//                produto = new ProdutoModel(
//                nome, fabricante, tipoProduto, qtdProduto, valorProduto, dtFabricacao, garantia
//                );
//
//                ProdutoDAO.inserir(produto);
//                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
//                requestDispatcher.forward(request, response);
//
//            }catch(ClassNotFoundException | IllegalArgumentException | SQLException e) {
//            System.out.println("Erro" + e);
//
//            request.setAttribute("msg", e);
//            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
//            requestDispatcher.forward(request, response);
//
//            } catch (Exception ex) {
//                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
////            System.out.println("Vou atualizar");
//            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
//            
//            try{
//                String nome = request.getParameter("Nome");
//                String fabricante = request.getParameter("Fabricante");
//                String tipoProduto = request.getParameter("TipoProduto");
//                int qtdProduto = Integer.parseInt(request.getParameter("qtdProduto"));
//                float valorProduto = Float.parseFloat(request.getParameter("valor"));
//                String dtFabricacao;
//                if(!request.getParameter("dtFabricacao").isEmpty()){
//                    dtFabricacao = request.getParameter("dtFabricacao");
//                } else {
//                    dtFabricacao = data;
//                }
//                int garantia = Integer.parseInt(request.getParameter("garantia"));
//
//                produto = new ProdutoModel(
//                    nome, fabricante, tipoProduto, qtdProduto, valorProduto, dt1.parse(dtFabricacao), garantia
//                );
//
//                produto.setId(Integer.parseInt(request.getParameter("idProd")));
//
//                ProdutoDAO.atualizar(produto);
//
//                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
//                requestDispatcher.forward(request, response);
//
//            } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
//                System.out.println("Erro" + e);
//
//                request.setAttribute("msg", e);
//                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
//                requestDispatcher.forward(request, response);
//
//            } catch (Exception ex) {    
//                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//}