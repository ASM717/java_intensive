#!/bin/sh

rm -rf target
mkdir target
javac  src/java/edu/school21/printer/*/*.java -d ./target
jar cfmv target/images-to-chars-printer.jar src/manifest.txt -C target edu -C src resources
java -jar target/images-to-chars-printer.jar . 0
