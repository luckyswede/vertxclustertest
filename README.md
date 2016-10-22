[new terminal]
* cd service
* mvn clean package
* ./run.sh

[new terminal]
* cd proxy
* mvn clean package
* ./run.sh

[new terminal]
* ab -n 5000 -c 5 http://localhost:8080/


