### Run an MySQL database using docker

```bash
docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass123 -e MYSQL_ROOT_HOST='%' --rm -d mysql:8
```
Running Utils.TestJDBC will test the connection to the database.

### Stop Database Connection
```bash
docker stop mysqldb
```

### Remove Database Data
```bash
docker volume rm mysqldbvol
```
