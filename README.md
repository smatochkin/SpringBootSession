# Sample SpringBoot app with session management in Redis

The purpose of this app is to test Redis backed session replication
for SpringBoot application hosted in Pivotal Cloud Foundry.

## Issues found

1. Pivotal Cloud Foundry Redis Managed service does not support
   `CONFIG` command. `CONFIG` command is used by Spring Session
   Redis framework to enable notifications.

2. Cloud Foundry User Provided Services do not support tags. Cloud
  Foundry Service tags are used by Spring Boot Cloud Connectors to
  autowire backing services. Lack of tags support in User Provided
  Services makes UPS not usable for Spring Boot apps that utilize
  Cloud Connectors.
