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
<script src="/adminportal/resources/manageDiagTest.js"></script>
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
					<li  class="active"><a href="../care/diagtest">DiagTest</a></li>
					<li><a href="../care/diagtestcompany">DiagTestCompany</a></li>
					<li><a href="../care/model">Model</a></li>
					<li><a href="../care/company">Company</a></li>
					<li><a href="../care/manufacturer">Manufacturer</a></li>
					<li><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>DiagTest</h1>
					<button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button>
				</div>
				<br>
				
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>Test Code</td>
						<td>Android Supported</td>
						<td>IOS Supported</td>
						<td>Test Type</td>
						<td>Order Number</td>
						<td>Category Code</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.testCd}}</td>
						<td>{{entity.androidSupported}}</td>
						<td>{{entity.iosSupported}}</td>
						<td>{{entity.testType}}</td>
						<td>{{entity.orderNum}}</td>
						<td>{{entity.categoryCd}}</td>

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


									Test Code:<input class="form-control" type="text" name="testCd" ng-model="ent.testCd" required="required">
										<span style="color: Red" ng-show="addform.testCd.$touched && addform.testCd.$invalid">
										This field is required.</span> <br> <br>
									Android Supported:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="androidsupported"
										ng-model="ent.androidSupported"  ng-checked = "true">
										<br> <br> 
									IOS Supported:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="iossupported"
										ng-model="ent.iosSupported"  ng-checked = "true">
										<br> <br>
									Test Type:<input	class="form-control" type="text" name="testType" ng-model="ent.testType" required="required">
										<span style="color: Red" ng-show="addform.testType.$touched && addform.testType.$invalid">
										This field is required.</span>
										<br> <br>
									Order Number: <input class="form-control" type="number" name="orderNum" ng-model="ent.orderNum" required="required">
										<span style="color: Red" ng-show="addform.orderNum.$touched && addform.orderNum.$invalid">
										This field is required.</span>
										<br> <br>
									Category Code: <input class="form-control" type="text" name="categoryCd" ng-model="ent.categoryCd" required="required">
										<span style="color: Red" ng-show="addform.categoryCd.$touched && addform.categoryCd.$invalid">
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
									<div class="modal-body">

									Test Code:<input class="form-control" type="text" name="testCd" ng-model="entEdit.testCd" readonly="readonly">
										<span style="color: Red" ng-show="editform.testCd.$touched && editform.testCd.$invalid">
										This field is required.</span> <br> <br>
									Android Supported:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="androidsupported"
										ng-model="entEdit.androidSupported"  ng-checked = "true">
										<br> <br> 
									IOS Supported:<input type="checkbox" ng-true-value="1" ng-false-value="0" name="iossupported"
										ng-model="entEdit.iosSupported"  ng-checked = "true">
										<br> <br>
									Test Type:<input class="form-control" type="text" name="testType" ng-model="entEdit.testType" required="required">
										<span style="color: Red" ng-show="editform.testType.$touched && editform.testType.$invalid">
										This field is required.</span>
										<br> <br>
									Order Number: <input class="form-control" type="number" name="orderNum" ng-model="entEdit.orderNum" required="required">
										<span style="color: Red" ng-show="editform.orderNum.$touched && editform.orderNum.$invalid">
										This field is required.</span>
										<br> <br>
									Category Code: <input class="form-control" type="text" name="categoryCd" ng-model="entEdit.categoryCd" required="required">
										<span style="color: Red" ng-show="editform.categoryCd.$touched && editform.categoryCd.$invalid">
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