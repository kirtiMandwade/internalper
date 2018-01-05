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
<script src="/adminportal/resources/manageECompany.js"></script>
<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">

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
					<li class="active"><a href="../care/company">Company</a></li>
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
					<h1>Company</h1>
    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>				</div>
				<br>

				<table id="listOfOverflows" class="table table-striped" border="1">
					<tr>
						<td>Primary Contact Id</td>
						<td>Company Name</td>
						<td>Company Address</td>
						<td>Company City</td>
						<td>Login ID</td>
						<td>Password</td>

						<td>Company State</td>
						<td>Company Zip</td>
						<td>Company Country</td>
						<td>Company Title</td>
						<td>Company Image Filename</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.primaryContactId}}</td>
						<td>{{entity.companyName}}</td>
						<td>{{entity.companyAddress}}</td>
						<td>{{entity.companyCity}}</td>
						<td>{{entity.loginId}}</td>
						<td>{{entity.password}}</td>

						<td>{{entity.companyState}}</td>
						<td>{{entity.companyZip}}</td>
						<td>{{entity.companyCountry}}</td>
						<td>{{entity.companyTitle}}</td>
						<td>{{entity.companyImageFilename}}</td>

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
							<div class="modal-dialog"  >

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body" style="overflow-y: scroll; max-height:55%;  margin-top: 50px; margin-bottom:50px;">

									Primary Contact Id:<input class="form-control" type="number" name="primaryContactId"
											ng-model="ent.primaryContactId" required="required">
											<span style="color: Red" ng-show="addform.primaryContactId.$touched && addform.primaryContactId.$invalid">
											This field is required.</span>
											<br> <br>
									Company Name: <input class="form-control" type="text" name="companyName" ng-model="ent.companyName" required="required">
											<span style="color: Red" ng-show="addform.companyName.$touched && addform.companyName.$invalid">
											This field is required.</span>
											<br> <br>
									Company Address: <input class="form-control" type="text" name="companyAddress" ng-model="ent.companyAddress" required="required">
											<span style="color: Red" ng-show="addform.companyAddress.$touched && addform.companyAddress.$invalid">
											This field is required.</span>
											<br> <br>
									Company City: <input class="form-control" type="text" name="companyCity" ng-model="ent.companyCity" required="required">
											<span style="color: Red" ng-show="addform.companyCity.$touched && addform.companyCity.$invalid">
											This field is required.</span>
											<br> <br>
									Login ID: <input class="form-control" type="text" name="loginId" ng-model="ent.loginId" required="required">
											<span style="color: Red" ng-show="addform.loginId.$touched && addform.loginId.$invalid">
											This field is required.</span>
											<br> <br>

Password:<input	class="form-control" type="text" name="password"
ng-model="ent.password" required="required">
<span style="color: Red" ng-show="addform.password.$touched && addform.password.$invalid">This field is required.</span>
<br> <br>

Company State:<input	class="form-control" type="text" name="companyState"
ng-model="ent.companyState" required="required">
<span style="color: Red" ng-show="addform.companyState.$touched && addform.companyState.$invalid">This field is required.</span>
<br> <br>

Company Zip:<input	class="form-control" type="text" name="companyZip"
ng-model="ent.companyZip" required="required">
<span style="color: Red" ng-show="addform.companyZip.$touched && addform.companyZip.$invalid">This field is required.</span>
<br> <br>

Company Country:<input	class="form-control" type="text" name="companyCountry"
ng-model="ent.companyCountry" required="required">
<span style="color: Red" ng-show="addform.companyCountry.$touched && addform.companyCountry.$invalid">This field is required.</span>
<br> <br>

Company Title:<input	class="form-control" type="text" name="companyTitle"
ng-model="ent.companyTitle" required="required">
<span style="color: Red" ng-show="addform.companyTitle.$touched && addform.companyTitle.$invalid">This field is required.</span>
<br> <br>

Company Image Filename:<input	class="form-control" type="text" name="companyImageFilename"
ng-model="ent.companyImageFilename" required="required">
<span style="color: Red" ng-show="addform.companyImageFilename.$touched && addform.companyImageFilename.$invalid">This field is required.</span>
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

									Primary Contact Id:<input class="form-control" type="number" name="primaryContactId"
											ng-model="ent.primaryContactId" required="required">
											<span style="color: Red" ng-show="editform.primaryContactId.$touched && editform.primaryContactId.$invalid">
											This field is required.</span>
											<br> <br>
									Company Name: <input class="form-control" type="text" name="companyName" ng-model="ent.companyName" required="required">
											<span style="color: Red" ng-show="editform.companyName.$touched && editform.companyName.$invalid">
											This field is required.</span>
											<br> <br>
									Company Address: <input class="form-control" type="text" name="companyAddress" ng-model="ent.companyAddress" required="required">
											<span style="color: Red" ng-show="editform.companyAddress.$touched && editform.companyAddress.$invalid">
											This field is required.</span>
											<br> <br>
									Company City: <input class="form-control" type="text" name="companyCity" ng-model="ent.companyCity" required="required">
											<span style="color: Red" ng-show="editform.companyCity.$touched && editform.companyCity.$invalid">
											This field is required.</span>
											<br> <br>
									Login ID: <input class="form-control" type="text" name="loginId" ng-model="ent.loginId" required="required">
											<span style="color: Red" ng-show="editform.loginId.$touched && editform.loginId.$invalid">
											This field is required.</span>
											<br> <br>

Password:<input	class="form-control" type="text" name="password"
ng-model="ent.password" required="required">
<span style="color: Red" ng-show="editform.password.$touched && editform.password.$invalid">This field is required.</span>
<br> <br>

Company State:<input	class="form-control" type="text" name="companyState"
ng-model="ent.companyState" required="required">
<span style="color: Red" ng-show="editform.companyState.$touched && editform.companyState.$invalid">This field is required.</span>
<br> <br>

Company Zip:<input	class="form-control" type="text" name="companyZip"
ng-model="ent.companyZip" required="required">
<span style="color: Red" ng-show="editform.companyZip.$touched && editform.companyZip.$invalid">This field is required.</span>
<br> <br>

Company Country:<input	class="form-control" type="text" name="companyCountry"
ng-model="ent.companyCountry" required="required">
<span style="color: Red" ng-show="editform.companyCountry.$touched && editform.companyCountry.$invalid">This field is required.</span>
<br> <br>

Company Title:<input	class="form-control" type="text" name="companyTitle"
ng-model="ent.companyTitle" required="required">
<span style="color: Red" ng-show="editform.companyTitle.$touched && editform.companyTitle.$invalid">This field is required.</span>
<br> <br>

Company Image Filename:<input	class="form-control" type="text" name="companyImageFilename"
ng-model="ent.companyImageFilename" required="required">
<span style="color: Red" ng-show="editform.companyImageFilename.$touched && editform.companyImageFilename.$invalid">This field is required.</span>
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