package BUS;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.sql.Date;

public class KiemTra {
	public static KiemTra getInstance() {
		return new KiemTra();
	}

	public String GioiTinh(Boolean gt) {
		if (gt) return "Nam";
		return "Nữ";
		
	}
	public boolean GioiTinh(String gt) {
		if(gt.equalsIgnoreCase("nam")) return true;
		return false;
	}
	public Boolean forMatchDate(String dateString) {
		 String regex = "\\d{4}-\\d{2}-\\d{2}";
		 return Pattern.matches(regex, dateString);
	}
	public Date toDate(String st) {
		SimpleDateFormat dateFormatch = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqldate = null;
		try {
			java.util.Date utilDate = dateFormatch.parse(st);
			sqldate = new java.sql.Date(utilDate.getTime());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return sqldate;
	}
	
	public String formatchString(String str) {
//		\\s đại diện cho bất kỳ ký tự khoảng trắng nào và + biểu thị cho một hoặc nhiều lần lặp lại. 
		try {
			str = str.replaceAll("\\s+", " ").trim();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		return str;
	}
}
