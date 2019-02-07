all: docker

docker:
	mvn clean install

	docker build -t demo:latest .
.PHONY: docker
