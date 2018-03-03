$(function () {
    var map = null;
    var v00 = "<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10 = "<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面1小时观测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse'><ul class='nav'><li><a href='#' onclick='toSiteChartDM1GC()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>地面1小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse'><ul class='nav'><li><a href='#' onclick='toSiteChartDM1JS()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages102' data-toggle='collapse' class='collapsed'><span>地面3小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages102' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDM3JS()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages103' data-toggle='collapse' class='collapsed'><span>地面6小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages103' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDM6JS()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages104' data-toggle='collapse' class='collapsed'><span>地面12小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages104' class='collapse'><ul class='nav'><li><a href='#' onclick='toSiteChartDM12JS()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages105' data-toggle='collapse' class='collapsed'><span>地面24小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages105' class='collapse '><ul class='nav'><li><a href='#' onclick='toSiteChartDM24JS()'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li>";

    var v20 = "<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 温度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse'><ul class='nav'><li><a href='#' onclick='toGridChartWendu01()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixWendu01()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages201' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 位势高度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages201' class='collapse'><ul class='nav'><li><a href='#' onclick='toGridChartGaodu01()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixGaodu01()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages202' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 u风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages202' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartUfeng01()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixUfeng01()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages203' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 v风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages203' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartVfeng01()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixVfeng01()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v21 = "<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages210' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-远东区域（中国）降水</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages210' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartJS02()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixJS02()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages211' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 温度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages211' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartWendu02()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixWendu02()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages212' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 位势高度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages212' class='collapse'><ul class='nav'><li><a href='#' onclick='toGridChartGaodu02()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixGaodu02()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages213' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 u风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages213' class='collapse'><ul class='nav'><li><a href='#' onclick='toGridChartUfeng02()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' onclick='toGridMatrixUfeng02()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages214' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 v风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages214' class='collapse '><ul class='nav'><li><a href='#' onclick='toGridChartVfeng02()'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a  href='#' onclick='toGridMatrixVfeng02()'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v22 = "<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>检验用格点要素场资料>格点资料>矩阵图</h3><div class='panel'><iframe src='/grid_material_view' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>";

    var v30 = "<li><a data-toggle='collapse'><i class='lnr lnr-layers'></i><span>用户日志</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";


    toSiteChartDM1GC = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面1小时观察资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_1h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartDM1JS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面1小时降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_PRE_1h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartDM3JS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面3小时降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_PRE_3h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartDM6JS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面6小时降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_PRE_6h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartDM12JS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面12小时降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_PRE_12h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toSiteChartDM24JS = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>地面24小时降水资料>折线图</h3><div class='panel'><iframe id='iframe' src='/site_chart_view?data_logo=TM_RSURF_PRE_24h'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixWendu01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-温度>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_ECMWF_T'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartWendu01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-温度>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_ECMWF_T'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixGaodu01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-位势高度>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_ECMWF_H'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartGaodu01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-位势高度>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_ECMWF_H'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridMatrixUfeng01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-u风>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_ECMWF_U'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartUfeng01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-u风>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_ECMWF_U'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixVfeng01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-v风>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_ECMWF_V'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartVfeng01 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>欧洲中心格点场资料>欧洲中心数值预报产品-低分辨率-全球-v风>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_ECMWF_V'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixJS02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-远东区域（中国）降水>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_JAPAN_PRE'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartJS02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-远东区域（中国）降水>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_JAPAN_PRE'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixWendu02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-温度>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_JAPAN_T'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartWendu02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-温度>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_JAPAN_T'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridMatrixGaodu02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本中心数值预报产品-低分辨率-全球-位势高度>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_JAPAN_H'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartGaodu02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本中心数值预报产品-低分辨率-全球-位势高度>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_JAPAN_H'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixUfeng02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-u风>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_JAPAN_U'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartUfeng02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-u风>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_JAPAN_U'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }

    toGridMatrixVfeng02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-v风>矩阵图</h3><div class='panel'><iframe id='iframe' src='/grid_matrix_view?data_logo=TM_GRID_JAPAN_V'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 600px;'  frameborder='0'></iframe></div></div></div>");
    }
    toGridChartVfeng02 = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>日本中心格点场资料>日本数值预报产品-低分辨率-北半球-v风>折线图</h3><div class='panel'><iframe id='iframe' src='/grid_chart_view?data_logo=TM_GRID_JAPAN_V'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");
    }
    //行为记录
    toBehaviorRecord = function () {
        $("#main").empty();
        $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>用户日志>行为记录</h3><div class='panel'><iframe id='iframe' src='/behavior_record_view?mode_type=3' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 800px;'  frameborder='0'></iframe></div></div></div>");

    }
    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        if (event.target.getText() != '分布图')
            $('.binMapChoice').hide();
        $('span.bin_map').click(binMapListener);
        $('a.bin_map').click(pullSelectVal());
    });


    function binMapListener() {
        var dataType = $("#dataType").val();
        var qualiteType = $("#qualiteType").val();
        $('.binMapChoice').show();
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
            data: {
                dataType: dataType,
                qualiteType: qualiteType
            },
            dataType: "json",
            success: function (data) {
                var pointArray = new Array();
                var dotColor = "#00FF66";
                var gray = "#999999";
                for (var ki in data) {
                    var binMap = data[ki];
                    if (binMap['station_id_d'] == 999999 || binMap['station_id_d'] == 999998)
                        dotColor = gray;
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
                $('mapDiv').html("");
            }
        });
    };
    $('a.bin_map').click(binMapListener);
});