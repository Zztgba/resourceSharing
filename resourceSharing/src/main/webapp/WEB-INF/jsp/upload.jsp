<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
	<script src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <title>资源上传</title>
	<script>
        $(function(){
			//获取resource标签
			/* var inp = $("#main").("<a href=\"http://www.baidu.com\">百度</a>");
			console.log(inp); */
		});
    </script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
	<p></p>
	<div></div>
	
    <!-- 网站主体 -->
    <div id="main">
        <!-- 上传表单-->
        <div class="upload">
            <p>上传资源</p>
            <hr/>
            <form action="${pageContext.request.contextPath }/ResourceController/saveResource.action" method="post" enctype="multipart/form-data" id="uploadForm">
                <span>
                    <label>选择文件：</label>
                    <input class="upt" type="text" readonly="readonly" id="file"/>
                    <input class="upt" type="file" name="filePath" value=""/>
                    <b id="fileb"></b>
                    <b>文件格式可以是txt、pdf、zip、rar等后缀</b>
                </span>
                <span>
                    <label>资源名称：</label>
                    <input class="upt" type="text" name="name" value="" />
                </span>
                <span>
                    <label>资源类型：</label>
                    <select class="upt" name="type">
                        <option value="1">文本文件</option>
                        <option value="2">电子文件</option>
                        <option value="3">压缩文件</option>
                    </select>
                </span>
                <span>
                    <label>关键词：</label>
                    <input id="keywords" class="upt" type="text" name="keywords" value=""/>
                    <b id="keywordsb"></b>
                    <b>多个关键词用空格分割,关键词不能超过5个</b>
                </span>
                <span>
                    <label>资源分：</label>
                    <select class="upt" id="sel" name="score">
                        <option>0</option>
                        <option>1</option>
                        <option>2</option>
                        <option selected="selected">3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>
                    </select>
                </span>
                <span class="d_span">
                    <label>资源描述：</label>
                    <textarea  class="area" name="description" placeholder="描述不支持HTML标签；详细的资源描述有机会获得我们的推荐，更有利于他人下载，赚取更多积分。如资源描述不清，有可能审核不通过。"></textarea>
                </span>
                <span>
                    <label class="agree">
                        <input id="agree" type="checkbox" name="" value="1" />
                        同意爱下下资源上传协议
                        <b id="agreea"></b>
                         <b id="agreeb">同意爱下下资源上传协议请打勾</b>
                    </label>

                </span>

                <span><label class="btn"><input type="button" value="提交" /></label></span>
            </form>
        </div>
        <!-- 公告 -->
        <div class="advice">
            <p class="title">上传须知</p>
            <hr />
            <p><span>*</span>如涉及侵权内容,您的资源将被移除</p>
            <p><span>*</span>请勿上传小说、mp3、图片等与技术无关的内容.一旦发现将被删除</p>
            <p><span>*</span>请勿在未经授权的情况下上传任何涉及著作权侵权的资源，除非该资源完全由您个人创作</p>
            <p><span>*</span>点击上传资源即表示您确认该资源不违反资源分享的使用条款，并且您拥有该资源的所有版权或者上传资源的授权</p>
        </div>
    </div>

    
</body>
<script>
	$(function(){
		//验证文件类型
		var $fileFlag=false;
		$("input[name='filePath']").change(function(){
			var $filePath=$("input[name='filePath']").val();
			var $index=$filePath.lastIndexOf("\\");
			//文件名
			var $filename=$filePath.substring($index+1);
			var $index2=$filePath.lastIndexOf(".")
			//文件后缀名
			var $suffixName=$filePath.substring($index2+1);
			var suffixArr=["txt","pdf","zip","rar"];
			for(var i=0;i<suffixArr.length;i++){
				if(suffixArr[i]===$suffixName){
					$("#file").val($filename);
					$("#fileb").text("");
					$fileFlag=true;
					break;
				}else{
					$("#file").val("");
					$("#fileb").text("上传的文件格式不对，请重新选择！");
				}
			}
		});
		//关键字验证
		var $kwFlag=false;
		$("#keywords").blur(function(){
			var $kwVal=$("#keywords").val();
			var kwArr=$kwVal.split(" ");
			if(kwArr.length>5){
				$("#keywordsb").text("关键词不能超过5个,请重新输入！");
			}else{
				$("#keywordsb").text("");
				$kwFlag=true;
			}
		});
		//checkBox验证
		var agreeFlag=false;
		$("#agree").click(function(){
			if($("#agree").is(":checked")){
				agreeFlag=true;
			}else{
				agreeFlag=false;
			}
		});
		//表单提交验证
		$("input[type='button']").click(function(){
			if(agreeFlag===false){
				$("#agreea").text("划勾后才能提交");
			}else{
				$("#agreea").text("");
				if($fileFlag&&$kwFlag){
					$("#uploadForm").submit();
				}
			}
			
		});
	});
</script>
</html>