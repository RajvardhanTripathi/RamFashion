/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import EJBBean.RFBean;
import EJBBean.RFBeanLocal;
import Entity.Admin;
import Entity.Brands;
import Entity.Categories;
import Entity.GroupTable;
import Entity.Products;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author rajtr
 */
@Named(value = "RFJSFBean")
@SessionScoped
public class RFJSFBean implements Serializable {
    @EJB RFBeanLocal rbl;
    boolean valid = true;
    
    
    
    String admin_name;
    String admin_email;
    String admin_pass;
    String admin_img;

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_pass() {
        return admin_pass;
    }

    public void setAdmin_pass(String admin_pass) {
        this.admin_pass = admin_pass;
    }

    public String getAdmin_img() {
        return admin_img;
    }
    @PersistenceContext(unitName = "FashionPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public void setAdmin_img(String admin_img) {
        this.admin_img = admin_img;
    }
    
    
    public void insertadmin()
    {
        rbl.insertadmin(admin_name, admin_email, admin_pass, admin_img);
        
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("logina.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFBean.class.getName()).log(Level.SEVERE, null, ex);
         
            }
          admin_name="";
          admin_email="";
          admin_pass="";
          admin_img="";
         
         
    }  
    
    String username;
    String password;
    String email;
    String address;
    String city;
    String state;
    String phone;
    String role="user";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
     public void insertuser()
    {
        rbl.insertuser(username, password, email, address, city, state, phone, role);
        
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFBean.class.getName()).log(Level.SEVERE, null, ex);
         
            }
         
         
             username="";
             password="";
             email="";
             address="";
             city="";
             state="";
             phone="";
             role="";
             
             
         }  
    
   

    
    
    
    
     public void checkadmin(){
     Admin ad = rbl.checkadmin(admin_email);
     String aemail = ad.getAdminEmail();
     String pass = ad.getAdminPass();
     
     if(aemail.isEmpty()){
         valid = false;
     }else if( !(aemail.equals(admin_email)) && !(pass.equals(admin_pass))){
         valid = false;
     } else {
         try{
             FacesContext.getCurrentInstance().getExternalContext().redirect("admin.jsf");
         }catch(IOException e){
             
             
         }
     }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
     
    
    String product_name;
    String product_desc;
    String date;
    String product_stock;
    String product_price;
    String product_img;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(String product_stock) {
        this.product_stock = product_stock;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }
    
    int cat_id;
    String cat_name;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }



    
    
    
    
    
    public List<Categories> get_category(){
        List<Categories> cd= em.createNamedQuery("Categories.findAll").getResultList();
        return cd;
    }
    
    
    int brand_id;
    String brand_name;

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }



    
    
    public List<Brands> get_brands(){
        
        List<Brands> bd= em.createNamedQuery("Brands.findAll").getResultList();
        return bd;
    }
    
    
    public void insertproduct(){
        
       rbl.insertproduct(product_name, product_desc, brand_id, cat_id, date, product_stock, product_price, product_img);
        
        try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("add-product.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFBean.class.getName()).log(Level.SEVERE, null, ex);
         
            }
        
     product_name="";   
     product_desc="";
     brand_id=0;
     cat_id=0;
     date="";
     product_stock="";
     product_price="";
     product_img="";
        
        
    }
    
    public List<Products> showproduct(){
        
        return rbl.showproduct();
    
    
    }
    
    public void delete(Integer product_id){
        
        rbl.deleteProduct(product_id);
    }
    
    
    public void addcat()
    {
        rbl.addcat(cat_name);
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispcat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void addbrand()
    {
        rbl.addbrand(brand_name);
         try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispbrand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    public void deletebrand(Integer brand_id)
    {
        rbl.deletebrand(brand_id);
    }
    public void deletecat(Integer cat_id)
    {
        rbl.deletecat(cat_id);
    }
    
    public void srch(Integer cat_id)
        {
            Categories c1=rbl.srch(cat_id);
            setCat_id(cat_id);
            cat_name=c1.getCatName();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("edit_cat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
     public void catupdate(){
         rbl.catupdate(cat_id, cat_name);
          try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispcat.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
      public void bsrch(Integer brand_id)
        {
            Brands c1=rbl.bsrch(brand_id);
            setBrand_id(brand_id);
            brand_name=c1.getBrandName();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("edit_brand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(RFJSFBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
     public void brandupdate(){
         rbl.brandupdate(brand_id, brand_name);
          try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dispbrand.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Brands.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
    
    public RFJSFBean() {
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
}
