$(function () {
    var map = null;
    var v00 = "<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDMCG()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' onclick='toDistributionCurveDMCG()' class='bin_map' name='GM_RSURF_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGNZDZ()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' class='bin_map' name='GM_RSURF_CH'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v11 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages111' data-toggle='collapse' class='collapsed'><span>高空测风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages111' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a  href='#' onclick='toSiteChartFJTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v12 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages121' data-toggle='collapse' class='collapsed'><span>台风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages121' class='collapse '><ul class='nav'><li><a  href='#' onclick='toSiteChartTFZL()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li></ul></div></li>";

    var v20 = "<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>美国海温格点</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartHWGD()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixHWGD()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v30 = "<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages300' data-toggle='collapse' class='collapsed'><span>AIRS红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages300' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartAIRS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapAIRS()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_AIRS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages301' data-toggle='collapse' class='collapsed'><span>IASI 红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages301' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartIASI()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapIASI()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_IASI_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages302' data-toggle='collapse' class='collapsed'><span>ATOVS业务垂直探测器卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages302' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartATOVS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapATOVS()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map'  name='bin_ATOVS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages303' data-toggle='collapse' class='collapsed'><span>ASCAT洋面风卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages303' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartASCAT()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapASCAT()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_ASCAT_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages304' data-toggle='collapse' class='collapsed'><span>GPS折射率（掩星）</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages304' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartGPS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapGPS()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_GPS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages305' data-toggle='collapse' class='collapsed'><span>云导风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages305' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartYDF()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapYDF()'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_YDF_map'>轨迹图</span></a></li></ul></div></li>";

    var v40 = "<li><a data-toggle='collapse'><i class='lnr lnr-layers'></i><span>用户日志</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    toSiteChartDMCG = function () {//地面常规观测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>常规地面观测（含船舶、浮标）资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartGNZDZ = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>国内自动站地面气象资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSURF_CH'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSiteChartGKTC = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RTEMP_GL'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSiteChartGKTF = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RWIND_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartFJTC = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>飞机探测资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartTFZL = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>其他资料>台风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixHWGD = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>海温格点>美国海温格点>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_gm_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridChartHWGD = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>海温格点>美国海温格点>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartAIRS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>AIRS红外高光谱卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartIASI = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>IASI红外高光谱卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_RSATE_IASI'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartATOVS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>ATOVS业务垂直探测器卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_RATVC_ATOVS'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartASCAT = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>ASCAT洋面风卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_RSATE_ASCAT'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartGPS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>GPS折射率（掩星）>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSateFileChartYDF = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>云导风资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_R2CWE_CLOUDL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
//行为记录
    toBehaviorRecord = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>用户日志>行为记录</h3><div class='panel'><iframe id='iframe' src='/behavior_record_view?mode_type=1' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapAIRS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>AIRS红外高光谱卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapIASI = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>IASI红外高光谱卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_RSATE_IASI'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapATOVS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>ATOVS业务垂直探测器卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_RATVC_ATOVS'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapASCAT = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>ASCAT洋面风卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_RSATE_ASCAT'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapGPS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>GPS折射率（掩星）>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSateFileMapYDF = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>云导风资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_R2CWE_CLOUDL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toDistributionCurveDMCG = function () {//地面常规观测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>常规地面观测（含船舶、浮标）资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }


    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        $('a.bin_map').click(binMapListener);
        $('#binMapQuery').click(binMapListener);
        $('span.bin_satellite_map').click(binSatelliteMapListener);
        //$("#dataType").attr("disabled",true);
    });

    function dataTypeChange() {
        var dataType = $("#dataType option:selected").val();
        if (dataType == "无")
            return;
        $.ajax({
            type: "post",
            async: true,
            url: "/getQualiteTypes",
            data: {
                dataType: dataType,
            },
            dataType: "json",
            success: function (data) {
                var options = "<option value=''>无</option>";
                for (i in data) {
                    var qc = data[i].quality_code_comment
                    if (qc == "")
                        qc = data[i].quality_code
                    if (qc == "")
                        continue
                    options += "<option value=" + data[i].quality_code + ">" + qc + "</option>"
                }
                $("#qualiteType").html("");
                $("#qualiteType").append(options);
                $("#qualiteType").attr("disabled", false);
            }
        });
    };
    $('#binMapQuery').click(binMapListener);

    function binMapListener(event) {
        $("#bin_map_div").show();
        $("#bin_satellite_map_div").hide();
        var dataTypeName = event.target.getAttribute('name');
        if (null != dataTypeName && "" != dataTypeName) {
            var options = "<option value=" + dataTypeName + ">" + dataTypeName + "</option>";
            var dataTypeSel = $("#dataType");
            dataTypeSel.html("");
            dataTypeSel.append(options);
            dataTypeSel.attr("disabled", false);
            //$("#dataType").attr("disabled",false);
            dataTypeChange();
        }
        var dataType = $("#dataType option:selected").val();
        var qualiteType = $("#qualiteType option:selected").val();
        var prs = $("#prs option:selected").val();
        var startTime = $("#start").val();
        if (qualiteType == undefined || qualiteType == "")
            return
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
                startTime: startTime,
                neLon: llb.getNorthEast().getLng(),
                neLat: llb.getNorthEast().getLat(),
                swLon: llb.getSouthWest().getLng(),
                swLat: llb.getSouthWest().getLat(),
                prs: prs
            },
            dataType: "json",
            success: function (data) {
                var dotColor = "#999999";
                var qt = qualiteType.toLocaleLowerCase();
                for (var ki in data) {
                    var binMap = data[ki];
                    if ((binMap[qt] == 0 || binMap[qt] == 3 || binMap[qt] == 4))
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
                    var prsv = binMap['prs'];
                    var prs_hwc = (prsv == undefined || prsv == "") ? binMap['prs_hwc'] : prsv;
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>tem:</span>" + binMap['tem'] + "</li>"
                        + "<li>" + "<span>prs:</span>" + prs_hwc + "</li>"
                        + "<li>" + "<span>dpt:</span>" + binMap['dpt'] + "</li>"
                        + "<li>" + "<span>q_tem:</span>" + binMap['q_tem'] + "</li>"
                        + "<li>" + "<span>q_dpt:</span>" + binMap['q_dpt'] + "</li>"
                        + "</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var point1 = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent, {offset: new T.Point(0, -30)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin, point1); //开启信息窗口
                    });// 将标注添加到地图中
                }
            }
        });
    };
    $('a.bin_map').click(binMapListener);

    function MapMoveend(e) {
        $("#bin_map_div").show();
        $("#bin_satellite_map_div").hide();
        var dataType = $("#dataType option:selected").val();
        var qualiteType = $("#qualiteType option:selected").val();
        if (qualiteType == undefined || qualiteType == "")
            return
        var startTime = $("#start").val();
        var prs = $("#prs option:selected").val();
        //让所有点在视野范围内
        var llb = map.getBounds();
        var old_zoom = map.getZoom();
        $("#customMap").html("");
        map = null;
        map = new T.Map('customMap');
        //设置显示地图的中心点和级别
        map.centerAndZoom(llb.getCenter(), old_zoom);
        map.removeEventListener("moveend", MapMoveend);
        map.addEventListener("moveend", MapMoveend);
        $.ajax({
            type: "post",
            async: true,
            url: "/getElements",
            data: {
                dataType: dataType,
                qualiteType: qualiteType,
                startTime: startTime,
                neLon: llb.getNorthEast().getLng(),
                neLat: llb.getNorthEast().getLat(),
                swLon: llb.getSouthWest().getLng(),
                swLat: llb.getSouthWest().getLat(),
                prs: prs
            },
            dataType: "json",
            success: function (data) {
                var dotColor = "#999999";
                var qt = qualiteType.toLocaleLowerCase();
                for (var ki in data) {
                    var binMap = data[ki];
                    if ((binMap[qt] == 0 || binMap[qt] == 3 || binMap[qt] == 4))
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
                    var prsv = binMap['prs'];
                    var prs_hwc = (prsv == undefined || prsv == "") ? binMap['prs_hwc'] : prsv;
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>tem:</span>" + binMap['tem'] + "</li>"
                        + "<li>" + "<span>prs:</span>" + prs_hwc + "</li>"
                        + "<li>" + "<span>dpt:</span>" + binMap['dpt'] + "</li>"
                        + "<li>" + "<span>q_tem:</span>" + binMap['q_tem'] + "</li>"
                        + "<li>" + "<span>q_dpt:</span>" + binMap['q_dpt'] + "</li>"
                        + "</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var point1 = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent, {offset: new T.Point(0, -30)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin, point1); //开启信息窗口
                    });// 将标注添加到地图中
                }
            }
        });
    }

    //----------Satellite map----------

    // 初始化卫星轨道图 的选项控件 和 轨道地图
    function binSatelliteMapListener(event) {
        $("#bin_map_div").hide();
        $("#bin_satellite_map_div").show();

        var SateType = event.target.getAttribute("name");
        if (SateType == "bin_AIRS_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        } else if (SateType == "bin_AIRS_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        } else if (SateType == "bin_IASI_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>" +
                "<option value='IASI_MTA'>IASI_MTA(METOP-A)</option>" +
                "<option value='IASI_MTB'>IASI_MTB(METOP-B)</option>";
            $("#satelliteType").append(sates);
        } else if (SateType == "bin_ATOVS_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>" +
                "<option value='AMSUA_NOAA15'>AMSUA_NOAA15</option>" +
                "<option value='AMSUA_NOAA18'>AMSUA_NOAA18</option>" +
                "<option value='AMSUA_NOAA19_BAWX'>AMSUA_NOAA19_BAWX</option>" +
                "<option value='AMSUA_NOAA19_EUMP'>AMSUA_NOAA19_EUMP</option>" +
                "<option value='AMSUA_NOAA19_EUMS'>AMSUA_NOAA19_EUMS</option>" +
                "<option value='AMSUA_MTB_EUMP'>AMSUA_MTB(MP01)_EUMP</option>" +
                "<option value='AMSUA_MTB_EUMS'>AMSUA_MTB(MP01)_EUMS</option>" +
                "<option value='AMSUA_MTA_EUMC'>AMSUA_MTA(MP02)_EUMC</option>" +
                "<option value='AMSUA_MTA_EUMS'>AMSUA_MTA(MP02)_EUMS</option>" +
                "<option value='AMSUB_NOAA15'>AMSUB_NOAA15</option>" +
                "<option value='MHS_NOAA18'>MHS_NOAA18</option>" +
                "<option value='MHS_NOAA19'>MHS_NOAA19</option>" +
                "<option value='MHS_MTB'>MHS_MTB(MP01)</option>" +
                "<option value='MHS_MTA'>MHS_MTA(MP02)</option>";
            $("#satelliteType").append(sates);

        } else if (SateType == "bin_ASCAT_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>" +
                "<option value='ASCAT_MTA'>ASCAT_MTA</option>" +
                "<option value='ASCAT_MTB'>ASCAT_MTB</option>";
            $("#satelliteType").append(sates);
        } else if (SateType == "bin_GPS_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>" +
                "<option value='GNSS_MTB'>GNSS_MTB(MP01)</option>" +
                "<option value='GNSS_MTA'>GNSS_MTA(MP02)</option>" +
                "<option value='GNSS_TDMX'>GNSS_TDMX</option>" +
                "<option value='GNSS_TASR'>GNSS_TASR</option>";
            $("#satelliteType").append(sates);
        } else if (SateType == "bin_YDF_map") {
            $("#satelliteType").empty();
            var sates = "<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        }

        $("#querySatelliteTime").empty();
        $("#querySatelliteTime").append("<option  value='0'>无</option>");

        //初始化时间控件为昨天
        getYesDay_Sate();

        var zoom = 2;
        //初始化地图对象
        $("#satelliteMap").html("");

        map = new T.Map('satelliteMap');
        //设置显示地图的中心点和级别
        map.centerAndZoom(new T.LngLat(50.40969, 58.90940), zoom);
        //让所有点在视野范围内

    };

    // 初始化时间控件为昨天
    getYesDay_Sate = function () {
        var nowdate = new Date();
        var y = nowdate.getFullYear();
        var m = nowdate.getMonth() + 1;
        var d = nowdate.getDate() - 1;
        var formatnowdate = y + '-' + m + '-' + d;
        $("#querySatelliteDate").val(formatnowdate);
    };

    // 触发该事件（选择卫星平台，相应的更新卫星时次）
    $("#satelliteType").change(binSatelliteTimeRangeMapListener);

    function binSatelliteTimeRangeMapListener() {
        $("#bin_map_div").hide();
        $("#bin_satellite_map_div").show();
        if ($("#satelliteType").val() == 0) {
            $("#querySatelliteTime").empty();
            $("#querySatelliteTime").append("<option  value='0'>无</option>");
        } else {
            var queryCond = {
                "querySatelliteDate": $("#querySatelliteDate").val(),
                "satelliteType": $("#satelliteType").val(),
            };
            $.ajax({
                type: "post",
                async: true,
                url: "/getSatelliteTimeRangElements",
                data: queryCond,
                dataType: "json",
                success: function (data) {
                    var querySatelliteTimeArray = new Array();
                    var fileNameTimeMap = eval(data);
                    //$("#querySatelliteTime").html("");

                    $("#querySatelliteTime").empty();
                    var timeFiles = "";
                    if (fileNameTimeMap.length > 0) {
                        timeFiles = "<option  value='0'>请选择卫星时次</option>";
                    } else {
                        timeFiles = "<option  value='0'>无</option>";
                    }
                    $("#querySatelliteTime").append(timeFiles);

                    for (var key in fileNameTimeMap) {
                        var fileNameTime = fileNameTimeMap[key].file_name_time;
                        if (("" != fileNameTime) || (null != fileNameTime)) {
                            var timeFiles = "";
                            timeFiles = "<option  value='" + fileNameTime + "'>" + fileNameTime + "</option>";
                            $("#querySatelliteTime").append(timeFiles);
                            // $("#querySatelliteTime").html(timeFiles);

                        } //end if
                    } //end for
                }
            });
        }


    };
    $('span.bin_satellite_map').click(binSatelliteMapListener);

    // 查询（按钮）触发查询卫星轨道图事件
    SatelliteQuery = function () {
        $("#bin_map_div").hide();
        $("#bin_satellite_map_div").show();
        var queryCond = {
            "querySatelliteDate": $("#querySatelliteDate").val(),
            "satelliteType": $("#satelliteType").val(),
            "querySatelliteTime": $("#querySatelliteTime").val(),
        };

        //让所有点在视野范围内
        $.ajax({
            type: "post",
            async: true,
            url: "/getSatelliteElements",
            data: queryCond,
            dataType: "json",
            success: function (data) {
                var pointArray = new Array();
                map.clearOverLays();  // 清除覆盖物(点)
                for (var i in data) {
                    var point = new T.Circle(new T.LngLat(data[i].obs_lon, data[i].obs_lat), 1, {
                        color: "#00FF66",
                        weight: 6,
                        opacity: 1,
                        fillColor: "#00FF66",
                        fillOpacity: 0,
                        lineStyle: "solid"
                    });
                    map.addOverLay(point);    //增加点
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>经度（°）:</span>" + data[i].obs_lon + "</li>"
                        + "<li>" + "<span>纬度（°）:</span>" + data[i].obs_lat + "</li>"
                        + "</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var pointInner = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent, {offset: new T.Point(0, -9)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin, pointInner); //开启信息窗口
                    });// 将标注添加到地图中
                }
                //   $('mapDiv').html("");
            }
        });
    };
    // $('span.bin_satellite_map').click(binSatelliteMapListener);

});