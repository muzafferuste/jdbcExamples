package techProED.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc02Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String yol = "jdbc:oracle:thin:@localhost:1521/XE";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(yol, "muste", "284552");

		Statement st = con.createStatement();

		String selectQuery = "SELECT * FROM bolumler";

		ResultSet tablo1 = st.executeQuery(selectQuery);

		while (tablo1.next()) {
			
			System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + " " + tablo1.getString(3));
		}

		System.out.println("=========================");

		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK1: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve
		 * maaslarini, maas sıralı olarak listeleyiniz
		 * -----------------------------------------------------------------------------
		 */

		String q2 = "SELECT personel_isim, maas FROM personel WHERE bolum_id IN(10, 30)"
				+ " ORDER BY maas DESC";

		ResultSet q2sonuc = st.executeQuery(q2);

		int toplam = 0;
		while (q2sonuc.next()) {

			System.out.println("Personel isim: " + q2sonuc.getString(1) + " Maas: " + q2sonuc.getInt(2));
			toplam += q2sonuc.getInt("maas");
		}
		
		System.out.println("mmaslarin toplami: " + toplam);

		System.out.println("=========================");

		/*
		 * =======================================================================
		 * ORNEK4: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini ve
		 * maaslarini bolum ve maas siraali listeleyiniz. NOT: calisani olmasa bile
		 * bolum ismi gosterilmelidir.
		 * ========================================================================
		 */

		String q3 = "SELECT b.bolum_isim, p.personel_isim, p.maas" + " FROM personel p" + " FULL JOIN bolumler b"
				+ " ON b.bolum_id = p.bolum_id" + " ORDER BY b.bolum_id, p.maas";

		ResultSet q3sonuc = st.executeQuery(q3);

		while (q3sonuc.next()) {

			System.out.println(q3sonuc.getString(1) + " " + q3sonuc.getString(2) + " " + q3sonuc.getInt(3));
		}
		
		System.out.println("q4=========================");


		/*
		 * =======================================================================
		 * ORNEK5: Maasi en yuksek 10 kisiyinin bolumunu,adini ve maasini listeyiniz
		 * ========================================================================
		 */
		
		String q4 = "SELECT p.personel_isim, b.bolum_isim, p.maas"
				+ " FROM personel p"
				+ " JOIN bolumler b"
				+ " ON b.bolum_id = p.bolum_id"
				+ " ORDER BY maas DESC";
		
		ResultSet q4sonuc = st.executeQuery(q4);
		
		int count = 1;
		while(q4sonuc.next() && count<=10) {
			
			System.out.println(count + ". " + q4sonuc.getString(1) + " " + q4sonuc.getString(2) + " "+ q4sonuc.getInt(3));
			count++;
		}

		q4sonuc.close();
		q3sonuc.close();
		q2sonuc.close();
		tablo1.close();
		st.close();
		con.close();

	}

}
