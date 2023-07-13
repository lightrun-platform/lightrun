#!/bin/bash

envsubst '$LIGHTRUN_SERVER $CUSTOMER_ENDPOINT' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf
nginx -g "daemon off;"