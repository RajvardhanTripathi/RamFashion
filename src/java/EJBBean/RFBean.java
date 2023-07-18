/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package EJBBean;

import Entity.Admin;
import Entity.Brands;
import Entity.Categories;
import Entity.GroupMatch;
import Entity.GroupTable;
import Entity.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author rajtr
 */
@Stateless

public class RFBean implements RFBeanLocal {

    @PersistenceContext(unitName = "FashionPU")
    private EntityManager em;
    Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();
    
    

    @Override
    public void insertadmin(String admin_name, String admin_email, String admin_pass, String admin_img) {
        
        Admin a=new Admin();
        a.setAdminName(admin_name);
        a.setAdminEmail(admin_email);
        a.setAdminPass(admin_pass);
        a.setAdminImg(admin_img);
        em.persist(a);

//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  @Inject Pbkdf2PasswordHash hasher;
        @Override
    public void insertuser(String username, String password, String email, String address, String city, String state, String phone, String role) {

    GroupTable rb = new GroupTable();
        rb.setUsername(username);
        String pass = hasher.generate(password.toCharArray());
        rb.setPassword(pass);
        rb.setEmail(email);
        rb.setAddress(address);
        rb.setCity(city);
        rb.setState(state);
        rb.setPhone(phone);
        rb.setRole(role);
        em.persist(rb);

        GroupMatch mc = new GroupMatch();
        mc.setName("user");
        GroupTable gt = (GroupTable)em.createNamedQuery("GroupTable.findByUsername").setParameter("username", username).getSingleResult();
        mc.setUsername(gt);
        em.persist(mc);


    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


    @Override
    public Admin checkadmin(String admin_email) {
       
        Admin ad = (Admin)em.createNamedQuery("Admin.findByAdminEmail").setParameter("adminEmail", admin_email).getSingleResult();
        return ad;
                
                 
        

//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

   
    
    @Override
    public void insertproduct(String product_name, String product_desc, int brand_id, int cat_id, String date, String product_stock, String product_price, String product_img) {
        
        
        Products p=new Products();
        Brands bd=em.find(Brands.class, brand_id);
        Categories cd=em.find(Categories.class, cat_id);
        
        p.setProductName(product_name);
        p.setProductDesc(product_desc);
        p.setBrandId(bd);
        p.setCatId(cd);        
        p.setDate(date);
        p.setProductStock(product_stock);
        p.setProductPrice(product_price);
        p.setProductImg(product_img);
        em.persist(p);



//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void deleteProduct(Integer product_id) {
        
        Products d1  =(Products) em.createNamedQuery("Products.findByProductId").setParameter("productId", product_id).getSingleResult();
        em.remove(d1);



//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public void addcat(String cat_name) {
        Categories c=new Categories();
        c.setCatName(cat_name);
        em.persist(c);
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addbrand(String brand_name) {
        Brands b=new Brands();
        b.setBrandName(brand_name);
        em.persist(b);
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletebrand(Integer brand_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Brands b=(Brands) em.createNamedQuery("Brands.findByBrandId").setParameter("brandId",brand_id).getSingleResult();
        em.remove(b);
    }

    @Override
    public void deletecat(Integer cat_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Categories c=(Categories) em.createNamedQuery("Categories.findByCatId").setParameter("catId", cat_id).getSingleResult();
      em.remove(c);
    }
    
    
     @Override
    public Categories srch(Integer cat_id) {
        Categories c1 = em.find(Categories.class,cat_id);
        return c1;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void catupdate(Integer cat_id, String cat_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Categories c1 = (Categories)em.find(Categories.class,cat_id);
        c1.setCatName(cat_name);
        em.merge(c1);
        
    }

    @Override
    public Brands bsrch(Integer brand_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Brands c1 = em.find(Brands.class,brand_id);
        return c1;
    }

    @Override
    public void brandupdate(Integer brand_id, String brand_name) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Brands c1 = (Brands)em.find(Brands.class,brand_id);
        c1.setBrandName(brand_name);
        em.merge(c1);
        
      }
    
    
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Products> showproduct() {
        
          List<Products> show=em.createNamedQuery("Products.findAll").getResultList();
        return show;

    


//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    





   
    
    
    
    
    
}
