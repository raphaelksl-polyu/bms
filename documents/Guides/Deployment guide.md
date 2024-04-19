## Building from source code

1. Install the following: 
	1. Java 17
	2. IntelliJ Idea
	3. Jmix plugin
	4. Docker

2. Create docker network:
```
docker network create bms-network
```

3. Create MySQL database container volume:
```
docker volume create bms-db-volume
```

4. Create MySQL database container:
```
docker run --name bms-db-container -d ^
    -p 3306:3306 ^
    -e MYSQL_ROOT_PASSWORD=root ^
    -e MYSQL_ROOT_HOST=% ^
    --network=bms-network ^
    --mount source=bms-db-volume,target=/var/lib/mysql ^
    --restart unless-stopped ^
    mysql:8.0.36
```

5. Create database:
```
mysql -uroot -proot
```

```
CREATE DATABASE bms;
```

6. Configure Data Store to use docker network hostname
```
bms-db-container
```

7. Create BMS Front/Backend image
```
./gradlew "-Pvaadin.productionMode=true" bootBuildImage
```

8. Create BMS F/BE container
```
docker run --name bms-container -d ^
    -p 8080:8080 ^
    --network=bms-network ^
    --restart unless-stopped ^
    batch-meeting-scheduler:0.0.1-SNAPSHOT
```

