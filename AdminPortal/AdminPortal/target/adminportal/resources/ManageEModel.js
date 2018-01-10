var app = angular.module('AdminPortal', ['720kb.datepicker','naif.base64']); 
var input;
var openFile = function(event) {
     input = event.target;

var reader = new FileReader();

reader.onload = function () {
  /*$scope.fileContent = reader.result;
  $scope.$apply();
  
  alert("file content"+$scope.fileContent);
}*/


var dataURL = reader.result;
var output = document.getElementById('output');
output.src = dataURL;

//  alert("file content"+$scope.dataURL);
}

reader.readAsDataURL(input.files[0]);
//console.log(input.files[0]);
};
//,'angularFileUpload'

app.config(['$compileProvider', function ($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(|blob|):/);
}]);

app.controller('empCtrl', [
		'$scope',
		'$http',
		function($scope, $http) {
			
			$scope.ent={};
			$scope.ent.isAutoCreated="1";
			$scope.ent.isValid="1";
						
			$scope.entEdit={};
			$scope.entEdit.isAutoCreated="1";
			$scope.entEdit.isValid="1";
			
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

			$scope.edit = function(entity) {
				console.log(entity);
				$scope.editForm = true;
				$scope.entEdit = entity;
			};

			$scope.close = function(entity) {
				console.log(entity);
				$scope.editForm =false;
			};
			
			
			
			
			
			
			$scope.resizeImage = function ( file, base64_object ) {
			    // file is an instance of File constructor.
			    // base64_object is an object that contains compiled base64 image data from file.
			    var deferred = $q.defer();
			    var url = URL.createObjectURL(file);// creates url for file object.
			    Jimp.read(url)
			    .then(function (item) {
			      item
			      .resize(1280, Jimp.AUTO)// width of 1280px, auto-adjusted height
			      .quality(50)//drops the image quality to 50%
			      .getBase64(file.type, function (err, newBase64) {
			        if (err) {throw err;}
			        var bytes = Math.round((3/4)*newBase64.length);
			        base64Object.filetype = file.type;
			        base64Object.filesize = bytes;
			        base64Object.base64 = newBase64;
			        // Note that base64 in this package doesn't contain "data:image/jpeg;base64," part,
			        // while base64 string from Jimp does. It should be taken care of in back-end side.
			        deferred.resolve(base64Object);
			      });
			    })
			    .catch(function (err) {
			      return console.log(err);// error handling
			    });
			    return deferred.promise;
			  };
			
			
			
			
			
			
			

			$scope.save = function() {
				
				console.log(input.files[0]);
				
				   $scope.ent.releaseDate= new Date($scope.ent.releaseDate);
				   $scope.ent.createdAt=new Date($scope.ent.createdAt);
				   $scope.ent.updatedAt=new Date($scope.ent.updatedAt);
				   
				   
				   
				   $scope.ent.deviceImage=$scope.ent.deviceImage.base64;		//$base64.encode(input.files[0]);	
			     
				   //alert("device image"+$scope.ent.deviceImage);
				   
				$http.post("/adminportal/care/model/save",
						$scope.ent).then(function(response) {
						
					console.log(response);
					$scope.refresh();

				});

			};

			$scope.update = function() {
				$http.post("/adminportal/care/model/update",
						$scope.entEdit).then(function(response) {
					console.log(response);
					$scope.refresh();
					$scope.editForm =false;
					$scope.entEdit=null;
				});

			};
			$scope.refresh = function() {
				console.log("refresh called")
				$http.get("/adminportal/care/model/getall").then(
						function(response) {
							console.log(response);
							$scope.arrEntity = response.data;
						});

			}


			$scope.delete = function() {
				$http.post("/adminportal/care/model/remove",
						$scope.delent).then(function(response) {
					console.log(response);

					$scope.refresh();
				});

			};
			$http.get("/adminportal/care/model/getall").then(
					function(response) {
						console.log(response);
						$scope.arrEntity = response.data;
					});


		} ]);
