
function handlePetLogin(event){
	event.preventDefault();
	
	const name = document.getElementById("dogName").value;
	const password = document.getElementById("dogPassword").value;
	
	const dog = {
		dogName:name,
		dogPassword:password
	};
	
	fetch('https://dogvideocall-latest.onrender.com/api/v1/users/login/dog',{
	
	//fetch('http://localhost:8085/api/v1/users/login/dog',{
		method: 'POST',
		headers: {
			'Content-Type' : 'application/json'
		},
		body: JSON.stringify(dog)
	}).then(response => {
		
		if(!response.ok){
			alert('Login/Password is incorrect');
			throw new Error('Login failed');
			
		}
		return response.json();
	}). then((response) => {
		localStorage.setItem('connectedUser', JSON.stringify(response));
		alert('Logged in!')
		const ownerName = localStorage.getItem('ownerName');
		window.open(`videoCallHTML.html?username=${ownerName}`,target="_blank");
		//window.location.href = 'videoCallHTML.html'
	}).catch(error => {
		console.error('POST request error',error)
	});
	
}

const loginForm = document.getElementById("petLoginForm");
loginForm.addEventListener("submit", handlePetLogin);

