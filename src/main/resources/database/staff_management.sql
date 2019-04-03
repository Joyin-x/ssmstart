/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MariaDB
 Source Server Version : 50560
 Source Host           : 120.79.187.96:3306
 Source Schema         : staff_management

 Target Server Type    : MariaDB
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 03/04/2019 19:33:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤表ID',
  `employee_id` int(11) NOT NULL COMMENT '员工ID',
  `office_time` datetime(0) NOT NULL COMMENT '上班考勤时间',
  `after_work` datetime(0) NULL DEFAULT NULL COMMENT '下班考勤时间',
  `location` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打卡地点',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_attendance-employee`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (2, 4, '2019-03-19 07:54:10', '2019-03-19 11:54:12', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (3, 6, '2019-03-19 08:54:07', '2019-03-19 11:54:12', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (19, 9, '2019-03-19 11:54:07', '2019-03-19 11:54:12', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (20, 1, '2019-03-20 11:39:55', '2019-03-20 11:54:12', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (21, 1, '2019-03-21 15:38:10', '2019-03-21 16:15:57', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (23, 1, '2019-03-22 17:26:24', '2019-03-22 17:26:29', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (24, 9, '2019-03-23 21:47:41', '2019-03-23 21:47:48', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (25, 1, '2019-03-24 12:50:26', '2019-03-24 12:50:29', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (26, 21, '2019-03-25 00:32:59', '2019-03-25 00:37:06', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (27, 28, '2019-03-25 13:19:31', '2019-03-25 13:25:44', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (28, 25, '2019-03-25 13:27:47', '2019-03-25 13:27:50', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (31, 5, '2019-03-26 23:21:58', '2019-03-26 23:22:03', '广东省广州市天河区天府路1号');
INSERT INTO `attendance` VALUES (32, 9, '2019-03-26 23:26:04', '2019-03-26 23:26:07', '广东省广州市天河区天府路1号');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `employee_id` int(3) NULL DEFAULT NULL COMMENT '负责人id',
  `department_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `principal` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门负责人',
  `established_time` date NULL DEFAULT NULL COMMENT '成立时间',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门描述',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `emplouee_id1123`(`employee_id`) USING BTREE,
  INDEX `id`(`id`, `employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 36, '人事部', '沙建辉', '2019-01-07', NULL);
INSERT INTO `department` VALUES (2, 16, '销售部', '温倩', '2019-01-07', NULL);
INSERT INTO `department` VALUES (3, 1, '财务部', '陈明明', '2018-10-29', NULL);
INSERT INTO `department` VALUES (4, 3, '市场部', '李希', '2018-10-08', NULL);
INSERT INTO `department` VALUES (5, 37, '研发部', '李剑开', '2018-09-11', NULL);
INSERT INTO `department` VALUES (6, 18, '程序开发部', '刘晓静', '2018-08-01', NULL);

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `id` int(3) NOT NULL COMMENT '公告表id',
  `employeeName` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论员工姓名',
  `employeeID` int(3) NOT NULL COMMENT '评论的员工',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论的内容',
  `discussTime` date NOT NULL COMMENT '评论的时间',
  `like` tinyint(1) NULL DEFAULT 0 COMMENT '点赞 0未点赞 1已点赞',
  INDEX `employeeID`(`employeeID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES (1, '陈明明', 1, '测试数据，测试数据', '2019-03-22', 1);
INSERT INTO `discuss` VALUES (3, '陈明明', 1, '有点难懂。', '2019-03-23', 0);
INSERT INTO `discuss` VALUES (5, '陈明明', 1, '这个可以有', '2019-03-23', 0);
INSERT INTO `discuss` VALUES (6, '陈明明', 1, '写的不错，支持', '2019-03-23', 0);
INSERT INTO `discuss` VALUES (1, '陈晓', 9, '支持支持', '2019-03-23', 0);
INSERT INTO `discuss` VALUES (1, '陈明明', 1, '测试', '2019-03-24', 0);
INSERT INTO `discuss` VALUES (2, '李希', 3, '123', '2019-03-24', 0);
INSERT INTO `discuss` VALUES (8, '李希', 3, '12', '2019-03-24', 0);
INSERT INTO `discuss` VALUES (1, '慕容复', 21, '测试一下', '2019-03-24', 0);
INSERT INTO `discuss` VALUES (2, '大舅子', 38, '呵', '2019-03-25', 0);
INSERT INTO `discuss` VALUES (2, '温倩', 16, '1', '2019-03-25', 0);
INSERT INTO `discuss` VALUES (5, '陈晓', 9, '测试数据', '2019-03-26', 0);
INSERT INTO `discuss` VALUES (10, '陈晓', 9, '测试测试', '2019-03-26', 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `name` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `sex` int(1) NOT NULL COMMENT '员工性别(0男1女 )',
  `birthday` date NOT NULL COMMENT '出生日期',
  `native_place` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `department_id` int(3) NOT NULL COMMENT '所在部门编号',
  `position` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职务',
  `education` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业学校',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `professional` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `remark` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_department_id`(`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '陈明明', 0, '1999-01-07', '河北省涞水县', '广州市荔湾区恩宁路昌华大街5号', '10086', 3, '财务总监', '本科', '清华大学', '510150@163.com', '财务管理', '入职四年');
INSERT INTO `employee` VALUES (2, '赵敏', 1, '1998-11-03', '辽宁省抚顺县', '广东省广州市五华县平远镇富贵村', '5635832', 4, '市场拓展员', '本科', '北京大学', '5635832@qq.com', '产品管理', '应届生');
INSERT INTO `employee` VALUES (3, '李希', 1, '1990-02-28', '广东省珠海市', '广州市南沙区珠江街珠江西一路38号', '4511462', 4, '市场经理', '本科', '华南理工大学广州学院', '4511462@126.com', '产品管理', '入职六年');
INSERT INTO `employee` VALUES (4, '王涛', 0, '1994-06-16', '北京市朝阳区', '广州市南沙区横沥镇兆丰路3号', '46212989', 2, '销售主任', '本科', '广州海洋大学', '46212989@qq.com', '市场营销', '应届生');
INSERT INTO `employee` VALUES (5, '韩绍华', 1, '1994-02-22', '山西省侯马市', '广东省广州市五华县平远镇富贵村', '84961133', 6, '软件工程师', '本科', '广州大学', '84961133@qq.com', '外贸', '入职七年');
INSERT INTO `employee` VALUES (6, '李航', 1, '1991-07-19', '上海市静安区', '广东省广州市南沙区黄阁镇吉祥路1号', '84978811', 6, '系统分析员', '本科', '广州培正大学', '84978811@163.com', '大数据人工智能', '实习生');
INSERT INTO `employee` VALUES (7, '李剑', 0, '2000-07-05', '北京市通州区', '广州市越秀区连新路11号', '2129891', 6, '软件工程师', '本科', '华南农业大学', '2129891@qq.com', '计算机科学与技术', '入职五年');
INSERT INTO `employee` VALUES (8, '石磊', 0, '1994-06-16', '河南省宜州市', '北京市东城区和平里6区8号楼8-3号', '564300', 2, '销售经理', '本科', '华南师范大学', '564300@qq.com', '网络工程', '应届生');
INSERT INTO `employee` VALUES (9, '陈晓', 0, '0000-00-00', '天津市津南区', '广东省广州市五华县平远镇富贵村', '15017814621', 2, '销售代表', '本科', '山西交通学院', '1461483915@qq.com', '市场营销', '入职两年');
INSERT INTO `employee` VALUES (10, '林阳', 0, '1989-06-03', '福建省沙县', '北京市崇文区夕照寺街16号华城小区4号', '87824', 1, '人事主管', '本科', '武汉大学', '87824@qq.com', '管理学', '入职两年');
INSERT INTO `employee` VALUES (11, '林月', 1, '1986-11-02', '山西省交口县', '广东省广州市五华县平远镇富贵村', '5203146', 1, '行政助理', '本科', '南京大学', '5203146@qq.com', '经济学', '应届生');
INSERT INTO `employee` VALUES (12, '刘森德', 0, '1988-12-23', '安徽省无为县', '广东省广州市五华县平远镇富贵村', '225412', 4, '产品主管', '本科', '中山大学', '225412@qq.com', '市场营销', '入职七年');
INSERT INTO `employee` VALUES (13, '李浮尘', 0, '1992-11-23', '河北省高阳县', '广东省广州市荔湾区沙面大街8号', '81216810', 3, '财务助理', '本科', '中南大学', '81216810@qq.com', '经济学', '实习生');
INSERT INTO `employee` VALUES (15, '萧炎', 0, '1978-03-30', '福建省建宁县', '广东省广州市五华县平远镇富贵村', '74524221', 2, '销售代表', '本科', '西安交通大学', '74524221@qq.com', '外贸', '入职七年');
INSERT INTO `employee` VALUES (16, '温倩', 1, '1994-04-19', '北京市县', '广东省广州市五华县平远镇富贵村', '503720', 1, '销售总监', '本科', '厦门大学', '503720@qq.com', '国际经济与贸易', '应届生');
INSERT INTO `employee` VALUES (17, '绫清竹', 1, '1986-05-06', '河南省温县', '广东省广州市五华县平远镇富贵村', '654312', 2, '销售经理', '本科', '同济大学', '654312@qq.com', '金融', '入职两年');
INSERT INTO `employee` VALUES (18, '刘晓静', 1, '1993-03-01', '上海市松江区', '北京市崇文区夕照寺街16号华城小区4号', '985641', 6, 'IT主管', '本科', '西安交通大学', '985641@qq.com', '网络工程', '应届生');
INSERT INTO `employee` VALUES (19, '宇文天', 0, '1989-06-16', '江苏省无锡市', '广东省广州市五华县平远镇富贵村', '59711032', 3, '财务经理', '本科', '四川大学', '59711032@qq.com', '财务管理', '入职七年');
INSERT INTO `employee` VALUES (20, '段誉', 0, '1988-02-26', '广东省佛山市', '广东省广州市五华县平远镇富贵村', '1651431', 4, '市场拓展经理', '本科', '华中科技大学', '1651431@qq.com', '市场营销', '应届生');
INSERT INTO `employee` VALUES (21, '慕容复', 1, '1996-01-26', '安徽省无为县', '广东省广州市五华县平远镇富贵村', '452131', 6, '硬件测试工程师', '本科', '东南大学', '452131@qq.com', '软件工程', '入职两年');
INSERT INTO `employee` VALUES (22, '郭雅', 1, '1993-05-11', '浙江省宁波市', '广东省广州市五华县平远镇富贵村', '789461', 3, '审计主管', '本科', '北京航空航天大学', '789461@qq.com', '审计专业', '实习生');
INSERT INTO `employee` VALUES (23, '陈鹏', 0, '1987-04-14', '天津市交香区', '北京市朝阳区常营乡常营民族家园13号楼', '5641359', 4, '广告策划主管', '本科', '湖南大学', '5641359@qq.com', '市场营销', '应届生');
INSERT INTO `employee` VALUES (24, '王彤', 1, '1998-12-09', '浙江省临安市', '广东省广州市五华县平远镇富贵村', '4983416', 3, '出纳员', '本科', '河海大学', '4983416@qq.com', '审计专业', '入职七年');
INSERT INTO `employee` VALUES (25, '徐帆', 1, '1999-02-02', '广西横县', '广东省广州市五华县平远镇富贵村', '5678941', 2, '销售主管', '本科', '南京农业大学', '5678941@qq.com', '外贸', '应届生');
INSERT INTO `employee` VALUES (26, '曾景辉', 1, '1984-03-16', '重庆市长寿区', '广东省广州市五华县平远镇富贵村', '369845', 2, '销售主任', '本科', '东北师范大学', '369845@qq.com', '市场营销', '入职两年');
INSERT INTO `employee` VALUES (27, '吴荣达', 0, '1992-04-06', '四川省中江县', '广东省广州市五华县平远镇富贵村', '15798145', 3, '助理会计', '本科', '郑州大学', '15798145@qq.com', '会计学', '应届生');
INSERT INTO `employee` VALUES (28, '余静霞', 1, '1995-07-11', '广东省潮州市', '广东省广州市五华县平远镇富贵村', '231597', 3, '会计', '本科', '广州大学', '231597@qq.com', '会计学', '入职两年');
INSERT INTO `employee` VALUES (35, '凌天宇', 0, '2002-05-01', '山西省晋城市陵川县', '龙门大道', '54612311', 3, '财务总监', '本科', '山东海道口大学', '54612311@qq.com', '财务管理', '入职半年');
INSERT INTO `employee` VALUES (36, '沙建辉', 1, '2019-08-01', '广东省广州市天河区', '龙门街', '13462652322', 1, '行政经理', '小学', '社会大学', '825514316@qq.com', '管理学', '入职两年');
INSERT INTO `employee` VALUES (37, '李剑开', 1, '1988-07-05', '北京市通州区', '广州市越秀区连新路11号', '2129891256', 5, '研发总监', '本科', '华南农业大学', '2129891256@qq.com', '计算机科学与技术', '入职六年');
INSERT INTO `employee` VALUES (38, '大舅子', 0, '1996-10-01', '广东省广州市天河区', '天河区珠江新城华夏路富力盈凯广场东门', '135641421', 1, '人事助理', '小学', '广东大学', '1461483915@qq.com', '网络工程', '');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`  (
  `employee_id` int(3) NOT NULL COMMENT '员工ID',
  `evaluation_content` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评估内容',
  `evaluation_time` date NULL DEFAULT NULL COMMENT '评估时间',
  `evaluation_level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '能力评估等级',
  ` certificate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证书',
  INDEX `foreign_employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES (1, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');
INSERT INTO `evaluation` VALUES (2, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');
INSERT INTO `evaluation` VALUES (4, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');
INSERT INTO `evaluation` VALUES (5, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');
INSERT INTO `evaluation` VALUES (15, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');
INSERT INTO `evaluation` VALUES (3, '软件综合考试', '2018-11-01', '高级架构师', '软件设计师（高级）');

-- ----------------------------
-- Table structure for mobilize
-- ----------------------------
DROP TABLE IF EXISTS `mobilize`;
CREATE TABLE `mobilize`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位表ID',
  `employee_id` int(3) NULL DEFAULT NULL COMMENT '员工id',
  `original_position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原职务',
  `original_department_id` int(3) NOT NULL COMMENT '原部门id',
  `now_position` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '现职务',
  `now_department_id` int(3) NOT NULL COMMENT '现部门id',
  `transfer_date` date NOT NULL COMMENT '调动日期',
  `transfer_reason` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调动原因',
  `approver` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审批人',
  `mobilize_remark` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreignkey_depatement_id`(`original_department_id`) USING BTREE,
  INDEX `foreignkey_department_id1`(`now_department_id`) USING BTREE,
  INDEX `foreignkey_employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mobilize
-- ----------------------------
INSERT INTO `mobilize` VALUES (2, 3, '招聘专员', 1, '产品推广员', 4, '2019-01-01', '沟通能力突出', '未设置', '再接再厉');
INSERT INTO `mobilize` VALUES (3, 2, '招聘专员', 1, '市场调研主管', 4, '2019-02-14', '员工本人申请', '未设置', '工作能力待审核');
INSERT INTO `mobilize` VALUES (5, 9, '人事主管', 1, '销售代表', 2, '2019-03-01', '工作态度不端正', '未设置', '无');
INSERT INTO `mobilize` VALUES (7, 11, '行政助理', 1, '行政助理', 1, '2019-03-25', '测试', '未设置', '无');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告表id',
  `employee_id` int(11) NOT NULL COMMENT '员工Id',
  `header` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `notice_time` date NULL DEFAULT NULL COMMENT '发布时间',
  `like` int(3) NULL DEFAULT 0 COMMENT '点赞人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreigen_employee`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 3, '青岛胶东国际机场', '寒冬腊月，海风刺骨，正在建设中的青岛胶东国际机场，机械轰鸣、一片繁忙，海星造型的五个指廊日渐精美。记者从青岛胶东国际机场建设指挥部了解到，目前青岛新机场建设已进入“决战期”，预计今年下半年实现转场运行。青岛胶东国际机场建设指挥部副指挥长吴有胜介绍，目前机场建设已全面进入大面积装饰装修和设备安装阶段。航站区方面，海星造型的五个指廊基本呈现，正在推进内部精装工程，超过22万平方米的不锈钢金属屋面施工基本完 成；飞行区方面，东、西两条跑道贯通，其中东跑道采用国际最高运行等级4F标准设计。', '2019-01-01', 0);
INSERT INTO `notice` VALUES (2, 2, '淘宝直播独立App将在春节前上线', '1月23日，据 微信公众号红聘网消息，在淘宝直播机构大会上，淘宝直播负责人赵圆圆透露，淘宝直播独立APP将在春节前正式上线。1月23日，据 微信公众号红聘网消息，在淘宝直播机构大会上，淘宝直播负责人赵圆圆透露，淘宝直播独立APP将在春节前正式上线。淘宝直播是阿里巴巴推出的直播平台，定位于消费类直播，用户可边看边买，涵盖的范畴包括母婴、美妆等。\r\n\r\n赵圆圆表示，自2016年3月份试运营以来，观看直播内容的移动用户超过千万，机构主播数量超5000人，截至2018年，平台每天直播场次超过5万场，其中超过一半的观众为90后。', '2018-12-31', 0);
INSERT INTO `notice` VALUES (4, 15, '摩拜单车将更名为美团单车 美团APP将成其唯一入口', '1月23日，美团联合创始人、高级副总裁王慧文发布内部信，宣布摩拜已全面接入美团APP，摩拜单车将成为美团LBS平台单车事业部，由他本人兼任事业部总经理。王慧文在内部信中表示，目前美团APP和摩拜APP均支持扫码骑车，未来摩拜单车品牌将更名为美团单车，美团APP将成为其国内唯一入口。', '2018-11-07', 0);
INSERT INTO `notice` VALUES (5, 4, '锤子科技员工爆料：锤子并无情怀可言', '今天下午三点多钟，微博上出现了「锤子科技被字节跳动接盘」的讯息。在这条新闻出现之后，有一位锤子科技的员工找到我们，和我们说了一些你们可能不知道，也想不到的信息。为了保护这位员工，我们不会暴露这个员工的身份信息，不过我们已经证实了他的身份。事实上这次并不像是媒体口中的收购，确切地说是一场巨大的裁员。几乎所有员工都必须签署「自愿离职协议」，放弃自己的司龄、年假、期权等福利待遇之后才能得到入职字节跳动的机会。', '2019-01-04', 0);
INSERT INTO `notice` VALUES (6, 3, '我的区长父亲', '他是一个伟大的父亲，至今我无法忘记他的身影，他在我最需要帮助的时候，出现，然后默默离开。', '2019-03-22', 0);
INSERT INTO `notice` VALUES (7, 1, '还是我的父亲', '测试一下，是否本人插入的这条数据', '2019-03-22', 0);
INSERT INTO `notice` VALUES (8, 3, '测试', '测试', '2019-03-24', 0);
INSERT INTO `notice` VALUES (9, 3, '测试', '测试', '2019-03-24', 0);
INSERT INTO `notice` VALUES (10, 1, '测试', '测试', '2019-03-24', 0);
INSERT INTO `notice` VALUES (11, 21, '你说呢', '我要气炸了', '2019-03-24', 0);

-- ----------------------------
-- Table structure for overtime
-- ----------------------------
DROP TABLE IF EXISTS `overtime`;
CREATE TABLE `overtime`  (
  `id` int(3) NOT NULL COMMENT '员工id',
  `overtimeID` int(3) NOT NULL AUTO_INCREMENT COMMENT '加班表id',
  `department_id` int(3) NULL DEFAULT NULL COMMENT '部门id',
  `overtime_reason` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作内容',
  `startTime` datetime(0) NULL DEFAULT NULL COMMENT '加班开始时间',
  `endTime` datetime(0) NULL DEFAULT NULL COMMENT '加班结束时间',
  `approve` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审批人',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '审批状态（1通过，0驳回）',
  PRIMARY KEY (`overtimeID`) USING BTREE,
  INDEX `departmentId`(`department_id`) USING BTREE,
  INDEX `employeeId`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of overtime
-- ----------------------------
INSERT INTO `overtime` VALUES (9, 2, 2, '把客户的订单转交给企业的生产部门。', '2018-12-25 00:00:00', '2018-12-25 00:00:00', '陈明明', 0);
INSERT INTO `overtime` VALUES (9, 3, 2, '寻找产品的潜在客户，并把他们转变为企业的实际客户', '2018-12-25 00:00:00', '2018-12-25 00:00:00', '陈明明', 1);
INSERT INTO `overtime` VALUES (9, 4, 2, '把客户已购买的产品发送给客户', '2017-12-25 00:00:00', '2019-12-25 00:00:00', '', 1);
INSERT INTO `overtime` VALUES (9, 5, 2, '负责产品的市场渠道开拓与销售工作，执行并完成公司产品年度销售计划', '0000-00-00 00:00:00', '2015-09-09 00:00:00', '', 1);
INSERT INTO `overtime` VALUES (9, 6, 2, '根据公司市场营销战略，提升销售价值，控制成本，扩大产品在所负责区域的销售，积极完成销售量指标，扩大产品市场占有率。', '2015-02-02 00:00:00', '2015-09-09 00:00:00', '', 1);
INSERT INTO `overtime` VALUES (9, 7, 2, '根据公司产品、价格及市场策略，独立处置询盘、报价、合同条款的协商及合同签订事宜。', '2018-12-25 00:00:00', '2018-12-25 00:00:00', '', 1);
INSERT INTO `overtime` VALUES (9, 8, 2, '根据公司产品、价格及市场策略，独立处置询盘、报价、合同条款的协商及合同签订事宜。', '2018-12-25 05:03:00', '2018-12-25 18:07:00', '', 0);
INSERT INTO `overtime` VALUES (9, 9, 2, '与客户签订销售合同，督促合同正常如期履行，并催讨所欠应收销售款项。', '2018-12-25 05:03:00', '2018-12-25 05:03:00', '', 0);
INSERT INTO `overtime` VALUES (9, 10, 2, '完成销售经理临时交办的其他任务。', '2018-12-25 03:00:00', '2018-12-25 23:04:00', '', 0);
INSERT INTO `overtime` VALUES (3, 11, 4, '确定公司产品和服务的需求、竞争者和潜在客户，制定价格策略，确保公司利润最大化和客户满意度最大化。', '2019-03-25 06:30:00', '2018-12-25 22:00:00', '', 1);
INSERT INTO `overtime` VALUES (1, 12, 1, '制定具体的工作方案和计划，以保证企业目标的顺利实现', '2019-03-25 06:06:00', '2018-12-25 21:26:00', NULL, NULL);
INSERT INTO `overtime` VALUES (1, 13, 3, '需求分析、预算制定、招聘方案的制定', '2019-03-24 12:00:00', '2019-03-25 22:00:00', NULL, NULL);
INSERT INTO `overtime` VALUES (17, 14, 2, '', '2019-03-26 16:00:00', '2019-03-27 21:00:00', NULL, NULL);

-- ----------------------------
-- Table structure for rewards
-- ----------------------------
DROP TABLE IF EXISTS `rewards`;
CREATE TABLE `rewards`  (
  `id` int(11) NOT NULL COMMENT '奖惩表ID',
  `employee_id` int(11) NULL DEFAULT NULL COMMENT '员工ID',
  `rewards_date` date NOT NULL COMMENT '奖惩日期',
  `rewards_reason` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖惩原因',
  `remark` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_rewards_employee`(`employee_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务表ID',
  `employee_id` int(3) NOT NULL COMMENT '员工id',
  `work_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工作内容',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '当前状态（0已完成 1未完成）',
  `start_time` date NOT NULL COMMENT '开始时间',
  `end_time` date NOT NULL COMMENT '截止时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_key_employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 1, '发布招聘信息、筛选应聘人员资料', 1, '2018-12-05', '2019-02-14');
INSERT INTO `task` VALUES (2, 2, '根据企业的经营目标制定市场调研目标以及方案,组织人员进行市场调研工作,根据企业的经营目标制定市场调研', 0, '2019-02-04', '2019-02-12');
INSERT INTO `task` VALUES (3, 3, '将产品宣传或销售到各个销售渠道,组织人员进行市场调研工作,根据企业的经营目标制定市场调研组织人员进行', 1, '2019-02-06', '2019-02-12');
INSERT INTO `task` VALUES (4, 1, '设置网校机构权限分配', 1, '1996-01-26', '1997-02-13');
INSERT INTO `task` VALUES (5, 13, '无心', 0, '1996-01-26', '1997-02-13');
INSERT INTO `task` VALUES (6, 10, 'http://localhost:8080/ssmstart_war/', 1, '1996-01-26', '1997-02-13');
INSERT INTO `task` VALUES (7, 11, '优点还体现在泛型 假如 set中存放的是Object', 1, '2019-03-27', '2019-04-01');
INSERT INTO `task` VALUES (8, 8, '暂时你先在打杂部实习吧', 1, '2019-03-20', '2019-03-20');
INSERT INTO `task` VALUES (9, 8, '12来让 管理科毛巾覆盖', 1, '2019-03-24', '2019-03-26');
INSERT INTO `task` VALUES (10, 6, '测试测试', 1, '2019-03-24', '2019-03-27');
INSERT INTO `task` VALUES (11, 4, '测试', 1, '2019-03-24', '2019-12-24');
INSERT INTO `task` VALUES (12, 37, '测试', 1, '2019-03-24', '2019-03-25');
INSERT INTO `task` VALUES (13, 38, '测试', 1, '2019-03-26', '2019-03-28');
INSERT INTO `task` VALUES (14, 38, '测试', 1, '2019-03-26', '2019-03-28');
INSERT INTO `task` VALUES (15, 16, '你说呢', 1, '2019-03-24', '2019-03-27');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(3) NULL DEFAULT NULL COMMENT '用户id',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录电话号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `flag` int(1) NOT NULL DEFAULT 0 COMMENT '用户权限表标识0（普通员工）1（经理）2（超级管理员）',
  `picture` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户图片路径',
  INDEX `f_employee-id`(`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, '15017814621', '708408469bd3b641070e6d9a7c24bbc3', 2, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (1, '10086', '707d641b3cf8445dfa8117556bc73cb2', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (2, '5635832', '6b2ff1cd2a58aa8ba351bebf72a74a40', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (7, '2129891', 'df818c724f121d57868cd09f9c3cfbb4', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (11, '5203146', 'd43d32719e0839533a58b4e8f96deb77', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (12, '225412', '77e794304834a8d7bfcbbb0f1340ae76', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (3, '4511462', '0c5d9ecd729ab2c160a027514fd9ed2e', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (4, '46212989', 'e10adc3949ba59abbe56e057f20f883e', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (6, '84978811', 'e3be00dc5cc26786ece51b040c1c87fb', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (8, '564300', '9705978fb7887ae471c17b4fba3c6e72', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (10, '87824', '07ea0d7bd7a9e17aa492885735903b4d', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (13, '81216810', '1c18b465cefc71973429a0546553d8ce', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (15, '74524221', '94869164eaf0ed762982443bddf34b4c', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (16, '503720', '3832ad537fda424b62fe957f92a49313', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (17, '654312', '5d264f1d67ff24de2db1f830e93f6cb1', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (18, '985641', 'da7bd0eaf9dac80eafe771fdfb9c2179', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (19, '59711032', '74eef8a4ba3e085f7015fce368b63973', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (20, '1651431', 'c1517daabdee1d9edd392e34cad7b651', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (21, '452131', '5d66d79983d9ead0079345ddd7f1456e', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (22, '789461', '4b8894150eaf98a81fa88bcb41309b25', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (23, '5641359', '51b5b7b7819bce773fb20e9cc6191ba2', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (24, '4983416', 'd877daa4977f425d153859abb933f724', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (25, '5678941', '3770a1706f6b005c006ecf096a493e9b', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (26, '369845', '25e332f489d548bb549b568b2e2607c8', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (27, '15798145', '12be9f086ca2f833c6c8a0ef83986a0d', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (28, '231597', '58760131bcd74d0871d89fe463dd1f1d', 0, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (35, '546123', '155a8583e1fea64acb9e9dc484b6a16a', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (36, '13462652322', '34d61934c859ceb2bc6e075e34c4275d', 1, 'https://weixiong.info/image/work.jpg');
INSERT INTO `user` VALUES (37, '2129891256', 'ea8c1386608324e1df16d28aa300495f', 0, 'https://weixiong.info/image/f21a267c-b928-443b-ae08-38c12b2be901.jpg');
INSERT INTO `user` VALUES (38, '135641421', 'cac3999ea3019d32e85f1d2451b11e71', 0, 'https://weixiong.info/image/f21a267c-b928-443b-ae08-38c12b2be901.jpg');
INSERT INTO `user` VALUES (5, '84961133', '4197127d517a3cb15a97d852fc6ddf1e', 0, 'https://weixiong.info/image/f21a267c-b928-443b-ae08-38c12b2be901.jpg');

-- ----------------------------
-- Table structure for wage
-- ----------------------------
DROP TABLE IF EXISTS `wage`;
CREATE TABLE `wage`  (
  `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '薪资表id',
  `employee_id` int(11) NOT NULL COMMENT '员工id',
  `basic_salary` float(10, 2) NOT NULL COMMENT '底薪',
  `bonus` float(10, 2) NULL DEFAULT NULL COMMENT '奖金',
  `fine` float(10, 2) NULL DEFAULT NULL COMMENT '罚款',
  `overtime_pay` float(10, 2) NULL DEFAULT NULL COMMENT '加班费',
  `net_payroll` float NULL DEFAULT NULL COMMENT '实发工资',
  `start_time` date NOT NULL COMMENT '工资计算起止时间',
  `end_time` date NOT NULL COMMENT '工资计算截止时间',
  `pay_date` date NOT NULL COMMENT '发薪水日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `foreign_employeeId`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of wage
-- ----------------------------
INSERT INTO `wage` VALUES (1, 1, 3000.00, 2000.00, 0.00, 3000.00, 8000, '2019-01-22', '2019-02-22', '2019-02-23');
INSERT INTO `wage` VALUES (2, 1, 3000.00, 4000.00, 100.00, 2600.00, 9500, '2018-12-22', '2019-01-22', '2019-01-23');
INSERT INTO `wage` VALUES (3, 2, 3000.00, 2700.00, 300.00, 3600.00, 9000, '2019-01-22', '2019-02-22', '2019-01-23');

SET FOREIGN_KEY_CHECKS = 1;
