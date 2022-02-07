package jp.co.sample.domain;

public class Administrator {

	private Integer id;
	private String name;
	private String mailAddress;
	private String password;
	
	public Administrator() {}
	

	public Administrator(Integer id, String name, String mailAdress, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mailAddress = mailAdress;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAdress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", mailAdress=" + mailAddress + ", password=" + password
				+ "]";
	}
	
	
}
