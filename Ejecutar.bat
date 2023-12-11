@echo off
cd /d %~dp0
./gradlew clean CucumberTest
pause