@echo off
cd /d %~dp0
./gradlew downloadAllure allureServe
pause