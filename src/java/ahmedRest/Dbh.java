/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahmedRest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ahmed Higazi
 */
public class Dbh {
    
    private Connection connection;
    
     void conToDb() throws ClassNotFoundException, SQLException{
            try {
                 Class.forName("com.mysql.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/restdb","root","");
 
            } catch (SQLException ex) {
                  System.out.print("conn");
              }
     }
     
     
     public CivilsRest retrieveName(String fname ) throws SQLException
	{
            ArrayList <CivilRest> List = new ArrayList<>();
          CivilsRest civils = new CivilsRest();
		try {
			conToDb();
		} catch (ClassNotFoundException e) {
                     System.out.print("c");
		  } 
                
                		Statement s = null;
                try {
                        String qu = "select * from civils where fname like '%"+fname+"%'";
                        s = connection.createStatement();
	                ResultSet rsul= s.executeQuery(qu);
                        while (rsul.next()) {
	    	         CivilRest civil=new CivilRest();
	    	          civil.setId(rsul.getInt("id"));
	    	          civil.setFname(rsul.getString("fname"));
                          civil.setLname(rsul.getString("lname"));
                          civil.setNnumber(rsul.getInt("nnumber"));
                      List.add( civil);
	     }
               civils.setC( List);
		} catch (SQLException e) {
                   System.out.print("conn3");

		}
            return  civils;
              }
     
      public CivilsRest retrieveByid( int id) throws SQLException
	{
            ArrayList <CivilRest> nameList = new ArrayList<>();
          CivilsRest civils = new CivilsRest();
		// connect to data base
		try {
			conToDb();
		} catch (ClassNotFoundException e1) {
                     System.out.print("conn2");
		} 
                
                		Statement s = null;
           try {
      
             String query = "select * from civils where id="+id;
              s = connection.createStatement();
	     ResultSet rsul= s.executeQuery(query);
        
              while (rsul.next()) {
	    	CivilRest civil=new CivilRest();
	    	civil.setId(rsul.getInt("id"));
	    	civil.setFname(rsul.getString("fname"));
                civil.setLname(rsul.getString("lname"));
                civil.setNnumber(rsul.getInt("nnumber"));
                 nameList.add( civil);
	     }
               civils.setC( nameList);
		} catch (SQLException e) {
             // TODO Auto-generated catch block
              System.out.print("co");

		}
     
            return  civils;
              }
     
}
