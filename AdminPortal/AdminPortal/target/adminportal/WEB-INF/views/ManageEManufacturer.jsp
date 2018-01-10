
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
<script src="/adminportal/resources/manageEManufacturer.js"></script>
<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">

<link href="/adminportal/resources/css/angular-datepicker.css"
	rel="stylesheet" type="text/css" />
<script src="/adminportal/resources/js/angular-datepicker.js"></script>

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>

				<ul class="nav nav-pills nav-stacked">
					<li><a href="../care/appConfig">AppConfig</a></li>
					<li><a href="../care/diagissue">DiagIssuesFlow</a></li>
					<li><a href="../care/diagtest">DiagTest</a></li>
					<li><a href="../care/diagtestcompany">DiagTestCompany</a></li>
					<li><a href="../care/model">Model</a></li>
					<li><a href="../care/company">Company</a></li>
					<li class="active"><a href="../care/manufacturer">Manufacturer</a></li>
					<li><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>Manufacturer</h1>
					    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>
				</div>
				<br>

				<table id="listOfOverflows" class="table table-striped" border="1">
					<tr>
						<td>Manufacturer Type</td>
						<td>Manufacturer Name</td>
						<td>Contact Name</td>
						<td>Contact Title</td>

						<td>Is Supported</td>
						<td>Is AutoCreated</td>
						<td>Created At</td>
						<td>Address1</td>
						<td>Address2</td>
						<td>City</td>
						<td>State</td>
						<td>Country</td>
						<td>Zip Code</td>
						<td>Country Id</td>
						<td>Phone Number</td>
						<td>Email Address</td>
						<td>Description</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.manufacturerType}}</td>
						<td>{{entity.manufacturerName}}</td>
						<td>{{entity.contactName}}</td>
						<td>{{entity.contactTitle}}</td>

						<td>{{entity.isSupported}}</td>
						<td>{{entity.isAutoCreated}}</td>
						<td>{{entity.createdAt|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<td>{{entity.address1}}</td>
						<td>{{entity.address2}}</td>
						<td>{{entity.city}}</td>
						<td>{{entity.state}}</td>
						<td>{{entity.country}}</td>
						<td>{{entity.zipcode}}</td>
						<td>{{entity.countryId}}</td>
						<td>{{entity.phoneNumber}}</td>
						<td>{{entity.emailAddress}}</td>
						<td>{{entity.description}}</td>

						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#editmodal" ng-click="edit(entity)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(entity)">delete</a></td>
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
									<div class="modal-body" style="overflow-y: scroll; max-height:55%;  margin-top: 50px; margin-bottom:50px;">

										Manufacturer Type:<input
											class="form-control" type="number" name="manufacturerType"
											ng-model="ent.manufacturerType" required="required"> <span
											style="color: Red"
											ng-show="addform.manufacturerType.$touched && addform.manufacturerType.$invalid">
											This field is required.</span> <br> <br>
										Manufacturer Name: <input
											class="form-control" type="text" name="manufacturerName"
											ng-model="ent.manufacturerName" required="required"> <span
											style="color: Red"
											ng-show="addform.manufacturerName.$touched && addform.manufacturerName.$invalid">
											This field is required.</span> <br> <br>
										Contact Name: <input
											class="form-control" type="text" name="contactName"
											ng-model="ent.contactName" required="required"> <span
											style="color: Red"
											ng-show="addform.contactName.$touched && addform.contactName.$invalid">
											This field is required.</span> <br> <br>
										Contact Title:<input class="form-control" type="text" name="contactTitle"
											ng-model="ent.contactTitle" required="required"> <span
											style="color: Red"
											ng-show="addform.contactTitle.$touched && addform.contactTitle.$invalid">
											This field is required.</span> <br> <br>

Is Supported:<input	type="checkbox" ng-true-value="1" ng-false-value="0" name="isSupported" ng-model="ent.isSupported"  ng-checked="true">
<br> <br>

Is AutoCreated:<input	type="checkbox" ng-true-value="1" ng-false-value="'0'" name="isAutoCreated" ng-model="ent.isAutoCreated"  ng-checked="true">
<br> <br>

Created At:<datepicker style="width: 228px;">
	<input ng-model="ent.createdAt" format="DD-MM-YYYY" type="text" />
	</datepicker>
	<br><br>


Address1:<input	class="form-control" type="text" name="address1"
ng-model="ent.address1" required="required">
<span style="color: Red" ng-show="addform.address1.$touched && addform.address1.$invalid">
This field is required.</span>
<br> <br>

Address2:<input	class="form-control" type="text" name="address2"
ng-model="ent.address2" required="required">
<span style="color: Red" ng-show="addform.address2.$touched && addform.address2.$invalid">
This field is required.</span>
<br> <br>

City:<input	class="form-control" type="text" name="city"
ng-model="ent.city" required="required">
<span style="color: Red" ng-show="addform.city.$touched && addform.city.$invalid">
This field is required.</span>
<br> <br>

State:<input	class="form-control" type="text" name="state"
ng-model="ent.state" required="required">
<span style="color: Red" ng-show="addform.state.$touched && addform.state.$invalid">
This field is required.</span>
<br> <br>

Country:<input	class="form-control" type="text" name="country"
ng-model="ent.country" required="required">
<span style="color: Red" ng-show="addform.country.$touched && addform.country.$invalid">
This field is required.</span>
<br> <br>

Zip Code:<input	class="form-control" type="text" name="zipcode"
ng-model="ent.zipcode" required="required">
<span style="color: Red" ng-show="addform.zipcode.$touched && addform.zipcode.$invalid">
This field is required.</span>
<br> <br>

Country Id:<input	class="form-control" type="number" name="countryId"
ng-model="ent.countryId" required="required">
<span style="color: Red" ng-show="addform.countryId.$touched && addform.countryId.$invalid">
This field is required.</span>
<br> <br>

Phone Number:<input	class="form-control" type="text" name="phoneNumber"
ng-model="ent.phoneNumber" required="required">
<span style="color: Red" ng-show="addform.phoneNumber.$touched && addform.phoneNumber.$invalid">
This field is required.</span>
<br> <br>

Email Address:<input	class="form-control" type="text" name="emailAddress"
ng-model="ent.emailAddress" required="required">
<span style="color: Red" ng-show="addform.emailAddress.$touched && addform.emailAddress.$invalid">
This field is required.</span>
<br> <br>

Description:<input	class="form-control" type="text" name="description"
ng-model="ent.description" required="required">
<span style="color: Red" ng-show="addform.description.$touched && addform.description.$invalid">
This field is required.</span>
<br> <br>

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
				</div>

				<div class="input-group input-group-lg">
					<form name="editform">
						<div class="modal fade" id="editmodal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit </h4>
									</div>
									<div class="modal-body" style="overflow-y: scroll; max-height:55%;  margin-top: 50px; margin-bottom:50px;">

										Manufacturer Type:<input
											class="form-control" type="number" name="manufacturerType"
											ng-model="ent.manufacturerType" required="required"> <span
											style="color: Red"
											ng-show="editform.manufacturerType.$touched && editform.manufacturerType.$invalid">
											This field is required.</span> <br> <br>
										Manufacturer Name: <input
											class="form-control" type="text" name="manufacturerName"
											ng-model="ent.manufacturerName" required="required"> <span
											style="color: Red"
											ng-show="editform.manufacturerName.$touched && editform.manufacturerName.$invalid">
											This field is required.</span> <br> <br>
										Contact Name: <input
											class="form-control" type="text" name="contactName"
											ng-model="ent.contactName" required="required"> <span
											style="color: Red"
											ng-show="editform.contactName.$touched && editform.contactName.$invalid">
											This field is required.</span> <br> <br>
										Contact Title:<input class="form-control" type="text" name="contactTitle"
											ng-model="ent.contactTitle" required="required"> <span
											style="color: Red"
											ng-show="editform.contactTitle.$touched && editform.contactTitle.$invalid">
											This field is required.</span> <br> <br>

Is Supported:<input	type="checkbox" ng-true-value="1" ng-false-value="0" name="isSupported" ng-model="ent.isSupported">
<br> <br>

Is AutoCreated:<input	type="checkbox" ng-true-value="1" ng-false-value="0" name="isAutoCreated" ng-model="ent.isAutoCreated">
<br> <br>

Created At:<datepicker style="width: 228px;">
	<input ng-model="ent.createdAt" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Address1:<input	class="form-control" type="text" name="address1"
ng-model="ent.address1" required="required">
<span style="color: Red" ng-show="editform.address1.$touched && editform.address1.$invalid">
This field is required.</span>
<br> <br>

Address2:<input	class="form-control" type="text" name="address2"
ng-model="ent.address2" required="required">
<span style="color: Red" ng-show="editform.address2.$touched && editform.address2.$invalid">
This field is required.</span>
<br> <br>

City:<input	class="form-control" type="text" name="city"
ng-model="ent.city" required="required">
<span style="color: Red" ng-show="editform.city.$touched && editform.city.$invalid">
This field is required.</span>
<br> <br>

State:<input	class="form-control" type="text" name="state"
ng-model="ent.state" required="required">
<span style="color: Red" ng-show="editform.state.$touched && editform.state.$invalid">
This field is required.</span>
<br> <br>

Country:<input	class="form-control" type="text" name="country"
ng-model="ent.country" required="required">
<span style="color: Red" ng-show="editform.country.$touched && editform.country.$invalid">
This field is required.</span>
<br> <br>

Zip Code:<input	class="form-control" type="text" name="zipcode"
ng-model="ent.zipcode" required="required">
<span style="color: Red" ng-show="editform.zipcode.$touched && editform.zipcode.$invalid">
This field is required.</span>
<br> <br>

Country Id:<input	class="form-control" type="number" name="countryId"
ng-model="ent.countryId" required="required">
<span style="color: Red" ng-show="editform.countryId.$touched && editform.countryId.$invalid">
This field is required.</span>
<br> <br>

Phone Number:<input	class="form-control" type="text" name="phoneNumber"
ng-model="ent.phoneNumber" required="required">
<span style="color: Red" ng-show="editform.phoneNumber.$touched && editform.phoneNumber.$invalid">
This field is required.</span>
<br> <br>

Email Address:<input	class="form-control" type="text" name="emailAddress"
ng-model="ent.emailAddress" required="required">
<span style="color: Red" ng-show="editform.emailAddress.$touched && editform.emailAddress.$invalid">
This field is required.</span>
<br> <br>

Description:<input	class="form-control" type="text" name="description"
ng-model="ent.description" required="required">
<span style="color: Red" ng-show="editform.description.$touched && editform.description.$invalid">
This field is required.</span>
<br> <br>
										</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												ng-disabled="editform.$invalid" data-dismiss="modal"
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
</body>
</html>