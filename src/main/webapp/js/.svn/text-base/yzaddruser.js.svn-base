function savaruser(){
		//用户名
			if($("#rname").val()==""){
				$("#rnameyz").html("不能为空!");
				return ;
			}
			else{
				$("#rnameyz").html("");
			}
		//密码
			if($("#pass").val()==""){
				$("#passyz").html("不能为空!");
				return;
			}
			else{
				if($("#pass").length>16){
					$("#passyz").html("密码长度不能超过16位!");
				}else{
					$("#passyz").html("");
				}
				
			}
		//二次密码
			if($("#pass1").val()==""){
				$("#pass1yz").html("不能为空!");
				return;
			}
			else{
				if($("#pass1").val()!=$("#pass").val()){
					$("#pass1yz").html("两次密码不一致!");
					return;
				}
				if($("#pass1").length>16){
					$("#pass1yz").html("密码长度不能超过16位!");
				}else{
					$("#pass1yz").html("");
				}
			}
		
		//姓名
			if($("#name").val()==""){
				$("#nameyz").html("不能为空");
				return;
			}
			else{
				$("#nameyz").html("");
			}
		//姓名
			if($("#address").val()==""){
				$("#addressyz").html("不能为空");
				return;
			}
			else{
				$("#addressyz").html("");
			}
		
		//手机号码
			var regphone=/^((\(\d{2,3}\))|(\d{3}\-))?1\d{10}$/;
			var phone=$("#phone").val();
			if(!regphone.test(phone)){
				$("#phoneyz").html("手机号码格式不正确");
				return;
			}
			else{
				$("#phoneyz").html("");
			}
		
		//年龄
		var regage=/^[0-9]*[1-9][0-9]*$/;
		var age=$("#age").val();
			if(!regage.test(age)){
				$("#ageyz").html("年龄格式不正确 注:1-120之间");
				return;
			}else{
				if(age>120)
				{
					$("#ageyz").html("年龄格式不正确 注:1-120之间");
					return;
				}
				$("#ageyz").html("");
			}
		
		//邮箱地址
		//QQ
			var regemail=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
			var email=$("#email").val();
			if(!regemail.test(email)){
				$("#emailyz").html("邮箱格式不正确 注:xxx@xx.com");
				return;
			}
			else{
				$("#emailyz").html("");
			}
		
		//QQ
		var regqq=/^[1-9]*[1-9][0-9]*$/;
		var qq=$("#qq").val();
			if(!regqq.test(qq)){
				$("#qqyz").html("请输入有效的QQ号码");
				return;
			}
			else{
				$("#qqyz").html("");
			}
			
			document.forms[0].submit();
}


$(function(){
	//用户名
		$("#rname").blur(function(){
			if($("#rname").val()==""){
				$("#rnameyz").html("不能为空!");
			}
			else{
				$("#rnameyz").html("");
			}
			})
		//密码
		$("#pass").blur(function(){
			if($("#pass").val()==""){
				$("#passyz").html("不能为空!");
			}
			else{
				if($("#pass").length>16){
					$("#passyz").html("密码长度不能超过16位!");
				}else{
					$("#passyz").html("");
				}
			}
			})
		//二次密码
		$("#pass1").blur(function(){
			if($("#pass1").val()==""){
				$("#pass1yz").html("不能为空!");
			}
			else{
				if($("#pass1").val()!=$("#pass").val()){
					$("#pass1yz").html("两次密码不一致!");
				}
				else{
					if($("#pass1").length>16){
						$("#pass1yz").html("密码长度不能超过16位!");
					}else{
						$("#pass1yz").html("");
					}
				}
			}
		})
		//姓名
		$("#name").blur(function(){
			if($("#name").val()==""){
				$("#nameyz").html("不能为空");
			}
			else{
				$("#nameyz").html("");
			}
			})
		//姓名
		$("#address").blur(function(){
			if($("#address").val()==""){
				$("#addressyz").html("不能为空");
			}
			else{
				$("#addressyz").html("");
			}
		})
		//手机号码
		$("#phone").blur(function(){
			var regphone=/^((\(\d{2,3}\))|(\d{3}\-))?1\d{10}$/;
			var phone=$("#phone").val();
			if(!regphone.test(phone)){
				$("#phoneyz").html("手机号码格式不正确");
			}
			else{
				$("#phoneyz").html("");
			}
		})
		//年龄
		$("#age").blur(function(){
		var regage=/^[0-9]*[1-9][0-9]*$/;
		var age=$("#age").val();
			if(!regage.test(age)){
				$("#ageyz").html("年龄格式不正确 注:1-120之间");
			}else{
				if(age>120)
				{
					$("#ageyz").html("年龄格式不正确 注:1-120之间");
				}
				$("#ageyz").html("");
			}
		})
		//邮箱地址
		$("#email").blur(function(){
			var regemail=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
			var email=$("#email").val();
			if(!regemail.test(email)){
				$("#emailyz").html("邮箱格式不正确 注:xxx@xx.com");
			}
			else{
				$("#emailyz").html("");
			}
		})
		//QQ
		$("#qq").blur(function(){
		var regqq=/^[1-9]*[1-9][0-9]*$/;
		var qq=$("#qq").val();
			if(!regqq.test(qq)){
				$("#qqyz").html("请输入有效的QQ号码");
			}
			else{
				$("#qqyz").html("");
			}
			})
})