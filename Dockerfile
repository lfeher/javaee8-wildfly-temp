FROM maven:3.6.0-jdk-8-slim as maven

COPY . /project
WORKDIR /project

RUN mvn clean package
RUN chmod +x wait-for-it.sh

#--------------------------------------------------------------------------------------
FROM lfeher/wildfly-15.0.1-final
ENV WILDFLY_HOME /opt/wildfly
ENV LAUNCH_JBOSS_IN_BACKGROUND true

USER root
COPY --from=maven /project/target/javaee8-wildfly.war ${WILDFLY_HOME}/standalone/deployments/

USER jboss
EXPOSE 8080

CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
