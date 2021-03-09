package cap.sprint.capsprinthbms.entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Hotel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int hotelId;
	String city;
	String hotelName;
	String address;
	String description;
	double average_rate_per_day;
	String email;
	String phone1;
	String phone2;
	String website;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	List<RoomDetails> roomDetailsList;
	
	public Hotel() {
		
	}


	public Hotel(String city, String hotelname, String address, String description, double average_rate_per_day,
			String email, String phone1, String phone2, String website) {
		super();
		this.city = city;
		this.hotelName = hotelname;
		this.address = address;
		this.description = description;
		this.average_rate_per_day = average_rate_per_day;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
	}


	public Hotel(String city, String hotelname, String address, String description, double average_rate_per_day,
			String email, String phone1, String phone2, String website, List<RoomDetails> roomDetailsList) {
		super();
		this.city = city;
		this.hotelName = hotelname;
		this.address = address;
		this.description = description;
		this.average_rate_per_day = average_rate_per_day;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
		this.roomDetailsList = roomDetailsList;
	}




	public Hotel(int hotelId, String city, String hotelname, String address, String description,
			double average_rate_per_day, String email, String phone1, String phone2, String website) {
		super();
		this.hotelId = hotelId;
		this.city = city;
		this.hotelName = hotelname;
		this.address = address;
		this.description = description;
		this.average_rate_per_day = average_rate_per_day;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.website = website;
	}


	public int getHotelId() {
		return hotelId;
	}


	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getHotelName() {
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getAverage_rate_per_day() {
		return average_rate_per_day;
	}


	public void setAverage_rate_per_day(double average_rate_per_day) {
		this.average_rate_per_day = average_rate_per_day;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}

	public List<RoomDetails> getRoomDetailsList() {
		return roomDetailsList;
	}


	public void setRoomDetailsList(List<RoomDetails> roomDetailsList) {
		this.roomDetailsList = roomDetailsList;
	}


	@Override
	public String toString() {
		return "Hotel [hotelid=" + hotelId + ", city=" + city + ", hotelname=" + hotelName + ", address=" + address
				+ ", description=" + description + ", average_rate_per_day=" + average_rate_per_day + ", email=" + email
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", website=" + website+"]";
	}


	
	
}