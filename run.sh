export HADOOP_HOME=/opt/hadoop-2.7.0
{
	rm base-1.0-SNAPSHOT.jar
} || {}
{
	rm -rf /home/jonatan/Desktop/intermediate
} || {}
{
	rm -rf /home/jonatan/Desktop/output
} || {}
smbget -u jonatan -p 87100454724 smb://192.168.0.11/build/libs/base-1.0-SNAPSHOT.jar
$HADOOP_HOME/bin/hadoop jar base-1.0-SNAPSHOT.jar com.j.distributed.Main /home/jonatan/Desktop/input /home/jonatan/Desktop/intermediate /home/jonatan/Desktop/output "$1"
