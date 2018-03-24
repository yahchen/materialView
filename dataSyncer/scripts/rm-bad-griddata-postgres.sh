#!/usr/bin/env bash
export PGPASSWORD=postgres
sed -i "s/data_logo=[a-zA-Z_\-\:\d\']*/data_logo='$1'/" /data/rmGridDataPsql.sql
sed -i "s/data_time=[0-9\-\']*/data_time='$2'/" /data/rmGridDataPsql.sql
sed -i "s/s_d_id=[0-9]*/s_d_id='$3'/" /data/rmGridDataPsql.sql
psql -U postgres -h 127.0.0.1 -d postgres -f /data/rmGridDataPsql.sql


#测试用例：sh rm-bad-griddata-postgres.sh ﻿GM_RSURF_GL '2017-10-11 00:00:00' 25#!/usr/bin/env bash