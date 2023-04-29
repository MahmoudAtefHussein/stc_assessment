FROM openjdk:11
ENV DB_HOST "172.17.0.2"
ADD target/stc_assessment.jar stc_assessment.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "stc_assessment.jar"]
