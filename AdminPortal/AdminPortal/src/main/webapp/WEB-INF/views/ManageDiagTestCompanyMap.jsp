
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
					<li><a href="../care/eUser">User</a></li>
					<li><a href="../logout"> Logout</a></li>
				</ul>
			<br>
			</div>

			<div class="col-xs-6 col-md-4">
				<div>
					<h1>DiagTestCompanyMap</h1>
  	    <div class="input-group" style="position:relation;left:50%">
<!--
				<input type="text" class="form-control" placeholder="CompanyName" id="txtSearch" ng-model="company" style="height:27px"/>
  		 <div class="input-group-btn">
  		      <button class="btn btn-primary" ng-click="search()" >
   		     <span class="glyphicon glyphicon-search" ></span>
    	    </button>
        <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" ng-click="addNewChoice();setDefaultValueForChoices()" >
     	   <span class="glyphicon glyphicon-plus"></span>
        </button>
         -->

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
</div>
</div>
<br>

				<!-- <div>
					<h1>DiagTestCompanyMap</h1>
    <button class="btn btn-primary"  data-toggle="modal" data-target="#addModal" style="position: relative; left: 90%" ng-click="addNewChoice();setDefaultValueForChoices()">
        <span class="glyphicon glyphicon-plus"></span>
        </button>				</div>
				<br> -->

				<table class="table table-striped" border="1">
					<tr>
						<td>Company Name</td>

						<td>Product Code</td>
						<td>Severity Code</td>
						<td>Diag Issues Flow</td>
						<td>Diag Test</td>

						<td>Edit</td>
						<td>Delete</td>


					</tr>
					<tr ng-repeat="entity in arrEntity">
						<td>{{entity.company.companyName}}</td>

						<td>{{entity.productCd.lookUpKey.lookUpValue}}</td>
						<td>{{entity.severityCd.lookUpKey.lookUpValue}}</td>
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
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body">


										<!-- Company Id:<input class="form-control" type="number" name="companyId"
											ng-model="ent.companyId" required="required"> <span
											style="color: Red"
											ng-show="addform.companyId.$touched && addform.companyId.$invalid">
											This field is required.</span> <br> <br>
										 -->
										 Company Name:<select
        								      	class="form-control" ng-model="ent.company"
              									name="company"
              									ng-options="x as x.companyName for x in arrEntityForCompany"
              									></select><br><br >
										 Product Code:<select
        								      	class="form-control" ng-model="ent.productCd"
              									name="productCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrLookUp"
              									></select><br><br >



										 <!-- <input
												class="form-control" type="text" name="productCd"
												ng-model="ent.productCd" required="required"> <span
												style="color: Red"
												ng-show="addform.productCd.$touched && addform.productCd.$invalid">
												This field is required.</span> <br> <br>
									 -->

<div data-ng-repeat="choice in choices" style="position: relative;">
<table>
<tr>

<div class="row">

<div class="col-sm-4" style="background-color:lavender;">
	 Severity Code:<select
        								      	class="form-control" ng-model="ent.severityCd"
              									name="severityCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrSev"
              									></select>
			<span style="color: Red" ng-show="addform.severityCd.$touched && addform.severityCd.$invalid"> This field is required.</span>

</div>

<div class="col-sm-4" style="background-color:lavenderblush;">
Diag Issues Flow:<select id="{{choice.id}}" class="form-control" ng-model="choice.diagIissuesFlow"
					ng-options="x.issueCd for x in arrdiagIissuesFlow"></select>

</div>

<div  class="col-sm-4" style="background-color:lavender;">
Diag Test:<select id="{{choice.id}}"  class="form-control" ng-model="choice.diagTest" ng-options="x.testCd for x in arrDiagTest"></select>

</div>

<div class="col-sm-4" style="background-color:lavenderblush;">
Action Value <br>
<button ng-click="addNewChoice()"  class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button>
<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"><span class="glyphicon glyphicon-minus"></span></button>
</div>

</div>
</tr>
</table>
</div>
		</div><br>
										<!-- Serverity Code: <input
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
											<br><br>	-->


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
										<!-- companyId:<input class="form-control" type="number" name="companyId"
											ng-model="entEdit.companyId" required="required" di>
											<span style="color: Red"
											ng-show="editform.companyId.$touched && editform.companyId.$invalid">
											This field is required.</span> <br> <br> -->
							Company Name:<select
        								      	class="form-control" ng-model="entEdit.company"
              									name="company"
              									ng-options="x as x.companyName for x in arrEntityForCompany"
              									></select><br><br >


							<!-- <select
            							  class="form-control" ng-model="entEdit.company"
     							         name="company"
     							         ng-options="x.companyId as x.companyName for x in arrEntityForCompany"
    							          ></select><br><br> -->

								Product Cd:<select
        								      	class="form-control" ng-model="entEdit.productCd"
              									name="productCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrLookUp"
              									></select><br><br >

							<!--
								<input
											class="form-control" type="text" name="productCd"
											ng-model="entEdit.productCd" required="required"> <span
											style="color: Red"
											ng-show="editform.productCd.$touched && editform.productCd.$invalid">
											This field is required.</span> <br> <br>
									 -->
									 Severity Code:<select
        								      	class="form-control" ng-model="entEdit.severityCd"
              									name="severityCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrSev"
              									></select><br><br >
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

										<form name="dupeditform">
						<div class="modal fade" id="dupeditform" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Add </h4>
									</div>
									<div class="modal-body">



										 Company Name:<select
        								      	class="form-control" ng-model="dupent.company"
              									name="company"
              									ng-options="x as x.companyName for x in arrEntityForCompany"
              									></select><br><br >
										 Product Code:<select
        								      	class="form-control" ng-model="dupent.productCd"
              									name="productCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrLookUp"
              									></select><br><br >



<div data-ng-repeat="dupent in choices" style="position: relative;">
<table>
<tr>

<div class="row">
<div class="col-sm-4" style="background-color:lavender;">
	 Severity Code:<select
        								      	class="form-control" ng-model="dupent.severityCd"
              									name="severityCd"
              									ng-options="x as x.lookUpKey.lookUpValue for x in arrSev" ng-selected="dupent.severityCd"
              									></select>
			<span style="color: Red" ng-show="addform.severityCd.$touched && addform.severityCd.$invalid"> This field is required.</span>

</div>

<div class="col-sm-4" style="background-color:lavenderblush;">
Diag Issues Flow:<select id="{{choice.id}}" class="form-control" ng-model="dupent.diagIissuesFlow"
					ng-options="x.issueCd for x in arrdiagIissuesFlow" ng-selected="dupent.diagIissuesFlow"></select>

</div>

<div  class="col-sm-4" style="background-color:lavender;">
Diag Test:<select id="{{choice.id}}"  class="form-control" ng-model="dupent.diagTest" ng-options="x.testCd for x in arrDiagTest"></select>

</div>

<div class="col-sm-4" style="background-color:lavenderblush;">
Action Value <br>
<button ng-click="addNewChoice()"  class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button>
<button type="button" ng-click="deleteNewChoice()" class="btn btn-info"><span class="glyphicon glyphicon-minus"></span></button>
</div>

</div>
</tr>
</table>
</div>
		</div><br>
										<!-- Serverity Code: <input
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
											<br><br>	-->


										<div class="modal-footer">
											<button type="button" ng-disabled="addform.$invalid"
												class="btn btn-default" data-dismiss="modal"
												ng-click="saveDuplicate()">save</button>

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