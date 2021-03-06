
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
<script src="/adminportal/resources/manageEDeviceTradeInPrice.js"></script>
<link rel="stylesheet"
	href="/adminportal/resources/css/style.css">
<link rel="stylesheet"
	href="/adminportal/resources/css/search-bar-style.css">

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
					<li><a href="../care/diagtestcompany">DiagTestCompany</a></li>
					<li><a href="../care/model">Model</a></li>
					<li><a href="../care/company">Company</a></li>
					<li><a href="../care/manufacturer">Manufacturer</a></li>
					<li><a href="../care/deviceattribute">DeviceAttribute</a></li>
					<li class="active"><a href="../care/devicebaseprice">DeviceTradeInBasePrice</a></li>
					<li><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
				<br>
			</div>
			
			
			<div class="col-xs-6 col-md-4">
				<div>
					<h1>DeviceTradeInBasePrice</h1>
<!--   	    <div class="input-group" style="position:relation;left:50%">

				<input type="text" class="form-control" placeholder="CompanyName" id="txtSearch" ng-model="companyName" style="height:27px"/>
  		 <div class="input-group-btn">
  		      <button class="btn btn-primary" ng-click="search()" >
   		     <span class="glyphicon glyphicon-search" ></span>
    	    </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()" >
     	   <span class="glyphicon glyphicon-plus"></span>
        </button>
        

        	<input type="text" class="form-control" placeholder="Company Name" id="txtSearch" ng-model="company" style="height:27px;width:70%"/>
   <div class="input-group-btn" >
        <button class="btn btn-primary" ng-click="search()" style="position: relative; left:-105px">
        <span class="glyphicon glyphicon-search" ></span>
        </button>
             <button class="btn btn-primary"  data-toggle="modal" data-target="#duplicateModal" style="position: relative; left:-100px;height:30px">
        <span >Duplicate</span>
</button>
    <button  class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left:-95px" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>


</div>
</div> -->
<div class="topnav">
	
         
	
		<input type="text" placeholder="CompanyName" id="txtSearch" ng-model="companyName" >
		<button ng-click="search()"><span class="glyphicon glyphicon-search" ></span></button>
		
	
	   
    <button data-toggle="modal" data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus" ></span>
        </button>
      <!--   <button  data-toggle="modal" data-target="#duplicateModal" >
        <span >Duplicate</span> -->
</button>
		
		
		
	
</div>


</div>
<br>
<!-- 
			<div class="col-sm-9">

				<div>
					<h1>DeviceTradeInBasePrice</h1>
				    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%">
        <span class="glyphicon glyphicon-plus"></span>
        </button>
				</div>
				<br> -->

				<table class="table table-striped" border="1">
					<tr>
						<td>BasePrice</td>
						<td>Company Name</td>
						<td>Device Model Id</td>

						<td>Edit</td>
						<td>Delete</td>
					</tr>

					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.basePrice}}</td>
						<td>{{entity.company.companyName}}</td>
						<td>{{entity.eModel.deviceModelId}}</td>

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

										Base Price:<input class="form-control" type="text" name="basePrice"
											ng-model="ent.basePrice" required="required"> <span
											style="color: Red"
											ng-show="addform.basePrice.$touched && addform.basePrice.$invalid">
											This field is required.</span> <br> <br>
										<!-- Company Name: <input
											class="form-control" type="text" name="companyName"
											ng-model="ent.companyName" required="required"> <span
											style="color: Red"
											ng-show="addform.companyName.$touched && addform.companyName.$invalid">
											This field is required.</span> <br> <br>
										 -->
										  Company Name:<select 
           										class="form-control" ng-model="ent.company"
      									        name="company"
      									        ng-options="x as x.companyName for x in arrEntityForCompany"
          									    ></select><br><br >
										 Model Device Id:
											<select class="form-control" ng-model="ent.eModel"
											ng-options="x as x.deviceModelId for x in arrModel"></select><br><br>

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

										Base Price:<input class="form-control" type="text" name="basePrice"
											ng-model="ent.basePrice" required="required"> <span
											style="color: Red"
											ng-show="editform.basePrice.$touched && editform.basePrice.$invalid">
											This field is required.</span> <br> <br>
										<!-- Company Name: <input
											class="form-control" type="text" name="companyName"
											ng-model="ent.companyName" required="required"> <span
											style="color: Red"
											ng-show="editform.companyName.$touched && editform.companyName.$invalid">
											This field is required.</span> <br> <br> -->
											Company Name:<select 
           										   class="form-control" ng-model="ent.company"
        									      name="company"
      										        ng-options="x as x.companyName for x in arrEntityForCompany"
    								          ></select><br><br>
										Model Device Id:
											<select class="form-control" ng-model="ent.eModel"
											ng-options="x as x.deviceModelId for x in arrModel"></select><br><br>

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