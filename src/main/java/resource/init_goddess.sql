CREATE PROCEDURE init_goddess()
  BEGIN
    DROP TABLE IF EXISTS `goddess`;
    CREATE TABLE `goddess` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `user_name` varchar(30) NOT NULL,
      `sex` int(11) DEFAULT NULL,
      `age` int(11) DEFAULT NULL,
      `birthday` date DEFAULT NULL,
      `email` varchar(30) DEFAULT NULL,
      `mobile` varchar(11) DEFAULT NULL,
      `create_date` date DEFAULT NULL,
      `update_date` date DEFAULT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

    INSERT INTO goddess VALUE ('1', '小白', '1', '10', '2000-12-12', 'xiaoxi@163.com', '13911111111', current_date(), current_date());
    INSERT INTO goddess VALUE ('2', '小黑', '1', '11', '2001-12-12', 'xiaoxi@163.com', '13911111111', current_date(), current_date());
    INSERT INTO goddess VALUE ('3', '小红', '1', '12', '2002-12-12', 'xiaoxi@163.com', '13911111111', current_date(), current_date());
    INSERT INTO goddess VALUE ('4', '小绿', '1', '13', '2003-12-12', 'xiaoxi@163.com', '13911111111', current_date(), current_date());
    INSERT INTO goddess VALUE ('5', '小紫', '1', '14', '2004-12-12', 'xiaoxi@163.com', '13911111111', current_date(), current_date());
  END

