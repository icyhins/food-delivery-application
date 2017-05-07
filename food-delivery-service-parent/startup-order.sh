#!/bin/sh

#Clean & install
mvn clean install

#Go to order jar path
cd ../food-delivery-service-order/target/

#start jar
java -jar food-delivery-service-order-1.0.0.BUILD-SNAPSHOT.jar

#Back to parent pom
#cd ../../food-delivery-service-parent


