var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.delent={};
			$scope.editForm = false;
			$scope.myVar = false;
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};
			$scope.delDevice = function(entity) {
				console.log(entity);
				$scope.delent = entity;

			};

			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.ent = entity;

				angular.forEach($scope.arrModel, function(item, index) {
					if(item.deviceModelId==$scope.ent.eModel.deviceModelId)
					{
						$scope.ent.eModel=$scope.arrModel[index];

	}
					});

			};


			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/care/devicebaseprice/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/care/devicebaseprice/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/devicebaseprice/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/devicebaseprice/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/devicebaseprice/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


			$http.get("/adminportal/care/model/getall").then(
					function(response) {
						console.log(response);
						$scope.arrModel = response.data;
					});
		} ]);
