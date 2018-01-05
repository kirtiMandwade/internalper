var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
//			$scope.ent={};
//			$scope.ent.company="";
//			$scope.ent.productCd="";
//			
			$scope.choices=[];
			
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
			
			$scope.setDefaultValueForChoices = function() {
			    $scope.choices.length = 1;
			};
			
			$scope.addNewChoiceForEdit = function(wsProfileId) {
				var newItemNo = $scope.choicesEdit.length + 1;

				$scope.choicesEdit.push({
						'id': 'choice' + newItemNo,
						'profileFeatureId':{ 'wsProfileId':wsProfileId}
				});

				$('#myModal').show();
			};

			$scope.deleteNewChoiceForEdit = function() {
				$scope.choicesEdit.splice($scope.choicesEdit.length-1);
				$('#myModal').show();
			};
			
			$scope.setDefaultValueForEditChoices = function() {
			       $scope.choicesEdit.length = 0;
			};
			

			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.entEdit = entity;
				
				angular.forEach($scope.arrEntityForCompany,function(item,index){
					if(item.companyName==$scope.entEdit.company.companyName)
					{
						$scope.entEdit.company=$scope.arrEntityForCompany[index];
					}
				});
				
				angular.forEach($scope.arrLookUp,function(item,index){
					if(item.lookUpKey.lookUpValue==$scope.entEdit.productCd.lookUpKey.lookUpValue)
					{
						$scope.entEdit.productCd=$scope.arrLookUp[index];
					}
				});
				
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
				
			
				angular.forEach($scope.choices,function(item,index){
					item.id=null;
					item.company=$scope.ent.company;
					item.productCd=$scope.ent.productCd;
				});
				
				$http.post("/adminportal/care/diagtestcompany/save",
						$scope.choices).then(function(response) {
					console.log(response);
					$scope.refresh();
				});

				
				/*
				$http.post("/adminportal/care/diagtestcompany/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
				});
*/
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
			};
			
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
			
			$http.get("/adminportal/care/lookup/getall?lookUpType=PRODUCTCD").then(
				     function(response) {
				      console.log(response);
				      $scope.arrLookUp = response.data;
		     });
			
			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/care/diagtestcompany/search",$scope.company.companyName).then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});
			};	

} ]);