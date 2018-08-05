#!/usr/bin/env bash
export PGPASSWORD=postgres
sed -i "s/data_logo=[a-zA-Z_\-\:\d\']*/data_logo='$1'/" rmGridDataPsql.sql
sed -i "s/data_time=[0-9\-\']*/data_time='$2'/" rmGridDataPsql.sql
psql -U postgres -h 127.0.0.1 -d postgres -f rmGridDataPsql.sql

#                                         data_logo        data_time
#测试用例：sh rm-bad-griddata-postgres.sh ﻿GM_GRID_KWBC_GL '2017-10-11 00:00:00'