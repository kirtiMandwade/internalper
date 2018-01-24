var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.delent={};
			
			$scope.choices = [];
			$scope.skip_array=[];
			
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
			
			$scope.setNewArrLookUpAtrNam=function(x,index,arrLookUpAtrNam){
				
				return $scope.choices.indexOf(x) === -1;
				
				/*angular.forEach($scope.arrLookUpAtrNam, function(item, index) {
					if(item.lookUpKey.lookUpValue==$scope.choices[index].attributeName.lookUpKey.lookUpValue)
					{
						$scope.arrLookUpAtrNam.splice(index,1);
					}
					});*/
			};
			   
			$scope.addNewChoice = function() {
					var newItemNo = $scope.choices.length + 1;
				
					$scope.choices.push({
						'id': 'choice' + newItemNo,
					});
					$('#addModal').show();
			};
			
			$scope.deleteNewChoice = function() {
				$scope.choices.splice($scope.choices.length-1);
				$('#addModal').show();
			};
			
			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.ent = entity;

				angular.forEach($scope.arrModel, function(item, index) {
					if(item.deviceModelId==$scope.ent.eMod.deviceModelId)
					{
						$scope.ent.eMod=$scope.arrModel[index];
					}
				});
							
				angular.forEach($scope.arrLookUpAtrNam, function(item, index) {
					if(item.lookUpKey.lookUpValue==$scope.ent.attributeName.lookUpKey.lookUpValue)
					{
						$scope.ent.attributeName=$scope.arrLookUpAtrNam[index];
					}
					});
				
			};

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;
			};

			$scope.save = function() {
//				$scope.ent.eMod.releaseDate=new Date($scope.ent.eMod.releaseDate);
				
				angular.forEach($scope.choices,function(item,index){
				/*	item.attributeId=null;
					item.id=null;*/
					item.eMod=$scope.ent.eMod;
					item.eMod.releaseDate=new Date(item.eMod.releaseDate);
					item.eMod.createdAt=new Date(item.eMod.createdAt);

				});
				
				$http.post("/adminportal/care/deviceattribute/save",
						$scope.choices).then(function(response) {
					console.log(response);
					$scope.refresh();
				});
			};

			$scope.update = function() {
				$scope.ent.eMod.releaseDate=new Date($scope.ent.eMod.releaseDate);
				$scope.ent.eMod.createdAt=new Date($scope.ent.eMod.createdAt);
				
				$http.post("/adminportal/care/deviceattribute/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/deviceattribute/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/deviceattribute/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/deviceattribute/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


			$http.get("/adminportal/care/model/getall").then(
					function(response) {
						console.log(response);
						$scope.arrModel = response.data;
					});
			
			$http.get("/adminportal/care/lookup/getall?lookUpType=ATTRIBUTENAME").then(
				     function(response) {
				      console.log(response);
				      $scope.arrLookUpAtrNam = response.data;
		     });
} ]);