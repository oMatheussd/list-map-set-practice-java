package entities;

public class Participation {
	
	private String eventName;
	private String email;
	
	public Participation(String eventName, String email) {
		this.eventName = eventName;
		this.email = email;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
