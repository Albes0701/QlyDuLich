package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import DTO.QlyToursDTO;
import Util.JDBCUtil;

public class QlyToursDAO {
	public static QlyToursDAO getIntance() {
		return new QlyToursDAO();
	}
	public ArrayList<QlyToursDTO> selectAll(){
		ArrayList<QlyToursDTO> ketqua=new ArrayList<QlyToursDTO>();
		try {
			Connection con=JDBCUtil.getConnection();
			java.sql.Statement st=con.createStatement();
			String sql="select * from tours";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String matour=rs.getString("matour");
				String tentour=rs.getString("tentour");
				int songay=rs.getInt("songay");
				String noiden=rs.getString("noiden");
				String maloai=rs.getString("maloai");
				String noikhoihanh=rs.getString("noikhoihanh");
				QlyToursDTO tour=new QlyToursDTO(matour, tentour, noiden, noikhoihanh, maloai, songay);
				ketqua.add(tour);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	public int InsertTour(QlyToursDTO t) {
		int ketQua=0;
		try {
			//Bước 1:Tạo kết nối
			Connection con=JDBCUtil.getConnection();
			//Bước 2:Tạo đối tượng statement
			java.sql.Statement st=con.createStatement();
			//Bước 3:Thực thi statement
			String sql="INSERT INTO tours (matour,tentour,songay,noiden,maloai,noikhoihanh)"+
						" VALUES('"+t.getMatour()+"','"+t.getTentour()+"',"+t.getSongay()+",'"+t.getNoiden()+"','"+t.getMaloai()+"','"+t.getNoikhoihanh()+"')";
			ketQua=st.executeUpdate(sql);
			//Bước 4:Xử lý kết quả trả về
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println("So dong thay doi la: "+ketQua);
			//Bước 5:Ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		return ketQua;
	}
}
