package com.hx.syncer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.sql.Timestamp;

/**
 * Created by yahchen on 2017/11/5.
 */
@Service
public class PropertiesReflectUtil {

    public void autowiredProperty(Object o,Class cls,String k,String v){
        Method[] ms = cls.getMethods();
        try {
            for(Method m:ms){
                String mName = m.getName().toLowerCase();
                if(mName.startsWith("set") && mName.endsWith(k.toLowerCase())){
                    String type = m.getParameterTypes()[0].getSimpleName();
                    if(type.equals("long")){
                        long vl = StringUtils.isEmpty(v)?0L:Long.valueOf(v);
                        m.invoke(o, vl);
                    }else if(type.equals("int")){
                        int vi = StringUtils.isEmpty(v)?0:Integer.valueOf(v);
                        m.invoke(o, vi);
                    }else if(type.equals("double")){
                        double vd = StringUtils.isEmpty(v)?0:Double.valueOf(v);
                        m.invoke(o, vd);
                    }else if(type.equals("Timestamp")){
                        Timestamp vd = StringUtils.isEmpty(v)?new Timestamp(System.currentTimeMillis()): Timestamp.valueOf(v);
                        m.invoke(o, vd);
                    }else {
                        m.invoke(o, v);
                    }
                }
            }
        }catch (Exception e){

        }

    }
}
