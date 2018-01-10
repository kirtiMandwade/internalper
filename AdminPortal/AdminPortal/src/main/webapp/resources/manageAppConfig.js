var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.delent={};
			$scope.choices = [];
			$scope.editForm = false;
			$scope.myVar = false;
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};
			$scope.delDevice = function(entity) {
				console.log(entity);
				$scope.delent = entity;

			};
			$scope.setDefaultValueForChoices = function() {
			    $scope.choices.length = 1;

			   };


			$scope.addNewChoice = function() {

				// alert("hello");
				var newItemNo = $scope.choices.length + 1;

				$scope.choices.push({

						'id': 'choice' + newItemNo,
					// 'id' : 'choice' + newItemNo

				});

				$('#addModal').show();
			};



			$scope.deleteNewChoice = function() {
				$scope.choices.splice($scope.choices.length-1);
				$('#addModal').show();


			};


			$scope.edit = function(entity) {
				console.log(entity);
				$scope.company={};
				$scope.editForm = true;
				$scope.ent = entity;
				angular.forEach($scope.arrEntityForCompany, function(item, index) {
					if(item.companyName==$scope.ent.company.companyName)
					{
						$scope.ent.company=item	;


	}
					});

			};

			$scope.add = function(entity) {

				$scope.ent = null;


			};

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {



				angular.forEach($scope.choices, function(item, index) {

					item.company=$scope.ent.company;



	});
				$http.post("/adminportal/care/appConfig/saveAll	",
						$scope.choices).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.saveDuplicate= function() {
				/*
				 * $scope.ent.arrEcompany=[];
				 * $scope.ent.arrEcompany.push($scope.company);
				 */$http.post("/adminportal/care/appConfig/saveAll",
						$scope.choices).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};
			$scope.duplicate = function() {

				$scope.choices=[];

				angular.forEach($scope.arrEntity, function(item, index) {
					if(item.company.companyName==$scope.fromCompany.companyName)
					{
						$scope.dupent={};
						Object.assign($scope.dupent, item);
						$scope.dupent.configId=null;
						$scope.dupent.company=$scope.toCompany;
						$scope.choices.push($scope.dupent);
	}
					});
				angular.forEach($scope.arrEntityForCompany, function(item, index) {
					if(item.companyName==$scope.fromCompany.companyName)
					{
						$scope.dupent.company=$scope.toCompany;


	}
					});
				$("#dupeditform").modal('show');
				/*
				 * $http.post("/adminportal/care/appConfig/save",
				 * $scope.ent).then(function(response) { console.log(response);
				 * $scope.refresh();
				 *
				 * });
				 */

			};

			$scope.update = function() {

				$http.post("/adminportal/care/appConfig/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/appConfig/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/appConfig/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};


			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/care/appConfig/search",$scope.company).then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			};
			$http.get("/adminportal/care/appConfig/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});
			$http.get("/adminportal/care/company/getall").then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForCompany = response.data;
				     });


		} ]);
