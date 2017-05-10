/**
 * 
 */

var app = angular.module("myApp", [])

app.controller("myController", [ "$scope", function($scope) {

	$scope.title ="Books";
	$scope.name = "Angular JS Programming";
	$scope.pubdate = new Date('2016','04','01');
	$scope.price = 50;
} ])
