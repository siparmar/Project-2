/**
 * 
 */
var app = angular.module("myApp", [])

app.controller("myController", [ "$scope", function($scope) {
	$scope.title = "Books";
	$scope.name = "Programming AngularJS";
} ])