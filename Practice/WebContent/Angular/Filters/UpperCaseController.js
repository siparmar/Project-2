/**
 * 
 */

var app = angular.module("myApp", [])

app.controller("myController", [ "$scope", function($scope) {

	$scope.title = "New Book";
	$scope.name = "AngularJS";

}

])
