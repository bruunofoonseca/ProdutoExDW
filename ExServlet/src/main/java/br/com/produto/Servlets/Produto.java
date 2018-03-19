package br.com.produto.Servlets;

import br.com.produto.DAOs.CategoriaDAO;
import br.com.produto.DAOs.ProdutoDAO;
import br.com.produto.Models.CategoriaModel;
import br.com.produto.Models.ProdutoModel;
import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diogo.sfelix
 */
@WebServlet(name = "Produto", urlPatterns = {"/cadastrarProduto"})
public class Produto extends HttpServlet {
    
    String data;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher requestDispatcher;

        if (request.getParameterMap().containsKey("id")) {
            if(!request.getParameter("id").isEmpty()){
                int idProduto = Integer.parseInt(request.getParameter("id"));

                ProdutoModel produto = null;
                try {
                    produto = ProdutoDAO.obter(idProduto);
                } catch(Exception e) {
                    System.out.println(e);
                }

                request.setAttribute("produto", produto);
            }
        }

        List<CategoriaModel> listaCategorias = null;
        try {
            listaCategorias = CategoriaDAO.listar();
        } catch(Exception e) {
            System.out.println(e);
        }

        request.setAttribute("categorias", listaCategorias);

        requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastrarProduto.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pego a url chamada pelo menuPrincipal
        String destino = request.getServletPath();
        RequestDispatcher requestDispatcher;
        
        ProdutoModel produto;
        
        if(request.getParameter("id").isEmpty()){
            try{  
                String nome = request.getParameter("Nome");
                String descricao = request.getParameter("descricao");
                float precoCompra = Float.parseFloat(request.getParameter("precoCompra"));
                float precoVenda = Float.parseFloat(request.getParameter("precoVenda"));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                int idCat = Integer.parseInt(request.getParameter("categoria"));
                
                CategoriaModel categoria = CategoriaDAO.obter(idCat);
                Date today = new Date();

                produto = new ProdutoModel();
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setPrecoCompra(precoCompra);
                produto.setPrecoVenda(precoVenda);
                produto.setQuantidade(quantidade);
                produto.setDtCadastro(today);
                produto.setCategorias(categoria);

                ProdutoDAO.inserir(produto);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                requestDispatcher.forward(request, response);

            }catch(ClassNotFoundException | IllegalArgumentException | SQLException e) {
            System.out.println("Erro" + e);

            request.setAttribute("msg", e);
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
            requestDispatcher.forward(request, response);

            } catch (Exception ex) {
//                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
            
            try{
                String nome = request.getParameter("Nome");
                String descricao = request.getParameter("descricao");
                float precoCompra = Float.parseFloat(request.getParameter("precoCompra"));
                float precoVenda = Float.parseFloat(request.getParameter("precoVenda"));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                int idCat = Integer.parseInt(request.getParameter("categoria"));
                
                CategoriaModel categoria = CategoriaDAO.obter(idCat);
                Date today = new Date();

                produto = new ProdutoModel();

                produto.setId(Integer.parseInt(request.getParameter("id")));
                produto.setNome(nome);
                produto.setDescricao(descricao);
                produto.setPrecoCompra(precoCompra);
                produto.setPrecoVenda(precoVenda);
                produto.setQuantidade(quantidade);
                produto.setDtCadastro(today);
                produto.setCategorias(categoria);

                ProdutoDAO.atualizar(produto);

                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroSucess.jsp");
                requestDispatcher.forward(request, response);

            } catch (ClassNotFoundException | IllegalArgumentException | SQLException e) {
                System.out.println("Erro" + e);

                request.setAttribute("msg", e);
                requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cadastroDanger.jsp");
                requestDispatcher.forward(request, response);

            } catch (Exception ex) {    
//                Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
};
