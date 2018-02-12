//站点资料>地面资料>中国地面逐小时资料>折线图
function toChinaGround() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>中国地面逐小时资料>折线图</h3><div class='panel'><iframe id='iframe' src='jsp/global/site/site_chart.jsp?data_code=SURF_CHN_MUL_HOR'  width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//站点资料>地面资料>全球地面逐小时资料>折线图
function toGlobalGround() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>地面资料>全球地面逐小时资料>折线图</h3><div class='panel'><iframe src='jsp/global/site/site_chart.jsp?data_code=SURF_GLB_MUL_HOR' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//站点资料>高空资料>全球高空定时值资料>折线图
function toUpperGlobal() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>全球高空定时值资料>折线图</h3><div class='panel'><iframe src='jsp/global/site/site_chart.jsp?data_code=UPAR_GLB_MUL_FTM' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//站点资料>高空资料>全球飞机高空探测资料>折线图
function toUpperAirPlaneGlobal() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>高空资料>全球飞机高空探测资料>折线图</h3><div class='panel'><iframe src='jsp/global/site/site_chart.jsp?data_code=UPAR_ARD_G_MUT_AMD' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//站点资料>检验用降水资料>检验用降水资料>折线图

//站点资料>台风资料>台风实况与预报要素资料>折线图
function toTyphoonPredict() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>站点资料>台风资料>台风实况与预报要素资料>折线图</h3><div class='panel'><iframe src='jsp/global/site/site_chart.jsp?data_code=SEVP_WEFC_TYP_WT' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//格点资料>海温资料>华盛顿海温数值预报产品-全球>折线图
function toSeaFigure() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>格点资料>海温资料>华盛顿海温数值预报产品-全球>折线图</h3><div class='panel'><iframe src='jsp/global/site/grid_chart.jsp?data_code=NAFP_FOR_FTM_KWBC_GLB' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//格点资料>检验用格点要素场资料>？？？>折线图

//文件资料>雷达资料>质控后标准格式单站多普勒雷达基数据>折线图
function toDopplerRadar() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>雷达资料>质控后标准格式单站多普勒雷达基数据>折线图</h3><div class='panel'><iframe src='jsp/global/site/file_chart.jsp?data_code=RADA_L2_QC' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
toWindProfileRadar
//文件资料>雷达资料>质控后标准格式单站多普勒雷达基数据>折线图
function toWindProfileRadar() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>风廓线资料>中国风廓线雷达数据文件-小时平均采样高度上的产品文件>折线图</h3><div class='panel'><iframe src='jsp/global/site/file_chart.jsp?data_code=UPAR_WPR_HOUR' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
//文件资料>GPS资料>质控后标准格式单站多普勒雷达基数据>折线图
function toGPSMoisture() {
    $("#main").empty();
    $("#main").append("<div class='main-content'><div class='container-fluid'><h3 class='page-title'>文件资料>风廓线资料>中国风廓线雷达数据文件-小时平均采样高度上的产品文件>折线图</h3><div class='panel'><iframe src='jsp/global/site/file_chart.jsp?data_code=UPAR_WPR_HOUR' width='100%'  border='0'  style='padding: 0px; width: 100%; height: 550px;'  frameborder='0'></iframe></div></div></div>");
}
/*//解析字符串，形成     当前位置：站点资料>地面资料>全球地面逐小时资料>折线图  
 //中国地面逐小时index为15                                          1>2>15>16
 function parseStr(index){
 if(index>15){
 }
 }*/