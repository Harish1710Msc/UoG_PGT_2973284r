function dogRegister(){
	const dogName = document.getElementById("dogName").value;
	const ownerName = localStorage.getItem("ownerName");
	const dogPassword = document.getElementById("dogPassword").value;
	
	
	const dog ={
		
		dogName:dogName,
		dogPassword:dogPassword,
		ownerName:ownerName,
		dogStatus:'offline'
		
	};
	console.log(JSON.stringify(dog))
	fetch('http://localhost:8085/api/v1/users/registerYourDog',{
			method: 'POST',
			headers: {
				'Content-Type' : 'application/json'
			},
			body: JSON.stringify(dog)
		}).then(response => {
			
			if(!response.ok){
				alert('Error in registration');
				throw new Error('Registration failed');
				
			}
			return response.json();
		}).catch(error => {
			console.error('POST request error',error)
		});
	
}




const dogRegisterForm = document.getElementById("dogRegister");

dogRegisterForm.addEventListener("submit",dogRegister)