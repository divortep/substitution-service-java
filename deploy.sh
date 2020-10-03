#!/bin/bash

docker build -t substitution-service-java . &&
docker rm substitution-service-java &&
docker run --publish 8080:8080 --detach --name substitution-service-java substitution-service-java:latest