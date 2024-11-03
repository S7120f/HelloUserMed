function loginFunc(event) {
  event.preventDefault(); // prevent the form from submitting normally, which would relad the page

  // controll username and password before we sending the information
  var user = document.getElementById("username").value; // retrieve value username
  var pass = document.getElementById("password").value; // retrieve value password
  var result = document.getElementById("result");

  // set username/password always to admim in localStorage
  localStorage.setItem("username", "admin");
  localStorage.setItem("password", "admin");

  //retrieve stored value from localStorage
  var storedUsername = localStorage.getItem("username");
  var storedPassword = localStorage.getItem("password");

  // check if username and password is correct
  if (user === "" || pass === "") {
    result.innerHTML = "Användarnamn och lösenord får inte vara tomma.";
  } else if (user !== storedUsername || pass !== storedPassword) {
    result.innerHTML =
      "Du har angivet ett felaktigt användarnamn eller lösenord. Var vänligen och försök igen";
  } else {
    result.innerHTML = "Inloggad, Välkommen!";
    localStorage.setItem("isLoggedIn", "true"); // set login status
    showAdminFeatures(); // show function for logged in admin
  }
}

function logout() {
  localStorage.removeItem("isLoggedIn"); // remove login status
  localStorage.removeItem("username"); // remove username
  localStorage.removeItem("password"); // remove password
  hideAdminFeatures(); // hide admin-function
  document.getElementById("result").innerHTML = "Du har loggat ut";
}

function checkLoginStatus() {
  // retrieve the login satsu from localStorage
  const isLoggedIn = localStorage.getItem("isLoggedIn") == "true";

  //if the user is loged inm show admin features
  if (isLoggedIn) {
    showAdminFeatures();
  } else {
    //if the user is not logged in, hide admin features
    hideAdminFeatures();
  }
}

function showAdminFeatures() {
  document.getElementById("adminFeatures").style.display = "block"; // show admin-function
}

function hideAdminFeatures() {
  document.getElementById("adminFeatures").style.display = "none"; // hide admin-function
}

// call checkLoginStatus on page laod
document.addEventListener("DOMContentLoaded", checkLoginStatus);
