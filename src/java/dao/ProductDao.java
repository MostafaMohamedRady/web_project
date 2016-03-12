/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class ProductDao implements DoaInterface<Product>{

    PreparedStatement statment;
    Product product;

    
    @Override
    public int insert(Product bean) {
      int check = 0;
        try {
            
            statment = DBconnect.getInstance().getconn().prepareStatement("insert into product"
                    + "(categories_idcategory,idproduct,product_color,product_count,product_description,product_img,product_lastmodify,product_name,product_options,product_price,product_quntityavailable,product_quntitysold,product_size)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            statment.setInt(1,bean.getCategoriesIdcategory());
            statment.setInt(2,bean.getIdproduct());
            statment.setString(3,bean.getProductColor());
            statment.setInt(4,bean.getProductCount() );
            statment.setString(5,bean.getProductDescription());
            statment.setString(6,bean.getProductImg());
            statment.setDate(7,Date.valueOf(LocalDate.now()));
            statment.setString(8,bean.getProductName());
            statment.setString(9,bean.getProductOptions());
            statment.setFloat(10,bean.getProductPrice());
            statment.setInt(11,bean.getProductQuntityavailable());
            statment.setInt(12,bean.getProductQuntitysold());
            statment.setString(13,bean.getProductSize());
            
            check = statment.executeUpdate();
            
            System.out.println("insert"+check);
        } catch (SQLException ex) {
            Logger.getLogger(ProductPKDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int update(Product bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Product bean) {
       int check = 0;
        
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from product where idproduct=?");
            statment.setInt(1, bean.getIdproduct());
            
            check = statment.executeUpdate();
            
            System.out.println("Delete"+check);
        } catch (SQLException ex) {
            Logger.getLogger(ProductPKDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public Product selectById(int id) {
       product = new Product();
       
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product where idproduct=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setProductColor(result.getString("product_color"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    product.setProductSize(result.getString("product_size"));
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductPKDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product; 
    }

    @Override
    public Product selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List selectAll() {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product ");
           // statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while(result.next()) {
                    product = new Product(); 
                   
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setIdproduct(result.getInt("idproduct"));
                    product.setProductColor(result.getString("product_color"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    product.setProductSize(result.getString("product_size"));
                   // product.setProductPK(productPk);
                    productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductPKDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return productList;
    }
    
    public ArrayList selectProductsByCategoryId(int id){
        ArrayList<Product> productList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from product where categories_idcategory=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            while(result.next()) {
                    product = new Product(); 
                    
                    product.setCategoriesIdcategory(result.getInt("categories_idcategory"));
                    product.setIdproduct(result.getInt("idproduct"));
                    product.setProductColor(result.getString("product_color"));
                    product.setProductCount(result.getInt("product_count"));
                    product.setProductDescription(result.getString("product_description"));
                    product.setProductImg(result.getString("product_img"));
                    product.setProductLastmodify(result.getDate("product_lastmodify"));
                    product.setProductName(result.getString("product_name"));
                    product.setProductOptions(result.getString("product_options"));
                    product.setProductPrice(result.getFloat("product_price"));
                    product.setProductQuntityavailable(result.getInt("product_quntityavailable"));
                    product.setProductQuntitysold(result.getInt("product_quntitysold"));
                    product.setProductSize(result.getString("product_size"));
                    //product.setProductPK(productPk);
                    productList.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductPKDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return productList;
    
    }
    

   
}
