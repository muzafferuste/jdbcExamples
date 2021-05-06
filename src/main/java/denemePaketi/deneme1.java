package denemePaketi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deneme1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String yol = "jdbc:oracle:thin:@localhost:1521/XE";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(yol, "muste", "284552");

		Statement st = con.createStatement();

		/*
		 * -----------------------------------------------------------------------------
		 * ORNEK5: MUDUR’u Mesut veya Emine olan personelin bolumlerini,isimlerini,
		 * maaslarini ve mudur isimlerini maas siralı olarak (Çoktan aza) listeleyiniz.
		 * -----------------------------------------------------------------------------
		 * -
		 */

		String denemeQuery = "SELECT p.personel_isim, b.bolum_isim, p.maas, (SELECT personel_isim FROM personel"
				+ "														WHERE p.mudur_id = personel_id) AS mudur_isim"
				+ " FROM personel p" + " FULL JOIN bolumler b" + " ON p.bolum_id = b.bolum_id"
				+ " WHERE p.mudur_id IN(7698, 7788)" + " ORDER BY maas DESC";

		ResultSet deneme1 = st.executeQuery(denemeQuery);

		while (deneme1.next()) {
			System.out.println(deneme1.getString(1) + " " + deneme1.getString(2) + " " + deneme1.getInt(3) + " "
					+ deneme1.getString(4));

		}

	}

}
