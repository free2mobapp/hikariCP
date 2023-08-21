# Overview
Code to go through HikariCP (Connection Pool)

Get the Hikari CP metrics
run the following endpoint.
to get the number of connections use:
http://localhost:8080/actuator/metrics/hikaricp.connections

The following metrics are available to monitor Hikari CP
They are
"hikaricp.connections",
"hikaricp.connections.acquire",
"hikaricp.connections.active",
"hikaricp.connections.creation",
"hikaricp.connections.idle",
"hikaricp.connections.max",
"hikaricp.connections.min",
"hikaricp.connections.pending",
"hikaricp.connections.timeout",
"hikaricp.connections.usage",

what the most common Hikari properties means,
Here is a list of most common properties you can include:

spring.datasource.hikari.autoCommit: This property controls the default auto-commit behavior of connections returned from the pool. It is a boolean value. Default: true

spring.datasource.hikari.connectionTimeout: This property controls the maximum number of milliseconds that a client will wait for a connection from the pool. If this time exceeds without a connection becoming available, a SQLException will be thrown. Default: 30000 (30 seconds)

spring.datasource.hikari.idleTimeout: This property controls the maximum amount of time that a connection is allowed to sit idle in the pool.. A value of 0 means that idle connections are never removed from the pool. The minimum allowed value is 10000ms (10 seconds). Default: 600000 (10 minutes)

spring.datasource.hikari.keepaliveTime: This property controls how frequently HikariCP will attempt to keep a connection alive, in order to prevent it from being timed out by the database or network infrastructure. This value must be less than the maxLifetime value. A “keepalive” will only occur on an idle connection. The minimum allowed value is 30000ms (30 seconds), but a value in the range of minutes is most desirable. Default: 0 (disabled)

spring.datasource.hikari.maxLifetime: This property controls the maximum lifetime of a connection in the pool. An in-use connection will never be retired, only when it is closed will it then be removed. The minimum allowed value is 30000ms (30 seconds). Default: 1800000 (30 minutes)

spring.datasource.hikari.minimumIdle: This property controls the minimum number of idle connections that HikariCP tries to maintain in the pool. If the idle connections dip below this value and total connections in the pool are less than maximumPoolSize, HikariCP will make a best effort to add additional connections quickly and efficiently. Default: same as maximumPoolSize

spring.datasource.hikari.maximumPoolSize: This property controls the maximum size that the pool is allowed to reach, including both idle and in-use connections. Basically this value will determine the maximum number of actual connections to the database backend. Default: 10

spring.datasource.hikari.poolName: This property represents a user-defined name for the connection pool and appears mainly in logging and JMX management consoles to identify pools and pool configurations. Default: auto-generated.

# Reference
https://www.baeldung.com/spring-boot-hikari
https://howtodoinjava.com/spring-boot2/jpa-hibernate-hikaricp-config/
Article on pool sizing: https://github.com/brettwooldridge/HikariCP/wiki/About-Pool-Sizing
Leak Detection: https://www.youtube.com/watch?v=FOQwsAQLseo&ab_channel=ChargeAhead