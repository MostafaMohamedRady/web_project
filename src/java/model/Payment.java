/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bakar M.M.R
 */
@Entity
@Table(name = "payment", catalog = "web_project", schema = "")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpayment")
    private Integer idpayment;
    @Basic(optional = false)
    @Column(name = "payment_total")
    private float paymentTotal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payment_discount")
    private Float paymentDiscount;
    @Basic(optional = false)
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    @ManyToOne
    private Users usersIdusers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentIdpayment")
    private Collection<CartProduct> cartProductCollection;

    public Payment() {
    }

    public Payment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Payment(Integer idpayment, float paymentTotal, Date paymentDate) {
        this.idpayment = idpayment;
        this.paymentTotal = paymentTotal;
        this.paymentDate = paymentDate;
    }

    public Integer getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public float getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(float paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    public Float getPaymentDiscount() {
        return paymentDiscount;
    }

    public void setPaymentDiscount(Float paymentDiscount) {
        this.paymentDiscount = paymentDiscount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Users getUsersIdusers() {
        return usersIdusers;
    }

    public void setUsersIdusers(Users usersIdusers) {
        this.usersIdusers = usersIdusers;
    }

    public Collection<CartProduct> getCartProductCollection() {
        return cartProductCollection;
    }

    public void setCartProductCollection(Collection<CartProduct> cartProductCollection) {
        this.cartProductCollection = cartProductCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpayment != null ? idpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idpayment == null && other.idpayment != null) || (this.idpayment != null && !this.idpayment.equals(other.idpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Payment[ idpayment=" + idpayment + " ]";
    }
    
}
