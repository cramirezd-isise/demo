/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.semana01.logic;

import com.edu.sise.semana01.dao.IEmpleadoDAO;
import com.edu.sise.semana01.dao.mysql.MySQLDAOManager;
import com.edu.sise.semana01.entity.Empleado;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos
 */
public class EmpleadoLogic {
  
    MySQLDAOManager factory = MySQLDAOManager.getInstance();
    IEmpleadoDAO dao = factory.getEmpleadoDAO();
    
    
     public DefaultTableModel listarTodos() throws Exception{
         DefaultTableModel modelo = new DefaultTableModel();
         modelo.addColumn("ID");
         modelo.addColumn("NOMBRE");
         modelo.addColumn("CLAVE");
         
         List<Empleado> lista = dao.listarTodos();
         for(Empleado objEmpleado : lista){
             Object data[] ={
                 objEmpleado.getId_empleado(),
                 objEmpleado.getNombre(),
                 objEmpleado.getApe_pat(),
                 objEmpleado.getApe_mat(),
                 objEmpleado.getNombre(),
                 objEmpleado.getFnacimiento(),
                 objEmpleado.getSueldo()
             };
             modelo.addRow(data);
         }
         
         return modelo;
     }
    public void imprimirTB(JTable jTable) throws Exception{
        jTable.setModel(listarTodos());
    }
     

}
