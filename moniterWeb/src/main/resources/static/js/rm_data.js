$(function(){
    var map = null;
    var v00="<li><a data-toggle='collapse'><i class='lnr lnr-home'></i><span>关于我们</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    var v10="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages100' data-toggle='collapse' class='collapsed'><span>地面常规观测（含船舶、浮标）资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages100' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' class='bin_map'><i class='icon-submenu lnr lnr-list'></i><span>分布图</span></a></li></ul></div></li><li><a href='#subPages101' data-toggle='collapse' class='collapsed'><span>国内自动站地面气象资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages101' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i><span>折线图</span></a></li><li><a href='#' class='bin_map'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v11="<li><a data-toggle='collapse'><i class='lnr lnr-earth'></i><span>站点资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages110' data-toggle='collapse' class='collapsed'><span>高空探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages110' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages111' data-toggle='collapse' class='collapsed'><span>高空测风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages111' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li><li><a href='#subPages112' data-toggle='collapse' class='collapsed'><span>飞机探测资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages112' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='#' class='bin_map'><i class='icon-submenu lnr lnr-list'></i>分布图</a></li></ul></div></li>";

    var v20="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages201' data-toggle='collapse' class='collapsed'><span>云导风资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages201' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li><li><a href='page-login.html'><i class='icon-submenu lnr lnr-star-half'></i>轨迹图</a></li></ul></div></li>";

    var v21="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages210' data-toggle='collapse' class='collapsed'><span>GPS可降水资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages210' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";

    var v22="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages220' data-toggle='collapse' class='collapsed'><span>多普勒雷达文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages220' class='collapse'><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";

    var v23="<li><a data-toggle='collapse'><i class='lnr lnr-book'></i><span>文件资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/><li><a href='#subPages230' data-toggle='collapse' class='collapsed'><span>风廓线资料</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a><div id='subPages230' class='collapse '><ul class='nav'><li><a href='page-profile.html'><i class='icon-submenu lnr lnr-chart-bars'></i>折线图</a></li></ul></div></li>";


    var v40="<li><a data-toggle='collapse'><i class='lnr lnr-paw'></i><span>用户日志</span><!--子图标标识--><i class='icon-submenu lnr lnr-chevron-left'></i></a></li><hr/>";

    $('a.tl_type').click(function (event) {
        var pn = event.target.getAttribute("id");
        $("#navId").html("");
        $("#navId").append(eval(pn));
        if(event.target.getText() != '分布图')
            $('.binMapChoice').hide();
        $('a.bin_map').click(binMapListener);
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
                $("#qualiteType").change(binMapListener);
            }
        });
    });
    function binMapListener() {
        var dataType = $("#dataType option:selected").val();
        var qualiteType = $("#qualiteType option:selected").val();
        if(qualiteType == undefined || qualiteType == "")
            return
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
                dataType:dataType,
                qualiteType:qualiteType
            },
            dataType: "json",
            success: function(data) {
                var pointArray = new Array();
                var dotColor = "#00FF66";
                var gray = "#999999";
                for (var ki in data){
                    var binMap = data[ki];
                    if(binMap['station_id_d']==999999 || binMap['station_id_d']==999998)
                        dotColor = gray;
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
                $('mapDiv').html("");
            }
        });
    };
    $('a.bin_map').click(binMapListener);

});