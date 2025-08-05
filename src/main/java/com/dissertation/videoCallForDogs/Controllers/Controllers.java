package com.dissertation.videoCallForDogs.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dissertation.videoCallForDogs.Dog;
import com.dissertation.videoCallForDogs.UserService;
import com.dissertation.videoCallForDogs.Users;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class Controllers {
	
	@Autowired
	UserService service;
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> Login(@RequestBody Users user) throws Exception {
		Users loggedInUser = service.Login(user);
		
		if(loggedInUser!=null) {
		System.out.println(user.getName() + "is logged in now!!");
		return ResponseEntity.ok(true);
		}
		return null;
			
	}
	
	@PostMapping("/login/dog")
	public ResponseEntity<Boolean> dogLogin(@RequestBody Dog dog) throws Exception{
	
		if(service.loginDog(dog)!=null) {
			return ResponseEntity.ok(true);
		}
		return null;
	}
	
	@PostMapping("/register")
	public void Register(Users user) {
		service.createUsers();
		 service.userRegister(user);
	}
	@PostMapping("/logout")
	public void Logout(Users user) {
		service.Logout(user);
	}
	
	@PostMapping("/logout/dog")
	public void Logout(@RequestBody String dogName) {
		
		System.out.println("Logging out your pet!");
		service.dogLogout(dogName);
	}
	
	@GetMapping("/viewAll")
	public List<Users> findAll(){
		service.createUsers();
		return service.ViewUsersList();
	}
	
	@PostMapping("/registerYourDog")
	public Boolean registerYourDog(@RequestBody Dog dog) throws Exception {
		System.out.print(dog.getDogName());
		service.registerDog(dog);
		return true;
		
	}
	
	@PostMapping("/viewAllPets")
	public List<Dog> viewAllPets(@RequestBody String ownerName){
		System.out.println("Calling to view all pets by" +ownerName);
		List<Dog> listOfDogs = service.findDogsWithOwnerName(ownerName);
		return  listOfDogs ;
	}
	

}
