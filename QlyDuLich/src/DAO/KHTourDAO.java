package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.KHTourDTO;
import Util.JDBCUtil;

public class KHTourDAO {
	public KHTourDAO getIntance() {
		return new KHTourDAO();
	}
	public ArrayList<KHTourDTO> selectAll() {
		ArrayList<KHTourDTO> ketqua=new ArrayList<KHTourDTO>();
		try {
			Connection con=JDBCUtil.getConnection();
			Statement st=con.createStatement();
			String sql="select * from kehoachtour";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				String makht=rs.getString("makht");
				String matour=rs.getString("matour");
				String mota=rs.getString("mota");
				Date ngaydi=rs.getDate("ngaydi");
				Date ngayve=rs.getDate("ngaydi");
				int songuoi=rs.getInt("songuoi");
				long giave=rs.getLong("giave");
				String huongdanvien=rs.getString("huongdanvien");
				long tongchi=rs.getLong("tongchi");
				String anh1=rs.getString("anh1");
				String anh2=rs.getString("anh2");
				String anh3=rs.getString("anh3");
				KHTourDTO kht=new KHTourDTO(makht, matour, mota, huongdanvien, anh1, anh2, anh3, 
						ngaydi, ngayve, songuoi, tongchi, giave);
				ketqua.add(kht);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	
	public int InsertKHT(KHTourDTO t) {
		int ketQua=0;
		try {
			Connection con=JDBCUtil.getConnection();
			Statement st=con.createStatement();
			String sql="INSERT INTO kehoachtour (makht,matour,mota,ngaydi,ngayve,songuoi,giave,huongdanvien,"
					+ "tongchi,anh1,anh2,anh3)"+" VALUES ('"+t.getMakht()+"','"+t.getMatour()+"','"+t.getMota()+"','"+t.getNgaydi()+"','"
					+t.getNgayve()+"',"+t.getSonguoi()+","+t.getGiaVe()+",'"+t.getHuongdanvien()+"',"+t.getTongchi()+",'"+t.getAnh1()+"','"
					+t.getAnh2()+"','"+t.getAnh3()+"')";
			st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: " + sql);
			System.out.println("So dong thay doi la: " + ketQua);
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
