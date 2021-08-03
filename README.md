# imdb-service

### Building the project
1. Setup JDK 16
```bash
sudo apt install openjdk-16-jdk
```

2. Build and run tests
```bash
./gradlew clean build componentTest
```

### Run application
```
./gradlew bootRun
```

### JWT
1. Request authorization
```bash
curl --request POST \
  --url http://localhost:8080/login \
  --header 'content-type: application/json' \
  --data '{
	"username": "lunatech",
	"password": "7un@t3ch"
}'
```

2. Copy authorization header token in the previous step and use it in your request
```
curl --request GET \
  --url http://localhost:8080/api/titles/The%20Seven%20Sisters \
  --header 'authorization: 	{generated token}'
```

### API Documentation
http://localhost:8080/swagger-ui.html

#### Examples
- Fewer Hops
http://localhost:8080/api/six-degrees/Lars Rudolph
http://localhost:8080/api/six-degrees/Markus Waldow
http://localhost:8080/api/six-degrees/Jennifer Lawrence

- Medium Hops
http://localhost:8080/api/six-degrees/Jeffrey DeMunn

- More Hops
??


#### TODO List
- Create exception handler;
- Create unit test for the package movie in the layer service;
- Translate the titles and format the path;
