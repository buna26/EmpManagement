import java.util.*;
import java.security.SecureRandom;

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
	public String getFirstName() { return this.firstname; }
	
	public void setLastName(String lastname) { this.lastname = lastname; }
	public String getLastName() { return this.lastname; }
	
	public void setEmail(String email) { this.email = email; }
	public String getEmail() { return this.email; }
	
	public void setDesignation(String designation) { this.designation = designation; }
	public String getDesignation() { return this.designation; }

	public boolean isValidEmail(String email){ 
		return this.email.indexOf('@') > -1 && this.email.endsWith(".com") ? true : false;
	}
	
	private String defaultPassword(){
	    int length = 10;
      char password[] = new char[length];
      for(int i = 0; i < length; i++) {
        int ch = new SecureRandom().nextInt(4 - 1) + 1, rand;
        switch(ch) {
          case 1: { 
            rand = new SecureRandom().nextInt(90 - 65) + 65;
            password[i] = (char)(rand);
            break;
            }
          case 2: {
            rand = new SecureRandom().nextInt(122 - 97) + 97;
            password[i] = (char)(rand);
            break;
            }
          case 3: {
            rand = new SecureRandom().nextInt(57 - 48) + 48;
            password[i] = (char)(rand);
            break;
            }
          case 4: {
            rand = new SecureRandom().nextInt(47 - 33) + 33;
            password[i] = (char)(rand);
            break;
            }
        default: continue;
        }
      }
    return new String(password);
	}
	
	private String strengthCheck(String password){
		int uppercaseCount = 0;
		int lowercaseCount = 0;
		int digitCount = 0;
		String specialCharSet = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		int specialCharCount = 0;
		
		for(int i = 0; i < password.length(); i++){
			if(password.charAt(i) >= 65 && password.charAt(i) <= 90){	uppercaseCount++;	}
			
			if(password.charAt(i) >= 97 && password.charAt(i) <= 122){	lowercaseCount++;	}
			
			if(password.charAt(i) >= 48 && password.charAt(i) <= 57){	digitCount++;	}
			
			if(specialCharSet.contains(Character.toString(password.charAt(i)))) {	specialCharCount++;    }
		}
		
		if(uppercaseCount < 2 && digitCount <= 2 && password.length() < 8 && specialCharCount < 1){ return "Weak"; }
		else if(uppercaseCount <= 3 && digitCount < 5 && specialCharCount < 2 && password.length() <= 15){ return "Medium"; }
		else { return "Strong"; }
		
	}
	
	public void setPassword(String password){
		System.out.println(password);
		System.out.println(strengthCheck(password));
	}
	
	public void info() {
		System.out.println("Name : "+ this.firstname +" "+ lastname);
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
		
		emp.setPassword("Riya@345A#");
	}
}
