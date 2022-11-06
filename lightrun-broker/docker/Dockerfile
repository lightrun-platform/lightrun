FROM redhat/ubi8

RUN ln -sf /bin/bash /bin/sh
RUN useradd -ms /bin/bash  nginx
RUN rpm -Uvh http://nginx.org/packages/rhel/8/x86_64/RPMS/nginx-1.22.1-1.el8.ngx.x86_64.rpm


RUN chown -R nginx:nginx /var/cache/nginx && \
    chown -R nginx:nginx /var/log/nginx && \
    chown -R nginx:nginx /etc/nginx/


RUN touch /var/run/nginx.pid && \
    chown -R nginx:nginx /var/run/nginx.pid

USER nginx

RUN ln -sf /dev/stdout /var/log/nginx/access.log && \
    ln -sf /dev/stderr /var/log/nginx/error.log

EXPOSE 443
STOPSIGNAL SIGTERM

CMD ["nginx", "-g", "daemon off;"]