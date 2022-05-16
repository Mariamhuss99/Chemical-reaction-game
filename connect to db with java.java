/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class chemicalsss {
    
 void searchinDB(){
 
 
 
 
 System.out.print("Your task is to prepare asprine");
      
        
        
  
        try{
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chemicalreaction","root","01006475490");
            Statement stmt = (Statement) conn.createStatement();
          
            String component = "C6H6";
            String SQL= "SELECT * FROM `drugs` WHERE product1='" + component + "'" ;
            ResultSet rs =  stmt.executeQuery(SQL);
            while (rs.next()){
           
            
            
          //  System.out.println("components = " + rs.getString("components"));
               
               

                          Scanner j = new Scanner (System.in);
                          String equal= j.next();
        
       
      
                           
                     
      if (equal.equals (rs.getString("c1")) ){
          
          System.out.print("score ++");
            
            }
      else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
    
      
      }
     
        
      
      
      
      
       Scanner sk = new Scanner (System.in);
      String skk=sk.next();
      
       
       if (skk.equals(rs.getString("c2"))) {
      
       System.out.println("score ++");
        System.out.println("BENZEN was prepared");
      System.out.print(rs.getString("product1"));
      System.out.print(rs.getString("sign3"));
      
       System.out.print(rs.getString("product2"));
             
      
      }
       else{
      System.out.print("sorry you made a diffrent drug ");
       System.out.print("GAME OVER ");
 System.exit(0);
      
      }
       
             
            }
            
            String component2 = "C6H5CL";
            String sQL2= "SELECT * FROM `drugs` WHERE product1='" + component2 + "'" ;
            ResultSet rs2 =  stmt.executeQuery(sQL2);
            while (rs2.next()){
            
            Scanner ql = new Scanner (System.in);
            String l = ql.next();
            
            if (l.equals(rs2.getString("c1"))){
            
            System.out.print("true");
            }
                  
      else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
      System.exit(0);
      
      }
            
            
            
            
            l=ql.next();
             
            if (l.equals(rs2.getString("c2"))){
            
            System.out.print("true");
             System.out.println("CHLOROBENZEN was prepared");
      System.out.print(rs2.getString("product1"));
      System.out.print(rs2.getString("sign3"));
      
       System.out.print(rs2.getString("product2"));
            
            }
             else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
    System.exit(0);
      
      }
            
            
            }
             String component3 = "C6H6O";
            String sQL3= "SELECT * FROM `drugs` WHERE product1='" + component3 + "'" ;
            ResultSet rs3 =  stmt.executeQuery(sQL3);
            while (rs3.next()){
            
            Scanner ll = new Scanner (System.in);
            String lll = ll.next();
            
            if (lll.equals(rs3.getString("c1"))){
            
            System.out.print("true");
            }
                  
      else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
      System.exit(0);
      
      }
            
            
            
            lll=ll.next();
             
            if (lll.equals(rs3.getString("c2"))){
            
            System.out.print("true");
             System.out.println("phenol was prepared");
      System.out.print(rs3.getString("product1"));
      System.out.print(rs3.getString("sign3"));
      
       System.out.print(rs3.getString("product2"));
            
            }
             else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
    System.exit(0);
      
      }
            
            
            }
             String component4 = "C7H6O3";
            String sQL4= "SELECT * FROM `drugs` WHERE product1='" + component4 + "'" ;
            ResultSet rs4 =  stmt.executeQuery(sQL4);
            while (rs4.next()){
            
            Scanner co = new Scanner (System.in);
            String comp = co.next();
            
            if (comp.equals(rs4.getString("c1"))){
            
            System.out.print("true");
            }
                  
      else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
      System.exit(0);
      
      }
            
            
            
            
            comp=co.next();
             
            if (comp.equals(rs4.getString("c2"))){
            
            System.out.print("true");
             System.out.println("Salicylic acid was prepared");
      System.out.print(rs4.getString("product1"));
      System.out.print(rs4.getString("sign3"));
      
       System.out.print(rs4.getString("product2"));
            
            }
             else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
    System.exit(0);
      
      }
            
            
            }
            
             String component5 = "C8H6O4";
            String sQL5= "SELECT * FROM `drugs` WHERE product1='" + component5 + "'" ;
            ResultSet rs5 =  stmt.executeQuery(sQL5);
            while (rs5.next()){
            
            Scanner ss = new Scanner (System.in);
            String s = ss.next();
            
            if (s.equals(rs5.getString("c1"))){
            
            System.out.print("true");
            }
                  
      else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
      System.exit(0);
      
      }
           
            
            
            
            
            
            s=ss.next();
             
            if (s.equals(rs5.getString("c2"))){
            
            System.out.print("true");
             
            
            }
             else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
    System.exit(0);
      
      }
           
            s=ss.next();
            if(s.equals(rs5.getString("c3"))){
            
            System.out.print("true");
            System.out.println("Asprine was prepared");
      System.out.print(rs5.getString("product1"));
     
            } else{
      System.out.print("sorry you made a diffrent drug ");
      System.out.print("GAME OVER ");
      System.exit(0);
      
      }
            
            
            }
            
        } 
        catch (Exception e){
        System.out.println("ERROR:" + e.getMessage());
        System.out.print("wrong");
        }
        // TODO code application logic here
              
        
        
        
        
 }
 
}
