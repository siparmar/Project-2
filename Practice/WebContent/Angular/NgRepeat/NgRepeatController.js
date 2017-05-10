/**
 * 
 */

var app = angular.module("myApp", []);

app.controller("myController", [ "$scope", function($scope) {
	$scope.title = "Books";
	$scope.products = [ {
		name : "First book",
		price : 10,
		pubdate : new Date('2015', '01', '03')
	}, {
		name : "Second book",
		price : 20,
		pubdate : new Date('2016', '04', '02')
	} ];
}])
