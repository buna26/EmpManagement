import java.util.*;

class EmpDetails{
	private String firstname, lastname;
	private long empID;
	private String email;
	private String designation;
	private String password;
	
	EmpDetails(String firstname, String lastname, String email, String designation){
		this.firstname = firstname;
		this.lastname = lastname;
		this.empID = Math.abs(firstname.hashCode());
		this.email = email;
		this.designation = designation;
		this.password = defaultPassword();
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
		return email.indexOf('@') > -1 && email.indexOf("outlook") > -1 && email.endsWith(".com") ? true : false;
	}
	
	private String defaultPassword(){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$&";
		int length = 10;
        char [] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
	
	public void info() {
		System.out.println("Name : "+ firstname +" "+ lastname);
		System.out.println("Employee ID : "+ empID);
		if(!isValidEmail(email))
		    System.out.println("Email ID is not valid");
		else
		    System.out.println("Email ID : "+ email);
		System.out.println("Designation : "+ designation);
        System.out.println("Your Default Password is "+ password);
  }
}

class Employee{
	public static void main(String args[]){
		EmpDetails emp = new EmpDetails("Riya", "Das", "riyadas@gmail.com", "Analyst");
		EmpDetails emp1 = new EmpDetails("Raktim", "Deka", "raktimdek@outlook.com", "Bekar Shontan");
		emp.info();
		emp1.info();
	}
}
