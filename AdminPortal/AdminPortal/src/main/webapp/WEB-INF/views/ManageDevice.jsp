<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="/adminportal/resources/manageDevice.js"></script>
<script src="/adminportal/resources/css/style.css"></script>


</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="../tradein/device">Device</a></li>
					<li><a href="../tradein/grade">Grade</a></li>
					<li><a href="../tradein/deviceprice">Device Price</a></li>
					<li><a href="../tradein/promotion">Promotions</a></li>
										<li><a href="../logout" > Logout</a></li>



				</ul>
				<br>

			</div>

			<div class="col-sm-9">
				<div>
					<h1>Devices</h1>	<button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button>
				</div></br>

				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->

 	<button
					class="btn btn-info" ng-click="search()">Search Device</button></br>
 Model: <input class="form-control" type="text"
											ng-model="model" name="model"
											required> <span style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid"></span></br>

				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>TradeinDeviceId</td>
						<td>Make</td>
						<td>Model</td>
						<td>Color</td>
						<td>Storage</td>
						<td>Charger</td>
						<td>Show Base Price</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="device in arrDevices">
						<td>{{device.tradeinDeviceId}}</td>
						<td>{{device.make}}</td>
						<td>{{device.model}}</td>
						<td>{{device.color}}</td>
						<td>{{device.storage}}</td>
						<td>{{device.charger}}</td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#basePriceModal" ng-click="getBasePrice(device)">Show
								Base Price</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#myModal" ng-click="edit(device)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(device)">delete</a></td>

						<!-- 			<td style="cursor: pointer;" ng-click="delete(device)">delete</td>
 -->

					</tr>
				</table>

				<br>

				<div class="input-group input-group-lg">

					<div class="modal fade" id="basePriceModal" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Base Price</h4>
								</div>
								<div class="modal-body">

									<ul>
										<li ng-repeat=" base in basePrice"
											ng-if="basePrice.length >0">{{ base.productPK.companyName }} : {{
											base.basePrice }}</li>
										<li ng-if="basePrice.length < 1">Base Price Not Assigned
										</li>
									</ul>
								</div>
								<div class="modal-footer">

									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
								</div>
							</div>

						</div>
					</div>
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
										<h4 class="modal-title">Add Device</h4>
									</div>
									<div class="modal-body">


										Make: <input class="form-control" type="text"
											ng-model="dev.make" name="make" ng-pattern="/^[A-z]+$/"
											required> <span style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">make
											cannot have alphanumeric characters</span> <br> <br>
										model: <input class="form-control" type="text" name="model"
											ng-model="dev.model" required="required"> <span
											style="color: Red"
											ng-show="addform.model.$touched && addform.model.$invalid">
											This field is required.</span> <br> <br> color: <input
											class="form-control" type="text" name="color"
											ng-model="dev.color" required="required"> <span
											style="color: Red"
											ng-show="addform.color.$touched && addform.color.$invalid">
											This field is required.</span> <br> <br> storage: <input
											class="form-control" type="text" name="storage"
											ng-model="dev.storage" required="required"> <span
											style="color: Red"
											ng-show="addform.storage.$touched && addform.storage.$invalid">
											This field is required.</span> <br> <br> charger: <input
											type="checkbox" ng-true-value="'Y'" ng-false-value="'N'" name=" charger" ng-model="dev.charger"  ng-checked = "true"
											><!-- Yes <input type="radio" value="N"
											name=" charger" ng-model="dev.charger" required="required">No -->



									</div>
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

					</form>
				</div>
				<div class="input-group input-group-lg">
					<form>


						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit Device</h4>
									</div>
									<div class="modal-body">
										Make: <input class="form-control" type="text"
											ng-model="devEdit.make" name="make" ng-pattern="/^[A-z]+$/"
											required> <span style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">make
											cannot have alphanumeric characters</span> <br> <br>
										model: <input class="form-control" type="text" name="model"
											ng-model="devEdit.model" required="required"> <span
											style="color: Red"
											ng-show="addform.model.$touched && addform.model.$invalid">
											This field is required.</span> <br> <br> color: <input
											class="form-control" type="text" name="color"
											ng-model="devEdit.color" required="required"> <span
											style="color: Red"
											ng-show="addform.color.$touched && addform.color.$invalid">
											This field is required.</span> <br> <br> storage: <input
											class="form-control" type="text" name="storage"
											ng-model="devEdit.storage" required="required"> <span
											style="color: Red"
											ng-show="addform.storage.$touched && addform.storage.$invalid">
											This field is required.</span> <br>
 <br> charger: <input
											type="checkbox" ng-true-value="'Y'" ng-false-value="'N'" name="charger" ng-model="devEdit.charger">
 <br> <br> <br>
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
				`
			</div>
		</div>




	</div>


	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
