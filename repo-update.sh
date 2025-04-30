#!/bin/sh

##### publish repos to repository start #####
cd utils
mvn clean install

cd ../entities
mvn clean install

cd ..
##### publish repo to repository finish ####

