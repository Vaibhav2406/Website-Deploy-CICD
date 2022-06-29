FROM devopsedu/webapp
RUN apt-get update
RUN apt-get install -y wget
RUN cd /var/www/html/ ; wget https://github.com/edureka-devops/projCert/archive/refs/heads/master.zip
RUN cd /var/www/html/ ; apt-get install -y zip ; unzip -n master.zip
RUN rm /var/www/html/index.html
RUN mv /var/www/html/projCert-master/website/*  /var/www/html/
CMD apachectl -D FOREGROUND
