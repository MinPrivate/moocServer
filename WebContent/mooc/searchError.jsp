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
	
	<!-- Le styles -->
    <link href="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
    <link type="text/css" href="http://cdn.bootcss.com/font-awesome/3.0.2/css/font-awesome.min.css" rel="stylesheet" />
    <!--[if IE 7]>
    <link rel="stylesheet" href="http://cdn.bootcss.com/font-awesome/3.0.2/css/font-awesome-ie7.min.css">
    <![endif]-->
    <!--[if lt IE 9]>
    <link rel="stylesheet" type="text/css" href="css/custom-theme/jquery.ui.1.10.0.ie.css"/>
    <![endif]-->
    <link href="./css/docs.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/prettify/r224/prettify.css" rel="stylesheet">
    

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.6.2/html5shiv.js"></script>
    <![endif]-->
	<script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
	<script src="http://cdn.bootcss.com/twitter-bootstrap/2.2.2/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>
	<script src="http://cdn.bootcss.com/prettify/r224/prettify.js" type="text/javascript"></script>
	<script src="js/docs.js" type="text/javascript"></script>
	<script src="js/demo.js" type="text/javascript"></script>
	
	<link rel="stylesheet" type="text/css" href="./css/halfmoontabs.css">
	<style type="text/css" media="screen">object.FusionCharts:focus, embed.FusionCharts:focus {outline: none}</style>
	<script language="JavaScript" type="text/javascript" src="./charts/FusionCharts.js"></script>
	<script type="text/javascript" src="js/flashCheck.js"></script>
	<script src="./js/String-Util.js"></script>
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
<body style="background:#2f5c93;-webkit-animation: animate-cloud 20s linear infinite; -moz-animation: animate-cloud 20s linear infinite; -ms-animation: animate-cloud 20s linear infinite; -o-animation: animate-cloud 20s linear infinite; animation: animate-cloud 20s linear infinite; width: 100%; height: auto;">

	<iframe frameborder="0" style="display: none;"></iframe>
	<form id="dataForm" name="dataForm" target="upload" method="post" enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/ChartData" >
	</form>

	<%
	HttpSession session2 = request.getSession(false);
	String keyword = "";
	if(session2!=null){ 
		keyword = (String)session.getAttribute("keyword"); 
	} 
	%>

	<div id="s_fm" style="width: 80%; margin: auto;"> 
		<div id="s_form_wrapper">
			<!-- <a href="/" id="result_logo"> 
				<img src="images/mooc_logo.jpg" alt="到首页" title="到首页"> 
			</a> -->
			<form name="f" id="form" method="post" action="DoSearch" onsubmit="return isSearch();">
				
					<input type="text" class="s_ipt" name="keyword" id="keyword" value="<% out.print(keyword); %>" maxlength="100" autocomplete="off" style="float: left;">
				
				
				
					<input type="submit" value="搜索" id="su" class="btn self-btn bg s_btn">
				
				
			</form> 
		</div> 
	</div>
	
	<div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all" style="width: 80%; margin: auto;">
        <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
            <li class="ui-state-default ui-corner-top ui-tabs-active ui-state-active" role="tab" tabindex="0" aria-controls="tabs-a" aria-labelledby="ui-id-3" aria-selected="true">
            	<a href="#tabs-a" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">综述</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-b" aria-labelledby="ui-id-4" aria-selected="false">
            	<a href="#tabs-b" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">媒体指数</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-c" aria-labelledby="ui-id-5" aria-selected="false">
            	<a href="#tabs-c" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">规模</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-d" aria-labelledby="ui-id-6" aria-selected="false">
            	<a href="#tabs-d" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-6">用户数据分析</a>
            </li>
        </ul>
        <div id="tabs-a" aria-labelledby="ui-id-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false" style="display: block;">
        	<h3>您所查询的内容目前还未实现，谢谢合作，敬请期待。。。。</h3>
			
        </div>
        <div id="tabs-b" aria-labelledby="ui-id-4" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
       		
       	</div>
        <div id="tabs-c" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	
        </div>
        <div id="tabs-d" aria-labelledby="ui-id-6" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	
        </div>
    </div>

	<iframe name="upload" style="display: none"></iframe>
</body>
</html>