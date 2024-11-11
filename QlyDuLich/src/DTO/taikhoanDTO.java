package DTO;

public class taikhoanDTO {
	private String user,pass,quyen;

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public taikhoanDTO() {}
	
	public void copyTK(taikhoanDTO tk) {
		this.user = tk.user;
		this.pass = tk.pass;
		this.quyen = tk.quyen;
	}

	public taikhoanDTO(String user, String pass, String quyen) {
		this.user = user;
		this.pass = pass;
		this.quyen = quyen;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
