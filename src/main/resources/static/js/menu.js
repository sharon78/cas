   var app = angular.module('casApp', ['ngRoute']);

    // configure our routes
    app.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/dashboard.html',
                controller  : 'mainController'
            })

            // route for the about page
            .when('/trialbalance', {
                templateUrl : 'pages/trialbalance.html',
                controller  : 'cntrl1'
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });

    app.controller("cntrl1",function($scope, $http){

    	_refreshPageData();

    	function _refreshPageData() {

    		$http({
    			method : 'GET',
    			url : 'http://localhost:8080/trialbalance/year/2016'
    		}).then(function successCallback(response) {
    			$scope.trialBalances = response.data;
    		}, function errorCallback(response) {
    			console.log(response.statusText);
    		});
    	};	
    	
    	$scope.refresh = function(){
    		_refreshPageData();
    	};
    	
 /*
    	$.fn.digits = function(){ 
    	    return this.each(function(){ 
    	        $(this).text( $(this).text().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") ); 
    	    })
    	}
    	*/
    });
    
    