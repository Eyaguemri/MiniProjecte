package train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connexion {

	public static void main(String[] args) {
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train","root","");  

			   Statement stmt=con.createStatement();
			    
			   ResultSet rs=stmt.executeQuery("select * from prix"); 

			   while(rs.next())  
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			     
			   ResultSet résultats = null;
			   String requete = "SELECT * FROM client";

			   try {
			      Statement stmt1 = con.createStatement();
			      résultats = stmt1.executeQuery(requete);
			   } catch (SQLException e) {
			      //traitement de l'exception
			   }
			   con.close();  
			   
			   }catch(Exception e){
			    System.out.println(e);
			   } 
		
		// TODO Auto-generated method stub

	}

}
