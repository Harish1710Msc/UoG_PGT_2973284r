function dogRegister(){
	const dogName = document.getElementById("dogName").value;
	localStorage.setItem("dogName" ,dogName);
	const ownerName = localStorage.getItem("ownerName");
	const dogPassword = document.getElementById("dogPassword").value;
	
	
	const dog ={
		
		dogName:dogName,
		dogPassword:dogPassword,
		ownerName:ownerName,
		dogStatus:'offline'
		
	};
	console.log(JSON.stringify(dog))
	
	fetch('https://dogvideocall-latest.onrender.com/api/v1/users/registerYourDog',{
	//fetch('http://localhost:8085/api/v1/users/registerYourDog',{
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
			alert('Registration success! Going back to home!')
			window.location.href = './Homepage.html'
			return response.json();
		}).catch(error => {
			console.error('POST request error',error)
		});
	
}




const dogRegisterForm = document.getElementById("dogRegister");

dogRegisterForm.addEventListener("submit",dogRegister)