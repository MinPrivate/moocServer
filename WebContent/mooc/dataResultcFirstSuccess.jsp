<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title></title>
<script type="text/javascript">
  
	var query = window.location.search;
	query = query.substring(1);
	
	var argsArr = new Object();
	var pairs = query.split("&");
	for(var i=0;i<pairs.length;i++)
	{
	    var sign = pairs[i].indexOf("="); 
	    //如果没有找到=号，那么就跳过，跳到下一个字符串（下一个循环）。
	    if(sign == -1)
	    {
	        continue; 
	    }
	
	    var aKey = pairs[i].substring(0,sign);
	    var aValue = pairs[i].substring(sign+1);       
	
	    argsArr[aKey] = aValue;
	}
	
	var sChartNameComment  = argsArr["sChartNameComment"];
	var sChartNamesina = argsArr["sChartNamesina"];
	var sChartNameCouseNum = argsArr["sChartNameCouseNum"];
	
	
	if(parent){
		
		parent.window.showCommentChart(sChartNameComment);
		
		parent.window.showChart(sChartNamesina);
		
		parent.window.showColumn2DChart(sChartNameCouseNum);
		
	}
 
</script>
</head>
<body>
</body>
</html>
