<%@ page contentType="text/html;charset=UTF-8"%>

<html>

<head>
<title>User</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script src="/adminportal/resources/manageEUser.js"></script>

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
					<li><a href="../care/company">Company</a></li>
					<li><a href="../care/manufacturer">Manufacturer</a></li>
					<li><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li class="active"><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
			<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>User</h1>
					<div class="input-group" style="position:relation;left:0%">

				<input type="text" class="form-control" placeholder="CompanyName" id="txtSearch" ng-model="companyName" style="height:27px" />
  		 <div class="input-group-btn">
  		      <button class="btn btn-primary" ng-click="search()" >
   		     <span class="glyphicon glyphicon-search" ></span>
    	    </button>
        	
    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 30%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>

</div>
</div>
				
				</div>
				<br>

				<table  id="listOfOverflows" class="table table-striped" border="1">
					<tr>

						<td>Company Name</td>
						<td>UserId</td>
<<<<<<< HEAD
<!-- 						<td>password</td>
 -->						<td>FirstName</td>
=======
						<!-- <td>password</td> -->
						<td>FirstName</td>
>>>>>>> branch 'master' of https://github.com/kirtiMandwade/internalper.git
						<td>Email</td>
						<td>Department</td>
						<td>Unit</td>


						<td>Edit</td>
						<td>Delete</td>
					</tr>
					<tbody ng-repeat="entity in arrEntity">

						<td>{{entity.eCompany.companyName}}</td>
						<td>{{entity.userId}}</td>
<<<<<<< HEAD
					<!-- 	<td>{{entity.password}}</td> -->
=======
						<!-- <td>{{entity.password}}</td> -->
>>>>>>> branch 'master' of https://github.com/kirtiMandwade/internalper.git
						<td>{{entity.firstName}}</td>
						<td>{{entity.email}}</td>
						<td>{{entity.department.lookUpKey.lookUpValue}}</td>
						<td>{{entity.unit.lookUpKey.lookUpValue}}</td>

						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#editmodal" ng-click="edit(entity)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(entity)">delete</a></td>
					</tr>
</tbody>
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

			 Company Name:<select
              class="form-control" ng-model="ent.eCompany"
              name="selct"
              ng-options="x as x.companyName for x in arrEntityForCompany"
              ></select><br><br>

									UserId: <input class="form-control" type="text" name="configValue" ng-model="ent.userId" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>

											password: <input class="form-control" type="text" name="configValue" ng-model="ent.password" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>

											FirstName: <input class="form-control" type="text" name="configValue" ng-model="ent.firstName" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>

											Email: <input class="form-control" type="text" name="configValue" ng-model="ent.email" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>

											Department: <select
              class="form-control" ng-model="ent.department"
              name="selct"
              ng-options="x as x.lookUpKey.lookUpValue for x in arrEntityForDepartment"
              ></select><br><br>

											Unit: <select
              class="form-control" ng-model="ent.unit"
              name="selct"
              ng-options="x as x.lookUpKey.lookUpValue for x in arrEntityForUnit"
              ></select><br><br>


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

									<!-- Company Id: <input class="form-control" type="number"
											ng-model="ent.companyId" name="companyId" required  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/">
											<span style="color: Red" ng-show="editform.companyId.$dirty&&editform.companyId.$error.pattern">
											Company ID can not have alphabets</span>
             								<span style="color: Red" ng-show="editform.companyId.$touched && editform.companyId.$invalid">
											Company ID Code length exceeded</span>
											<br> <br> -->
											 Company Name:<select
              class="form-control" ng-model="ent.eCompany"
              name="selct"
              ng-options="x as x.companyName for x in arrEntityForCompany"
              ></select><br><br >
									
									UserId: <input class="form-control" type="text" name="configValue" ng-model="ent.userId" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>
											
											<!-- password: <input class="form-control" type="text" name="configValue" ng-model="ent.password" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>
											 -->
											FirstName: <input class="form-control" type="text" name="configValue" ng-model="ent.firstName" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>
											
											Email: <input class="form-control" type="text" name="configValue" ng-model="ent.email" required="required">
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span>
											<br> <br>
											
											Department: <select 
              class="form-control" ng-model="ent.department"
              name="selct"
              ng-options="x as x.lookUpKey.lookUpValue for x in arrEntityForDepartment"
              ></select><br><br>
											
											Unit: <select 
              class="form-control" ng-model="ent.unit"
              name="selct"
              ng-options="x as x.lookUpKey.lookUpValue for x in arrEntityForUnit"
              ></select><br><br>
							

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
</body>
</html>