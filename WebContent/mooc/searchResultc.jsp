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
	
	<script language="javascript">
			
			function createCouseData(item){
				
			 	if (isEmpty(item)){
			 		item = "cn";
			 	}
			 	
			 	couseleibie(item);
		   		
		   		var form = document.getElementById('dataForm'); 
				var index = form.action.indexOf("?");
				if (index>0)
			  		form.action = form.action.substring(0, index);
				
				var actionWithParameter = form.action + "?part=couse&item=" + item;
		        form.action = actionWithParameter;
		        
				form.submit();
		 	}
			
			function couseleibie(lb) {
		
			    document.getElementById("cn").className = "nom";
			    document.getElementById("cl").className = "nom";
			    document.getElementById("cp").className = "nom";
		
			    document.getElementById(lb).className = "currtitle";
			}
			
			function createQuxianData(item){
				
			 	if (isEmpty(item)){
			 		item = "sina";
			 	}
			 	
			 	quxianleibie(item);
		   		
		   		var form = document.getElementById('dataForm'); 
				var index = form.action.indexOf("?");
				if (index>0)
			  		form.action = form.action.substring(0, index);
				
				var actionWithParameter = form.action + "?part=client&item=" + item;
		        form.action = actionWithParameter;
		        
				form.submit();
		 	}
			
			function quxianleibie(lb) {
		
			    
			    document.getElementById("sina").className = "nom";
			    document.getElementById("sohu").className = "nom";
		
			    document.getElementById(lb).className = "currtitle";
			}
			
			function createGuimoData(item){
				
			 	if (isEmpty(item)){
			 		item = "userGuimo";
			 	}
			 	
			 	guimoleibie(item);
		   		
		   		var form = document.getElementById('dataForm'); 
				var index = form.action.indexOf("?");
				if (index>0)
			  		form.action = form.action.substring(0, index);
				
				var actionWithParameter = form.action + "?part=guimo&item=" + item;
		        form.action = actionWithParameter;
		        
				form.submit();
		 	}
			
			function guimoleibie(lb) {
		
			    
			    document.getElementById("userGuimo").className = "nom";
			    document.getElementById("marketGuimo").className = "nom";
		
			    document.getElementById(lb).className = "currtitle";
			}
		 
		 	function showChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		DrawChart("chartdivz", "charts/MSLine.swf", "900", "400", DataUrl1);
		 	}
		 	
			function showCommentChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		DrawChart("chartdivcomment", "charts/MSLine.swf", "900", "400", DataUrl1);
		 	}
			
			function showGuimoChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		DrawChart("chartdivguimo", "charts/MSLine.swf", "900", "400", DataUrl1);
		 	}
		 
			function ConstructHttpString(myURL) {
			     myURL += "?rnd=" + new Date().getTime();
			     return encodeURIComponent(myURL.toString());
			}
			
			//画图(以指定 xml格式文件为数据源)  
			function DrawChart(divId,flashFileName,width,height,xmlUrl) {
			     var myChartId = new Date().getTime();
			     var myChart = new FusionCharts(flashFileName, myChartId, width, height);
			     //myChart.setDataURL("data.xml"); //获取xml格式数据源
			     myChart.setDataURL(ConstructHttpString(xmlUrl)); //获取xml格式数据源
			     myChart.addParam("wmode", "Opaque");
			     myChart.render(divId);
			     
			     /*
			     var chartDivHeightObj=document.getElementById(divId);  
					var firstObject_Chart=document.getElementById("first_Chart_Div");  
					if(firstObject_Chart){  
					    chartDivHeightObj.appendChild(firstObject_Chart);  
					} */
			 }
		 
		  	function FC_NoDataToDisplay(DOMId){
		        //If it's our required chart
		        if (DOMId=="chartID1" || DOMId=="chartID2"){
		           //Simply alert 
		           window.alert("无此数据");
		           return;
		        }else{
		        	 window.alert("有数据显示");
		        }
		    }
		</script>
		
		<script type="text/javascript">
			function showColumn2DChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		drawColumn2DChart(DataUrl1);
		 		
		 	}
			
			function drawColumn2DChart(DataUrl1){
				var myChartId = new Date().getTime();
				var chart = new FusionCharts("charts3v/Column2D.swf", myChartId, "900", "500", "0", "1" );
				
				chart.setDataURL(ConstructHttpString(DataUrl1));
				chart.addParam("wmode", "Opaque");
				chart.render("chartdivcouse");
			}
			
		</script>
		
		<script type="text/javascript">
			function showPie2DChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		drawPie2DChart(DataUrl1, "chartdivPie");
		 		
		 	}
			
			function showPie2DSexChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		drawPie2DChart(DataUrl1, "chartdivsex");
		 		
		 	}
			
			function drawPie2DChart(DataUrl1, chardiv){
				var myChartId = new Date().getTime();
				var chart = new FusionCharts("charts/Pie2D.swf", myChartId, "700", "400", "0", "1" );
				
				chart.setDataURL(ConstructHttpString(DataUrl1));
				chart.addParam("wmode", "Opaque");
				chart.render(chardiv);
			}
			
		</script>
		
		
		<script type="text/javascript">
			function init(){
				var form = document.getElementById('dataForm'); 
				var index = form.action.indexOf("?");
				if (index>0)
			  		form.action = form.action.substring(0, index);
			
				var actionWithParameter = form.action+ "?part=init&item=gsresult";
		        form.action = actionWithParameter;
				form.submit();
			}
		</script>
		
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
<body onload="init();" style="background:#2f5c93;-webkit-animation: animate-cloud 20s linear infinite; -moz-animation: animate-cloud 20s linear infinite; -ms-animation: animate-cloud 20s linear infinite; -o-animation: animate-cloud 20s linear infinite; animation: animate-cloud 20s linear infinite; width: 100%; height: auto;">

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
            	<a href="#tabs-b" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">领导人</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-c" aria-labelledby="ui-id-5" aria-selected="false">
            	<a href="#tabs-c" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">媒体指数</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-d" aria-labelledby="ui-id-6" aria-selected="false">
            	<a href="#tabs-d" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-6">产品分析</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-e" aria-labelledby="ui-id-7" aria-selected="false">
            	<a href="#tabs-e" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-7">用户数据分析</a>
            </li>
        </ul>
        <div id="tabs-a" aria-labelledby="ui-id-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false" style="display: block;">
        	<h1>Mooc学院（典型企业）分析报告</h1>
			<h3>1、公司简介</h3>
			<p style="TEXT-INDENT: 2em">
			“MOOC学院”(mooc.guokr.com) 是中文互联网内最大的MOOC学习社区，2014年4月18日由北京果壳互动科技传媒有限公司创立，公司CEO为姬十三。MOOC学院收录了主流的三大课程提供商Coursera、Udacity、edX的所有课程，并将大部分课程的课程简介翻译成中文。这里聚集了超过50%的MOOC中文用户，用户可以在MOOC学院给上过的MOOC课程点评打分，在学习的过程中和同学讨论课程问题，记录自己的上课笔记。
			
			</p>
			
			<h3>2、企业领导人</h3>
			<p style="TEXT-INDENT: 2em">
			公司领导人，姬十三，出生于1977年，果壳网创始人、CEO，神经生物学博士。姬十三自2004年起开始科学写作，先后曾在10多家媒体开设科学专栏，长期致力于推动知识传播及知识获取模式的革命，曾获上海大众科学奖、全国科普先进工作者、时尚先生年度科学传播人物等荣誉。
			
			</p>
			<p style="TEXT-INDENT: 2em">
			姬十三是一个偏技术型的年轻企业家，在公众眼球下的活动并不多，显出低调做事的实干型企业家风格。另外，根据姬十三的微博好友（前30）分析可知，其好友较为广泛，涉及到作家、演员、模特、科学研究者、投资人、创业者等等领域的人，具有较为广泛的人脉资源，社会活动能力较强。
			
			</p>
			<h3>3、企业文化和战略方向</h3>
			<p style="TEXT-INDENT: 2em">
			MOOC学院的定位是讨论，点评和记录课程，课程是属于其他平台的，MOOC学院不直接收录课程内容，只是专注于帮助学习者互相交流，发现课程。
			
			</p>
			
			<h3>4、市场表现</h3>
			<p style="TEXT-INDENT: 2em">
			截止2014年7月15日，两个多月时间内，mooc学院已有了50万用户，课程涉及98门之多，用户评分反馈良好。

			</p>
			<h3>5、总结</h3>
			<p style="TEXT-INDENT: 2em">
			Mooc学院是一家年轻化的企业，企业领导人低调实干，在产品市场方面把握比较到位，课程设计较符合用户的需求。MOOC学院的定位是讨论，点评和记录课程，适合年轻的大学生，数据也证明其受到这些人群的青睐，并发展迅速。总的来说，Mooc学院在大学生这部分市场有着较大的潜力。
			
			</p>
        </div>
        <div id="tabs-b" aria-labelledby="ui-id-4" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
       		
       		<table border="1">
       			<thead>
       				<tr>
       					<th>时间</th>
       					<th>社会经历</th>
       				</tr>
       			</thead>
       			<tbody>
       				<tr>
       					<td>1990年9月—1996年7月（5年10个月）</td>
       					<td>浙江省舟山市普陀中学</td>
       				</tr>
       				<tr>
       					<td>1996年9月—2001年7月（4年10个月）</td>
       					<td>中国科学技术大学生物学系分子与细胞生物学专业学士</td>
       				</tr>
       				<tr>
       					<td>2001年9月—2007年7月（5年10个月）</td>
       					<td>复旦大学神经生物学研究所</td>
       				</tr>
       				<tr>
       					<td>2007年—2008年</td>
       					<td>打算成为一流科学写作者的博士毕业生——受过还不错的科研训练，发表了两篇SCI，机缘巧合，走上了科学写作之路。</td>
       				</tr>
       				<tr>
       					<td>2008年</td>
       					<td>创办科学松鼠会</td>
       				</tr>
       				<tr>
       					<td>2009年</td>
       					<td>辞去一份外企工作，全职来运营科学松鼠会。</td>
       				</tr>
       				<tr>
       					<td>2010年</td>
       					<td>另组团队，创建了果壳网。</td>
       				</tr>
       				<tr>
       					<td>2011年</td>
       					<td>在果壳网发起了一个系列活动“万有青年烩”。之希望万种青年在这个平台以有趣、有味的方式来分享。</td>
       				</tr>
       				<tr>
       					<td>2014年9月13日</td>
       					<td>姬十三和Coursera中国区合作主管Eli Bildner一起发布了Coursera和MOOC学院成为战略合作伙伴后，并联合推出"MOOC校园大使"计划。</td>
       				</tr>
       			</tbody>
       		</table>
       		
       	</div>
        <div id="tabs-c" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	<div id="moonmenu" class="halfmoon" style="text-align:center;">
				<ul style=" padding-left:350px;">
					
					<li onClick="createQuxianData('sina');" id="sina" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">新浪新闻搜索度</li>
					<li onClick="createQuxianData('sohu');" id="sohu" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">搜狐新闻搜索度</li>
				</ul>
				<!-- ----- flash start ----------->
				<div id="chartdivz" align="center">
					
				</div> 
		
				<!------- flash end ----------->

			</div>
        	
        </div>
        <div id="tabs-d" aria-labelledby="ui-id-6" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	<div id="moonmenu" class="halfmoon" style="text-align:center;">
				<ul style=" padding-left:350px; margin-top: 5px; margin-bottom: 5px;">
					<li onClick="createCouseData('cn');" id="cn" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总数量</li>
					<li onClick="createCouseData('cl');" id="cl" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总浏览量</li>
					<li onClick="createCouseData('cp');" id="cp" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课评分</li>
				</ul>
				<!-- ----- flash start ----------->
				<div id="chartdivcouse" align="center"></div>
					
				<!------- flash end ----------->

			</div>
        	
        </div>
        <div id="tabs-e" aria-labelledby="ui-id-7" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	<div id="moonmenu" class="halfmoon" style="text-align:center;">
				
				<!-- ----- flash start ----------->
				<div id="chartdivcomment" align="center">
					
				</div> 
				<div id="chartdivage" align="center">
					
				</div>
				<div id="chartdivsex" align="center">
					
				</div>
				<!------- flash end ----------->

			</div>
        </div>
    </div>

	<iframe name="upload" style="display: none"></iframe>
</body>
</html>