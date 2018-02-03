package com.hx.syncer.service;

import com.hx.syncer.dao.BaseRepository;
import com.hx.syncer.util.DbUtils;
import com.hx.syncer.util.PropertiesReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahchen on 2018/1/13.
 */
@Service
public class SateDataBinFileService {
    @Autowired
    private PropertiesReflectUtil propertiesReflectUtil;
    @Autowired
    private DbUtils dbUtils;
    public void readAndSaveFileBin(String tableName,String sfId,Path satePath) {
        BaseRepository baseRepository = dbUtils.getTableEleDaoObj(tableName);
        try(InputStream in = new FileInputStream(satePath.toFile())) {
            // 一次读多个字节
            byte[] tempbytes = new byte[4];
            int byteread = 0;
            int X =0 ,n = 0;            //
            int iPos = 1 ;              // 用于读取atovs数据中的一条数据的下标值（为1-86）
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            List<Object> sateBinBeanList = new ArrayList<>();
            StringBuffer dateSb = null;
            boolean isNeedCreate = true;
            Object sateBean = null;
            int wait_count = 0;
            while ((byteread = in.read(tempbytes)) != -1) {
                if(isNeedCreate) {
                    wait_count++;
                    sateBean = dbUtils.getTableEleBeanClassName(tableName);
                    propertiesReflectUtil.autowiredProperty(sateBean, sateBean.getClass(), "f_d_id", sfId);
                    dateSb = new StringBuffer();
                    isNeedCreate = false;
                }
                int value = byteArrayToInt(tempbytes);
                if( 1 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"sat_id",value+"");
                }else if(2 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"instrument_id",value+"");
                    
					// 探测仪器代号（如：5=HIRS；10=AMSU-A；11=AMSU-B）
            		if(5 == value){             //	HIRS：X=40，n=20
            			X = 40;
            			n = 20;
            		}else if(10 == value){      //	AMSU-A：X=35, n=15
            			X = 35;
            			n = 15;
            		}else if(11 == value){      //	AMSU-B/MHS：X=25，n=5
            			X = 25;
            			n = 5;
            		}else if(12 == value){      //	AMSU-B/MHS：X=25，n=5
            			X = 25;
            			n = 5;
            		}else if(221 == value){      //	IASI：X=25；通道数n=8471 但是实际为502
            			X = 25;
            			n = 502;
            		}else{                      //	AMSU-B/MHS：X=25，n=10
            			X = 25;
            			n = 10;
            		}

                }else if(3 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"scan_line",value+"");
                }else if(4 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"scan_fov",value+"");
                }else if(5 == iPos){//year
                    dateSb.append(value);
                }else if(6 == iPos){//mon
                    dateSb.append(value);
                }else if(7 == iPos){//day
                    dateSb.append(value);
                }else if(8 == iPos){//hour
                    dateSb.append(value);
                }else if(9 == iPos){//min
                    dateSb.append(value);
                }else if(10 == iPos){//sec
                    dateSb.append(value);
                }else if(11 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"obs_lat",value/100+"");
                }else if(12 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"obs_lon",value/100+"");
                }else if(13 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"surface_mark",value+"");
                }else if(14 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"fsurface_height",value+"");
                }else if(15 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"fLocal_zenith",value/100+"");
                }else if(16 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"local_azimuth",value/100+"");
                }else if(17 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"solar_zenith",value/100+"");
                }else if(18 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"solar_azimuth",value+"");
                }else if(19 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"sat_scalti",value+"");
                }else if(20 == iPos){
                    propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"obs_dataqual",value+"");
                }
                iPos ++;
                // 扫描到一组数据后，添加到ArrayList列表中
                if ( (21+n) == iPos){
                    //propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"file_name_time",dateSb.toString());
					 propertiesReflectUtil.autowiredProperty(sateBean,sateBean.getClass(),"scan_time",dateSb.toString());
                    dateSb = new StringBuffer();
                    sateBinBeanList.add(sateBean);
                    iPos = 1;
                    isNeedCreate = true;
                    if(wait_count == 2000){
                        baseRepository.save(sateBinBeanList);
                        sateBinBeanList = new ArrayList<>();
                        wait_count = 0;
                    }
                }
            }
            if(!sateBinBeanList.isEmpty())
                baseRepository.save(sateBinBeanList);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    // byte 数组与 int 的相互转换
    public int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16
                | (b[0] & 0xFF) << 24;
    }

    public byte[] intToByteArray(int a) {
        return new byte[] { (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF) };
    }
}
