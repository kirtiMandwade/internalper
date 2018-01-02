var app = angular.module('AdminPortal', ['720kb.datepicker']);
app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.choices = [];
			$scope.choicesEdit = [];
$scope.choiceid;
$scope.wsProfileId;
			$scope.editForm = false;
			$scope.delDev={};
			$scope.basePrice =[];
			$scope.dev={}
			$scope.entity={};
			$scope.calltype;
			$scope.splitVariable;
			$scope.arrChoicechoice=[];
			$scope.myVar = false;
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};


$scope.buttondis=true;
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
			$scope.addNewChoiceForEdit = function(wsProfileId) {
				//alert("hello");
				var newItemNo = $scope.choicesEdit.length + 1;

				$scope.choicesEdit.push({

						'id': 'choice' + newItemNo,
'profileFeatureId':{ 'wsProfileId':wsProfileId}
					//'id' : 'choice' + newItemNo

				});

				$('#myModal').show();
			};



			$scope.deleteNewChoiceForEdit = function() {
				$scope.choicesEdit.splice($scope.choicesEdit.length-1);
				$('#myModal').show();


			};


/*end*/

			$scope.setDefaultValueForChoices = function() {
			    $scope.choices.length = 1;

			   };


			$scope.getValue = function(calltype,entity,choiceid) {

				var valueType;
				var featureDesc;
// choiceid=choiceid+1;
			/*	var cvalue;
				var slct;
				$scope.cvalue=document.getElementsByName("choicevalue");
				$scope.slct=document.getElementsByName("selct");

				$($scope.cvalue).show();
				$($scope.slct).hide();
				*/

//				$scope.choices[choiceid].wsProfiles=$scope.dev;
//				entity.wsProfiles=$scope.dev.
				$( "#choicevaluechoice"+choiceid ).show();
				$( "#selctchoice"+choiceid ).hide();


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
					el = angular.element(document.querySelector('#choiceedit'+choiceid));

					//selEl = angular.element(document.querySelector("input.form-control input[name='selctedit']"));
					selEl = angular.element(document.querySelector('#selctedit'+choiceid));
					checkE1=angular.element(document.querySelector('#choicecheck'+choiceid));
					}if(calltype=="editadd"){
						//el = angular.element(document.querySelector("input.form-control input[name='choicevalues']"));	//"div.user-panel.main input[name='login']"
						el = angular.element(document.querySelector('#editadd'+choiceid));

						//selEl = angular.element(document.querySelector("input.form-control input[name='selctedit']"));
						selEl = angular.element(document.querySelector('#selcteditadd'+choiceid));
						checkE1=angular.element(document.querySelector('#editaddcheck'+choiceid));

						}
				if(calltype=="add")
				{
				//el = angular.element(document.querySelector("input.form-control input[name='choicevalue']"));
				el = angular.element(document.querySelector('#choicevalue'+choiceid));

				//selEl = angular.element(document.querySelector("input.form-control input[name='selct']"));
				selEl = angular.element(document.querySelector('#selct'+choiceid));
				checkE1=angular.element(document.querySelector('#addcheck'+choiceid));

				}
				selEl.hide();
				checkE1.hide();
					if(valueType=='BOOLEAN')
					{
						el.hide();

						checkE1.show();
//						  entity.featureValue=featureDesc;
						/* el[0].type="checkbox";
							el[0].disabled=false;

				           el[0].className="";
//				           el[0].checked=true;

				           if(entity.featureValue=="on")
				        	   entity.featureValue="Y";
				        	   else
				        		   entity.featureValue=="N";*/


				}else if(valueType=='DATE')
				{
				entity.featureValue=featureDesc;
				el[0].type="date";
				el[0].className="form-control";
				el[0].disabled=false;

				}
				else if(valueType=='CHOICE'){
					entity.choiceValues="";
					entity.featureValue=featureDesc;

					el[0].type="text";
					el[0].className="form-control";

					el.hide();
					selEl.show();
//					$scope[arrChoice+choiceid];
				$scope["arrChoicechoice"+choiceid]=entity.featureValue.split(",");
				entity.featureValue=$scope["arrChoicechoice"+choiceid][0];
				console.log(entity.featureValue.split(","));
					}
				else{
el.show();

				el[0].type="text";
				el[0].className="form-control";

				entity.choiceValues="";
				entity.featureValue=featureDesc;
				el[0].disabled=false;
				}
				};


				$scope.splitChoices = function(device) {
					if(device != null && device.includes(","))
						{
							$scope.splitVariable = device;
							return $scope["arrChoicechoice"]=$scope.splitVariable.split(",");
						}


				};

			 	$scope.edit = function(device) {
				console.log(device);
				$scope.editForm = true;
				$scope.devEdit = device;


				/*angular.forEach($scope.arrFeatures, function(item, index) {
					if(item.featureCd==entity.feature.featureCd)
					{
						valueType=item.valueType;
						featureDesc=item.choiceValues;
	}
					});
*/
			};
			$scope.delWSProfile = function(device) {
				console.log(device);
				$scope.delDev = device;

			};

			$scope.close = function(device) {
				console.log(device);
				$scope.editForm =false;

			};

			$scope.save = function() {

//				var cache = [];


				$scope.dev.profileFeatures=$scope.choices;
/*				$scope.dev=		JSON.stringify($scope.dev, function(key, value) {
				    if (typeof value === 'object' && value !== null) {
				        if (cache.indexOf(value) !== -1) {
				            // Circular reference found, discard key
				            return;
				        }
				        // Store value in our collection
				        cache.push(value);
				    }
				    return value;
				});
				cache = null; */// Enable garbage collection

				$http.post("/adminportal/warehouse/profile/save",
						$scope.dev).then(function(response) {
					console.log(response);
					$scope.refresh();
/*					$scope.saveProFeatBean={};

					$scope.saveProFeatBean.fea=$scope.choices;
					$scope.saveProFeatBean.wsProfiles=$scope.dev;
					$http.post("/adminportal/warehouse/profile/SaveProfileFeature",
							$scope.saveProFeatBean).then(function(response) {
						console.log(response);
						$scope.refresh();

					});
*/				});

			};

			$scope.update = function() {

				 $scope.devEdit.profileFeatures=$scope.devEdit.profileFeatures.concat($scope.choicesEdit);

				$http.post("/adminportal/warehouse/profile/update",
						$scope.devEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.devEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/warehouse/profile/getall").then(
						function(response) {
							console.log(response);
							$scope.arrWSProfiles = response.data;
						});

			}

			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/warehouse/profile/search",$scope.model).then(
						function(response) {
							console.log(response);
							$scope.arrWSProfiles = response.data;
						});

			}


			$scope.getBasePrice = function(device) {
				$http.post("/adminportal/warehouse/GetBasePrice",device).then(
						function(response) {
							console.log(response);
							$scope.basePrice = response.data;
						});

			}

			$scope.delete = function() {
				$http.post("/adminportal/warehouse/profile/remove",
						$scope.delDev).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/warehouse/profile/getall").then(
					function(response) {
						console.log(response);
						$scope.arrWSProfiles = response.data;

					});
			$http.get("/adminportal/warehouse/feature/getall").then(
					function(response) {
						console.log(response);
						$scope.arrFeatures = response.data;
			});


		} ]);