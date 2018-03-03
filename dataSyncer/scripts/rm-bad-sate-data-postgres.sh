#!/usr/bin/env bash
export PGPASSWORD=postgres
sed 's/data_logo=[a-zA-Z_\-\:\d]*/data_logo=$1/' /data/rmpsql.sql
sed 's/data_time=[0-9]*/data_time=$2/' /data/rmpsql.sql
sed 's/s_d_id=[0-9]*/s_d_id=$3/' /data/rmpsql.sql
psql -U postgres -h 127.0.0.1 -d postgres -f /data/rmSiteDataPsql.sql