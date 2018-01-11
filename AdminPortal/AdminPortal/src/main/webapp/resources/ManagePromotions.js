var app = angular.module('AdminPortal', ['720kb.datepicker']);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {

			$scope.editForm = false;
			$scope.dev={};
			$scope.devEdit={};
			$scope.dev.gradeSpecific="Y";
			$scope.dev.deviceSpecific="Y";
			$scope.dev.startDateTime=new Date();
			$scope.dev.endDateTime=new Date();
			$scope.devEdit.startDateTime=new Date();
			$scope.deductionType=[];
			$scope.devEdit.eCompany={};
			$scope.devEdit.promotionKey={};
			$scope.arrDevicePrices=[];
			$scope.myVar = false;
			$scope.delpromo={};
			$scope.toggle = function() {
				$scope.myVar = !$scope.myVar;
			};

			$scope.delDevice = function(promo) {
				console.log(promo);
				$scope.delpromo = promo;

			};



			/*$http.get("/adminportal/tradein/promotion/GetAllDevPrice").then(
					function(response) {
						console.log(response);
						$scope.arrDevicePrices = response.data;

					});*/


			$scope.edit = function(promotion) {
				console.log(promotion);
				$scope.editForm = true;
				$scope.devEdit = promotion;


				$scope.devEdit.startDateTime=new Date(promotion.startDateTime);
				$scope.devEdit.endDateTime=new Date(promotion.endDateTime);


				angular.forEach($scope.deductionType, function(item, index) {
					if(item.deductionType==$scope.devEdit.deductionType)
					{
						$scope.devEdit.deductionType=$scope.deductionType[index];

	}				});
			};



			$scope.close = function(promotion) {
				console.log(promotion);
				$scope.editForm =false;

			};

			$scope.save = function() {
			console.log(new Date($scope.dev.startDateTime));
			$scope.dev.startDateTime=	new Date($scope.dev.startDateTime);
			$scope.devEdit.endDateTime=new Date($scope.dev.endDateTime);
			$scope.dev.promotionKey.companyName=$scope.dev.eCompany.companyName; 
			$scope.dev.endDateTime=	new Date($scope.dev.endDateTime);
				$http.post("/adminportal/tradein/promotion/save",
						$scope.dev).then(function(response) {
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$scope.devEdit.startDateTime=	new Date($scope.devEdit.startDateTime);

				$scope.devEdit.endDateTime=	new Date($scope.devEdit.endDateTime);

				$http.post("/adminportal/tradein/promotion/update",
						$scope.devEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.devEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/tradein/promotion/getall").then(
						function(response) {
							console.log(response);
							$scope.arrPromotion = response.data;
						});

			}

			$scope.delete = function() {
				$http.post("/adminportal/tradein/promotion/remove",
						$scope.delpromo).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/tradein/promotion/getall").then(
					function(response) {
						console.log(response);
						$scope.arrPromotion = response.data;
					});

			$http.get("/adminportal/tradein/GetDeductionType").then(
					function(response) {
						console.log(response);
						$scope.deductionType = response.data;
						$scope.dev.deductionType = $scope.deductionType[0];

					});

			$scope.search = function() {
				console.log("searcg called")
				$http.post("/adminportal/tradein/promotion/search",$scope.PromoCode).then(
						function(response) {
							console.log(response);
							$scope.arrPromotion = response.data;
						});

			}
			
			$http.get("/adminportal/care/company/getall").then(
				     function(response) {
				      console.log(response);
				      $scope.arrEntityForCompany = response.data;
				     });
			

		} ]);