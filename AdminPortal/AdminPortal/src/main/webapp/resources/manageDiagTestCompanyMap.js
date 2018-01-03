var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			
			$scope.entEdit={};
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
				$scope.entEdit = entity;
				angular.forEach($scope.arrdiagIissuesFlow, function(item, index) {
					if(item.issueCd==$scope.entEdit.diagIissuesFlow.issueCd)
					{
						$scope.entEdit.diagIissuesFlow=$scope.arrdiagIissuesFlow[index];

	}
					});

				angular.forEach($scope.arrDiagTest, function(item, index) {
					if(item.testCd==$scope.entEdit.diagTest.testCd)
					{
						$scope.entEdit.diagTest=$scope.arrDiagTest[index];

	}
					});

			};


			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/care/diagtestcompany/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/care/diagtestcompany/update",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/diagtestcompany/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/diagtestcompany/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/diagtestcompany/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});

			$http.get("/adminportal/care/diagtest/getall").then(
					function(response) {
						console.log(response);
						$scope.arrDiagTest = response.data;
					});

			$http.get("/adminportal/care/diagissue/getall").then(
					function(response) {
						console.log(response);
						$scope.arrdiagIissuesFlow = response.data;
					});
			$http.get("/adminportal/care/company/getall").then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForCompany = response.data;
				     });

		} ]);
