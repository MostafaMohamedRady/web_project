/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Bakar M.M.R
 */
public class CartProduct {


    private int idcartProduct;

    private int cartProductMount;

    private Date cartProductDate;

    private Payment paymentIdpayment;

    private Product product;

    private Users usersIdusers;

    public CartProduct() {
    }

    public int getIdcartProduct() {
        return idcartProduct;
    }

    public void setIdcartProduct(int idcartProduct) {
        this.idcartProduct = idcartProduct;
    }

    public int getCartProductMount() {
        return cartProductMount;
    }

    public void setCartProductMount(int cartProductMount) {
        this.cartProductMount = cartProductMount;
    }

    public Date getCartProductDate() {
        return cartProductDate;
    }

    public void setCartProductDate(Date cartProductDate) {
        this.cartProductDate = cartProductDate;
    }

    public Payment getPaymentIdpayment() {
        return paymentIdpayment;
    }

    public void setPaymentIdpayment(Payment paymentIdpayment) {
        this.paymentIdpayment = paymentIdpayment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Users getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(Users usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

}
