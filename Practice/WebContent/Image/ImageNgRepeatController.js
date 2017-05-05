/**
 * 
 */

var app = angular.module("myApp", [])

app.controller("MyController", ["$scope", function($scope) {

	$scope.title = "Books";
	$scope.products = [ {
		name : "Book 1",
		price : 10,
		pubdate : new Date('2015', '03', '24'),
		//image : "Image/1.jpg"
	}, {
		name : "Book2",
		price : 20,
		pubdate : new Date('2016', '04', '28'),
		image : 'Image/2.jpg'
	} ]

}

])
