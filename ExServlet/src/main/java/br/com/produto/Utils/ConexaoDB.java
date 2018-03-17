/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author bruno.falmeida
 */
public class ConexaoDB {
    //Obtem uma conexao
    public static Connection getConnection() throws ClassNotFoundException{
        
        String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
        Class.forName(driverName);
    
        // Conexao para abertura e fechamento
        Connection connection = null;
        try {
            // Só tenta abrir conecao caso nao exista nenhuma aberta
            String dbURL = Constants.DB_ADRESS;
            //Propriedades para guarda usuario e senha
            Properties properties = new Properties();
            properties.put("user", Constants.DB_USER);
            properties.put("password", Constants.DB_PASS);
            // realiza conexao com banco
            connection = DriverManager.getConnection(dbURL, Constants.DB_USER, Constants.DB_PASS);

        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return connection;
    }
}