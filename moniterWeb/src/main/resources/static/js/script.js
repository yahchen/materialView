$(document).ready(function(){
    //$('.tooltip').tooltipster();
	var data_logo=getQueryString("data_logo");//上一页传递过来的值
    getYesDay();//初始化时，默认设置昨天日期
    onLoadDdSelected(data_logo);//选中效果
    onShowGridMatrix(data_logo);//矩阵图

	$("#selectParent dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");          // 该行多个中，只能选一个， 欧洲中心、日本格点、EC 

		if ($(this).hasClass("select-ee")) {                                      // 如果该dd中 选择的是（包含）“select-ee”
			$("#selectChildren1").show();
			$("#selectChildren2").hide();
            $("#wendu01").addClass("selected").siblings().removeClass("selected");
		}else if($(this).hasClass("select-jj")){                               // 如果该dd中 选择的是（包含）“select-jj
			$("#selectChildren1").hide();
			$("#selectChildren2").show();
            $("#jiangshui02").addClass("selected").siblings().removeClass("selected");
		}
        getDDSelectedValue();
	});
	
	$("#selectChildren1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
        if($(this).attr("value")!=null){
            onShowGridMatrix($(this).attr("value"));
        }
		/**var text = $(this).find("a").text();  // 找到当前点击的dt下的a标签并获取其内容
		var varText="TM_GRID_ECMWF_T";
		if(text=="位势高度"){
            varText="TM_GRID_ECMWF_H";
		}else if(text=="U风"){
            varText="TM_GRID_ECMWF_U";
		}else if(text=="V风"){
		    varText="TM_GRID_ECMWF_V";
		}
        onShowGridMatrix(varText);**/
	});

	$("#selectChildren2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
        if($(this).attr("value")!=null){
            onShowGridMatrix($(this).attr("value"));
		}
	/**var text = $(this).find("a").text();  // 找到当前点击的dt下的a标签并获取其内容
       var varText="TM_GRID_JAPAN_PRE";
        if(text=="温度"){
           varText="TM_GRID_JAPAN_T";
        }else if(text=="位势高度"){
            varText="TM_GRID_JAPAN_H";
        }else if(text=="U风"){
            varText="TM_GRID_JAPAN_U";
        }else if(text=="V风"){
            varText="TM_GRID_JAPAN_V";
        }**/
	});
});

getQueryString = function(name) {//读取上一个页面src的值
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}


onShowGridMatrix=function(aPara){//显示矩阵图
		var queryCond = {
				"queryTime":$( "#start2" ).val(),
				"queryElment":aPara
			};
		$.ajax({
		 	type: "post",
            dataType: "json",
		 	cache:false,
		 	url:"/findMatrixByTimeElement",
		 	data:queryCond,
		 	beforeSend:function(){
		 		$("#message").html("正在查询数据，请稍后...");
		 		return true;
		 	},
		 	success:function(json){
		 		$("#page_data").empty();
		 		if(json.listLen!="0"){
		 			var  tabStr="<table   border='1px'  cellspacing='0' cellpadding='0'  width='100%'>";
			 		//var len=json.itemLen;
			 		$.each(json.list, function(index1, obj) {
			 			var s="<tr height='50'>";

			 		   $.each(obj, function(key, value){
			 			   var labelStr="<span  style='display:block;font-size:20px;text-align:center'>"+value+"</span>";
			 			   if(value.fileState==-1){
			 				  labelStr="<label  class='tooltip'  id='Id12' title='"+value.fileInfo+"' style= 'display:block;width:25px;height:45px;background-color: #EE1111;margin-right:'><span class='tooltip'  id='id19' style='font-size:40px;'>&times;</span></label>";
			 			   } else if(value.fileState==1){
			 				  labelStr="<label  style= 'display:block;width:25px;height:45px;background-color: #1AE61A;margin-right:'><span  style='font-size:40px;''>&radic;</span></label>";
			 			   }
			 			  s+="<td align='center'>"+labelStr+"</td>";
			 		   });
			 		   s+="</tr>";
			 		  tabStr+=s;
			 		});
			 		tabStr+="</table>";
			 		$("#page_data").append(tabStr);
		 		}
		 		$("#message").html(json.listMessage);
		 	},
		 	error:function(){
		 		$("#message").html("查询数据失败，请重试！");
		 	}
		 });
	}

//当页面加载的时候，出现相应的选中效果
onLoadDdSelected=function(aParam){
    if(aParam=='TM_GRID_ECMWF_H'){
       $("#gaodu01").addClass("selected").siblings().removeClass("selected");
    }else if(aParam=='TM_GRID_ECMWF_U'){
       $("#ufeng01").addClass("selected").siblings().removeClass("selected");
    }else if(aParam=='TM_GRID_ECMWF_V'){
       $("#vfeng01").addClass("selected").siblings().removeClass("selected");
    }else if(aParam=='TM_GRID_JAPAN_PRE'){
       $("#japan00").addClass("selected").siblings().removeClass("selected");
       $("#selectChildren1").hide();
       $("#selectChildren2").show();
       $("#jiangshui02").addClass("selected").siblings().removeClass("selected");
    }else if(aParam=='TM_GRID_JAPAN_T'){
       $("#japan00").addClass("selected").siblings().removeClass("selected");
       $("#selectChildren1").hide();
       $("#selectChildren2").show();
       $("#wendu02").addClass("selected").siblings().removeClass("selected");
    }else if(aParam=='TM_GRID_JAPAN_H'){
       $("#japan00").addClass("selected").siblings().removeClass("selected");
       $("#selectChildren1").hide();
       $("#selectChildren2").show();
       $("#gaodu02").addClass("selected").siblings().removeClass("selected");
     }else if(aParam=='TM_GRID_JAPAN_U'){
       $("#japan00").addClass("selected").siblings().removeClass("selected");
       $("#selectChildren1").hide();
       $("#selectChildren2").show();
       $("#ufeng02").addClass("selected").siblings().removeClass("selected");
      }else if(aParam=='TM_GRID_JAPAN_V'){
       $("#japan00").addClass("selected").siblings().removeClass("selected");
       $("#selectChildren1").hide();
       $("#selectChildren2").show();
       $("#vfeng02").addClass("selected").siblings().removeClass("selected");
      }
}
getYesDay=function () {//页面加载时，设置默认时间
    var nowdate = new Date();
    var y = nowdate.getFullYear();
    var m = nowdate.getMonth()+1;
    var d = nowdate.getDate()-1;
    var formatnowdate = y+'-'+m+'-'+d;
    $("#start2").val(formatnowdate);
}

getDDSelectedValue=function () {
    $("dd.selected:visible").each(function () {
        if($(this).attr("value")!=null){//不为空时，则再次触发查询页面
            onShowGridMatrix($(this).attr("value"));
        }
    });
}