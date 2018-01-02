var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.grd={};
			$scope.delgrade={};
			$scope.editForm = false;
			$scope.deductionType ;
			$scope.grd.active="Y";
			$scope.myVar = false;
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};
			$scope.delDevice = function(grade) {
				console.log(grade);
				$scope.delgrade = grade;

			};

			$scope.add = function() {
				$scope.grd=null;

			};

			$scope.edit = function(grade) {
				console.log(grade);
				$scope.editForm = true;
				$scope.grdEdit = grade;

				angular.forEach($scope.arrDevices, function(deductionType, index) {
					if(item==$scope.grdEdit.deductionType)
					{
						$scope.grdEdit.deductionType=$scope.deductionType[index];

	}
					});

				angular.forEach($scope.deductionType, function(item, index) {
					if(item.deductionType==$scope.grdEdit.deductionType)
					{
						$scope.grdEdit.deductionType=$scope.deductionType[index];

	}				});
			};


			$scope.close = function(grade) {
				console.log(grade);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/tradein/grade/save",
						$scope.grd).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/tradein/grade/update",
						$scope.grdEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.grdEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/tradein/grade/getall").then(
						function(response) {
							console.log(response);
							$scope.arrGrades = response.data;
						});

			}

			$http.get("/adminportal/tradein/GetDeductionType").then(
					function(response) {
						console.log(response);
						$scope.deductionType = response.data;
						$scope.grd.deductionType = $scope.deductionType[0];

					});
			$scope.delete = function() {
				$http.post("/adminportal/tradein/grade/remove",
						$scope.delgrade).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/tradein/grade/getall").then(
					function(response) {
						console.log(response);
						$scope.arrGrades = response.data;
					});


		} ]);
