$(function(){
    var map = null;
    var v00="<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面1小时观测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>地面1小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages102' data-toggle='collapse' class='collapsed'><span>地面3小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages102' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages103' data-toggle='collapse' class='collapsed'><span>地面6小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages103' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages104' data-toggle='collapse' class='collapsed'><span>地面12小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages104' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages105' data-toggle='collapse' class='collapsed'><span>地面24小时降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages105' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li>";

    var v20="<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages200' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 温度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages200' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages201' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 位势高度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages201' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages202' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 u风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages202' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages203' data-toggle='collapse' class='collapsed'><span>欧洲中心数值预报产品-低分辨率-全球 v风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages203' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    var v21="<li><a data-toggle='collapse'><i class='lnr lnr-map'></i><span>格点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages210' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-远东区域（中国）降水</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages210' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages211' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 温度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages211' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages212' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 位势高度</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages212' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages213' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 u风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages213' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li><li><a href='#subPages214' data-toggle='collapse' class='collapsed'><span>日本数值预报产品-低分辨率-北半球 v风</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages214' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-dice'></i>矩阵图</a></li></ul></div></li>";

    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        $('a.bin_map').click(binMapListener);
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
                    var sContent = "";
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
    $('select.bin_map').click(function (event) {
        var selectVal = event.target;
        var idVal = event.target.getAttribute("id");
    });
});