<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="/adminportal/resources/manageProfiles.js"></script>
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
					<li class="active"><a href="../warehouse/profile">Profiles</a></li>
					<li><a href="../warehouse/feature">Feature</a></li>
					<li><a href="../warehouse/productfeature">Product Feature</a></li>
					<li><a href="../warehouse/workstation">Workstation</a></li>
					<!-- <li><a href="../warehouse/workStationfeature">Workstation Feature</a></li>
					<li><a href="../warehouse/profilefeature">Profile Feature</a></li>
					 -->					<li><a href="../logout" > Logout</a></li>

				</ul>
				<br>

			</div>

			<div class="col-sm-9">
				<div>
					<h1>Profile</h1>
					<button class="btn btn-info" ng-click="addNewChoice()" data-toggle="modal" data-target="#addModal" style="position:relative;left:90%">Add</button>
				</div></br>


				<!--   <div>
    <h3>Id : Name : Age : Web</h3></div>
 -->

 	<!-- <button
					class="btn btn-info" ng-click="search()">Search Device</button></br> -->
<!--  Model: <input class="form-control" type="text"
											ng-model="model" name="model"
											required> <span style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid"></span></br>
					 -->
				<table id="listOfDevices" class="table table-striped" border="1">
					<tr>
						<td>ProfileCd</td>
						<td>CompanyName</td>
						<td>ProfileDesc</td>
										<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="device in arrWSProfiles">
						<td>{{device.wsProfileId.profileCd}}</td>
						<td>{{device.wsProfileId.companyName}}</td>
						<td>{{device.profileDesc}}</td>

						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#myModal" ng-click="edit(device)">edit</a></td>
						<td><a style="cursor: pointer;" data-toggle="modal"
							data-target="#delModal" ng-click="delWSProfile(device)">delete</a></td>

						<!-- 			<td style="cursor: pointer;" ng-click="delete(device)">delete</td>
 -->

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
										<h4 class="modal-title">Add Profile</h4>
									</div>
									<div class="modal-body">


										Profile Code: <input class="form-control" type="text"
											ng-model="dev.wsProfileId.profileCd" name="make" ng-pattern="/^[A-z]+$/"
											required> <span style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">make
											cannot have alphanumeric characters</span> <br> <br>
										Company Name: <input class="form-control" type="text" name="model"
											ng-model="dev.wsProfileId.companyName" required="required"> <span
											style="color: Red"
											ng-show="addform.model.$touched && addform.model.$invalid">
											This field is required.</span> <br> <br> ProfileDesc: <input
											class="form-control" type="text" name="color"
											ng-model="dev.profileDesc" required="required"> <span
											style="color: Red"
											ng-show="addform.color.$touched && addform.color.$invalid">
											This field is required.</span> <br> <br>

<div data-ng-repeat="choice in choices" style="position: relative;">


									<!-- <div style="border: 2px ridge rgb(63, 138, 176);">
									<span1 id="span1" style="color:red ;display:none">
									<b>Please insert mno and prefix</b></span1> -->

								<table>
									<tr>
									<!-- <td>
										Feature Code:  <input   class="form-control" type="hidden"
											ng-model="choice.wsProfiles" value="{{dev}}" name="choicevalue" > <br> <br>
										</td> -->
										<td>
										Feature Code: <select
											class="form-control" ng-model="choice.feature"
											ng-options="x.featureCd for x in arrFeatures" ng-change="getValue('add',choice,$index)" id="{{choice.id}}" ></select><br> <br>
										</td>
										<td>
										Feature Value: <input id="choicevalue{{choice.id}}"  class="form-control" type="text"
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
				<div class="input-group input-group-lg">
     <form>


      <div class="modal fade" id="myModal" role="dialog">
       <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
         <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Device</h4>
         </div>
         <div class="modal-body">
            Profile Code: <input class="form-control" type="text"
           ng-model="devEdit.wsProfileId.profileCd" name="make" ng-pattern="/^[A-z]+$/"
           required> <span style="color: Red"
           ng-show="addform.make.$touched && addform.make.$invalid">
           This field is required.</span> <span style="color: Red"
           ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">make
           cannot have alphanumeric characters</span> <br> <br>
          Company Name: <input class="form-control" type="text" name="model"
           ng-model="devEdit.wsProfileId.companyName" required="required"> <span
           style="color: Red"
           ng-show="addform.model.$touched && addform.model.$invalid">
           This field is required.</span> <br> <br> ProfileDesc: <input
           class="form-control" type="text" name="color"
           ng-model="devEdit.profileDesc" required="required"> <span
           style="color: Red"
           ng-show="addform.color.$touched && addform.color.$invalid">
           This field is required.</span> <br> <br>

<div data-ng-repeat="w in devEdit.profileFeatures" ng-init='arrlist=splitChoices(w.feature.choiceValues)'">
<table>

	<tr>
				<!-- <td>		Feature Code: <select class="form-control" ng-model="devEdit1.feature"
											ng-options="x.featureCd for x in arrFeatures"></select></td>
 -->
 <td>
          feature code <input class="form-control" type="text" name="color" ng-model="w.feature.featureCd" ng-disabled="buttonCode" required ng-init="buttonCode=true">
          <span
           style="color: Red"
           ng-show="addform.color.$touched && addform.color.$invalid">
           This field is required.</span> <br> <br>
          </td>

          <td>
										Feature Value: <input id="choiceedit{{w.profileFeatureId.featureCd}}"  class="form-control" type="text"
											ng-model="w.featureValue" name="choicevalue"  disabled="disabled" required>  <!-- id="ent1.id" -->
										</td>
										<td>
										<select id="selctedit{{w.profileFeatureId.featureCd}}" class="form-control"
										ng-model="w.featureValue" name="selct"
										ng-options="x for x in arrChoicechoice{{w.profileFeatureId.featureCd}}" style="display:none"></select>
										</td>

				<!-- <td>		Feature Value: <input id="choicevalues" class="form-control" type="text" name="choicevalues"
											ng-model="devEdit1.featureValue" required>

									 <select id="selctedit" class="form-control" name="selctedit"
											ng-model="devEdit1.featureValue"
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
      <td><button ng-click="getValue('edit',w,w.profileFeatureId.featureCd)" class="btn btn-default">Edit</button>



 				<td>
											<button ng-click="addNewChoiceForEdit(w.profileFeatureId.workStationId)"
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

				<td>		Feature Value: <input id="editadd{{choice.id}}" class="form-control" type="text" name="choicevalues"
											ng-model="choice.featureValue" >




<td>
		<select id="selcteditadd{{choice.id}}" class="form-control"
										ng-model="choice.featureValue" name="selct"
										ng-options="x for x in arrChoicechoice{{choice.id}}" style="display:none"></select>
										</td>

				<td>

											<button ng-click="addNewChoiceForEdit(w.profileFeatureId.wsProfileId)"
											class="btn btn-info">+</button>
										</td>

										<th><button type="button" ng-click="deleteNewChoiceForEdit()" style=""
												class="btn btn-default" >-</button>
										</th>

	</tr>

</table>
</div></div>
         </div>
         <div class="modal-footer">
          <button class="btn btn-default" data-dismiss="modal"
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
	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
