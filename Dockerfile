FROM openjdk:17
EXPOSE 8080
ADD target/video-game-database.jar video-game-database.jar
ENTRYPOINT["java", "-jar", "video-game-database.jar"]