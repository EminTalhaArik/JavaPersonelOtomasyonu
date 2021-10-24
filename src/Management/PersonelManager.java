package Management;

import java.sql.*;
import java.util.ArrayList;

import Model.*;

public class PersonelManager {

	DBConnection dbconnection = new DBConnection();

	public boolean addPersonel(String kullaniciAdi, String sifre, String ad, String soyad, String unvan, double maas,
			String departman, String mevcutIs, String maasTuru, String cinsiyet) {

		Connection connection = dbconnection.connect();
		Statement statement = null;
		PreparedStatement preparedStatement;

		boolean key = false;
		String query = "INSERT INTO personel"
				+ "(kullanici_adi, sifre, ad, soyad, unvan, tur, maas, departman, mevcut_is, maas_turu, cinsiyet) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?)";

		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, kullaniciAdi);
			preparedStatement.setString(2, sifre);
			preparedStatement.setString(3, ad);
			preparedStatement.setString(4, soyad);
			preparedStatement.setString(5, unvan);
			preparedStatement.setString(6, "personel");
			preparedStatement.setDouble(7, maas);
			preparedStatement.setString(8, departman);
			preparedStatement.setString(9, mevcutIs);
			preparedStatement.setString(10, maasTuru);
			preparedStatement.setString(11, cinsiyet);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;

	}

	public boolean updatePersonel(int id, String kullaniciAdi, String sifre) {
		Connection connection = dbconnection.connect();
		Statement statement = null;
		PreparedStatement preparedStatement;

		boolean key = false;
		String query = "UPDATE personel SET kullanici_adi = ? , sifre = ? WHERE id = ?";

		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, kullaniciAdi);
			preparedStatement.setString(2, sifre);
			preparedStatement.setInt(3, id);

			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				connection.close();
				statement.close();

			} catch (SQLException e) {
			}

		}
		return key;

	}
	
	public boolean deletePersonel(int id) {
		Connection connection = dbconnection.connect();
		Statement statement = null;
		PreparedStatement preparedStatement;

		boolean key = false;
		String query = "DELETE FROM personel WHERE id = ?";

		try {
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

			key = true;

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {

			try {
				connection.close();
				statement.close();

			} catch (SQLException e) {
			}

		}
		return key;

	}

	public ArrayList<Personel> getPersonelList() {

		ArrayList<Personel> personelList = new ArrayList();

		Connection connection = dbconnection.connect();
		Statement statement = null;
		ResultSet resultSet = null;
		Personel obj;
		try {
			statement = connection.createStatement();

			resultSet = statement.executeQuery("SELECT * FROM personel");
			while (resultSet.next()) {
				if (resultSet.getString("tur").equals("personel")) {

					obj = new Personel();

					obj.setId(resultSet.getInt("id"));
					obj.setAd(resultSet.getString("ad"));
					obj.setSoyad(resultSet.getString("soyad"));
					obj.setUnvan(resultSet.getString("unvan"));
					obj.setDepartman(resultSet.getString("departman"));

					personelList.add(obj);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				
			}
			
		}

		return personelList;
	}

}
