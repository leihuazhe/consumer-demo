package com.github.dapeng.service.consumer

import com.github.dapeng.consumer.scala.domain.Hello
import com.github.dapeng.consumer.scala.service.ConsumerService

/**
  * @author with struy.
  *         Create by 2018/3/4 17:22
  *         email :yq1724555319@gmail.com
  */

class ConsumerServiceImpl extends ConsumerService{
  override def sayHello(hello: Hello): String = {
    s"hello ${hello.name}"
  }
}
