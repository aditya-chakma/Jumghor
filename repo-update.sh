#!/bin/sh

##### publish repos to repository start #####
cd entities
mvn clean install

cd ../utils
mvn clean install

cd ..
##### publish repo to repository finish ####

