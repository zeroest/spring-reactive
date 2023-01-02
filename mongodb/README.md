
# MongoDB Setup

## Run

```shell
docker-compose up -d
```

## User setup

### Login root account

```shell
docker exec -it mongo bash

mongosh -u ${MONGO_INITDB_ROOT_USERNAME} -p ${MONGO_INITDB_ROOT_PASSWORD}
```

### Create user

```shell
use mydb

db.createUser({
  user: "mydbroot",
  pwd: "pwd",
  roles: [
    "readWrite",
    "dbAdmin"
  ]
});
```

## Configuration

[[Baeldung] Spring Data Reactive Repositories with MongoDB](https://www.baeldung.com/spring-data-mongodb-reactive)

[[Doc] Built-in Roles](https://www.mongodb.com/docs/manual/reference/built-in-roles/)

[[Doc] MongoReactiveDataAutoConfiguration](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/data/mongo/MongoReactiveDataAutoConfiguration.html)
