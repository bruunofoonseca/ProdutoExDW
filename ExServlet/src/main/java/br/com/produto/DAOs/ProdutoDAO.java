/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.DAOs;

import br.com.produto.Utils.ConexaoDB;
import br.com.produto.Models.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno Fonseca
 */
public class ProdutoDAO {
    // insere um produto na tabela produto
    public static void inserir(ProdutoModel produto)
            throws SQLException, ClassNotFoundException{
        
        // construindo a strin de inserção no BD na tabela produto
        String sql = "INSERT INTO produto (NOME, DESCRICAO, PRECO_COMPRA, "
                + "PRECO_VENDA, QUANTIDADE, DT_CADASTRO)" 
                + " VALUES (?, ?, ?, ?, ?, ?)";
        
        // conexao para abertura e fechamento do BD
        Connection connection = null;
        
        // Statement para obtenção atraves da conexão, execuçao
        // comandos SQL
        PreparedStatement preparedStatement = null;
        
        try {
            // abrindo conexão
            connection = ConexaoDB.getConnection();

            // criar um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            // configura os parametros do preparedStatement
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setFloat(3, produto.getPrecoCompra());
            preparedStatement.setFloat(4, produto.getPrecoVenda());
            preparedStatement.setInt(5, produto.getQuantidade());
            Timestamp t = new Timestamp(produto.getDtCadastro().getTime());
            preparedStatement.setTimestamp(6, t);
            
            // executa o comando SQL
            preparedStatement.execute();
        } finally{
            // Se o preparedStatement ainda estiver aberto, realiza fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
    
    // Realiza a atualização do produto, conforme ID e dados
    // passados como parametros
    public static void atualizar(ProdutoModel produto)
            throws SQLException, Exception {
        // String de update no BD
        String sql = "UPDATE produto SET NOME=?, DESCRICAO=?, PRECO_COMPRA=?, "
                + "PRECO_VENDA=?, QUANTIDADE=?, DT_CADASTRO=?"
                + "WHERE ID=?";
        
        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            // abrindo conexão
            connection = ConexaoDB.getConnection();
            
            // Criar um preparedStatement para executar instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            // configurando os parametros para update
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getDescricao());
            preparedStatement.setFloat(3, produto.getPrecoCompra());
            preparedStatement.setFloat(4, produto.getPrecoVenda());
            preparedStatement.setFloat(5, produto.getQuantidade());
            Timestamp t = new Timestamp(produto.getDtCadastro().getTime());
            preparedStatement.setTimestamp(6, t);
            preparedStatement.setInt(7, produto.getId());
            
             //Executa o comando no banco de dados
            preparedStatement.execute();
        } 
        catch (Exception e) {
            // imprimir erro tecnico no consile
            e.printStackTrace();
        }
        finally {
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    // Realiza a exclusão logica de um produto, no BD
    // como parametro. A exclusão apenas ira INATIVAR o 
    // produto em todas as tela de pesquisa
    public static void excluir(int id) throws SQLException, Exception{
        // String de exclusão, a partir de um ID
        String sql = "DELETE FROM produto WHERE ID=?";
        
        // conexão para abertura e fechamento no BD
         Connection connection = null;
         
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um preparedStatement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do prepared preparedStatement
            preparedStatement.setInt(1, id);

            // executa o comando no BD
            preparedStatement.execute();
    } finally {
            //Se o preparedStatement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static List<ProdutoModel> listar()
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto";

        List<ProdutoModel> listaProdutos = null;

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }

                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("ID"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));
                produto.setPrecoCompra(result.getFloat("PRECO_COMPRA"));
                produto.setPrecoVenda(result.getFloat("PRECO_VENDA"));
                produto.setQuantidade(result.getInt("QUANTIDADE"));
                Date d = new Date(result.getTimestamp("DT_CADASTRO").getTime());
                produto.setDtCadastro(d);

                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Retorna a lista de clientes do banco de dados
        return listaProdutos;
    }

    public static List<ProdutoModel> procurar(String nome)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto "
                + "WHERE (UPPER(NOME) LIKE UPPER(?))";

        List<ProdutoModel> listaProdutos = null;

        //Conexão para abertura e fechamento
        Connection connection = null;
        
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();
            
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + nome + "%");
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }

                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("ID"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));
                produto.setPrecoCompra(result.getFloat("PRECO_COMPRA"));
                produto.setPrecoVenda(result.getFloat("PRECO_VENDA"));
                produto.setQuantidade(result.getInt("QUANTIDADE"));
                Date d = new Date(result.getTimestamp("DT_CADASTRO").getTime());
                produto.setDtCadastro(d);

                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        return listaProdutos;        
    }

    public static ProdutoModel obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produto WHERE ID=?";

        //Conexão para abertura e fechamento
        Connection connection = null;

        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;

        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConexaoDB.getConnection();

            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                ProdutoModel produto = new ProdutoModel();
                produto.setId(result.getInt("ID"));
                produto.setNome(result.getString("NOME"));
                produto.setDescricao(result.getString("DESCRICAO"));
                produto.setPrecoCompra(result.getFloat("PRECO_COMPRA"));
                produto.setPrecoVenda(result.getFloat("PRECO_VENDA"));
                produto.setQuantidade(result.getInt("QUANTIDADE"));
                Date d = new Date(result.getTimestamp("DT_CADASTRO").getTime());
                produto.setDtCadastro(d);
                
                //Retorna o resultado
                return produto;
            }            
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }
}