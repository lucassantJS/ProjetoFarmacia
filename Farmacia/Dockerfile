# Use uma imagem base oficial do Maven com OpenJDK 17 para a fase de build
FROM maven:3.8.4-openjdk-17-slim AS build

# Configuração do diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e as dependências para o cache das dependências
COPY pom.xml .
COPY src ./src

# Baixa as dependências e compila o projeto
RUN mvn clean package -DskipTests

# Use uma imagem base oficial do OpenJDK para a execução da aplicação
FROM openjdk:17-jdk-slim

# Configuração do diretório de trabalho dentro do container
WORKDIR /app

# Copia o jar construído da imagem de build para a imagem final
COPY --from=build /app/target/Projeto-Farmacia-1.0-SNAPSHOT.jar app.jar

# Expõe a porta que a aplicação irá rodar
EXPOSE 8081

# Define o comando de inicialização da aplicação
ENTRYPOINT ["java", "-XX:TieredStopAtLevel=1", "-Dspring.output.ansi.enabled=always", "-Dcom.sun.management.jmxremote", "-Dspring.jmx.enabled=true", "-Dspring.liveBeansView.mbeanDomain", "-Dspring.application.admin.enabled=true", "-Dmanagement.endpoints.jmx.exposure.include=*", "-jar", "/app/app.jar"]
