package com.hx.syncer.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yahchen on 2018/1/11.
 */
public class DataSyncerConstants {
    public static final int SITEHEAD = 1;
    public static final int GRIDHEAD = 2;
    public static final int FILEHEAD = 3;
    public static final int SATEFILEHEAD = 4;
    public static final Map<String, String> FILTERFILENAMEMAP = new HashMap();

    public static final Map<String, String> SITE_DATA_DAO_NAMES = new HashMap<>();
    public static final Map<String, String> SITE_DATA_DO_NAMES = new HashMap<>();
    public static final String[] DATA_HEAD_TABLE_KEYS = {"data_name","data_code","retrieve_start_time","retrieve_end_time","retrieve_process_time","file_path","data_start_time","data_end_time","longitude_latitude_scope","sys_conn_state","data_num","user_id","system_name","data_type","mode_type","return_abnormal_info","id"};


    static {
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUA-045KM-BAWX-", "AMSUA_NOAA15");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-AMSUA-045KM-BAWX-", "AMSUA_NOAA18");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-BAWX-", "AMSUA_NOAA19_BAWX");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMP-PROC-", "AMSUA_NOAA19_EUMP");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMS-EUMS-EATH-PROC-", "AMSUA_NOAA19_EUMS");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMP-PROC-", "AMSUA_MTB_EUMP");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMS-EUMS-EEDM-PROC-", "AMSUA_MTB_EUMS");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMC-PROC-", "AMSUA_MTA_EUMC");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMS-EUMS-EMAS-PROC-", "AMSUA_MTA_EUMS");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUB-015KM-BAWX-", "AMSUB_NOAA15");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-MHS-015KM-BAWX-", "MHS_NOAA18");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-MHS-015KM-BAWX-", "MHS_NOAA19");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-MHS-015KM-EUMC-PROC-", "MHS_MTB");
        FILTERFILENAMEMAP.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-MHS-015KM-EUMP-PROC-", "MHS_MTA");
        FILTERFILENAMEMAP.put("SATE_L1_MTA_IASI_MWB_RED_GLB-EUMP-", "IASI_MTA");
        FILTERFILENAMEMAP.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTB-EKMI-", "GNSS_MTB");
        FILTERFILENAMEMAP.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTA-EKMI-", "GNSS_MTA");
        FILTERFILENAMEMAP.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TDMX-EDZW-", "GNSS_TDMX");
        FILTERFILENAMEMAP.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TSAR-EDZW-", "GNSS_TASR");
        FILTERFILENAMEMAP.put("SATE_L1_MTA_ASCAT_MWB_S1C_GLB-025KM-GLB-EHDB-", "ASCAT_MTA");

        SITE_DATA_DAO_NAMES.put("GM_RSURF_CH", "gmSiteSurfChDao");
        SITE_DATA_DAO_NAMES.put("GM_RTEMP_GL", "gmSiteTempGlDao");
        SITE_DATA_DAO_NAMES.put("GM_RSURF_GL", "gmSiteSurfGlDao");


        SITE_DATA_DAO_NAMES.put("RM_RSURF_CH", "rmSiteSurfChDao");
        SITE_DATA_DAO_NAMES.put("RM_RTEMP_GL", "rmSiteTempGlDao");
        SITE_DATA_DAO_NAMES.put("RM_RSURF_GL", "rmSiteSurfGlDao");

        SITE_DATA_DAO_NAMES.put("TM_RSURF_1h", "tmSiteSurf1hDao");
        SITE_DATA_DAO_NAMES.put("TM_RSURF_PRE_1h", "tmSiteSurfPre1hDao");
        SITE_DATA_DAO_NAMES.put("TM_RSURF_PRE_3h", "tmSiteSurfPre3hDao");
        SITE_DATA_DAO_NAMES.put("TM_RSURF_PRE_6h", "tmSiteSurfPre6hDao");
        SITE_DATA_DAO_NAMES.put("TM_RSURF_PRE_12h", "tmSiteSurfPre12hDao");
        SITE_DATA_DAO_NAMES.put("TM_RSURF_PRE_24h", "tmSiteSurfPre24hDao");


        SITE_DATA_DO_NAMES.put("GM_RSURF_CH", "GmSiteSurfChDo");
        SITE_DATA_DO_NAMES.put("GM_RTEMP_GL", "GmSiteTempGlDo");
        SITE_DATA_DO_NAMES.put("GM_RSURF_GL", "GmSiteSurfGlDo");


        SITE_DATA_DO_NAMES.put("RM_RSURF_CH", "RmSiteSurfChDo");
        SITE_DATA_DO_NAMES.put("RM_RTEMP_GL", "RmSiteTempGlDo");
        SITE_DATA_DO_NAMES.put("RM_RSURF_GL", "RmSiteSurfGlDo");

        SITE_DATA_DO_NAMES.put("TM_RSURF_1h", "TmSiteSurf1hDo");
        SITE_DATA_DO_NAMES.put("TM_RSURF_PRE_1h", "TmSiteSurfPre1hDo");
        SITE_DATA_DO_NAMES.put("TM_RSURF_PRE_3h", "TmSiteSurfPre3hDo");
        SITE_DATA_DO_NAMES.put("TM_RSURF_PRE_6h", "TmSiteSurfPre6hDo");
        SITE_DATA_DO_NAMES.put("TM_RSURF_PRE_12h", "TmSiteSurfPre12hDo");
        SITE_DATA_DO_NAMES.put("TM_RSURF_PRE_24h", "TmSiteSurfPre24hDo");

    }
}
