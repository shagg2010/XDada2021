printf "============================================= -------------------------------------- =================================\n "
printf "============================================= Pre-loading Data in Cassandra Database =================================\n "
printf "============================================= -------------------------------------- =================================\n "
while [ $(cqlsh -e "USE system" || echo 1) ];
do
  sleep 1;
done
echo '[Cassandra] Waited for cassandra startup and now setting up keyspace...' \
cqlsh localhost 9042 -f /tmp/01_keyspace.cql \
echo '[Cassandra] Creating schemas...' \
cqlsh localhost 9042 -f /tmp/02_schema_ddl.cql \
echo '[Cassandra] Insert some values...' \
cqlsh localhost 9042 -f /tmp/03_inserts.cql \
echo '[Cassandra] Flushing cassandra...' \
nodetool flush store \
echo '[Cassandra] Done!'