package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import BUS.KiemTra;
import DTO.DatTourDTO;
import Util.JDBCUtil;

public class DatTourDAO {
	public static DatTourDAO getIntance() {
		return new DatTourDAO();
	}
	
	public ArrayList<DatTourDTO> getLoc(String loaitour,String noiBD, String noiDen,java.sql.Date ngayDi, int soNgay, int soNguoi, long giaVe) {
		ArrayList<DatTourDTO> list = new ArrayList<>();
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="SELECT * FROM kehoachtour kht"
					+ " LEFT JOIN tours t  ON kht.matour = t.matour WHERE t.maloai = '" + loaitour+"'";
					if(!noiBD.equalsIgnoreCase("Địa điểm")) {
						sql += " AND t.noikhoihanh = '" + noiBD+"'";
					}
					if(!noiDen.equalsIgnoreCase("Địa điểm")) {
						sql += " AND t.noiden = '" + noiDen+"'";
					}
					if(soNguoi != 0) {
						sql += " AND kht.songuoi >= " + soNguoi+"";
					}
					if(ngayDi != null) {
						sql += " AND kht.ngaydi = '" + ngayDi+"'";
					}
					if(giaVe != 0) {
						sql += " AND kht.giave <= " + giaVe;
					}
					sql += " ORDER BY t.matour";
			System.err.println(sql);
			ResultSet rs=st.executeQuery(sql);
			//Bước 4:Xử lý kết quả trả về
			while(rs.next()){
				String matour = rs.getString("t.matour");
				String tentour = rs.getString("t.tentour");
				String makht = rs.getString("kht.makht");
				java.sql.Date ngaydi = rs.getDate("kht.ngaydi");
				java.sql.Date ngayve = rs.getDate("kht.ngayve");
				String hinh1 = rs.getString("anh1");
				String hinh2 = rs.getString("anh2");
				String hinh3 = rs.getString("anh3");
				int songuoi = rs.getInt("kht.songuoi");
				double giave = rs.getDouble("kht.giave");
				long giave2 = (long) giave;
				if(KiemTra.getInstance().checkngaydi(ngaydi)) {
					
					if(soNgay != 0) {
						
						LocalDate localDate = ngaydi.toLocalDate();
						LocalDate localDateve = ngayve.toLocalDate();
						LocalDate ngaySauKhiCong = localDate.plusDays(soNgay-1);
						if(ngaySauKhiCong.compareTo(localDateve) == 0 && soNgay != 0) {
							DatTourDTO dt = new DatTourDTO(matour, makht, tentour, hinh1, hinh2, hinh3, tentour, noiBD, makht, hinh1, hinh2, hinh3, giave2, songuoi, ngaydi, ngayve);					
							list.add(dt);
						}
					}else {
						DatTourDTO dt = new DatTourDTO(matour, makht, tentour, hinh1, hinh2, hinh3, tentour, noiBD, makht, hinh1, hinh2, hinh3, giave2, songuoi, ngaydi, ngayve);					
						list.add(dt);
					}
				}
			}
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	
}
