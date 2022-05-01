#!/bin/sh

rm -rf target
mkdir target
javac  src/java/edu/school21/printer/*/*.java -d ./target
java -classpath ./target edu.school21.printer.app.Program . 0 /Users/amuriel/Desktop/it.bmp
