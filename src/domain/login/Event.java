package domain.login;

import java.sql.Date;

public class Event {
	private int eventId;
	private String topic;
	private String eventType;
	private Date eventDate;
	private String location;
	private float price;
	private String eventTime;
	private String description;

	
	public Event() {
	}
	
	public Event(int eventId, String topic, String eventType, Date eventDate, String location, float price,
			String eventTime, String description) {
		super();
		this.eventId = eventId;
		this.topic = topic;
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.location = location;
		this.price = price;
		this.eventTime = eventTime;
		this.description = description;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
