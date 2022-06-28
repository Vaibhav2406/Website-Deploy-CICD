FROM devopsedu/webapp 
RUN cp proj /var/www/html/index.php
RUN rm /var/www/html/index.html
CMD apachectl -D FOREGROUND
