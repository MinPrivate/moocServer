function createflash(fvalue, chartdiv, leibie) {

    var bg = "", caption = "", yname = "";
    var xianzhi = 0;

    if (leibie == "aqi") {
        xianzhi = 100;
        if (chartdiv == "chartdiv") {
            caption = "最近24小时空气质量指数(AQI)趋势";
        } else {
            caption = "最近一个月空气质量指数(AQI)趋势";
        }
        yname = "空气质量指数(AQI)";
    }

    if (leibie == "pm25") {
        xianzhi = 75;
        if (chartdiv == "chartdiv") {
            caption = "最近24小时PM2.5浓度趋势";
        } else {
            caption = "最近一个月PM2.5浓度趋势";
        }
        yname = "PM2.5浓度(单位：μg/m3)";
    }

    if (leibie == "pm10") {
        xianzhi = 150;
        if (chartdiv == "chartdiv") {
            caption = "最近24小时PM10浓度趋势";
        } else {
            caption = "最近一个月PM10浓度趋势";
        }
        yname = "PM10浓度(单位：μg/m3)";
    }

    if (leibie == "so2") {
        if (chartdiv == "chartdiv") {
            xianzhi = 500;
            caption = "最近24小时SO2浓度趋势";
        } else {
            xianzhi = 150;
            caption = "最近一个月SO2浓度趋势";
        }
        yname = "SO2浓度(单位：μg/m3)";
    }
    if (leibie == "no2") {
        if (chartdiv == "chartdiv") {
            xianzhi = 200;
            caption = "最近24小时NO2浓度趋势";
        } else {
            xianzhi = 80;
            caption = "最近一个月NO2浓度趋势";
        }
        yname = "NO2浓度(单位：μg/m3)";
    }
    if (leibie == "co") {
        if (chartdiv == "chartdiv") {
            xianzhi = 10;
            caption = "最近24小时CO浓度趋势";
        } else {
            xianzhi = 4;
            caption = "最近一个月CO浓度趋势";
        }
        yname = "CO浓度(单位：mg/m3)";
    }
    if (leibie == "o3") {
        if (chartdiv == "chartdiv") {
            xianzhi = 200;
            caption = "最近24小时O3浓度趋势";
        } else {
            xianzhi = 160;
            caption = "最近一个月O3浓度趋势";
        }
        yname = "O3浓度(单位：μg/m3)";
    }
    if (leibie == "aqi" || leibie == "pm25") bg = "bgImage='../images/flashimg/flash_shuoming.gif'";

    var myChart = new FusionCharts("http://download.cnpm25.cn/pm2d5/flash/Charts/Line_old.swf", "myChartId" + Math.ceil(Math.random() * 1000), "810", "300"); //
    var str = "<chart caption='" + caption + "' bgImageVAlign='bottom' logoURL='http://download.cnpm25.cn/pm2d5/images/flashimg/flash_logo.gif'  chartBottomMargin='10' bgImageHAlign='middle' showValues='1'  numVDivLines='12' canvasBorderThickness='1' baseFont='宋体' labelDisplay='Rotate' slantLabels='1' bgColor='EBEFF7'   baseFontSize ='12'   yAxisName='" + yname + "' showNames='1' decimalPrecision='0' formatNumberScale='0'>";
    str = str + "<trendLines><line startValue='" + xianzhi + "' color='0033FF' displayvalue='良(限值)' toolText='良(二级标准限值:" + xianzhi + ")' /></trendLines>"; /* xAxisName='日期' */


    str = str + fvalue + "</chart>"


    /* 如何caption="" 则隐藏flash */
    if (caption != "") {
        myChart.setDataXML(str);
        myChart.render(chartdiv);
    }
    else
    { document.getElementById(chartdiv).style.display = "none"; }
}

function leibie(lb) {

    document.getElementById("page").className = "nom";
    document.getElementById("down").className = "nom";
    document.getElementById("video").className = "nom";
    document.getElementById("rank").className = "nom";

    document.getElementById(lb).className = "currtitle";
}