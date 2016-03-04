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

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idusers;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userAddress;

    private String userMobile;

    private int userSsn;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
 
    private Float userCharge;
  
    private Date userRegdate;

    private String userJob;

    private Integer userZip;

    private Collection<Payment> paymentCollection;

    private Collection<CartProduct> cartProductCollection;

    public Users() {
    }

    public Users(Integer idusers) {
        this.idusers = idusers;
    }

    public Users(Integer idusers, String userName, String userPassword, String userEmail, int userSsn, Date userRegdate) {
        this.idusers = idusers;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userSsn = userSsn;
        this.userRegdate = userRegdate;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public int getUserSsn() {
        return userSsn;
    }

    public void setUserSsn(int userSsn) {
        this.userSsn = userSsn;
    }

    public Float getUserCharge() {
        return userCharge;
    }

    public void setUserCharge(Float userCharge) {
        this.userCharge = userCharge;
    }

    public Date getUserRegdate() {
        return userRegdate;
    }

    public void setUserRegdate(Date userRegdate) {
        this.userRegdate = userRegdate;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public Integer getUserZip() {
        return userZip;
    }

    public void setUserZip(Integer userZip) {
        this.userZip = userZip;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
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
        hash += (idusers != null ? idusers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idusers == null && other.idusers != null) || (this.idusers != null && !this.idusers.equals(other.idusers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Users[ idusers=" + idusers + " ]";
    }
    
}
