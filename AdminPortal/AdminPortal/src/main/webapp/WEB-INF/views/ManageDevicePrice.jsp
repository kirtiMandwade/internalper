<%@ page contentType="text/html;charset=UTF-8"%>

<html>

<head>
<title>AdminPortal</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="/adminportal/resources/manageDevicePrice.js"></script>
<link rel="stylesheet"
href="/adminportal/resources/css/style.css">


</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="../tradein/device">Device</a></li>
					<li><a href="../tradein/grade">Grade</a></li>
					<li class="active"><a href="../tradein/deviceprice">Device
							Price</a></li>
					<li><a href="../tradein/promotion">Promotions</a></li>
					<li><a href="../logout"> Logout</a></li>

				</ul>
				<br>

			</div>



	<div class="col-xs-6 col-md-4">

				<div>
					<h1>Device Price</h1>	<!-- <button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button> -->
      <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="CompanyName" id="txtSearch" ng-model="companyName" style="height:27px"/>
   <div class="input-group-btn">
        <button class="btn btn-primary" ng-click="search()" >
        <span class="glyphicon glyphicon-search" ></span>
        </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="add()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


   </div></div>
				</div>
			<!-- <div class="col-sm-9">
				<div>
					<h1>Device Price</h1>
					<button class="btn btn-info" data-toggle="modal"
						data-target="#addModal" style="position: relative; left: 90%">Add</button>
						       
				 
				 
				  <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="CompanyName" id="txtSearch" ng-model="companyName" style="height:27px"/>
   <div class="input-group-btn">
        <button class="btn btn-primary" ng-click="search()" >
        <span class="glyphicon glyphicon-search" ></span>
        </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="add()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


   </div></div>
				 
				 
				 
				 
				 
				 <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>
				</div>
 -->				<br>
				
				<table id="listOfDevicePrices" class="table table-striped" border="1">
					<tr>
						<td>Company Name</td>
						<td>Base Price</td>
						<td>Currency</td>

						<td>Device</td>


						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="device in arrDevicePrice">
						<td>{{device.devPriceKey.companyName}}</td>
						<td>{{device.basePrice}}</td>
						<td>{{device.currency}}</td>

						<!-- <td>{{device.devPriceKey.tradeinDeviceId}}</td>

						TradeInDeviceId-{{device.deviceEntity.tradeinDeviceId}},Make-{{device.deviceEntity.make}},Model-{{device.deviceEntity.model}},
						 title="Storage-{{device.deviceEntity.storage}},Color-{{device.deviceEntity.color}},Charger-{{device.deviceEntity.charger}}"
						-->

						<td>
						<a href="#" data-toggle="tooltip" data-html="true"  title="Storage-{{device.deviceEntity.storage}},Color-{{device.deviceEntity.color}},Charger-{{device.deviceEntity.charger}}">
						<!-- <button class="btn btn-success btn-md"> -->
						{{device.deviceEntity.make}} - {{device.deviceEntity.model}}
						<!-- </button> -->
						</a>






						</td>

						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#myModal" ng-click="edit(device)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(device)">delete</a></td>


					</tr>
				</table>

				<br>

				<div class="input-group input-group-lg">

					<div class="modal fade" id="delModal" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Confirm Delete</h4>
								</div>
								<div class="modal-body">

									<p>Are you sure you want to delete this</p>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal" ng-click="delete()">yes</button>

									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
								</div>
							</div>

						</div>
					</div>

					<form name="addform">

						<div class="modal fade" id="addModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body">



										Company Name: <input class="form-control" type="text"
											ng-model="dev.devPriceKey.companyName" name="companyName"
											ng-pattern="/^[A-z]+$/" required> <span
											style="color: Red"
											ng-show="addform.companyName.$touched && addform.companyName.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">companyName
											cannot have alphanumeric characters</span> <br> <br>
										basePrice: <input class="form-control" type="text"
											name="basePrice" ng-model="dev.basePrice"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" required="required">
										<span style="color: Red"
											ng-show="addform.basePrice.$touched && addform.basePrice.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.basePrice.$dirty&&addform.basePrice.$error.pattern">Base
											Price must have decimal numbers</span> <br> <br> currency:
										<input class="form-control" type="text" name="currency"
											ng-model="dev.currency" ng-maxlength="3" required="required">
										<span style="color: Red"
											ng-show="addform.currency.$touched && addform.currency.$invalid">
											This field is required and cannot have more then 3chars</span> <br>
										<br> Device: <select class="form-control"
											ng-model="dev.deviceEntity"
											ng-options="x.model+'-'+x.make for x in arrDevices"></select><br>




										<div class="modal-footer">
											<button type="button" ng-disabled="addform.$invalid"
												class="btn btn-default" data-dismiss="modal"
												ng-click="save()">save</button>

											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>

							</div>
						</div>



					</form>
				</div>
				<div class="input-group input-group-lg">
					<form name="editform" ng-show="editForm">

						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit </h4>
									</div>
									<div class="modal-body">
										companyName: <input class="form-control" type="text"
											ng-model="devEdit.devPriceKey.companyName" name="companyName"
											required> <span style="currency: Red"
											ng-show="editform.companyName.$touched && editform.companyName.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="editform.firstname.$dirty&&editform.firstname.$error.pattern">companyName
											cannot have alphanumeric characters</span> <br> <br>
										basePrice: <input class="form-control" type="text"
											name="basePrice" ng-model="devEdit.basePrice"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" required="required">
										<span style="color: Red"
											ng-show="editform.basePrice.$touched && editform.basePrice.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="editform.basePrice.$dirty&&editform.basePrice.$error.pattern">Base
											Price must have decimal numbers</span> <br> <br> currency:
										<input class="form-control" type="text" name="currency"
											ng-maxlength="3" ng-model="devEdit.currency"
											required="required"> <span style="color: Red"
											ng-show="editform.currency.$touched && editform.currency.$invalid">
											This field is required and cannot have more then 3chars</span> <br>
										<br> Device : <select class="form-control"
											ng-model="devEdit.deviceEntity"
											ng-options="x.model +'-'+x.make for x in arrDevices"
											disabled="isDisabled"></select><br> <br> <br>

									</div>
									<div class="modal-footer">
										<button class="btn btn-default" data-dismiss="modal"
											ng-click="update()">update</button>

										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>

</html>