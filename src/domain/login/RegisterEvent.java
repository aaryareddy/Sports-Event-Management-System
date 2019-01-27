package domain.login;
/**
 * 
 * @author mehra
 *
 */
public class RegisterEvent {

	private String username;
	private String phonenumber;
	private String eventname;
	private String category;
	private String address;
	
	public RegisterEvent() {
	}
	
	public RegisterEvent(String username, String phonenumber, String eventname, String category, String address)
	{
		super();
		this.username = username;
		this.phonenumber = phonenumber;
		this.eventname = eventname;
		this.category = category;
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPhoneNumber() {
		return phonenumber;
	}
	
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getEventName() {
		return eventname;
	}
	public void setEventName(String eventname) {
		this.eventname= eventname;
	}
	
    public String getCategory() {
    	return category;
    }
    
    public void setCategory(String category) {
    	this.category= category;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
	
}

