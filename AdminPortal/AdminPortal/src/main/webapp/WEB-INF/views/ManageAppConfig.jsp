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
<script src="/adminportal/resources/manageAppConfig.js"></script>

<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>

				<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="../care/appConfig">AppConfig</a></li>
					<li ><a href="../care/diagissue">DiagIssuesFlow</a></li>
					<li><a href="../care/diagtest">DiagTest</a></li>
					<li><a href="../care/diagtestcompany">DiagTestCompany</a></li>
					<li><a href="../care/model">Model</a></li>
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
					<h1>AppConfig</h1>
       <!--  <button class="btn btn-primary"  data-toggle="modal" data-target="#duplicateModal" style="position: relative; left: 89%">
        <span >Duplicate</span>

    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus"></span>
        </button> -->


  <div class="input-group" style="position:relation;left:40%">

				<input type="text" class="form-control" placeholder="Company Name" id="txtSearch" ng-model="company" style="height:27px;width:50%"/>
   <div class="input-group-btn" >
        <button class="btn btn-primary" ng-click="search()" style="position: relative; left:-530px">
        <span class="glyphicon glyphicon-search" ></span>
        </button>
             <button class="btn btn-primary"  data-toggle="modal" data-target="#duplicateModal" style="position: relative; left:-520px">
        <span >Duplicate</span>
</button>
    <button style="position: relative; left:-500px" class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


   </div></div>
				</div>
				<br>

				<table class="table table-striped" border="1">
					<tr>

						<td>Company Name</td>
						<td>Config Key</td>
						<td>Config Value</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>
<tr ng-repeat="entity in arrEntity">
						<td>{{entity.company.companyName}}</td>
						<td>{{entity.configKey}}</td>
						<td>{{entity.configValue}}</td>

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

					<form name="duplicateform">
					<div class="modal fade" id="duplicateModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body">

									<!-- Company Id:<input class="form-control" type="number"
											ng-model="ent.companyId" name="companyId" required  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/">
											<span style="color: Red" ng-show="addform.companyId.$dirty&&addform.companyId.$error.pattern">
											Company ID can not have alphabets</span>
             								<span style="color: Red" ng-show="addform.companyId.$touched && addform.companyId.$invalid">
											Company ID Code length exceeded</span>
											<br> <br>
									 -->
									Copy From Company Name:<select
              							class="form-control" ng-model="fromCompany" name="selct" ng-options="x as x.companyName for x in arrEntityForCompany"></select><br><br >

									Copy To Company Name:<select
              							class="form-control" ng-model="toCompany" name="selct" ng-options="x as x.companyName for x in arrEntityForCompany"></select><br><br >

									 										<div class="modal-footer">
											<button type="button"
												class="btn btn-default" data-dismiss="modal" data-target="#editmodal"
												ng-click="duplicate()">copy</button>

											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div></form>
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

									<!-- Company Id:<input class="form-control" type="number"
											ng-model="ent.companyId" name="companyId" required  ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/">
											<span style="color: Red" ng-show="addform.companyId.$dirty&&addform.companyId.$error.pattern">
											Company ID can not have alphabets</span>
             								<span style="color: Red" ng-show="addform.companyId.$touched && addform.companyId.$invalid">
											Company ID Code length exceeded</span>
											<br> <br>
									 -->
									 Company Name:<select
              							class="form-control" ng-model="ent.company" name="selct" ng-options="x as x.companyName for x in arrEntityForCompany"></select><br><br >

												<div data-ng-repeat="choice in choices"
											style="position: relative;">

																		  <div class="row">
						<div class="col-sm-4" style="background-color:lavender;">

									 Config Key:<input class="form-control" type="text" name="configKey" ng-model="choice.configKey" >
											<span style="color: Red" ng-show="addform.configKey.$touched && addform.configKey.$invalid">
											This field is required.</span></div>

								 <div class="col-sm-4" style="background-color:lavenderblush;">
									Config Value: <input class="form-control" type="text" name="configValue" ng-model="choice.configValue" >
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span></div>


											    <div class="col-sm-4" style="background-color:lavender;">Action Value <br>




											<button ng-click="addNewChoice()"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>


										<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button></div>
  </div></div>

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
              class="form-control" ng-model="ent.company" name="selct" ng-options="x as x.companyName for x in arrEntityForCompany"
              ></select><br><br >
									Config Key:<input class="form-control" type="text" name="configKey" ng-model="ent.configKey" required="required">
											<span style="color: Red" ng-show="editform.configKey.$touched && editform.configKey.$invalid">
											This field is required.</span>
											<br> <br>
									Config Value: <input class="form-control" type="text" name="configValue" ng-model="ent.configValue" required="required">
											<span style="color: Red" ng-show="editform.configValue.$touched && editform.configValue.$invalid">
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


<form name="dupeditform">
						<div class="modal fade" id="dupeditform" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit </h4>
									</div>
									<div class="modal-body">



											 Company Name:<select
              class="form-control" ng-model="dupent.company" name="selct" ng-options="x as x.companyName for x in arrEntityForCompany"
              ></select><br><br >




																					<div data-ng-repeat="choice in choices"
											style="position: relative;">

																		  <div class="row">
						<div class="col-sm-4" style="background-color:lavender;">

									 Config Key:<input class="form-control" type="text" name="configKey" ng-model="choice.configKey" >
											<span style="color: Red" ng-show="addform.configKey.$touched && addform.configKey.$invalid">
											This field is required.</span></div>

								 <div class="col-sm-4" style="background-color:lavenderblush;">
									Config Value: <input class="form-control" type="text" name="configValue" ng-model="choice.configValue" >
											<span style="color: Red" ng-show="addform.configValue.$touched && addform.configValue.$invalid">
											This field is required.</span></div>


											    <div class="col-sm-4" style="background-color:lavender;">Action Value <br>




											<button ng-click="addNewChoice()"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>


										<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button></div>
  </div></div>

									</div>

										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												ng-disabled="dupeditform.$invalid" data-dismiss="modal"
												ng-click="saveDuplicate()">update</button>

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