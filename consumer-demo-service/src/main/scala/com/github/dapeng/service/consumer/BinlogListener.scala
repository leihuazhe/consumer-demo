package com.github.dapeng.service.consumer

import com.today.binlog.BinlogEvent
import com.today.eventbus.annotation.KafkaConsumer
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

/**
  *
  * 描述: com.github.dapeng.service.consumer
  *
  * @author hz.lei
  * @date 2018年05月06日 下午11:38
  */
@KafkaConsumer(groupId = "GOODS_0.0.1_EVENT", topic = "Binlog")
class BinlogListener {
  private val logger = LoggerFactory.getLogger(getClass)

  @com.today.eventbus.annotation.BinlogListener
  def onBinlog(event: java.util.List[BinlogEvent]): Unit = {
    event.asScala.foreach(e => {
      logger.info(s"recevie msg: ${e.toString}")
    })
  }

}
