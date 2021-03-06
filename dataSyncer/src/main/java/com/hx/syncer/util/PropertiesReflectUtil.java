package com.hx.syncer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yahchen on 2017/11/5.
 */
@Service
@Slf4j
public class PropertiesReflectUtil {
    //private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

    private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

    public void autowiredProperty(Object o, Class cls, String k, String v) {
        if (StringUtils.isEmpty(k) || StringUtils.isEmpty(v))
            return;
        Method[] ms = cls.getMethods();
        try {
            for (Method m : ms) {
                String mName = m.getName().toLowerCase();
                if (mName.startsWith("set") && mName.endsWith(k.toLowerCase())) {
                    String type = m.getParameterTypes()[0].getSimpleName();
                    if (type.equalsIgnoreCase("float")) {
                        float vf = StringUtils.isEmpty(v) ? 0f : Float.valueOf(v);
                        m.invoke(o, vf);
                    } else if (type.equalsIgnoreCase("long")) {
                        long vl = StringUtils.isEmpty(v) ? 0L : Long.valueOf(v);
                        m.invoke(o, vl);
                    } else if (type.equalsIgnoreCase("int")) {
                        int vi = StringUtils.isEmpty(v) ? 0 : Integer.valueOf(v);
                        m.invoke(o, vi);
                    } else if (type.equalsIgnoreCase("double")) {
                        double vi = StringUtils.isEmpty(v) ? 0 : Double.valueOf(v);
                        m.invoke(o, vi);
                    } else if (type.equalsIgnoreCase("Timestamp")) {
                        if (!StringUtils.isEmpty(v)) {
                            if (!v.contains(":")) {   //不包含“：”的时间
                                SimpleDateFormat ff = new SimpleDateFormat("yyyyMMddHHmm");
                                Date currentTime = ff.parse(v);

                                SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String dateString = fo.format(currentTime);
                                v = dateString;

                            }

                        } else {
                            v = System.currentTimeMillis() + "";
                        }
                        Timestamp vd = Timestamp.valueOf(v);
                        m.invoke(o, vd);
                    } else {
                        m.invoke(o, v);
                    }
                    return;
                }
            }
        } catch (Exception e) {
            log.info("autowrite error for bean filed,keyName:" + k + ",value:" + v,e);
        }

    }

    public String getFiledValue(Object o, String k) {
        if (StringUtils.isEmpty(k))
            return null;
        Method[] ms = o.getClass().getMethods();
        try {
            for (Method m : ms) {
                String mName = m.getName().toLowerCase();
                if (checkMname(mName,k) && mName.startsWith("get") && mName.endsWith(k.toLowerCase())) {
                    return m.invoke(o).toString();
                }
            }
        } catch (Exception e) {
            log.info("PropertiesReflectUtil.getfiledValue error,keyName:" + k,e);
        }
        return null;
    }

    private boolean checkMname(String mname,String coreName){
        if(StringUtils.isEmpty(mname))
            return false;
        String checkMname = mname.replaceFirst("get","").replaceFirst(coreName,"");
        if(checkMname.trim().length() <= 0)
            return true;
        return false;
    }
}
