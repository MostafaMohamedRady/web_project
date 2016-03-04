/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bakar M.M.R
 */
@Entity
@Table(name = "cart_product", catalog = "web_project", schema = "")
@NamedQueries({
    @NamedQuery(name = "CartProduct.findAll", query = "SELECT c FROM CartProduct c")})
public class CartProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcart_product")
    private Integer idcartProduct;
    @Basic(optional = false)
    @Column(name = "cart_product_mount")
    private int cartProductMount;
    @Basic(optional = false)
    @Column(name = "cart_product_date")
    @Temporal(TemporalType.DATE)
    private Date cartProductDate;
    @JoinColumn(name = "payment_idpayment", referencedColumnName = "idpayment")
    @ManyToOne(optional = false)
    private Payment paymentIdpayment;
    @JoinColumns({
        @JoinColumn(name = "product_idproduct", referencedColumnName = "idproduct"),
        @JoinColumn(name = "product_categories_idcategory", referencedColumnName = "categories_idcategory")})
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users usersIdusers;

    public CartProduct() {
    }

    public CartProduct(Integer idcartProduct) {
        this.idcartProduct = idcartProduct;
    }

    public CartProduct(Integer idcartProduct, int cartProductMount, Date cartProductDate) {
        this.idcartProduct = idcartProduct;
        this.cartProductMount = cartProductMount;
        this.cartProductDate = cartProductDate;
    }

    public Integer getIdcartProduct() {
        return idcartProduct;
    }

    public void setIdcartProduct(Integer idcartProduct) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcartProduct != null ? idcartProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartProduct)) {
            return false;
        }
        CartProduct other = (CartProduct) object;
        if ((this.idcartProduct == null && other.idcartProduct != null) || (this.idcartProduct != null && !this.idcartProduct.equals(other.idcartProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CartProduct[ idcartProduct=" + idcartProduct + " ]";
    }
    
}
