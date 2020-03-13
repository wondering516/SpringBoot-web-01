# 初学SpringBoot

## 师从小匠
https://www.bilibili.com/video/av62800055

## 附带复习Git语法

* `git init` 初始化仓库
* `git remote add origin [url]` 添加你远程仓库的地址
* `git status` 查看当前仓库状态
* `git add .` 注意`.`不能丢, 将所有文件添加到缓存区
* `git commit -m"[description]"` 提交, 并添加描述
* `git push origin` 默认将缓存区的文件提交到远程仓库的master文件下


## 遇到的问题

### 1. 加载`Bootstrap`后无法显示样式
**原因**
![cannotloadstylesheet](src/main/resources/static/image/problem/problem01_cannot_load_stylesheet.png)
* 未添加`type="text/javascript"`
