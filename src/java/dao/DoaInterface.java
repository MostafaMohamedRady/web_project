/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Bakar M.M.R
 */
public interface DoaInterface<T> {
    int insert();
    int update();
    int delete();
    T selectById(T bean);
    T selectByName(T bean);
    T selectAll();
}
