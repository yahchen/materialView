$(function () {
    var map = null;
    var data_logo = getQueryString("data_logo");

    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        $('a.bin_map').click(binMapListener);
        $('#binMapQuery').click(binMapListener);
        //  $('span.bin_satellite_map').click(binSatelliteMapListener);
        //$("#dataType").attr("disabled",true);
    });


    // 初始化地图对象
    var zoom = 2;
    $("#satelliteMap").html("");
    map = new T.Map('satelliteMap');
    //设置显示地图的中心点和级别
    map.centerAndZoom(new T.LngLat(50.40969, 58.90940), zoom);
    //让所有点在视野范围内


    binSatelliteMapListener(data_logo);


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
        // $("#bin_map_div").hide();
        // $("#bin_satellite_map_div").show();
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
                        weight: 3.5,
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
                        var infoWin = new T.InfoWindow(sContent, {offset: new T.Point(0, -3)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin, pointInner); //开启信息窗口
                    });// 将标注添加到地图中
                }
            }
        });
    };

});


//----------Satellite map----------

// 初始化卫星轨道图 的选项控件 和 轨道地图
function binSatelliteMapListener(data_logo) {

    //alert( getQueryString("data_logo"));

    //  var SateType = event.target.getAttribute("name");

    if (data_logo == "GM_AIRS") {
        $("#satelliteType").empty();
        var sates = "<option value='0'>请选择卫星</option>";
        $("#satelliteType").append(sates);
    } else if (data_logo == "GM_METOPA_IASI") {
        $("#satelliteType").empty();
        var sates = "<option value='0'>请选择卫星</option>" +
            "<option value='IASI_MTA'>IASI_MTA(METOP-A)</option>";
        $("#satelliteType").append(sates);
    } else if (data_logo == "GM_RATVC_ATOVS") {
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

    } else if (data_logo == "GM_RSATE_ASCAT") {
        $("#satelliteType").empty();
        var sates = "<option value='0'>请选择卫星</option>" +
            "<option value='ASCAT_MTA'>ASCAT_MTA</option>" +
            "<option value='ASCAT_MTB'>ASCAT_MTB</option>";
        $("#satelliteType").append(sates);
    } else if (data_logo == "GM_GPS") {
        $("#satelliteType").empty();
        var sates = "<option value='0'>请选择卫星</option>" +
            "<option value='GNSS_MTB'>GNSS_MTB(MP01)</option>" +
            "<option value='GNSS_MTA'>GNSS_MTA(MP02)</option>" +
            "<option value='GNSS_TDMX'>GNSS_TDMX</option>" +
            "<option value='GNSS_TASR'>GNSS_TASR</option>";
        $("#satelliteType").append(sates);
    } else if (data_logo == "GM_R2CWE_CLOUD") {
        $("#satelliteType").empty();
        var sates = "<option value='0'>请选择卫星</option>";
        $("#satelliteType").append(sates);
    }

    $("#querySatelliteTime").empty();
    $("#querySatelliteTime").append("<option  value='0'>无</option>");

    //初始化时间控件为昨天
    getYesDay_Sate();


};


// 初始化时间控件为昨天
getYesDay_Sate = function () {
    var nowdate = new Date();
    var y = nowdate.getFullYear();
    var m = nowdate.getMonth() + 1;
    var d = nowdate.getDate() - 1;
    var formatnowdate = y + '-' + fix(m, 2) + '-' + fix(d, 2);
    $("#querySatelliteDate").val(formatnowdate);
}
//fix(m,2)  m不足两位 前面补0
function fix(num, length) {
    return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
}