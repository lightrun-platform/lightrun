FROM redhat/ubi9

RUN yum install gettext procps-ng -y
RUN ln -sf /bin/bash /bin/sh
RUN useradd -ms /bin/bash  nginx
RUN rpm -Uvh http://nginx.org/packages/rhel/9/x86_64/RPMS/nginx-1.24.0-1.el9.ngx.x86_64.rpm 


RUN chown -R nginx:nginx /var/cache/nginx && \
    chown -R nginx:nginx /var/log/nginx && \
    chown -R nginx:nginx /etc/nginx/


RUN touch /var/run/nginx.pid && \
    chown -R nginx:nginx /var/run/nginx.pid

USER nginx

RUN ln -sf /dev/stdout /var/log/nginx/access.log && \
    ln -sf /dev/stderr /var/log/nginx/error.log

COPY entrypoint.sh /var/entrypoint.sh

EXPOSE 443
STOPSIGNAL SIGTERM


CMD ["bash", "/var/entrypoint.sh"]