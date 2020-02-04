#####删除全部用户和邮箱
`git config --unset --global user.name`
`git config --unset --global user.email`
#####查看全局用户和邮箱
`git config user.name`
`git config user.email`
##### git缓存区的意义
#####判断文件是否更改，使用时间戳、文件长度等信息进行比较要比通过文件内容比较要快的多，所以Git这样的实现方式可以让工作区状态扫描更快速的执行。
##### 恢复删除的文件
`git cat-file -p HEAD~1:welcome.txt > welcome.txt`
##### 显示当前的版本号
`git describe`
#####文件忽略
`hello`
`*.o`
`*.h`
##### 显示分支
`git rev-parse --symbolic --branches`
##### 显示tag
`git rev-parse --symbolic --tags`
##### 显示指定哈希版本
`git rev-parse  6652  6652a0d`
`6652a0dce6a5067732c00ef0a220810a7230655e
6652a0dce6a5067732c00ef0a220810a7230655e`
#####浏览日志(正则表达式过滤)
`git log --oneline F^! D`
#####修补式提交
`git commit –amend`
#####如何删除错误的提交记录?
#####1.git tag 在特定命名空间建立的引用(假设需要删除提交记录D）
`$ git tag F
$ git tag E HEAD^
$ git tag D HEAD^^
$ git tag C HEAD^^^
$ git tag B HEAD~4
$ git tag A HEAD~5`
#####2.暂时将HEAD头指针切换到C
`git checkout C`
#####3.执行拣选操作将E提交在当前HEAD上重放
`git cherry-pick master^`
#####3.执行拣选操作将F提交在当前HEAD上重放
`git cherry-pick master`
#####4.通过日志可以看到D提交已经不在了。
`git log --oneline --decorate -6`
#####5.将master分支指向新的提交ID
`git checkout master`
#####冲突解决
`git pull = git fetch + git merge`
`默认情况下，合并后的结果会自动提交，但是如果提供--no-commit 选项，则合并后的
结果会放入暂存区，用户可以对合并结果进行检查、更改，然后手动提交。`
特殊标识<<<<<<<（七个小于号）和=======（七个等号）之间的内容是当前分支所
更改的内容。特殊标识=======（七个等号）和>>>>>>>（七个大于号）之间的内容是所
合并的版本更改的内容。
冲突解决的实质就是通过编辑操作，将冲突标识符所标识的冲突内容替换为合适的内
容，并去掉冲突标识符。编辑完毕后执行git add命令将文件添加到暂存区（标号0），然后
再提交就完成了冲突解决。
#####存在冲突的原因
自动合并如果成功地执行，则大多数情况下就意味着完事大吉，但是在某些特殊情况下，
合并后的结果虽然在Git 看来是完美的合并，实际上却存在着逻辑冲突。
一个典型的逻辑冲突是一个用户修改了一个文件的文件名，而另外的用户在其他文件中
引用旧的文件名，这样的合并虽然能够成功但是包含着逻辑冲突。例如：
（1）一个C语言的项目中存在头文件hello.h，该头文件定义了一些函数声明。
（2）用户user1将hello.h文件改名为api.h。
（3）用户user2写了一个新的源码文件 foo.c并在该文件中包含了hello.h文件。
（4）两个用户的提交合并后，会因为源码文件 foo.c找不到所包含的文件hello.h而导致
项目编译失败。
#####显示里程碑
git tag
#####分支命令
用法1： git branch

用法2： git branch <branchname>

用法3： git branch <branchname> <start-point>

用法4： git branch -d <branchname>

用法5： git branch -D <branchname>

用法6： git branch -m <oldbranch> <newbranch>

用法7： git branch -M <oldbranch> <newbranch>
#####远程分支
Git 允许一个版本库和任意多的版本库进行交互
#####注册远程版本库
git remote add new-remote file:///path/to/repos/hello-user1.git
#####更改远程版本库的地址
`git remote set-url new-remote file:///path/to/repos/hello-user2.git`
#####更改远程版本库的名称
`git remote rename new-remote user2`
#####远程版本库更新
`git remote update`
#####通过git 给其他git用户发送邮件
`git send-email`
#####应用git补丁
`git apply`