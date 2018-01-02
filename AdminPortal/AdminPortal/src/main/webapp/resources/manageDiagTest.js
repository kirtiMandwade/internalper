var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.ent.androidSupported="1";
			$scope.ent.iosSupported="1";
			$scope.delent={};
			
			$scope.entEdit={};
			$scope.entEdit.androidSupported="1";
			$scope.entEdit.iosSupported="1";
			
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
				$scope.entEdit = entity;
			};

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;
			};

			$scope.save = function() {

				$http.post("/adminportal/care/diagtest/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
				});
			};

			$scope.update = function() {
				$http.post("/adminportal/care/diagtest/update",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});
			};
			
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/diagtest/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});
			};

			$scope.delete = function() {
				$http.post("/adminportal/care/diagtest/remove",
						$scope.delent).then(function(response) {
					console.log(response);
					$scope.refresh();
				});
			};
			
			$http.get("/adminportal/care/diagtest/getall").then(function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
			});

} ]);