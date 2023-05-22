# 🗃️ TelegramDB
WebFlux application for [TelegramBot](https://github.com/PavelBocharov/TelegramBot)'s data.
![](./src/main/resources/img/webflux.jpg)
## 🟢 Build image
1) Compile jar - `mvn clean install`
2) Build docker image - `docker build -t marolok/telegram_db:1.0.0 .`
3) Push docker image - `docker push marolok/telegram_db:1.0.0`
## ⚙️Config
* All configurate in - [TelegramConf](https://github.com/PavelBocharov/TelegramConf)
* Docker image - [marolok/telegram_conf:1.0.0](https://hub.docker.com/repository/docker/marolok/telegram_conf/general)