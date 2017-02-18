<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <title>Group</title>
		
		<script src="hplus/js/jquery.min.js"></script>
        <link href="hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
        <link href="hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
        <link href="hplus/css/animate.css" rel="stylesheet">
        <link href="layui/css/layui.css" rel="stylesheet">
        <link href="hplus/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
        <link href="hplus/css/style.css?v=4.1.0" rel="stylesheet">
       
         
		<link href="hplus/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
        <link href="hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
        <style>
            label.required:after {content: " *"; color: red;}
        </style>
       
       <style type="text/css">
       .red { color:#FF5511 !important; }
       .yellow { color:#FFBB00 !important; }
       .blue { color:#0000CC !important; }
       .black { color:#666666 !important; }
       </style>
       
    </head>
    <body class="gray-bg">
      
            <div class="col-lg-2 col-md-3">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3><i class="fa fa-angle-double-right"></i>  設定</h3>
                    </div>
                    <div class="panel-body">
                        <div class="ibox">
                            <div class="fa-tree-list">
                                <ul style="list-style-type:none;margin-left:0px;">
                                    <li>
                                        <span>
                                            <i class="fa fa-fw fa-folder-open"></i>
                                            使用者管理
                                        </span>
                                        <ul style="list-style-type:none;margin-left:20px;">
                                            <li onclick=""><i class="fa fa-fw fa-file-text-o"></i>人員管理</li>
                                            <li onclick=""><i class="fa fa-fw fa-file-text-o"></i>部門權限管理</li>
                                            <li onclick=""><i class="fa fa-fw fa-file-text-o"></i>值機狀態管理</li>
                                        </ul>
                                    </li>
                                    <li class="active">
                                        <span>
                                            <i class="fa fa-fw fa-folder-open"></i>
                                            管道管理
                                        </span>
                                        <ul style="list-style-type:none;margin-left:20px;">
                                            <li><i class="fa fa-fw fa-file-text-o"></i>分派小組管理</li>
                                            <li><i class="fa fa-fw fa-file-text-o"></i>Chat管道設定</li>
                                        </ul>
                                    </li>
                                    <li>
                                        <span>
                                            <i class="fa fa-fw fa-folder-open"></i>
                                            案件管理
                                        </span>

                                        <ul style="list-style-type:none;margin-left:20px;">
                                            <li><i class="fa fa-fw fa-file-text-o"></i>常用連結管理</li>
                                            <li><i class="fa fa-fw fa-file-text-o"></i>服務代碼管理</li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="col-lg-10 col-md-9">
                <div class="panel panel-success">
                    <!-- 設定頁面內容頁 Start-->
                    <div class="panel-body" id="settingContent">
                        
                        <!-- 人員管理切換頁籤Start -->
                        <div id="hrTabControlButton">
                            <button class="btn-sm btn-primary manage" onclick="showManage()"><i class="fa fa-fw fa-user"></i>人員管理</button>
                            <button class="btn-sm btn-success ban" onclick="showBan()"><i class="fa fa-fw fa-user"></i>停用列表</button>
                            <button class="btn-sm btn-success addMember" style="display:none;"><span onclick="showAddMember()">新增人員</span> <i class="fa fa-times" onclick="closeAddMember()"></i></button>
                            <button class="btn-sm btn-success editMember" style="display:none;"><span onclick="showEditMember()">HolyLin</span> <i class="fa fa-times" onclick="closeEditMember()"></i></button>
                        </div>
                        <!-- 人員管理切換頁籤End -->

                        <div id="manageContent">
                            <div>
                                <ul class="pagination">
                                    <li onclick="showAddMember()"><a href="#"><i class="fa fa-fw fa-plus"></i></a></li>
                                    <li onclick="unlockAccount()"><a href="#"><i class="fa fa-fw fa-unlock-alt"></i></a></li>
                                    <li onclick="confirmBan()"><a href="#"><i class="fa fa-fw fa-ban"></i></a></li>
                                </ul>

                                <ul class="pagination" style="float:right;" >
                                    <li>
                                        <input type="text" id="manageSearch" placeholder="搜索"
                                               style="background-color: #FFFFFF;
                                                      border: 1px solid #DDDDDD;
                                                      color: inherit;
                                                      float: left;
                                                      line-height: 1.42857;
                                                      margin-left: -1px;
                                                      padding: 4px 10px;
                                                      position: relative;
                                                      text-decoration: none;">
                                    </li>

                                    <li><a href="#"><i class="fa fa-fw fa-refresh"></i></a></li>
                                </ul>
                            </div>

                            <div class="row ibox">
                                <div class="col-lg-12 col-md-12">
                                  
<div class="col-lg-3 col-md-3">

        
<!-- Insert   -->
<button type="button" class="btn btn-primary btn-sl" data-toggle="modal" data-target="#insertt">
 新增
</button>
<!-- Modal -->
<div class="modal fade" id="insertt" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog modal-ml">
    <div class="modal-content ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="update_myModalLabel" >新增欄位:</h4>
      </div>
      <div class="modal-body">

       <label >in_state:</label>
      <input  class="form-control" id="in_state" placeholder="state"><br>
       <label>in_name:</label>
      <input  class="form-control" id="in_name" placeholder="name"><br>
       <label>in_person_dbid</label>
      <input class="form-control" id="in_person_dbid" placeholder="person_dbid"><br>
      
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="insert()">建立</button>
      </div>
    </div>
  </div>
</div>	
<!-- Insert	END-->

           
<!-- UPDATE	   -->
<button type="button" class="btn btn-primary btn-sl" data-toggle="modal" data-target="#update">
 更新
</button>
<!-- Modal -->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog modal-ml">
    <div class="modal-content ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="update_myModalLabel" >更新欄位:</h4>
      </div>
      <div class="modal-body">

       <label >up_state:</label>
      <input  class="form-control" id="up_state" placeholder="up_state"><br>
       <label>up_name:</label>
      <input  class="form-control" id="up_name" placeholder="up_name"><br>
       <label>up_dbid:</label>
      <input class="form-control" id="up_dbid" placeholder="up_dbid"><br>
      
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="update()">更新</button>
      </div>
    </div>
  </div>
</div>	
<!-- UPDATE	END-->


<!-- delete -->
<button type="button" class="btn btn-primary btn-sl" data-toggle="modal" data-target="#delete">
 刪除
</button>
<!-- Modal -->
<div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog modal-ml">
    <div class="modal-content ">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="delete_myModalLabel" >刪除欄位:</h4>
      </div>
      <div class="modal-body">
      
	
       <label>Delete DBID:</label>
      <input class="form-control" id="dedbid" placeholder="dbid"><br>
      </div>
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="Gdelete()">刪除</button>
      </div>
    </div>
  </div>
</div>
<!-- delete END-->


<!-- permission -->
<!--                         <button type="button" class="btn btn-default"  -->
<!--                           onclick="location.href='p.jsp'">permission -->
<!--                         </button> -->
<!-- permission END-->

</div>
		
		 
	   <div class="col-lg-9 col-md-9">
	  
	<div id="div">
   <table  id="table"
        data-pagination="true"
        data-search="true"
		data-click-to-select="true"
		 >  
		<thead>
				<tr >
					
					<th id="name" data-sortable="true"></th>
					<th id="state" data-sortable="true"></th>
					<th id="dbid" data-sortable="true"></th>
				</tr>
     </thead>
</table>
    
    </div>
                    </div>
                            </div>
                        </div>

                    </div>
                    <!-- 設定頁面內容頁 End-->
                </div>
            </div>
        </div>
    </body>


    <!-- 全局js -->
  
    <script src="hplus/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- Data Tables -->
    <script src="hplus/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="hplus/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- DataPicker -->
    <script src="hplus/js/plugins/datapicker/bootstrap-datepicker.js"></script>

    <!-- toastStr -->
    <script src="hplus/js/plugins/toastr/toastr.min.js"></script>

    <!-- layui -->
    <script src="layui/layui.js"></script>
    
    <script src="hplus/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>			  <!-- TABLE相關 -->
    <script src="hplus/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>	  <!-- TABLE相關 -->
 	<script src="hplus/js/demo/bootstrap-table-demo.js"></script>


 <script type="text/javascript">
 window.onload = select;
 
 
 var dbid = 0;
	 function select(){
		 
		  $.ajax({                              
	          url:"RESTful/Query_GroupInfo",
		         data:{
		        	dbid:dbid
		        	 },
		         type : "POST",                                                                    
		         dataType:'json',
		         
		         error:function(e){                                                                 
		         alert("失敗");
		         callback(data);
		         },
		         success:function(data){
		        	 $("#div").html($('#table').bootstrapTable({
		        		 columns: [{
		        		        field: 'name',
		        		        title: 'name'
		        		    },{
		        		        field: 'state',
		        		        title: 'state'
		        		    }, {
		        		        field: 'dbid',
		        		        title: 'dbid'
		        		    }],
		     	data:data.group
		     	}));"json"
		     	
	     		console.log("Select",data);	
		     }
		     });		  
	 		}; 

		 </script>
		
		 
<script type="text/javascript">
var dbid = 0;



	function insert(){
		var in_state = document.getElementById('in_state').value;
		var in_name = document.getElementById('in_name').value;;
		var in_person_dbid = document.getElementById('in_person_dbid').value;
		$.ajax({                              
	          url:"RESTful/Insert_GroupInfo",
		         data:{
		        	state:in_state,
		        	name:in_name,
		        	person_dbid:in_person_dbid
		        	 },
		         type : "POST",                                                                    
		         dataType:'json',
		         
		         error:function(e){                                                                 
		         alert("失敗");
		         callback(data);
		         },
		         success:function(data){
		        	 $.ajax({                              
		   	          url:"RESTful/Query_GroupInfo",
		   		         data:{
		   		        	dbid:dbid
		   		        	 },
		   		         type : "POST",                                                                    
		   		         dataType:'json',
		   		         
		   		         error:function(e){                                                                 
		   		         alert("失敗");
		   		         callback(data);
		   		         },
		   		         success:function(data){ 
		   		        	 
		   		        	 $('#table tr').empty();
		   		        	 $("#div").html($('#table').bootstrapTable({
		   		        		 columns: [{
		   		        		        field: 'name',
		   		        		        title: 'name'
		   		        		    },{
		   		        		        field: 'state',
		   		        		        title: 'state'
		   		        		    }, {
		   		        		        field: 'dbid',
		   		        		        title: 'dbid'
		   		        		    }],
		   		     	data:data.group
		   		     	}));"json"
		   		     	
		   	     		console.log("Select",data);	
		   		     }
		   		     });	
		     }
		     });		  
	}
</script>

<script type="text/javascript">
var dbid = 0;

function update(){
	
	
	var up_dbid = document.getElementById('up_dbid').value;
	var up_name = document.getElementById('up_name').value;	
	var up_state =  document.getElementById('up_state').value;	
		
		
	$.ajax({                              
          url:"RESTful/Update_GroupInfo",
	         data:{
	        	state:up_state,
	        	name:up_name,
	        	dbid:up_dbid
	        	 },
	         type : "POST",                                                                    
	         dataType:'json',
	         
	         error:function(e){                                                                 
	         alert("失敗");
	         callback(data);
	         },
	         success:function(data){
	        	 $.ajax({                              
	   	          url:"RESTful/Query_GroupInfo",
	   		         data:{
	   		        	dbid:dbid
	   		        	 },
	   		         type : "POST",                                                                    
	   		         dataType:'json',
	   		         
	   		         error:function(e){                                                                 
	   		         alert("失敗");
	   		         callback(data);
	   		         },
	   		         success:function(data){ 
	   		        	 
	   		        	 $('#table tr').empty();
	   		        	 $("#div").html($('#table').bootstrapTable({
	   		        		 columns: [{
	   		        		        field: 'name',
	   		        		        title: 'name'
	   		        		    },{
	   		        		        field: 'state',
	   		        		        title: 'state'
	   		        		    }, {
	   		        		        field: 'dbid',
	   		        		        title: 'dbid'
	   		        		    }],
	   		     	data:data.group
	   		     	}));"json"
	   		     	
	   	     		console.log("Select",data);	
	   		     }
	   		     });	
	     }
	     });		  
}
</script>

<script type="text/javascript">
function Gdelete(){
	var dedbid = document.getElementById('dedbid').value;
	var dbid = 0;
	$.ajax({                              
        url:"RESTful/Delete_GroupInfo",
	         data:{
	        	 dbid:dedbid
	        	 },
	         type : "POST",                                                                    
	         dataType:'json',
	         
	         error:function(e){                                                                 
	         alert("失敗");
	         callback(data);
	         },
	         success:function(data){

	        	 $.ajax({                              
	   	          url:"RESTful/Query_GroupInfo",
	   		         data:{
	   		        	dbid:dbid
	   		        	 },
	   		         type : "POST",                                                                    
	   		         dataType:'json',
	   		         
	   		         error:function(e){                                                                 
	   		         alert("失敗");
	   		         callback(data);
	   		         },
	   		         success:function(data){ 
	   		        	 
	   		        	 $('#table tr').empty();
	   		        	 $("#div").html($('#table').bootstrapTable({
	   		        		 columns: [{
	   		        		        field: 'name',
	   		        		        title: 'name'
	   		        		    },{
	   		        		        field: 'state',
	   		        		        title: 'state'
	   		        		    }, {
	   		        		        field: 'dbid',
	   		        		        title: 'dbid'
	   		        		    }],
	   		     	data:data.group
	   		     	}));"json"
	   		     	
	   	     		console.log("Select",data);	
	   		     }
	   		     });	
	     }
	     });
}
</script>
    
</html>


