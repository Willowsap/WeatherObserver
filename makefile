JFLAGS = -d bin -sourcepath src
JUNIT5_JAR = junit-platform-console-standalone-1.8.2.jar 
JUNIT5_RUNNER = org.junit.platform.console.ConsoleLauncher

default: 
	@echo "usage: make target"
	@echo "4 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - builds codebase"
	@echo "____________________ test - runs JUnit5 tests"
	@echo "____________________ demo - runs demo (client)"
	@echo "Just starting with make? Try these 4 make commands successively:"
	@echo "________ make clean ; make compile ; make demo"

compile: $(JUNIT5_JAR)
	javac $(JFLAGS) -cp .:$(JUNIT5_JAR) src/**/*.java

test: $(JUNIT5_JAR)
	java -cp .:bin:$(JUNIT5_JAR) $(JUNIT5_RUNNER) --scan-class-path 

demo: bin/tests/Demo.class
	java -cp .:bin tests/Demo

clean:
	rm -f *~
	rm -f ./bin/**/*.class
	rm -f src/**/*.java~
