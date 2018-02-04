package com.hx.syncer.util;

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
                    } else if(type.equalsIgnoreCase("double")){
                        double vi = StringUtils.isEmpty(v) ? 0 : Double.valueOf(v);
                        m.invoke(o, vi);
                    }else if (type.equalsIgnoreCase("Timestamp")) {
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
            System.out.println("Exception"+ e);
        }

    }

    public String getFiledValue(Object o,String k){
        if (StringUtils.isEmpty(k))
            return null;
        Method[] ms = o.getClass().getMethods();
        try {
            for (Method m : ms) {
                String mName = m.getName().toLowerCase();
                if (mName.startsWith("get") && mName.endsWith(k.toLowerCase())) {
                    return m.invoke(o).toString();
                }
            }
        } catch (Exception e) {

        }
        return null;
    }
}
