var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.ent={};
			$scope.delent={};
			$scope.editForm = false;
			$scope.myVar = false;
			$scope.ent={};
			
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};
			

			$scope.getValue = function(calltype) {

var valueType;
var featureDesc;
$( "#choicevalue" ).show();
$( "#selct" ).hide();

				
				angular.forEach($scope.arrFeatures, function(item, index) {
					if(item.featureCd==$scope.ent.feature.featureCd)
					{
						valueType=item.valueType;
						featureDesc=item.choiceValues;
	}
					});


var el ;
	var selEl;

console.log("change called");
if(calltype=="edit"){
el = angular.element(document.querySelector('#choicevalues'));
selEl = angular.element(document.querySelector('#selctedit'));
}
if(calltype=="add")
{
	el = angular.element(document.querySelector('#choicevalue'));

	selEl = angular.element(document.querySelector('#selct'));
}
selEl.hide();

	if(valueType=='BOOLEAN')
	{

		 el[0].type="checkbox";
           el[0].className="";
           el[0].checked=true;
           $scope.ent.featureValue=featureDesc;

           
}else if(valueType=='DATE')
{
$scope.ent.featureValue=featureDesc;
el[0].type="date";
el[0].className="form-control";

}
else if(valueType=='CHOICE'){
	$scope.ent.choiceValues="";
	$scope.ent.featureValue=featureDesc;

	el[0].type="text";
	el[0].className="form-control";
	
	el.hide();
	selEl.show();

$scope.arrChoice=$scope.ent.featureValue.split(",");
$scope.ent.featureValue=$scope.arrChoice[0];
console.log($scope.ent.featureValue.split(","));
	}
else{
$scope.ent.choiceValues="";
$scope.ent.featureValue=featureDesc;

el[0].type="text";
el[0].className="form-control";


}
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
			
				$http.post("/AdminPortal/Warehouse/SaveWorkStationFeature",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/AdminPortal/Warehouse/UpdateWorkStationFeature",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.ent=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/AdminPortal/Warehouse/GetAllWorkStationFeature").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			};

		
			$scope.delete = function() {
				$http.post("/AdminPortal/Warehouse/RemoveWorkStationFeature",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			
			
			$http.get("/AdminPortal/Warehouse/GetAllWorkStationFeature").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});

			$http.get("/AdminPortal/Warehouse/GetAllFeatures").then(
					function(response) {
						console.log(response);
						$scope.arrFeatures = response.data;
					});
		
		} ]);
