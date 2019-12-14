# o2o
## 1、项目概述

o2o校园商铺，用于校园中店家与学生之间的交互。

## 2.模块划分

用户模块：登录、注册、修改密码、退出

商家模块：登录、注册、修改密码、管理商铺、退出

## 3.设计思想

MVC设计思想

表现层：html+css+Jquery+ajax

控制层：springmvc

业务层;service组件

持久层：Dao组件

## 4.技术架构

（1）开发环境：windows10+tomcat+mysql

（2）采用技术：java+jquery+ajax+springmvc

IOC+AOP+mybatis

java：开发核心技术

jquery：简化前端JavaScript（$对象和API）

ajax：局处理页面，提升用户体验度

springmvc：负责接收请求，调用业务组件处理，生成json响应

spring(IOC/AOP):管理相关组件

IOC:负责管理Controller/service/dao，维护它们之间的关系

AOP：面向切面编程，不修改原有的代码，给系统增加新的功能

## 5.整体规范

-所有的请求ajax方法访问

-前端页面采用HTML

-请求结果进行JSON相应

