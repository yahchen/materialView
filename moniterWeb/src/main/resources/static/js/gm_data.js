$(function(){
    var map = null;
    var v00="<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDMCG()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGNZDZ()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li>";

    var v11="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages111' data-toggle='collapse' class='collapsed'><span>高空测风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages111' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTF()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartFJTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v12="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages121' data-toggle='collapse' class='collapsed'><span>台风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages121' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartTFZL()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li></ul></div></li>";

    var v20="<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>美国海温格点</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartHWGD()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixHWGD()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v30="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages300' data-toggle='collapse' class='collapsed'><span>AIRS红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages300' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li><li><a href='#subPages301' data-toggle='collapse' class='collapsed'><span>IASI 红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages301' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li><li><a href='#subPages302' data-toggle='collapse' class='collapsed'><span>ATOVS业务垂直探测器卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages302' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li><li><a href='#subPages303' data-toggle='collapse' class='collapsed'><span>ASCAT洋面风卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages303' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li><li><a href='#subPages304' data-toggle='collapse' class='collapsed'><span>GPS折射率（掩星）</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages304' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li><li><a href='#subPages305' data-toggle='collapse' class='collapsed'><span>云导风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages305' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li>";

    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        $('a.bin_map').click(binMapListener);
    });

toSiteChartDMCG = function(){//地面常规观测资料
          $("#main").empty();
          $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>常规地面观测（含船舶、浮标）资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
     }
toSiteChartGNZDZ = function(){
          $("#main").empty();
          $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>国内自动站地面气象资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSURF_CH'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

}
toSiteChartGKTC = function(){
          $("#main").empty();
          $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RTEMP_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

 }
toSiteChartGKTF = function(){
         $("#main").empty();
         $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RWIND_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
}
toSiteChartFJTC = function(){
         $("#main").empty();
         $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>飞机探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
}
toSiteChartTFZL = function(){
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>其他资料>台风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
}

toGridMatrixHWGD = function(){
          $("#main").empty();
          $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>海温格点>美国海温格点>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
  }

toGridChartHWGD=function(){
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>海温格点>美国海温格点>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

}

    function binMapListener() {
        var zoom = 4;
        //初始化地图对象
        $("#customMap").html("");
        map = new T.Map('customMap');
        //设置显示地图的中心点和级别
        map.centerAndZoom(new T.LngLat(116.40969, 39.90940), zoom);
        //让所有点在视野范围内
        $.ajax({
            type: "post",
            async: true,
            url: "/getElements",
            data: "",
            dataType: "json",
            success: function(data) {
                var pointArray = new Array();
                for (var i in data.Lat){
                    var point = new T.Circle(new T.LngLat(data.Lon[i],data.Lat[i]), 1,{color:"#1493FF",weight:15,opacity:1,fillColor:"#1493FF",fillOpacity:0,lineStyle:"solid"});
                    map.addOverLay(point);    //增加点
                    pointArray[i] = new T.LngLat(data.Lon[i],data.Lat[i]);
                    _CloudCollection = new T.CloudMarkerCollection(pointArray, {
                        color: '#1493FF',
                        SizeType: TDT_POINT_SIZE_SMALL
                    })
                    var infoWin = new T.InfoWindow();
                    var sContent = "<li> </li>";
                    infoWin.setContent(sContent);
                    point.addEventListener("click", function () {
                        point.openInfoWindow(infoWin);
                    });// 将标注添加到地图中
                }
                map.addOverLay(_CloudCollection);
                $('mapDiv').html("");
            }
        });
    };
    $('a.bin_map').click(binMapListener);
});

