package Management;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMessage(String str) {

		String msg;
		switch (str) {
		case "fill":
			msg = "Lütfen Tüm Alanlarý Doldurunuz.";
			break;
		case "succes":
			msg = "Ýþlem Baþarýlý";
			break;
		case "error":
			msg = "Bir Hata Gerçekleþti";
		default:
			msg = str;
		}

		JOptionPane.showMessageDialog(null, msg, "Uyarý", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public static boolean showConfirmMessage(String str) {

		String msg;
		switch (str) {
		case "sure":
			msg = "Bu Ýþlemi Gerçekleþtirmek Ýstediðinize Emin Misiniz ?";
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
