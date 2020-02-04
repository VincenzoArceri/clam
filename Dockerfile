
FROM java:8
WORKDIR /
ADD clam.jar clam.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "clam.jar"]
CMD []
