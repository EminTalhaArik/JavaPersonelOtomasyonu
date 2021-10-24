package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Personel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class PersonelGorevlendirGUI extends JFrame {

	private static Personel personel = new Personel();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGorevlendirGUI frame = new PersonelGorevlendirGUI(personel);
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
	public PersonelGorevlendirGUI(Personel personel) {
		setTitle("Personel G\u00F6revlendirme Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personel \u0130smi : ");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 10, 151, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(personel.getAd() + " " + personel.getSoyad());
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(171, 10, 267, 41);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 488, 150);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		
		JButton btnGrevlendir = new JButton("G\u00F6revlendir");
		btnGrevlendir.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnGrevlendir.setBounds(10, 270, 198, 55);
		contentPane.add(btnGrevlendir);
		
		JButton btnDeletePersonel_1 = new JButton("Personeli \u00C7\u0131kar");
		btnDeletePersonel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btnDeletePersonel_1.setBounds(300, 270, 198, 55);
		contentPane.add(btnDeletePersonel_1);
	}
}
