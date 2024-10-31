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
  } else if (user !== storedUsername) {
    result.innerHTML = "Du har angivet ett felaktigt användarnamn eller lösenord. Var vänligen och försök igen";
  } else if (pass !== storedPassword) {
    result.innerHTML = "Du har angivet ett felaktigt användarnamn eller lösenord. Var vänligen och försök igen";
  } else {
    result.innerHTML = "Inloggad, Välkommen!";
  }
}
