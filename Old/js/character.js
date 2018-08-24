function sendAjaxGet(url, func) {
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function () {
        console.log(this.readyState);
        if (this.readyState === 4 && this.status === 200) {
            func(this);
        }
    };
    xhr.open("GET", url, true);
    xhr.send();
}

function setHeroInfo(xhr) {
    let res = JSON.parse(xhr.responseText);
    console.log(res.name);
    document.getElementById("name").innerHTML = res.name;
    document.getElementById("fullName").innerText = res.biography.fullName;
    document.getElementById("#").setAttribute("src", res.images.md);

    //Appearance Info
    let appearance = document.getElementById("appearance");
    let gender = document.createElement("p");
    gender.innerText = "Gender: " + res.appearance.gender;
    let race = document.createElement("p");
    race.innerText = "Race: " + res.appearance.race;
    let height = document.createElement("p");
    height.innerText = "Height: " + res.appearance.height;
    let weight = document.createElement("p");
    weight.innerText = "Weight: " + res.appearance.weight;
    appearance.append(gender, race, height, weight);

    //Powerstats
    let powerstats = document.getElementById("powerStats");
    let intelligence = document.createElement("p");
    intelligence.innerText = "Intelligence: " + res.powerstats.intelligence;
    let strength = document.createElement("p");
    strength.innerText = "Intelligence: " + res.powerstats.strength;
    let speed = document.createElement("p");
    speed.innerText = "Intelligence: " + res.powerstats.speed;
    let durability = document.createElement("p");
    durability.innerText = "Intelligence: " + res.powerstats.durability;
    let power = document.createElement("p");
    power.innerText = "Intelligence: " + res.powerstats.power;
    let combat = document.createElement("p");
    combat.innerText = "Intelligence: " + res.powerstats.combat;
    powerstats.append(intelligence, strength, speed, durability, power, combat);



}

window.onload = function () {
    // let heroID = window.location.pathname.split("/");
    let heroID = 1;
    sendAjaxGet("https://cdn.rawgit.com/akabab/superhero-api/0.2.0/api/id/" + heroID + ".json", setHeroInfo);
};