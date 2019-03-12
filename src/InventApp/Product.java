package InventApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jerry
 */


public class Product {


    Connection connection;
    
    private Integer id;
    private String name ;
    private Integer category_id ;
    private String price ;
    private Integer quantity ;
    private String description ;
    private String category;

    public Product(){}
    
    public Product(Integer ID, String NAME, Integer CATEGORY_ID, String PRICE, Integer QUANTITY, String DESCRIPTION,String categoryName)
    {
        this.id = ID;
        this.name = NAME;
        this.category_id = CATEGORY_ID;
        this.price = PRICE;
        this.quantity = QUANTITY;
        this.description = DESCRIPTION;
        this.category = categoryName;
    }
    
    
    
    // insert a new product
    public static void insertProduct(Product product)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `product`(`name`, `quantity`, `price`, `category_id`, `description`) VALUES (?,?,?,?,?)"); // https://bit.ly/2Hh09fD

            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setString(3, product.getPrice());
            ps.setInt(4, product.getCategory_id());
            ps.setString(5, product.getDescription());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "New Product Added");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    // update product
    // changeImage mean if you want to update the product image to
    public static void updateProduct(Product product, boolean changeImage)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        if(changeImage)
        {
        
            try {
            ps = con.prepareStatement("UPDATE `product` SET `name`=?,`quantity`=?,`price`=?,`category_id`=?,`description`=? WHERE `id` = ?");

            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setString(3, product.getPrice());
            ps.setInt(4, product.getCategory_id());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getId());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Product Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        }else{
            
            try {
            ps = con.prepareStatement("UPDATE `product` SET `name`=?,`quantity`=?,`price`=?,`category_id`=?,`description`=? WHERE `id` = ?");

            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setString(3, product.getPrice());
            ps.setInt(4, product.getCategory_id());
            ps.setString(5, product.getDescription());
            ps.setInt(6, product.getId());

            if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Product Updated");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        }
        
    }
    
    
    
    // delete product by id
    public static void deleteProduct(Integer id)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("DELETE FROM `product` WHERE `id` = ?");

            ps.setInt(1, id);

            // show a confirmation message before deleting the product
            int YesOrNo = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete This Product","Delete Product", JOptionPane.YES_NO_OPTION);
            if(YesOrNo == 0){
                
                if(ps.executeUpdate() != 0){
                JOptionPane.showMessageDialog(null, "Product Deleted");
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something Wrong");
                    
                }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
     
     
     // get prodcuts list using arraylist
    public ArrayList<Product> productsList(String val){
        
        ArrayList<Product> product_list = new ArrayList<>();
        connection = DB_INFO.getConnection();
        ResultSet rs;
        PreparedStatement ps;
        
               //String query = "SELECT product.id, product.name, category_id, quantity, price, picture,description,category.name as 'category' FROM product INNER JOIN category ON category.id = product.category_id";
        
               String query = "SELECT product.id, product.name,category_id, quantity, price, description,category.name as 'category'\n" +
"  FROM product\n" +
"INNER JOIN category ON category.id = product.category_id\n" +
"WHERE\n" +
"CONCAT(\n" +
"Convert(product.id , char(11)), product.name,\n" +
"Convert(quantity , char(11)), price,\n" +
"description, category.name\n" +
")\n" +
"LIKE ?;";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + val + "%");
            rs = ps.executeQuery();
           
            Product prd;
            // Integer ID, String NAME, Integer CATEGORY_ID, String PRICE, byte[] PICTURE, Integer QUANTITY, String DESCRIPTION
            while(rs.next()){
                prd = new Product(rs.getInt("id"), 
                                 rs.getString("name"), 
                                 rs.getInt("category_id"),
                                 rs.getString("price"),
                                 rs.getInt("quantity"),
                                 rs.getString("description"),
                                 rs.getString("category")
                                 );
                
                product_list.add(prd);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_list;
        
    }
     
     
     
     public ArrayList<Product> getAllProducts(){
        
        ArrayList<Product> product_list = new ArrayList<>();
        connection = DB_INFO.getConnection();
        ResultSet rs;
        PreparedStatement ps;
        
               String query = "SELECT product.id, product.name,category_id, quantity, price, description FROM product";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
           
            Product prd;
            
            while(rs.next()){
                prd = new Product(rs.getInt("id"), 
                                 rs.getString("name"), 
                                 rs.getInt("category_id"),
                                 rs.getString("price"),
                                 rs.getInt("quantity"),
                                 rs.getString("description"),
                                 null
                                 );
                
                product_list.add(prd);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_list;
        
    }
     
     
    // get products by category
    public ArrayList<Product> productsInCategoryList(Integer categoryId){
        
        ArrayList<Product> product_list = new ArrayList<>();
        connection = DB_INFO.getConnection();
        ResultSet rs;
        PreparedStatement ps;
        
               String query = "SELECT product.id, product.name,category_id, quantity, price, description FROM product WHERE category_id = ?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
           
            Product prd;
            
            while(rs.next()){
                prd = new Product(rs.getInt("id"), 
                                 rs.getString("name"), 
                                 rs.getInt("category_id"),
                                 rs.getString("price"),
                                 rs.getInt("quantity"),
                                 rs.getString("description"),
                                 null
                                 );
                
                product_list.add(prd);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product_list;
        
    }
    
    public boolean containsSignificantSubstr(String filter){
        if(this.name.contains(filter)){
            return true;
        }
        if(this.description.contains(filter)){
            return true;
        }
        if(this.price.contains(filter)){
            return true;
        }
        return false;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }
    
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
    
    public String getCategoryName(Integer category_id) {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
