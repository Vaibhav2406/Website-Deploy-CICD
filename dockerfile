FROM devopsedu/webapp 
ADD proj /var/www/html/index.php
RUN rm /var/www/html/index.html
CMD apachectl -D FOREGROUND
