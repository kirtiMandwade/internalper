var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.entEdit={};
			$scope.delent={};
			$scope.editForm = false;
			$scope.valueType ;
			$scope.entEdit.active="Y";
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
				$scope.entEdit = entity;
				
				angular.forEach($scope.arrEntities, function(valueType, index) {
					if(item==$scope.entEdit.valueType)
					{
						$scope.entEdit.valueType=$scope.valueType[index];

	}
					});
				
				angular.forEach($scope.valueType, function(item, index) {
					if(item.valueType==$scope.entEdit.valueType)
					{
						$scope.entEdit.valueType=$scope.valueType[index];

	}				});
			};
			
			
			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {
			
				$http.post("/AdminPortal/Warehouse/SaveProfileFeature",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/AdminPortal/Warehouse/UpdateProfileFeature",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/AdminPortal/Warehouse/getAllProfileFeatures").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}

			$http.get("/AdminPortal/Warehouse/GetValueType").then(
					function(response) {
						console.log(response);
						$scope.valueType = response.data;
						$scope.entEdit.valueType = $scope.valueType[0];

					});
			$scope.delete = function() {
				$http.post("/AdminPortal/Warehouse/RemoveProfileFeature",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/AdminPortal/Warehouse/getAllProfileFeatures").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});
			$http.get("/AdminPortal/Warehouse/GetAllProfiles").then(
					function(response) {
						console.log(response);
						$scope.arrProfiles = response.data;
					});
			$http.get("/AdminPortal/Warehouse/GetAllFeatures").then(
					function(response) {
						console.log(response);
						$scope.arrFeatures = response.data;
					});

		
		} ]);
