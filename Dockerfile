FROM java:10
WORKDIR /
ADD simple-test.jar simple-test.jar
EXPOSE 8080
CMD java - jar simple-test.jar