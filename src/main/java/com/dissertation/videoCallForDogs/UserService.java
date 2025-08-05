package com.dissertation.videoCallForDogs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	

	private List<Users> UserList = new ArrayList<>();
	private List<Dog> dogList = new ArrayList<>();

	public List<Users> createUsers() {
		List<Users> newList = new ArrayList<>();
		Users owner = new Users();
		owner.setName("Participant1");
		owner.setPassword("1234");
		owner.setIsOwner(true);
		owner.setIsPet(false);
		userRegister(owner);
		newList.add(owner);
		
		
		Users owner1 = new Users();
		owner1.setName("Participant2");
		owner1.setPassword("1234");
		owner1.setIsOwner(true);
		owner1.setIsPet(false);
		userRegister(owner1);
		newList.add(owner1);
		
		Users owner2 = new Users();
		owner2.setName("Participant3");
		owner2.setPassword("1234");
		owner2.setIsOwner(true);
		owner2.setIsPet(false);
		userRegister(owner2);
		newList.add(owner2);
		
		
		return newList;

	}

	public void userRegister(Users users) {

		users.setStatus("Online");
		UserList.add(users);

	}

	public Users Login(Users user) throws Exception {
		List<Users> RegisteredUserlist = createUsers();
		for (Users users : RegisteredUserlist) {
			if ((users.getName().equals(user.getName())) && (users.getPassword().equals(user.getPassword()))) {
				user.setStatus("Online");
				System.out.println("User" + user.getName() + "is logged in!");
				return user;
			}  
		}

		throw new Exception("Wrong credentials");

	}

	public Dog loginDog(Dog dog) throws Exception {

		for (Dog petDog : dogList) {
			if ((petDog.getDogName().equals(dog.getDogName()))
					&& (petDog.getDogPassword().equalsIgnoreCase(dog.getDogPassword()))) {
				petDog.setDogStatus("Online");
				System.out.println("Your pet is logged online");
				return petDog;
			}
		}
		return null;
	}

	public void Logout(Users user) {
		for (Users users : UserList) {
			if (users.getName().equals(user.getName())) {
				user.setStatus("Offline");
//				user.setName("NAN");
			}
		}
	}
	
	public void dogLogout(String dogName) {
		System.out.println(dogList.size());
		for(Dog dog : dogList) {
			System.out.println(dog.dogName + dogName);
			
			if(dogName.contains(dog.getDogName())) {
				dog.setDogStatus("Offline");
				System.out.println("Your dog is offline");
			}
		}
	}

	public List<Users> ViewUsersList() {
		return UserList;
	}

	public void registerDog(Dog dog) {
		System.out.println("Registering the dog!");
		dog.setDogStatus("Offline");
		dogList.add(dog);
		System.out.println(dogList.get(0).getDogName());

	}

	public List<Dog> findDogsWithOwnerName(String ownerName) {
		System.out.println(dogList.size());
		List<Dog> returnListOfDogs = new ArrayList<>();
		for (Dog dog : dogList) {
			String dogOwnerName = dog.getOwnerName();
			if (ownerName.contains(dogOwnerName)) {
				returnListOfDogs.add(dog);
			} else {
				System.out.println("No Dogs for this Owner!");
			}
		}
		return returnListOfDogs;
	}
	
	

}
