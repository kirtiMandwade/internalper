
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
<script src="/adminportal/resources/manageDiagTestCompanyMap.js"></script>
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
					<li class="active"><a href="../care/diagtestcompany">DiagTestCompany</a></li>
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
					<h1>DiagTestCompanyMap</h1>
    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>				</div>
				<br>

				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>Company Id</td>

						<td>Product Code</td>
						<td>Severity Code</td>
						<td>Diag Issues Flow</td>
						<td>Diag Test</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.companyId}}</td>

						<td>{{entity.productCd}}</td>
						<td>{{entity.severityCd}}</td>
						<td>{{entity.diagIissuesFlow.issueCd}}</td>
						<td>{{entity.diagTest.testCd}}</td>

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


										Company Id:<input class="form-control" type="number" name="companyId"
											ng-model="ent.companyId" required="required"> <span
											style="color: Red"
											ng-show="addform.companyId.$touched && addform.companyId.$invalid">
											This field is required.</span> <br> <br>
										Product Code:<input
											class="form-control" type="text" name="productCd"
											ng-model="ent.productCd" required="required"> <span
											style="color: Red"
											ng-show="addform.productCd.$touched && addform.productCd.$invalid">
											This field is required.</span> <br> <br>
										Serverity Code: <input
											class="form-control" type="text" name="severityCd"
											ng-model="ent.severityCd" required="required"> <span
											style="color: Red"
											ng-show="addform.severityCd.$touched && addform.severityCd.$invalid">
											This field is required.</span> <br> <br>

										Diag Issues Flow: <select
											class="form-control" ng-model="ent.diagIissuesFlow"
											ng-options="x.issueCd for x in arrdiagIissuesFlow"></select><br>

										Diag Test: <select class="form-control" ng-model="ent.diagTest"
											ng-options="x.testCd for x in arrDiagTest"></select>
											<br><br>

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
										companyId:<input class="form-control" type="number" name="companyId"
											ng-model="entEdit.companyId" required="required" di>
											<span style="color: Red"
											ng-show="editform.companyId.$touched && editform.companyId.$invalid">
											This field is required.</span> <br> <br>
										Product Cd:<input
											class="form-control" type="text" name="productCd"
											ng-model="entEdit.productCd" required="required"> <span
											style="color: Red"
											ng-show="editform.productCd.$touched && editform.productCd.$invalid">
											This field is required.</span> <br> <br>
										Severity Cd: <input
											class="form-control" type="text" name="severityCd"
											ng-model="entEdit.severityCd" required="required"> <span
											style="color: Red"
											ng-show="editform.severityCd.$touched && editform.severityCd.$invalid">
											This field is required.</span> <br>
											<br> <br>
										diagIissuesFlow: <select
											class="form-control" ng-model="entEdit.diagIissuesFlow"
											ng-options="x.issueCd for x in arrdiagIissuesFlow"></select><br>
										diagTest: <select class="form-control"
											ng-model="entEdit.diagTest"
											ng-options="x.testCd for x in arrDiagTest"></select>
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
</body>
</html>