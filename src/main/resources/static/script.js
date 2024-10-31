function loginFunc(event) {
  event.preventDefault();

  var user = document.getElementById("username").value // retrieve value username
  var pass = document.getElementById("password").value // retrieve value password
  var result = document.getElementById("result");

  // set username/password always to admim
  localStorage.setItem("username", "admin");
  localStorage.setItem("password", "admin");

  //retrieve stored value
  var storedUsername = localStorage.getItem("username");
  var storedPassword = localStorage.getItem("password");

  // check if username and password is correct
  if (user === "" || pass === "") {
    result.innerHTML = "Användarnamn och lösenord får inte vara tomma.";
  } else if (user !== storedUsername || pass !== storedPassword) {
    result.innerHTML = "Du har angivet ett felaktigt användarnamn eller lösenord. Var vänligen och försök igen";
  } else {
    result.innerHTML = "Inloggad, Välkommen!";
    localStorage.setItem("isLoggedIn", "true"); // sätt inloggningstatus
    showAdminFeatures(); // visa funktioner för inloggade användare 
  }
}

function logout() {
    localStorage.removeItem("isLoggedIn"); // ta bort inloggningsstatus
    localStorage.removeItem("username"); // ta bort användarnamn
    localStorage.removeItem("password"); // ta bort lösenord
    hideAdminFeatures(); // dölj admin funktniomner
    document.getElementById("result").innerHTML = "Du har loggat ut"
}

function checkLoginStatus() {
    const isLoggedIn = localStorage.getItem("isLoggedIn") == "true";

    if (isLoggedIn) {
        showAdminFeatures();
    } else {
        hideAdminFeatures(); 
    }
}


function showAdminFeatures() {
    document.getElementById("adminFeatures").style.display = "block"; // visa admin-funktioner
}

function hideAdminFeatures(){
    document.getElementById("adminFeatures").style.display = "none"; // dölj admin-funtkioner
}

// anropa chechLoginStatus vid sidladdning
document.addEventListener("DOMContentLoaded", checkLoginStatus);