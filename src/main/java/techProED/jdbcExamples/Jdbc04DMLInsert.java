package techProED.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc04DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String yol = "jdbc:oracle:thin:@LOCALHOST:1521/XE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(yol, "muste", "284552");
		
		Statement st = con.createStatement();
		
		/*=======================================================================
		  ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') 
		  ekleyelim ve eklenen kaydi teyit icin sorgulayalim.
		========================================================================*/
//		String s1 = "INSERT INTO bolumler VALUES(80, 'ARGE', 'ISTANBUL')";
//		
//		int st1 = st.executeUpdate(s1);
//		System.out.println(st1 + " adet satir eklendi.");
		
		
		/*=======================================================================
        ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
        ========================================================================*/
		// 1.YONTEM
     	// -----------------------------------------------
     	// Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin 
     	// yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
        // bu kotu bir yaklasimdir.
     		
     	String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
     		            	  "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
     		            	  "INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
		
     	
     	for (String each : sorgular1) {
			
     		st.addBatch(each);
     		}
     	
     	int[] s3 = st.executeBatch();
     	System.out.println(s3.length + " satir eklendi.");
     	
     	
     	ResultSet rs = st.executeQuery("SELECT * FROM bolumler");
     	
     	while(rs.next()) {
            System.out.println("Bölüm ID:" + rs.getInt("bolum_id")+
            		" "+"Bölüm Isim:" + rs.getString("bolum_isim")+
            		" "+"Konum:" + rs.getString("konum"));
        }
     	
     	rs.close();
     	st.close();
     	con.close();
     	
	}

}
