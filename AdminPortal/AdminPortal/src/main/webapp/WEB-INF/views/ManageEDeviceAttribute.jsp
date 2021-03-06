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
<script src="/adminportal/resources/manageEDevAttribute.js"></script>
<link rel="stylesheet" href="/adminportal/resources/css/style.css">

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
					<li><a href="../care/manufacturer">Manufacturer</a></li>
					<li class="active"><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>DeviceAttributes</h1>

					<button class="btn btn-primary" data-toggle="modal"
						data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()" style="position: relative; left: 90%">
						<span class="glyphicon glyphicon-plus"></span>
					</button>
				</div>
				<br>

				<table  class="table table-striped" border="1">
					<tr>

						<td>Device Model</td>
						<td>Device Make</td>

						<td>Attribute Name</td>
						<td>Attribute Value</td>
						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.eMod.modelName}}</td>
						<td>{{entity.eMod.modelName}}</td>

						<td>{{entity.attributeName.lookUpKey.lookUpValue}}</td>
						<td>{{entity.attributeValue}}</td>

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
										<h4 class="modal-title">Add</h4>
									</div>
									<div class="modal-body">
									
									Model Device Id:
										<select class="form-control" ng-model="ent.eMod"
											ng-options="x.deviceModelId for x in arrModel"></select><br>
									
									
				<div data-ng-repeat="choice in choices" style="position: relative;">

				<div class="row">
				<div class="col-sm-4" style="background-color:lavender;">
					Attribute Name:<select class="form-control" id="{{choice.id}}" 
							ng-model="choice.attributeName" name="attributeName"
							ng-options="x as x.lookUpKey.lookUpValue for x in arrLookUpAtrNam | filter:setNewArrLookUpAtrNam"></select>
							<span style="color: Red" ng-show="addform.attributeName.$touched && addform.attributeName.$invalid">
							This field is required.</span>
					
				</div>
				<div class="col-sm-4" style="background-color:lavenderblush;">
									
					Attribute Value:
						<input class="form-control" type="text" id="{{choice.id}}" name="attributeValue"
						ng-model="choice.attributeValue" required="required"><!--  <span
						style="color: Red"
						ng-show="addform.attributeValue.$touched && addform.attributeValue.$invalid">
						This field is required.</span> -->
				</div>
				<div class="col-sm-4" style="background-color:lavender;">Action Value <br>

											<button ng-click="addNewChoice();setNewArrLookUpAtrNam(choice.id)"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>

										<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button>
				</div>
				</div>
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
									<h4 class="modal-title">Edit</h4>
								</div>
								<div class="modal-body">

									Attribute Name:<select class="form-control"	ng-model="ent.attributeName" name="attributeName"
																ng-options="x as x.lookUpKey.lookUpValue for x in arrLookUpAtrNam"></select>
								<span style="color: Red" ng-show="addform.attributeName.$touched && addform.attributeName.$invalid">
								This field is required.</span>
									
									
									<!-- <input class="form-control" type="text"
										name="attributeName" ng-model="ent.attributeName"
										required="required"> <span style="color: Red"
										ng-show="editform.attributeName.$touched && editform.attributeName.$invalid">
										This field is required.</span> --> <br> <br> Attribute Value: <input
										class="form-control" type="text" name="attributeValue"
										ng-model="ent.attributeValue" required="required"> <span
										style="color: Red"
										ng-show="editform.attributeValue.$touched && editform.attributeValue.$invalid">
										This field is required.</span> <br> <br> Model Device Id: <select
										class="form-control" ng-model="ent.eMod"
										ng-options="x.deviceModelId for x in arrModel"></select><br>

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