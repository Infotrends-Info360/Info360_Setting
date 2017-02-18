<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <title>「設定」頁面</title>

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
    </head>
    <body class="gray-bg">
        <div class="widget">
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
                            <button class="btn-sm btn-success editMember" style="display:none;"><span onclick="showEditMember()">更新人員</span> <i class="fa fa-times" onclick="closeEditMember()"></i></button>
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
                                <div class="col-lg-12 col-md-12" id="manageTable_div">
                                
   <table  id="manageTable"
       data-pagination="true"
       data-search="true"
       data-click-to-select="true"
  	   data-toolbar="#toolbar"
		 >  
		<thead>
				<tr >
				
					 <th id="user_name" data-sortable="true"></th>		 	
			 		 <th id="emailaddress" data-sortable="true"></th>
			 		 <th id="state" data-sortable="true"></th>
			 		 <th id="account" data-sortable="true"></th>
			 		 <th id="employee_id" data-sortable="true"></th>
			 		 <th id="dn" data-sortable="true"></th>
			 		 <th id="max_count" data-sortable="true"></th>
				</tr>
     </thead>
</table>
   
                 
                                </div>
                            </div>
                        </div>

                        <div id="banContent" style="display:none;">
                            <div>
                                <ul class="pagination">
                                    <li onclick="showAddMember()"><a href="#"><i class="fa fa-fw fa-plus"></i></a></li>
                                    <li onclick="unlockAccount()"><a href="#"><i class="fa fa-fw fa-unlock-alt"></i></a></li>
                                    <li onclick="confirmBan()"><a href="#"><i class="fa fa-fw fa-ban"></i></a></li>
                                </ul>

                                <ul class="pagination" style="float:right;" >
                                    <li>
                                        <input type="text" id="banSearch" placeholder="搜索"
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
                                <div class="col-lg-12 col-md-12" id="banTable_div">
                                
   <table  id="banTable"
       data-pagination="true"
       data-search="true"
       data-click-to-select="true"
  	   data-toolbar="#toolbar"
		 >  
		<thead>
				<tr >
				
					 <th id="user_name" data-sortable="true"></th>		 	
			 		 <th id="emailaddress" data-sortable="true"></th>
			 		 <th id="state" data-sortable="true"></th>
			 		 <th id="account" data-sortable="true"></th>
			 		 <th id="employee_id" data-sortable="true"></th>
			 		 <th id="dn" data-sortable="true"></th>
			 		 <th id="max_count" data-sortable="true"></th>
				</tr>
     </thead>
    
</table>
   
                                </div>
                            </div>
                        </div>
<!-- 新增 --> 
                        <div id="addMemberContent" style="display:none;">
                            <div class="widget">
<!--                                  <form class="form-horizontal"> -->
                                    <div class="form-group col-sm-6">
                                        <label for="inputAccount" class="col-sm-2 control-label required">帳號</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="inputAccount" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputName" class="col-sm-2 control-label required">姓名</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="inputName" placeholder="">
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-6">
                                        <label for="inputLastName" class="col-sm-2 control-label">姓氏</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="inputLastName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputFirstName" class="col-sm-2 control-label">名字</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="inputFirstName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputEmployNumber" class="col-sm-2 control-label">員工編號</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" id="inputEmployNumber" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputPhoneNumber" class="col-sm-2 control-label">分機號碼</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" id="inputPhoneNumber" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputPassword" class="col-sm-2 control-label required">密碼</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control" id="inputPassword" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputConfirmPassword" class="col-sm-2 control-label required">確認密碼</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control" id="inputConfirmPassword" placeholder="">
                                        </div>
                                    </div>


                                    <div class="form-group col-sm-12">
                                        <label for="inputEmail" class="col-sm-1 control-label">Email</label>
                                        <div class="col-sm-9">
                                            <input type="email" class="form-control" id="inputEmail" placeholder="">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group col-sm-12">
                                        <label for="inputDepartment" class="col-sm-1 control-label">部門</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="inputDepartment" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-12">
                                        <label for="inputDepartment" class="col-sm-1 control-label">最大接通數</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="inputMaxcount" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputConfirmPassword" class="col-sm-2 control-label">啟用狀態:</label>
                                        <div class="col-sm-8">
                                            <select class="form-control" id="inputState">
      											<option value="0">啟用</option>
	  											<option value="1">停用</option>
      										</select>
                                        </div>
                                    </div>
                   
                                    <div class="form-group">
                                        <div class="col-sm-offset-9 col-sm-3">
                                            <button class="btn btn-primary" onclick="sendAddMember()">儲存</button>
                                            <button class="btn btn-default">取消</button>
                                        </div>
                                    </div>


<!--                                 </form> -->

                            </div>
                        </div>
<!-- 新增END --> 
                       
<!-- 更新 -->
                       <div id="editMemberContent" style="display:none;">
                            <div class="widget">
<!--                                 <form class="form-horizontal"> -->
                                    <div class="form-group col-sm-6">
                                        <label for="inputAccount" class="col-sm-2 control-label required">帳號</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="updateAccount" >
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputName" class="col-sm-2 control-label required">姓名</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="updateName" placeholder="">
                                        </div>
                                    </div>

                                    <div class="form-group col-sm-6">
                                        <label for="inputLastName" class="col-sm-2 control-label">姓氏</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="updateLastName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputFirstName" class="col-sm-2 control-label">名字</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="updateFirstName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputEmployNumber" class="col-sm-2 control-label">員工編號</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" id="updateEmployNumber" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputPhoneNumber" class="col-sm-2 control-label">分機號碼</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control" id="updatePhoneNumber" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputPassword" class="col-sm-2 control-label required">密碼</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control" id="updatePassword" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputConfirmPassword" class="col-sm-2 control-label required">確認密碼</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control" id="updateConfirmPassword" placeholder="">
                                        </div>
                                    </div>


                                    <div class="form-group col-sm-12">
                                        <label for="inputEmail" class="col-sm-1 control-label">Email</label>
                                        <div class="col-sm-9">
                                            <input type="email" class="form-control" id="updateEmail" placeholder="">
                                        </div>
                                    </div>
                                   
                                    <div class="form-group col-sm-6">
                                        <label for="inputDepartment" class="col-sm-2 control-label">部門</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" id="updateDepartment" placeholder="">
                                        </div>
                                    </div>
                                     <div class="form-group col-sm-12">
                                        <label for="inputDepartment" class="col-sm-1 control-label">最大接通數</label>
                                        <div class="col-sm-4">
                                            <input type="text" class="form-control" id="updateMaxcount" placeholder="">
                                        </div>
                                    </div>
                                     <div class="form-group col-sm-6">
                                        <label for="inputConfirmPassword" class="col-sm-2 control-label">啟用狀態:</label>
                                        <div class="col-sm-8">
                                            <select class="form-control" id="updateState">
      											<option value="0">啟用</option>
	  											<option value="1">停用</option>
      										</select>
                                        </div>
                                    </div>
                   
                                    <div class="form-group">
                                        <div class="col-sm-offset-9 col-sm-3">
                                            <button class="btn btn-primary" onclick="sendEditMember()">更新</button>
                                            <button class="btn btn-default">取消</button>
                                        </div>
                                    </div>


<!--                                 </form> -->
                            </div>
                        </div>
<!-- 更新END -->

                    </div>
                    <!-- 設定頁面內容頁 End-->
                </div>
            </div>
        </div>
    </body>

    <!-- 彈跳對話視窗-->
    <!-- Modal -->
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#confirmBan" style="display:none;" id="confirmBanButton">banDialog</button>

    <div id="confirmBan" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-body">
                    <h3>是否確定停用帳號？</h3>
                </div>
                <div class="modal-footer">
                
                					<div class="form-group col-sm-6">
                                        <label for="inputDepartment" class="col-sm-3 control-label">DBID:</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" id="deletedbid" placeholder="">
                                        </div>
                                    </div>
                						
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick="showToastSuccess('刪除成功')">確定</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div>

        </div>
    </div>

    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#unlockModal" style="display:none;" id="unlockButton">unlockDialog</button>

    <div id="unlockModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-body">
                    <h3>是否解除鎖定帳號？</h3>
                </div>
                <div class="modal-footer">
                					<div class="form-group col-sm-6">
                                        <label for="inputDepartment" class="col-sm-3 control-label">帳號:</label>
                                        <div class="col-sm-6">
                                            <input type="text" class="form-control" id="state_account" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group col-sm-6">
                                        <label for="inputDepartment" class="col-sm-3 control-label">鎖定:</label>
                                        <div class="col-sm-6">
                                            <select id="state_list">
                                              <option value="0">開啟</option>
                                              <option value="1">鎖定</option>
                                            </select>
                                        </div>
                                    </div>
                
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick="showToastError('鎖定/解鎖')">確定</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div>

        </div>
    </div>

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
		
		 
		 </script>
		
    <script>
    
    function play(callback) {
    	
   	 function state(){
   		  $.ajax({                              
   	          url:"RESTful/Query_Person_STATE",
   		         data:{
   		        	state:0
   		        	 },
   		         type : "POST",                                                                    
   		         dataType:'json',
   		         
   		         error:function(e){                                                                 
   		         alert("失敗");
   		         callback(data);
   		         },
   		         success:function(data){
   		        	 $('#manageTable tr').empty();
   		        	 $("#manageTable_div").html($('#manageTable').bootstrapTable({
   		        		 columns: [{
   		        		        field: 'account',
   		        		        title: '帳號'
   		        		    },{
   		        		        field: 'user_name',
   		        		        title: '姓名'
   		        		    },{
   		        		        field: 'employee_id',
   		        		        title: '員工編號'
   		        		    },{
   		        		        field: 'dn',
   		        		        title: '分機號碼'
   		        		    },{
   		        		        field: 'emailaddress',
   		        		        title: '信箱'
   		        		    },{
   		        		    	field: 'state',
   		        		        title: '狀態'
   		        		    },{
   		        		    	field: 'max_count',
   		        		        title: '最大接通數'
   		        		    }],
   		        		    
   		     	data:data.person
   		     	}));"json"
   		     	
   	     		console.log("正常用戶",data);	
   		     	
   	     	 $.ajax({                              
   	          url:"RESTful/Query_Person_STATE",
   		         data:{
   		        	state:1
   		        	 },
   		         type : "POST",                                                                    
   		         dataType:'json',
   		         
   		         error:function(e){                                                                 
   		         alert("失敗");
   		         callback(data);
   		         },
   		         success:function(data){
   		        	 $('#banTable tr').empty();
   		        	 $("#banTable_div").html($('#banTable').bootstrapTable({
   		        		 columns: [{
   		        		        field: 'account',
   		        		        title: '帳號'
   		        		    },{
   		        		        field: 'user_name',
   		        		        title: '姓名'
   		        		    },{
   		        		        field: 'employee_id',
   		        		        title: '員工編號'
   		        		    },{
   		        		        field: 'dn',
   		        		        title: '分機號碼'
   		        		    },{
   		        		        field: 'emailaddress',
   		        		        title: '信箱'
   		        		    },{
   		        		    	field: 'state',
   		        		        title: '狀態'
   		        		    },{
   		        		    	field: 'max_count',
   		        		        title: '最大接通數'
   		        		    }],
   		        		    
   		     	data:data.person
   		     	}));"json"
   		     	
   	     		console.log("停用用戶",data);	
   	     	callback();
   		     }
   		     });		  
   	     		
   		     }
   		     });	
   		  
   	 		}; 
   	 	state();
    	}
    	function play2() {
    	  $("#manageTable tbody tr,#banTable tbody tr").on("click",function(){
              var text = $(this).text();
              if (text && text != "") {
                  showEditMember();
              }
          });
    	}
    	play(play2);
    	
    
        $(document).ready(function(){
            //init datatable
            $("#manageTable").DataTable();
            $("#manageTable").css("width","100%");
            $("#manageTable_filter").prop("style","float:right;");
            $("#manageTable_wrapper div:nth-child(1)").hide();

            $("#manageSearch").keyup(function(){
                var searchText = $("#manageSearch").val();

                $("input[aria-controls='manageTable']").val(searchText);
                $("input[aria-controls='manageTable']").trigger("keyup");
            });


            $("#banTable").DataTable();
            $("#banTable").css("width","100%");
            $("#banTable_filter").prop("style","float:right;");
            $("#banTable_wrapper div:nth-child(1)").hide();

            $("#banSearch").keyup(function(){

                var searchText = $("#banSearch").val();

                $("input[aria-controls='banTable']").val(searchText);
                $("input[aria-controls='banTable']").trigger("keyup");
            });
        });

        function showManage() {
            closeAllHrContent();
            $("#manageContent").show();

            $("button.manage").removeClass("btn-success");
            $("button.manage").addClass("btn-primary");  	
			
        }

        function showBan() {
            closeAllHrContent();
            $("#banContent").show();

            $("button.ban").removeClass("btn-success");
            $("button.ban").addClass("btn-primary");
         
        }

        function showAddMember() {
            closeAllHrContent();
            $("#addMemberContent").show();

            $("button.addMember").show();
            $("button.addMember").removeClass("btn-success");
            $("button.addMember").addClass("btn-primary");
        }

        function showEditMember() {
            closeAllHrContent();
            $("#editMemberContent").show();

            $("button.editMember").show();
            $("button.editMember").removeClass("btn-success");
            $("button.editMember").addClass("btn-primary");
        }

        function sendAddMember() {
            if (!validateAddMember()) {
                return;
            }
            
            closeAddMember();
            
            var in_first_name = document.getElementById('inputFirstName').value;
    		var in_last_name = document.getElementById('inputLastName').value;
    		var in_user_name = document.getElementById('inputName').value;
    		var in_emailaddress = document.getElementById('inputEmail').value;
    		var in_password = document.getElementById('inputPassword').value;
    		var in_employee_id = document.getElementById('inputEmployNumber').value;
    		var in_group_dbid = document.getElementById('inputDepartment').value;
    		var in_account = document.getElementById('inputAccount').value;
    		var in_dn = document.getElementById('inputPhoneNumber').value;
    		var in_state = document.getElementById('inputState').value;
    		var in_maxcount = document.getElementById('inputMaxcount').value;
    		
    		$.ajax({                              
    	          url:"RESTful/Insert_PersonInfo",
    		         data:{
    		        	 first_name:in_first_name,
    		        	 last_name:in_last_name,
    		        	 user_name:in_user_name,
    		        	 emailaddress:in_emailaddress,
    		        	 password:in_password,
    		        	 employee_id:in_employee_id,
    		        	 group_dbid:in_group_dbid,
    		        	 account:in_account,
    		        	 state:in_state,
    		        	 dn:in_dn,
						 max_count:in_maxcount
    		        	 },
    		         type : "POST",                                                                    
    		         dataType:'json',
    		         
    		         error:function(e){                                                                 
    		         alert("失敗");
    		         callback(data);
    		         },
    		         success:function(data){
    		        	 play(play2);
    		     }
    		     });	
            
            showToastSuccess("新增成功");
        }

        function sendEditMember() {
        	
            if (!validateEditMember()) {
            
                return;
            }
            closeEditMember();
            var up_first_name = document.getElementById('updateFirstName').value;
        	var up_last_name = document.getElementById('updateLastName').value;
        	var up_user_name = document.getElementById('updateName').value;
        	var up_emailaddress = document.getElementById('updateEmail').value;
        	var up_password = document.getElementById('updatePassword').value;
        	var up_employee_id = document.getElementById('updateEmployNumber').value;
        	var up_group_dbid = document.getElementById('updateDepartment').value;
        	var up_account = document.getElementById('updateAccount').value;
        	var up_state = document.getElementById('updateState').value;
        	var up_dn = document.getElementById('updatePhoneNumber').value;
        	var up_maxcount = document.getElementById('updateMaxcount').value;

        	$.ajax({                              
                url:"RESTful/Update_PersonInfo",
      	         data:{
      	        	 first_name:up_first_name,
      	        	 last_name:up_last_name,
      	        	 user_name:up_user_name,
      	        	 emailaddress:up_emailaddress,
      	        	 password:up_password,
      	        	 employee_id:up_employee_id,
      	        	 group_dbid:up_group_dbid,
      	        	 account:up_account,
      	        	 state:up_state,
      	        	 dn:up_dn,
      	        	 max_count:up_maxcount

      	        	 },
      	         type : "POST",                                                                    
      	         dataType:'json',
      	         
      	         error:function(e){                                                                 
      	         alert("失敗");
      	         callback(data);
      	         },
      	         success:function(data){
      	        	play(play2);
      	     }
      	     });		  
            showToastSuccess("修改成功");
        }

        function closeAddMember() {
            closeAllHrContent();
            $("button.addMember").hide();

            $("#manageContent").show();
            $("button.manage").removeClass("btn-success");
            $("button.manage").addClass("btn-primary");
        }

        function closeEditMember() {
            closeAllHrContent();
            $("button.editMember").hide();

            $("#manageContent").show();
            $("button.manage").removeClass("btn-success");
            $("button.manage").addClass("btn-primary");
        }

        function closeAllHrContent() {
            $("#manageContent").hide();
            $("#banContent").hide();
            $("#addMemberContent").hide();
            $("#editMemberContent").hide();

            $("#hrTabControlButton button").removeClass("btn-primary");
            $("#hrTabControlButton button").addClass("btn-success");
        }

        // 解鎖對話視窗
        function unlockAccount() {
            $("#unlockButton").trigger("click");

        }

        // 停用對話視窗
        function confirmBan() {
            $("#confirmBanButton").trigger("click");
        }

        /*show toastStr*/
        toastr.options = {
            "closeButton": false,
            "debug": false,
            "progressBar": true,
            "positionClass": "toast-top-right",
            "onclick": null,
            "showDuration": "2000",
            "timeOut": "2000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"
        }

        function showToastSuccess(message) {
        	persondelete();
            toastr.success(message);
        }

        function showToastError(message) {
        	 state_lis();
            toastr.error(message);
        }

        function validateAddMember() {
            var account = $("#inputAccount", "#addMemberContent" ).val();
            var name = $("#inputName", "#addMemberContent").val();
            var passowrd = $("#inputPassword", "#addMemberContent").val();
            var confirmPassword = $("#inputConfirmPassword", "#addMemberContent").val();
            var email = $("#inputEmail", "#addMemberContent").val();

            if (!account || account == '') {
                toastr.error("請輸入帳號");
                return false;
            }

            if (!name || name == '') {
                toastr.error("請輸入姓名");
                return false;
            }

            if (!passowrd || passowrd == '') {
                toastr.error("請輸入密碼");
                return false;
            }

            if (email != '' && !isValidEmail(email)) {
                toastr.error("請輸入正確的Email格式");
                return false;
            }

            if (!confirmPassword || confirmPassword == '') {
                toastr.error("請輸入確認密碼");
                return false;
            }

            if (passowrd != confirmPassword) {
                toastr.error("密碼與確認密碼不同，請重新輸入");
                return false;
            }

            return true;
        }

        function validateEditMember() {
        	var account = $("#updateAccount", "#editMemberContent" ).val();
            var name = $("#updateName", "#editMemberContent").val();
            var passowrd = $("#updatePassword", "#editMemberContent").val();
            var confirmPassword = $("#updateConfirmPassword", "#editMemberContent").val();
            var email = $("#updateEmail", "#editMemberContent").val();

            if (!name || name == '') {
                toastr.error("請輸入姓名");
                return false;
            }

            if (!passowrd || passowrd == '') {
                toastr.error("請輸入密碼");
                return false;
            }

            if (!confirmPassword || confirmPassword == '') {
                toastr.error("請輸入確認密碼");
                return false;
            }

            if (email != '' && !isValidEmail(email)) {
                toastr.error("請輸入正確的Email格式");
                return false;
            }

            if (passowrd != confirmPassword) {
                toastr.error("密碼與確認密碼不同，請重新輸入");
                return false;
            }

            return true;
        }

        function isValidEmail(email) {
            var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
    </script>
    <script type="text/javascript">
 	function persondelete(){
 		
    var deletedbid = document.getElementById('deletedbid').value;
    	
    $.ajax({                              
        url:"RESTful/Delete_PersonInfo",
	         data:{
	        	
	        	 dbid:deletedbid
	        
	        	 },
	         type : "POST",                                                                    
	         dataType:'json',
	         
	         error:function(e){                                                                 
	         alert("失敗");
	         callback(data);
	         },
	         success:function(data){
	        	play(play2);
	     }
	         
    });
    
 	}
    </script>
  
 <script type="text/javascript">
 	function state_lis(){
 		
    var state = document.getElementById('state_list').value;
    var account = document.getElementById('state_account').value;
    $.ajax({                              
        url:"RESTful/Person_logicdelete",
	         data:{
	        	
	        	 state:state,
	        	 account:account
	        
	        	 },
	         type : "POST",                                                                    
	         dataType:'json',
	         
	         error:function(e){                                                                 
	         alert("失敗");
	         callback(data);
	         },
	         success:function(data){
	        	play(play2);
	     }
	         
    });
    
 	}
    </script>
		
		 
</html>


