
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
<script src="/adminportal/resources/manageGrade.js"></script>
<script src="/adminportal/resources/css/style.css"></script>

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
								<ul class="nav nav-pills nav-stacked">

								<li><a href="../tradein/device">Device</a></li>
					<li class="active"><a href="../tradein/grade">Grade</a></li>
					<li><a href="../tradein/deviceprice">Device
							Price</a></li>
					<li  ><a href="../tradein/promotion">Promotions</a></li>
					<li><a href="../logout" > Logout</a></li>


				</ul>
				<br>
			</div>

			<div class="col-xs-6 col-md-4">

				<div>
					<h1>Grades</h1>	<!-- <button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button> -->
      <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="GradeCode" id="txtSearch" ng-model="gradeCode" style="height:27px"/>
   <div class="input-group-btn">
        <button class="btn btn-primary" ng-click="search()" >
        <span class="glyphicon glyphicon-search" ></span>
        </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="add()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


   </div></div>
				</div><br>

				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>GradeCode</td>
						<td>GradeDesc</td>
						<td>GradeDisplayName</td>
						<td>Deduction Value</td>
						<td>Deduction Type</td>
						<td>Active</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="grade in arrGrades">
						<td>{{grade.gradeCode}}</td>
						<td>{{grade.gradeDesc}}</td>
						<td>{{grade.gradeDisplayName}}</td>
						<td>{{grade.deductionValue}}</td>
						<td>{{grade.deductionType}}</td>
						<td>{{grade.active}}</td>

						<!-- <td ng-click="edit(grade)">edit</td>
			<td ng-click="delete(grade)">delete</td> -->
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#editmodal" ng-click="edit(grade)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(grade)">delete</a></td>


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



										Grade Code: <input class="form-control" type="text"
											ng-model="grd.gradeCode" name="gradeCode" ng-maxlength="2"
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>Grade
										Description<input class="form-control" type="text"
											name="model" ng-model="grd.gradeDesc" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDesc.$touched && addform.gradeDesc.$invalid">
											This field is required.</span> <br> <br> Grade Display
										Name: <input class="form-control" type="text" name="color"
											ng-model="grd.gradeDisplayName" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDisplayName.$touched && addform.gradeDisplayName.$invalid">
											This field is required.</span> <br> <br> Deduction Value:
										<input class="form-control" type="text" name="deductionValue"
											ng-model="grd.deductionValue"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" required="required">
										<span style="color: Red"
											ng-show="addform.deductionValue.$touched && addform.deductionValue.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.deductionValue.$dirty&&addform.deductionValue.$error.pattern">deduction
											value must have decimal numbers</span> <br> <br> Deduction
										Type: <select class="form-control"
											ng-model="grd.deductionType"
											ng-options="x for x in deductionType"></select><br> <br>


										<br> Active: <input type="checkbox" ng-true-value="Y"
											ng-false-value="N" name="active" ng-model="grd.active"
											ng-checked="true"></br>


										<!-- <select ng-model="empl.department">
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


										<br>Grade Description<input class="form-control"
											type="text" name="gradeDesc" ng-model="grdEdit.gradeDesc"
											required="required"> <span style="color: Red"
											ng-show="editform.gradeDesc.$invalid"> This field is
											required.</span> <br> <br> Grade Display Name: <input
											class="form-control" type="text" name="gradeDisplayName"
											ng-model="grdEdit.gradeDisplayName" required="required">
										<span style="color: Red"
											ng-show="editform.gradeDisplayName.$touched && editform.gradeDisplayName.$invalid">
											This field is required.</span> <br> <br> Deduction Value:
										<input class="form-control" type="text" name="deductionValue"
											ng-model="grdEdit.deductionValue"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" required="required">
										<span style="color: Red"
											ng-show="editform.deductionValue.$touched && editform.deductionValue.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="editform.deductionValue.$dirty&&editform.deductionValue.$error.pattern">deduction
											value must have decimal numbers</span><br> <br> Deduction
										Type: <select class="form-control"
											ng-model="grdEdit.deductionType"
											ng-options="x for x in deductionType"></select><br> <br>

										<br> Active: <input type="checkbox" ng-true-value="'Y'"
											ng-false-value="'N'" name="active" ng-model="grdEdit.active"
											ng-checked="true"></br>

										<!-- <select ng-model="empl.department">
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