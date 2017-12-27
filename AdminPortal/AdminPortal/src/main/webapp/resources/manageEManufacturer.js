var app = angular.module('AdminPortal', ['720kb.datepicker']);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.ent.isSupported="1";
			$scope.ent.isAutoCreated="1";
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


			};


			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {
			    $scope.ent.createdAt= new Date($scope.ent.createdAt);
				$http.post("/adminportal/care/manufacturer/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/care/manufacturer/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/manufacturer/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/manufacturer/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/manufacturer/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


		} ]);
