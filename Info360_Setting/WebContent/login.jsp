<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Info360</title>
    <link rel="shortcut icon" href="hplus/favicon.ico"> <link href="hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="hplus/css/animate.css" rel="stylesheet">
    <link href="hplus/css/style.css?v=4.1.0" rel="stylesheet">
    
	<link href="css/Login.css" rel="stylesheet"></link>
	
<!-- 	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script> -->
     <!-- 全局js -->
    <script src="hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="hplus/js/bootstrap.min.js?v=3.3.6"></script>
   
     <script src="hplus/Login.js"></script>
    
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">
<!-- LOGO字 -->
			<div style="text-align: center" >
                <h1 class="logo-name"style="color:#AAAAAA	">Info360</h1>
            </div>
<!-- LOGO字END -->
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
 			<h3>Welcome to Info360</h3>
 			
 			<form id="myFormd" action="jmenu.jsp" method="post">
 			
 	 			<input class="form-control" placeholder="請輸入帳號" 
                    	    					id="account" name="account" >
	 			<input class="form-control" placeholder="請輸入密碼"  
                           type="password"      id="password" name="password"><br><br>
                
     			<input type="hidden" id="demo" name="demo" value=""/>
   			
  				 <input type="button" class="btn btn-primary block full-width m-b"
  				 onclick="Login_PersonInfo()" value="登入">
  				 
  				
  				 
			</form>
			 	

	<!-- 忘記密碼與註冊 -->
                <p class="text-muted text-center"> 
                <a href="#"><small>忘記密碼</small></a> 
                
                <a href="#">註冊</a>
                </p>
	<!-- 忘記密碼與註冊END -->
 				<div class="loadingdiv" id="loading" style="display: none">
    				<img class="loading"  src="hplus/images.png">
				</div>
            
        </div>
    </div>

	
	

   
</body>
<script type="text/javascript">


</script>

</html>
