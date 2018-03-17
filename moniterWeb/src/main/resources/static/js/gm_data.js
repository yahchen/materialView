$(function () {
    var map = null;
    var v00 = "<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDMCG()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' onclick='toDistributionCurveDMCG()' class='' name='GM_RSURF_GL'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGNZDZ()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' onclick='toGroudAutoSateFileBinMap()' class='' name='GM_RSURF_CH'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v11 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartGKTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toHighAirDetectBinMap()'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a  href='#' onclick='toSiteChartFJTC()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toPlaneDetectBinMap()'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v12 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages121' data-toggle='collapse' class='collapsed'><span>台风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages121' class='collapse '><ul class='nav'><li><a  href='#' onclick='toSiteChartTFZL()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li></ul></div></li>";

    var v20 = "<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>美国海温格点</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartHWGD()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixHWGD()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v30 = "<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><!--<li><a href='#subPages300' data-toggle='collapse' class='collapsed'><span>AIRS红外高光谱卫星资料</span>--><!--子图标标识--><!--<i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages300' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartAIRS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapAIRS()'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li>--><li><a href='#subPages301' data-toggle='collapse' class='collapsed'><span>IASI 红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages301' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartIASI()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapIASI()'><i class='icon-submenu lnr lnr-star-half'></i><span >轨迹图</span></a></li></ul></div></li><li><a href='#subPages302' data-toggle='collapse' class='collapsed'><span>ATOVS业务垂直探测器卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages302' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartATOVS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapATOVS()'><i class='icon-submenu lnr lnr-star-half'></i><span >轨迹图</span></a></li></ul></div></li><!--<li><a href='#subPages303' data-toggle='collapse' class='collapsed'><span>ASCAT洋面风卫星资料</span>--><!--子图标标识--><!--<i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages303' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartASCAT()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapASCAT()'><i class='icon-submenu lnr lnr-star-half'></i><span>轨迹图</span></a></li></ul></div></li><li><a href='#subPages304' data-toggle='collapse' class='collapsed'><span>GPS折射率（掩星）</span><!--子图标标识--><!--<i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages304' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartGPS()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapGPS()'><i class='icon-submenu lnr lnr-star-half'></i><span >轨迹图</span></a></li></ul></div></li><li><a href='#subPages305' data-toggle='collapse' class='collapsed'><span>云导风资料</span>--><!--子图标标识--><!--<i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages305' class='collapse '><ul class='nav'><li><a href='#' onclick='toSateFileChartYDF()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toSateFileMapYDF()'><i class='icon-submenu lnr lnr-star-half'></i><span >轨迹图</span></a></li></ul></div></li>-->";

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
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>海温格点>美国海温格点>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartAIRS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>AIRS红外高光谱卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_GRID_KWBC_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileChartIASI = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>IASI红外高光谱卫星资料>折线图</h3><div class='panel'><iframe id='iframe' src='/sate_file_chart_view?data_logo=GM_METOPA_IASI'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

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

    // 行为轨迹图 start
    toSateFileMapAIRS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>AIRS红外高光谱卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_AIRS'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }

    toSateFileMapIASI = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>IASI红外高光谱卫星资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_METOPA_IASI'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

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
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>GPS折射率（掩星）>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_GPS'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    toSateFileMapYDF = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>卫星资料>云导风资料>轨迹图</h3><div class='panel'><iframe id='iframe' src='/track_map_view?data_logo=GM_R2CWE_CLOUD'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    // 行为轨迹图 end

    toDistributionCurveDMCG = function () {//地面常规观测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>常规地面观测（含船舶、浮标）资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGroudAutoSateFileBinMap = function () {//地面常规观测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>国内自动站地面气象资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RSURF_CH'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toHighAirDetectBinMap = function () {//高空探测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空探测资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RTEMP_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toHighAirAnemometryBinMap = function () {//高空测风资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>高空测风资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RSURF_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toPlaneDetectBinMap = function () {//飞机探测资料
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>飞机探测资料>分布图</h3><div class='panel'><iframe id='iframe' src='/distribution_curve_view?data_logo=GM_RSING_GL'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }


    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
    });
});