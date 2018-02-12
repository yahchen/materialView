package com.hx.dao.impl;

import com.hx.bean.BehaviorRecordParam;
import com.hx.bean.TableEnum;
import com.hx.dao.BehaviorRecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BehaviorRecordDaoImpl implements BehaviorRecordDao {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    @Override
    public List<Map<String, Object>> findRecordByPage(BehaviorRecordParam behaviorRecordParam) {
        return null;
    }

    @Override
    public Long findRecordSize(BehaviorRecordParam behaviorRecordParam) {
        return null;
    }

    public Map<String, Object> findRecordsByPage(BehaviorRecordParam behaviorRecordParam) {

        String sqlWhere = buildSqlWhere(behaviorRecordParam);
        sqlWhere += " order by data_time ASC ";
        List<Map<String, Object>> dataHeadList = null;
        Long total = 0L;
        Long startIndex = (behaviorRecordParam.getPageNo() - 1L) * behaviorRecordParam.getPageSize();
        String tableStr = TableEnum.getTableByCode(behaviorRecordParam.getMaterialType());
        Map<String, Object> map = new HashMap<>();

        String sSQL = "select * from " + tableStr + sqlWhere + " limit " + behaviorRecordParam.getPageSize() + " offset " + startIndex + ";";
        String sSQLCount = "select * from " + tableStr + sqlWhere;
        String dateTimeStr = " ";
        //System.out.println(sSQL);
        dataHeadList = template.queryForList(sSQL);
        for (Map<String, Object> list : dataHeadList) {
            int a = list.get("return_abnormal_info").toString().indexOf("-1");
            String succOrFailStr = "成功";
            if (a >= 0) {
                succOrFailStr = "失败";
            }
            if (list.get("data_time") != null) {
                dateTimeStr = list.get("data_time").toString();
            }
            list.put("data_time", dateTimeStr.substring(0, dateTimeStr.length() - 2));
            list.put("return_abnormal_info", succOrFailStr);
        }
        total = Long.valueOf(template.queryForList(sSQLCount).size());

        map.put("data", dataHeadList);
        map.put("total", total);
        return map;
    }

    @Override
    public List<Map<String, Object>> findMaterialName(BehaviorRecordParam behaviorRecordParam) {
        String sqlWhere = buildSqlWhere(behaviorRecordParam);
        String tableStr = TableEnum.getTableByCode(behaviorRecordParam.getMaterialType());
        String sqlStr = "select distinct(data_logo),data_name from " + tableStr + sqlWhere;
        List<Map<String, Object>> list = template.queryForList(sqlStr);
        return list;
    }

    //查询资料名称
    @Override
    public List<Map<String, Object>> findSatelliteName(BehaviorRecordParam behaviorRecordParam) {
        String sqlWhere = buildSqlWhere(behaviorRecordParam);
        String tableStr = TableEnum.getTableByCode(behaviorRecordParam.getMaterialType());
        String sqlStr = "select distinct(sate_name) from " + tableStr + sqlWhere;
        List<Map<String, Object>> list = template.queryForList(sqlStr);
        return list;
    }

    private String buildSqlWhere(BehaviorRecordParam behaviorRecordParam) {
        String sqlWhere = " where 1=1";

        //开始时间
        if (behaviorRecordParam.getStartTime() != null && !behaviorRecordParam.getStartTime().equals("")) {
            sqlWhere += " and data_time > '" + behaviorRecordParam.getStartTime() + "'";
        }

        //结束时间
        if (behaviorRecordParam.getEndTime() != null && !behaviorRecordParam.getEndTime().equals("")) {
            sqlWhere += " and data_time <= '" + behaviorRecordParam.getEndTime() + "'";
        }

        //两个条件：资料类型
        if (behaviorRecordParam.getMaterialType() != null && !behaviorRecordParam.getMaterialType().equals("")) {
            sqlWhere += " and data_type = '" + behaviorRecordParam.getMaterialType() + "'";
        }

        //资料名称
        if (behaviorRecordParam.getMaterialName() != null && !behaviorRecordParam.getMaterialName().equals("") && !behaviorRecordParam.getMaterialName().equals("0")) {
            sqlWhere += " and data_logo = '" + behaviorRecordParam.getMaterialName() + "'";
        }

        //卫星名称
        if (behaviorRecordParam.getSateName() != null && !behaviorRecordParam.getSateName().equals("") && !behaviorRecordParam.getSateName().equals("0")) {//用户名
            sqlWhere += " and sate_name = '" + behaviorRecordParam.getSateName() + "'";
        }

        //耗时
        if (behaviorRecordParam.getTimeConsumeIndex() != null && !behaviorRecordParam.getTimeConsumeIndex().equals("") && !behaviorRecordParam.getTimeConsumeIndex().equals("0")) {
            String timeConValue = behaviorRecordParam.getTimeConsume().substring(0, behaviorRecordParam.getTimeConsume().length() - 1);
            if ("1".equals(behaviorRecordParam.getTimeConsumeIndex()) || "4".equals(behaviorRecordParam.getTimeConsumeIndex())) {
                sqlWhere += " and retrieve_process_time " + timeConValue;
            } else {//    2:1-2s  3:2-5s
                String strs[] = timeConValue.split("-");
                sqlWhere += " and retrieve_process_time > " + strs[0] + " and retrieve_process_time <= " + strs[1];
            }
        }

        //成功/失败
        if (behaviorRecordParam.getSuccFail() != null && !behaviorRecordParam.getSuccFail().equals("") && !behaviorRecordParam.getSuccFail().equals("0")) {
            if (behaviorRecordParam.getSuccFail().equals("1")) {//成功  字符串中没有 -1
                sqlWhere += " and return_abnormal_info not like '%-1%'";
            } else if (behaviorRecordParam.getSuccFail().equals("-1")) {//失败   字符串中有-1
                sqlWhere += " and return_abnormal_info like '%-1%'";
            }
        }

        //模式类型
        sqlWhere += " and mode_type = " + behaviorRecordParam.getModeType();
        return sqlWhere;
    }

}
