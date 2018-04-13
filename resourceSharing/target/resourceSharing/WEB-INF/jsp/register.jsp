<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
    <title>用户注册</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- 网站主体 -->
    <div id="main">
        <!-- 上传表单-->
        <div class="upload">
            <p>用户注册</p>
            <hr/>
            <form action="${pageContext.request.contextPath }/UserController/register.action" id="myform" method="post" enctype="multipart/form-data">
                <span>
                    <label>用户头像：</label>
                    <input class="upt" type="text" readonly="readonly" id="imageName"/>
                    <input class="upt" type="file" name="headImage" value=""/>
                    <b id="imageb"></b>
                    <b>文件格式可以是jpg,gif,png等图片格式</b>
                </span>
                <span>
                    <label>用户名：</label>
                    <input id="name" class="upt" type="text" name="name" value="" />
					<b id="nameb"></b>
                    <b>账号可以包含字母，数字，下划线，不允许出现其他符号,长度3-16位</b>
                </span>
                <span>
                    <label>用户别名：</label>
                    <input id="alias" class="upt" type="text" name="nickname" value="" />
					<b id="aliasb"></b>
                    <b>别名可以包含字母，数字，下划线，不允许出现其他符号</b>
                </span>
                <span>
                    <label>生日：</label>
                    <input id="birth" class="Wdate upt" type="text" name="birth" value="" onFocus="WdatePicker({lang:'zh-cn',readOnly:true,dateFmt:'yyyy-MM-dd'})"/>
					<b id="birthb"></b>
                    <b>年-月-日</b>
                </span>
                <span>
                    <label>性别：</label>
                                                            男<input id="sex" class="" type="radio" name="sex" value="男">
                                                            女<input id="sex1" class="" type="radio" name="sex" value="女">
					<b id="sexb"></b>
                    <b>性别在男，女中选择</b>
                </span>
                <span>
                    <label>密码：</label>
                    <input id="password" class="upt" type="password" name="password" value="" />
                    <b id="passwordb"></b>
                    <b>密码长度为6-20位</b>
                </span>
                <span>
                    <label>确认密码：</label>
                    <input id="confirmPass" class="upt" type="password" name="abd" value="" />
                    <b id="confirmPassb"></b>
                    <b>两次输入的密码必须保持一致</b>
                </span>
                <span>
                    <label>联系方式：</label>
                    <input id="tel" class="upt" type="text" name="tel" value="" />
                    <b id="telb"></b>
                    <b>您丢失密码后找回密码的凭证</b>
                </span>
                <span>
                    <label>电子邮箱：</label>
                    <input id="email" class="upt" type="text" name="email" value="" />
                    <b id="emailb"></b>
                    <b>您丢失密码后找回密码的凭证</b>
                </span>

                <span><label class="btn"><input id="reg" type="button"  value="注册" /></label></span>
            </form>
        </div>

    </div>
	<script>
		$(function(){
			//头像验证 
			var imageFlag=false;
			var $image=$("input[name='headImage']");
			$image.change(function(){
				imageFlag=false;
				var $index=$image.val().lastIndexOf("\\");
				var $suffixIndex=$image.val().lastIndexOf(".");
				var $imageName=$image.val().substring($index+1);
				var $suffixName=$image.val().substring($suffixIndex+1);
				var allowImage=['jpg','png','jpeg','bmp','gif'];
				for(var i=0;i<allowImage.length;i++){
					if($suffixName===allowImage[i]){
						$("#imageName").val($imageName);
						$("#imageb").text("");
						imageFlag=true;
						break;
					}
				}
				if(imageFlag==false){
					$("#imageName").val("");
					$("#imageb").text("用户头像格式不对，请重新选择！");
				}
			});
			
			//用户名验证
			var nameFlag=false;
			$("#name").blur(function(){
				var $nameRex=/^[0-9a-zA-Z_]{3,16}$/;
				var $name=$("#name").val();
				var $nameLen=$name.length;
				if($nameLen<3){
					$("#nameb").text("用户名过短，请重新输入!");
				}else if($nameLen>16){
					$("#nameb").text("用户名过长，请重新输入!");
				}else if($nameRex.test($name)){
					$("#nameb").text("");
					nameFlag=true;
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath }/UserController/rexName.action",
						data:"name="+$name,
						dataType:"json",
						success:function(data){
							if(data===false){
								$("#nameb").text("");
								nameFlag=true;
							}else{
								$("#nameb").text("用户名已被注册，请重新输入!");
							}
						}
					});
				}else{
					$("#nameb").text("用户名格式不对，请重新输入!");
				}
				
				
			});
			
			//验证用户别名
			var $nickname=false;
			$("#alias").blur(function(){
				var $nameRex=/^[0-9a-zA-Z_]{3,16}$/;
				var $name=$("#alias").val();
				var $nameLen=$name.length;
				if($nameLen<3){
					$("#aliasb").text("用户名过短，请重新输入!");
				}else if($nameLen>16){
					$("#aliasb").text("用户名过长，请重新输入!");
				}else if($nameRex.test($name)){
					$("#aliasb").text("");
					$nickname=true;
				}else{
					$("#aliasb").text("用户名格式不对，请重新输入!");
				}
			});
			//验证生日
			var $birthFlag=false;
			$("#birth").blur(function(){
				var $birthVal=$("#birth").val();
				var $RexBirth=/^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$/;
				if($RexBirth.test($birthVal)){
					$("#birthb").text("");
					$birthFlag=true;
				}else{
					$("#birthb").text("生日日期不符合规则，请重新输入！");
				}
			});
			//验证密码
			var $pswFlag=false;
			var $pswVal;
			$("#password").blur(function(){
				$pswVal=$("#password").val();
				if($pswVal.length<6){
					$("#passwordb").text("用户名过短，请重新输入!");
				}else if($pswVal.length>20){
					$("#passwordb").text("用户名过长，请重新输入!");
				}else{
					$("#passwordb").text("");
					$pswFlag=true;
				}
			});
			
			//验证确定密码
			var $cfmFlag=false;
			$("#confirmPass").blur(function(){
				var $cfmPswVal=$("#confirmPass").val();
				if($pswVal===$cfmPswVal){
					$("#confirmPassb").text("");
					$cfmFlag=true;
				}else{
					$("#confirmPassb").text("两次输入的密码不一致,请重新输入!");
				}
			});
			
			//验证联系方式
			var $telFlag=false;
			$("#tel").blur(function(){
				var $telVal=$("#tel").val();
				var $rexTel=/^[1][35789][0-9]{9}$/;
				if($rexTel.test($telVal)){
					$("#telb").text("");
					$telFlag=true;
				}else{
					$("#telb").text("请输入11位数手机号！");
				}
			});
			
			//验证电子邮箱
			var $emailFlag=false;
			$("#email").blur(function(){
				var $emailVal=$("#email").val();
				var $RexEmail=/^\w{1,}@\w{1,}\.\w{1,}$/;
				if($RexEmail.test($emailVal)){
					$("#emailb").text("");
					$emailFlag=true;
				}else{
					$("#emailb").text("请输入正确的邮箱！");
				}
			});
			
			//表单提交
			$("#reg").click(function(){
				//var param = $("#myform").serialize();
				if(imageFlag&&nameFlag&&$nickname&&$birthFlag&&$cfmFlag&&$pswFlag&&$telFlag&&$emailFlag){
					$("#myform").submit();
				}
			});
		});
		
		
	</script>
</body>
</html>