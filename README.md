# best-pay-demo
本示例演示了如何调用[best-pay-sdk](https://github.com/lly835/best-pay-sdk)

####项目说明
1. 需要在Jdk版本>1.8上运行(纳尼,你还在1.7?1.9都快出了你不知道吗?)
2. 本项目采用SpringBoot1.5开发

####项目结构
```bash
src/main/java/com/github/lly835
├── PayDemoApplication.java    
├── ServletInitializer.java
├── config
│   └── PayConfig.java       //支付密钥配置类
└── controller
    └── PayController.java   //支付调用
```

####运行示例
1. 运行前需要先配置好密钥, 见`PayConfig.java`
2. 运行命令
    ```bash
    git clone git@github.com:lly835/best-pay-demo.git
    cd best-pay-demo
    mvn clean package
    java -jar target/*.war
    ```
3. 浏览器访问http://127.0.0.1:8080/pay
4. 查看日志
