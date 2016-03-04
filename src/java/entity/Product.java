/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Bakar M.M.R
 */
public class Product implements Serializable {

    protected ProductPK productPK;
    
    private String productName;
   
    private Float productPrice;
   
    private String productDescription;
 
    private int productCount;
   
    private String productImg;
   
    private int productQuntityavailable;
  
    private int productQuntitysold;

    private Date productLastmodify;

    private String productOptions;

    private String productColor;

    private String productSize;
  
    private Categories categories;

    private Collection<CartProduct> cartProductCollection;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(ProductPK productPK, String productName) {
        this.productPK = productPK;
        this.productName = productName;
    }

    public Product(int idproduct, int categoriesIdcategory) {
        this.productPK = new ProductPK(idproduct, categoriesIdcategory);
    }

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getProductQuntityavailable() {
        return productQuntityavailable;
    }

    public void setProductQuntityavailable(int productQuntityavailable) {
        this.productQuntityavailable = productQuntityavailable;
    }

    public int getProductQuntitysold() {
        return productQuntitysold;
    }

    public void setProductQuntitysold(int productQuntitysold) {
        this.productQuntitysold = productQuntitysold;
    }

    public Date getProductLastmodify() {
        return productLastmodify;
    }

    public void setProductLastmodify(Date productLastmodify) {
        this.productLastmodify = productLastmodify;
    }

    public String getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(String productOptions) {
        this.productOptions = productOptions;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Collection<CartProduct> getCartProductCollection() {
        return cartProductCollection;
    }

    public void setCartProductCollection(Collection<CartProduct> cartProductCollection) {
        this.cartProductCollection = cartProductCollection;
    }

}
