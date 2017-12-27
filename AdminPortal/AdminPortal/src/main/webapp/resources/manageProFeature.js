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

				$http.post("/adminportal/warehouse/productfeature/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/warehouse/productfeature/update",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/warehouse/productfeature/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}

			$http.get("/adminportal/warehouse/GetValueType").then(
					function(response) {
						console.log(response);
						$scope.valueType = response.data;
						$scope.entEdit.valueType = $scope.valueType[0];

					});
			$scope.delete = function() {
				$http.post("/adminportal/warehouse/productfeature/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/warehouse/productfeature/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


		} ]);
