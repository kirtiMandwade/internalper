
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
<script src="/adminportal/resources/ManageEModel.js"></script>
<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">

<link href="/adminportal/resources/css/angular-datepicker.css"
	rel="stylesheet" type="text/css" />
<script src="/adminportal/resources/js/angular-datepicker.js"></script>
<script src="/adminportal/resources/js/angular-base64-upload.js"></script>
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
					<li class="active"><a href="../care/model">Model</a></li>
					<li><a href="../care/company">Company</a></li>
					<li><a href="../care/manufacturer">Manufacturer</a></li>
					<li><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>Model</h1>
    <button  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>				</div></br>

				<table id="listOfOverflows" class="table table-striped" border="1">
					<tr>
						<td>Platform Id</td>

						<td>Manufacturer Id</td>
						<td>Model Number</td>
						<td>Country Id</td>
						<td>Network Technology Id</td>
						<td>Cable Id</td>


						<td>Battery Id</td>
						<td>Charger Id</td>
						<td>Location Id</td>
						<td>Source Id</td>
						<td>Shipment Id</td>
						<td>Model Condition</td>
						<td>Release Date</td>
						<td>Is AutoCreated</td>
						<td>Created At</td>
						<td>Updated At</td>
						<td>Is Valid</td>
						<td>Initial Firmware Id</td>
						<td>Availability</td>
						<td>Battery Status</td>
						<td>Cable Status</td>

						<td>Device Image</td>

						<td>Cost</td>
						<td>Web URL Link</td>
						<td>Model Name</td>
						<td>Default Profile Present</td>
						<td>Device Image Location</td>
						<td>Source Product Code</td>
						<td>P O Number</td>
						<td>Manual Instruction Description</td>
						<td>Description</td>
						<td>Default Profile File Name</td>
						<td>Default Profile Last Update</td>


						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.platformId}}</td>

						<td>{{entity.manufacturerId}}</td>
						<td>{{entity.modelNumber}}</td>
						<td>{{entity.countryId}}</td>
						<td>{{entity.networkTechnologyId}}</td>
						<td>{{entity.cableId}}</td>

						<td>{{entity.batteryId}}</td>
						<td>{{entity.chargerId}}</td>
						<td>{{entity.locationId}}</td>
						<td>{{entity.sourceId}}</td>
						<td>{{entity.shipmentId}}</td>
						<td>{{entity.modelCondition}}</td>
						<td>{{entity.releaseDate|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<!-- <td>{{entity.isAutoCreated}}</td> -->
						<!-- new -->
						  <td ng-if="entity.isAutoCreated == '1' ">AutoCreated</td>
						  <td ng-if="entity.isAutoCreated == '0' ">Not AutoCreated</td>
						
						<!-- end -->
						<td>{{entity.createdAt|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<td>{{entity.updatedAt|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<!-- <td>{{entity.isValid}}</td> -->
						<!-- new -->
						  <td ng-if="entity.isValid == '1' ">Valid</td>
						  <td ng-if="entity.isValid == '0' ">Not Valid</td>
						
						<!-- end -->
						<td>{{entity.initialFirmwareId}}</td>
						<td>{{entity.availability}}</td>
						<td>{{entity.batteryStatus}}</td>
						<td>{{entity.cableStatus}}</td>


						<!-- <td>
      <img data-ng-src="data:image/png;base64,{{entity.deviceImage}}"/>
      </td>
						<td>{{entity.deviceImage}}</td> -->

						<td>
						<input type="hidden" class="form-control" accept="image/*" name="deviceImage" ng-model="entity.deviceImage" ng-bind="{{entity.deviceImage}}" onchange="openFile(event)">
						<img id="output">
						</td>





						<td>{{entity.cost}}</td>
						<td>{{entity.weburlLink}}</td>
						<td>{{entity.modelName}}</td>
						<td>{{entity.defaultProfilePresent}}</td>
						<td>{{entity.deviceImageLocation}}</td>
						<td>{{entity.sourceProductCode}}</td>
						<td>{{entity.poNumber}}</td>
						<td>{{entity.manualInstructionDesc}}</td>
						<td>{{entity.description}}</td>
						<td>{{entity.defaultProfileFileName}}</td>
						<td>{{entity.defaultProfileLastUpdate}}</td>

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
					<form name="addform" enctype="multipart/form-data" ><!-- enctype="multipart/form-data" -->
						<div class="modal fade" id="addModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body" style="overflow-y: scroll; max-height:55%;  margin-top: 50px; margin-bottom:50px;">


										Platform Id:<input class="form-control" type="number" name="platformId"
											ng-model="ent.platformId" required="required"> <span
											style="color: Red"
											ng-show="addform.platformId.$touched && addform.platformId.$invalid">
											This field is required.</span> <br> <br> ManufacturerId<input
											class="form-control" type="number" name="manufacturerId"
											ng-model="ent.manufacturerId" required="required"> <span
											style="color: Red"
											ng-show="addform.manufacturerId.$touched && addform.manufacturerId.$invalid">
											This field is required.</span> <br> <br>
										Model Number: <input
											class="form-control" type="text" name="modelNumber"
											ng-model="ent.modelNumber" required="required"> <span
											style="color: Red"
											ng-show="addform.modelNumber.$touched && addform.modelNumber.$invalid">
											This field is required.</span> <br> <br>
										Country Id: <input
											class="form-control" type="number" name="countryId"
											ng-model="ent.countryId" required="required"> <span
											style="color: Red"
											ng-show="addform.countryId.$touched && addform.countryId.$invalid">
											This field is required.</span> <br> <br>
										Network Technology Id: <input class="form-control" type="number"
											name="networkTechnologyId" ng-model="ent.networkTechnologyId"
											required="required"> <span style="color: Red"
											ng-show="addform.networkTechnologyId.$touched && addform.networkTechnologyId.$invalid">
											This field is required.</span> <br> <br> CableId: <input
											class="form-control" type="number" name="cableId"
											ng-model="ent.cableId" required="required"> <span
											style="color: Red"
											ng-show="addform.cableId.$touched && addform.cableId.$invalid">
											This field is required.</span> <br> <br>


Battery Id:<input	class="form-control" type="number" name="batteryId"
ng-model="ent.batteryId" required="required">
<span style="color: Red" ng-show="addform.batteryId.$touched && addform.batteryId.$invalid">
This field is required.</span>
<br> <br>

Charger Id:<input	class="form-control" type="number" name="chargerId"
ng-model="ent.chargerId" required="required">
<span style="color: Red" ng-show="addform.chargerId.$touched && addform.chargerId.$invalid">
This field is required.</span>
<br> <br>

Location Id:<input	class="form-control" type="number" name="locationId"
ng-model="ent.locationId" required="required">
<span style="color: Red" ng-show="addform.locationId.$touched && addform.locationId.$invalid">
This field is required.</span>
<br> <br>

Source Id:<input	class="form-control" type="number" name="sourceId"
ng-model="ent.sourceId" required="required">
<span style="color: Red" ng-show="addform.sourceId.$touched && addform.sourceId.$invalid">
This field is required.</span>
<br> <br>

Shipment Id:<input	class="form-control" type="number" name="shipmentId"
ng-model="ent.shipmentId" required="required">
<span style="color: Red" ng-show="addform.shipmentId.$touched && addform.shipmentId.$invalid">
This field is required.</span>
<br> <br>

Model Condition:<input	class="form-control" type="text" name="modelCondition"
ng-model="ent.modelCondition" required="required">
<span style="color: Red" ng-show="addform.modelCondition.$touched && addform.modelCondition.$invalid">
This field is required.</span>
<br> <br>

Release Date:<datepicker style="width: 228px;">
	<input ng-model="ent.releaseDate" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Is AutoCreated:<input	type="checkbox" ng-true-value="1" ng-false-value="0" name="isAutoCreated" ng-model="ent.isAutoCreated"  ng-checked="true">
<br> <br>

Created At:<datepicker style="width: 228px;">
	<input ng-model="ent.createdAt" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Updated At:<datepicker style="width: 228px;">
	<input ng-model="ent.updatedAt" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Is Valid:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="isValid" ng-model="ent.isValid"  ng-checked="true">
<br> <br>

Initial Firmware Id:<input	class="form-control" type="number" name="initialFirmwareId"
ng-model="ent.initialFirmwareId" required="required">
<span style="color: Red" ng-show="addform.initialFirmwareId.$touched && addform.initialFirmwareId.$invalid">
This field is required.</span>
<br> <br>

Availability:<input	class="form-control" type="number" name="availability"
ng-model="ent.availability" required="required">
<span style="color: Red" ng-show="addform.availability.$touched && addform.availability.$invalid">
This field is required.</span>
<br> <br>

Battery Status:<input	class="form-control" type="number" name="batteryStatus"
ng-model="ent.batteryStatus" required="required">
<span style="color: Red" ng-show="addform.batteryStatus.$touched && addform.batteryStatus.$invalid">
This field is required.</span>
<br> <br>

Cable Status:<input	class="form-control" type="number" name="cableStatus"
ng-model="ent.cableStatus" required="required">
<span style="color: Red" ng-show="addform.cableStatus.$touched && addform.cableStatus.$invalid">
This field is required.</span>
<br> <br>




Device Image:<input class="form-control" type="file" accept="image/*" name="deviceImage"
ng-model="ent.deviceImage" base-sixty-four-input	onchange="openFile(event)">
<br>
<img id="output">

<br> <br>




Cost:<input	class="form-control" type="number" name="cost"
ng-model="ent.cost" required="required">
<span style="color: Red" ng-show="addform.cost.$touched && addform.cost.$invalid">
This field is required.</span>
<br> <br>

Web URL Link:<input	class="form-control" type="text" name="weburlLink"
ng-model="ent.weburlLink" required="required">
<span style="color: Red" ng-show="addform.weburlLink.$touched && addform.weburlLink.$invalid">
This field is required.</span>
<br> <br>

Model Name:<input	class="form-control" type="text" name="modelName"
ng-model="ent.modelName" required="required">
<span style="color: Red" ng-show="addform.modelName.$touched && addform.modelName.$invalid">
This field is required.</span>
<br> <br>

Default Profile Present:<input	class="form-control" type="number" name="defaultProfilePresent"
ng-model="ent.defaultProfilePresent" required="required">
<span style="color: Red" ng-show="addform.defaultProfilePresent.$touched && addform.defaultProfilePresent.$invalid">
This field is required.</span>
<br> <br>

Device Image Location:<input	class="form-control" type="text" name="deviceImageLocation"
ng-model="ent.deviceImageLocation" required="required">
<span style="color: Red" ng-show="addform.deviceImageLocation.$touched && addform.deviceImageLocation.$invalid">
This field is required.</span>
<br> <br>

Source Product Code:<input	class="form-control" type="text" name="sourceProductCode"
ng-model="ent.sourceProductCode" required="required">
<span style="color: Red" ng-show="addform.sourceProductCode.$touched && addform.sourceProductCode.$invalid">
This field is required.</span>
<br> <br>

P O Number:<input	class="form-control" type="text" name="poNumber"
ng-model="ent.poNumber" required="required">
<span style="color: Red" ng-show="addform.poNumber.$touched && addform.poNumber.$invalid">
This field is required.</span>
<br> <br>

Manual Instruction Description:<input	class="form-control" type="text" name="manualInstructionDesc"
ng-model="ent.manualInstructionDesc" required="required">
<span style="color: Red" ng-show="addform.manualInstructionDesc.$touched && addform.manualInstructionDesc.$invalid">
This field is required.</span>
<br> <br>

Description:<input	class="form-control" type="text" name="description"
ng-model="ent.description" required="required">
<span style="color: Red" ng-show="addform.description.$touched && addform.description.$invalid">
This field is required.</span>
<br> <br>

Default Profile File Name:<input	class="form-control" type="text" name="defaultProfileFileName"
ng-model="ent.defaultProfileFileName" required="required">
<span style="color: Red" ng-show="addform.defaultProfileFileName.$touched && addform.defaultProfileFileName.$invalid">
This field is required.</span>
<br> <br>

Default Profile Last Update:<input	class="form-control" type="number" name="defaultProfileLastUpdate"
ng-model="ent.defaultProfileLastUpdate" required="required">
<span style="color: Red" ng-show="addform.defaultProfileLastUpdate.$touched && addform.defaultProfileLastUpdate.$invalid">
This field is required.</span>
<br> <br>


										</div>
										<div class="modal-footer">
											<button type="button"
												class="btn btn-default" data-dismiss="modal"
												ng-click="save()">save</button> <!-- ng-disabled="addform.$invalid" -->

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
					<form name="editform" enctype="multipart/form-data">
						<div class="modal fade" id="editmodal" role="dialog">
							<div class="modal-dialog" >

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit </h4>
									</div>
									<div class="modal-body" style="overflow-y: scroll; max-height:55%;  margin-top: 50px; margin-bottom:50px;">
										Platform Id:<input class="form-control" type="number" name="platformId"
											ng-model="entEdit.platformId" required="required"> <span
											style="color: Red"
											ng-show="addform.platformId.$touched && addform.platformId.$invalid">
											This field is required.</span> <br> <br>
										Manufacturer Id:<input
											class="form-control" type="number" name="manufacturerId"
											ng-model="entEdit.manufacturerId" required="required">
										<span style="color: Red"
											ng-show="addform.manufacturerId.$touched && addform.manufacturerId.$invalid">
											This field is required.</span> <br> <br>
										Model Number: <input
											class="form-control" type="text" name="modelNumber"
											ng-model="entEdit.modelNumber" required="required"> <span
											style="color: Red"
											ng-show="addform.modelNumber.$touched && addform.modelNumber.$invalid">
											This field is required.</span> <br> <br>
										Country Id: <input
											class="form-control" type="number" name="countryId"
											ng-model="entEdit.countryId" required="required"> <span
											style="color: Red"
											ng-show="addform.countryId.$touched && addform.countryId.$invalid">
											This field is required.</span> <br> <br>
										Network Technology Id: <input class="form-control" type="number"
											name="networkTechnologyId" ng-model="entEdit.networkTechnologyId"
											required="required"> <span style="color: Red"
											ng-show="addform.networkTechnologyId.$touched && addform.networkTechnologyId.$invalid">
											This field is required.</span> <br> <br>
										Cable Id: <input
											class="form-control" type="number" name="cableId"
											ng-model="entEdit.cableId" required="required"> <span
											style="color: Red"
											ng-show="addform.cableId.$touched && addform.cableId.$invalid">
											This field is required.</span> <br> <br>

Battery Id:<input	class="form-control" type="number" name="batteryId"
ng-model="entEdit.batteryId" required="required">
<span style="color: Red" ng-show="addform.batteryId.$touched && addform.batteryId.$invalid">
This field is required.</span>
<br> <br>

Charger Id:<input	class="form-control" type="number" name="chargerId"
ng-model="entEdit.chargerId" required="required">
<span style="color: Red" ng-show="addform.chargerId.$touched && addform.chargerId.$invalid">
This field is required.</span>
<br> <br>

Location Id:<input	class="form-control" type="number" name="locationId"
ng-model="entEdit.locationId" required="required">
<span style="color: Red" ng-show="addform.locationId.$touched && addform.locationId.$invalid">
This field is required.</span>
<br> <br>

Source Id:<input	class="form-control" type="number" name="sourceId"
ng-model="entEdit.sourceId" required="required">
<span style="color: Red" ng-show="addform.sourceId.$touched && addform.sourceId.$invalid">
This field is required.</span>
<br> <br>

Shipment Id:<input	class="form-control" type="number" name="shipmentId"
ng-model="entEdit.shipmentId" required="required">
<span style="color: Red" ng-show="addform.shipmentId.$touched && addform.shipmentId.$invalid">
This field is required.</span>
<br> <br>

Model Condition:<input	class="form-control" type="text" name="modelCondition"
ng-model="entEdit.modelCondition" required="required">
<span style="color: Red" ng-show="addform.modelCondition.$touched && addform.modelCondition.$invalid">
This field is required.</span>
<br> <br>

Release Date:<datepicker style="width: 228px;">
	<input ng-model="entEdit.releaseDate" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Is AutoCreated:<input	type="checkbox" ng-true-value="1" ng-false-value="0" name="isAutoCreated" ng-model="entEdit.isAutoCreated"  ng-checked="true">
<br> <br>

Created At:<datepicker style="width: 228px;">
	<input ng-model="entEdit.createdAt" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Updated At:<datepicker style="width: 228px;">
	<input ng-model="entEdit.updatedAt" format="DD-MM-YYYY"
	type="text" />
	</datepicker>
	<br> <br>

Is Valid:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="isValid" ng-model="entEdit.isValid"  ng-checked="true">
<br> <br>

Initial Firmware Id:<input	class="form-control" type="number" name="initialFirmwareId"
ng-model="entEdit.initialFirmwareId" required="required">
<span style="color: Red" ng-show="addform.initialFirmwareId.$touched && addform.initialFirmwareId.$invalid">
This field is required.</span>
<br> <br>

Availability:<input	class="form-control" type="number" name="availability"
ng-model="entEdit.availability" required="required">
<span style="color: Red" ng-show="addform.availability.$touched && addform.availability.$invalid">
This field is required.</span>
<br> <br>

Battery Status:<input	class="form-control" type="number" name="batteryStatus"
ng-model="entEdit.batteryStatus" required="required">
<span style="color: Red" ng-show="addform.batteryStatus.$touched && addform.batteryStatus.$invalid">
This field is required.</span>
<br> <br>

Cable Status:<input	class="form-control" type="number" name="cableStatus"
ng-model="entEdit.cableStatus" required="required">
<span style="color: Red" ng-show="addform.cableStatus.$touched && addform.cableStatus.$invalid">
This field is required.</span>
<br> <br>




Device Image:<input class="form-control" type="file" accept="image/*" name="deviceImage"
ng-model="entEdit.deviceImage" base-sixty-four-input onfocus="openFile(event)"><!-- 	onchange="openFile(event)"> -->
<br>
<img id="output">

<br> <br>





Cost<input	class="form-control" type="number" name="cost"
ng-model="entEdit.cost" required="required">
<span style="color: Red" ng-show="addform.cost.$touched && addform.cost.$invalid">
This field is required.</span>
<br> <br>

Web URL Link:<input	class="form-control" type="text" name="weburlLink"
ng-model="entEdit.weburlLink" required="required">
<span style="color: Red" ng-show="addform.weburlLink.$touched && addform.weburlLink.$invalid">
This field is required.</span>
<br> <br>

Model Name:<input	class="form-control" type="text" name="modelName"
ng-model="entEdit.modelName" required="required">
<span style="color: Red" ng-show="addform.modelName.$touched && addform.modelName.$invalid">
This field is required.</span>
<br> <br>

Default Profile Present:<input	class="form-control" type="number" name="defaultProfilePresent"
ng-model="entEdit.defaultProfilePresent" required="required">
<span style="color: Red" ng-show="addform.defaultProfilePresent.$touched && addform.defaultProfilePresent.$invalid">
This field is required.</span>
<br> <br>

Device Image Location:<input	class="form-control" type="text" name="deviceImageLocation"
ng-model="entEdit.deviceImageLocation" required="required">
<span style="color: Red" ng-show="addform.deviceImageLocation.$touched && addform.deviceImageLocation.$invalid">
This field is required.</span>
<br> <br>

Source Product Code:<input	class="form-control" type="text" name="sourceProductCode"
ng-model="entEdit.sourceProductCode" required="required">
<span style="color: Red" ng-show="addform.sourceProductCode.$touched && addform.sourceProductCode.$invalid">
This field is required.</span>
<br> <br>

P O Number:<input	class="form-control" type="text" name="poNumber"
ng-model="entEdit.poNumber" required="required">
<span style="color: Red" ng-show="addform.poNumber.$touched && addform.poNumber.$invalid">
This field is required.</span>
<br> <br>

Manual Instruction Description:<input	class="form-control" type="text" name="manualInstructionDesc"
ng-model="entEdit.manualInstructionDesc" required="required">
<span style="color: Red" ng-show="addform.manualInstructionDesc.$touched && addform.manualInstructionDesc.$invalid">
This field is required.</span>
<br> <br>

Description<input	class="form-control" type="text" name="description"
ng-model="ent.description" required="required">
<span style="color: Red" ng-show="addform.description.$touched && addform.description.$invalid">
This field is required.</span>
<br> <br>

Default Profile FileName:<input	class="form-control" type="text" name="defaultProfileFileName"
ng-model="ent.defaultProfileFileName" required="required">
<span style="color: Red" ng-show="addform.defaultProfileFileName.$touched && addform.defaultProfileFileName.$invalid">
This field is required.</span>
<br> <br>

Default Profile Last Update:<input	class="form-control" type="number" name="defaultProfileLastUpdate"
ng-model="ent.defaultProfileLastUpdate" required="required">
<span style="color: Red" ng-show="addform.defaultProfileLastUpdate.$touched && addform.defaultProfileLastUpdate.$invalid">
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
		</div>
	</div>
</body>

</html>