
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
<script src="/adminportal/resources/manageProfileFeature.js"></script>
<script src="/adminportal/resources/css/style.css"></script>

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
				<li ><a href="../Warehouse/ManageWSProfile">Profiles</a></li>
					<li><a href="../Warehouse/ManageFeature">Feature</a></li>
					<li ><a href="../Warehouse/ManageProFeature">Product Feature</a></li>
					<li  ><a href="../Warehouse/ManageWorkstation">Workstation</a></li>
					<li><a href="../Warehouse/ManageWorkStationFeature">Workstation Feature</a></li>
					<li class="active"><a href="../Warehouse/ManageProfileFeature">Profile Feature</a></li>
										<li><a href="../logout" > Logout</a></li>


				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>ProfileFeature</h1>
											<button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button>
				</div></br>
					
				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>Feature Cd</td>
						<td>Profile Cd</td>
						<td>Feature Value</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.fea.featureCd}}</td>
						<td>{{entity.wsProfiles.profileCd}}</td>
						<td>{{entity.featureValue}}</td>

						<!-- <td ng-click="edit(grade)">edit</td>
			<td ng-click="delete(grade)">delete</td> -->
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#editmodal" ng-click="edit(entity)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(entity)">delete</a></td>


					</tr>
				</table>

				<br>
				<button class="btn btn-info" data-toggle="modal"
					data-target="#addModal">Add Feature</button>

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
										<h4 class="modal-title">Add Device</h4>
									</div>
									<div class="modal-body">



										Profile
										Cd: <select class="form-control"
											ng-model="ent.wsProfiles"
											ng-options="x.profileCd for x in arrProfiles"></select><br> <br>
Feature
										Cd: <select class="form-control"
											ng-model="ent.fea"
											ng-options="x.featureCd for x in arrFeatures"></select><br> <br>
											Feature Value: <input class="form-control" type="text"
											ng-model="ent.featureValue" name="gradeCode" 
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

										<br> 										<!-- <select ng-model="empl.department">
<option ng-repeat="x in departments" value="{{x}}">{{x.name}}</option>

</select> -->

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
					<form name="editform">
						<div class="modal fade" id="editmodal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit Feature</h4>
									</div>
									<div class="modal-body">

							Profile
										Cd: <select class="form-control"
											ng-model="entEdit.wsProfiles"
											ng-options="x.profileCd for x in arrProfiles"></select><br> <br>
Feature
										Cd: <select class="form-control"
											ng-model="entEdit.fea"
											ng-options="x.featureCd for x in arrFeatures"></select><br> <br>
											Feature Value: <input class="form-control" type="text"
											ng-model="entEdit.featureValue" name="gradeCode" 
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

										<br> 																	<!-- <select ng-model="empl.department">
<option ng-repeat="x in departments" value="{{x}}">{{x.name}}</option>

</select> -->
										<br> <br>

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
						</div>


					</form>

				</div>
			</div>
		</div>
	</div>
</body>

</html>