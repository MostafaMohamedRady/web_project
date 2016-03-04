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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "product", catalog = "web_project", schema = "")
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Basic(optional = false)
    @Column(name = "product_name")
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_price")
    private Float productPrice;
    @Lob
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_count")
    private Integer productCount;
    @Column(name = "product_img")
    private String productImg;
    @Column(name = "product_quntityavailable")
    private Integer productQuntityavailable;
    @Column(name = "product_quntitysold")
    private Integer productQuntitysold;
    @Column(name = "product_lastmodify")
    @Temporal(TemporalType.DATE)
    private Date productLastmodify;
    @Column(name = "product_options")
    private String productOptions;
    @Column(name = "product_color")
    private String productColor;
    @Column(name = "product_size")
    private String productSize;
    @JoinColumn(name = "categories_idcategory", referencedColumnName = "idcategory", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categories categories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
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

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Integer getProductQuntityavailable() {
        return productQuntityavailable;
    }

    public void setProductQuntityavailable(Integer productQuntityavailable) {
        this.productQuntityavailable = productQuntityavailable;
    }

    public Integer getProductQuntitysold() {
        return productQuntitysold;
    }

    public void setProductQuntitysold(Integer productQuntitysold) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPK != null ? productPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productPK == null && other.productPK != null) || (this.productPK != null && !this.productPK.equals(other.productPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ productPK=" + productPK + " ]";
    }
    
}
