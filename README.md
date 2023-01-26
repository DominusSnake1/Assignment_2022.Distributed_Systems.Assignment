### Run an MySQL database using docker

```bash
docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=pass123 -e MYSQL_ROOT_HOST='%' --rm -d mysql:8
```

### Stop Database Connection
```bash
docker stop mysqldb
```

### Remove Database Data
```bash
docker volume rm mysqldbvol
```
###

#### Useful Links:
* Download Docker: https://www.docker.com/products/docker-desktop/
* Github Repository: https://github.com/DominusSnake1/Katanemimena_Ergasia_2022-2023