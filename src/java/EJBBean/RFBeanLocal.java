/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package EJBBean;

import Entity.Admin;
import Entity.Brands;
import Entity.Categories;
import Entity.GroupTable;
import Entity.Products;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rajtr
 */
@Local
public interface RFBeanLocal {
    
            void insertadmin(String admin_name, String admin_email, String admin_pass, String admin_img);
            
            Admin checkadmin(String admin_email);
            
            void insertproduct(String product_name, String product_desc, int brand_id, int cat_id, String date, String product_stock, String product_price, String product_img);
            
            List<Products> showproduct();
            
            void deleteProduct(Integer product_id);
            
            void insertuser(String username, String password, String email, String address, String city, String state, String phone, String role);
           
            void addcat(String cat_name);
            
            void addbrand(String brand_name);
            
            void deletebrand(Integer brand_id);
            
            void deletecat(Integer cat_id);
            
            Categories srch(Integer cat_id);
            void catupdate(Integer cat_id, String cat_name);
    
            Brands bsrch(Integer brand_id);
            void brandupdate(Integer brand_id,String brand_name);
}
