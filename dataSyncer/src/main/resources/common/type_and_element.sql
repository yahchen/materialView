-- Table: public.type_and_element_mapping

-- DROP TABLE public.type_and_element_mapping;

CREATE TABLE public.type_and_element_mapping
(
    data_logo_type character varying(200) COLLATE pg_catalog."default",
    data_logo_type_comment character varying(255) COLLATE pg_catalog."default",
    element_type character varying(200) COLLATE pg_catalog."default",
    element_type_comment character varying(255) COLLATE pg_catalog."default",
    quality_code character varying(200) COLLATE pg_catalog."default",
    quality_code_comment character varying(255) COLLATE pg_catalog."default",
    id bigint NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.type_and_element_mapping
    OWNER to postgres;


//插入数据
﻿INSERT INTO public.type_and_element_mapping(
	data_logo_type,data_logo_type_comment,element_type,element_type_comment,quality_code,quality_code_comment, id)
	VALUES
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料',  'PRS_Sea','海平面气压', 'Q_PRS_Sea','海平面气压质控码', 1),
    ('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'TEM', '温度/气温', 'Q_TEM','温度/气温质控码', 2),
    ('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 3),
    ('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 4),
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 5),
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_1h','过去1小时降水量', 'Q_PRE_1h','过去1小时降水量质控码', 6),
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_6h','过去6小时降水量', 'Q_PRE_6h','过去6小时降水量质控码', 7),
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_24h','过去24小时降水量', 'Q_PRE_24h','过去24小时降水量质控码', 8),
	('GM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRS','气压', 'Q_PRS','气压质控码', 9),


	('GM_RSURF_CH', '国内自动站地面气象资料',  'PRS_Sea','海平面气压', 'Q_PRS_Sea','海平面气压质控码', 10),
    ('GM_RSURF_CH', '国内自动站地面气象资料', 'TEM', '温度/气温', 'Q_TEM','温度/气温质控码', 11),
    ('GM_RSURF_CH', '国内自动站地面气象资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 12),
    ('GM_RSURF_CH', '国内自动站地面气象资料', 'WIN_D_INST','瞬时风向', 'Q_WIN_D_INST','瞬时风向质控码', 13),
	('GM_RSURF_CH', '国内自动站地面气象资料', 'WIN_S_INST','瞬时风速', 'Q_WIN_S_INST','瞬时风速质控码', 14),
	('GM_RSURF_CH', '国内自动站地面气象资料', 'PRE_1h','过去1小时降水量', 'Q_PRE_1h','过去1小时降水量质控码', 15),
	('GM_RSURF_CH', '国内自动站地面气象资料', 'PRE_6h','过去6小时降水量', 'Q_PRE_6h','过去6小时降水量质控码', 16),
	('GM_RSURF_CH', '国内自动站地面气象资料', 'PRE_24h','过去24小时降水量', 'Q_PRE_24h','过去24小时降水量质控码', 17),
	('GM_RSURF_CH', '国内自动站地面气象资料', 'PRS','气压', 'Q_PRS','气压质控码', 18),


	('GM_RTEMP_GL', '高空探测资料', 'Alti','测站高度', '','', 19),
	('GM_RTEMP_GL', '高空探测资料', 'PRS_HWC','', 'Q_PRS_HWC','', 20),
  ('GM_RTEMP_GL', '高空探测资料', 'EVSS', '', '','', 21),
  ('GM_RTEMP_GL', '高空探测资料', 'GPH','位势高度', 'Q_GPH','位势高度质控码', 22),
  ('GM_RTEMP_GL', '高空探测资料', 'TEM','温度/气温', 'Q_TEM','温度/气温质控码', 23),
	('GM_RTEMP_GL', '高空探测资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 24),
	('GM_RTEMP_GL', '高空探测资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 25),
	('GM_RTEMP_GL', '高空探测资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 26),
	('GM_RTEMP_GL', '高空探测资料', 'Time_Dev_WQ','时间偏差', '','', 27),
	('GM_RTEMP_GL', '高空探测资料', 'Lat_Dev','纬度偏差', 'Q_Lat_Dev','纬度偏差质控码', 28),
	('GM_RTEMP_GL', '高空探测资料', 'Lon_Dev','经度偏差', 'Q_Lon_Dev','经度偏差质控码', 29),


	('GM_GRID_KWBC_GL', '美国海温格点', 'TEF2','测站高度', '','', 30),



    ('TM_RSURF_PRE_1h', '地面1小时降水资料', 'PRE_1h','过去1小时降水量', '','', 31),
	('TM_RSURF_PRE_3h', '地面3小时降水资料', 'PRE_3h','过去3小时降水量', '','', 32),
	('TM_RSURF_PRE_6h', '地面6小时降水资料', 'PRE_6h','过去6小时降水量', '','', 33),
	('TM_RSURF_PRE_12h', '地面12小时降水资料', 'PRE_12h','过去12小时降水量', '','', 34),
	('TM_RSURF_PRE_24h', '地面24小时降水资料', 'PRE_24h','过去24小时降水量', '','', 35),

	('TM_RSURF_1h', '地面1小时观测资料', 'Alti','测站高度', '','', 36),
	('TM_RSURF_1h', '地面1小时观测资料', 'TEM','温度/气温', '','', 37),
	('TM_RSURF_1h', '地面1小时观测资料', 'PRS','气压', '','', 38),
	('TM_RSURF_1h', '地面1小时观测资料', 'DPT','露点温度', '','', 39),
	('TM_RSURF_1h', '地面1小时观测资料', 'WIN_D_INST','瞬时风向', '','',40),
	('TM_RSURF_1h', '地面1小时观测资料', 'WIN_S_INST','瞬时风速', '','', 41),
	('TM_RSURF_1h', '地面1小时观测资料', 'PRE_1h','过去1小时降水量', '','', 42),
	('TM_RSURF_1h', '地面1小时观测资料', 'TEM_Max','最高气温', '','', 43),
	('TM_RSURF_1h', '地面1小时观测资料', 'TEM_Min','最低气温', '','', 44),
	('TM_GRID_ECMWF_U', '欧洲中心格点场资料', 'WIU','欧洲中心数值预报产品-低分辨率-全球 u风', '','', 45),
	('TM_GRID_ECMWF_V', '欧洲中心格点场资料', 'WIV','欧洲中心数值预报产品-低分辨率-全球 v风', '','', 46),
	('TM_GRID_ECMWF_H', '欧洲中心格点场资料', 'GPH','欧洲中心数值预报产品-低分辨率-全球 位势高度', '','', 47),
	('TM_GRID_ECMWF_T', '欧洲中心格点场资料', 'TEM','欧洲中心数值预报产品-低分辨率-全球 温度', '','', 48),
	('TM_GRID_JAPAN_U', '日本格点场降水资料', 'WIU','日本数值预报产品-低分辨率-北半球 u风', '','', 49),
	('TM_GRID_JAPAN_V', '日本格点场降水资料', 'WIV','日本数值预报产品-低分辨率-北半球 v风', '','', 50),
	('TM_GRID_JAPAN_H', '日本格点场降水资料', 'GPH','日本数值预报产品-低分辨率-北半球 位势高度', '','', 51),
	('TM_GRID_JAPAN_T', '日本格点场降水资料', 'TEM','日本数值预报产品-低分辨率-北半球 温度', '','', 52),
	('TM_GRID_JAPAN_PRE', '日本格点场降水资料', 'TPE','日本数值预报产品-低分辨率-远东区域（中国）降水', '','', 53),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'Alti','测站高度', '','', 54),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料',  'PRS_Sea','海平面气压', 'Q_PRS_Sea','海平面气压质控码', 55),
    ('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'TEM', '温度/气温', 'Q_TEM','温度/气温质控码', 56),
    ('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 57),
    ('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 58),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 59),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_1h','过去1小时降水量', 'Q_PRE_1h','过去1小时降水量质控码', 60),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_6h','过去6小时降水量', 'Q_PRE_6h','过去6小时降水量质控码', 61),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRE_24h','过去24小时降水量', 'Q_PRE_24h','过去24小时降水量质控码', 62),
	('RM_RSURF_GL', '地面常规观测（含船舶、浮标）资料', 'PRS','气压', 'Q_PRS','气压质控码', 63),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'Alti','测站高度', '','', 64),
	('RM_RSURF_CH', '国内自动站地面气象资料',  'PRS_Sea','海平面气压', 'Q_PRS_Sea','海平面气压质控码',65),
  ('RM_RSURF_CH', '国内自动站地面气象资料', 'TEM', '温度/气温', 'Q_TEM','温度/气温质控码', 66),
  ('RM_RSURF_CH', '国内自动站地面气象资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 67),
  ('RM_RSURF_CH', '国内自动站地面气象资料', 'WIN_D_INST','瞬时风向', 'Q_WIN_D_INST','瞬时风向质控码', 68),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'WIN_S_INST','瞬时风速', 'Q_WIN_S_INST','瞬时风速质控码', 69),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'PRE_1h','过去1小时降水量', 'Q_PRE_1h','过去1小时降水量质控码', 70),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'PRE_6h','过去6小时降水量', 'Q_PRE_6h','过去6小时降水量质控码', 71),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'PRE_24h','过去24小时降水量', 'Q_PRE_24h','过去24小时降水量质控码', 72),
	('RM_RSURF_CH', '国内自动站地面气象资料', 'PRS','气压', 'Q_PRS','气压质控码', 73),
	('RM_RTEMP_GL', '高空探测资料', 'Alti','测站高度', '','', 74),
	('RM_RTEMP_GL', '高空探测资料', 'PRS_HWC','', 'Q_PRS_HWC','', 75),
  ('RM_RTEMP_GL', '高空探测资料', 'EVSS', '', '','', 76),
  ('RM_RTEMP_GL', '高空探测资料', 'GPH','位势高度', 'Q_GPH','位势高度质控码', 77),
  ('RM_RTEMP_GL', '高空探测资料', 'TEM','温度/气温', 'Q_TEM','温度/气温质控码', 78),
	('RM_RTEMP_GL', '高空探测资料', 'DPT','露点温度', 'Q_DPT','露点温度质控码', 79),
	('RM_RTEMP_GL', '高空探测资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 80),
	('RM_RTEMP_GL', '高空探测资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 81),
	('RM_RTEMP_GL', '高空探测资料', 'Time_Dev_WQ','时间偏差', '','', 82),
	('RM_RTEMP_GL', '高空探测资料', 'Lat_Dev','纬度偏差', 'Q_Lat_Dev','纬度偏差质控码', 83),
	('RM_RTEMP_GL', '高空探测资料', 'Lon_Dev','经度偏差', 'Q_Lon_Dev','经度偏差质控码', 84);



  ('GM_RSING_GL', '飞机探测资料', 'Flight_Stat','飞机飞行详细状态', '','', 85),
  ('GM_RSING_GL', '飞机探测资料', 'Flight_Heigh','飞行高度(气压高度)', 'Q_Flight_Heigh','飞行高度(气压高度)质控码', 86),
  ('GM_RSING_GL', '飞机探测资料', 'TEM','温度/气温', 'Q_TEM','温度/气温质控码', 87),
  ('GM_RSING_GL', '飞机探测资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 88),
  ('GM_RSING_GL', '飞机探测资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 89),

  ('RM_RSING_GL', '飞机探测资料', 'Flight_Stat','飞机飞行详细状态', '','', 90),
  ('RM_RSING_GL', '飞机探测资料', 'Flight_Heigh','飞行高度(气压高度)', 'Q_Flight_Heigh','飞行高度(气压高度)质控码', 91),
  ('RM_RSING_GL', '飞机探测资料', 'TEM','温度/气温', 'Q_TEM','温度/气温质控码', 92),
  ('RM_RSING_GL', '飞机探测资料', 'WIN_D','平均风向', 'Q_WIN_D','平均风向质控码', 93),
  ('RM_RSING_GL', '飞机探测资料', 'WIN_S','平均风速', 'Q_WIN_S','平均风速质控码', 94),
