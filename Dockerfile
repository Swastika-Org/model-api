FROM registry.access.redhat.com/ubi8/openjdk-11:1.17

COPY target/quarkus-app/*.jar /opt/java/applications/
COPY target/quarkus-app/lib/ /opt/java/applications/lib/
COPY target/quarkus-app/app/ /opt/java/applications/app/
COPY target/quarkus-app/quarkus/ /opt/java/applications/quarkus/

# expose debug and http port
EXPOSE 5005 8080
USER 1001

# Adjust InitialRAMPercentage / MaxRAMPercentage to your needs.
ENTRYPOINT java -XshowSettings:vm -XX:InitialRAMPercentage=80 -XX:MaxRAMPercentage=80 -Dquarkus.http.host=0.0.0.0 -jar /opt/java/applications/quarkus-run.jar