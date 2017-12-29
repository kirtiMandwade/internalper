var app = angular.module('AdminPortal', ['720kb.datepicker']);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.choices = [];
			$scope.arrDevices=[];
			$scope.arrChoice;
			$scope.choicesEdit = [];

			$scope.entEdit={};
			$scope.entEdit1={};
			$scope.entity={};
			$scope.delent={};
			$scope.delent1={};
			$scope.editForm = false;
			$scope.entEdit.active="Y";
			$scope.myVar = false;
			$scope.ent={};
			$scope.ent1={};
			$scope.choiceid;
//			$scope.ent1=[];
			$scope.ent.workStationFeatures=[];
			$scope.ent.active="Y";
			$scope.ent.provisionedDate=new Date();
			$scope.ent.endDate=new Date();
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};




			$scope.addNewChoice = function() {

				//alert("hello");
				var newItemNo = $scope.choices.length + 1;

				$scope.choices.push({

						'id': 'choice' + newItemNo,
					//'id' : 'choice' + newItemNo

				});

				$('#addModal').show();
			};

			$scope.deleteNewChoice = function() {
				$scope.choices.splice($scope.choices.length-1);
				$('#addModal').show();


			};

			/*new*/
			$scope.addNewChoiceForEdit = function() {
				//alert("hello");
				var newItemNo = $scope.choicesEdit.length + 1;

				$scope.choicesEdit.push({

						'id': 'choice' + newItemNo,
					//'id' : 'choice' + newItemNo

				});

				$('#editmodal').show();
			};



			$scope.deleteNewChoiceForEdit = function() {
				$scope.choicesEdit.splice($scope.choicesEdit.length-1);
				$('#editmodal').show();


			};


/*end*/



			$scope.getValue = function(calltype,entity,choiceid) {

				var valueType;
				var featureDesc;

			/*	var cvalue;
				var slct;
				$scope.cvalue=document.getElementsByName("choicevalue");
				$scope.slct=document.getElementsByName("selct");

				$($scope.cvalue).show();
				$($scope.slct).hide();
				*/

				$( "#choicevalue"+choiceid ).show();
				$( "#selct"+choiceid ).hide();


								angular.forEach($scope.arrFeatures, function(item, index) {
									if(item.featureCd==entity.feature.featureCd)
									{
										valueType=item.valueType;
										featureDesc=item.choiceValues;
					}
									});


				var el ;
				var selEl;

				console.log("change called");
				if(calltype=="edit"){
				//el = angular.element(document.querySelector("input.form-control input[name='choicevalues']"));	//"div.user-panel.main input[name='login']"
				el = angular.element(document.querySelector('#choicevalues'+choiceid));

				//selEl = angular.element(document.querySelector("input.form-control input[name='selctedit']"));
				selEl = angular.element(document.querySelector('#selctedit'+choiceid));
				}
				if(calltype=="add")
				{
				//el = angular.element(document.querySelector("input.form-control input[name='choicevalue']"));
				el = angular.element(document.querySelector('#choicevalue'+choiceid));

				//selEl = angular.element(document.querySelector("input.form-control input[name='selct']"));
				selEl = angular.element(document.querySelector('#selct'+choiceid));
				}
				selEl.hide();

					if(valueType=='BOOLEAN')
					{

						 el[0].type="checkbox";
				           el[0].className="";
				           el[0].checked=true;
				           entity.featureValue="Y";


				}else if(valueType=='DATE')
				{
				entity.featureValue=featureDesc;
				el[0].type="date";
				el[0].className="form-control";

				}
				else if(valueType=='CHOICE'){
					entity.choiceValues="";
					entity.featureValue=featureDesc;

					el[0].type="text";
					el[0].className="form-control";

					el.hide();
					selEl.show();
//					$scope[arrChoice+choiceid];
				$scope["arrChoice"+choiceid]=entity.featureValue.split(",");
				entity.featureValue=$scope["arrChoice"+choiceid][0];
				console.log(entity.featureValue.split(","));
					}
				else{
				entity.choiceValues="";
				entity.featureValue=featureDesc;

				el[0].type="text";
				el[0].className="form-control";


				}
				};



			$scope.delDevice = function(entity) {
				console.log(entity);
				$scope.delent = entity;


				$scope.delent1=entity1;

			};
			
			$scope.splitChoices = function(device) {
				$scope.splitVariable = device;
				/*$scope.entity.featureValue=device;*/
				
			 /*$scope["arrChoicechoice"]=$scope.entity.featureValue.split(",");*/
			return $scope["arrChoicechoice"]=$scope.splitVariable.split(",");
			/*alert($scope.arrChoicechoice);*/
			/*console.log(entity.featureValue.split(","));
				alert(arrChoicechoice);
*/
			};



			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.entEdit = entity;

/*				$scope.entEdit1=entity1;*/
				
				$scope.addNewChoiceForEdit();
			};


			$http.get("/adminportal/warehouse/profile/getall").then(
					function(response) {
						console.log(response);
						$scope.arrDevices = response.data;
						$scope.ent.wsProfile=$scope.arrDevices[0];

			});

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;

			};

			$scope.save = function() {

				   $scope.ent.provisionedDate= new Date($scope.ent.provisionedDate);
				    $scope.ent.endDate=new Date($scope.ent.endDate);


			    $scope.workstation={};
			    $scope.ent.workStationFeatures=$scope.choices;

			    $http.post("/adminportal/warehouse/workstation/save",
			      $scope.ent).then(function(response) {
			     console.log(response);
			     //$scope.workstation=response.data;
			     $scope.refresh();
			    });



			/*	$scope.ent.provisionedDate=	new Date($scope.ent.provisionedDate);
				$scope.ent.endDate=new Date($scope.ent.endDate);

				$http.post("/adminportal/warehouse/workstation/save",
						$scope.ent).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

				$http.post("/adminportal/warehouse/workstation/SaveWorkStationFeature",
						$scope.ent1).then(function(response) {
					console.log(response);
					$scope.refresh();

				});





				//JSON.stringi

				alert($scope.choices[0]);

				//$data=$.toJSON($scope.choices)

				$http.post("/adminportal/warehouse/workstationfeature/save",
						$scope.choices).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

*/
			};

			$scope.update = function() {
				
				 $scope.ent.workStationFeatures=$scope.choicesEdit;
				$http.post("/adminportal/warehouse/workstation/update",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});

				$http.post("/adminportal/warehouse/workstationfeature/update",
						$scope.entEdit1).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit1=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/warehouse/workstation/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

				$http.get("/adminportal/warehouse/workstationfeature/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity1 = response.data;
						});

			};


			$scope.delete = function() {
				$http.post("/adminportal/warehouse/workstation/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

				$http.post("/adminportal/warehouse/workstationfeature/remove",
						$scope.delent1).then(function(response) {
					console.log(response);

					$scope.refresh();
				});


			};

			$http.get("/adminportal/warehouse/workstation/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
			});

			$http.get("/adminportal/warehouse/workstationfeature/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity1 = response.data;
			});

			$http.get("/adminportal/warehouse/feature/getall").then(
					function(response) {
						console.log(response);
						$scope.arrFeatures = response.data;
			});


		} ]);