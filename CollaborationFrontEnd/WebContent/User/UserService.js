/**
 * 
 */
app.service("UserService" , function($http){
	
	var userService = this 
	var BASE_URL = "http://localhost:8081/CollaborationBackEndNew"
		
		
		userService.login = function(user){
		return $http.post(BASE_URL , "/Login", user)
	}
	
	
	 userService.register = function(user){
		 return $http.post(BASE_URL , "/Register" , user)
	 }


}
)

