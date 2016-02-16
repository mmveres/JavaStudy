package jabber.entities;

public class User {
	private int id;
	private String name;
	private String comments;
	private int pwd;
	
	public User(String name, int pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	
	
	public User(int id, String name, String comments, int pwd) {
		this.id = id;
		this.name = name;
		this.comments = comments;
		this.pwd = pwd;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return ""+ name + "(" + id + ")";
	}
	
	

}
