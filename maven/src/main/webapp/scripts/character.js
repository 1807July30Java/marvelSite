/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function (){
		if (this.readyState === 4 && this.status === 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
}

function populateHeroes(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		
		var h = document.getElementByID("Heroes");
	}
}

window.onload = function () {
	sendAjaxGet("http://localhost:8084/Marvelous/CharacterServlet", populateHeroes);
}