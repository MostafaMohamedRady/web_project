/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bakar M.M.R
 */
@Embeddable
public class ProductPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idproduct")
    private int idproduct;
    @Basic(optional = false)
    @Column(name = "categories_idcategory")
    private int categoriesIdcategory;

    public ProductPK() {
    }

    public ProductPK(int idproduct, int categoriesIdcategory) {
        this.idproduct = idproduct;
        this.categoriesIdcategory = categoriesIdcategory;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public int getCategoriesIdcategory() {
        return categoriesIdcategory;
    }

    public void setCategoriesIdcategory(int categoriesIdcategory) {
        this.categoriesIdcategory = categoriesIdcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproduct;
        hash += (int) categoriesIdcategory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPK)) {
            return false;
        }
        ProductPK other = (ProductPK) object;
        if (this.idproduct != other.idproduct) {
            return false;
        }
        if (this.categoriesIdcategory != other.categoriesIdcategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProductPK[ idproduct=" + idproduct + ", categoriesIdcategory=" + categoriesIdcategory + " ]";
    }
    
}
