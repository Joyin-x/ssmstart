#简单的ssm整合


程序运行只需要在你的数据库中有如下的一张表，然后修改 src/main/resources/jdbc.properties 的配置为你的数据库连接即可。
数据库表


```
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` (`id`, `name`)
VALUES
	(1,'超级管理员'),
	(2,'一般用户');

/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

```

