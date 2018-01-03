var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.delent={};
			$scope.editForm = false;
			$scope.valueType ;
			$scope.ent.active="Y";
			$scope.myVar = false;
			/*$scope.toggle = function() {
				if($scope.ent.choiceValues=="Y")
				{$scope.ent.choiceValues="N";}
				else if ($scope.ent.choiceValues=="N"){
				$scope.ent.choiceValues="Y";
				}
			};*/
			$scope.delDevice = function(entity) {
				console.log(entity);
				$scope.delent = entity;

			};

			$scope.change=function(calltype){
				 var el ;
					$scope.ent.choiceValues="";
					$( "#choicevalue" ).hide();

				console.log("change called");
				if(calltype=="edit")
	             el = angular.element(document.querySelector('#choicevalues'));
				if(calltype=="add")
		             el = angular.element(document.querySelector('#choicevalue'));

					if($scope.ent.valueType=='CHOICE')
					{


						el.show();

	}/*else if($scope.ent.valueType=='DATE')
	{
		$scope.ent.choiceValues="";
		 el[0].type="date";
           el[0].className="form-control";

}else{
	$scope.ent.choiceValues="";

	 el[0].type="text";
     el[0].className="form-control";


}*/


			}


			$scope.edit = function(entity) {
				console.log(entity);
				$('#choicevalues').hide();

				$scope.editForm = true;
				$scope.ent = entity;
				if($scope.ent.valueType=='CHOICE')
				{


					$('#choicevalues').show();

}

				angular.forEach($scope.arrEntities, function(valueType, index) {
					if(item==$scope.ent.valueType)
					{
						$scope.ent.valueType=$scope.valueType[index];

	}
					});

				angular.forEach($scope.valueType, function(item, index) {
					if(item.valueType==$scope.ent.valueType)
					{
						$scope.ent.valueType=$scope.valueType[index];

	}				});
			};


			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {

				$http.post("/adminportal/warehouse/feature/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};
			
			
			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/warehouse/feature/search",$scope.featureCd).then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			};	
			
			

			$scope.update = function() {
				console.log($scope.ent);
				$http.post("/adminportal/warehouse/feature/update",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/warehouse/feature/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			};

			$http.get("/adminportal/warehouse/GetValueType").then(
					function(response) {
						console.log(response);
						$scope.valueType = response.data;
						$scope.ent.valueType = $scope.valueType[0];

					});
			$scope.delete = function() {
				$http.post("/adminportal/warehouse/feature/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/warehouse/feature/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


		} ]);
