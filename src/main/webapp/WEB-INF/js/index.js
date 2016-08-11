/**
 * JavaScript for index.html
 */
var app = angular.module("myApp",[]);

app.controller("cntrl1",function($scope, $http){

		$scope.trialBalances=[
{
	"seq": "01",
	"accountCode": "1000",
	"accountTitle": "Cash on hand",
	"debitAmount": 0,
	"creditAmount": 0
	},
	{
	"seq": "02",
	"accountCode": "2000",
	"accountTitle": "Accounts Payable",
	"debitAmount": 0,
	"creditAmount": 0
	}
	]

/*
	function _refreshPageData() {
		$http({
			method : 'GET',
			url : 'trialbalance/year/2016'
		}).then(function successCallback(response) {
			$scope.trialBalances = response.data.trialBalances;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
*/	
	
});

