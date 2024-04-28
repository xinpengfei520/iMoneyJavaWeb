# iMoneyJavaWeb

iMoneyJavaWeb

## 1.主要技术点

1.采用 SSM 框架开发；
2.集成 Swagger2;
3.使用 MySQL8.0 数据库；

## 2.接口文档

[Swagger2](http://localhost:8080/iMoneyJavaWeb/swagger-ui.html)

本地请求地址：

http://localhost:8080/iMoneyJavaWeb/QiniuUpToken

## 3.生成 war 包

Build -> BuildArtifacts -> war build ...

或者使用 maven 命令

```shell
mvn clean package -DskipTests
```

或者使用 IDEA 的 maven 插件，点击右侧的 maven 选项卡，找到 package，双击运行。

然后会在 target 目录下看到生成的 war 包

## 4.部署

### 4.1.手动部署

将 war 包放到 tomcat 的 webapps 目录下，启动 tomcat 即可

### 4.2. docker 部署

编写 Dockerfile 文件，使用 github workflow 自动打包 docker 镜像并上传到 ACR 仓库（Alibaba Cloud Registry）

服务器拉取镜像并运行即可。

这样就实现了容器化部署，做到程序与环境隔离，方便管理和水平扩展。