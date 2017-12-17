$(function(){
    var map = null;
    var v00="<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li>";

    var v11="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages111' data-toggle='collapse' class='collapsed'><span>高空测风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages111' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v12="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages121' data-toggle='collapse' class='collapsed'><span>台风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages121' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li></ul></div></li>";

    var v20="<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>美国海温格点</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v30="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages300' data-toggle='collapse' class='collapsed'><span>AIRS红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages300' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_AIRS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages301' data-toggle='collapse' class='collapsed'><span>IASI 红外高光谱卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages301' class='collapse '><ul class='nav'><li><a href=#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href=#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_IASI_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages302' data-toggle='collapse' class='collapsed'><span>ATOVS业务垂直探测器卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages302' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map'  name='bin_ATOVS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages303' data-toggle='collapse' class='collapsed'><span>ASCAT洋面风卫星资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages303' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_ASCAT_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages304' data-toggle='collapse' class='collapsed'><span>GPS折射率（掩星）</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages304' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_GPS_map'>轨迹图</span></a></li></ul></div></li><li><a href='#subPages305' data-toggle='collapse' class='collapsed'><span>云导风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages305' class='collapse '><ul class='nav'><li><a href='#'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#'><i class='icon-submenu lnr lnr-star-half'></i><span class='bin_satellite_map' name='bin_YDF_map'>轨迹图</span></a></li></ul></div></li>";


    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));

        $('span.bin_map').click(binMapListener);
        $('span.bin_satellite_map').click(binSatelliteMapListener);
    });

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


    //----------Satellite map----------

    // 初始化卫星轨道图 的选项控件 和 轨道地图
    function binSatelliteMapListener(event) {
        $('.binSatelliteMapChoice').show();
        $('#satelliteMap').show();

        var SateType = event.target.getAttribute("name");
        if(SateType =="bin_AIRS_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        }else if(SateType =="bin_AIRS_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        }else if(SateType =="bin_IASI_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>" +
                "<option value='IASI_MTA'>IASI_MTA(METOP-A)</option>"  +
                "<option value='IASI_MTB'>IASI_MTB(METOP-B)</option>" ;
            $("#satelliteType").append(sates);
        }else if(SateType =="bin_ATOVS_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>" +
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
                "<option value='MHS_MTA'>MHS_MTA(MP02)</option>" ;
            $("#satelliteType").append(sates);

        }else if(SateType =="bin_ASCAT_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>" +
                "<option value='ASCAT_MTA'>ASCAT_MTA</option>"  +
                "<option value='ASCAT_MTB'>ASCAT_MTB</option>" ;
            $("#satelliteType").append(sates);
        }else if(SateType =="bin_GPS_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>" +
                "<option value='GNSS_MTB'>GNSS_MTB(MP01)</option>"  +
                "<option value='GNSS_MTA'>GNSS_MTA(MP02)</option>" +
                "<option value='GNSS_TDMX'>GNSS_TDMX</option>"  +
                "<option value='GNSS_TASR'>GNSS_TASR</option>" ;
            $("#satelliteType").append(sates);
        }else if(SateType =="bin_YDF_map"){
            $("#satelliteType").empty();
            var sates ="<option value='0'>请选择卫星</option>";
            $("#satelliteType").append(sates);
        }

        $("#querySatelliteTime").empty();
        $("#querySatelliteTime").append("<option  value='0'>无</option>");

        //初始化时间控件为昨天
        getYesDay_Sate();

        var zoom =2;
        //初始化地图对象
        $("#satelliteMap").html("");

        map = new T.Map('satelliteMap');
        //设置显示地图的中心点和级别
        map.centerAndZoom(new T.LngLat(50.40969, 58.90940), zoom);
        //让所有点在视野范围内

    };
    $('span.bin_satellite_map').click(binSatelliteMapListener);

    // 初始化时间控件为昨天
    getYesDay_Sate=function () {
        var nowdate = new Date();
        var y = nowdate.getFullYear();
        var m = nowdate.getMonth()+1;
        var d = nowdate.getDate()-1;
        var formatnowdate = y+'-'+m+'-'+d;
        $("#querySatelliteDate").val(formatnowdate);
    };

// test start
    // 触发该事件 (时间控jian)
  /* $("#querySatelliteDate").blur(getTime);
    function getTime(){
        var vx=document.getElementById("querySatelliteDate").value;
        // document.getElementById("querySatelliteDate").value=x.toUpperCase()
        if(vx == "" || vx==null){
            alert("xxxxxx");
        }else{
            alert(vx);
        }
    };*/
//test end

    // 触发该事件（选择卫星平台，相应的更新卫星时次）
    $("#satelliteType").change(binSatelliteTimeRangeMapListener);

    function binSatelliteTimeRangeMapListener() {
        if($("#satelliteType").val()==0){
            $("#querySatelliteTime").empty();
            $("#querySatelliteTime").append("<option  value='0'>无</option>");
        }else{
            var queryCond = {
                "querySatelliteDate":$( "#querySatelliteDate" ).val(),
                "satelliteType":$( "#satelliteType" ).val(),
            };
            $.ajax({
                type: "post",
                async: true,
                url: "/getSatelliteTimeRangElements",
                data: queryCond,
                dataType: "json",
                success: function(data) {
                    var querySatelliteTimeArray = new Array();
                    var fileNameTimeMap = eval(data);
                    //$("#querySatelliteTime").html("");

                    $("#querySatelliteTime").empty();
                    var timeFiles ="";
                    if(fileNameTimeMap.length >0){
                        timeFiles = "<option  value='0'>请选择卫星时次</option>";
                    }else{
                        timeFiles = "<option  value='0'>无</option>";
                    }
                    $("#querySatelliteTime").append(timeFiles);

                    for (var key in fileNameTimeMap) {
                        var fileNameTime  = fileNameTimeMap[key].file_name_time;
                        if( ("" != fileNameTime) ||(null != fileNameTime)){
                            var timeFiles="";
                            timeFiles = "<option  value='"+fileNameTime+"'>"+fileNameTime+"</option>";
                            $("#querySatelliteTime").append(timeFiles);
                            // $("#querySatelliteTime").html(timeFiles);

                        } //end if
                    } //end for
                }
            });
        }


    };
    $('span.bin_satellite_map').click(binSatelliteMapListener);




    // 触发该事件
    //$("#querySatelliteTime").change(binSatelliteTimesMapListener);


    // 查询（按钮）触发查询卫星轨道图事件
    SatelliteQuery =function(){

       var queryCond = {
            "querySatelliteDate":$( "#querySatelliteDate" ).val(),
            "satelliteType":$( "#satelliteType" ).val(),
            "querySatelliteTime":$( "#querySatelliteTime" ).val(),
        };

        //让所有点在视野范围内
        $.ajax({
            type: "post",
            async: true,
            url: "/getSatelliteElements",
            data: queryCond,
            dataType: "json",
            success: function(data) {
                var pointArray = new Array();
                map.clearOverLays();  // 清除覆盖物(点)
                for (var i in data){
                    var point = new T.Circle(new T.LngLat(data[i].obs_lon,data[i].obs_lat), 1,{color:"#00FF66",weight:6,opacity:1,fillColor:"#00FF66",fillOpacity:0,lineStyle:"solid"});
                    map.addOverLay(point);    //增加点
                    var sContent = "<div>"
                        + "<ul>"
                        + "<li>" + "<span>经度（°）:</span>" +  data[i].obs_lon + "</li>"
                        + "<li>" + "<span>纬度（°）:</span>" +  data[i].obs_lat + "</li>"
                        +"</ul>"
                        + "</div>";
                    point.addEventListener("click", function (e) {
                        var pointInner = e.lnglat;
                        var infoWin = new T.InfoWindow(sContent,{offset:new T.Point(0,-9)}); // 创建信息窗口对象
                        map.openInfoWindow(infoWin,pointInner); //开启信息窗口
                    });// 将标注添加到地图中
                }
            //   $('mapDiv').html("");
            }
        });
    };
   // $('span.bin_satellite_map').click(binSatelliteMapListener);



});