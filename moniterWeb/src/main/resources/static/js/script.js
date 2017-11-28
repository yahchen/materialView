$(document).ready(function(){

	var data_logo=getQueryString("data_logo")
    onLoadDdSelected(data_logo);
    onShowGridMatrix(data_logo);

	$("#selectParent dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");          // 该行多个中，只能选一个， 欧洲中心、日本格点、EC 

		if ($(this).hasClass("select-ee")) {                                      // 如果该dd中 选择的是（包含）“select-ee”
			$("#selectChildren1").show();
			$("#selectChildren2").hide();

		}else if($(this).hasClass("select-jj")){                               // 如果该dd中 选择的是（包含）“select-jj
			$("#selectChildren1").hide();
			$("#selectChildren2").show();

		}
	});
	
	$("#selectChildren1 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		var text = $(this).find("a").text();  // 找到当前点击的dt下的a标签并获取其内容
		var varText="TM_GRID_ECMWF_T";
		if(text=="位势高度"){
            varText="TM_GRID_ECMWF_H";
		}else if(text=="U风"){
            varText="TM_GRID_ECMWF_U";
		}else if(text=="V风"){
		    varText="TM_GRID_ECMWF_V";
		}
        onShowGridMatrix(varText);
	});
	
	
	$("#selectChildren2 dd").click(function () {
		$(this).addClass("selected").siblings().removeClass("selected");
		var text = $(this).find("a").text();  // 找到当前点击的dt下的a标签并获取其内容
        var varText="TM_GRID_JAPAN_PRE";
        if(text=="温度"){
           varText="TM_GRID_JAPAN_T";
        }else if(text=="位势高度"){
            varText="TM_GRID_JAPAN_H";
        }else if(text=="U风"){
            varText="TM_GRID_JAPAN_U";
        }else if(text=="V风"){
            varText="TM_GRID_JAPAN_V";
        }
		onShowGridMatrix(varText);
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
			 			   //alert(value);
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