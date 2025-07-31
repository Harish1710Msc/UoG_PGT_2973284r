
function handleLogin(event){
	event.preventDefault();
	
	const name = document.getElementById("ownerName").value;
	const password = document.getElementById("password").value;
	localStorage.setItem("ownerName",name);
	const user = {
		name:name,
		password:password
	};
	
	fetch('http://localhost:8085/api/v1/users/login',{
		method: 'POST',
		headers: {
			'Content-Type' : 'application/json'
		},
		body: JSON.stringify(user)
	}).then(response => {
		
		if(!response.ok){
			alert('Login/Password is incorrect');
			throw new Error('Login failed');
			
		}
		return response.json();
	}). then((response) => {
		localStorage.setItem('connectedUser', JSON.stringify(response));
		window.location.href = 'index.html'
	}).catch(error => {
		console.error('POST request error',error)
	});
	
}

const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", handleLogin);

