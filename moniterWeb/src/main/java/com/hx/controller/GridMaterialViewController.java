package com.hx.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hx.bean.FileStateInfo;
import com.hx.bean.GridDataHead;
import com.hx.bean.GridMatrixMessageEnum;
import com.hx.bean.MatrixErrorEnum;
import com.hx.service.GridMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class GridMaterialViewController {

    @Autowired
    @Qualifier("gridMatrixServiceImpl")
    private GridMatrixService gridMatrixService;

    @RequestMapping("/grid_matrix_view")//对应url
    public String gridMaterialView(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        //String data_logo=request.getParameter("data_logo");
       // mv.setViewName("grid/grid_matrix");
        //mv.addObject("data_logo",data_logo);
        return "grid/grid_matrix";
    }

    @RequestMapping("/findMatrixByTimeElement")//对应url
    @ResponseBody
    public Map<String,Object> findMatrixByTimeElement(HttpServletRequest request,ModelAndView mv){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。

        String queryTime=request.getParameter("queryTime");
        String queryElment=request.getParameter("queryElment");
        //if(queryTime==null||"".equals(queryTime)){
         //   queryTime=dateSubN(1);
        //}
        String sTime = queryTime + " 00:00:00";
        String eTime= queryTime + " 23:59:59";
        //startTime endTime两者全不为空，则按时间查，否则有一个为空，则按时区查

        List<Map<String, Object>> gridDataHeadList=gridMatrixService.findMatrixByTimeElement(sTime,eTime,queryElment);

        Map jsonMap=new HashMap();

        if(gridDataHeadList.size()>0){
            Map<String, Object> gridDataHeadMap=gridDataHeadList.get(0);
            String[] mGridArray=gridDataHeadMap.get("gridfile_state").toString().split(";");//文件状态 3个，每个为：1,1,1,1,1,1,1,1,-1,-1,-1; 1,1,1,1,1,1,1,1,-1,-1,-1; 1,1,1,1,1,1,1,1,1,1,1
            String [] gridFileInfos=gridDataHeadMap.get("return_abnormal_info").toString().split("#");//文件提示信息
            String[] validTimes=gridDataHeadMap.get("validtime").toString().split(",");//时效 200,500,850

            List jsonList=new ArrayList<>();
            Map jsonItemHead=new TreeMap<>();
            jsonItemHead.put("item00", "");
            for(int j=1;j<=validTimes.length;j++){
                if(j>9){//主要是为了TreeMap排序，如果0，1，2，3，4，5，6，7，8，9，10那么排序为：0，1，10，2，增加判断是为了组装成：00，01，02，03，...，10方便排序
                    jsonItemHead.put(("item"+j), validStrLen(validTimes[j-1]));
                }else{
                    jsonItemHead.put(("item0"+j), validStrLen(validTimes[j-1]));
                }
            }
            jsonList.add(jsonItemHead);

            String[] fcstLevels=gridDataHeadMap.get("fcstlevel").toString().split(",");//层次

            for(int i=0;i<mGridArray.length;i++){
                Map jsonItemMap=new TreeMap<>();
                jsonItemMap.put("item00", fcstLevels[i]+"Pa");
                String[]	mGridItem=mGridArray[i].split(",");
                String[] gridFileInfo=gridFileInfos[i].split(";");
                for(int j=1;j<=mGridItem.length;j++){
                    FileStateInfo fileStateInfo=new FileStateInfo();
                    if(j>9){//主要是为了TreeMap排序，如果0，1，2，3，4，5，6，7，8，9，10那么排序为：0，1，10，2，增加判断是为了组装成：00，01，02，03，...，10方便排序
                        fileStateInfo.setFileState(mGridItem[j-1]);
                        fileStateInfo.setFileInfo(MatrixErrorEnum.getErrorEnumByCode(gridFileInfo[j-1]));
                        jsonItemMap.put(("item"+j), fileStateInfo);
                    }else{
                        fileStateInfo.setFileState(mGridItem[j-1]);
                        fileStateInfo.setFileInfo(MatrixErrorEnum.getErrorEnumByCode(gridFileInfo[j-1]));
                        jsonItemMap.put(("item0"+j), fileStateInfo);
                    }
                }
                jsonList.add(jsonItemMap);
            }
            jsonMap.put("list", jsonList);
            jsonMap.put("listLen", jsonList.size());
            jsonMap.put("listMessage",queryTime+ GridMatrixMessageEnum.getMatricMessageByCode(queryElment)+"矩阵图");
        }else{
            jsonMap.put("listLen","0");
            jsonMap.put("listMessage",queryTime+GridMatrixMessageEnum.getMatricMessageByCode(queryElment)+"无数据！");
        }
        return jsonMap;
    }

    /**
     * 校验支付串长度，不足两位补充到2位
     * @param str
     * @return
     */
    public String validStrLen(String str){
        if(str==null&&"".equals(str)){
            return str;
        }else if(str.length()==1){
            return "00"+str;
        }else if(str.length()==2){
            return "0"+str;
        }
        return str;
    }

    //当前日期减N天，返回yyyy-mm-dd格式的日期字符串
    public String dateSubN(int n){
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - n);
        String endDate = dft.format(date.getTime());
        return endDate;
    }

    //文件信息解析并保存到对象fileStateInfo中
}
