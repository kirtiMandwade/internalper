
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
<script src="/adminportal/resources/manageFeature.js"></script>
<script src="/adminportal/resources/css/style.css"></script>

<link rel="stylesheet"
	href="/adminportal/resources/css/search-bar-style.css">

</head>

<body ng-app="AdminPortal" ng-controller="empCtrl">


	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav">
				<h4>Menu</h4>
				<ul class="nav nav-pills nav-stacked">
				<li ><a href="../warehouse/profile">Profiles</a></li>
					<li class="active"><a href="../warehouse/feature">Feature</a></li>
					<li><a href="../warehouse/productfeature">Product Feature</a></li>
					<li><a href="../warehouse/workstation">Workstation</a></li>
											<li><a href="../logout" > Logout</a></li>


				</ul>
				<br>
			</div>

	<!-- 		<div class="col-sm-9">

				<div>
					<h1>Features</h1>
 <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>				</div></br>

 -->				
				
				<div class="col-xs-6 col-md-4">
				<div>
					<h1>Features</h1>
  	  <!--   <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="FeatureCd" id="txtSearch" ng-model="featureCd" style="height:27px"/>
  		 <div class="input-group-btn">
  		      <button class="btn btn-primary" ng-click="search()" >
   		     <span class="glyphicon glyphicon-search" ></span>
    	    </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal">
     	   <span class="glyphicon glyphicon-plus"></span>
        </button>

</div>
</div> -->
<div class="topnav">
	
         
	
		<input type="text" placeholder="FeatureCd" id="txtSearch" ng-model="featureCd" >
		<button ng-click="search()"><span class="glyphicon glyphicon-search" ></span></button>
		
	
	   
    <button data-toggle="modal" data-target="#addModal">
        <span class="glyphicon glyphicon-plus" ></span>
        </button>
      
		
		
	
</div>
</div>
<br>
				
				
				
				
				<table id="listOfFeatures" class="table table-striped" border="1">
					<tr>
						<td>Feature Cd</td>
						<td>Feature Desc</td>
						<td>Value Type</td>
						<td>Choice Values</td>
						<td>Default Value</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.featureCd}}</td>
						<td>{{entity.featureDesc}}</td>
						<td>{{entity.valueType}}</td>
						<td>{{entity.choiceValues}}</td>
						<td>{{entity.defaultValue}}</td>

						<!-- <td ng-click="edit(grade)">edit</td>
			<td ng-click="delete(grade)">delete</td> -->
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



									Feature Code: <input class="form-control" type="text"
											ng-model="ent.featureCd" name="gradeCode"
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

									Feature	Description<input class="form-control" type="text"
											name="model" ng-model="ent.featureDesc" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDesc.$touched && addform.gradeDesc.$invalid">
											This field is required.</span> <br> <br>

									Value Type: <select class="form-control"
											ng-model="ent.valueType"
											ng-options="x for x in valueType" ng-change="change('add')"></select><br> <br>

									<div id="choicevalue" style="display:none" >

									Choice Values: <input  class="form-control" type="text" name="color"
											ng-model="ent.choiceValues"  >

									</div>
										<br>

									Default Value:
										<input class="form-control" type="text" name="deductionValue"
											ng-model="ent.defaultValue"
											required="required">
										<span style="color: Red"
											ng-show="addform.deductionValue.$touched && addform.deductionValue.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.deductionValue.$dirty&&addform.deductionValue.$error.pattern">deduction
											value must have decimal numbers</span> <br> <br>

										<br> 										<!-- <select ng-model="empl.department">
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

						Feature Code: <input class="form-control" type="text"
											ng-model="ent.featureCd" name="gradeCode"
											required> <span style="color: Red"
											ng-show="addform.gradeCode.$touched && addform.gradeCode.$invalid">
											Grade Code length exceeded</span> <br> <br>

						Feature	Description<input class="form-control" type="text"
											name="model" ng-model="ent.featureDesc" required="required">
										<span style="color: Red"
											ng-show="addform.gradeDesc.$touched && addform.gradeDesc.$invalid">
											This field is required.</span> <br> <br>

						Value Type: <select class="form-control"
											ng-model="ent.valueType"
											ng-options="x for x in valueType"  ng-change="change('edit')"></select><br> <br>
												 <div id="choicevalues" style="display:none" >

						Choice Values: <input  class="form-control" type="text" name="color"
											ng-model="ent.choiceValues"  ></div> <br>

						Default Value:
										<input class="form-control" type="text" name="deductionValue"
											ng-model="ent.defaultValue"
											required="required">
										<span style="color: Red"
											ng-show="addform.deductionValue.$touched && addform.deductionValue.$invalid">
											This field is required.</span> <span style="color: Red"
											ng-show="addform.deductionValue.$dirty&&addform.deductionValue.$error.pattern">deduction
											value must have decimal numbers</span> <br> <br>


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