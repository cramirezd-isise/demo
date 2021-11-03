/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.semana01.dao.mysql;

import com.edu.sise.semana01.dao.Conexion;
import com.edu.sise.semana01.dao.IDAOManager;
import com.edu.sise.semana01.dao.IEmpleadoDAO;
import com.edu.sise.semana01.dao.mysql.MySQLEmpleadoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlos
 */
public class MySQLDAOManager implements IDAOManager{
    
    private static final MySQLDAOManager instance = new MySQLDAOManager();
    
    private Connection cn;
    private IEmpleadoDAO empleadoDao = null;
    
    private MySQLDAOManager(){
        cn = new Conexion().getCnxMySQL();
    }
    
    public static MySQLDAOManager getInstance(){
        return instance;
    }
    

    @Override
    public IEmpleadoDAO getEmpleadoDAO() {
        if(empleadoDao == null){
            empleadoDao= new MySQLEmpleadoDAO(cn);
        }
        return empleadoDao;
    }
}
