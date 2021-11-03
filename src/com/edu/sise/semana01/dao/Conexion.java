/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.semana01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class Conexion {
    
    //url conexión
    //usuario
    //clave
    //Driver de conexión (Mysql/Oracle/SQL SERVER/Postgres....)
    private static String urlMySQL ="jdbc:mysql://localhost:3306/lpjava1642";
    private static String urlSQLSERVER ="jdbc:sqlserver://localhost:1433;databaseName=demo;user=sa;password=Sise2021$;";
    private static String usuarioMySQL="root";
    private static String passwordMySQL="123456";
    private static String driverMySQL = "com.mysql.cj.jdbc.Driver";
    private static String driverSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    Connection connMySQL = null;
    Connection connSQLSERVER = null;
    
    static{
        try {
            Class.forName(driverMySQL);
            Class.forName(driverSQL);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de conexión: " + ex);
        }
    }
    
    public Connection getCnxMySQL(){
        
        try {
            connMySQL = DriverManager.getConnection(urlMySQL, usuarioMySQL, passwordMySQL);
            //conn = DriverManager.getConnection(urlSQL);
        } catch (SQLException ex) {
            System.out.println("Error en DriverManager: " +  ex);
        }
        return connMySQL;
    }
    
        public Connection getCnxSQLSERVER(){
        
        try {
            connSQLSERVER = DriverManager.getConnection(urlSQLSERVER);
        } catch (SQLException ex) {
            System.out.println("Error en DriverManager: " +  ex);
        }
        return connSQLSERVER;
    }
}
