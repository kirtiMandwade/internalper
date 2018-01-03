var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.editForm = false;
			$scope.delDev={};
			$scope.basePrice =[];
			$scope.dev={}
			$scope.dev.charger="Y";
			$scope.myVar = false;
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};


			 	$scope.edit = function(device) {
				console.log(device);
				$scope.editForm = true;
				$scope.devEdit = device;

			};
			$scope.delDevice = function(device) {
				console.log(device);
				$scope.delDev = device;

			};

			$scope.close = function(device) {
				console.log(device);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/tradein/device/save",
						$scope.dev).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/tradein/device/update",
						$scope.devEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.devEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/tradein/device/getall").then(
						function(response) {
							console.log(response);
							$scope.arrDevices = response.data;
						});

			};

			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/tradein/device/search",$scope.model).then(
						function(response) {
							console.log(response);
							$scope.arrDevices = response.data;
						});

			};


			$scope.getBasePrice = function(device) {
				$http.post("/adminportal/tradein/GetBasePrice",device).then(
						function(response) {
							console.log(response);
							$scope.basePrice = response.data;
						});

			};

			$scope.delete = function() {
				$http.post("/adminportal/tradein/device/remove",
						$scope.delDev).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/tradein/device/getall").then(
					function(response) {
						console.log(response);
						$scope.arrDevices = response.data;
					});


		} ]);