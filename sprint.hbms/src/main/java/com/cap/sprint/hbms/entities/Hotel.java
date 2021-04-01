package com.cap.sprint.hbms.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about the Hotel")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "hotelId")
public class Hotel {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Hotel id for a booking")
	private int hotelId;
	
	@ApiModelProperty(notes = "Hotel City")
	private String city;
	
	@ApiModelProperty(notes = "Hotel Name")
	private String hotelName;
	
	@ApiModelProperty(notes = "Hotel Address")
	private String address;
	
	@ApiModelProperty(notes = "Hotel Description")
	String description;
	
	@ApiModelProperty(notes = "Average price of rooms")
	private double average_rate_per_day;
	
	@ApiModelProperty(notes = "Hotel Email")
	@Pattern(regexp = "^(.+)@(.+)$", message = "Provide valid email")
	private String email;
	
	@ApiModelProperty(notes = "Hotel Primary Phone No")
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Numbers only")
	@Size(min = 10, max = 10, message = "Mobile Number should be 10 digits")
	private String phone1;
	
	@ApiModelProperty(notes = "Hotel Secondary Phone No")
	@Pattern(regexp = "^[7-9][0-9]{9}$", message = "Numbers only")
	@Size(min = 10, max = 10, message = "Mobile Number should be 10 digits")
	private String phone2;
	
	@ApiModelProperty(notes = "Hotel Website")
	private String website;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
	@ApiModelProperty(notes = "Rooms to be booked")
	private List<RoomDetails> roomDetailsList;
	
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
	public String toString() 
	{
		return "Hotel [hotelid=" + hotelId + ", city=" + city + ", hotelname=" + hotelName + ", address=" + address
				+ ", description=" + description + ", average_rate_per_day=" + average_rate_per_day + ", email=" + email
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", website=" + website+"]";
	}


	
	
}