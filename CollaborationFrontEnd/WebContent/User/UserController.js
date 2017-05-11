/**
 * 
 */
var app = angular.module("app", [])

app.controller("UserController", function($scope, $location, UserService) {

	$scope.user = {
		user_id : "",
		name : "",
		password : "",
		role : "",
		address : "",
		contact : "",
		isOnline : " ",
	}
	$scope.login = function() {
		UserService.login($scope.user).then(
			function(response) {
			$scope.user = response.data
			$location.path("/Home")
		}, function(response) {
			$scope.user = "Invalid user"
			$location.path("/Login")
		}

		)
	}

	$scope.register = function() {
		UserService.register($scope.user).then(
			function(response) {
			$scope.message("User registered")
			$location.path("/Login")
		}, function(response) {
			$scope.errorMessage("Registeration failed")
			$location.path("/Register")
		})
	}
})