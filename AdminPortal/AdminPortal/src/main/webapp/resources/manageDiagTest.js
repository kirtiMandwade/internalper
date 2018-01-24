	





var app = angular.module('AdminPortal', ['ui']);
/*angular.bootstrap(document, ['AdminPortal']);*/
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
				
				
				angular.forEach($scope.arrLookUpCatCd,function(item,index){
					if(item.lookUpKey.lookUpValue==$scope.entEdit.categoryCd.lookUpKey.lookUpValue)
					{
						$scope.entEdit.categoryCd=$scope.arrLookUpCatCd[index];
					}
				});
				
				angular.forEach($scope.arrLookUpOrNm,function(item,index){
					if(item.lookUpKey.lookUpValue==$scope.entEdit.orderNum.lookUpKey.lookUpValue)
					{
						$scope.entEdit.orderNum=$scope.arrLookUpOrNm[index];
					}
				});
				
				angular.forEach($scope.arrLookUpTT,function(item,index){
					if(item.lookUpKey.lookUpValue==$scope.entEdit.testType.lookUpKey.lookUpValue)
					{
						$scope.entEdit.testType=$scope.arrLookUpTT[index];
					}
				});
				
				
				
				
				
				
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
			
			$scope.updateDragAndDrop = function() {

				$http.post("/adminportal/care/diagtest/saveList",
						$scope.arrEntity).then(function(response) {
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
			
			$http.get("/adminportal/care/lookup/getall?lookUpType=CATEGORYCD").then(
				     function(response) {
				      console.log(response);
				      $scope.arrLookUpCatCd = response.data;
		     });
			
			$http.get("/adminportal/care/lookup/getall?lookUpType=ORDERNUM").then(
				     function(response) {
				      console.log(response);
				      $scope.arrLookUpOrNm = response.data;
		     });
			
			$http.get("/adminportal/care/lookup/getall?lookUpType=TESTTYPE").then(
				     function(response) {
				      console.log(response);
				      $scope.arrLookUpTT = response.data;
		     });

} ]);


