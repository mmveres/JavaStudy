package jabber.entities;

import java.sql.Date;

public class Message {
	private int id;
	private int idFrom;
	private int idTo;
	private Date date;
	private String text;
	
	
	
	public Message(int idFrom, int idTo, Date date, String text) {
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.date = date;
		this.text = text;
	}

	
	
	
	public Message(int id, int idFrom, int idTo, Date date, String text) {
		this.id = id;
		this.idFrom = idFrom;
		this.idTo = idTo;
		this.date = date;
		this.text = text;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFrom() {
		return idFrom;
	}

	public void setIdFrom(int idFrom) {
		this.idFrom = idFrom;
	}

	public int getIdTo() {
		return idTo;
	}

	public void setIdTo(int idTo) {
		this.idTo = idTo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getLine(){
		return date +"> " + text;
	}

}
