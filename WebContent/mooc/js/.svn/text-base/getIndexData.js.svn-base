/*
 * 函数名:getTransport
 * 功能: 根据不同的浏览器对象创建 XMLHttpRequest对象并返回，如果浏览器不支持该对象，则返回undefined.
 */
 var xmlhttp = null;
 function getHttpRequest() 
 {
   try
   {
    xmlhttp = new ActiveXObject('Msxml2.XMLHTTP');
   }
   catch(e)
   {
        try
          {
                xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
          }
          catch(e1)
          {
              xmlhttp = new XMLHttpRequest();
          }
       
   }
 }
 

 
function httpGet(url,method,data)
{
 getHttpRequest();
 xmlhttp.open(method,url +"?"+data,true);
 xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 xmlhttp.setRequestHeader("Content-Length",data.length);
 xmlhttp.onreadystatechange = callback;
 xmlhttp.send (null);
 //alert("send");
}

function callback()
{
     if(xmlhttp.readyState == 4)
     {  //alert("back: " + xmlhttp.status);
       if(xmlhttp.status == 200)
       {//alert("ok");
           //要实现的操作            
           var xmlDoc = xmlhttp.responseText;
           var data = eval(xmlDoc);
           //alert(xmlDoc);
           //ip信息
           document.getElementById("userIP").innerHTML+=data[0].userIP;
           document.getElementById("userLocation").innerHTML+=data[0].userLocation;
           document.getElementById("userISP").innerHTML+=data[0].userISP;
           document.getElementById("appUpdateTime").innerHTML+=data[0].userTime;
           document.getElementById("ISPUpdateTime").innerHTML+=data[0].userTime;
           document.getElementById("disUpdateTime").innerHTML+=data[0].userTime;
           //各应用信息
           document.getElementById("appTotal_0").innerHTML+=data[1].total;
           document.getElementById("appTotalNotes_0").innerHTML+=NetLevelNotes(data[1].total);
           document.getElementById("appTotalImg_0").src=NetLevelLogo(data[1].total);
           document.getElementById("appPage_0").innerHTML+=data[1].page;
           document.getElementById("appPageNotes_0").innerHTML+=NetLevelNotes(data[1].page);
           document.getElementById("appVideo_0").innerHTML+=data[1].video;
           document.getElementById("appVideoNotes_0").innerHTML+=NetLevelNotes(data[1].video);
           document.getElementById("appDown_0").innerHTML+=data[1].down;
           document.getElementById("appDownNotes_0").innerHTML+=NetLevelNotes(data[1].down);
           document.getElementById("appAudio_0").innerHTML+=data[1].audio;
           document.getElementById("appAudioNotes_0").innerHTML+=NetLevelNotes(data[1].audio);
           document.getElementById("appGame_0").innerHTML+=data[1].game;
           document.getElementById("appGameNotes_0").innerHTML+=NetLevelNotes(data[1].game);
           document.getElementById("appMail_0").innerHTML+=data[1].mail;
           document.getElementById("appMailNotes_0").innerHTML+=NetLevelNotes(data[1].mail);
           document.getElementById("appMsg_0").innerHTML+=data[1].msg;
           document.getElementById("appMsgNotes_0").innerHTML+=NetLevelNotes(data[1].msg);
           
           document.getElementById("appTotal_4").innerHTML+=data[2].total;
           document.getElementById("appTotalNotes_4").innerHTML+=NetLevelNotes(data[2].total);
           document.getElementById("appTotalImg_4").src=NetLevelLogo(data[2].total);
           document.getElementById("appPage_4").innerHTML+=data[2].page;
           document.getElementById("appPageNotes_4").innerHTML+=NetLevelNotes(data[2].page);
           document.getElementById("appVideo_4").innerHTML+=data[2].video;
           document.getElementById("appVideoNotes_4").innerHTML+=NetLevelNotes(data[2].video);
           document.getElementById("appDown_4").innerHTML+=data[2].down;
           document.getElementById("appDownNotes_4").innerHTML+=NetLevelNotes(data[2].down);
           document.getElementById("appAudio_4").innerHTML+=data[2].audio;
           document.getElementById("appAudioNotes_4").innerHTML+=NetLevelNotes(data[2].audio);
           document.getElementById("appGame_4").innerHTML+=data[2].game;
           document.getElementById("appGameNotes_4").innerHTML+=NetLevelNotes(data[2].game);
           document.getElementById("appMail_4").innerHTML+=data[2].mail;
           document.getElementById("appMailNotes_4").innerHTML+=NetLevelNotes(data[2].mail);
           document.getElementById("appMsg_4").innerHTML+=data[2].msg;
           document.getElementById("appMsgNotes_4").innerHTML+=NetLevelNotes(data[2].msg);
           
           document.getElementById("appTotal_10").innerHTML+=data[3].total;
           document.getElementById("appTotalNotes_10").innerHTML+=NetLevelNotes(data[3].total);
           document.getElementById("appTotalImg_10").src=NetLevelLogo(data[3].total);
           document.getElementById("appPage_10").innerHTML+=data[3].page;
           document.getElementById("appPageNotes_10").innerHTML+=NetLevelNotes(data[3].page);
           document.getElementById("appVideo_10").innerHTML+=data[3].video;
           document.getElementById("appVideoNotes_10").innerHTML+=NetLevelNotes(data[3].video);
           document.getElementById("appDown_10").innerHTML+=data[3].down;
           document.getElementById("appDownNotes_10").innerHTML+=NetLevelNotes(data[3].down);
           document.getElementById("appAudio_10").innerHTML+=data[3].audio;
           document.getElementById("appAudioNotes_10").innerHTML+=NetLevelNotes(data[3].audio);
           document.getElementById("appGame_10").innerHTML+=data[3].game;
           document.getElementById("appGameNotes_10").innerHTML+=NetLevelNotes(data[3].game);
           document.getElementById("appMail_10").innerHTML+=data[3].mail;
           document.getElementById("appMailNotes_10").innerHTML+=NetLevelNotes(data[3].mail);
           document.getElementById("appMsg_10").innerHTML+=data[3].msg;
           document.getElementById("appMsgNotes_10").innerHTML+=NetLevelNotes(data[3].msg);
           //各运营商信息
           drawISPScore(data[4].telicon,data[4].unicon,data[4].mobile,data[4].gwbn,data[4].aipu,"chartdiv");
           //各区域信息
           //alert(data[5][0].DistrictName);
           //addRow("xiang1",data[5][0].DistrictCode,data[5][0].DistrictName,data[5][0].Score);
           addTbody("xiang1",data[5],data[6]);//data[5]: 当前数据    data[6]：前一天数据
           
       }
       else
       {
            
       }      
     }
}
function drawISPScore(telicon,unicon,mobile,gwbn,aipu,divName){
	var chart = new FusionCharts("charts/Column2D.swf", "ChartId_flash", "560", "250", "0", "1" );
	var dataStringc ='<chart yAxisName="评分" caption=""  useRoundEdges="1" yAxisMinValue="0" yAxisMaxValue="100" bgColor="FFFFFF,FFFFFF" showBorder="0">\n\
		<set label="" link="n-./spDetail.jsp?ispID=2&ispName=电信" value="' + telicon + '" /> \n\
		<set label="" link="n-./spDetail.jsp?ispID=5&ispName=联通" value="' + unicon + '" /> \n\
		<set label="" link="n-./spDetail.jsp?ispID=3&ispName=铁通" value="' + mobile + '" /> \n\
		<set label="" link="n-./spDetail.jsp?ispID=1&ispName=长城宽带" value="' + gwbn + '" /> \n\
		<set label="" link="n-./spDetail.jsp?ispID=4&ispName=爱普" value="' + aipu + '" />\n\
	\n\
	</chart>';
	chart.setXMLData( dataStringc );
	chart.render(divName);
}

//function addRow(tableDiv,addressCode,addressName){
//	alert("addRow");
//	   var table = document.getElementById(tableDiv);
//	   var newRow = table.tbody.insertRow(); //创建新行
//	   var newCell1 = newRow.insertCell(); //创建新单元格
//	   var newCell2 = newRow.insertCell(); //创建新单元格
//	   newCell1.innerHTML = "123";
//	   newCell2.innerHTML = "qwe";
//	   						//单元格内的内容
//	   //newCell.setAttribute("align","center"); //设置位置
//	}

function addTbody(tableDiv,data,dataBefo){
	//alert("addTbody");
	var oTable = document.getElementById(tableDiv);
	//创建tbody 
	var oTbody = document.createElement("tbody"); 
	oTable.appendChild(oTbody); 
	 
	var rows = data.length;
	//alert("rows " + rows);
	var i = 0;
	while( i < rows){
		addRow(oTbody,data[i].DistrictCode,data[i].DistrictName,data[i].Score, dataBefo[i].Score);
		i++;
	}
	 
	
	}

function addRow(oTbody,addressCode,addressName,score,scoreBefo){
	//alert("addRow");
	//var oTable = document.getElementById(tableDiv);
	//创建tbody 
//	var oTbody = document.createElement("tbody"); 
//	oTable.appendChild(oTbody); 
	 
	//创建链接
    var address = "./districtDetail.jsp?addressCode=" + addressCode + "&addressName=" + addressName;
    var node = document.createElement('a');
    node.setAttribute('href', address);
    node.setAttribute('target', '_blank');
    var text = document.createTextNode(addressName);
    node.appendChild(text);
    //创建图片
    var imgurldown = "./images/down.png";
    var imgdown = document.createElement('img');
    imgdown.setAttribute('src', imgurldown);
    
    var imgurlup = "./images/up.png";
    var imgup = document.createElement('img');
    imgup.setAttribute('src', imgurlup);
    
	
	//创建表格的第一行 
	var oTR_1 = document.createElement("tr"); 
	oTbody.appendChild(oTR_1); 
	 
	var oTD_11 = document.createElement("td");
	oTD_11.appendChild(node); 
	oTR_1.appendChild(oTD_11); 
	var oTD_21 = document.createElement("td"); 
	oTD_21.appendChild(document.createTextNode(score));
	if(parseInt(score) < parseInt(scoreBefo)){
		oTD_21.appendChild(imgdown);
	}else{
		oTD_21.appendChild(imgup);
	}
	oTR_1.appendChild(oTD_21); 
	 
	
	}

function NetLevelNotes(iScore){
	var level = "";
	if(iScore >= 90){
		level = "请尽情享受信息新生活！";
	}else if(iScore >= 80){
		level = "畅游网络，一路畅通无阻！";
	}else if(iScore >= 70){
		level = "请注意，您的网络可能有时会卡额！";
	}else if(iScore >= 60){
		level = "基本满足需求，要想更出众，可考虑升级宽带！";
	}else{
		level = "赶紧升级宽带，奔小康吧！";
	}
	return level;
}

var levelCycle = "./images/level/cycle.png";
var levelMoto = "./images/level/moto.png";
var levelCar = "./images/level/car.gif";
var levelAirplane = "./images/level/airplane.png";
var levelRocket = "./images/level/rocket.png";

function NetLevelLogo(iScore){
	var levelLogo = "";
	if(iScore >= 90){
		levelLogo = levelRocket;
	}else if(iScore >= 80){
		levelLogo = levelAirplane;
	}else if(iScore >= 70){
		levelLogo = levelCar;
	}else if(iScore >= 60){
		levelLogo = levelMoto;
	}else{
		levelLogo = levelCycle;
	}
	return levelLogo;
}