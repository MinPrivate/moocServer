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
				chart.render("chartdivage");
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
			
				var actionWithParameter = form.action+ "?part=init&item=hyresult";
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
            	<a href="#tabs-b" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-4">规模</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-c" aria-labelledby="ui-id-5" aria-selected="false">
            	<a href="#tabs-c" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-5">市场分布</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-d" aria-labelledby="ui-id-6" aria-selected="false">
            	<a href="#tabs-d" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-6">媒体指数</a>
            </li>
            <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="tabs-e" aria-labelledby="ui-id-7" aria-selected="false">
            	<a href="#tabs-e" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-7">用户数据分析</a>
            </li>
        </ul>
        <div id="tabs-a" aria-labelledby="ui-id-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="true" aria-hidden="false" style="display: block;">
        	<h1>在线教育行业报告</h1>
			<h3>1、概念特点</h3>
			<p style="TEXT-INDENT: 2em">
			在线教育，也称为远程教育、e-learning，它结合了互联网技术与传统教育方式，具有学习时空灵活性、学习时间碎片化、和学习范围广泛化的特点。
			
			</p>
			
			<h3>2、市场规模</h3>
			<p style="TEXT-INDENT: 2em">
			在线教育并不是一个新概念，其已有近10年的历史，但国内对在线教育这个概念比较关注还得从2008年开始。
			</p>
			<p style="TEXT-INDENT: 2em">
			在线教育的国内用户规模从08年到14年间，在线教育用户人数高速增长，现已到达7000多万人，市场规模从300亿元迅速增长到近1000亿的规模。未来无论从用户规模还是市场规模，均将保持高速增长水平，可见在线教育正处于大规模快速发展期，市场前景比较看好。
			
			</p>
			<h3>3、市场分布</h3>
			<p style="TEXT-INDENT: 2em">
			在线教育目前已涉及到各个方面，包括高等教育外、K12教育（指幼儿园到高中的基础教育）、各类学前教育、在线语言类、职业教育、各类培训、其它教育等细分领域。
			</p>
			
			<h3>4、主要企业</h3>
			<p style="TEXT-INDENT: 2em">
			根据从百度指数抓取的数据以及官方公布的数据，得出在线教育行业前20企业的得分排名以及用户关注度排名，如下表：
				排名	平台名称	总分
				1	网易公开课	8.925
				2	新东方在线	8.715
				3	中华会计网校	8.035
				4	网易云课堂	7.905
				5	沪江网校	7.865
				6	e学大	7.505
				7	学而思网校	7.515
				8	猿题库	7.6
				9	51talk	7.58
				10	极客学院	7.38
				11	学习宝	7.495
				12	邢帅教育	7.455
				13	北京四中网校	7.35
				14	TutorGROUP	7.225
				15	101网校	7.465
				16	91外教网	7.435
				17	魔方格	7.35
				18	YY教育	7.23
				19	超级课程表	7.365
				20	新浪公开课	7.175

			</p>
			<p style="TEXT-INDENT: 2em">
			在线教育排名前20的企业平台中，高学历教育（网易公开课等）以及培训课程（新东方等）比较热门，且占有较大比重；各大平台得分情况相差并不大。另外，近30天的百度搜索指数排名和综合排名有一定的出入，说明各大企业并没有形成绝对垄断的形式，在线教育平台市场竞争激烈，同时这也有利于整个行业的健康发展。
			</p>
			<h3>5、媒体关注度</h3>
			<p style="TEXT-INDENT: 2em">
			在线教育起源很早，但是在近两年才慢慢进入媒体视野，特别是2013年年低和2014年，该行业关注度几乎是一个爆炸式的增长。说明当前，在线教育正处于比较热门的状态，大家对其关注度也特别高；但从2014年整年来看，从年初到年底的并无多大增长，并且可以从曲线上预测，到2015年，媒体关注度应该不会有较大的增长，说明公众对在线教育慢慢回归理性，渡过了新事物的成长爆发期，也说明在线教育的发展不可盲目跟风，各大平台也应该回归理性。
			</p>
			<h3>6、用户特点</h3>
			<p style="TEXT-INDENT: 2em">
			2014年在线教育的用户主要以男性为主，占比高达86%，女性仅占14%；另外，从年龄上来看，这些用户大多在20岁到40岁之间，人群偏年轻化，这部分人一般是大学生和职工，他们熟悉互联网，易接受新事物，对知识技能需求较高。
			</p>
			<h3>7、总结</h3>
			<p style="TEXT-INDENT: 2em">
			首先，在线教育行业是随着互联网而诞生的一个新兴行业，其市场规模在近年迅速扩大，产生了一大批包括网易公开课、新东方在线、中华会计网校、网易云课堂、沪江网校、e学大等平台，行业企业间竞争较为激烈。其次，产品覆盖高等教育、k12、职业教育等各大细分市场，但仍以高等教育为主。由于在线教育与互联网技术结合的特点，该行业用户大多在20到40岁之间，呈现年轻化特点；另外，该行业的男性用户远多于女性用户。自13年年底以来，在线教育被广泛关注，其关注增长度远高于其市场规模增长率，说明该行业存在着较大的增长空间，该行业总体情况看好，市场格局存在较大的可能性。
			</p>
        </div>
        <div id="tabs-b" aria-labelledby="ui-id-4" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
       		<div id="moonmenu" class="halfmoon" style="text-align:center;">
				<ul style=" padding-left:350px;">
					
					<li onClick="createGuimoData('userGuimo');" id="userGuimo" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">行业用户规模</li>
					<li onClick="createGuimoData('marketGuimo');" id="marketGuimo" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">行业市场规模</li>
				</ul>
				<!-- ----- flash start ----------->
				<div id="chartdivguimo" align="center">
					
				</div> 
		
				<!------- flash end ----------->

			</div>
       		
       		
       	</div>
        <div id="tabs-c" aria-labelledby="ui-id-5" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
        	<div id="moonmenu" class="halfmoon" style="text-align:center;">
				
				<!-- ----- flash start ----------->
				<div id="chartdivPie" align="center">
					
				</div> 
		
				<!------- flash end ----------->

			</div>
			
			<table border="1" style="width: 72%; margin-left: 135px; text-align: center;">
       			<thead>
       				<tr>
       					<th>公司名称</th>
       					<th>排名</th>
       				</tr>
       			</thead>
       			<tbody>
       				<tr>
       					<td>网易公开课</td>
       					<td>1</td>
       				</tr>
       				<tr>
       					<td>新东方在线</td>
       					<td>2</td>
       				</tr>
       				<tr>
       					<td>中华会计网校</td>
       					<td>3</td>
       				</tr>
       				<tr>
       					<td>网易云课堂</td>
       					<td>4</td>
       				</tr>
       				<tr>
       					<td>沪江网校</td>
       					<td>5</td>
       				</tr>
       				<tr>
       					<td>e学大</td>
       					<td>6</td>
       				</tr>
       				<tr>
       					<td>学而思网校</td>
       					<td>7</td>
       				</tr>
       				<tr>
       					<td>猿题库</td>
       					<td>8</td>
       				</tr>
       				<tr>
       					<td>51talk</td>
       					<td>9</td>
       				</tr>
       				<tr>
       					<td>极客学院</td>
       					<td>10</td>
       				</tr>
       				<tr>
       					<td>学习宝</td>
       					<td>11</td>
       				</tr>
       				<tr>
       					<td>邢帅教育</td>
       					<td>12</td>
       				</tr>
       				<tr>
       					<td>北京四中网校</td>
       					<td>13</td>
       				</tr>
       				<tr>
       					<td>TutorGROUP</td>
       					<td>14</td>
       				</tr>
       				<tr>
       					<td>101网校</td>
       					<td>15</td>
       				</tr>
       				<tr>
       					<td>91外教网</td>
       					<td>16</td>
       				</tr>
       				<tr>
       					<td>魔方格</td>
       					<td>17</td>
       				</tr>
       				<tr>
       					<td>YY教育</td>
       					<td>18</td>
       				</tr>
       				<tr>
       					<td>超级课程表</td>
       					<td>19</td>
       				</tr>
       				<tr>
       					<td>新浪公开课</td>
       					<td>20</td>
       				</tr>
       			</tbody>
       		</table>
        </div>
        <div id="tabs-d" aria-labelledby="ui-id-6" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
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
			<table border="1" style="width: 93%; margin-left: 35px; text-align: center;">
       			<thead>
       				<tr>
       					<th>公司名称</th>
       					<th>近30天百度搜索指数</th>
       				</tr>
       			</thead>
       			<tbody>
       				<tr>
       					<td>网易公开课</td>
       					<td>7203</td>
       				</tr>
       				<tr>
       					<td>新东方在线</td>
       					<td>63582</td>
       				</tr>
       				<tr>
       					<td>中华会计网校</td>
       					<td>16313</td>
       				</tr>
       				<tr>
       					<td>网易云课堂</td>
       					<td>2759</td>
       				</tr>
       				<tr>
       					<td>沪江网校</td>
       					<td>2149</td>
       				</tr>
       				<tr>
       					<td>e学大</td>
       					<td>203</td>
       				</tr>
       				<tr>
       					<td>学而思网校</td>
       					<td>3980</td>
       				</tr>
       				<tr>
       					<td>猿题库</td>
       					<td>5323</td>
       				</tr>
       				<tr>
       					<td>51talk</td>
       					<td>1370</td>
       				</tr>
       				<tr>
       					<td>极客学院</td>
       					<td>1340</td>
       				</tr>
       				<tr>
       					<td>学习宝</td>
       					<td>8027</td>
       				</tr>
       				<tr>
       					<td>邢帅教育</td>
       					<td>743</td>
       				</tr>
       				<tr>
       					<td>北京四中网校</td>
       					<td>1318</td>
       				</tr>
       				<tr>
       					<td>TutorGROUP</td>
       					<td>102</td>
       				</tr>
       				<tr>
       					<td>101网校</td>
       					<td>638</td>
       				</tr>
       				<tr>
       					<td>91外教网</td>
       					<td>426</td>
       				</tr>
       				<tr>
       					<td>魔方格</td>
       					<td>6398</td>
       				</tr>
       				<tr>
       					<td>YY教育</td>
       					<td>479</td>
       				</tr>
       				<tr>
       					<td>超级课程表</td>
       					<td>6119</td>
       				</tr>
       				<tr>
       					<td>新浪公开课</td>
       					<td>655</td>
       				</tr>
       			</tbody>
       		</table>
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