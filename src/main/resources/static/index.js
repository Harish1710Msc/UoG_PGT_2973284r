function loadAndDisplayPets(){
	const userListElement = document.getElementById("petList");
	const ownerName = localStorage.getItem('ownerName');
	userListElement.innerHTML='Loading...';
	
	fetch('http://localhost:8085/api/v1/users/viewAllPets',{
		method: 'POST',
		headers: {
					'Content-Type' : 'application/json'
				},
				body: JSON.stringify(ownerName)
	})
	 .then((response)=>{
		return response.json();
		
	})
	.then((data) =>{
		console.log(data);
		displayPets(data,userListElement);
	});
}


function displayPets(petList, userListElement){
	userListElement.innerHTML ="";
	
	petList.forEach(pet =>{
		const listItem = document.createElement("li");
		listItem.innerHTML=`
		<div>
		<i class="fa -user-circle"></i>
		${pet.dogName} <i class="user-name">(${pet.dogStatus})</li>
		<button class='joinMeeting'> Video Call </button>
		</div>
			`;
	userListElement.appendChild(listItem);
	
	const videoCallButton = listItem.querySelector(".joinMeeting");
	    videoCallButton.addEventListener("click", () => {
			const ownerName = localStorage.getItem('ownerName');
	        const roomId = localStorage.getItem('roomId')
			window.open(`videoCallHTML.html?roomID=${roomId}&username=${ownerName}`);
	        console.log(`Starting video call with ${pet.dogName} (${pet.dogStatus})`);
	        
	    });

	});
}

window.addEventListener("load",loadAndDisplayPets);


function joinExistingMeeting(){

	window.open(`videoCallHTML.html?username=${ownerName}`);
}


const joinMeeting = window.getElementById('joinMeeting');
joinMeeting.addEventListener("click", joinExistingMeeting);