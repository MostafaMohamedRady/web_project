/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.CartProduct;
import entity.Users;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class CartProductDao implements DoaInterface<CartProduct> {

    PreparedStatement statment;
    CartProduct cartProduct;

    @Override
    public int insert(CartProduct bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("insert into cart_peoduct"
                    + "(cart_peoduct_mount,cart_peoduct_date,payment_idpayment,product_idproduct,users_idusers)"
                    + " values (?,?,?,?,?)");
            statment.setInt(1, bean.getCartProductMount());
            statment.setDate(2, Date.valueOf(LocalDate.now()));
            statment.setInt(3, bean.getPaymentIdpayment().getIdpayment());
            statment.setInt(4, bean.getProduct().getIdproduct());
            statment.setFloat(5, bean.getUsersIdusers().getIdusers());
            check = statment.executeUpdate();

            System.out.println("insert" + check);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int update(CartProduct bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(CartProduct bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CartProduct selectById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CartProduct selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartProduct> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public float sumCart(int idUser) {
        float sum=0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select sum(select product_price*cart_product_mount "
                    + "from product,cart_product"
                    + " where idproduct=product_idproduct) from cart_product"
                    + "where users_idusers=?");
            statment.setInt(1, idUser);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                sum=result.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

}
