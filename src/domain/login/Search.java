package domain.login;

public class Search {
	String[] date;
	String[] events;
	String[] price;
	public Search(){}
	public Search(String[] date, String[] events, String[] price) {
		super();
		this.date = date;
		this.events = events;
		this.price = price;
	}
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public String[] getEvents() {
		return events;
	}
	public void setEvents(String[] events) {
		this.events = events;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String[] price) {
		this.price = price;
	}
	

}
