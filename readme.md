#Spring Cloud Demo
>  本 Demo 使用 Spring Cloud netflix 组件
>

## Spring cloud 角色介绍
- 注册中心：  所有的微服务将会注册到注册中心，可提供服务注册与发现功能。
- 服务提供者： 提供服务的主体， 可自由决定提供的服务内容。 最终会被注册到注册中心。 
- 服务消费者： 消费在注册中心注册的服务。
- 微服务： 一个独立的应用， 理论上是一个微服务只提供单一服务。 也就是只做一件事情。 注册到注册中心的最小单元。
- 网关：   微服务安全保障关口，提供路由，可作为服务器端负载均衡使用。 可添加自定义Filter 进行全局权限控制。

## Demo 简介
> 本Demo包含Spring Cloud 入门内容，一个注册中心，两组Spring Cloud服务，两种消费服务的方式, 以及网关路由。
> 其中Feign方式中集成了hystrix 熔断器。 Ribbon负责客户端负载均衡。 Feign 默认使用Ribbon负载均衡。 网关中添加
> 了一个自定义过滤器。 可在过滤器中做权限控制等逻辑。

## Demo 各个模块介绍
-  spring-cloud-eureka-server ： 注册中心
-  spring-cloud-eureka-client :  服务提供者  service-hi
-  spring-cloud-eureka-client2:  服务提供者  service-hi
-  spring-cloud-eureka-client3:  服务提供者  service-hello
-  spring-cloud-eureka-feign:    服务消费者  通过Feign方式消费服务， 服务消费入口, 集成 Ribbon 负载均衡，以及 hystrix 熔断。 
-  spring-cloud-eureka-ribbon:   服务消费者  通过Ribbon方式消费服务, 服务消费入口 。
-  spring-cloud-zuul:            网关  将消费者访问路径进行路由转发，提高消费者高可用。 所有请求从网关进出。 

## Demo 运行
1.  注册中心： spring-cloud-eureka-server
2.  服务提供者 （最少启动一个）： spring-cloud-eureka-client，spring-cloud-eureka-client2，spring-cloud-eureka-client3
3.  服务消费者 （最少启动一个）： spring-cloud-eureka-feign，spring-cloud-eureka-ribbon
4.  网关 (可选择性启动) ： spring-cloud-zuul 


## 注意事项
1. 注册到注册中心的服务，必须是可访问的服务。 创建好服务后，该服务可直接使用Http工具访问，若无法正常访问，即使注册到注册中心，亦无法访问。
但注册中心却无法识别，会认为该服务是正常状态。 
2. 服务提供者是基础的Rest服务，Spring Cloud 只是基于此所作的一系列整合。 使用Spring Cloud，需通过消费者
做转发，消费者通过客户端负载均衡从而调用目标服务。
3. 使用Hystrix对Feign支持时，需配置Feign开启对Hystrix 支持，否则无法正常使用。 feign.hystrix.enabled = true
4. 若开启网关，则需配置路由规则。 若使用网关，所有服务消费皆需通过网关消费，由网关进行路由转发，切不可越过网关，否则网关失效。
5. 网关配置自定义Filter时，需主动创建一个Filter对象，并交由Spring管理，否则Filter不生效。

## 其他事项