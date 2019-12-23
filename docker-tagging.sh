#!/usr/bin/env bash

container_name=app-api-say
docker commit -a chancaysergio@gmail.com ${container_name} sercheo.registry.jetbrains.space/public-docker/${container_name}
docker push sercheo.registry.jetbrains.space/public-docker/${container_name}

container_name=grafana
docker commit -a chancaysergio@gmail.com ${container_name} sercheo.registry.jetbrains.space/public-docker/${container_name}
docker push sercheo.registry.jetbrains.space/public-docker/${container_name}

container_name=prometheus
docker commit -a chancaysergio@gmail.com ${container_name} sercheo.registry.jetbrains.space/public-docker/${container_name}
docker push sercheo.registry.jetbrains.space/public-docker/${container_name}
