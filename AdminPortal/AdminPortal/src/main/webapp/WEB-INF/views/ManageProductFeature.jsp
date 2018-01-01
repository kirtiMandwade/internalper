
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
<script src="/adminportal/resources/manageProFeature.js"></script>
<script src="/adminportal/resources/css/style.css"></script>

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
				<li ><a href="../warehouse/profile">Profiles</a></li>
					<li ><a href="../warehouse/feature">Feature</a></li>
					<li class="active"><a href="../warehouse/productfeature">Product Feature</a></li>
					<li><a href="../warehouse/workstation">Workstation</a></li>
											<li><a href="../logout" > Logout</a></li>

				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>ProductFeature</h1>
											<button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button>
				</div></br>


				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>Feature Cd</td>
						<td>Product code</td>
						<td>Introduction Version</td>
						<td>Edit</td>
						<td>Delete</td>
					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.featureCd}}</td>
						<td>{{entity.productCd}}</td>
						<td>{{entity.introducedVersion}}</td>

						<!-- <td ng-click="edit(grade)">edit</td>
			<td ng-click="delete(grade)">delete</td> -->
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
									<div class="modal-body">



										Feature Code: <input class="form-control" type="text"
											ng-model="ent.featureCd" name="gradeCode"
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>Product
										Code<input class="form-control" type="text"
											name="model" ng-model="ent.productCd" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDesc.$touched && addform.gradeDesc.$invalid">
											This field is required.</span> <br> <br> Introduction Version: <input class="form-control" type="text" name="color"
											ng-model="ent.introducedVersion" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDisplayName.$touched && addform.gradeDisplayName.$invalid">
											This field is required.</span> <br> <br>


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
										<h4 class="modal-title">Edit </h4>
									</div>
									<div class="modal-body">

						Feature Code: <input class="form-control" type="text"
											ng-model="entEdit.featureCd" name="gradeCode"
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>Product
										Code<input class="form-control" type="text"
											name="model" ng-model="entEdit.productCd" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDesc.$touched && addform.gradeDesc.$invalid">
											This field is required.</span> <br> <br> Introduction Version: <input class="form-control" type="text" name="color"
											ng-model="entEdit.introducedVersion" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDisplayName.$touched && addform.gradeDisplayName.$invalid">
											This field is required.</span> <br> <br>

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