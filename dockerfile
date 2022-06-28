FROM devopsedu/webapp
RUN docker run -d -P devopsedu/webapp
RUN docker pull tomcat:latest
