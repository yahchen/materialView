package com.hx.syncer.util;

import java.util.*;

/**
 * Created by yahchen on 2018/1/11.
 */
public class DataSyncerConstants {
    public static final int SITEHEAD = 1;
    public static final int GRIDHEAD = 2;
    public static final int FILEHEAD = 3;
    public static final Map<String,String> fNameMap = new HashMap();

    static {
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUA-045KM-BAWX-","AMSUA_NOAA15");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-AMSUA-045KM-BAWX-","AMSUA_NOAA18");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-BAWX-","AMSUA_NOAA19_BAWX");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMP-PROC-","AMSUA_NOAA19_EUMP");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMS-EUMS-EATH-PROC-","AMSUA_NOAA19_EUMS");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMP-PROC-","AMSUA_MTB_EUMP");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMS-EUMS-EEDM-PROC-","AMSUA_MTB_EUMS");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMC-PROC-","AMSUA_MTA_EUMC");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMS-EUMS-EMAS-PROC-","AMSUA_MTA_EUMS");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUB-015KM-BAWX-","AMSUB_NOAA15");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-MHS-015KM-BAWX-","MHS_NOAA18");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-MHS-015KM-BAWX-","MHS_NOAA19");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-MHS-015KM-EUMC-PROC-","MHS_MTB");
        fNameMap.put("SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-MHS-015KM-EUMP-PROC-","MHS_MTA");
        fNameMap.put("SATE_L1_MTA_IASI_MWB_RED_GLB-EUMP-","IASI_MTA");
        fNameMap.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTB-EKMI-","GNSS_MTB");
        fNameMap.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTA-EKMI-","GNSS_MTA");
        fNameMap.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TDMX-EDZW-","GNSS_TDMX");
        fNameMap.put("SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TSAR-EDZW-","GNSS_TASR");
        fNameMap.put("SATE_L1_MTA_ASCAT_MWB_S1C_GLB-025KM-GLB-EHDB-","ASCAT_MTA");
    }
}
