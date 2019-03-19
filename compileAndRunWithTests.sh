#!/bin/bash

mvn clean install -q
cd target
java -cp *.jar com.github.wojtechm.Main

