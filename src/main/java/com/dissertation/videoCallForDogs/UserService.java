package com.dissertation.videoCallForDogs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<Users> UserList = new ArrayList<>();
	private List<Dog> dogList = new ArrayList();

	public List<Users> createUsers() {
		List<Users> newList = new ArrayList<>();
		Users owner = new Users();
		owner.setName("Harish");
		owner.setPassword("1234");
		owner.setIsOwner(true);
		owner.setIsPet(false);
		userRegister(owner);
		newList.add(owner);
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
			} else {
				throw new Exception("Wrong credentials supplied!");
			}
		}

		return null;

	}

	public Dog loginDog(Dog dog) throws Exception {

		for (Dog petDog : dogList) {
			if ((petDog.getDogName().equals(dog.getDogName()))
					&& (petDog.getDogPassword().equalsIgnoreCase(dog.getDogPassword()))) {
				petDog.setDogStatus("Online");
				return petDog;
			}
		}
		return null;
	}

	public void Logout(Users user) {
		for (Users users : UserList) {
			if (users.getName().equals(user.getName())) {
				user.setStatus("Offline");
				user.setName("NAN");
			}
		}
	}
	
	public void dogLogout(String dogName) {
		for(Dog dog : dogList) {
			if(dog.getDogName().equals(dogName)) {
				dog.setDogStatus("Offline");
			}
		}
	}

	public List<Users> ViewUsersList() {
		return UserList;
	}

	public void registerDog(Dog dog) {
		System.out.println("Registering the dog!");
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
