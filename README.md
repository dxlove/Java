# Java
笔记
deisgn 中包含设计模式等 众多工具类的demo.     
otps是 java微服务的实现,spring boot spring cloud       
java微服务的架构包含 Eureka(服务的发现和治理) Ribbon(客户端负载均衡) Hystrix(服务容错保护) Zuul(API网关服务)     
eureka-server:是注册中心服务器,(高可用实现就是多个server相互在对方服务列表中注册)        
>>服务注册: 服务提供者启动的时候会通过发送REST请求的方式将自己注册到Eureka Server       
>>服务同步: 当服务提供者发送注册请求到一个服务注册中心,他会将该请求转发给集群其他注册中心,从而实现注册中心之间的服务同步       
>>服务续约: 在注册完成之后,服务提供者会维护一个心跳来持续告诉Eureka Server:"我还活着"       
>>获取服务: Eureka Server会维护一份只读的服务清单来返回给客户端,同时该缓存清单会每隔30秒跟新一次.     
>>服务调用: 客户端可以根据自己的需要决定具体调用那个实例,在Ribbon中会默认采用轮询的方式调用,从而实现客户端负责均衡,对于访问的选择,Eureka
中有Region和Zone概念,一个Region中可以包含多个Zone.每个客户端要被注册到一个Zone中,所以每个客户端对应一个Region和一个Zone,在进行调用时,优先访问同处一个Zone中的服务提供方,访问不到,在访问其他的.      
>>服务下线: 当服务实例进行正常关闭时,会触发一次服务下线的REST请求给Server        
>>时效剔除: Server会启动的时候会创建一个定时任务,默认60s将当前清单中超时(默认90s)没有续约的服务剔除.        
>>自我保护: 统计心跳失败的比例,15分钟之内是否低于85%.如果出现低于的情况,Server会将当前实例注册信息保护起来,让这些实例不会过期.       


ribbon-consumer: 负载均衡服务器,负责接收客户端请求,分发给特定的指定server名称的服务提供者.      
Spring Cloud Hystrix(服务容错保护)
>>命令模式和观察者-订阅者模式        
>>可以构建同步/异步API      
>>可以构建服务降级(俗称 命令执行失败后的操作) 写请求一般返回值void 可以不降级        
>>命令名称.分组,线程池的划分(commandKey,groupKey,threadPoolKey)     
>>请求缓存 @CacheResult或者 @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")实现 也可以@CacheResult配合@CacheKey("id")实现