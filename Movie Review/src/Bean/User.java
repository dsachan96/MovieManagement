package Bean;

import Main.runner;

public class User {
	String name;
	String role;
	public User(String name) throws Exception{
		runner r = new runner();
		if(!r.checkUserExists(name)){
			this.name = name;
			this.role = "user";
		}
		else{
			throw new Exception("User Already Exist");
		}
	}
	public String getUserName(){
		return this.name;
	}
	public void modify(){
		this.role = "critic";
	}
	public String getRole() {
		// TODO Auto-generated method stub
		return role;
	}
}
