 function sendAjaxGet(url, func) {
    var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function () {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    };
    xhr.open("GET", url, true);
    xhr.send();
};

function displayHeroList(xhr) {
    var res = JSON.parse(xhr.responseText);
    var resultDiv = document.getElementById("displayHeroes");

    console.log("entered");
    for (var i = 0; i < res.length; i++) {
    	if (res[i].biography.publisher == "Marvel Comics" && res[i].biography.alignment == "good"){
	    	var hero = document.createElement("li");

            var a = document.createElement("a");
            a.textContent = res[i].name;;
            var hrefp = "character/" + i;
            a.setAttribute('href', hrefp);
            hero.appendChild(a);

            resultDiv.appendChild(hero);
    	}
    }
   

}

window.onload = function () {
	sendAjaxGet('https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/all.json', displayHeroList);
};
