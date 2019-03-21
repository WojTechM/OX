#!/bin/bash

mvn clean install -q
java -jar target/*.jar
