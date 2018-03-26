#!/usr/bin/env bash
export PGPASSWORD=postgres
sed -i "s/data_logo=[a-zA-Z_\-\:\d\']*/data_logo='$1'/" rmSiteDataPsql.sql
sed -i "s/data_time=[0-9\-\']*/data_time='$2'/" rmSiteDataPsql.sql
sed -i "s/s_d_id=[0-9]*/s_d_id='$3'/" rmSiteDataPsql.sql
psql -U postgres -h 127.0.0.1 -d postgres -f /data/rmSiteDataPsql.sql

#                                         data_logo     data_time        s_d_id
#测试用例：sh rm-bad-sitedata-postgres.sh ﻿GM_RSURF_GL '﻿2018-02-20 00:00:00' 25
