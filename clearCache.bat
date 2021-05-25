REM 清空当前分支下本地git暂存区的缓存
REM 默认情况会以当前目录执行, 可以修改workDir以指定目录; 如 项目路径为D:\project\Test,改为: set workDir=D:\project\Test
set workDir=%cd%
git -C %workDir% rm -r --cached .
git -C %workDir% add .
git -C %workDir% commit -m "clear git cached"
pause