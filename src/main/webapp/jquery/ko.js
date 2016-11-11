 // This is a simple *viewmodel* - JavaScript that defines the data and behavior of your UI
  	function AppViewModel() {
  		this.test = $("#inputAgents").attr('data');
  		this.agents = JSON.parse(this.test);
  	}
 
//  	$.post("kojson", {data:jsonData}, function(returnedData) {
//  	});no

  	// Activates knockout.js
  	ko.applyBindings(new AppViewModel());