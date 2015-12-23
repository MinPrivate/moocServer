
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>MOOC相关曲线</title>
		<link rel="Shortcut Icon" type="image/ico" href="./images/mooc_logo.ico">

		<style type="text/css" media="screen">object.FusionCharts:focus, embed.FusionCharts:focus {outline: none}</style>
		
		<link rel="stylesheet" type="text/css" href="./css/halfmoontabs.css">
		<script language="JavaScript" type="text/javascript" src="./js/sort.js"></script> 
		<script language="JavaScript" type="text/javascript" src="./charts/FusionCharts.js"></script>
		<script language="JavaScript" type="text/javascript" src="./js/data1.js"></script> 
		
		<script type="text/javascript" src="js/flashCheck.js"></script>
		
        <script src="./js/String-Util.js"></script>
        
        
        <script language="JavaScript" type="text/javascript" src="./js/data.js"></script>
		
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
			 		item = "client";
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
		
			    document.getElementById("client").className = "nom";
			    document.getElementById("sina").className = "nom";
			    document.getElementById("sohu").className = "nom";
		
			    document.getElementById(lb).className = "currtitle";
			}
		 
		 	function showChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		DrawChart("chartdivz", "charts/MSLine.swf", "900", "400", DataUrl1);
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
				chart.render("chartdiv");
			}
			
		</script>
		
		<script type="text/javascript">
			function showPie2DChart(DataUrl1){
				
		 		DataUrl1 = "./data/" + DataUrl1;
		 		
		 		drawPie2DChart(DataUrl1);
		 		
		 	}
			
			function drawPie2DChart(DataUrl1){
				var myChartId = new Date().getTime();
				var chart = new FusionCharts("charts/Pie2D.swf", myChartId, "700", "400", "0", "1" );
				
				chart.setDataURL(ConstructHttpString(DataUrl1));
				chart.addParam("wmode", "Opaque");
				chart.render("chartdivPie");
			}
			
		</script>
		
		
		<script type="text/javascript">
			function init(){
				
				var form = document.getElementById('dataForm'); 
				var index = form.action.indexOf("?");
				if (index>0)
			  		form.action = form.action.substring(0, index);
			
				var actionWithParameter = form.action+ "?part=init&item=all";
		        form.action = actionWithParameter;
				form.submit();
				
			}
		</script>
		
		
	</head>
	
	<body onload="init();">
		<iframe frameborder="0" style="display: none;"></iframe>
		<form id="dataForm" name="dataForm" target="upload" method="post" enctype="multipart/form-data"
			action="<%=request.getContextPath()%>/ChartData" >
		</form>
		
		<center>
			<div id="header">

  				<table width="100%" border="0">
					<tbody>
    					<tr class="space">
    					</tr>
    					<tr>
      						<td colspan="2" valign="top">
      							<table width="100%" border="0">
        							<tbody>
										<tr class="space"></tr>
        								<tr>
        									<td colspan="2" valign="top" class="warp" bgcolor="#f5f7fb">
	        									<table width="100%">
	        										<tbody>
	        											
														<tr>
				        									<td width="60%" align="center" class="warp" valign="top" bgcolor="#f5f7fb">
					          									
																<!-- ----- flash start ----------->
																<div style=" background-color:#f5f7fb; margin-top:-10px; border:0px solid #99b0da; width:100%; background-image:url()">
																	
																	<!--饼状图 开始-->
																	<div id="moonmenu" class="halfmoon" style="text-align:center;">
																		<ul style=" padding-left:500px; margin-top: 5px; margin-bottom: 5px;">
																			<li onClick="createCouseData('cn');" id="cn" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总数量</li>
																			<li onClick="createCouseData('cl');" id="cl" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总浏览量</li>
																			<li onClick="createCouseData('cp');" id="cp" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课评分</li>
																		</ul>
																		<!-- ----- flash start ----------->
																		<div id="chartdivPie" align="center"></div>
																			
					  													<!------- flash end ----------->
					
					  												</div>	
																    
																	
																	
																</div>
																<!------- flash end ----------->
																
															</td>
														</tr>
													</tbody>
												</table>
											</td>
												
        								</tr>
        								
        								<tr class="space"></tr>
        								<tr>
        									<td colspan="2" valign="top" class="warp" bgcolor="#f5f7fb">
	        									<table width="100%">
	        										<tbody>
	        											
														<tr>
				        									<td width="60%" align="center" class="warp" valign="top" bgcolor="#f5f7fb">
					          									
																<!-- ----- flash start ----------->
																<div style=" background-color:#f5f7fb; margin-top:-10px; border:0px solid #99b0da; width:100%; background-image:url()">
																	
																	<!--柱状图 开始-->
																	<div id="moonmenu" class="halfmoon" style="text-align:center;">
																		<ul style=" padding-left:500px; margin-top: 5px; margin-bottom: 5px;">
																			<li onClick="createCouseData('cn');" id="cn" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总数量</li>
																			<li onClick="createCouseData('cl');" id="cl" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课总浏览量</li>
																			<li onClick="createCouseData('cp');" id="cp" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">公开课评分</li>
																		</ul>
																		<!-- ----- flash start ----------->
																		<div id="chartdiv" align="center"></div>
																			
					  													<!------- flash end ----------->
					
					  												</div>	
																    
																	
																	
																</div>
																<!------- flash end ----------->
																
															</td>
														</tr>
													</tbody>
												</table>
											</td>
												
        								</tr>
        								
        								<tr class="space"></tr>
        								
        								<tr height="230px">
          									<td colspan="2" align="center" class="warp" valign="top" bgcolor="#f5f7fb">
												<!--part 1-->
												
          										<br>
												<div id="moonmenu" class="halfmoon" style="text-align:center;">
													<ul style=" padding-left:500px;">
														<li onClick="createQuxianData('client');" id="client" style="cursor: pointer;" class="currtitle" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">客户参与度</li>
														<li onClick="createQuxianData('sina');" id="sina" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">新浪新闻搜索度</li>
														<li onClick="createQuxianData('sohu');" id="sohu" style="cursor: pointer;" class="nom" onMouseOver="this.style.backgroundColor=&#39;#BFC5FA&#39;" onMouseOut="this.style.backgroundColor=&#39;&#39;">搜狐新闻搜索度</li>
													</ul>
													<!-- ----- flash start ----------->
													<div id="chartdivz" align="center">
														
													</div> 
													
  													<!------- flash end ----------->

  												</div>
												<!--part 2 end-->
											</td>
										</tr>
										
        							</tbody>
        						</table>
        					</td>
        				</tr>
        			</tbody>
        		</table>
  				<!-- footer -->
				
				<!-- END footer -->
			</div>
		</center> 
		<iframe name="upload" style="display: none"></iframe>
	</body>
</html>