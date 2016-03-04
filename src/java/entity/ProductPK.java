/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Bakar M.M.R
 */

public class ProductPK {
   
    private int idproduct;

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

}
