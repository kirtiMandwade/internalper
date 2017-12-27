var app = angular.module('AdminPortal', []);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			$scope.choices = [];
$scope.choiceid;
			$scope.editForm = false;
			$scope.delDev={};
			$scope.basePrice =[];
			$scope.dev={}
			$scope.entity={};
			$scope.calltype;
			$scope.myVar = false;
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




			$scope.getValue = function(calltype,entity,choiceid) {

				var valueType;
				var featureDesc;
 choiceid=choiceid+1;
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
				el = angular.element(document.querySelector('#choicevalueschoice'+choiceid));

				//selEl = angular.element(document.querySelector("input.form-control input[name='selctedit']"));
				selEl = angular.element(document.querySelector('#selcteditchoice'+choiceid));
				}
				if(calltype=="add")
				{
				//el = angular.element(document.querySelector("input.form-control input[name='choicevalue']"));
				el = angular.element(document.querySelector('#choicevaluechoice'+choiceid));

				//selEl = angular.element(document.querySelector("input.form-control input[name='selct']"));
				selEl = angular.element(document.querySelector('#selctchoice'+choiceid));
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
				$scope["arrChoicechoice"+choiceid]=entity.featureValue.split(",");
				entity.featureValue=$scope["arrChoicechoice"+choiceid][0];
				console.log(entity.featureValue.split(","));
					}
				else{
				entity.choiceValues="";
				entity.featureValue=featureDesc;

				el[0].type="text";
				el[0].className="form-control";


				}
				};




			 	$scope.edit = function(device) {
				console.log(device);
				$scope.editForm = true;
				$scope.devEdit = device;


				angular.forEach($scope.arrFeatures, function(item, index) {
					if(item.featureCd==entity.feature.featureCd)
					{
						valueType=item.valueType;
						featureDesc=item.choiceValues;
	}
					});

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