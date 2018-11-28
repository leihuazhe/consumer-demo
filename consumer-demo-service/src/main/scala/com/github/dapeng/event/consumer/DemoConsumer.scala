package com.github.dapeng.event.consumer

import java.util.Random

import com.github.dapeng.db.ConsumerDataSource
import com.today.eventbus.annotation.{KafkaConsumer, KafkaListener}
import com.today.eventbus.common.ConsumerContext
import com.today.user.scala.events.{ActivedEvent, RegisteredEvent}
import com.today.user.scala.events.serializer.{ActivedEventSerializer, RegisteredEventSerializer}
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional
import wangzx.scala_commons.sql._


/**
  * @author with struy.
  *         Create by 2018/3/3 20:21
  *         email :yq1724555319@gmail.com
  */
@KafkaConsumer(groupId = "demo_subscribe1", topic = "member_test", maxAttempts = 25, retryInterval = 2000)
@Transactional(rollbackFor = Array(classOf[Throwable]))
class DemoConsumer {
  val LOGGER = LoggerFactory.getLogger(getClass)
  val dataSource = ConsumerDataSource.mysqlData

  @KafkaListener(serializer = classOf[RegisteredEventSerializer])
  def subscribeRegisteredEvent(event: RegisteredEvent): Unit = {
    ConsumerDataSource.mysqlData.executeUpdate(sql"update test set name='maple' where id = 1 ")
    ConsumerDataSource.mysqlData.executeUpdate(sql"update test set name='struy' where id = 2 ")
    LOGGER.info(s"=====> Subscribed RegisteredEvent")

    val num = new Random().nextInt(2)
    //    val i = 1 / 0
    Thread.sleep(2000)

    val i = 2 / 0;

    println(s"收到消息 RegisteredEvent  ${event.id} ${event.userId}")
  }


  @KafkaListener(serializer = classOf[ActivedEventSerializer])
  def subscribeRegisteredEvent(context: ConsumerContext, event: ActivedEvent): Unit = {
    // 如果顺序这样写，会抛出异常。
    //  def subscribeRegisteredEvent(event: ActivedEvent, context: ConsumerContext): Unit = {
    val c = context.toString
    println(s"fetch metadata $c")

    ConsumerDataSource.mysqlData.executeUpdate(sql"update test set name='maple' where id = 1 ")
    ConsumerDataSource.mysqlData.executeUpdate(sql"update test set name='struy' where id = 2 ")
    LOGGER.info(s"=====> Subscribed ActivedEvent")
    println(s"收到消息 ActivedEvent  ${event.id} ${event.userId} ")
  }

}
