FROM openjdk:8-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/demo/demo.jar"]

ADD /target/demo-0.0.1-SNAPSHOT.jar /usr/share/demo/demo.jar