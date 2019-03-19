#!/bin/bash

mvn clean install -q -DskipTests
cd target
java -cp *.jar com.github.wojtechm.Main

