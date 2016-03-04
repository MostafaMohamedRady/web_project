/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Collection;

/**
 *
 * @author Bakar M.M.R
 */

public class Categories {
    private static final long serialVersionUID = 1L;
   
    private int idcategory;
   
    private String categoryName;
  
    private Collection<Product> productCollection;

    public Categories() {
    }

    public Categories(int idcategory) {
        this.idcategory = idcategory;
    }

    public Categories(int idcategory, String categoryName) {
        this.idcategory = idcategory;
        this.categoryName = categoryName;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

}
