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
					 -->
					<li><a href="../logout"> Logout</a></li>

				</ul>
				<br>

			</div>

			<!-- <div class="col-sm-9">
				<div>
					<h1>Profile</h1>
					 <button class="btn btn-primary"  data-toggle="modal"   ng-click="addNewChoice();setDefaultValueForChoices()" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>

				</div>
				</br> -->


				<div class="col-xs-6 col-md-4">

				<div>
					<h1>Profile</h1>
  	    <div class="input-group" style="position:relation;left:50%">
<!--
				<input type="text" class="form-control" placeholder="ProfileCd" id="txtSearch" ng-model="profileCd" style="height:27px"/>
  		 <div class="input-group-btn">
  		      <button class="btn btn-primary" ng-click="search()" >
   		     <span class="glyphicon glyphicon-search" ></span>
    	    </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()">
     	   <span class="glyphicon glyphicon-plus"></span>
        </button>
         -->

        	<input type="text" class="form-control" placeholder="ProfileCd" id="txtSearch" ng-model="profileCd" style="height:27px;width:70%"/>
   <div class="input-group-btn" >
        <button class="btn btn-primary" ng-click="search()" style="position: relative; left:-106px">
        <span class="glyphicon glyphicon-search" ></span>
        </button>
             <button class="btn btn-primary"  data-toggle="modal" data-target="#duplicateModal" style="position: relative; left:-100px;height:30px">
        <span >Duplicate</span>
</button>
    <button style="position: relative; left:-95px" class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()" style="position: relative; left: 90%" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


</div>
</div>
</div>
<br>








				<table id="listOfProfiles" class="table table-striped" border="1">
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
							data-target="#myModal" ng-click="edit(device);setDefaultValueForEditChoices()">edit</a></td>
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
										<h4 class="modal-title">Add Profile</h4>
									</div>
									<div class="modal-body">


										Profile Code: <input class="form-control" type="text"
											ng-model="dev.wsProfileId.profileCd" name="make"
											 required> <br> <br>
										Company Name: <input class="form-control" type="text"
											name="model" ng-model="dev.wsProfileId.companyName"
											required="required"> <span style="color: Red"
											ng-show="addform.model.$touched && addform.model.$invalid">
											This field is required.</span> <br> <br> ProfileDesc: <input
											class="form-control" type="text" name="color"
											ng-model="dev.profileDesc" required="required"> <span
											style="color: Red"
											ng-show="addform.color.$touched && addform.color.$invalid">
											This field is required.</span> <br> <br><br>

										<div data-ng-repeat="choice in choices"
											style="position: relative;">


											<!-- <div style="border: 2px ridge rgb(63, 138, 176);">
									<span1 id="span1" style="color:red ;display:none">
									<b>Please insert mno and prefix</b></span1> -->

											<table>
												<tr>

												  <div class="row">
    <div class="col-sm-4" style="background-color:lavender;"> Feature Code<select class="form-control"
														ng-model="choice.feature"
														ng-options="x.featureCd for x in arrFeatures"
														ng-change="getValue('add',choice,choice.id)"
														id="{{choice.id}}"></select>
        </div>
    <div class="col-sm-4" style="background-color:lavenderblush;">Feature Value <input id="addcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" >
													 <input
														id="choicevalue{{choice.id}}" class="form-control"
														type="text" ng-model="choice.featureValue"
														name="choicevalue" required> <!-- id="ent1.id" -->
												<select id="selct{{choice.id}}"
														class="form-control" ng-model="choice.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{choice.id}}"
														style="display: none"></select>

          </div>
    <div class="col-sm-4" style="background-color:lavender;">Action Value <br>




											<button ng-click="addNewChoice()"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>


										<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button></div>
  </div>

<!-- 													<td>
										Feature Code:  <input   class="form-control" type="hidden"
											ng-model="choice.wsProfiles" value="{{dev}}" name="choicevalue" > <br> <br>
										</td>

											<td class="columnSizefornew">Feature Code</td>		<td class="columnSizefornew"><select class="form-control"
														ng-model="choice.feature"
														ng-options="x.featureCd for x in arrFeatures"
														ng-change="getValue('add',choice,choice.id)"
														id="{{choice.id}}"></select><br> <br>
													</td>
														<td class="columnSizefornewcss"></td>
	<td class="columnSizefornew">Feature Value</td>
<td class="columnSizefornew">  <input id="addcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" >
													 <input
														id="choicevalue{{choice.id}}" class="form-control"
														type="text" ng-model="choice.featureValue"
														name="choicevalue" required> id="ent1.id"
												<select id="selct{{choice.id}}"
														class="form-control" ng-model="choice.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{choice.id}}"
														style="display: none"></select></td>
														<td class="columnSizefornewcss"></td>
													<td class="columnSizefornew">
														<button ng-click="addNewChoice()" class="btn btn-info">
															style="position:relative;left:30%">
															<span class="glyphicon glyphicon-plus-sign"
																style="vertical-align: middle"></span>
																	Add More
														</button>
													<button type="button" ng-click="deleteNewChoice()"
															style="" class="btn btn-default">-</button></td>
 -->
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
										<h4 class="modal-title">Edit</h4>
									</div>
									<div class="modal-body">
										Profile Code: <input class="form-control" type="text"
											ng-model="devEdit.wsProfileId.profileCd" name="make"
											ng-pattern="/^[A-z]+$/" required> <span
											style="color: Red"
											ng-show="addform.make.$touched && addform.make.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.firstname.$dirty&&addform.firstname.$error.pattern">make
											cannot have alphanumeric characters</span> <br> <br>
										Company Name: <input class="form-control" type="text"
											name="model" ng-model="devEdit.wsProfileId.companyName"
											required="required"> <span style="color: Red"
											ng-show="addform.model.$touched && addform.model.$invalid">
											This field is required.</span> <br> <br> ProfileDesc: <input
											class="form-control" type="text" name="color"
											ng-model="devEdit.profileDesc" required="required"> <span
											style="color: Red"
											ng-show="addform.color.$touched && addform.color.$invalid">
											This field is required.</span> <br> <br>

										<div data-ng-repeat="w in devEdit.profileFeatures"
											ng-init='arrlist=splitChoices(w.feature.choiceValues)'">
											<table>

												<tr>

												  <div class="row">
    <div class="col-sm-4" style="background-color:lavender;"> Feature Code<input class="form-control"
														type="text" name="color" ng-model="w.feature.featureCd"
														ng-disabled="buttonCode" required
														ng-init="buttonCode=true">
        </div>
    <div class="col-sm-4" style="background-color:lavenderblush;">Feature Value  <input id="choicecheck{{w.profileFeatureId.featureCd}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="w.featureValue"  style="display: none" >
											<!-- ng-change="checkbox(w) -->
													<input
														id="choiceedit{{w.profileFeatureId.featureCd}}"
														class="form-control" type="text"  ng-model="w.featureValue"
		 												name="choicevalue" disabled="disabled"
														> <!-- id="ent1.id" -->
													<select
														id="selctedit{{w.profileFeatureId.featureCd}}"
														class="form-control" ng-model="w.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{w.profileFeatureId.featureCd}}"
														style="display: none"></select>
          </div>
    <div class="col-sm-4" style="background-color:lavender;">Action Value <br>


<button ng-click="getValue('edit',w,w.profileFeatureId.featureCd)"   class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></button>

											<button ng-click="addNewChoiceForEdit(w.profileFeatureId.wsProfileId)"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>


										<button type="button" ng-click="deleteNewChoiceForEdit()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button></div>
  </div>

<!-- <!-- 													<td>		Feature Code: <select class="form-control" ng-model="devEdit1.feature"
											ng-options="x.featureCd for x in arrFeatures"></select></td>

													<td class="columnSizefornew">Feature Code</td>		<td class="columnSizefornew"> <input class="form-control"
														type="text" name="color" ng-model="w.feature.featureCd"
														ng-disabled="buttonCode" required
														ng-init="buttonCode=true"> <span
														style="color: Red"
														ng-show="addform.color.$touched && addform.color.$invalid">
															This field is required.</span> <br> <br>
													</td>


														<td class="columnSizefornewcss"></td>

<td class="columnSizefornew">Feature Value</td>		<td class="columnSizefornew"> <input id="choicecheck{{w.profileFeatureId.featureCd}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="w.featureValue"  style="display: none" >
											ng-change="checkbox(w)
													<input
														id="choiceedit{{w.profileFeatureId.featureCd}}"
														class="form-control" type="text"  ng-model="w.featureValue"
		 												name="choicevalue" disabled="disabled"
														> id="ent1.id"
													<select
														id="selctedit{{w.profileFeatureId.featureCd}}"
														class="form-control" ng-model="w.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{w.profileFeatureId.featureCd}}"
														style="display: none"></select></td>


																											<td class="columnSizefornewcss"></td>

													 	<td class="columnSizefornew"><button
															ng-click="getValue('edit',w,w.profileFeatureId.featureCd)"
															class="btn btn-default">Edit</button>

														<button
															ng-click="addNewChoiceForEdit(w.profileFeatureId.workStationId)"
															class="btn btn-info">+</button>
													</td>

													<th><button type="button"
															ng-click="deleteNewChoiceForEdit()" style=""
															class="btn btn-default">-</button></th>
 -->
												</tr>

											</table>
										</div>



										<div data-ng-repeat="choice in choicesEdit"
											style="position: relative;">

											<table>

												<tr>
													<!-- <td class="columnSizefornew">Feature Code</td>		<td class="columnSizefornew">  <select class="form-control"
														ng-model="choice.feature"
														ng-options="x.featureCd for x in arrFeatures"
														ng-change="getValue('editadd',choice,choice.id)"></select></td>
														<td class="columnSizefornewcss"></td>


<td class="columnSizefornew">Feature Value</td>		<td class="columnSizefornew"> <input id="editaddcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" >
													 <input id="editadd{{choice.id}}"
														class="form-control" type="text" name="choicevalues"
														ng-model="choice.featureValue">
													<select id="selcteditadd{{choice.id}}"
														class="form-control" ng-model="choice.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{choice.id}}"
														style="display: none"></select></td>
														<td class="columnSizefornewcss"></td>

													<td class="columnSizefornewcss"></td>
														<td class="columnSizefornew">

														<button
															ng-click="addNewChoiceForEdit(w.profileFeatureId.wsProfileId)"
															class="btn btn-info">+</button>
												<button type="button"
															ng-click="deleteNewChoiceForEdit()" style=""
															class="btn btn-default">-</button></td>
 -->  <div class="row">
    <div class="col-sm-4" style="background-color:lavender;"> Feature Code <select class="form-control"
														ng-model="choice.feature"
														ng-options="x.featureCd for x in arrFeatures"
														ng-change="getValue('editadd',choice,choice.id)"></select>
        </div>
    <div class="col-sm-4" style="background-color:lavenderblush;">Feature Value <input id="editaddcheck{{choice.id}}" type="checkbox"
											ng-true-value="'Y'" ng-false-value="'N'" name="check"
											ng-model="choice.featureValue"  style="display: none" >
													 <input id="editadd{{choice.id}}"
														class="form-control" type="text" name="choicevalues"
														ng-model="choice.featureValue">
													<select id="selcteditadd{{choice.id}}"
														class="form-control" ng-model="choice.featureValue"
														name="selct"
														ng-options="x for x in arrChoicechoice{{choice.id}}"
														style="display: none"></select>
          </div>
    <div class="col-sm-4" style="background-color:lavender;">Action Value <br>



											<button ng-click="addNewChoiceForEdit(w.profileFeatureId.wsProfileId)"  class="btn btn-info"
											><span class="glyphicon glyphicon-plus"></span></button>


										<button type="button" ng-click="deleteNewChoiceForEdit()" class="btn btn-info"
												 ><span class="glyphicon glyphicon-minus"></span></button></div>
  </div>

												</tr>

											</table>
										</div>
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
				</div>
				</form>
			</div>
		</div>
	</div>
	</div>
	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>

</body>
</html>
