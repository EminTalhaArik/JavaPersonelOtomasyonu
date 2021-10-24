package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import Management.*;
import Model.*;

public class LoginGUI extends JFrame {

	// Class Definition
	private DBConnection dbconnection = new DBConnection();

	// Component Definition
	private JPanel contentPane;
	private JTextField txtLoginKullaniciAdi;
	private JTextField txtLoginSifre;
	private JRadioButton rdbtnPersonel;
	private JRadioButton rdbtnYnetici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public LoginGUI() {
		setTitle("Personel Y\u00F6netim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				" Giri\u015F Yap ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 88, 360, 220);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 : ");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(26, 36, 107, 23);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\u015Eifre : ");
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(26, 79, 107, 23);
		panel.add(lblNewLabel_1_1);

		txtLoginKullaniciAdi = new JTextField();
		txtLoginKullaniciAdi.setBounds(143, 36, 185, 23);
		panel.add(txtLoginKullaniciAdi);
		txtLoginKullaniciAdi.setColumns(10);

		txtLoginSifre = new JTextField();
		txtLoginSifre.setColumns(10);
		txtLoginSifre.setBounds(143, 83, 185, 23);
		panel.add(txtLoginSifre);

		JButton btnLogin = new JButton("Giri\u015F Yap");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtLoginKullaniciAdi.getText().length() == 0 || txtLoginSifre.getText().length() == 0) {
					System.out.println("Lütfen Tüm Alanlarý Doldurunuz.");
				} else {

					if (rdbtnPersonel.isSelected()) {

					} else if (rdbtnYnetici.isSelected()) {

						Connection connection = dbconnection.connect();
						Statement statement = null;
						ResultSet resultSet = null;

						try {
							statement = connection.createStatement();
							resultSet = statement.executeQuery("SELECT * FROM personel WHERE tur='yonetici'");
							Personel personel = new Personel();

							while (resultSet.next()) {

								if (txtLoginKullaniciAdi.getText().equals(resultSet.getString("kullanici_adi"))
										&& txtLoginSifre.getText().equals(resultSet.getString("sifre"))) {

									personel.setId(resultSet.getInt("id"));
									personel.setKullaniciAdi(resultSet.getString("kullanici_adi"));
									personel.setSifre(resultSet.getString("sifre"));
									personel.setAd(resultSet.getString("ad"));
									personel.setSoyad(resultSet.getString("soyad"));
									personel.setUnvan(resultSet.getString("unvan"));
									personel.setTur(resultSet.getString("tur"));
									personel.setMaas(resultSet.getDouble("maas"));
									personel.setDepartman(resultSet.getString("departman"));
									personel.setMevcutIs(resultSet.getString("mevcut_is"));
									personel.setCinsiyet(resultSet.getString("cinsiyet"));
									personel.setMaasTuru(resultSet.getString("maas_turu"));

									System.out.println("Ýsim : " + personel.getAd());

									YoneticiGUI yoneticiGUI = new YoneticiGUI(personel);
									yoneticiGUI.setVisible(true);
									dispose();

								}

							}

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						System.out.println("Kullanýcý Türü Seçilmedi.");
					}

				}

			}
		});
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnLogin.setBounds(26, 164, 302, 46);
		panel.add(btnLogin);

		rdbtnYnetici = new JRadioButton("Y\u00F6netici");
		rdbtnYnetici.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		rdbtnYnetici.setBackground(Color.WHITE);
		rdbtnYnetici.setBounds(187, 129, 103, 21);
		rdbtnYnetici.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnPersonel.setSelected(false);
			}
		});
		panel.add(rdbtnYnetici);

		rdbtnPersonel = new JRadioButton("Personel");
		rdbtnPersonel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		rdbtnPersonel.setBackground(Color.WHITE);
		rdbtnPersonel.setBounds(70, 129, 103, 21);
		rdbtnPersonel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rdbtnYnetici.setSelected(false);
			}
		});
		panel.add(rdbtnPersonel);

		JRadioButton rdbtnYnetici = new JRadioButton("Y\u00F6netici");
		rdbtnYnetici.setBounds(187, 129, 103, 21);
		panel.add(rdbtnYnetici);

		JLabel lblNewLabel = new JLabel("Personel Y\u00F6netim Sistemi");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 23));
		lblNewLabel.setBounds(49, 28, 281, 34);
		contentPane.add(lblNewLabel);
	}
}
