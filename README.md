# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#web)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#messaging.kafka)
* [Apache Kafka Streams Support](https://docs.spring.io/spring-kafka/docs/current/reference/html/#streams-kafka-streams)
* [Apache Kafka Streams Binding Capabilities of Spring Cloud Stream](https://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/#_kafka_streams_binding_capabilities_of_spring_cloud_stream)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Samples for using Apache Kafka Streams with Spring Cloud stream](https://github.com/spring-cloud/spring-cloud-stream-samples/tree/master/kafka-streams-samples)

### MyKafka
https://www.baeldung.com/spring-kafka
https://github.com/eugenp/tutorials/tree/b6ed66af5741117c07294d3a43bf8e13ddd82a21/spring-kafka

### KAFKA DOCKER IAMGE KNOWHOW
KAFKA DOCKER
    SITE
        https://hub.docker.com/r/bitnami/kafka/
    INSTALLATION
        curl -sSL https://raw.githubusercontent.com/bitnami/bitnami-docker-kafka/master/docker-compose.yml > docker-compose.yml
        docker-compose up -d
    RUN
        dcup
    COMMANDS
        EXEC INTO KAFKA CONTAINER
            cullen@Cullen-BattleStation:~/eclipse-workspace/KAFKA$ dcls
            CONTAINER ID   IMAGE                   COMMAND                  CREATED         STATUS         PORTS                                                                                  NAMES
            913b2476bac2   bitnami/kafka:3.1       "/opt/bitnami/script…"   3 minutes ago   Up 3 minutes   0.0.0.0:9092->9092/tcp, :::9092->9092/tcp                                              kafka_kafka_1
            2d6f7508c88a   bitnami/zookeeper:3.8   "/opt/bitnami/script…"   3 minutes ago   Up 3 minutes   2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, :::2181->2181/tcp, 8080/tcp                kafka_zookeeper_1
            ad89ea4fff4a   mariadb:latest          "docker-entrypoint.s…"   3 weeks ago     Up 2 days      0.0.0.0:3306->3306/tcp, :::3306->3306/tcp                                              yard_yard-db_1
            035c2f922e84   yard:latest             "java -jar /maven/Ya…"   3 weeks ago     Up 2 days      0.0.0.0:8000->8000/tcp, :::8000->8000/tcp, 0.0.0.0:8080->8080/tcp, :::8080->8080/tcp   yard_yard-app_1
            cullen@Cullen-BattleStation:~/eclipse-workspace/KAFKA$ docker exec -it 913b2476bac2 /bin/bash
        RUN COMMANDS FROM 
            /opt/bitnami/kafka/bin
        KAFKA COMMANDS
            LIST TOPICS
                ./kafka-topics.sh --list --bootstrap-server localhost:9092
            CREATE TOPIC
                ./kafka-topics.sh --create --topic test --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 #createtest
            PRODUCT AND CONSUME TEST
                PRODUCE - EXEC INTO CONTAINER
                    I have no name!@913b2476bac2:/opt/bitnami/kafka/bin$ ./kafka-console-producer.sh --broker-list localhost:9092 --topic test #producetest
                    >hello
                    >kafka
                    >how
                    >you doing?
                    >
                CONSUME - EXEC INTO CONTAINER AGAIN
                    I have no name!@913b2476bac2:/opt/bitnami/kafka/bin$ ./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning $consumetest
                    hello
                    kafka
                    how
                    you doing?
            TERMINOLOGY
                PRODUCERS - they send data to kafka topics
            CONNECT TO ZOOKEEPER
                cd /opt/bitnami/kafka/bin
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                I have no name!@913b2476bac2:/opt/bitnami/kafka/bin$ ./zookeeper-shell.sh zookeeper:2181
                Connecting to zookeeper:2181
                Welcome to ZooKeeper!
                JLine support is disabled

                WATCHER::

                WatchedEvent state:SyncConnected type:None path:null
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                ls /
                [admin, brokers, cluster, config, consumers, controller, controller_epoch, feature, isr_change_notification, latest_producer_id_block, log_dir_event_notification, zookeeper]
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                ls /brokers/ids
                [1001]
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                get /brokers/ids/1001
                {"listener_security_protocol_map":{"PLAINTEXT":"PLAINTEXT"},"endpoints":["PLAINTEXT://913b2476bac2:9092"],"jmx_port":-1,"features":{},"host":"913b2476bac2","timestamp":"1651050284198","port":9092,"version":5}
                XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                get /controller_epoch
                1

### First run logs
edy@edy-A520M-S2H:~/eclipse-workspace/KAFKA/mykafkaproducer$ dcup
Creating network "mykafkaproducer_default" with the default driver
Creating mykafkaproducer_mykafka_producer_app_1 ... done
Attaching to mykafkaproducer_mykafka_producer_app_1
mykafka_producer_app_1  | Listening for transport dt_socket at address: 8000
mykafka_producer_app_1  | 
mykafka_producer_app_1  |   .   ____          _            __ _ _
mykafka_producer_app_1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
mykafka_producer_app_1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
mykafka_producer_app_1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
mykafka_producer_app_1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
mykafka_producer_app_1  |  =========|_|==============|___/=/_/_/_/
mykafka_producer_app_1  |  :: Spring Boot ::                (v2.7.3)
mykafka_producer_app_1  | 
mykafka_producer_app_1  | 2022-08-28 17:06:03.451  INFO 1 --- [           main] z.c.e.m.producer.MykafkaApplication      : Starting MykafkaApplication v0.0.1-SNAPSHOT using Java 17.0.2 on f97e85153474 with PID 1 (/maven/mykafkaproducer-0.0.1-SNAPSHOT.jar started by root in /)
mykafka_producer_app_1  | 2022-08-28 17:06:03.454  INFO 1 --- [           main] z.c.e.m.producer.MykafkaApplication      : No active profile set, falling back to 1 default profile: "default"
mykafka_producer_app_1  | 2022-08-28 17:06:04.423  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
mykafka_producer_app_1  | 2022-08-28 17:06:04.432  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
mykafka_producer_app_1  | 2022-08-28 17:06:04.432  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.65]
mykafka_producer_app_1  | 2022-08-28 17:06:04.510  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
mykafka_producer_app_1  | 2022-08-28 17:06:04.511  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 998 ms
mykafka_producer_app_1  | 2022-08-28 17:06:05.062  INFO 1 --- [           main] o.a.k.clients.admin.AdminClientConfig    : AdminClientConfig values: 
mykafka_producer_app_1  | 	bootstrap.servers = [172.18.0.3:9092]
mykafka_producer_app_1  | 	client.dns.lookup = use_all_dns_ips
mykafka_producer_app_1  | 	client.id = 
mykafka_producer_app_1  | 	connections.max.idle.ms = 300000
mykafka_producer_app_1  | 	default.api.timeout.ms = 60000
mykafka_producer_app_1  | 	metadata.max.age.ms = 300000
mykafka_producer_app_1  | 	metric.reporters = []
mykafka_producer_app_1  | 	metrics.num.samples = 2
mykafka_producer_app_1  | 	metrics.recording.level = INFO
mykafka_producer_app_1  | 	metrics.sample.window.ms = 30000
mykafka_producer_app_1  | 	receive.buffer.bytes = 65536
mykafka_producer_app_1  | 	reconnect.backoff.max.ms = 1000
mykafka_producer_app_1  | 	reconnect.backoff.ms = 50
mykafka_producer_app_1  | 	request.timeout.ms = 30000
mykafka_producer_app_1  | 	retries = 2147483647
mykafka_producer_app_1  | 	retry.backoff.ms = 100
mykafka_producer_app_1  | 	sasl.client.callback.handler.class = null
mykafka_producer_app_1  | 	sasl.jaas.config = null
mykafka_producer_app_1  | 	sasl.kerberos.kinit.cmd = /usr/bin/kinit
mykafka_producer_app_1  | 	sasl.kerberos.min.time.before.relogin = 60000
mykafka_producer_app_1  | 	sasl.kerberos.service.name = null
mykafka_producer_app_1  | 	sasl.kerberos.ticket.renew.jitter = 0.05
mykafka_producer_app_1  | 	sasl.kerberos.ticket.renew.window.factor = 0.8
mykafka_producer_app_1  | 	sasl.login.callback.handler.class = null
mykafka_producer_app_1  | 	sasl.login.class = null
mykafka_producer_app_1  | 	sasl.login.connect.timeout.ms = null
mykafka_producer_app_1  | 	sasl.login.read.timeout.ms = null
mykafka_producer_app_1  | 	sasl.login.refresh.buffer.seconds = 300
mykafka_producer_app_1  | 	sasl.login.refresh.min.period.seconds = 60
mykafka_producer_app_1  | 	sasl.login.refresh.window.factor = 0.8
mykafka_producer_app_1  | 	sasl.login.refresh.window.jitter = 0.05
mykafka_producer_app_1  | 	sasl.login.retry.backoff.max.ms = 10000
mykafka_producer_app_1  | 	sasl.login.retry.backoff.ms = 100
mykafka_producer_app_1  | 	sasl.mechanism = GSSAPI
mykafka_producer_app_1  | 	sasl.oauthbearer.clock.skew.seconds = 30
mykafka_producer_app_1  | 	sasl.oauthbearer.expected.audience = null
mykafka_producer_app_1  | 	sasl.oauthbearer.expected.issuer = null
mykafka_producer_app_1  | 	sasl.oauthbearer.jwks.endpoint.refresh.ms = 3600000
mykafka_producer_app_1  | 	sasl.oauthbearer.jwks.endpoint.retry.backoff.max.ms = 10000
mykafka_producer_app_1  | 	sasl.oauthbearer.jwks.endpoint.retry.backoff.ms = 100
mykafka_producer_app_1  | 	sasl.oauthbearer.jwks.endpoint.url = null
mykafka_producer_app_1  | 	sasl.oauthbearer.scope.claim.name = scope
mykafka_producer_app_1  | 	sasl.oauthbearer.sub.claim.name = sub
mykafka_producer_app_1  | 	sasl.oauthbearer.token.endpoint.url = null
mykafka_producer_app_1  | 	security.protocol = PLAINTEXT
mykafka_producer_app_1  | 	security.providers = null
mykafka_producer_app_1  | 	send.buffer.bytes = 131072
mykafka_producer_app_1  | 	socket.connection.setup.timeout.max.ms = 30000
mykafka_producer_app_1  | 	socket.connection.setup.timeout.ms = 10000
mykafka_producer_app_1  | 	ssl.cipher.suites = null
mykafka_producer_app_1  | 	ssl.enabled.protocols = [TLSv1.2, TLSv1.3]
mykafka_producer_app_1  | 	ssl.endpoint.identification.algorithm = https
mykafka_producer_app_1  | 	ssl.engine.factory.class = null
mykafka_producer_app_1  | 	ssl.key.password = null
mykafka_producer_app_1  | 	ssl.keymanager.algorithm = SunX509
mykafka_producer_app_1  | 	ssl.keystore.certificate.chain = null
mykafka_producer_app_1  | 	ssl.keystore.key = null
mykafka_producer_app_1  | 	ssl.keystore.location = null
mykafka_producer_app_1  | 	ssl.keystore.password = null
mykafka_producer_app_1  | 	ssl.keystore.type = JKS
mykafka_producer_app_1  | 	ssl.protocol = TLSv1.3
mykafka_producer_app_1  | 	ssl.provider = null
mykafka_producer_app_1  | 	ssl.secure.random.implementation = null
mykafka_producer_app_1  | 	ssl.trustmanager.algorithm = PKIX
mykafka_producer_app_1  | 	ssl.truststore.certificates = null
mykafka_producer_app_1  | 	ssl.truststore.location = null
mykafka_producer_app_1  | 	ssl.truststore.password = null
mykafka_producer_app_1  | 	ssl.truststore.type = JKS
mykafka_producer_app_1  | 
mykafka_producer_app_1  | 2022-08-28 17:06:05.167  INFO 1 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.1.1
mykafka_producer_app_1  | 2022-08-28 17:06:05.168  INFO 1 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 97671528ba54a138
mykafka_producer_app_1  | 2022-08-28 17:06:05.168  INFO 1 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1661706365166
mykafka_producer_app_1  | 2022-08-28 17:06:14.633  INFO 1 --- [| adminclient-1] org.apache.kafka.clients.NetworkClient   : [AdminClient clientId=adminclient-1] Disconnecting from node -1 due to socket connection setup timeout. The timeout value is 9421 ms.
