#!/bin/bash

envsubst '$LIGHTRUN_SERVER' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf
nginx -g "daemon off;"