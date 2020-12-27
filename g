#!/bin/bash  
echo `date '+%Y-%m-%d %H:%M:%S'` >> /opt/git.log  
cd /opt/devman  
cd playdb

APP_COMMAND="/opt/devman/playdb/target/universal/stage/bin/play "\
"-Dhttp.port=1080 "\
"-Dplay.evolutions.db.default.autoApply=true -Dplay.evolutions.db.default.autoApplyDowns=true "\
"-Dpidfile.path=/opt/devman/play.pid "

LOG_FILE="/opt/devman/play.log"
kill $(cat /opt/devman/play.pid)
rm /opt/devman/play.log
rm /opt/devman/play.pid

git pull origin master >> /opt/git.log

echo $APP_COMMAND &>> $LOG_FILE
 
nohup bash -c "${APP_COMMAND} &>> ${LOG_FILE} 2>&1" &> /dev/null &

echo [Start finished \\o/]
   
