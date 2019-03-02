package P1;

public class Guest {
	
	private String firstname;
	private String lastname;
	private String email;
	private int phoneNo;
	private int orderNo;
	
	public Guest(String firstname, String lastname, String email, int phoneNo, int orderNo) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.orderNo = orderNo;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setFirstname (String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean checkFirstname(String firstname) {
		return firstname.toLowerCase().equals(this.firstname.toLowerCase());
	}
	public boolean checkLastname(String lastname) {
		return lastname.toLowerCase().equals(this.lastname.toLowerCase());
	}
	public boolean checkEmail(String email) {
		return email.toLowerCase().equals(this.email);
	}
	public boolean checkPhoneNo(int phoneNo) {
		return phoneNo == this.phoneNo;
	}
	
	public int getOrderNo() {
		return this.orderNo;
	}
	
	/**
	 * Metoda creata pentru testare
	 * @param orderNo int
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return String.format("Nume: %s, prenume: %s,  email: %s, numar telefon: %,012d, numar ordine: %d%n", this.firstname, this.lastname, this.email, this.phoneNo, this.orderNo);
	}
}
