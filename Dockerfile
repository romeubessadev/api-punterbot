#FROM maven:3.6.0-jdk-11-slim AS build
#
#COPY pom.xml /punterbot-api/pom.xml
#RUN mvn -f /punterbot-api/pom.xml dependency:go-offline -B
#
#COPY src /punterbot-api/src
#RUN mvn -f /punterbot-api/pom.xml package

FROM openjdk:11.0.6-jre-slim
WORKDIR /usr/punterbot-api/

# Copiar o .jar para o volume especificado
#COPY --from=build /punterbot-api/src/target/punterbot-api*.jar punterbot-api.jar
COPY target/punterbot-api*.jar punterbot-api.jar
EXPOSE 8080

# Comando para executar quando o container subir
ENTRYPOINT java \
            -server \
            -Xms128m \
            -Xmx1024m \
            -Dcom.sun.management.jmxremote.rmi.port=9090 \
            -Dcom.sun.management.jmxremote=true \
            -Dcom.sun.management.jmxremote.port=9090 \
            -Dcom.sun.management.jmxremote.ssl=false \
            -Dcom.sun.management.jmxremote.authenticate=false \
            -Dcom.sun.management.jmxremote.local.only=false \
            -Djava.rmi.server.hostname=localhost \
            -Xlog:gc:/usr/punterbot-api/gc.log \
            -XX:+HeapDumpOnOutOfMemoryError \
            -XX:HeapDumpPath="/usr/punterbot-api/erro-dump<pid>.hprof" \
            -XX:+UseGCOverheadLimit \
            -jar \
            /usr/punterbot-api/punterbot-api.jar
