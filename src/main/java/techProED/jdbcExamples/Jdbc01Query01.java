package techProED.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc01Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Ilgili driver'i yuklemeliyiz
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. Connection olusturmaliyiz
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "muste", "284552");

		// 3. SQL komutlari icin bir Statement olusturmaliyiz
		Statement st = con.createStatement();

		// 4. Sorgu ifadesini calistiriyoruz
		// SQL ifadelerini yazabilir ve calistirabiliriz
		ResultSet isim = st.executeQuery("SELECT personel_isim, maas FROM personel" + " WHERE personel_id = 7566");

		// 5. Sonuclari goster
		while (isim.next()) {

			System.out.println("Personel adi: " + isim.getString("personel_isim"));
			System.out.println("Personel adi: " + isim.getString(1) + " maas: " + isim.getInt(2));
		}

		// 6. ve son adim olusturulan nesneleri kapatiyoruz
		isim.close();
		st.close();
		con.close();

	}

}
