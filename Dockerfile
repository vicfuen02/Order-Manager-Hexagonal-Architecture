FROM eclipse-temurin:23-jdk-alpine AS builder

WORKDIR /home/app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

COPY src ./src
#RUN ./mvnw clean package -DskipTests
#    && mkdir -p target/dependency  \
#    && cd target/dependency  \
#    && jar -xf ../*.jar

RUN ./mvnw clean package -DskipTests

RUN mkdir -p /home/layer \
    && cd /home/layer \
    && cp /home/app/target/springbootessentials-0.0.2-SNAPSHOT.jar ./app-spe.jar \
    && java -Djarmode=tools -jar app-spe.jar extract --layers --launcher

FROM eclipse-temurin:23-jre-alpine

WORKDIR /home/app

#RUN mkdir -p /home/app/src/main/resources/logs  \
#    && chmod 777 /home/app/src/main/resources/logs
#
RUN addgroup -S spring && adduser -S spring-app -G spring
RUN chown -R spring-app:spring /home/app
USER spring-app:spring

COPY --from=builder /home/layer/app-spe/dependencies .
COPY --from=builder /home/layer/app-spe/spring-boot-loader .
COPY --from=builder /home/layer/app-spe/snapshot-dependencies .
COPY --from=builder /home/layer/app-spe/application .

EXPOSE 8080

#HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:8080/api/spe/actuator/health || exit 1

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]


