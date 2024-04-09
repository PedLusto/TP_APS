#!/bin/sh

./gradlew jar
export _JAVA_AWT_WM_NONREPARENTING=1
java -jar build/libs/PetShopee-1.0-SNAPSHOT.jar
