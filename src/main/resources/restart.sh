#!/bin/bash

count=`ps aux|grep git-commit | grep java | grep -v grep | wc -l`
echo ">>> There is [ $count ] process running git-commit-id service."
if [[ ${count} -gt 0 ]]; then
    echo "STOP git-commit service......"
    ps aux | grep git-commit | grep java | grep -v grep | awk '{print $2}' | xargs kill -9
    echo ">>> RESTART git-commit service ok."
else
    echo ">>> START git-commit service......"
fi
    sleep 1 
    nohup java -Dspring.profiles.active=local -jar /data/app/git-commit-id/git-commit-id-0.0.1-SNAPSHOT.jar
    > /data/app/git-commit-id/out.log 2>&1 &
