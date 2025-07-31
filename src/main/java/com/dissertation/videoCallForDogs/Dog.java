package com.dissertation.videoCallForDogs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dog {

	//int dogId;
	String ownerName;
	String dogName;
	String dogPassword;
	String dogStatus;
	
	
//	public int getDogId() {
//		return dogId;
//	}
//	public void setDogId(int dogId) {
//		this.dogId = dogId;
//	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getDogPassword() {
		return dogPassword;
	}
	public void setDogPassword(String dogPassword) {
		this.dogPassword = dogPassword;
	}
	public String getDogStatus() {
		return dogStatus;
	}
	public void setDogStatus(String dogStatus) {
		this.dogStatus = dogStatus;
	}
	
	
	
}
