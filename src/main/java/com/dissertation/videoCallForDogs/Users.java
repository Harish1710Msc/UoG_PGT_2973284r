package com.dissertation.videoCallForDogs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
	
	private String name;
	private String password;
	private Boolean isPet;
	private Boolean isOwner;
	private String status; 
	private String Dog;

	
	
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsPet() {
		return isPet;
	}
	public void setIsPet(Boolean isPet) {
		this.isPet = isPet;
	}
	public Boolean getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
