/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import entity.Users;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakar M.M.R
 */
public class UsersDao implements DoaInterface<Users> {

    PreparedStatement statment;
    Users user;

    @Override
    public int insert(Users obj) {
        int check=1;
        boolean checkMail=chechMail(obj.getUserEmail());// true if found
        boolean checkName=checkName(obj.getUserName());
        boolean checkSSN=checkSSN(obj.getUserSsn());
        if (!checkName && !checkMail && !checkSSN )
                { try {
            PreparedStatement pst=DBconnect.getInstance().getconn().prepareStatement("INSERT INTO users (user_name,user_password,user_email,user_ssn,user_charge) VALUES (?,?,?,?,?)");
            
            pst.setString(1,obj.getUserName());
            pst.setString(2,obj.getUserPassword());
            pst.setString(3,obj.getUserEmail());
            pst.setInt(4,obj.getUserSsn());
            pst.setFloat(5,obj.getUserCharge());
          //  pst.setFloat(7,salary);
            pst.executeUpdate();
             System.out.println("dao.UsersDao.insert()");
             
        } 
                catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                check=1;}
       else
       {check=0;}
        
        return check;
    }

    @Override
    public int update(Users bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("update Users set user_name=?,user_password=?,user_email=?"
                    + ",user_address=?,user_mobile=?,user_ssn=?,user_charge=?,user_regdate=?"
                    + ",user_job=?,user_zip=? where idusers=?");
            statment.setString(1, bean.getUserName());
            statment.setString(2, bean.getUserPassword());
            statment.setString(3, bean.getUserEmail());
            statment.setString(4, bean.getUserAddress());
            statment.setString(5, bean.getUserMobile());
            statment.setInt(6, bean.getIdusers());
            statment.setFloat(7, bean.getUserCharge());
            statment.setDate(8, (Date) bean.getUserRegdate());
            statment.setString(9, bean.getUserJob());
            statment.setInt(10, bean.getUserZip());
            statment.setInt(11, bean.getIdusers());
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public int delete(Users bean) {
        int check = 0;
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("delete from users where idusers=?");
            statment.setInt(1, bean.getIdusers());
            check = statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    @Override
    public Users selectById(int id) {
        user = new Users();
        try {

            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where idusers=?");
            statment.setInt(1, id);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public Users selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> selectAll() {
        ArrayList<Users> userList = new ArrayList<>();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                user=new Users();
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
    
    public boolean chechMail(String mail)
     {
         boolean ch=true;
         user=new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_email=?");
            statment.setString(1, mail);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
                
                ch=true;
            }
            else
            {
                ch=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return ch;         
     }
    public boolean checkName(String name)
     {
         boolean ch=true;
         user=new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_name=?");
            statment.setString(1, name);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
                
                ch=true;
            }
            else
            {
                ch=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return ch;         
     }

    public Users login(Users obj)
     {     Users user=null;
                try {
 
                PreparedStatement pst=DBconnect.getInstance().getconn().prepareStatement("SELECT * FROM users WHERE user_email=? AND user_password=?");
                pst.setString(1,obj.getUserEmail());
                pst.setString(2,obj.getUserPassword());
                ResultSet rs;
                
                    rs = pst.executeQuery();
                    if(rs.next())
                    {
                        user=new Users();
                        user.setUserEmail(rs.getString("user_email"));
                        user.setUserPassword(rs.getString("user_password"));
                        user.setUserName(rs.getString("user_name"));
                        user.setUserSsn(rs.getInt("user_ssn"));
                        user.setUserCharge(rs.getFloat("user_charge"));

                    }    
                } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
                }
      return user;
     }
                 
                   
                    
//            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_email=? and user_password=?");
//            statment.setString(1, mail);
//            statment.setString(2, pass);
//            ResultSet result = statment.executeQuery();
//            if (result.next()) {
//                user.setIdusers(result.getInt("idusers"));
//                user.setUserName(result.getString("user_name"));
//                user.setUserPassword(result.getString("user_password"));
//                user.setUserEmail(result.getString("user_email"));
//                user.setUserAddress(result.getString("user_address"));
//                user.setUserMobile(result.getString("user_mobile"));
//                user.setUserCharge(result.getFloat("user_charge"));
//                user.setUserRegdate(result.getDate("user_regdate"));
//                user.setUserJob(result.getString("user_job"));
//                user.setUserZip(result.getInt("user_zip"));
//                user.setUserSsn(result.getInt("user_ssn"));               
//            }

    private boolean checkSSN(int userSsn) {
        
    boolean ch=true;
         user=new Users();
        try {
            statment = DBconnect.getInstance().getconn().prepareStatement("select * from users where user_ssn=?");
            statment.setInt(1, userSsn);
            ResultSet result = statment.executeQuery();
            if (result.next()) {
                user.setIdusers(result.getInt("idusers"));
                user.setUserName(result.getString("user_name"));
                user.setUserPassword(result.getString("user_password"));
                user.setUserEmail(result.getString("user_email"));
                user.setUserAddress(result.getString("user_address"));
                user.setUserMobile(result.getString("user_mobile"));
                user.setUserCharge(result.getFloat("user_charge"));
                user.setUserRegdate(result.getDate("user_regdate"));
                user.setUserJob(result.getString("user_job"));
                user.setUserZip(result.getInt("user_zip"));
                user.setUserSsn(result.getInt("user_ssn"));
                
                ch=true;
            }
            else
            {
                ch=false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return ch;         
     }
}