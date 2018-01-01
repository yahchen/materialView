getQueryString = function(name) {//读取上一个页面src的值
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}
initDate=function () {
    var nowdate = new Date();
    var y = nowdate.getFullYear();
    var m = nowdate.getMonth()+1;
    var d = nowdate.getDate();
    var formatnowdate = y+'-'+fix(m,2)+'-'+fix(d,2);
    $("#end").val(formatnowdate);
    //获取系统前一个月的时间
    nowdate.setMonth(nowdate.getMonth()-1);
    y = nowdate.getFullYear();
    m = nowdate.getMonth()+1;
    d = nowdate.getDate();
    var formatwdate = y+'-'+fix(m,2)+'-'+fix(d,2);
    $("#start").val(formatwdate);
}
//fix(m,2)  m不足两位 前面补0
function fix(num, length) {
    return ('' + num).length < length ? ((new Array(length + 1)).join('0') + num).slice(-length) : '' + num;
}
