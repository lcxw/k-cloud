# /**
#  * Copyright (c) 2022 KCloud-Platform-Alibaba Authors. All Rights Reserved.
#  * <p>
#  * Licensed under the Apache License, Version 2.0 (the "License");
#  * you may not use this file except in compliance with the License.
#  * You may obtain a copy of the License at
#  * <p>
#  *   http://www.apache.org/licenses/LICENSE-2.0
#  * <p>
#  * Unless required by applicable law or agreed to in writing, software
#  * distributed under the License is distributed on an "AS IS" BASIS,
#  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  * See the License for the specific language governing permissions and
#  * limitations under the License.
#  */
FROM docker.io/sunrdocker/jdk17-jre-font-openssl-alpine:latest
LABEL maintainer="koushenhai"
LABEL description="laokou-auth"
COPY laokou-auth.jar app.jar
RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime  \
    && echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 1111
ENTRYPOINT java -Xms512m -Xmx512m -Dlog4j.skipJansi=false \
                                -jar \
                                app.jar > /dev/null