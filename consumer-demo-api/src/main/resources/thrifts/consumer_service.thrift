namespace java com.github.dapeng.consumer.service

include "consumer_domain.thrift"
/**
* 接收端业务服务
**/
service ConsumerService {
/**
# sayHello
**/
    string sayHello(1: consumer_domain.Hello hello)

}(group="EventTest")