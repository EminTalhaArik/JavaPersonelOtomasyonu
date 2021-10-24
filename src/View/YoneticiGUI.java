package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Personel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Label;
import java.awt.Button;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Management.Helper;
import Management.PersonelManager;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class YoneticiGUI extends JFrame {

	private PersonelManager personelManager = new PersonelManager();

	// Table Definition
	private DefaultTableModel personelModel;
	private Object[] personelData;

	private JPanel contentPane;
	private static Personel personel = new Personel();
	private JTextField txtAddAd;
	private JTextField txtAddSoyad;
	private JTextField txtAddUnvan;
	private JTextField txtAddDepartman;
	private JTextField txtMaas;
	private JTable tblListOfPersonel;
	private JTextField txtDeletePersonelID;

	private int selectedPersonelID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YoneticiGUI frame = new YoneticiGUI(personel);
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
	public YoneticiGUI(Personel personel) {

		personelModel = new DefaultTableModel();
		Object[] colPersonelName = new Object[5];

		colPersonelName[0] = "ID";
		colPersonelName[1] = "Ýsim";
		colPersonelName[2] = "Soyisim";
		colPersonelName[3] = "Ünvan";
		colPersonelName[4] = "Departman";

		personelModel.setColumnIdentifiers(colPersonelName);

		personelData = new Object[5];
		for (int i = 0; i < personelManager.getPersonelList().size(); i++) {
			personelData[0] = personelManager.getPersonelList().get(i).getId();
			personelData[1] = personelManager.getPersonelList().get(i).getAd();
			personelData[2] = personelManager.getPersonelList().get(i).getSoyad();
			personelData[3] = personelManager.getPersonelList().get(i).getUnvan();
			personelData[4] = personelManager.getPersonelList().get(i).getDepartman();

			personelModel.addRow(personelData);

		}

		setTitle("Personel Y\u00F6netim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 75, 1043, 486);
		contentPane.add(tabbedPane);

		JPanel pnlProfilIslemleri = new JPanel();
		pnlProfilIslemleri.setBackground(Color.WHITE);
		tabbedPane.addTab("Profil \u0130\u015Flemleri", null, pnlProfilIslemleri, null);
		pnlProfilIslemleri.setLayout(null);

		JLabel lblProfilImage = new JLabel("Resim");
		if (personel.getCinsiyet().equals("Erkek")) {
			lblProfilImage.setIcon(new ImageIcon("D:\\EclipseProjectsSpace\\PersonelOtomasyonu\\src\\View\\user.png"));
		} else {
			lblProfilImage
					.setIcon(new ImageIcon("D:\\EclipseProjectsSpace\\PersonelOtomasyonu\\src\\View\\userGirl.png"));
		}
		lblProfilImage.setBounds(32, 30, 133, 135);
		pnlProfilIslemleri.add(lblProfilImage);

		JLabel lblAd = new JLabel(personel.getAd() + " " + personel.getSoyad());
		lblAd.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblAd.setBounds(114, 186, 339, 20);
		pnlProfilIslemleri.add(lblAd);

		JLabel lblUnvanYazisi = new JLabel("\u00DCnvan\u0131 : ");
		lblUnvanYazisi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblUnvanYazisi.setBounds(10, 216, 65, 20);
		pnlProfilIslemleri.add(lblUnvanYazisi);

		JLabel lblDepartmYazisi = new JLabel("Departman : ");
		lblDepartmYazisi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblDepartmYazisi.setBounds(10, 246, 94, 20);
		pnlProfilIslemleri.add(lblDepartmYazisi);

		JLabel lblGrevi = new JLabel("G\u00F6rev : ");
		lblGrevi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblGrevi.setBounds(10, 276, 94, 20);
		pnlProfilIslemleri.add(lblGrevi);

		JLabel lblDepartman = new JLabel(personel.getDepartman());
		lblDepartman.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblDepartman.setBounds(114, 246, 339, 20);
		pnlProfilIslemleri.add(lblDepartman);

		JLabel lblUnvan = new JLabel(personel.getUnvan());
		lblUnvan.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblUnvan.setBounds(114, 216, 339, 20);
		pnlProfilIslemleri.add(lblUnvan);

		JLabel lblAdSoyad = new JLabel("Ad - Soyad : ");
		lblAdSoyad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAdSoyad.setBounds(10, 186, 94, 20);
		pnlProfilIslemleri.add(lblAdSoyad);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 276, 339, 67);
		pnlProfilIslemleri.add(scrollPane);

		JLabel lblMevcutGorev = new JLabel(personel.getMevcutIs());
		lblMevcutGorev.setVerticalAlignment(SwingConstants.TOP);
		lblMevcutGorev.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(lblMevcutGorev);
		lblMevcutGorev.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));

		JLabel lblMaa = new JLabel("Maa\u015F : ");
		lblMaa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblMaa.setBounds(10, 356, 94, 20);
		pnlProfilIslemleri.add(lblMaa);

		JLabel lblMaas = new JLabel(String.valueOf(personel.getMaas()));
		lblMaas.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblMaas.setBounds(114, 356, 72, 20);
		pnlProfilIslemleri.add(lblMaas);

		JLabel lblMaasTuru = new JLabel(personel.getMaasTuru());
		lblMaasTuru.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblMaasTuru.setBounds(196, 356, 148, 20);
		pnlProfilIslemleri.add(lblMaasTuru);

		JLabel lblKullaniciAdi = new JLabel(personel.getKullaniciAdi());
		lblKullaniciAdi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblKullaniciAdi.setBounds(307, 37, 250, 20);
		pnlProfilIslemleri.add(lblKullaniciAdi);

		JLabel lblKullancAdYazisi = new JLabel("Kullan\u0131c\u0131 Ad\u0131 : ");
		lblKullancAdYazisi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblKullancAdYazisi.setBounds(186, 37, 111, 20);
		pnlProfilIslemleri.add(lblKullancAdYazisi);

		JLabel lblSifre = new JLabel(personel.getSifre());
		lblSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		lblSifre.setBounds(307, 67, 250, 20);
		pnlProfilIslemleri.add(lblSifre);

		JLabel lblSifreYazisi = new JLabel("\u015Eifre : ");
		lblSifreYazisi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblSifreYazisi.setBounds(186, 67, 111, 20);
		pnlProfilIslemleri.add(lblSifreYazisi);

		JButton btnNewButton_1 = new JButton("Profil Ayarlar\u0131");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ProfilAyarlarýGUI profilAyarlarýGUI = new ProfilAyarlarýGUI(personel);
				profilAyarlarýGUI.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnNewButton_1.setBounds(114, 396, 183, 42);
		pnlProfilIslemleri.add(btnNewButton_1);

		JPanel pnlPersonelIslemleri = new JPanel();
		pnlPersonelIslemleri.setBackground(Color.WHITE);
		tabbedPane.addTab("Personel \u0130\u015Flemleri", null, pnlPersonelIslemleri, null);
		pnlPersonelIslemleri.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Personel Ekle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 432, 439);
		pnlPersonelIslemleri.add(panel);
		panel.setLayout(null);

		JLabel lblAd_1 = new JLabel("Ad : ");
		lblAd_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1.setBounds(25, 25, 111, 20);
		panel.add(lblAd_1);

		txtAddAd = new JTextField();
		txtAddAd.setBounds(156, 25, 241, 20);
		panel.add(txtAddAd);
		txtAddAd.setColumns(10);

		JLabel lblKullancAdYazisi_1_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131 : ");
		lblKullancAdYazisi_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblKullancAdYazisi_1_1.setBounds(121, 280, 111, 20);
		panel.add(lblKullancAdYazisi_1_1);

		JLabel lblAd_1_1 = new JLabel("Soyad : ");
		lblAd_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1_1.setBounds(25, 55, 111, 20);
		panel.add(lblAd_1_1);

		txtAddSoyad = new JTextField();
		txtAddSoyad.setColumns(10);
		txtAddSoyad.setBounds(156, 59, 241, 20);
		panel.add(txtAddSoyad);

		JLabel lblAd_1_1_1 = new JLabel("\u00DCnvan : ");
		lblAd_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1_1_1.setBounds(25, 115, 111, 20);
		panel.add(lblAd_1_1_1);

		txtAddUnvan = new JTextField();
		txtAddUnvan.setColumns(10);
		txtAddUnvan.setBounds(156, 119, 241, 20);
		panel.add(txtAddUnvan);

		JLabel lblAd_1_1_1_1 = new JLabel("Departman : ");
		lblAd_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1_1_1_1.setBounds(25, 145, 111, 20);
		panel.add(lblAd_1_1_1_1);

		txtAddDepartman = new JTextField();
		txtAddDepartman.setColumns(10);
		txtAddDepartman.setBounds(156, 149, 241, 20);
		panel.add(txtAddDepartman);

		JLabel lblAd_1_1_1_2 = new JLabel("Maa\u015F : ");
		lblAd_1_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1_1_1_2.setBounds(25, 175, 111, 20);
		panel.add(lblAd_1_1_1_2);

		txtMaas = new JTextField();
		txtMaas.setColumns(10);
		txtMaas.setBounds(156, 179, 120, 20);
		panel.add(txtMaas);

		JComboBox cmboxAddMaasTuru = new JComboBox();
		cmboxAddMaasTuru.setModel(new DefaultComboBoxModel(new String[] { "TL", "Dolar", "Euro" }));
		cmboxAddMaasTuru.setBounds(286, 178, 83, 21);
		panel.add(cmboxAddMaasTuru);

		JLabel lblAd_1_1_2 = new JLabel("Cinsiyet");
		lblAd_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAd_1_1_2.setBounds(25, 85, 111, 20);
		panel.add(lblAd_1_1_2);

		JLabel lblAddKullaniciAdi = new JLabel("??");
		lblAddKullaniciAdi.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAddKullaniciAdi.setBounds(242, 280, 155, 20);
		panel.add(lblAddKullaniciAdi);

		JLabel lblAddSifre = new JLabel("??");
		lblAddSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblAddSifre.setBounds(242, 310, 155, 20);
		panel.add(lblAddSifre);

		JButton btnCreateKullaniciAdiSifre = new JButton("Kullan\u0131c\u0131 Ad\u0131- \u015Eifre Olu\u015Ftur");
		btnCreateKullaniciAdiSifre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lblAddKullaniciAdi.setText(txtAddSoyad.getText() + txtAddAd.getText());
				lblAddSifre.setText("123" + txtAddAd.getText());

			}
		});
		btnCreateKullaniciAdiSifre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnCreateKullaniciAdiSifre.setBounds(156, 221, 241, 39);
		panel.add(btnCreateKullaniciAdiSifre);

		JLabel lblKullancAdYazisi_1_1_2 = new JLabel("\u015Eifre :");
		lblKullancAdYazisi_1_1_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblKullancAdYazisi_1_1_2.setBounds(121, 310, 111, 20);
		panel.add(lblKullancAdYazisi_1_1_2);

		JComboBox cmboxAddCinsiyet = new JComboBox();
		cmboxAddCinsiyet.setModel(new DefaultComboBoxModel(new String[] { "Erkek", "Kad\u0131n" }));
		cmboxAddCinsiyet.setBounds(156, 89, 241, 21);
		panel.add(cmboxAddCinsiyet);

		JButton btnPersonelEkle = new JButton("Personel Ekle");
		btnPersonelEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtAddAd.getText().length() == 0 || txtAddSoyad.getText().length() == 0
						|| txtAddDepartman.getText().length() == 0 || txtAddUnvan.getText().length() == 0) {

					Helper.showMessage("fill");

				} else {

					if (lblAddKullaniciAdi.getText().equals("??") || lblAddSifre.getText().equals("??")) {

						Helper.showMessage("Lütfen Kullanýcý Adý ve Þifre Oluþturunuz. ");

					} else {

						boolean control = personelManager.addPersonel(lblAddKullaniciAdi.getText(),
								lblAddSifre.getText(), txtAddAd.getText(), txtAddSoyad.getText(), txtAddUnvan.getText(),
								Double.valueOf(txtMaas.getText()), txtAddDepartman.getText(), null,
								cmboxAddMaasTuru.getSelectedItem().toString(),
								cmboxAddCinsiyet.getSelectedItem().toString());

						if (control) {
							Helper.showMessage("succes");

							txtAddAd.setText(null);
							txtAddSoyad.setText(null);
							txtAddDepartman.setText(null);
							txtAddUnvan.setText(null);
							txtMaas.setText(null);
							lblAddKullaniciAdi.setText("??");
							lblAddSifre.setText("??");

							updatePersonelTable();

						} else {
							Helper.showMessage("error");
						}

					}

				}

			}
		});
		btnPersonelEkle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		btnPersonelEkle.setBounds(73, 356, 241, 51);
		panel.add(btnPersonelEkle);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(660, 10, 368, 439);
		pnlPersonelIslemleri.add(scrollPane_1);


		JButton btnDeletePersonel = new JButton("Personeli \u00C7\u0131kar");
		btnDeletePersonel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtDeletePersonelID.getText().length() == 0) {
					Helper.showMessage("Lütfen Çýkarmak Ýstediðiniz  Personeli Seçiniz");
				} else {

					if (Helper.showConfirmMessage("sure")) {

						int id = Integer.parseInt(txtDeletePersonelID.getText());

						boolean control = personelManager.deletePersonel(id);

						if (control) {
							Helper.showMessage("succes");
							updatePersonelTable();
							txtDeletePersonelID.setText(null);
						}
					}
				}

			}
		});
		btnDeletePersonel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnDeletePersonel.setBounds(452, 394, 198, 55);
		pnlPersonelIslemleri.add(btnDeletePersonel);

		txtDeletePersonelID = new JTextField();
		txtDeletePersonelID.setEditable(false);
		txtDeletePersonelID.setColumns(10);
		txtDeletePersonelID.setBounds(452, 352, 198, 32);
		pnlPersonelIslemleri.add(txtDeletePersonelID);

		JButton btnPersonelGorevlendir = new JButton("G\u00F6revlendir");
		btnPersonelGorevlendir.setEnabled(false);
		btnPersonelGorevlendir.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnPersonelGorevlendir.setBounds(452, 10, 198, 55);
		pnlPersonelIslemleri.add(btnPersonelGorevlendir);

		JButton btnPersonelBilgileri = new JButton("Personel Bilgileri");
		btnPersonelBilgileri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnPersonelBilgileri.setEnabled(false);
		btnPersonelBilgileri.setBounds(452, 75, 198, 55);
		pnlPersonelIslemleri.add(btnPersonelBilgileri);

		JButton btnPersonelEkipIslemleri = new JButton("Ekip Atamas\u0131 Yap");
		btnPersonelEkipIslemleri.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnPersonelEkipIslemleri.setEnabled(false);
		btnPersonelEkipIslemleri.setBounds(452, 140, 198, 55);
		pnlPersonelIslemleri.add(btnPersonelEkipIslemleri);

		JButton btnBos = new JButton("...");
		btnBos.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnBos.setEnabled(false);
		btnBos.setBounds(452, 205, 198, 55);
		pnlPersonelIslemleri.add(btnBos);

		JButton btnBos1 = new JButton("...");
		btnBos1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnBos1.setEnabled(false);
		btnBos1.setBounds(452, 270, 198, 55);
		pnlPersonelIslemleri.add(btnBos1);

		JButton btnNewButton = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginGUI loginGUI = new LoginGUI();
				loginGUI.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnNewButton.setBounds(916, 10, 137, 39);
		contentPane.add(btnNewButton);
		

		tblListOfPersonel = new JTable(personelModel);
		tblListOfPersonel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				btnPersonelBilgileri.setEnabled(true);
				btnPersonelEkipIslemleri.setEnabled(true);
				btnPersonelGorevlendir.setEnabled(true);
				btnPersonelEkipIslemleri.setEnabled(true);
				
				try {

					selectedPersonelID = Integer
							.parseInt(tblListOfPersonel.getValueAt(tblListOfPersonel.getSelectedRow(), 0).toString());
					txtDeletePersonelID
							.setText(tblListOfPersonel.getValueAt(tblListOfPersonel.getSelectedRow(), 0).toString());

				} catch (Exception e2) {

				}

			}
		});	
		scrollPane_1.setViewportView(tblListOfPersonel);

	}

	public void updatePersonelTable() {
		DefaultTableModel clearModel = (DefaultTableModel) tblListOfPersonel.getModel();

		clearModel.setRowCount(0);

		for (int i = 0; i < personelManager.getPersonelList().size(); i++) {
			personelData[0] = personelManager.getPersonelList().get(i).getId();
			personelData[1] = personelManager.getPersonelList().get(i).getAd();
			personelData[2] = personelManager.getPersonelList().get(i).getSoyad();
			personelData[3] = personelManager.getPersonelList().get(i).getUnvan();
			personelData[4] = personelManager.getPersonelList().get(i).getDepartman();

			personelModel.addRow(personelData);

		}

	}
}
