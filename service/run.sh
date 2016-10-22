java -cp target/service-1.0-SNAPSHOT-fat.jar -Dhazelcast_cluster_ip_addresses="127.0.0.1" io.vertx.core.Starter run service.Service -cluster
