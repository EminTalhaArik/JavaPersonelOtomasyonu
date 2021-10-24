package Management;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMessage(String str) {

		String msg;
		switch (str) {
		case "fill":
			msg = "L�tfen T�m Alanlar� Doldurunuz.";
			break;
		case "succes":
			msg = "��lem Ba�ar�l�";
			break;
		case "error":
			msg = "Bir Hata Ger�ekle�ti";
		default:
			msg = str;
		}

		JOptionPane.showMessageDialog(null, msg, "Uyar�", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public static boolean showConfirmMessage(String str) {

		String msg;
		switch (str) {
		case "sure":
			msg = "Bu ��lemi Ger�ekle�tirmek �stedi�inize Emin Misiniz ?";
			break;
		default:
			msg = str;
		}

		int res = JOptionPane.showConfirmDialog(null, msg, "Emin Misiniz ?", JOptionPane.YES_NO_OPTION);

		if(res == 0) {
			return true;
		}else {
			return false;
		}
		
	}

}
