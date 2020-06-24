/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 24/06/2020 18:06:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `content` longtext CHARACTER SET utf8 COLLATE utf8_bin NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `category_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `commentable` bit(1) NOT NULL,
  `published` bit(1) NOT NULL,
  `recommended` bit(1) NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tag_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (35, b'1', '#### あ行单词\r\n\r\n愛（あい）：爱\r\n\r\n青（あお）：蓝色\r\n\r\n上（うえ）：上面\r\n\r\n家（いえ）：家\r\n\r\n（いいえ）：不，不是\r\n\r\n多い（おおい）：多的\r\n\r\n#### か行单词\r\n\r\n顔（かお）：脸\r\n\r\n赤（あか）：红色\r\n\r\n秋（あき）：秋天\r\n\r\n記憶（きおく）：记忆\r\n\r\n声（こえ）：声音\r\n\r\n空港（くうこう）机场\r\n\r\n#### さ行单词\r\n\r\n朝（あさ）：早晨\r\n\r\n足（あし）：脚\r\n\r\n寿司（すし）：寿司\r\n\r\n好き（すき）：喜欢\r\n\r\n世界（せかい）：世界\r\n\r\n嘘（いそ）：谎言\r\n\r\n西瓜（すいか）：西瓜\r\n\r\n#### た行单词\r\n\r\n支度（したく）：准备\r\n\r\n一（いち）：一\r\n\r\n口（くち）：嘴\r\n\r\n手（て）：手\r\n\r\n机（つくえ）：桌子\r\n\r\n男（おとこ）：男人\r\n\r\n#### な行单词\r\n\r\n夏（なつ）：夏天\r\n\r\n七（なな）：なな\r\n\r\n何（なに）：什么\r\n\r\n肉（にく）：肉\r\n\r\n犬（いぬ）：狗\r\n\r\nお金（おかね）：钱\r\n\r\n猫（ねこ）：猫\r\n\r\n#### は行单词\r\n\r\n歯（は）：牙齿\r\n\r\n母（はは）：母亲\r\n\r\n八（はち）：八\r\n\r\n鼻（はな）：鼻子\r\n\r\n額（ひたい）：额头\r\n\r\n財布（さいふ）：钱包\r\n\r\n細い（ほそい）：瘦的，细的\r\n\r\n#### ま行单词\r\n\r\n名前（なあえ）：名字\r\n\r\n頭（あたま）：头\r\n\r\n耳（みみ）：耳朵\r\n\r\n昔（むかし）：从前\r\n\r\n目（め）：眼睛\r\n\r\n桃（もも）：桃\r\n\r\nもしもし：喂喂\r\n\r\n#### や行单词\r\n\r\n早く（はやく）：快点\r\n\r\n嫌（いや）：讨厌\r\n\r\n休み（やすみ）：休息\r\n\r\n冬（ふゆ）：冬天\r\n\r\n雪（ゆき）：雪\r\n\r\n夢（ゆめ）：梦，梦想\r\n\r\n強い（つよい）：强壮的\r\n\r\n#### ら行单词\r\n\r\n桜（さくら）樱花\r\n\r\n春（はる）：春\r\n\r\n夜（よる）：晚上\r\n\r\n歴史（れきし）：历史\r\n\r\n顔色（かおいろ）：脸色\r\n\r\n黒（くろ）：黑色\r\n\r\n\r\n\r\n#### ざ行单词\r\n\r\n地図（ちず①）：地图\r\n\r\n風邪薬（かぜぐすぃ③）：感冒药\r\n\r\n四時（よじ①）：四点\r\n\r\n一時（いちじ）：一点\r\n\r\n青（あお）空（そら）（あおぞら③）：蓝天\r\n\r\nゼロ①：零\r\n\r\n\r\n\r\n## 沪江第一课1\r\n\r\n### 1.代词\r\n\r\n私（わたし）：我\r\n\r\nあなた：你\r\n\r\nあの人（あのひと）：那个人\r\n\r\n~ さん：不分男女，敬称\r\n\r\n~ ちゃん：小孩子，女生\r\n\r\n~ 君（くん）\r\n\r\n先生（せんせい）：老师，律师，医生\r\n\r\n学生（がくせい）：（大）学生\r\n\r\n大学（だいがく）：大学\r\n\r\n会社員（かいしゃいｎ）：公司员工\r\n\r\n会社（かいしゃ）：公司\r\n\r\n社員（しゃいん）：员工\r\n\r\n企業（きぎょう）：企业\r\n\r\n企画（きかく）策划\r\n\r\n### 2.国家\r\n\r\n中国（ちゅうごく）：中国\r\n\r\n中国人（ちゅうごくじｎ）：④中国人\r\n\r\n日本（にほん）：日本\r\n\r\n日本人（にほんじｎ）：④日本人\r\n\r\n韓国（かんこく）：韩国\r\n\r\n韓国人（かんこくじｎ）：④韩国人\r\n\r\n### 3.日常用语\r\n\r\nそうです①：是（这样）\r\n\r\n違います（ちがいます）④：不是\r\n\r\n分かりません（わかりません）⑤：不知道\r\n\r\n### 4.句子\r\n\r\n1.肯定句\r\n\r\n**[名1]は[名2]です**：名1是名2\r\n\r\n~は：助词，提示主题（读作wa）\r\n\r\n~です：助动词，表示断定\r\n\r\n2.否定句\r\n\r\n**[名1]は[名2]では　ありません**：名1不是名2\r\n\r\nでは：再口语中有时会说じゃ\r\n\r\nわたしは日本人では　ありません。（我不是日本人）\r\n\r\n3.疑问句\r\n\r\n**[名1]は[名2]ですか**：名1是名2吗\r\n\r\n~ か：疑问助词。\r\n\r\n简单回答：\r\n\r\n肯定：はい、そうです\r\n\r\n否定：いいえ、違います\r\n\r\n不知道：分かりません\r\n\r\n4.从属关系\r\n\r\n**[名1]の[名2]**\r\n\r\n私の父：我的父亲\r\n\r\n## 第一课2 \r\n\r\n#### 1.寒暄\r\n\r\n出迎え（でむかえ）：出去迎接、迎接\r\n\r\nこんいくちは⑤：你好（下午见面时）\r\n\r\nおはよえ（ございます）：早上好\r\n\r\nこんばんは⑤：晚上好\r\n\r\nどうもすみません：实在对不起\r\n\r\nどうも①：[副]非常，很\r\n\r\nすみません④：对不起，请问\r\n\r\n初めまして（はじめまして）：初次见面\r\n\r\nどうぞよろしくお願いいたします：请多关照\r\n\r\nこちらこそ④：我才要（请您---）\r\n\r\n——こちらこそ，どうぞよろしくお願いいたします\r\n\r\n——こちらこそ。すみません\r\n\r\n## 第二课\r\n\r\n### 第一部分：指示词（这个/那个）\r\n\r\n#### 1.单词\r\n\r\n本（ほん）①：[名] 书\r\n\r\n鞄（かばん）：[名] 包，公文包\r\n\r\n傘（かさ）①：[名]  伞\r\n\r\n鍵（かぎ）：[名]  钥匙，关键\r\n\r\n車（くるま）：[名]  汽车\r\n\r\n自転車（じてんしゃ）：[名]  自行车\r\n\r\n机（つくえ）：[名] 书桌\r\n\r\nテーブル：餐桌\r\n\r\nカメラ①：照相机\r\n\r\nテレビ①：电视机\r\n\r\nパソコン：[名] 个人电脑 パーソナルコンピューター缩写\r\n\r\nノート：[名] 笔记本\r\n\r\n何（なん）①：[名] 什么（询问事物）\r\n\r\n\r\n\r\n#### 2.基本课文\r\n\r\n**<font color=\'red\'>事物指示词</font>**：あれ（远那个）／それ（近那个）／これ（这个）\r\n\r\nだれ①：[疑]  谁（询问人）可写作 誰\r\n\r\n**例句**：あの人は　だれですか。那个人是谁\r\n\r\n—— あの人は　スミスさんです。\r\n\r\nどなた①：[疑]  哪位（敬称）\r\n\r\n方（かた）：[名] 位，人（ひと）的礼貌说法\r\n\r\n**例句**：スミスさんは　どなたですか。（史密斯先生是哪位）\r\n\r\n—— あの　方です。（是那位）\r\n\r\n**例句**：あれは　だれの　傘ですか。　（那是谁的伞）\r\n\r\n**指示连体词**：あの（远那个）／その（近那个）／この（这个）后必接名词\r\n\r\n**例句**：この　カメラは　スミスさんのです。（这是史密斯的伞）\r\n\r\n**<font color=\'red\'>事物指示词</font>**：どれ／どの名：哪一个，用于三个以上。どれ单独使用。\r\n\r\n### 第二部分：指示词（这个/那个）\r\n\r\n#### 1.单词\r\n\r\nいす：[名] 椅子\r\n\r\n新聞（しんぶん）：[名] 报纸\r\n\r\nニュース：[名] （news）新闻\r\n\r\n鉛筆（えんぴつ）：[名] 铅笔\r\n\r\n雑誌（ざっし）：[名] 杂志\r\n\r\n辞書（じしょ）：①[名] 词典\r\n\r\n電話（でんわ）：[名] 电话\r\n\r\n靴（くつ）：②[名] 鞋\r\n\r\n時計（とけい）：[名] 钟，表\r\n\r\nラジオ：[名] 收音机\r\n\r\n## 第四课\r\n\r\n#### 1.存在句\r\n\r\n（1）名[场所] **に**　名[物 / 人]**が**　あります／います　　— **某处**有某物 / 某人\r\n\r\n- **に**表示存在的场所，**が**表示存在地主体\r\n\r\n- **あります**： 用于无意识个体（桌子，书等）\r\n\r\n- **います**： 用于有意识个体（人，动物等）\r\n\r\n（2）名[场所] **に**　[何／誰]**が**　あります／いますか。 — 某处那是什么 / 谁\r\n\r\n- あそこに　誰が　いますか。　— 谁在那\r\n- 部屋に　何が　ありますか。　— 屋子里那是什么\r\n  - Tips：何在**です**或量词前读作**なん**，在**が**前读作**なに**\r\n\r\n（3）名[物 / 人]**は **   名[场所] **に**　あります／います　　— **某物 / 人**在某处\r\n\r\n- **に**表示存在的场所，**は**表示存在地主体，与（1）不同强调的是人或物\r\n\r\n（4）名[物 / 人]**は **   どこ **に**　あります／います　　— **某物 / 人**在哪\r\n\r\n- 図書館は　どこに　ありますか。　　— 图书馆在哪\r\n\r\n  図書館は　1階に　あります。           — 图书馆在一楼\r\n\r\n注：小野さんは　どこ　ですか　　＝　小野さんは　どこに　いますか。\r\n\r\n　　小野さんの　家は　どこ　ですか　＝　小野さんの　家は　どこに　ありますか。\r\n\r\n####　2.并列\r\n\r\n[名A] **と** [名B]　表示A和B\r\n\r\n#### 3.表具体位置\r\n\r\n[名词]  の　上（うえ）／下（した）／前（まえ）／後ろ（うしろ）／\r\n隣（となり）／中（なか）／外（そと）\r\n\r\n- 机の　上に　猫が　います。\r\n- 会社の　となりに　花屋が　あります。\r\n\r\n注：在句尾为加上**ね**（终助词）表示寻求确认\r\n\r\n- 甲：あそこに　犬が　いますね。 — 那有条狗是吧。\r\n- 乙：ええ、わたしの　犬です。\r\n\r\n注：疑问词+も+否定动词，表示全面否定\r\n\r\n- \r\n- ', '2020-05-18 22:33:57.732000', '/images/1005-800x450.jpg', '原创', b'1', '20200518_2232', '2020-05-18 22:33:57.732000', 0, 22, 1, b'1', b'1', b'0', '各位班长，2019-2020学年一年级优秀学生评选工作已开启，请各班做好评优相关准备。评优通知如上所示，请各班长将评优通知发送至每位同学，务必保证同学们都知晓评优事宜。学院定于5月20日19:00召开线上班长会议，部署相关评优工作，具体会议安排如下，请各班长务必按时参会。各班收到予以回复。', '1,4,6');
INSERT INTO `t_blog` VALUES (36, b'1', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:50:30.548000', '/images/1005-800x450.jpg', '原创', b'0', '20200518_2249', '2020-05-18 22:50:30.548000', 2, 27, 1, b'1', b'1', b'1', '两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2,6,1');
INSERT INTO `t_blog` VALUES (37, b'0', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:51:56.594000', '/images/1005-800x450.jpg', '原创', b'1', '20200518_2251', '2020-05-18 22:51:56.594000', 10, 26, 1, b'1', b'1', b'1', '理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。', '1,6,7');
INSERT INTO `t_blog` VALUES (38, b'1', '理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。', '2020-05-18 22:53:02.210000', '/images/1005-800x450.jpg', '原创', b'1', '理想化的软件开发流程', '2020-05-18 22:53:02.210000', 8, 26, 1, b'1', b'1', b'1', '理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。', '2,4');
INSERT INTO `t_blog` VALUES (39, b'1', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:53:48.833000', '/images/1005-800x450.jpg', '原创', b'1', '理想asdad', '2020-05-18 22:53:48.833000', 0, 23, 1, b'0', b'1', b'0', '两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2,4,7,9');
INSERT INTO `t_blog` VALUES (40, b'1', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:54:20.233000', '/images/1005-800x450.jpg', '原创', b'1', '20202020', '2020-05-18 22:54:20.233000', 0, 25, 2, b'1', b'1', b'1', '两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '5');
INSERT INTO `t_blog` VALUES (41, b'1', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:54:45.595000', '/images/1005-800x450.jpg', '原创', b'1', '20202254', '2020-05-18 22:54:45.595000', 5, 24, 1, b'0', b'1', b'1', '这是我的个人博客，会分享关于编程和生活方面的内容，同时也会记录自己学习的过程，希望可以给来到这的人和自己一点帮助.', '3,9');
INSERT INTO `t_blog` VALUES (42, b'1', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:55:05.074000', '/images/1005-800x450.jpg', '原创', b'0', '20202255', '2020-05-18 22:55:05.074000', 0, 25, 2, b'0', b'1', b'0', '这是我的个人博客，会分享关于编程和生活方面的内容，同时也会记录自己学习的过程，希望可以给来到这的人和自己一点帮助..', '5');
INSERT INTO `t_blog` VALUES (43, b'0', '# 一、概述\r\n\r\n## 1.形式化方法\r\n\r\n形式化方法是保证软件正确性的重要手段。\r\n\r\n**软件开发流程**：需求分析-概要设计-详细设计-软件编码-软件测试-软件交付\r\n\r\n软件行为符合需求。\r\n\r\n传统的正确性保障手段：过程评审、软件评审、设计方法（例UML）、编程方法、代码复查、软件测试。\r\n\r\n理想化的软件开发流程：将开发流程中的各个阶段用形式语言进行描述，而形式语言都是有语义的，避免了在用自然语言进行藐视概要设计等所产生的理解歧义问题。\r\n\r\n### 形式化方法的例子\r\n\r\n#### 顺序程序\r\n\r\n不厚干扰一步一步做计算，假定在四则运算的基础上计算阶乘\r\n\r\n**正确性**：形式的流程设计语言，形式的性质描述语言、建立在形式语义上的推到规则。\r\n\r\n完全正确性=部分正确性+终止正确性。\r\n\r\n**安全性**：程序在任何时候都应该满足的性质。\r\n\r\n#### 反应式系统\r\n\r\n与外界交互、处理外界的输入。\r\n\r\n从设计的角度来看，我们关心的是输入动作和对输入的处理的抽象流程，具体内容的处理方式可使用顺序程序来进行。\r\n\r\n正确性证明：形式的设计语言、形式的性质描述语言、、建立在形式语义和图算法上的推理方法。\r\n\r\n例如自动贩卖机的例子，设计的细化可以用模拟关系来说明，可以证明这些设计之间存在模拟关系。\r\n\r\n#### 并发程序\r\n\r\n两个进程组成，这两个进程可使用共享变量和公共资源。在这个系统中我们需要一个成为互斥算法的机制控制资源的使用。可以根据并发系统的特性，该系统永远满足一定的性质。', '2020-05-18 22:55:26.079000', '/images/1005-800x450.jpg', '原创', b'0', '20202256', '2020-05-18 22:55:26.079000', 6, 25, 2, b'0', b'1', b'0', 'blog', '5');
INSERT INTO `t_blog` VALUES (44, b'0', '#### あ行单词\r\n\r\n愛（あい）：爱\r\n\r\n青（あお）：蓝色\r\n\r\n上（うえ）：上面\r\n\r\n家（いえ）：家\r\n\r\n（いいえ）：不，不是\r\n\r\n多い（おおい）：多的\r\n\r\n#### か行单词\r\n\r\n顔（かお）：脸\r\n\r\n赤（あか）：红色\r\n\r\n秋（あき）：秋天\r\n\r\n記憶（きおく）：记忆\r\n\r\n声（こえ）：声音\r\n\r\n空港（くうこう）机场\r\n\r\n#### さ行单词\r\n\r\n朝（あさ）：早晨\r\n\r\n足（あし）：脚\r\n\r\n寿司（すし）：寿司\r\n\r\n好き（すき）：喜欢\r\n\r\n世界（せかい）：世界\r\n\r\n嘘（いそ）：谎言\r\n\r\n西瓜（すいか）：西瓜\r\n\r\n#### た行单词\r\n\r\n支度（したく）：准备\r\n\r\n一（いち）：一\r\n\r\n口（くち）：嘴\r\n\r\n手（て）：手\r\n\r\n机（つくえ）：桌子\r\n\r\n男（おとこ）：男人\r\n\r\n#### な行单词\r\n\r\n夏（なつ）：夏天\r\n\r\n七（なな）：なな\r\n\r\n何（なに）：什么\r\n\r\n肉（にく）：肉\r\n\r\n犬（いぬ）：狗\r\n\r\nお金（おかね）：钱\r\n\r\n猫（ねこ）：猫\r\n\r\n#### は行单词\r\n\r\n歯（は）：牙齿\r\n\r\n母（はは）：母亲\r\n\r\n八（はち）：八\r\n\r\n鼻（はな）：鼻子\r\n\r\n額（ひたい）：额头\r\n\r\n財布（さいふ）：钱包\r\n\r\n細い（ほそい）：瘦的，细的\r\n\r\n#### ま行单词\r\n\r\n名前（なあえ）：名字\r\n\r\n頭（あたま）：头\r\n\r\n耳（みみ）：耳朵\r\n\r\n昔（むかし）：从前\r\n\r\n目（め）：眼睛\r\n\r\n桃（もも）：桃\r\n\r\nもしもし：喂喂\r\n\r\n#### や行单词\r\n\r\n早く（はやく）：快点\r\n\r\n嫌（いや）：讨厌\r\n\r\n休み（やすみ）：休息\r\n\r\n冬（ふゆ）：冬天\r\n\r\n雪（ゆき）：雪\r\n\r\n夢（ゆめ）：梦，梦想\r\n\r\n強い（つよい）：强壮的\r\n\r\n#### ら行单词\r\n\r\n桜（さくら）樱花\r\n\r\n春（はる）：春\r\n\r\n夜（よる）：晚上\r\n\r\n歴史（れきし）：历史\r\n\r\n顔色（かおいろ）：脸色\r\n\r\n黒（くろ）：黑色\r\n\r\n\r\n\r\n#### ざ行单词\r\n\r\n地図（ちず①）：地图\r\n\r\n風邪薬（かぜぐすぃ③）：感冒药\r\n\r\n四時（よじ①）：四点\r\n\r\n一時（いちじ）：一点\r\n\r\n青（あお）空（そら）（あおぞら③）：蓝天\r\n\r\nゼロ①：零\r\n\r\n\r\n\r\n## 沪江第一课1\r\n\r\n### 1.代词\r\n\r\n私（わたし）：我\r\n\r\nあなた：你\r\n\r\nあの人（あのひと）：那个人\r\n\r\n~ さん：不分男女，敬称\r\n\r\n~ ちゃん：小孩子，女生\r\n\r\n~ 君（くん）\r\n\r\n先生（せんせい）：老师，律师，医生\r\n\r\n学生（がくせい）：（大）学生\r\n\r\n大学（だいがく）：大学\r\n\r\n会社員（かいしゃいｎ）：公司员工\r\n\r\n会社（かいしゃ）：公司\r\n\r\n社員（しゃいん）：员工\r\n\r\n企業（きぎょう）：企业\r\n\r\n企画（きかく）策划\r\n\r\n### 2.国家\r\n\r\n中国（ちゅうごく）：中国\r\n\r\n中国人（ちゅうごくじｎ）：④中国人\r\n\r\n日本（にほん）：日本\r\n\r\n日本人（にほんじｎ）：④日本人\r\n\r\n韓国（かんこく）：韩国\r\n\r\n韓国人（かんこくじｎ）：④韩国人\r\n\r\n### 3.日常用语\r\n\r\nそうです①：是（这样）\r\n\r\n違います（ちがいます）④：不是\r\n\r\n分かりません（わかりません）⑤：不知道\r\n\r\n### 4.句子\r\n\r\n1.肯定句\r\n\r\n**[名1]は[名2]です**：名1是名2\r\n\r\n~は：助词，提示主题（读作wa）\r\n\r\n~です：助动词，表示断定\r\n\r\n2.否定句\r\n\r\n**[名1]は[名2]では　ありません**：名1不是名2\r\n\r\nでは：再口语中有时会说じゃ\r\n\r\nわたしは日本人では　ありません。（我不是日本人）\r\n\r\n3.疑问句\r\n\r\n**[名1]は[名2]ですか**：名1是名2吗\r\n\r\n~ か：疑问助词。\r\n\r\n简单回答：\r\n\r\n肯定：はい、そうです\r\n\r\n否定：いいえ、違います\r\n\r\n不知道：分かりません\r\n\r\n4.从属关系\r\n\r\n**[名1]の[名2]**\r\n\r\n私の父：我的父亲\r\n\r\n## 第一课2 \r\n\r\n#### 1.寒暄\r\n\r\n出迎え（でむかえ）：出去迎接、迎接\r\n\r\nこんいくちは⑤：你好（下午见面时）\r\n\r\nおはよえ（ございます）：早上好\r\n\r\nこんばんは⑤：晚上好\r\n\r\nどうもすみません：实在对不起\r\n\r\nどうも①：[副]非常，很\r\n\r\nすみません④：对不起，请问\r\n\r\n初めまして（はじめまして）：初次见面\r\n\r\nどうぞよろしくお願いいたします：请多关照\r\n\r\nこちらこそ④：我才要（请您---）\r\n\r\n——こちらこそ，どうぞよろしくお願いいたします\r\n\r\n——こちらこそ。すみません\r\n\r\n## 第二课\r\n\r\n### 第一部分：指示词（这个/那个）\r\n\r\n#### 1.单词\r\n\r\n本（ほん）①：[名] 书\r\n\r\n鞄（かばん）：[名] 包，公文包\r\n\r\n傘（かさ）①：[名]  伞\r\n\r\n鍵（かぎ）：[名]  钥匙，关键\r\n\r\n車（くるま）：[名]  汽车\r\n\r\n自転車（じてんしゃ）：[名]  自行车\r\n\r\n机（つくえ）：[名] 书桌\r\n\r\nテーブル：餐桌\r\n\r\nカメラ①：照相机\r\n\r\nテレビ①：电视机\r\n\r\nパソコン：[名] 个人电脑 パーソナルコンピューター缩写\r\n\r\nノート：[名] 笔记本\r\n\r\n何（なん）①：[名] 什么（询问事物）\r\n\r\n\r\n\r\n#### 2.基本课文\r\n\r\n**<font color=\'red\'>事物指示词</font>**：あれ（远那个）／それ（近那个）／これ（这个）\r\n\r\nだれ①：[疑]  谁（询问人）可写作 誰\r\n\r\n**例句**：あの人は　だれですか。那个人是谁\r\n\r\n—— あの人は　スミスさんです。\r\n\r\nどなた①：[疑]  哪位（敬称）\r\n\r\n方（かた）：[名] 位，人（ひと）的礼貌说法\r\n\r\n**例句**：スミスさんは　どなたですか。（史密斯先生是哪位）\r\n\r\n—— あの　方です。（是那位）\r\n\r\n**例句**：あれは　だれの　傘ですか。　（那是谁的伞）\r\n\r\n**指示连体词**：あの（远那个）／その（近那个）／この（这个）后必接名词\r\n\r\n**例句**：この　カメラは　スミスさんのです。（这是史密斯的伞）\r\n\r\n**<font color=\'red\'>事物指示词</font>**：どれ／どの名：哪一个，用于三个以上。どれ单独使用。\r\n\r\n### 第二部分：指示词（这个/那个）\r\n\r\n#### 1.单词\r\n\r\nいす：[名] 椅子\r\n\r\n新聞（しんぶん）：[名] 报纸\r\n\r\nニュース：[名] （news）新闻\r\n\r\n鉛筆（えんぴつ）：[名] 铅笔\r\n\r\n雑誌（ざっし）：[名] 杂志\r\n\r\n辞書（じしょ）：①[名] 词典\r\n\r\n電話（でんわ）：[名] 电话\r\n\r\n靴（くつ）：②[名] 鞋\r\n\r\n時計（とけい）：[名] 钟，表\r\n\r\nラジオ：[名] 收音机\r\n\r\n## 第四课\r\n\r\n#### 1.存在句\r\n\r\n（1）名[场所] **に**　名[物 / 人]**が**　あります／います　　— **某处**有某物 / 某人\r\n\r\n- **に**表示存在的场所，**が**表示存在地主体\r\n\r\n- **あります**： 用于无意识个体（桌子，书等）\r\n\r\n- **います**： 用于有意识个体（人，动物等）\r\n\r\n（2）名[场所] **に**　[何／誰]**が**　あります／いますか。 — 某处那是什么 / 谁\r\n\r\n- あそこに　誰が　いますか。　— 谁在那\r\n- 部屋に　何が　ありますか。　— 屋子里那是什么\r\n  - Tips：何在**です**或量词前读作**なん**，在**が**前读作**なに**\r\n\r\n（3）名[物 / 人]**は **   名[场所] **に**　あります／います　　— **某物 / 人**在某处\r\n\r\n- **に**表示存在的场所，**は**表示存在地主体，与（1）不同强调的是人或物\r\n\r\n（4）名[物 / 人]**は **   どこ **に**　あります／います　　— **某物 / 人**在哪\r\n\r\n- 図書館は　どこに　ありますか。　　— 图书馆在哪\r\n\r\n  図書館は　1階に　あります。           — 图书馆在一楼\r\n\r\n注：小野さんは　どこ　ですか　　＝　小野さんは　どこに　いますか。\r\n\r\n　　小野さんの　家は　どこ　ですか　＝　小野さんの　家は　どこに　ありますか。\r\n\r\n####　2.并列\r\n\r\n[名A] **と** [名B]　表示A和B\r\n\r\n#### 3.表具体位置\r\n\r\n[名词]  の　上（うえ）／下（した）／前（まえ）／後ろ（うしろ）／\r\n隣（となり）／中（なか）／外（そと）\r\n\r\n- 机の　上に　猫が　います。\r\n- 会社の　となりに　花屋が　あります。\r\n\r\n注：在句尾为加上**ね**（终助词）表示寻求确认\r\n\r\n- 甲：あそこに　犬が　いますね。 — 那有条狗是吧。\r\n- 乙：ええ、わたしの　犬です。\r\n\r\n注：疑问词+も+否定动词，表示全面否定\r\n\r\n- \r\n\r\n\r\n\r\n\r\n\r\n', '2020-06-23 22:45:10.645000', '/images/1005-800x450.jpg', '原创', b'1', '20200623', '2020-06-23 22:46:04.138000', 3, 25, 2, b'1', b'1', b'1', '注：疑问词+も+否定动词，表示全面否定', '16,15,17');

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (35, 1);
INSERT INTO `t_blog_tags` VALUES (35, 4);
INSERT INTO `t_blog_tags` VALUES (35, 6);
INSERT INTO `t_blog_tags` VALUES (36, 2);
INSERT INTO `t_blog_tags` VALUES (36, 6);
INSERT INTO `t_blog_tags` VALUES (36, 1);
INSERT INTO `t_blog_tags` VALUES (37, 1);
INSERT INTO `t_blog_tags` VALUES (37, 6);
INSERT INTO `t_blog_tags` VALUES (37, 7);
INSERT INTO `t_blog_tags` VALUES (38, 2);
INSERT INTO `t_blog_tags` VALUES (38, 4);
INSERT INTO `t_blog_tags` VALUES (39, 2);
INSERT INTO `t_blog_tags` VALUES (39, 4);
INSERT INTO `t_blog_tags` VALUES (39, 7);
INSERT INTO `t_blog_tags` VALUES (39, 9);
INSERT INTO `t_blog_tags` VALUES (40, 5);
INSERT INTO `t_blog_tags` VALUES (41, 3);
INSERT INTO `t_blog_tags` VALUES (41, 9);
INSERT INTO `t_blog_tags` VALUES (42, 5);
INSERT INTO `t_blog_tags` VALUES (43, 5);
INSERT INTO `t_blog_tags` VALUES (44, 16);
INSERT INTO `t_blog_tags` VALUES (44, 15);
INSERT INTO `t_blog_tags` VALUES (44, 17);

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES (22, 'javasensior', 1);
INSERT INTO `t_category` VALUES (23, 'c++', 1);
INSERT INTO `t_category` VALUES (24, 'css', 1);
INSERT INTO `t_category` VALUES (25, 'category_song1', 2);
INSERT INTO `t_category` VALUES (26, '设计模式', 1);
INSERT INTO `t_category` VALUES (27, '基础知识', 1);
INSERT INTO `t_category` VALUES (28, 'spring', 1);
INSERT INTO `t_category` VALUES (29, 'mybatis1ssss', 1);
INSERT INTO `t_category` VALUES (31, 'category_song2', 2);
INSERT INTO `t_category` VALUES (32, 'category_song3', 2);
INSERT INTO `t_category` VALUES (34, 'category_song4', 2);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (14, '/images/avatar.jpg', '评论3', '2020-05-19 14:03:36.806000', 'p3@qq.com', 'p3', 38, -1, b'0');
INSERT INTO `t_comment` VALUES (19, '/images/avatar.jpg', '回复3', '2020-05-19 14:42:06.051000', 'r3@qq.com', 'r3', 38, 14, b'0');
INSERT INTO `t_comment` VALUES (20, '/images/avatar.jpg', '回复31', '2020-05-19 14:51:31.482000', 'r31@qq.com', 'r31', 38, 19, b'0');
INSERT INTO `t_comment` VALUES (21, '/images/avatar.jpg', '回复3', '2020-05-19 14:55:44.133000', 'r3@qq.com', 'r3', 38, 14, b'0');
INSERT INTO `t_comment` VALUES (22, '/images/avatar.jpg', '回复r3', '2020-05-19 14:57:54.900000', 'rr3@qq.com', 'rr3', 38, 19, b'0');
INSERT INTO `t_comment` VALUES (23, '/images/avatar.jpg', '测一下', '2020-05-21 21:35:36.670000', '11231@qq.com', 'nickname', 38, -1, b'0');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (1, 'java111', 1);
INSERT INTO `t_tag` VALUES (2, 'tag1', 1);
INSERT INTO `t_tag` VALUES (3, 'tag2', 1);
INSERT INTO `t_tag` VALUES (4, 'tag3', 1);
INSERT INTO `t_tag` VALUES (6, 'tag5', 1);
INSERT INTO `t_tag` VALUES (7, 'tag6', 1);
INSERT INTO `t_tag` VALUES (8, 'tag7', 1);
INSERT INTO `t_tag` VALUES (9, 'tag8', 1);
INSERT INTO `t_tag` VALUES (10, 'tag9', 1);
INSERT INTO `t_tag` VALUES (12, 'tag10', 1);
INSERT INTO `t_tag` VALUES (13, 'tag13', 1);
INSERT INTO `t_tag` VALUES (14, 'javasensior', 1);
INSERT INTO `t_tag` VALUES (15, 'song11', 2);
INSERT INTO `t_tag` VALUES (16, 'song2', 2);
INSERT INTO `t_tag` VALUES (17, 'song3', 2);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '/images/1005-100x100.jpg', '2020-05-01 18:43:01.000000', 'kangjiawen1109@163.com', '康宁', 'e10adc3949ba59abbe56e057f20f883e', 1, '2020-05-02 18:44:29.000000', 'Seiten');
INSERT INTO `t_user` VALUES (2, '/images/1005-100x100.jpg', '2020-06-23 21:04:48.000000', 'kangjiawen1109@163.com', '宋云', 'e10adc3949ba59abbe56e057f20f883e', 1, '2020-06-23 21:05:15.000000', 'Song');

SET FOREIGN_KEY_CHECKS = 1;
