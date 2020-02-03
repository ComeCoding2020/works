##第二章以前不知道的比较使用的命令
######删除全部用户和邮箱
`git config --unset --global user.name`
`git config --unset --global user.email`
######查看全局用户和邮箱
`git config user.name`
`git config user.email`
##### git缓存区的意义
######判断文件是否更改，使用时间戳、文件长度等信息进行比较要比通过文件内容比较要快的多，所以Git这样的实现方式可以让工作区状态扫描更快速的执行。
###### 恢复删除的文件
`git cat-file -p HEAD~1:welcome.txt > welcome.txt`
###### 显示当前的版本号
`git describe`
######文件忽略
`hello`
`*.o`
`*.h`
###### 显示分支
`git rev-parse --symbolic --branches`
###### 显示tag
`git rev-parse --symbolic --tags`
###### 显示指定哈希版本
`git rev-parse  6652  6652a0d`
`6652a0dce6a5067732c00ef0a220810a7230655e
6652a0dce6a5067732c00ef0a220810a7230655e`
######浏览日志(正则表达式过滤)
`git log --oneline F^! D`
######修补式提交
`git commit –amend`
#####如何删除错误的提交记录?
######1.git tag 在特定命名空间建立的引用(假设需要删除提交记录D）
`$ git tag F
$ git tag E HEAD^
$ git tag D HEAD^^
$ git tag C HEAD^^^
$ git tag B HEAD~4
$ git tag A HEAD~5`
######2.暂时将HEAD头指针切换到C
`git checkout C`
######3.执行拣选操作将E提交在当前HEAD上重放
`git cherry-pick master^`
######3.执行拣选操作将F提交在当前HEAD上重放
`git cherry-pick master`
######4.通过日志可以看到D提交已经不在了。
`git log --oneline --decorate -6`
######5.将master分支指向新的提交ID
`git checkout master`
