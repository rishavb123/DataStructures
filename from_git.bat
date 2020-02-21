@echo off
git clone https://github.com/rishavb123/%1.git
cd %1
rmdir .git /s /q
cd ..
jar -cfM "%1-Rishav Bhagat.zip" %1
git add -A
git commit -m "download %1 from git"
git push