<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta Http-Equiv="Content-Language" content="zh-cn" />
	<title>Industry Analysis</title>
	<link rel="Shortcut Icon" type="image/ico" href="./images/logo.ico">
	
	<link rel="stylesheet" type="text/css" href="css/register.css"/>
	<link rel="stylesheet" type="text/css" href="./css/css_register.css">
	
	<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>
    <script language="JavaScript" type="text/javascript" src="./jquery/jquery.js"></script>

	<script type="text/javascript">
		function isSearch() {
			
			var length = document.getElementById("keyword").value.length;
			if(length > 0){
				return true;
			}else{
				return false;
			}
		}
	</script>
</head>
<body>

<div class='signup_container'>
	<div>
		<img alt="MOOC行业搜索" src="./images/logo.png" width="400px;" height="200px;">
	</div>
    <div id="signup_forms" class="signup_forms clearfix">
            <form id="reg_form" name="reg_form" method="post" action="DoSearch" onsubmit="return isSearch();">
                    <input id="keyword" name="keyword" value="" type="text" class="itext input_hover" autocomplete="off">
                    <input id="doSearch" name="doSearch" type="submit" value="搜   索" style="width:100px; height:45px; float:left; display: block;padding: 0px; background-color: #98724d; text-align: center; color: #000000;" class="btn_reg btn_create btn_center">
                    
           </form>
    </div>

</div>

</body>
</html>