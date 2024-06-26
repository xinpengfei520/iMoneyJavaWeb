# 构建镜像
FROM tomcat:9.0.88-jdk8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 拷贝 *.war 文件到 tomcat webapps 目录
COPY target/*.war /usr/local/tomcat/webapps/iMoney.war
# 暴露端口
EXPOSE 8080
# 启动 tomcat
CMD ["catalina.sh", "run"]