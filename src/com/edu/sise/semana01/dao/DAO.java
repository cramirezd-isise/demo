/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.sise.semana01.dao;

import java.util.List;

/**
 *
 * @author Carlos
 */
public interface DAO<T,K> {
    void insertar(T o) throws Exception;
    void modificar(T o)throws Exception;
    void eliminar(T o) throws Exception;
    List<T> listarTodos() throws Exception;
    T obtener(K id) throws Exception;
}
