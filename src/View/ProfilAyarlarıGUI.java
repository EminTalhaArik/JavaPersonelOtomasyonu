package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Management.Helper;
import Management.PersonelManager;
import Model.Personel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProfilAyarlarýGUI extends JFrame {

	private PersonelManager personelManager = new PersonelManager();;

	private JPanel contentPane;
	private static Personel personel = new Personel();
	private JTextField txtKullaniciAdi;
	private JLabel lblifre;
	private JTextField txtSifre;
	private JButton btnSaveAndExit;
	private JLabel lblNotBilgilerinizi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilAyarlarýGUI frame = new ProfilAyarlarýGUI(personel);
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
	public ProfilAyarlarýGUI(Personel personel) {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				YoneticiGUI yoneticiGUI = new YoneticiGUI(personel);
				yoneticiGUI.setVisible(true);
				dispose();

			}
		});
		setBackground(Color.WHITE);

		setTitle("Profil Ayarlar\u0131");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 345, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtKullaniciAdi = new JTextField(personel.getKullaniciAdi());
		txtKullaniciAdi.setBounds(131, 10, 190, 24);
		contentPane.add(txtKullaniciAdi);
		txtKullaniciAdi.setColumns(10);

		JLabel lblKullancAdYazisi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 : ");
		lblKullancAdYazisi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblKullancAdYazisi.setBounds(10, 10, 111, 20);
		contentPane.add(lblKullancAdYazisi);

		lblifre = new JLabel("\u015Eifre : ");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblifre.setBounds(10, 57, 111, 20);
		contentPane.add(lblifre);

		txtSifre = new JTextField(personel.getSifre());
		txtSifre.setColumns(10);
		txtSifre.setBounds(131, 57, 190, 24);
		contentPane.add(txtSifre);

		btnSaveAndExit = new JButton("Kaydet");
		btnSaveAndExit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnSaveAndExit.setBounds(71, 134, 183, 42);
		btnSaveAndExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtKullaniciAdi.getText().length() == 0 || txtSifre.getText().length() == 0) {

					Helper.showMessage("Lütfen Alanlarý Boþ Býrakmayýnýz. ");
				} else {

					boolean control = personelManager.updatePersonel(personel.getId(), txtKullaniciAdi.getText(),
							txtSifre.getText());

					if (control) {
						Helper.showMessage("succes");

					} else {
						Helper.showMessage("error");
					}
					LoginGUI loginGUI = new LoginGUI();
					loginGUI.setVisible(true);
					dispose();

				}

			}
		});
		contentPane.add(btnSaveAndExit);

		lblNotBilgilerinizi = new JLabel(
				"Not : Bilgilerinizi de\u011Fi\u015Ftirdikten sonra yeniden giri\u015F yapman\u0131z gerekir.");
		lblNotBilgilerinizi.setForeground(Color.RED);
		lblNotBilgilerinizi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 9));
		lblNotBilgilerinizi.setBounds(10, 104, 311, 20);
		contentPane.add(lblNotBilgilerinizi);
	}
}
