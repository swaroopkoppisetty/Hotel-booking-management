package cap.sprint.capsprinthbms.entities;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "roomId")
public class RoomDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int roomId;
	
	@Column(unique = true)
	String roomNo;
	String roomType;
	double rate_per_day;
	boolean isavailable;
	
	String fileName;

    String fileType;
	
	@Lob
	byte[] data;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hotel_id")
	Hotel hotel;
	
	public RoomDetails() {
		
	}

	
	

	public RoomDetails( String roomNo, String roomType, double rate_per_day, boolean isavailable,
			Hotel hotel) {
		super();
		//this.room_id = room_id;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.rate_per_day = rate_per_day;
		this.isavailable = isavailable;
		this.hotel = hotel;
	}

	



	



	public RoomDetails(String roomNo, String roomType, double rate_per_day, boolean isavailable, String fileName,
			String fileType, byte[] data) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.rate_per_day = rate_per_day;
		this.isavailable = isavailable;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		
	}




	public int getRoomId() {
		return roomId;
	}






	public Hotel getHotel() {
		return hotel;
	}




	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}




	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}





	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public double getRate_per_day() {
		return rate_per_day;
	}


	public void setRate_per_day(double rate_per_day) {
		this.rate_per_day = rate_per_day;
	}
	
	
	


	


	public String getFileName() {
		return fileName;
	}




	public void setFileName(String fileName) {
		this.fileName = fileName;
	}




	public String getFileType() {
		return fileType;
	}




	public void setFileType(String fileType) {
		this.fileType = fileType;
	}




	public byte[] getData() {
		return data;
	}




	public void setData(byte[] data) {
		this.data = data;
	}




	public boolean isIsavailable() {
		return isavailable;
	}




	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}




	public RoomDetails(int roomId, String roomNo, String roomType, double rate_per_day, boolean isavailable,
			Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.rate_per_day = rate_per_day;
		this.isavailable = isavailable;
		this.hotel = hotel;
	}




	



	public RoomDetails(int roomId, String roomNo, String roomType, double rate_per_day, boolean isavailable,
			String fileName, String fileType, byte[] data, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.rate_per_day = rate_per_day;
		this.isavailable = isavailable;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.hotel = hotel;
	}




	@Override
	public String toString() {
		return "RoomDetails [room_id=" + roomId + ", roomNo=" + roomNo + ", roomType="
				+ roomType + ", rate_per_day=" + rate_per_day + ", isavailable=" + isavailable + "]";
	}




}
