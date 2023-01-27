package dto;

public class book {
private int id;
private String bname;
private String author;
private String company;
public book(int id, String bname, String author, String company) {
	super();
	this.id = id;
	this.bname = bname;
	this.author = author;
	this.company = company;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBname() {
	return bname;
}
public void setBname(String bname) {
	this.bname = bname;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}

}
