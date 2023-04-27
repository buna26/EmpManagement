import java.util.*;

class EmpDetails{
	private String firstname, lastname;
	private long empID;
	private String email;
	private String designation;
	
	EmpDetails(String firstname, String lastname, String email, String designation){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empID = Math.abs(firstname.hashCode());
		this.email = email;
		this.designation = designation;
	}	
	
	public void setFristName(String firstname) { this.firstname = firstname; }
	public String getFirstName() { return firstname; }
	
	public void setLastName(String lastname) { this.lastname = lastname; }
	public String getLastName() { return lastname; }
	
	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return email; }
	
	public void setDesignation(String designation) { this.designation = designation; }
	public String getDesignation() { return designation; }

	public boolean isValidEmail(String email){ 
		return email.indexOf('@') > -1 && email.endsWith(".com") ? true : false;
	}
	
	public void info() {
    System.out.println("Name : "+ firstname +" "+ lastname);
		System.out.println("Employee ID : "+ empID);
		if(!isValidEmail(email))
		    System.out.println("Email ID is not valid");
		else
		    System.out.println("Email ID : "+email);
		System.out.println("Designation : " + designation);
  }
}

class Employee{
	public static void main(String args[]){
		EmpDetails emp = new EmpDetails("Riya", "Das", "riyadas@gmail.com", "Analyst");
    EmpDetails emp1 = new EmpDetails("Raktim", "Deka", "raktimdek.adad", "Bekar Shontan");
		emp.info();
    emp1.info();
	}
}
