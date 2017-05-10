/**
 * 
 */
var app = angular.module("myApp", [])

app.controller("myController" , ["$scope" , function($scope){
	
	$scope.title = "Books";
	$scope.name = "AngularJS";
	$scope.pubdate =new Date ('2016','05','20')
	
}
	
	
	
	
	])