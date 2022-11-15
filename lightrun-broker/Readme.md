<p align="center">
    <a href="https://www.lightrun.com/" target="_blank">
      <img src="https://user-images.githubusercontent.com/33126908/135755862-3c2d9143-c9bc-49b6-933c-f80df720d44e.png" alt="Lightrun">
    </a>
</p>

## Overview

The Lightrun broker is a component that serves as a network bridge and enables secure communication between a customer’s internal network and the Lightrun server. 

With the Lightrun broker, Lightrun agents and plugins will be installed and work inside a customer’s internal network. However, rather than communicating directly with the Lightrun server, the agents and plugins will communicate with the Lightrun broker instead. The Lightrun broker then routes the messages sent by the agents and plugins to the Lightrun server via an SSL/TLS secured channel.

![Screen Shot 2022-09-15 at 17 42 29](https://user-images.githubusercontent.com/14246521/190434114-5d609589-973c-49b5-a95c-17113e04ca1e.png)

## Hardware and Networking Requirements

The Lightrun broker has the following hardware and networking requirements.

**Hardware Requirements.** - Depending on your internal network’s load, you can start with a 1 vCPU, 2GB RAM virtual machine and increase the virtual machine capacity on demand.

**Networking Requirements** - The following ports must be opened to the internet to use the Lightrun broker:
- Egress TCP port 443.
- Egress TCP/UDP port 53 (in case your public DNS server is not within your network).

## Lightrun Broker Setup and Configuration
**Prerequisites**
This guide assumes that you have already installed both the [Docker engine](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/).

Clone the the Lightrun broker source code from the following GitHub repository - https://github.com/lightrun-platform/lightrun/tree/main/lightrun-broker

The source code has the following file structure:

- `docker-compose.yaml` - The Lightrun broker docker-compose file.
- `docker/Dockerfile` - The dockerfile for managing custom nginx image based on RHEL
- `conf/certs` - Folder containing domain certificates.
- `conf/nginx.conf.template` - Template for nginx configuration file.

### Configuration steps

#### Step 1: Configure Domain Certificates
Generate a certificate and a private key for your domain, and copy the domain certificate into a `tls.crt` file and the private key into a `tls.key` file. Then place the `tls.crt` and `tls.key` files into the `conf/certs` folder.

#### Step 2: Build custom docker image based on RHEL
Build docker image from docker folder and upload to your docker registry

#### Step 3: Configure the Docker Compose file.
Open the `docker-compose.yaml` file in your preferred code editor, and change the ` LIGHTRUN_SERVER` parameter to your organization’s Lightrun server URL. Add image tag you built on previous step. Also, you can change the `dns` parameter to your organization’s public DNS IP address or leave the default Google Public DNS IP address.

> Note: *The `LIGHTRUN_SERVER` parameter should be in a `example.com` format.*

#### Step 4: Start the Lightrun Broker
Start the Lightrun broker image with the following command. 

```
docker-compose up -d
```

#### Step 5: Confirm your connection
Enter your Lightrun Server URL value into your browser. The connection should pass through the Lightrun Broker before going to the Lightrun server. 

> Important: *Be sure that within your network **lightrun server** is resolved to IP of Lightrun broker.*

