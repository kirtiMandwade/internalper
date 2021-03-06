
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
<script src="/adminportal/resources/manageDiagIssueFlow.js"></script>
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
					<li  class="active"><a href="../care/diagissue">DiagIssuesFlow</a></li>
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
					<h1>DiagIssues</h1>

    <button   data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>
				</div>
				<br>

				<table class="table table-striped" border="1">
					<tr>
						<td>Issue Code</td>
						<td>Order Number</td>
						<td>Status</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.issueCd}}</td>

						<td>{{entity.orderNum}}</td>
						
						<!-- new -->
						  <td ng-if="entity.status == '1' ">Enabled</td>
						  <td ng-if="entity.status == '0' ">Disabled</td>
						
						<!-- end -->
						
						

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

									Issue Code:<input class="form-control" type="text" name="issueCd" ng-model="ent.issueCd" required="required">
										<span style="color: Red" ng-show="addform.issueCd.$touched && addform.issueCd.$invalid">
										This field is required.</span>
										<br> <br>
									Order Number:<input class="form-control" type="number" name="orderNum" ng-model="ent.orderNum" required="required">
										<span style="color: Red" ng-show="addform.orderNum.$touched && addform.orderNum.$invalid">
										This field is required.</span>
										<br> <br>
									Status:<input class="form-control" type="number" name="status" ng-model="ent.status" required="required">
										<span style="color: Red" ng-show="addform.status.$touched && addform.status.$invalid">
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
										<h4 class="modal-title">Edit</h4>
									</div>
									<div class="modal-body">

									Issue Code:<input class="form-control" type="text" name="issueCd" ng-model="ent.issueCd" required="required">
										<span style="color: Red" ng-show="editform.issueCd.$touched && editform.issueCd.$invalid">
										This field is required.</span>
										<br> <br>
									Order Number:<input class="form-control" type="number" name="orderNum" ng-model="ent.orderNum" required="required">
										<span style="color: Red" ng-show="editform.orderNum.$touched && editform.orderNum.$invalid">
										This field is required.</span>
										<br> <br>
									Status:<input class="form-control" type="number" name="status" ng-model="ent.status" required="required">
										<span style="color: Red" ng-show="editform.status.$touched && editform.status.$invalid">
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