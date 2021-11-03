/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.semana01.dao.mysql;

import com.edu.sise.semana01.dao.DAOException;
import com.edu.sise.semana01.dao.IEmpleadoDAO;
import com.edu.sise.semana01.entity.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class MySQLEmpleadoDAO implements IEmpleadoDAO{

    //variable finales
    final String INSERT = "INSERT INTO empleados(id_empleado, nombre, ape_pat, ape_mat, fnacimiento, sueldo) "
            + " VALUES(?, ?, ?, ?, ?, ?)";
    final String GETALL = "SELECT * FROM empleados";
    
    private Connection cn;
    
    public MySQLEmpleadoDAO(Connection cn){
        this.cn =cn;
    }
    
    @Override
    public void insertar(Empleado o) throws DAOException{
        PreparedStatement ps = null;
        ResultSet rs =  null;
        try {
            ps = cn.prepareStatement(INSERT);
            int i = 1;
            ps.setInt(i++, o.getId_empleado());
            ps.setString(i++, o.getNombre());
            ps.setString(i++, o.getApe_pat());
            ps.setString(i++, o.getApe_mat());
            ps.setDate(i++, Date.valueOf(o.getFnacimiento()));
            ps.setDouble(i++, o.getSueldo());
            if(ps.executeUpdate()==0)
                throw new DAOException("No se pudo realizar el registro!!!");
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                o.setId_empleado(rs.getInt(1));
            }else{
                throw new DAOException("No se puede asignar ID");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        }finally{
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
                //if(cn!=null) cn.close();
            }catch(SQLException ex){
                throw new DAOException("Error en SQL", ex);
            }
        }
        
    }

    @Override
    public void modificar(Empleado o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Empleado o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> listarTodos() throws DAOException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Empleado> lista = new ArrayList<>();
        try{
            ps = cn.prepareStatement(GETALL);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(getRS(rs));
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        }finally{
            try{
                if(rs!=null) rs.close();
                if(ps!=null) ps.close();
                //if(cn!=null) cn.close();
            }catch(SQLException ex){
                throw new DAOException("Error en SQL", ex);
            }
        }
        return lista;
    }

    @Override
    public Empleado obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Empleado getRS(ResultSet rs) throws SQLException{
        return new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("nombre"),
                rs.getString("ape_pat"),
                rs.getString("ape_mat"),
                rs.getDate("fnacimiento").toLocalDate(),
                rs.getDouble("sueldo")
        );
    }
    
}
