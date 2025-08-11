
	
	function socketTestFunction(elementId){	
		console.log("Inside VC JS file");
		
		
		//const socket = new WebSocket('ws://localhost:8085/websocket-endpoint');
		const socket = new WebSocket('wss://dogvideocall-latest.onrender.com/websocket-endpoint');
		
		socket.onopen = () => {
			console.log('Connected');
			console.log(elementId);
			socket.send(JSON.stringify({event:"click",elementId: elementId}));
		};
		
		
			
		
		socket.onmessage = (event) => {
			console.log("Inside handler with data")
			console.log(event.data)
			const data = JSON.parse(event.data);
			
			if(data.event === "click" && data.elementId){
				console.log("Inside click event for whistle")
				const target = document.getElementById(elementId);
				
				if(target){
					console.log(target);
					target.play().catch(err =>{
						console.error('Error',err);
					});
				}
			}
			
		};
		
		socket.onerror = (error) => {
			console.error('Socket error',error);
		}
		
		/*const sock = io('socket.io')(8085, {
			cors: {
			origin: ['http://localhost:8085'],
			},
		})
		
	
		
		sock.on('connection',socket =>{
			console.log(socket.id)
		})*/
		
		}
		
		
		const socketTest = document.getElementById('socketTest');
		socketTest.addEventListener("click",() =>socketTestFunction('whistle'));
		
		
		const birdSound = document.getElementById('birdTest');
		birdSound.addEventListener("click" ,() => socketTestFunction('birdSound'));