#!/bin/bash

mvn clean install -q -DskipTests
java -jar target/*.jar $1
