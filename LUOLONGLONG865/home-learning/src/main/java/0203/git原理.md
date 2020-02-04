1.git环境设置

设置账户信息

git config user.name

git config user.email

git config --global user.name "name"

git config --global user.email "email"

git config --list


生成ssh key

ssh-keygen  -t  rsa  -C  "mail"

cat ~/.ssh/id_rsa.pub

将ssh key拷贝到gerrit链接或者github。

基本配置更新
gedit  ~/.gedit .cshrc.user

source gitenv.csh

git submodule update


2. branch操作
创建分支
git checkout -b branch // Create a new branch

git branch  // Check local branch

git branch -v // Check all local branch and the head information

git branch -vv // Check all local branch and upstream branch

git branch -a  // Check all branch

git branch -av  // Check all branch  and the head information

删除分支

git branch –m oldbranch newbranch  // Modify branch

git branch –D branch  // Delete local branch

建立远端分支

git push origin branchname:branchname  // Create a new origin branch

git branch --set-upstream branchname origin/branchname  // Set upstream branch

git branch -r |grep branchname  origin/feat/branchname  // Find branch on remote

git remote show origin // Check remote origin branch

git remote prune origin // Update remote origin branch and local branch

3. commit 操作
文件状态操作
git status  // Check git tree, what changed currently

git log  // Check the commit history

git diff  // Check changed files

git patch > patch.diff  // Create a patch

patch -p1 <patch.diff  // Patch on branch

添加删除文件

git add <file>  // Add changed files to local git stage

git add.  // Add all changed files to local git stage

git mv <old> <new> // Rename for file

git rm <file>  // Remove some files for current stage

增加注释

git commit <file>  // Commit files, Input comments

git commit –a  // Commit all files not git-add, Input comments

git commit –a –m “your comments” // Commit with comment, not suggest

git commit --amend  // Amend commit to last one 

push到远端分支

git push origin master // Push to remote repo master branch

git push origin HEAD --force // Pusch commit by force

git push origin HEAD:refs/for/master  // Push commit for review

git push origin HEAD:refs/for/master  --no-verify // Push on master branch bypass pre-push hook

git push origin HEAD:refs/for/personal/ezyunch/branch  // Push commit on personal branch

commit 更新

git fetch  // Fetch changes but no merge

git merge master  // Merge master to current devel branch

git pull  // this command = git fetch + git merge

解决冲突，Cherry-pick

git cherry-pick <commit id>  // Fetch one commit to local

git cherry-pick <commit id1^..id2>  // Fetch some commits to local

git cherry-pick --quit

git cherry-pick --continue

git cherry-pick --abort

解决冲突，git rebase
git rebase -i HEAD~4  //亚索最后四个commit    

git rebase -i <commit id>

git rebase –continue  # After problem resolved

git rebase –skip          # Skip this conflict patch

git rebase –abort       # Check out the original branch and stop rebasing

interactively rebase 


checkout 和 clean操作

git checkout -- // undo all changes in repo files

git checkout -f  // force checkout (throw away local modifications)

git clean –dfx // clean all ignores files  

stash操作

git stash [save message]

保存，save为可选项，message为本次保存的注释

git stash list

所有保存的记录列表

git stash pop stash@{num}

恢复，num是可选项，通过git stash list可查看具体值。只能恢复一次

git stash apply stash@{num}

恢复，num是可选项，通过git stash list可查看具体值。可回复多次

git stash drop stash@{num}

删除某个保存，num是可选项，通过git stash list可查看具体值

git stash clear

删除所有保存


reset操作
git reset --hard  // Revert local branch same as remote 
git reset --hard <commit id>  // Revert to the commit id
git push origin HEAD --force  // used with caution
git reset --hard commit id