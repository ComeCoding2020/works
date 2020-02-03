-- git学习笔记
1.Git是一款分布式版本控制系统，有别于CVS和SVN等集中式版本控制系统，Git可以让研发团队更加高效地协同工作、提高生产率
2.Git的一些闪亮特性
  每日的工作备份、异地协同工作、现场版本控制、避免引入辅助目录、重写提交说明、更好用的提交列表、更好的差异比较、工作进度保存、快
3.在提交过程中需要输入提交说明，这个要求对于Git来说是强制性的，不像其他很多版本控制系统（如CVS、Subversion）允许空白的提交说明。
4.在Git提交时，如果在命令行不提供提交说明（没有使用-m参数），Git会自动打开一个编辑器，要求您在其中输入提交说明，输入完毕保存退出
5.git暂存区是一个介于工作区和版本库的中间状态，当执行提交时实际上是将暂存区的内容提交到版本库中，而且Git很多命令都会涉及到暂存区的概念
6.git cat-file命令查看commit ID的类型
  $ git cat-file -t e695606
  commit
  $ git cat-file -t f58d
  tree
  $ git cat-file -t a0c6
  commit
7.git的commit id实际上是SHA1哈希值，SHA1摘要算法可以处理从零到一千多万个TB的输入数据，输出为固定的160比特的数字摘要。两个不同内容的输入即使数据量非常大、差异非常小，两者的哈希值也会显著不同。
8.关于git stash
  git stash用于保存和恢复工作进度。
  保存当前的工作进度。会分别对暂存区和工作区的状态进行保存。
  
  git stash list
  显示进度列表。此命令显然暗示了git stash 可以多次保存工作进度，并用在恢复时候    选择。
  
  git stash pop [--index] [<stash>]
  如果不使用任何参数，会恢复最新保存的工作进度，并将恢复的工作进度从存储的工作       进度列表中清除。
  如果提供<stash>参数（来自git stash list显示的列表），则从该<stash>中恢复。恢复完毕 也将从进度列表中删除<stash>。 
  选项--index除了恢复工作区的文件外，还尝试恢复暂存区。这也就是为什么在本章一   开始恢复进度的时候显示的状态和保存进度前的略有不同。
  
  git stash [save [--patch] [-k|--[no]keep-index] [-q|--quiet] [<message>]]
  这条命令实际上是第一条git stash命令的完整版。即如果需要在保存工作进度的时候使 用指定的说明，必须使用如下格式：
  
  git stash save “message...”
  使用参数--patch会显示工作区和HEAD的差异，通过对差异文件的编辑决定在进度中   最终要保存的工作区的内容，通过编辑差异文件可以在进度中排除无关内容。
  使用-k或者--keep-index参数，在保存进度后不会将暂存区重置。默认会将暂存区和工  作区强制重置。
  
  git stash apply [--index] [<stash>] 
  除了不删除恢复的进度之外，其余和git stash pop 命令一样。
  
  git stash drop [<stash>]
  删除一个存储的进度。默认删除最新的进度。
  
  git stash clear
  删除所有存储的进度。
  
  git stash branch <branchname> <stash>
  基于进度创建分支。
9.关于git reset
  Git reset 命令有三个主要选项：git reset --soft; git reset --mixed; git reset --hard;
  
  git reset --soft
  将HEAD引用指向给定提交。索引和工作目录的内容是不变的，在三个命令中对现有版本库状态改动最小。
  
  git reset --mixed（git reset默认的模式） 
  HEAD引用指向给定提交，并且索引内容也跟着改变，工作目录内容不变。这个命令会将索引变成你刚刚暂存该提交全部变化是的状态，会显示工作目录中有什么修改。
  
  git reset --hard
  HEAD引用指向给定提交，索引内容和工作目录内容都会变给定提交时的状态。也就是在给定提交后所修改的内容都会丢失(新文件会被删除，不在工作目录中的文件恢复，未清除回收站的前提)。
10.关于git checkout

  情况一:未使用 git add 缓存代码时
  // 放弃单个文件修改,注意不要忘记中间的"--",不写就成了检出分支了!
  git checkout -- filepathname
  // 放弃所有的文件修改
  git checkout .  
  此命令用来放弃掉所有还没有加入到缓存区（就是 git add 命令）的修改：内容修改与整个文件删除。但是此命令不会删除掉刚新建的文件。因为刚新建的文件还没已有加入到 git 的管理系统中。所以对于git是未知的。自己手动删除就好了。

  情况二:已经使用了 git add 缓存了代码:
  可以使用 git reset HEAD filepathname （比如： git reset HEAD readme.md）来放弃指定文件的缓存，放弃所有的缓存可以使用 git reset HEAD . 命令。
  此命令用来清除 git 对于文件修改的缓存。相当于撤销 git add 命令所在的工作。在使用本命令后，本地的修改并不会消失，而是回到了如（一）所示的状态。继续用（一）中的操作，就可以放弃本地的修改。

  情况三:已经用 git commit 提交了代码:
  可以使用 **git reset --hard HEAD^ 来回退到上一次commit的状态。
  此命令可以用来回退到任意版本：git reset --hard commitid **
  你可以使用 **git log **命令来查看git的提交历史。git log 的输出如下,之一这里可以看到第一行就是 commitid：
