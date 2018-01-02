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
<script src="/adminportal/resources/ManagePromotions.js"></script>
<script src="/adminportal/resources/css/style.css"></script>
<link href="/adminportal/resources/css/angular-datepicker.css"
	rel="stylesheet" type="text/css" />
<script src="/adminportal/resources/js/angular-datepicker.js"></script>


</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">



	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
				<li><a href="../tradein/device">Device</a></li>
					<li><a href="../tradein/grade">Grade</a></li>
					<li><a href="../tradein/deviceprice">Device
							Price</a></li>
					<li  class="active"><a href="../tradein/promotion">Promotions</a></li>
					<li><a href="../logout" > Logout</a></li>


				</ul>
				<br>

			</div>

				<div class="col-xs-6 col-md-4">

				<div>
					<h1>Promotions</h1>	<!-- <button class="btn btn-info" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button> -->
      <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="PromoCode" id="txtSearch" ng-model="PromoCode" style="height:27px"/>
   <div class="input-group-btn">
        <button class="btn btn-primary" ng-click="search()" >
        <span class="glyphicon glyphicon-search" ></span>
        </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


   </div></div>
				</div>
				</br>

				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->
<!--
				<button class="btn btn-info" ng-click="search()">Search
					Promotions</button>
				</br> PromoCode: <input class="form-control" type="text"
					ng-model="PromoCode" name="model" required> <span
					style="color: Red"
					ng-show="addform.make.$touched && addform.make.$invalid"></span></br>
 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>PromoCode</td>
						<td>PromoDesc</td>
						<td>PromoPriority</td>
						<td>DeviceSpecific</td>
						<td>GradeSpecific</td>
						<td>DeductionType</td>
						<td>Value</td>
						<td>Company Name</td>
						<td>Start Date</td>
						<td>End Date</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="promo in arrPromotion">
						<td>{{promo.promotionKey.promoCode}}</td>
						<td>{{promo.promoDesc}}</td>
						<td>{{promo.promoPriority}}</td>
						<td>{{promo.deviceSpecific}}</td>
						<td>{{promo.gradeSpecific}}</td>
						<td>{{promo.deductionType}}</td>
						<td>{{promo.value}}</td>
						<td>{{promo.promotionKey.companyName}}</td>
						<td>{{promo.startDateTime|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<td>{{promo.endDateTime|date:"MM-dd-yyyy HH:mm:ss"}}</td>

						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#myModal" ng-click="edit(promo)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delDevice(promo)">delete</a></td>




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
										<h4 class="modal-title">Add Promotion</h4>
									</div>
									<div class="modal-body">

										promo Code: <input class="form-control" type="text"
											ng-model="dev.promotionKey.promoCode" name="promoCode" ng-maxlength="30"
											required> <span style="color: Red"
											ng-show="addform.promoCode.$touched && addform.promoCode.$invalid">

											This field is required cannot have more then 30 chars</span> <br>
										promoDesc: <input class="form-control" type="text"
											ng-model="dev.promoDesc" name="promoDesc" required> <span
											style="color: Red"
											ng-show="addform.promoDesc.$touched && addform.promoDesc.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">promoDesc
											cannot have alphanumeric characters</span> <br> <br>
										promoPriority: <input class="form-control" type="text"
											name="promoPriority" ng-model="dev.promoPriority"
											required="required"> <span style="color: Red"
											ng-show="addform.promoPriority.$touched && addform.promoPriority.$invalid">
											This field is required.</span> <br> <br> Device Specific:
										<input type="checkbox" ng-true-value="'Y'"
											ng-false-value="'N'" name="gradeSpec"
											ng-model="dev.deviceSpecific" ng-checked="true"> <br>
										<br> Grade Specific: <input type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="devSpec"
											ng-model="dev.gradeSpecific" ng-checked="true"> <br>
										<br> value: <input class="form-control" type="text"
											name=" valu" ng-model="dev.value"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/" required="required">
										<span style="color: Red"
											ng-show="addform.valu.$touched && addform.valu.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.valu.$dirty&&addform.valu.$error.pattern">value
											must have decimal numbers</span> <br> <br> Deduction Type:
										<select class="form-control" ng-model="dev.deductionType"
											ng-options="x for x in deductionType"></select><br> <br>

										Company Name: <input class="form-control" type="text"
											ng-model="dev.promotionKey.companyName" name="companyName" required>
										<span style="color: Red"
											ng-show="addform.companyName.$touched && addform.companyName.$invalid">
											This field is required.</span> <br> Start Date:</br>
										<datepicker style="width: 228px;"> <input
											ng-model="dev.startDateTime" format="DD-MM-YYYY" type="text" />
										</datepicker>
										<br> <br> End Date:</br>
										<datepicker format="DD-MM-YYYY" style="width: 228px;">
										<input ng-model="dev.endDateTime" type="text" /> </datepicker>

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

						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit Device</h4>
									</div>
									<div class="modal-body">
										promo Code: <input class="form-control" type="text"
											ng-model="devEdit.promotionKey.promoCode" name="promoCode"
											ng-maxlength="30" required disabled="isDisabled"> <span
											style="color: Red"
											ng-show="editform.promoCode.$touched && editform.promoCode.$invalid">
											This field is required and cannot have more then 30chars.</span><br>
										Company Name: <input class="form-control" type="text"
											ng-model="devEdit.promotionKey.companyName" name="companyName" required
											disabled="isDisabled"> <span style="color: Red"
											ng-show="editform.companyName.$touched && editform.companyName.$invalid">
											This field is required.</span> <br> <br> promoDesc: <input
											class="form-control" type="text" ng-model="devEdit.promoDesc"
											name="promoDesc" required> <span style="color: Red"
											ng-show="editform.promoDesc.$touched && editform.promoDesc.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="editform.firstname.$dirty&&editform.firstname.$error.pattern">promoDesc
											cannot have alphanumeric characters</span> <br> <br>
										promoPriority: <input class="form-control" type="text"
											name="promoPriority" ng-model="devEdit.promoPriority"
											required="required"> <span style="color: Red"
											ng-show="editform.promoPriority.$touched && editform.promoPriority.$invalid">
											This field is required.</span> <br> <br>Device Specific: <input
											type="checkbox" ng-true-value="'Y'" ng-false-value="'N'"
											name="gradeSpec" ng-model="devEdit.deviceSpecific"
											ng-checked="true"><br> <br> Grade Specific:
										<input type="checkbox" ng-true-value="'Y'"
											ng-false-value="'N'" name="devSpec"
											ng-model="devEdit.gradeSpecific" ng-checked="true"> <br>
										<br> value: <input class="form-control" type="text"
											name=" valu" ng-model="devEdit.value" required="required"
											ng-pattern="/^[0-9]+(\.[0-9]{1,2})?$/"> <span
											style="color: Red"
											ng-show="editform.valu.$touched && editform.valu.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="editform.valu.$dirty&&editform.valu.$error.pattern">value
											must have decimal numbers</span><br> <br> Deduction Type:
										<select class="form-control" ng-model="devEdit.deductionType"
											ng-options="x for x in deductionType"></select><br> <br>

										Start Date:</br>
										<datepicker style="width: 228px;"> <input
											ng-model="devEdit.startDateTime" type="text" /> </datepicker>
										</br> <br> End Date:</br>
										<datepicker style="width: 228px;"> <input
											ng-model="devEdit.endDateTime" type="text" /> </datepicker>

										<br> <br>


										<div class="modal-footer">
											<button class="btn btn-default" data-dismiss="modal"
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
				`
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>

