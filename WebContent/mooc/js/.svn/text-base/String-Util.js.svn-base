
function isEmpty(str){
   if (str == null || str == "")
   {
	   return true;
   }else{
	   return false;
   }
}

function getTest(){
	return "test";
}

function getYYYYMMDD(strDay){
	var nyr = strDay.substring(0,10);
	return nyr;
}

function getYYYYMM(strDay){
	var ny = strDay.substring(0,7);
	return ny;
}

function getYYYY(strDay){
	var n = strDay.substring(0,4);
	return n;
}

function getNowDateTime(){
	
	//var strDate = "${Util.getDate('yyyy-MM-dd HH:mm:SS')}"; //服务器时间
	//var myDate = strDate.toDateTime();
	//alert(strDate);
	
	var myDate = new Date(); //浏览器时间
	
	
	var month = myDate.getMonth() + 1;
	if (month.toString().len()==1)
		month = '0' + month;
	
	var day = myDate.getDate();
	
	if (day.toString().len() == 1) {
		day = '0' + day.toString();
	}
	
	var hh = myDate.getHours();
	if (hh.toString().len()==1)
		hh = '0' + hh;
	
	var mm = myDate.getMinutes();
	if (mm.toString().len()==1)
		mm = '0' + mm;
		
	var ss = myDate.getSeconds();
	if (ss.toString().len()==1)
		ss = '0' + ss;
    
	var date = myDate.getFullYear() + "-" + month + "-" + day;
	var time = hh + ":" + mm + ":" + ss;
	var datetime = date + " " + time;

	return datetime;
	
}

function getNowDate(){
	
	//var strDate = "${Util.getDate('yyyy-MM-dd HH:mm:SS')}"; //服务器时间
	//var myDate = strDate.toDateTime();
	
	
	var myDate = new Date();//浏览器时间
	
	
	var month = myDate.getMonth() + 1;
	if (month.toString().len()==1)
		month = '0' + month;
	
	var day = myDate.getDate();
	
	if (day.toString().len() == 1) {
		day = '0' + day.toString();
	}
	
    
	var date = myDate.getFullYear() + "-" + month + "-" + day;

	return date;
	
}

function getLaterDateFromNow(strInterval, Number){

	var myDate = new Date();//浏览器时间
	myDate = myDate.DateAdd(strInterval,Number);	

	var month = myDate.getMonth() + 1;
	if (month.toString().len()==1)
		month = '0' + month;
	
	var day = myDate.getDate();
	
	if (day.toString().len() == 1) {
		day = "0" + day.toString();
	}
    
	var date = myDate.getFullYear() + "-" + month + "-" + day;

	return date;
}

function replaceText(str , str1 , str2){
	while ( str.indexOf(str1) >=0 ){
		str = str.replace( str1 , str2);
	}
	return str;
}

String.prototype.toDate= function( ){
	var y = this.substr(0, 4);
	var m = this.substr(5, 2);
	var d = this.substr(8, 2);
	m--;
	/*
	 * var h = 0; var mm = 0; var s = 0; if (this.length > 10){ h =
	 * this.substr(11, 2); mm= this.substr(14, 2); s = this.substr(17, 2); }
	 */
	return new Date(y, m, d); // , h , mm , s
}

//yyyy-mm-dd hh:mm:ss
String.prototype.toDateTime= function( ){
	var y = this.substr(0, 4);
	var m = this.substr(5, 2);
	var d = this.substr(8, 2);
	m--;
	

	var hh = 0; var mm = 0; var ss = 0; 
	if (this.length > 10)
	{ 	
		var hh_mm_ss = this.substr(11);

		var hh = 0;
		var mm = 0;
		var ss = 0;
		var arys= hh_mm_ss.split(':');
		
		if (arys.length>0)
			hh = arys[0];
		
		if (arys.length>1)
			mm = arys[1];
		
		if (arys.length>2)
			ss = arys[2];
	}

	if (hh.toString().len() == 1) { 
			hh = "0" + hh;
	}
	
	if (mm.toString().len() == 1) { 
		mm = "0" + mm;
	}
	
	if (ss.toString().len() == 1) { 
		ss = "0" + ss;
	}

	return new Date(y, m, d , hh , mm , ss);
}

String.prototype.toTime = function(){
	
	var hh = 0;
	var mm = 0;
	var ss = 0;
	var arys= this.split(':');
	
	if (arys.length>0)
		hh = arys[0];
	
	if (arys.length>1)
		mm = arys[1];
	
	if (arys.length>2)
		ss = arys[2];
	
	if (hh.toString().len() == 1) { 
		hh = "0" + hh;
	}
	
	if (mm.toString().len() == 1) { 
		mm = "0" + mm;
	}
	
	if (ss.toString().len() == 1) { 
		ss = "0" + ss;
	}
	
	return hh + ":" + mm + ":" + ss;

}


String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g,"");
}

String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"");
}

String.prototype.rtrim = function() {
	return this.replace(/\s+$/,"");
}
/**
 * 给String扩展一个len方法, 用于获取包含非ASCII码字符的常规长度(非ASCII码算2个字符)
 */
String.prototype.len = function() {
var ascRegexp = /[^\x00-\xFF]/g;
return this.replace(ascRegexp, '..').length;
}



function trim( str ) {
	return str.replace(/^\s+|\s+$/g,"");
}

function ltrim( str ) {
	return str.replace(/^\s+/,"");
}

function rtrim( str ) {
	return str.replace(/\s+$/,"");
}
function isValidZipCode( value ) {
	if ( value.length  != 6 || isNaN(value) ){
       return false;
    }
    return true;
}

String.prototype.isDate = function() {
	if (this.length != 10)
		return false
	else
    return /^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(this) ? function(str) {
        with (RegExp) {
            var date = new Date($1, --$2, $3);
            return $1 == date.getFullYear()
                && $2 == date.getMonth()+1
                && $3 == date.getDate();
        }
    }(this) : false;
}; 

function getPYCode(str) {
    var result = "";
    
    if (isEmpty(str))
    	return result;
    
    for (var i = 0; i < str.length; i++) {
        result += getPY(str.charAt(i).toString())
    }
    return result;
}
/*获取汉字的首字母
 * */

function getPY(s) {
    if (s != "") {
        execScript("tmp=asc(\"" + s + "\")", "vbscript");
        tmp = 65536 + tmp;
        var py = "";
        if (tmp >= 45217 && tmp <= 45252) {
            py = "A";
        } else if (tmp >= 45253 && tmp <= 45760) {
            py = "B";
        } else if (tmp >= 45761 && tmp <= 46317) {
            py = "C";
        } else if (tmp >= 46318 && tmp <= 46825) {
            py = "D";
        } else if (tmp >= 46826 && tmp <= 47009) {
            py = "E";
        } else if (tmp >= 47010 && tmp <= 47296) {
            py = "F";
        } else if ((tmp >= 47297 && tmp <= 47613) || (tmp == 63193)) {
            py = "G";
        } else if (tmp >= 47614 && tmp <= 48118) {
            py = "H";
        } else if (tmp >= 48119 && tmp <= 49061) {
            py = "J"
        } else if (tmp >= 49062 && tmp <= 49323) {
            py = "K";
        } else if (tmp >= 49324 && tmp <= 49895) {
            py = "L";
        } else if (tmp >= 49896 && tmp <= 50370) {
            py = "M";
        } else if (tmp >= 50371 && tmp <= 50613) {
            py = "N"
        } else if (tmp >= 50614 && tmp <= 50621) {
            py = "O";
        } else if (tmp >= 50622 && tmp <= 50905) {
            py = "P";
        } else if (tmp >= 50906 && tmp <= 51386) {
            py = "Q";
        } else if (tmp >= 51387 && tmp <= 51445) {
            py = "R";
        } else if (tmp >= 51446 && tmp <= 52217) {
            py = "S";
        } else if (tmp >= 52218 && tmp <= 52697) {
            py = "T";
        } else if (tmp >= 52698 && tmp <= 52979) {
            py = "W";
        } else if (tmp >= 52980 && tmp <= 53688) {
            py = "X";
        } else if (tmp >= 53689 && tmp <= 54480) {
            py = "Y";
        } else if (tmp >= 54481 && tmp <= 62289) {
            py = "Z";
        } else {
            py = s.charAt(0);
            py = py.toUpperCase();
        }
        return py;
    }
}


function getNum(i){
	
	var simpleNum = new Array("\u96f6","\u4e00","\u4e8c","\u4e09", "\u56db","\u4e94","\u516d", "\u4e03", "\u516b","\u4e5d","\u5341");
	//"零，一，二，三，四，五，六，七，八，九，十";
	
	//"百：\u4f70；千：\u4edf；万：\  ；角：\u89d2；分：\u5206";
	
	var temp = (parseInt)(i);
	
	if (temp>=0 && temp<=10){
		return simpleNum[temp];
	}
	else{
		return "";
	}
	
	/*
	if (i=="1"){
		temp = "一";
	}else if (i=="2"){
		temp = "二";
	}else if (i=="3"){
		temp = "三";
	}else if (i=="4"){
		temp = "四";
	}else if (i=="5"){
		temp = "五";
	}else if (i=="6"){
		temp = "六";
	}else if (i=="7"){
		temp = "七";
	}else if (i=="8"){
		temp = "八";
	}else if (i=="9"){
		temp = "九";
	}else if (i=="10"){
		temp = "十";
	}
	
	return temp;
	*/
}

 function GetVariables(source) {
    if (source == "" || source == null)
                 return null;
                 
             // Use a RegExp object to find all variables.
             var result = new ActiveXObject("Scripting.Dictionary");
             var expVar = new RegExp("\[[a-zA-Z]+\]", "i");
             var s;
             // Find all braced variables and store in a dictionary.
             while ((s = expVar.exec(source)) != null) {
                 var key = s[0].substr(1, s[0].length - 2);
                 if (!result.Exists(key))
                     result.Add(key, "1");
                 source = source.substr(s.lastIndex);
             }
             return result;

 }
  function ReplaceVariables(source, values) {
     var a = values.Keys().toArray();
     for (var i = 0; i < values.Count; i++) {
         var key = a[i];
         var v = values.Item(key);
         var expVar = new RegExp("\\[" + key + "\\]", "ig");
         source = source.replace(expVar, v);
     }
     
     return source;
 }
  
function checkSfzh(idcard1,showMsg){
	  var idcard=trim(idcard1);// 对身份证号码做处理。去除头尾空格。
      
	   var Errors=new Array(
	   "验证通过!",   
	   "身份证号码位数不对!",   
	   "身份证号码出生日期超出范围或含有非法字符!",   
	   "身份证号码校验错误!",   
	   "身份证地区非法!"  
	   );   
	   // var
		// area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"};
	   var idcard,Y,JYM;   
	   var S,M;   
	   var idcard_array = new Array();   
	   idcard_array = idcard.split(""); 
	   /* 基本校验 */  
	   if(isEmpty(idcard))    
	   {   
	    if( isEmpty(showMsg)) {
	    	alert("身份证号为空，请输入您的身份证号!");
	    }
	    return false;
	   } 
	   /*
		 * if(area[parseInt(idcard.substr(0,2))]==null) {
		 * if(showMsg==null||showMsg=="") alert(Errors[4]);
		 * 
		 * return false; }
		 */
	   /* 身份号码位数及格式检验 */  
	   switch(idcard.length){
	    case 15:   
	    if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){   
	     ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;// 测试出生日期的合法性
	    } else {   
	     ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;// 测试出生日期的合法性
	    }   
	    if(ereg.test(idcard)){   
	      return true; // 15位验证通过
	     }
	    else {   
	      if(showMsg==null||showMsg=="") alert(Errors[2]);   
	       return false;   
	      }   
	    break;   
	       
	    case 18:   
	    // 18位身份号码检测
	    // 出生日期的合法性检查
	    // 闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
	    // 平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
	    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){   
	    ereg=/^[1-9][0-9]{5}[1-2][0-9]{3}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// 闰年出生日期的合法性正则表达式
	    } else {   
	    ereg=/^[1-9][0-9]{5}[1-2][0-9]{3}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// 平年出生日期的合法性正则表达式
	    }   
	    if(ereg.test(idcard)){// 测试出生日期的合法性
	     // 计算校验位
	     S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7   
	     + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9   
	     + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10   
	     + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5   
	     + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8   
	     + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4   
	     + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2   
	     + parseInt(idcard_array[7]) * 1    
	     + parseInt(idcard_array[8]) * 6   
	     + parseInt(idcard_array[9]) * 3 ;   
	     Y = S % 11;   
	     M = "F";   
	     JYM = "10X98765432";   
	     M = JYM.substr(Y,1);/* 判断校验位 */  
	     if(M == idcard_array[17]){   
	      // alert(Errors[0]+"18");
	      return true; /* 检测ID的校验位false; */  
	     }   
	     else {   
	      if(showMsg==null||showMsg=="") alert(Errors[3]);    
	      return false;   
	     }   
	    }   
	    else {   
	     if(showMsg==null||showMsg=="") alert(Errors[2]);    
	     return false;   
	    }   
	    break;   
	       
	    default:   
	     if(showMsg==null||showMsg=="") alert(Errors[1]);    
	     return false;   
	   }   
 }


function getBirthdayBySfzh(idCard){
   var bir = null;
   var IdCard = idCard;   

   if(IdCard.length==18){
     bir=IdCard.substr(6,4)+"-"+IdCard.substr(10,2)+"-"+IdCard.substr(12,2);
     }
   else if(IdCard.length==15){
     bir="19"+IdCard.substr(6,2)+"-"+IdCard.substr(8,2)+"-"+IdCard.substr(10,2);
   }
   return bir;
}

function getSexBySfzh(idCard){   
    var IdCard = trim(idCard);
    
    if(IdCard.length==15){   
        if(IdCard.substring(14,15)%2==0){   
            return '2';   
        }else{   
            return '1';   
        }   
    }else if(IdCard.length ==18){   
	   if(IdCard.substring(14,17)%2==0){   
            return '2';   
        }else{   
            return '1';   
        }   
    }
}

// 年龄
function getAge(birthdayValue, nowDateStr){
    var dt1 = new Date(birthdayValue.replace("-", "/"));
    
    //var nowDateStr = "${Util.getDate('yyyy-MM-dd')}";
    var nowDate = nowDateStr.toDateTime();
    
    
    //alert(nowDateStr);
    
    //alert(nowDate);
    
    //var nowDate = new Date();
    var age = nowDate.getFullYear() - dt1.getFullYear();
    var m = nowDate.getMonth() - dt1.getMonth();
    if (m < 0)
        age--; 

  return age;
}

function testSpecialChar(str , reg){
	var len = arguments.length;
	if (isEmpty(str)) return false;
	if (len == 1){
		reg = "%&'\",;=^?$";
		var re=/[%&'",;=^?$]/g;
	}else{
		var re = new RegExp("[" + reg + "]","gi") ;
	}
	
	if ( re.test(str)){
		alert("输入中不能包含[" + reg+"]等特殊字符!");
		return true;
	}else{
		return false;
	}
	
}


