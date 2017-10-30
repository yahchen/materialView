<script type="text/javascript">
$(document).ready(function(){
	onShowGridMatrix("GRID_ECMWF_U");
});

onShowGridMatrix=function(aPara){
alert(aPara);
		$( "#sTime" ).datepicker({
			showButtonPanel: true
		});
		var queryCond = {
				"queryTime":$( "#sTime" ).val(),
				"queryElment":aPara
			}; 
		$.ajax({
		 	type:"GET",
		 	dataType:"json",
		 	cache:false,
		 	url:"${pageContext.request.contextPath }/menu/findByTime1.action",
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
			 			   alert(value.fileState);
			 			   if(value.fileState==-1){
			 				  labelStr="<label  class='tooltip'  id='Id12' title='"+value.fileInfo+"' style= 'display:block;width:25px;height:45;background-color: #EE1111;margin-right:'><span class='tooltip'  id='id19' style='font-size:40px;'>&times;</span></label>";
			 			   } else if(value.fileState==1){
			 				  labelStr="<label  style= 'display:block;width:25px;height:45;background-color: #1AE61A;margin-right:'><span  style='font-size:40px;''>&radic;</span></label>";
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
	
	
	function onShowElments(aPara){
		var trStr="";
		if(aPara==1){
			$("#select_condition tr:eq(7)").remove();
			 trStr="<tr><td><button style='width:89px;height:28px' onclick='onShowGridMatrix(\"GRID_ECMWF_U\")' >风的U分量</button>&nbsp;&nbsp;<button style='width:89px;height:28px' onclick='onShowElments(1)' >风的V分量</button>&nbsp;&nbsp;<button style='width:78px;height:28px' onclick='onShowElments(1)' >位势高度</button>&nbsp;&nbsp;<button style='width:68px;height:28px' onclick='onShowElments(1)' >温度</button></td></tr>";
			$("#select_condition").append(trStr);
		}else{
			$("#select_condition tr:eq(7)").remove();
			 trStr="<tr><td><button style='width:89px;height:28px' onclick='onShowGridMatrix(1)' >风的U分量</button>&nbsp;&nbsp;<button style='width:89px;height:28px' onclick='onShowElments(1)' >风的V分量</button>&nbsp;&nbsp;<button style='width:78px;height:28px' onclick='onShowElments(1)' >位势高度</button>&nbsp;&nbsp;<button style='width:68px;height:28px' onclick='onShowElments(1)' >温度</button></td></tr>";
			$("#select_condition").append(trStr);
		}
	}
	
	

	</script>
</head>



</html>
