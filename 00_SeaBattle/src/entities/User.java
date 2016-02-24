package entities;

import java.io.Serializable;

public class User  implements Serializable{
	private int idUser;
	private String name;
	private int password;
	
	
	public User() {
	}
	
	
	
	public User(int idUser, String name) {
		this.idUser = idUser;
		this.name = name;
	}



	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUser;
		result = prime * result + password;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idUser != other.idUser)
			return false;
		if (password != other.password)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "" + name + "(" + idUser + ")";
	}




	
	

}
