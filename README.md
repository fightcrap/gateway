# spring-boot基本搭建
### 应用技术有：
> - spring-boot
> - fastjson
> - dubbo
> - druid
> - mybatis


### 文件结构为：
```
├── README.md
├── api
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── fightingcrap
│                       └── server
│                           └── api
│                               ├── api
│                               ├── dto
│                               ├── enums
│                               └── utils
├── application-dev.yml
├── application-online.yml
├── common
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── fightingcrap
│                       └── server
│                           └── common
│                               ├── dto
│                               │   ├── DefaultResponse.java
│                               │   └── DefaultWebResponse.java
│                               ├── enums
│                               │   ├── ResultCode.java
│                               │   └── WebResultCode.java
│                               └── expection
│                                   ├── CommonExpection.java
│                                   ├── ServiceCommonExpection.java
│                                   └── WebCommonExpection.java
├── dao
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── fightingcrap
│           │           └── server
│           │               └── dao
│           │                   ├── dao
│           │                   │   └── PersonMapper.java
│           │                   └── entity
│           │                       └── Person.java
│           └── resources
│               ├── application-dataSource.yml
│               └── sqlmap
│                   └── PersonDAO-mapper.xml
├── impl
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── fightingcrap
│                       └── server
│                           └── impl
│                               ├── enums
│                               ├── impl
│                               └── utils
├── pom.xml
├── service
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│               └── com
│                   └── fightingcrap
│                       └── server
│                           └── service
│                               ├── enums
│                               ├── service
│                               └── utils
└── web
    ├── pom.xml
    └── src
        └── main
            ├── java
            │   └── com
            │       └── fightingcrap
            │           └── server
            │               └── web
            │                   ├── WebApplication.java
            │                   ├── annotation
            │                   │   └── ServiceLog.java
            │                   ├── aspect
            │                   │   ├── DubboRequestLogAspect.aj
            │                   │   ├── RequestLogAspect.aj
            │                   │   └── WebRequestLogAspect.aj
            │                   └── config
            │                       └── FastJsonConfigBean.java
            └── resources
                └── application.yml

```
#### 文件介绍：
- api module
    > 该模块主要是用于对外api开放。由于项目中应用了dubbo项目，所以对外提供rpc服务的接口，以及枚举，实体类，工具等信息都添加在该模块下

- common module
    > 该模块主要是用于通用工具类，通用实体。

- dao module
    > 该模块处理数据库交互的内容。dao是mybatis接口定义，entity是数据库实体类存放的地方，资源文件中：sqlmao是mybatis数据库xml实现类。
    application-dataSource.yml是链接数据库配置，依赖于外层的配置信息。一般不需要该。

- impl module
    > 该模块是用于api层的实现。
 
- service module
    > 该模块是基础服务提供模块，基本服务统一在这层处理，由上层服务组合成完整链路逻辑，只提供基础服务


