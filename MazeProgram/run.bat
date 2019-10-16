@echo off
echo Check out http://maze.serveo.net/controller to control the player from your phone
start ssh -R maze:80:localhost:8000 serveo.net
javac Application.java
java Application %1%