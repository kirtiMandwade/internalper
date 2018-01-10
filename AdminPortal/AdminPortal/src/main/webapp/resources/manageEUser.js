var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.dept='DEPT';
			$scope.unit='UNIT';
			$scope.arrEntityForUnit= {};
			arrEntityForDepartment={};
			$scope.ent={};
			$scope.company={};
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

/*			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.ent = entity;
					

			};
			
			*/
			
			/*new*/ 
			$scope.edit = function(entity) {
				console.log(entity);
				$scope.company={};
				$scope.editForm = true;
				$scope.ent = entity;
				angular.forEach($scope.arrEntityForCompany, function(item, index) {
					if(item.companyName==$scope.ent.eCompany.companyName)
					{
						$scope.ent.eCompany=item	;


	}
					});
				
				
				angular.forEach($scope.arrEntityForDepartment, function(item, index) {
					if(item.lookUpKey.lookUpValue==$scope.ent.department.lookUpKey.lookUpValue)
					{
						$scope.ent.department=item;


	}
					});
				
				
				angular.forEach($scope.arrEntityForUnit, function(item, index) {
					if(item.lookUpKey.lookUpValue==$scope.ent.unit.lookUpKey.lookUpValue)
					{
						$scope.ent.unit=item;


	}
					});

			};
			
			
/*end*/
			
			$scope.add = function(entity) {

				$scope.ent = null;


			};

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/care/eUser/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/care/eUser/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/eUser/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/eUser/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/eUser/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});
			$http.get("/adminportal/care/company/getall").then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForCompany = response.data;
				     });
				
			$http.get("/adminportal/care/lookup/getall?lookUpType="+$scope.dept).then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForDepartment = response.data;
				     });
					
			$http.get("/adminportal/care/lookup/getall?lookUpType="+$scope.unit).then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForUnit = response.data;
				     });
			
			/*NEW*/
			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/care/eUser/search",$scope.companyName).then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			};			

			/*end*/


					
		} ]);
