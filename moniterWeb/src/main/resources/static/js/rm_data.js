$(function(){
    var map = null;
    var v00="<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDMCG2()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' class='bin_map' name='RM_RSURF_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse'><ul class='nav'><li><a href='#' onclick='toSiteChartGNZDZ2()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' class='bin_map' name='RM_RSURF_CH'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v11="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTC2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map' name='RM_RTEMP_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages111' data-toggle='collapse' class='collapsed'><span>高空测风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages111' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTF2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map' name='RM_RWIND_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartFJTC2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map' name='RM_RSING_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v20="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages201' data-toggle='collapse' class='collapsed'><span>云导风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages201' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartYDF2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li>";

    var v21="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages210' data-toggle='collapse' class='collapsed'><span>GPS可降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages210' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGPS2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";

    var v22="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages220' data-toggle='collapse' class='collapsed'><span>多普勒雷达文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages220' class='collapse'><ul class='nav'><li><a href='#' onclick='toSiteChartDPL2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";

    var v23="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages230' data-toggle='collapse' class='collapsed'><span>风廓线资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages230' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartFKX2()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";

    var v30 = "<li><a data-toggle='collapse'><i class='lnr lnr-layers'></i><span>用户日志</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";


    toSiteChartDMCG2 = function(){//地面常规观测资料
              $("#main").empty();
              $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>常规地面观测（含船舶、浮标）资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=RM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
         }
    toSiteChartGNZDZ2 = function(){
              $("#main").empty();
              $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>国内自动站地面气象资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=RM_RSURF_CH'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSiteChartGKTC2 = function(){
              $("#main").empty();
              $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=RM_RTEMP_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

     }
    toSiteChartGKTF2 = function(){
             $("#main").empty();
             $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=RM_RWIND_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartFJTC2 = function(){
             $("#main").empty();
             $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>飞机探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=RM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartYDF2 = function(){
            $("#main").empty();
            $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>云导风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/file_chart_view?data_logo=RM_R2CWE_CLOUD'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartGPS2=function(){
            $("#main").empty();
            $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>GPS资料>GPS可降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/file_chart_view?data_logo=RM_GPS_MET'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSiteChartDPL2 = function(){
            $("#main").empty();
            $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>雷达资料>多普勒雷达文件资料>折线图</h3><div class='panel'><iframe id='iframe' src='/file_chart_view?data_logo=RM_RDRPL_QC'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartFKX2=function(){
            $("#main").empty();
            $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>风廓线资料>风廓线资料>折线图</h3><div class='panel'><iframe id='iframe' src='/file_chart_view?data_logo=RM_RWPRD_HOUR'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    //行为记录
    toBehaviorRecord=function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>用户日志>行为记录</h3><div class='panel'><iframe id='iframe' src='/behavior_record_view?mode_type=2' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        $('a.bin_map').click(binMapListener);
        $('#binMapQuery').click(binMapListener);
    });
    $('#dataType').change(function() {
        var dataType = $("#dataType option:selected").val();
        if(dataType == "无")
            return;
        $.ajax({
            type: "post",
            async: true,
            url: "/getQualiteTypes",
            data: {
                dataType:dataType,
            },
            dataType: "json",
            success: function(data) {
                var options = "<option value=''>无</option>";
                for(i in data){
                    var qc = data[i].quality_code_comment
                    if(qc == "")
                        qc = data[i].quality_code
                    if(qc == "")
                        continue
                    options += "<option value=" +  data[i].quality_code + ">" + qc + "</option>"
                }
                $("#qualiteType").html("");
                $("#qualiteType").attr("disabled",false);
                $("#qualiteType").append(options);
            }
        });
    });
    $("#binMapQuery").click(binMapListener);
    function binMapListener(event) {
        var dataTypeName = event.target.getAttribute('name');
        if(null != dataTypeName && "" != dataTypeName){
            var options = "<option value=" +  dataTypeName + ">" + dataTypeName + "</option>";
            var dataTypeSel = $("#dataType");
            dataTypeSel.html("");
            dataTypeSel.append(options);
            dataTypeSel.attr("disabled",false);
            //$("#dataType").attr("disabled",false);
            dataTypeChange();
        }
        var dataType = $("#dataType option:selected").val();
        var qualiteType = $("#qualiteType option:selected").val();
        var startTime = $("#start").val();
        if(qualiteType == undefined || qualiteType == "")
            return
        $('.binMapChoice').show();
        var zoom = 4;
        //初始化地图对象
        $("#customMap").html("");
        map = new T.Map('customMap');
        //设置显示地图的中心点和级别
        map.centerAndZoom(new T.LngLat(116.40969, 39.90940), zoom);
        map.removeEventListener("moveend", MapMoveend);
        map.addEventListener("moveend", MapMoveend);
        var llb = map.getBounds();
        //让所有点在视野范围内
        $.ajax({
            type: "post",
            async: true,
            url: "/getElements",
            data: {
                dataType: dataType,
                qualiteType: qualiteType,
                startTime:startTime,
                neLon:llb.getNorthEast().getLng(),
                neLat:llb.getNorthEast().getLat(),
                swLon:llb.getSouthWest().getLng(),
                swLat:llb.getSouthWest().getLat()
            },
            dataType: "json",
            success: function(data) {
                var dotColor = "#999999";
                for (var ki in data){
                    var binMap = data[ki];
                    if((binMap[qt]==0 || binMap[qt]==3 || binMap[qt]==4))
                        dotColor = "#00FF66";
                    var point = new T.Circle(new T.LngLat(binMap['lon'],binMap['lat']), 1,{color:dotColor,weight:15,opacity:1,fillColor:dotColor,fillOpacity:0,lineStyle:"solid"});
                    map.addOverLay(point);    //增加点
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>tem:</span>" + binMap['tem'] + "</li>"
                        + "<li>" + "<span>prs:</span>" + binMap['prs'] + "</li>"
                        + "<li>" + "<span>dpt:</span>" + binMap['dpt'] + "</li>"
                        + "<li>" + "<span>pre_1h:</span>" + binMap['pre_1h'] + "</li>"
                        + "<li>" + "<span>tem_max:</span>" + binMap['tem_max'] + "</li>"
                        + "<li>" + "<span>tem_min:</span>" + binMap['tem_min'] + "</li>"
                        +"</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var point = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent,{offset:new T.Point(0,-30)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin,point); //开启信息窗口
                    });// 将标注添加到地图中
                }
            }
        });
    };
    $('a.bin_map').click(binMapListener);
    function MapMoveend(e) {
        var dataType = $("#dataType option:selected").val();
        var qualiteType = $("#qualiteType option:selected").val();
        if(qualiteType == undefined || qualiteType == "")
            return
        var startTime = $("#start").val();
        $('.binMapChoice').show();
        //让所有点在视野范围内
        var llb = map.getBounds();
        $.ajax({
            type: "post",
            async: true,
            url: "/getElements",
            data: {
                dataType: dataType,
                qualiteType: qualiteType,
                startTime:startTime,
                neLon:llb.getNorthEast().getLng(),
                neLat:llb.getNorthEast().getLat(),
                swLon:llb.getSouthWest().getLng(),
                swLat:llb.getSouthWest().getLat()
            },
            dataType: "json",
            success: function (data) {
                var dotColor = "#999999";
                for (var ki in data) {
                    var binMap = data[ki];
                    if((binMap[qt]==0 || binMap[qt]==3 || binMap[qt]==4))
                        dotColor = "#00FF66";
                    var point = new T.Circle(new T.LngLat(binMap['lon'], binMap['lat']), 1, {
                        color: dotColor,
                        weight: 15,
                        opacity: 1,
                        fillColor: dotColor,
                        fillOpacity: 0,
                        lineStyle: "solid"
                    });
                    map.addOverLay(point);    //增加点
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>tem:</span>" + binMap['tem'] + "</li>"
                        + "<li>" + "<span>prs:</span>" + binMap['prs'] + "</li>"
                        + "<li>" + "<span>dpt:</span>" + binMap['dpt'] + "</li>"
                        + "<li>" + "<span>pre_1h:</span>" + binMap['pre_1h'] + "</li>"
                        + "<li>" + "<span>tem_max:</span>" + binMap['tem_max'] + "</li>"
                        + "<li>" + "<span>tem_min:</span>" + binMap['tem_min'] + "</li>"
                        + "</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var point = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent, {offset: new T.Point(0, -30)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin, point); //开启信息窗口
                    });// 将标注添加到地图中
                }
            }
        });
    }

});