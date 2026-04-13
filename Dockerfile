# Menggunakan base image Java 21 JRE
FROM eclipse-temurin:21-jre

# Metadata Label
LABEL maintainer="Davin"
LABEL version="1.0"

# Menyalin file JAR hasil build ke dalam image
COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar

# Perintah untuk menjalankan aplikasi
ENTRYPOINT ["java","-jar","/app.jar"]

# Mengekspos port 8080
EXPOSE 8080