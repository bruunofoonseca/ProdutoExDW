/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.DAOs;

import br.com.produto.Utils.ConexaoDB;
import br.com.produto.Models.CategoriaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno.falmeida
 */
public class CategoriaDAO {
    public static List<CategoriaModel> listar()
            throws SQLException, Exception {

        String sql = "SELECT * FROM categoria";

        List<CategoriaModel> listaCategorias = null;

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
                if (listaCategorias == null) {
                    listaCategorias = new ArrayList<>();
                }

                CategoriaModel produto = new CategoriaModel();
                produto.setId(result.getInt("ID"));
                produto.setNome(result.getString("NOME"));

                //Adiciona a instância na lista
                listaCategorias.add(produto);
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
        return listaCategorias;
    }
    
        public static List<CategoriaModel> listarByID(int idProd)
            throws SQLException, Exception {

        String sql = "SELECT c.id, c.nome FROM PRODUTO_CATEGORIA pc WHERE ID_PRODUTO = ?"
                + "INNER JOIN categoria c on c.id = pc.ID_CATEGORIA";

        List<CategoriaModel> listaCategorias = null;

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
                if (listaCategorias == null) {
                    listaCategorias = new ArrayList<>();
                }

                CategoriaModel produto = new CategoriaModel();
                produto.setId(result.getInt("ID"));
                produto.setNome(result.getString("NOME"));

                //Adiciona a instância na lista
                listaCategorias.add(produto);
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
        return listaCategorias;
    }

    public static List<CategoriaModel> procurar(String nome)
            throws SQLException, Exception {

        String sql = "SELECT * FROM categoria "
                + "WHERE (UPPER(NOME) LIKE UPPER(?))";

        List<CategoriaModel> listaCategorias = null;

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
                if (listaCategorias == null) {
                    listaCategorias = new ArrayList<>();
                }

                CategoriaModel categoria = new CategoriaModel();
                categoria.setId(result.getInt("ID"));
                categoria.setNome(result.getString("NOME"));

                //Adiciona a instância na lista
                listaCategorias.add(categoria);
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

        return listaCategorias;        
    }

    public static CategoriaModel obter(Integer id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM categoria WHERE ID=?";

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
                CategoriaModel categoria = new CategoriaModel();
                categoria.setId(result.getInt("ID"));
                categoria.setNome(result.getString("NOME"));
                
                //Retorna o resultado
                return categoria;
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