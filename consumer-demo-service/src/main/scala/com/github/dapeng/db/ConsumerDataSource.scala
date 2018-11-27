package com.github.dapeng.db

import javax.annotation.Resource
import javax.sql.DataSource

/**
  *
  * 描述: com.github.dapeng.db
  *
  * @author hz.lei
  * @date 2018年05月07日 上午12:02
  */
object ConsumerDataSource {

  @Resource(name = "tx_consumer_dataSource")
  var mysqlData: DataSource = _

  def getInstance: ConsumerDataSource.this.type = this

}


/*class ConsumerDataSource {
  /**
    * 使用 事务控制的dataSource
    *
    */
  @Resource(name = "tx_consumer_dataSource")
  def setMysqlData(mysqlData: DataSource): Unit = {
    ConsumerDataSource.mysqlData = mysqlData
  }
}*/






