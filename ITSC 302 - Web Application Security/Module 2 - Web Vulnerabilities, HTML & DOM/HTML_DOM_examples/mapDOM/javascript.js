//Use forms array to find first form in page, print out "action" attribute of that form
function map1()
{
	var form=document.forms[0];
	
	alert(form.getAttribute("action"));
}

//Use id of loginForm to locate it, print out "action" attribute
function map2()
{
	var form=document.getElementById("loginForm");

	alert(form.getAttribute("action"));	
}

//Map out all elements in page
function map3()
{
	//Get array of all elements in page
	var all = document.getElementsByTagName("*");
	var report="";

	for (var i=0; i<all.length; i++)
	{
		//If element is a form show it's action and method also
		if (all[i].tagName=="FORM")
			report += "TAGNAME:"+all[i].tagName + ",NAME:" + all[i].name + ",ACTION:" + all[i].action + ",METHOD:" + all[i].method + "\n";
		//If node is of type "input" indent it by a tab
		else if (all[i].tagName=="INPUT")
			report += "\tTAGNAME:" + all[i].tagName + ",NAME:" + all[i].name + ",VALUE:" + all[i].value + "\n";
		//Otherwise just show node data
		else
			report += "TAGNAME:" + all[i].tagName + ",NAME:" + all[i].name + ",VALUE:" + all[i].value + "\n";
	}
		
	alert(report);
	
}