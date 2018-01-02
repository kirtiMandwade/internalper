
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
<script src="/adminportal/resources/manageWorkstation.js"></script>


<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">
<!-- <script src="/adminportal/resources/css/style.css"></script> -->

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
						<li ><a href="../warehouse/profile">Profiles</a></li>
					<li ><a href="../warehouse/feature">Feature</a></li>
					<li ><a href="../warehouse/productfeature">Product Feature</a></li>
					<li class="active"><a href="../warehouse/workstation">Workstation</a></li>
									<li><a href="../logout" > Logout</a></li>


				</ul>
				<br>
			</div>

			<div class="col-sm-9">

				<div>
					<h1>Workstation</h1>
 <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal"  ng-click="addNewChoice();setDefaultValueForChoices()" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>
					<!--  data-target="#addModal" -->
				</div></br>


				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>WorkStationName</td>
						<td>Provisioned Date</td>
						<td>EndDate</td>
						<td>Active</td>
	<!-- 					<td>WSProfile Code</td>


						<td>WorkStationId</td>
						<td>Feature Code</td>
						<td>Feature Value</td> -->



						<td>Edit</td>
						<td>Delete</td>
					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.workStationName}}</td>
						<td>{{entity.provisionedDate|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<td>{{entity.endDate|date : "MM-dd-yyyy HH:mm:ss"}}</td>
						<td>{{entity.active}}</td>
<!-- 						<td>{{entity.wsProfile.wsProfileId.profileCd}}</td>
 -->

						<!-- <td>{{entity.workStationId}}</td> -->
					<!-- 	<td>{{entity.feature.featureCd}}</td>
						<td>{{entity.featureValue}}</td>
 -->

						<!-- <td ng-click="edit(grade)">edit</td>
			<td ng-click="delete(grade)">delete</td> -->
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#editmodal" ng-click="edit(entity);setDefaultValueForEditChoices()">edit</a></td>
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
										<h4 class="modal-title">Add Workstation</h4>
									</div>
									<div class="modal-body">

								Workstation Id: <input class="form-control" type="text"
											ng-model="ent.workStationId" name="workStationId" required>

<br> <br>


								WorkStationName: <input class="form-control" type="text"
											ng-model="ent.workStationName" name="gradeCode" required>
										<span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

								Provisioned	Date:<br>
										<datepicker style="width: 228px;"> <input
											ng-model="ent.provisionedDate" format="DD-MM-YYYY"
											type="text" /> </datepicker>
										<br> <br>

								End Date:<br>
										<datepicker style="width: 228px;"> <input
											ng-model="ent.endDate" format="DD-MM-YYYY" type="text" /> </datepicker>
										<br> <br>

								Active: <br><input type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="entActive"
											ng-model="ent.active" ng-checked="true"> <br>

								WSProfile:<br> <select class="form-control"
											ng-model="ent.wsProfile"
											ng-options="x.wsProfileId.profileCd for x in arrDevices"></select><br>


								<div data-ng-repeat="choice in choices" style="position: relative;">

									<!-- <div style="border: 2px ridge rgb(63, 138, 176);">
									<span1 id="span1" style="color:red ;display:none">
									<b>Please insert mno and prefix</b></span1> -->
								<table>
									<tr>
										<td>
										Feature Code: <select
											class="form-control" ng-model="choice.feature"
											ng-options="x.featureCd for x in arrFeatures" ng-change="getValue('add',choice,choice.id)" id="{{choice.id}}" ></select><br> <br>
										</td>
										 <td> Feature Value: <input id="addcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" > <br></td>
										<td>
										 <input id="choicevalue{{choice.id}}"  class="form-control" type="text"
											ng-model="choice.featureValue" name="choicevalue" required>  <!-- id="ent1.id" -->
										</td>
										<td>
										<select id="selct{{choice.id}}" class="form-control"
										ng-model="choice.featureValue" name="selct"
										ng-options="x for x in arrChoice{{choice.id}}" style="display:none"></select>
										</td>
										<td>
											<button ng-click="addNewChoice()"
											class="btn btn-info">
											<!-- style="position:relative;left:30%"> -->
											<span class="glyphicon glyphicon-plus-sign"
											style="vertical-align: middle"></span>
									<!-- 		Add More -->
											</button>
										</td>
										<!-- delete button -->
										<th><button type="button" ng-click="deleteNewChoice()" style=""
												class="btn btn-default" >-</button>
										</th>

									</tr>
								</table>
								</div>
								<!-- <div id="custom-error" style="color: red; display: none;">
									<b> Please Enter correct cell number</b>
								</div> -->


								</div>

								<br> <br>

								<div class="modal-footer">
								<!-- <button ng-click="addNewChoice()"
										class="btn btn-info">
										style="position:relative;left:30%">
										<span class="glyphicon glyphicon-plus-sign"
										style="vertical-align: middle"></span>
										Add More
										</button> -->

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
										<h4 class="modal-title">Edit Workstation</h4>
									</div>
									<div class="modal-body">
Workstation Id: <input class="form-control" type="text"
											ng-model="entEdit.workStationId" name="workStationId" required>

<br> <br>

						WorkStationName: <input class="form-control" type="text"
											ng-model="entEdit.workStationName" name="gradeCode" required>
										<span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

						Provisioned	Date:<br>
										<datepicker style="width: 228px;"> <input
											ng-model="entEdit.provisionedDate" format="DD-MM-YYYY"
											type="text" /> </datepicker>
										<br> <br>

						End Date:	<br><datepicker style="width: 228px;"> <input
											ng-model="entEdit.endDate" format="DD-MM-YYYY" type="text" /> </datepicker>
										<br> <br>

						Active:<br>	 <input type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="entEditActive"
											ng-model="entEdit.active" ng-checked="true">
							 <br> <br>

						WSProfile:<select class="form-control"
								ng-model="entEdit.wsProfile"
								ng-options="x.wsProfileId.profileCd for x in arrDevices"></select><br><br>



<div data-ng-repeat="w in entEdit.workStationFeatures" ng-init='arrlist=splitChoices(w.feature.choiceValues)'">
<table>

	<tr>
				<!-- <td>		Feature Code: <select class="form-control" ng-model="entEdit1.feature"
											ng-options="x.featureCd for x in arrFeatures"></select></td>
 -->


 <td>
          feature code <input class="form-control" type="text" name="color" ng-model="w.feature.featureCd" ng-disabled="buttonCode" required ng-init="buttonCode=true">
          <span
           style="color: Red"
           ng-show="addform.color.$touched && addform.color.$invalid">
           This field is required.</span> <br> <br>
          </td>


<td> Feature Value <input id="choicecheck{{w.workStationFeatureId.featureCd}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="w.featureValue"  style="display: none" > <br></td>
											<!-- ng-change="checkbox(w) -->
          <td>
										 <input id="choiceedit{{w.workStationFeatureId.featureCd}}"  class="form-control" type="text"
											ng-model="w.featureValue" name="choicevalue"  disabled="disabled" required>  <!-- id="ent1.id" -->
										</td>
										<td>
										<select id="selctedit{{w.workStationFeatureId.featureCd}}" class="form-control"
										ng-model="w.featureValue" name="selct"
										ng-options="x for x in arrChoice{{w.workStationFeatureId.featureCd}}" style="display:none"></select>
										</td>

				<!-- <td>		Feature Value: <input id="choicevalues" class="form-control" type="text" name="choicevalues"
											ng-model="entEdit1.featureValue" required>

									 <select id="selctedit" class="form-control" name="selctedit"
											ng-model="entEdit1.featureValue"
											ng-options="x for x in arrChoice" style="display:none"></select>
				</td>.
 -->

 <td>
          <!-- <div ng-switch="w.feature.valueType">
  <div ng-switch-when="BOOLEAN">

    Feature Value: <input type="checkbox" ng-true-value="'Y'" ng-false-value="'N'" name="charger" ng-model="w.featureValue" ng-disabled="button" required ng-init="button=true">
  </div>
  <div ng-switch-when="DATE">
     Feature Value:
										<datepicker style="width: 228px;"> <input class="form-control"
											ng-model="w.featureValue" format="DD-MM-YYYY"
											type="text" ng-disabled="button" required ng-init="button=true"/> </datepicker>


  </div>
  <div ng-switch-when="CHOICE">

     <select class="form-control"
										ng-model="w.featureValue" name="selct"
										ng-options="x for x in arrlist" ng-disabled="button" required ng-init="button=true"></select>

  </div>
  <div ng-switch-default>
     		Feature Value: <input class="form-control" type="text"
           ng-model="w.featureValue" ng-disabled="button" required ng-init="button=true" required>
  </div>
</div>
 -->


      </td>
      <td><button ng-click="getValue('edit',w,w.workStationFeatureId.featureCd)" class="btn btn-default">Edit</button>



 				<td>
											<button ng-click="addNewChoiceForEdit(w.workStationFeatureId.workStationId)"
											class="btn btn-info">+</button>
										</td>

										<th><button type="button" ng-click="deleteNewChoiceForEdit()" style=""
												class="btn btn-default" >-</button>
										</th>

	</tr>

</table>
</div>


<div data-ng-repeat="choice in choicesEdit" style="position: relative;">
<table>

	<tr>



				<td>		Feature Code: <select class="form-control" ng-model="choice.feature"
											ng-options="x.featureCd for x in arrFeatures"  ng-change="getValue('editadd',choice,choice.id)" ></select></td>


<td> Feature Value: <input id="editaddcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" > <br></td>

				<td>		 <input id="editadd{{choice.id}}" class="form-control" type="text" name="choicevalues"
											ng-model="choice.featureValue" >




<td>
		<select id="selcteditadd{{choice.id}}" class="form-control"
										ng-model="choice.featureValue" name="selct"
										ng-options="x for x in arrChoice{{choice.id}}" style="display:none"></select>
										</td>

				<td>

											<button ng-click="addNewChoiceForEdit(w.workStationFeatureId.workStationId)"
											class="btn btn-info">+</button>
										</td>

										<th><button type="button" ng-click="deleteNewChoiceForEdit()" style=""
												class="btn btn-default" >-</button>
										</th>

	</tr>

</table>
</div>
<!-- End -->
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
