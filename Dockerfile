FROM openjdk:11
ADD target/stc_assessment.jar stc_assessment.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "stc_assessment.jar"]
