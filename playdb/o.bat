rem call activator clean
call activator compile
call activator stage
git add .
git commit -m %1
git push origin master

