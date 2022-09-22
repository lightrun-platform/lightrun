## Topology

![Screen Shot 2022-09-15 at 17 42 29](https://user-images.githubusercontent.com/14246521/190434114-5d609589-973c-49b5-a95c-17113e04ca1e.png)

## Lightrun broker configuration

1. Put certificate and private key (valid for your domain) into conf/certs with names: tls.crt and tls.key
1. Set under docker-compose.yaml variable LIGHTRUN_SERVER with format https://example.com (Line #6)
1. Set under docker-compose.yaml public DNS your company uses or leave DNS of google as is (Line #17)


## Start Lightrun broker

```
docker-compose up -d
```

## Plugin and Agents via Lightrun Broker
- Be sure that within your network **lightrun server** resolved to IP of Lightrun broker

