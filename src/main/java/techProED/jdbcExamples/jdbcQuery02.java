package techProED.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcQuery02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String yol ="jdbc:oracle:thin:@localhost:1521/XE";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(yol, "muste", "284552");
		
		Statement st = con.createStatement();
		
		String selectQuery = "SELECT * FROM bolumler";
		
		ResultSet tablo1 = st.executeQuery(selectQuery);
		
		while(tablo1.next()) {
			System.out.println(tablo1.getInt(1) + " " 
					+ tablo1.getString(2) + " " 
					+ tablo1.getString(3));
		}
		
		System.out.println("=========================");
		
		 /* ----------------------------------------------------------------------------
		  ORNEK1: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve 
		  maaslarini, maas sıralı olarak listeleyiniz
		------------------------------------------------------------------------------*/
		
		String q2 = "SELECT personel_isim, maas"
				+ " FROM personel"
				+ " WHERE bolum_id IN(10, 30)"
				+ " ORDER BY maas DESC";
		
		ResultSet q2sonuc = st.executeQuery(q2);
		
		while(q2sonuc.next()) {
			
			System.out.println("Personel isim: " + q2sonuc.getString(1) + " Maas: " + q2sonuc.getInt(2));
		}
		
		tablo1.close();
		q2sonuc.close();
		st.close();
		con.close();
		
	}

}
