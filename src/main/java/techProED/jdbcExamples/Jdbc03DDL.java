package techProED.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc03DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String yol = "jdbc:oracle:thin:@localhost:1521/XE";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(yol, "muste", "284552");

		Statement st = con.createStatement();

		/*
		 * =======================================================================
		 * ORNEK2:isciler adinda bir tablo olusturunuz id NUMBER(3), birim VARCHAR2(10),
		 * maas NUMBER(5)
		 * ========================================================================
		 

		String createQuery = "CREATE TABLE isciler(id NUMBER(3), birim VARCHAR2(10), maas NUMBER(5))";
		
		
		 * 1.YONTEM (execute() method'u ile) 
		 * boolean s1 = st.execute(createQuery); //false deger dondurecek (DDL)
		 * System.out.println("Isciler tablosu olusturuldu. " + s1);
		 */
		
		/* Genel kullanim sekli asagidaki gibidir
		st.execute(createQuery); // false deger dondurecek (DDL)
		System.out.println("Isciler tablosu olusturuldu.");
		
		System.out.println("=====================================");
		
		String dropQuery = "DROP TABLE isciler PURGE";
		*/
		
		/* 2.YONTEM (executeUpdate() methodu ile) 
		int s2 = st.executeUpdate(dropQuery); // DDL islemleri 0(sifir) dondurur.
		System.out.println("Isciler tablosu silindi. " + s2);
		
		
		// Genel kullanim sekli asagidaki gibidir
		st.executeUpdate(dropQuery);
		System.out.println("Isciler tablosu silindi..");
		
		System.out.println("=====================================");
		*/
		
		/*=======================================================================
		  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar2(20)} ekleyiniz.   
		======================================================================== 
		String alterQuery1 = "ALTER TABLE isciler ADD isim VARCHAR2(20)";
		st.executeUpdate(alterQuery1);
		System.out.println("isciler tablosuna isim sutunu eklendi");
		*/
		
		/*=======================================================================
		  ORNEK4:isciler tablosuna soyisim VARCHAR2(20) ve sehir VARCHAR2(10)) 
		  adinda 2 yeni sutun ekleyiniz.  
		========================================================================
		String alterQuery2 = "ALTER TABLE isciler"
				+ " ADD(soyisim VARCHAR2(20), sehir VARCHAR2(20))";
		st.executeUpdate(alterQuery2);
		System.out.println("isciler tablosuna soyisim ve sehir sutunlari eklendi.");
		*/
		
		/*=======================================================================
		  ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
		========================================================================
		String alterQuery3 = "ALTER TABLE isciler DELETE COLUMN soyisim";
		st.executeUpdate(alterQuery3);
		System.out.println("isciler tablosundan soyisim sutunu silindi.");
		*/
		
		/*=======================================================================
		  ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.  
		========================================================================
		String alterQuery4 = "ALTER TABLE isciler RENAME TO calisanlar";
		st.executeUpdate(alterQuery4);
		System.out.println("Isciler tablosunun ismi calisanlar olarak degistirildi.");
		*/
		
		/*=======================================================================
		  ORNEK7:calisanlar tablosunu siliniz.  
		========================================================================
		dropQuery2 = "DROP TABLE calisanlar PURGE";
		st.execute(dropQuery2);
		System.out.println("calisanlar tablosu silindi.");
		*/
		
		st.close();
		con.close();
		
	}

}
