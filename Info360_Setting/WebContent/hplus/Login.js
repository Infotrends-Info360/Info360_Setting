//Login
   function Login_PersonInfo(){
	   //取得 "account" 欄位值
	   var account = $('#account').val();        
	    //取得 "password" 欄位值                                
	   var password = $('#password').val();

	     $.ajax({
	         url:"/Info360_Setting/RESTful/Login",
	         data:{
	        	 account:account,
	        	 password:password
	        	 },
	         type : "POST",                                                                    
	         dataType:'json', 
	         error:function(e){                                                                 
	         alert("請重新整理");
	         callback(data);
	         },
	         success:function(data){                                                           
	        	 console.log("login",data)
	        	 document.getElementById("demo").value=JSON.stringify(data.Function);
	        
	        	 
	       if(account==""||password==""){
	        
	        	alert(data.error)
 
	       }else if(data.error!=null){
	       		//alert("第2層error")
	       		alert(data.error);

	       	}else{
	       		//alert(JSON.stringify(data));
	       	 var Today=new Date();
	     
        	 alert(JSON.stringify(data));
        	
	       		$('#myForm').submit();
	       	}
	       		
	         },
	        beforeSend: function () {
            $('#loading').show();
       		 },
        	complete: function () {
            $('#loading').hide();
            
       		 }
	     }); 

	 };

	 
//Login submit	 
	 function myFunction() {
		    document.getElementById("myForm").submit();
		}
	 
	 
	 