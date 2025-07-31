package com.dissertation.videoCallForDogs;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Owner {
	
	int OwnerId;
	String ownerName;
	String password;
	String onwerStatus;
	List<Dog> dogs;
	
	
	public int getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOnwerStatus() {
		return onwerStatus;
	}
	public void setOnwerStatus(String onwerStatus) {
		this.onwerStatus = onwerStatus;
	}
	public List<Dog> getDogs() {
		return dogs;
	}
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

}
