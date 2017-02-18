<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kendo UI JSP Wrappers</title>
		<link rel="stylesheet" href="styles/kendo.common.min.css" />
		<link rel="stylesheet" href="styles/kendo.default.min.css" />
		<script src="js/jquery.min.js"></script>
		<script src="js/kendo.all.min.js"></script>
    </head>
    
<body>
<!--  
<div class="container">
	<div class="row">
		<h1>Kendo UI Wrappers For JSP</h1>
	</div>
</div> -->

<div id="grid"></div>
</body>
<script>
var myMap = new Map();
$.post("RESTful/Query_Person", { "EMPLOYEE_ID":"2222" },
   function(data){
	myMap.set('Status', data.Status);
	myMap.set('DBID', data.DBID);
	myMap.set('STATE', data.STATE);
	myMap.set('FIRST_NAME', data.FIRST_NAME);
	myMap.set('LAST_NAME', data.LAST_NAME);
	myMap.set('USER_NAME', data.USER_NAME);
	myMap.set('IS_AGENT', data.IS_AGENT);
	myMap.set('IS_ADMIN', data.IS_ADMIN);
	myMap.set('EMPLOYEE_ID', data.EMPLOYEE_ID);
	myMap.set('Error', data.Error);
     $("#grid").kendoGrid({
  		columns: [{
    		field: "status",
    		title: "Status" 
  		},
  		{
 		 	field: "dbid",
    		title: "DBID" 
  		}, 
  		{
    		field: "state",
    		title: "STATE" 
  		},
  		{
  			field: "first_name",
    		title: "FIRST_NAME" 
  		},
  		{
  			field: "last_name",
    		title: "LAST_NAME" 
  		},
  		{
  			field: "user_name",
    		title: "USER_NAME" 
  		},
  		{
  			field: "is_agent",
    		title: "IS_AGENT" 
  		},
  		{
  			field: "is_admin",
    		title: "IS_ADMIN" 
  		},
  		{
  			field: "employee_id",
    		title: "EMPLOYEE_ID" 
  		},
  		{
  			field: "error",
    		title: "Error" 
  		}],
  		dataSource: [ { status: myMap.get('Status'), dbid: myMap.get('DBID'), state: myMap.get('STATE'), first_name: myMap.get('FIRST_NAME'), last_name: myMap.get('LAST_NAME'), user_name: myMap.get('USER_NAME'), is_agent: myMap.get('IS_AGENT'), is_admin: myMap.get('IS_ADMIN'), employee_id: myMap.get('EMPLOYEE_ID'), error: myMap.get('Error') }]
	});
}, "json");
</script>

</html>