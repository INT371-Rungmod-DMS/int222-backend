#Build
FROM maven AS build
COPY src $PWD/src
COPY pom.xml $PWD
RUN mvn -f $PWD/pom.xml clean package

#Stage
FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 8080
COPY --from=build $PWD/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]