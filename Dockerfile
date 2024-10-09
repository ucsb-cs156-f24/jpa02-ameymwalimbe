
FROM bellsoft/liberica-openjdk-alpine:21


WORKDIR /app

ENV NODE_VERSION=20.17.0
RUN apk add curl
RUN apk add bash
RUN apk add maven
RUN apk add --no-cache libstdc++

COPY src /home/app/src
COPY lombok.config /home/app
COPY pom.xml /home/app

RUN mvn -B -DskipTests -f /home/app/pom.xml clean package

ENTRYPOINT ["sh", "-c", "java -jar /home/app/target/*.jar"]