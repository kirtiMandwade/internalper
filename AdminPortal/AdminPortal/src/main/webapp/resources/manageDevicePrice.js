$("[data-toggle='tooltip']").tooltip();

var app = angular.module('AdminPortal', []);
/*
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    
    $('.btn').tooltip({title: "<table><tr><td>Storage-{{device.deviceEntity.storage}}</td>" +
		"<td>Color-{{device.deviceEntity.color}}</td>" +
		"<td>Charger-{{device.deviceEntity.charger}}</td>", html: true, placement: "top"});
    
});*/




app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.arrDevices=[];
			$scope.arrEntityForCompany=[];
			$scope.delDev={};
			$scope.editForm = false;
			$scope.myVar = false;
			$scope.dev={};
			$scope.dev.devPriceKey={};
			
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;

			};

			$scope.delDevice = function(device) {
				console.log(device);
				$scope.delDev = device;

			};



			$http.get("/adminportal/tradein/device/getall").then(
					function(response) {
						console.log(response);
						$scope.arrDevices = response.data;
						$scope.dev.deviceEntity=$scope.arrDevices[0];

					});

			$scope.edit = function(device) {
				console.log(device);
				$scope.editForm = true;
				$scope.company={};
				
				$scope.devEdit = device;
				angular.forEach($scope.arrDevices, function(item, index) {
				if(item.tradeinDeviceId==$scope.devEdit.deviceEntity.tradeinDeviceId)
				{
					$scope.devEdit.deviceEntity=$scope.arrDevices[index];

}
				});
/*				angular.forEach($scope.arrEntityForCompany, function(item, index) {
					if(item.companyName==$scope.devEdit.deviceEntity.companyName)
					{
						$scope.devEdit.eCompany=item;
						$scope.devEdit.deviceEntity=$scope.arrEntityForCompany[index];

	}
					});*/
				

			};


			$scope.close = function(device) {
				console.log(device);
				$scope.editForm =false;

			};
			
			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/tradein/deviceprice/search",$scope.companyName).then(
						function(response) {
							console.log(response);
							$scope.arrDevicePrice = response.data;
						});

			};			
			

			$scope.save = function() {
				$scope.dev.devPriceKey.tradeinDeviceId=$scope.dev.deviceEntity.tradeinDeviceId;
				$scope.dev.devPriceKey.companyName=$scope.dev.eCompany.companyName;
				$http.post("/adminportal/tradein/deviceprice/save",
						$scope.dev).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				/*$scope.devEdit.productPK.tradeinDeviceId=$scope.devEdit.deviceEntity.tradeinDeviceId;
*/
				$http.post("/adminportal/tradein/deviceprice/update",
						$scope.devEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.devEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/tradein/deviceprice/getall").then(
						function(response) {
							console.log(response);
							$scope.arrDevicePrice = response.data;
						});

			}

			$scope.delete = function(device) {
				$http.post("/adminportal/tradein/deviceprice/remove",
						$scope.delDev).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/tradein/deviceprice/getall").then(
					function(response) {
						console.log(response);
						$scope.arrDevicePrice = response.data;

					});
			$http.get("/adminportal/care/company/getall").then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForCompany = response.data;
				     });
			


		} ]);
