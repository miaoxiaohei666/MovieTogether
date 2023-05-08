-- ----------------------
-- users data
-- ----------------------
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (1, '洪山区', 18, '恐怖', '爱情', '喜剧', '张三', '123', '111', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (2, '洪山区', 18, '爱情', null, null, '崔师滔', '123', '112', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (3, '洪山区', 18, '恐怖', null, null, '陆徐衍', '1234', '121', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (4, '洪山区', 18, '爱情', '恐怖', '喜剧', '王宇杰', '123', '123', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (5, '洪山区', 18, '喜剧', '悬疑', '爱情', '向晚', '123', '124', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (6, '洪山区', 15, '动作', '悬疑', null, '梁滔滔', '123', '125', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (7, '洪山区', 15, '科幻', '恐怖', '爱情', '兰舒涵', '123', '126', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (8, '洪山区', 15, '恐怖', null, null, '陆晶皓', '123', '127', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (11, '武昌区', 17, '剧情', '爱情', '科幻', '李怡凡', '123', '128', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (12, '武昌区', 19, '动作', '悬疑', null, '张文风', '123', '110', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (14, null, null, null, null, null, null, null, '13778106621', null, null);

-- ----------------------
-- cinemas data
-- ----------------------
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (1, '洪山区野芷湖西路16号中影星美国际影城创意天地店', '武汉中影星美国际影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (2, '洪山区东湖高新区高新大道中建光谷之星商业街(11号线豹澥站D 出口) ', '中影光谷之星LUXE影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (3, '洪山区光谷世界城C区3楼', '武汉中影国际影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (4, '洪山区和平街武丰村K2地块金地广场购物中心3-5层', '自由人影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (5, '洪山区光谷广场光谷资本大厦四楼', '巨幕影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (6, '江汉区中山大道539号（水塔）大汉口城四楼地铁2／6号线F出口', '武汉大汉口电影院');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (7, '江汉区常青路168号中百仓储购物广场4楼', '中影米禾影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (8, '江汉区江汉路步行街129号中心百货（中百商厦）7层', '中百国际影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (9, '江汉区青年路518号江宸天街5F万象影城 ', '万象影城');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (11, '江夏区兴新街136号宜佳购物广场4楼东侧', '大地影院');
INSERT INTO movietogether.cinemas (id, address, name)
VALUES (12, '江夏区文化路37号新中百广场6楼', '悦影绘高德影城');

-- ----------------------
-- friends data
-- ----------------------
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (1, '111', '112');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (2, '111', '126');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (13, '123', '126');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (16, '111', '123');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (17, '111', '124');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (20, '124', '125');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (21, '124', '112');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (22, '124', '128');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (23, '124', '123');
INSERT INTO movietogether.friends (id, user1, user2)
VALUES (26, '125', '111');

-- ----------------------
-- movie data
-- ----------------------
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (4, 'https://p0.pipi.cn/mmdb/25bfd671339c7e8ea33139d0476cb0d92908d.jpg?imageView2/1/w/464/h/644',
        '殡葬师莫三妹（朱一龙 饰）在刑满释放不久后的一次出殡中，遇到了孤儿武小文（杨恩又 饰），小文的出现，意外地改变了莫三妹对职业和生活的态度。',
        '剧情', '人生大事', '2022-06-24 18:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (5, 'https://p0.pipi.cn/mmdb/25bfd671be15bf51baf0ee3a5d06b91bf94c3.jpg?imageView2/1/w/464/h/644',
        '电影将故事的开篇设定在了努布拉岛被摧毁四年之后。如今，恐龙在世界各 地与人类共存，并猎食。这一脆弱的平衡将重塑未来，并最终决定人类能否 在这颗与史上最可怕生物共享的星球上继续站在食物链的顶端。',
        '科幻', '侏罗纪世界3', '2022-06-10中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (6, 'https://p0.pipi.cn/mmdb/25bfd6719ab339b860af333d9ae02439e6179.jpg?imageView2/1/w/464/h/644',
        '双影帝影后集结，献给每一个努力生活的“你”和“我”。影片由中国电影家协会指导拍摄，陈道明任总监制，黄渤任监制，实力派演员强力加盟演绎人间温情故事。倔强的人为了爱人奔走在空城，讨血汗钱的农民工巧合下驰援武汉，抗疫前线的人们除了顶着高压还要学会告别，后方阵地的社区工作者照顾居民却把风险留给了自己，平时疏于交流的父子也被迫日夜相处。总有一些措手不及的事情发生，但也总有一颗治愈的种子在人们心中生根发芽，这是一部关于春天和希望的电影。',
        '剧情', '你是我的春天', '2022-07-01 17:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (7, 'https://p0.pipi.cn/mmdb/25bfd671c6951bcbaeaf33da3f0d6ec74ad54.jpg?imageView2/1/w/464/h/644',
        '连环命案、私刑执法、预告杀人、以暴制暴...一群号称“神探”的团伙掀起了一场香港有史以来最邪恶的犯罪！患有精神疾病的“癫佬神探”李俊（刘青云 饰）为查真凶独闯犯罪现场！以“神探夫妇”陈仪（蔡卓妍 饰）和方礼信（林峯 饰）为首的重案组也开启了与杀戮赛跑的缉凶之路！敌友之间，正邪边缘，死亡审判的真相究竟是什么？真正的“神探”到底是谁？',
        '动作', '神探大战', '2022-07-08 18:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (8, 'https://p0.pipi.cn/mmdb/25bfd69a030338ddd2300b1f3b191305438ba.jpg?imageView2/1/w/464/h/644', '好莱坞惊悚大片《密室逃生2》由《速度与激情》系列金牌制片人重磅打造，前作曾创下中国影史进口惊悚片票房最高纪录。续作在闯关难度和惊险刺激程度上全面升级，集结全球顶级玩家合力解锁超高难度密室，开启危机重重的极限挑战。影片将于2022年4月2日全国上映。
', '恐怖', '密室逃生2', '2022-04-02 18:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (9, 'https://p0.pipi.cn/mmdb/25bfd671be151b2ff711e5024a88733756aae.jpg?imageView2/1/w/464/h/644',
        '有多少人的青春是从一场暗恋开始的？儿时的一次偶遇，少年时期的默默竞争，大学的意外重逢，洛枳（张雪迎 饰）对盛淮南（辛云来 饰）的漫长暗恋，最终会收获何种结局？影片改编自八月长安振华系列，为电影《最好的我们》续篇。',
        '爱情', '暗恋·橘生淮南', '2022-06-02 18:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (10, 'https://p0.pipi.cn/mmdb/d2dad52f537339be12230f804bc324cfdd9a5.jpg?imageView2/1/w/464/h/644',
        '2020年1月23日，农历腊月二十九，武汉宣布封城。年度压轴情感大片《穿过寒冬拥抱你》聚焦这一特殊时刻，以温情和治愈为基调，刻画了普通市民守望相助，真挚动人的爱情群像。快递员阿勇（黄渤饰），骑手武哥（贾玲饰），钢琴老师叶子扬（朱一龙饰），中年夫妇刘亚兰（徐帆饰）和李宏宇（高亚麟饰），退休老医生谢咏琴（吴彦姝饰）和餐厅老板沛爷（许绍雄饰）。疫情下，爱给了他们勇气和力量，挺身而出成为志愿者。他们以笑做盾，以爱为矛，冲破凛冽寒冬和恐惧，勇敢拥抱。爱在武汉的烟火气下蔓延，抵御一切苦难，最终见证奇迹。',
        '爱情', '穿过寒冬拥抱你', '2022-07-01中国大陆重映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (11, 'https://p0.pipi.cn/mmdb/25bfd69a8eac7e7a3539dd3abbabc299e2f10.jpg?imageView2/1/w/464/h/644',
        '在精灵旅社125周年庆典派对上，一场意外使德古拉带领的精灵家族首次变身成人，而约翰尼则成了怪兽。为了寻找治疗方法，这对冤家翁婿前往危机重重的南美雨林开启了一场欢乐又刺激的冒险之旅，遭遇了种种令人捧腹的窘况。得知消息的梅菲斯带领精灵家族前去营救爱人和老爸，他们最终能否将一切恢复正常？',
        '喜剧', '精灵旅社4：变身大冒险', '2022-04-03 08:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (12, 'https://p0.pipi.cn/mmdb/25bfd671030923300b39dda8874e2e346e751.jpg?imageView2/1/w/464/h/644',
        '海底小纵队的任务是将小章鱼库巴送回到它远在加勒比海的家。但是一场意外的事故将他们困在了尤卡坦半岛的热带雨林中，众人必须通过一个海底的隧道到达加勒比海。一场海底洞穴的潜水大冒险就这样开始了……',
        '喜剧', '海底小纵队：洞穴大冒险', '2022-07-09中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (13, 'https://p0.pipi.cn/mmdb/d2dad592b12f2aecd85bf1e2b67ecef72192c.jpg?imageView2/1/w/464/h/644',
        '故事背景设定在2075年，讲述了太阳即将毁灭，已经不适合人类生存，而面对绝境，人类将开启“流浪地球”计划，试图带着地球一起逃离太阳系，寻找人类新家园的故事。',
        '科幻', '流浪地球', '2022-07-01中国大陆重映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (14, 'https://p0.pipi.cn/mmdb/25bfd6022c98070e13f2aa3268512a1467db6.jpg?imageView2/1/w/464/h/644',
        '90年代初香港卧底警察阿骆为调查黑帮贩毒的幕后真相，身陷黑帮争位与黑警阴谋的漩涡之中，同只手遮天的隐秘势力斗智斗勇，最终揭露惊天权利阴谋的故事。',
        '动作', '边缘行者', '2022-04-15中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (15, 'https://p0.pipi.cn/mmdb/25bfd67133933802ff57e2332cdab1a7b6ab0.jpg?imageView2/1/w/464/h/644',
        '午夜黑暗房间，镜前点蜡烛占卜，穿红衣削苹果，如皮断了，将在镜里看到不干净东西。本身对镜子有心理阴影的少女姗姗，被她的同学拉去参加一场恐怖的镜子游戏，不慎削断果皮，受镜中不明事物惊吓不省人事，数日没有苏醒，身体开始发生异样地扭曲。姐姐为唤醒弥留的妹妹，参加一个能进入沉睡者脑中意识空间的恐怖实验，在极度恐怖的意识异境中寻找迷失的妹妹……',
        '恐怖', '镜世界', '2022-06-10 16:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (16, 'https://p0.pipi.cn/mmdb/25bfd687ecdc7e2ff7af339b7138f3b0d2d70.jpg?imageView2/1/w/464/h/644',
        '机械天才蒂姆·詹金（丹尼尔·雷德克里夫 饰）搭档好兄弟史蒂芬·李（丹尼尔·韦伯 饰）秘密组建越狱行动队，上演了一场令人窒息步步惊心的精巧越狱大秀。面对冷血狱警的无理压迫，看行动队如何摆脱404天牢狱之灾，如何冲破15道自由之门，手握天才之钥密室逃生。',
        '悬疑', '天才计划', '2022-06-10中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (17, 'https://p0.pipi.cn/mmdb/25bfd671f2af2a02ff281ef44a1cc13a2b038.jpg?imageView2/1/w/464/h/644',
        '《焚情》，一部作为爱情试金石的悬疑爱情电影。原本家庭幸福的医生林远志（郑嘉颖 饰），因一夜“激情”，陷入出轨的恐慌与焦灼，他试图用谎言来掩盖真相，但“第三者”方瑜（陈静 饰）的步步紧逼和疯狂示爱，则让妻子刘靖（朱晨丽 饰）以及整个家庭陷入各种不可知的致命危险中……',
        '悬疑', '焚情', '2022-06-18中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (18, 'https://p0.pipi.cn/mmdb/25bfd671b12f2ad7c3d7c37db5a7ce2aadac9.jpg?imageView2/1/w/464/h/644',
        '胜华高中的复读班上，新来了一个转学生林湘之（赵今麦饰），她文静聪明却总是孤独一人，不跟其他的同学做朋友。但这样的她却吸引了班上的学渣徐又树（林一饰）的注意。在徐又树不断想跟林湘之做朋友的过程中，他和古灵精怪的宋晓楠（沈月饰）、和高冷学霸蒋吾（汪佳辉饰）发现了林湘之的秘密，原来她患了一种特殊的疾病，她对朋友的记忆只有七天。为了帮助这个孤独的女孩，他们四个人组成了“末日生存”小队不断为她创造惊喜和属于他们的记忆。殊不知，林湘之的疾病背后却有个更悲伤的秘密......',
        '剧情', '一周的朋友', '2022-06-18 09:00中国大陆上映');
INSERT INTO movietogether.movie (id, cover, introduction, label, name, time)
VALUES (19, 'https://p0.pipi.cn/mmdb/25bfd6877a3c692c9517893eb18848de814d8.jpg?imageView2/1/w/464/h/644',
        '影片为2019年《唐顿庄园》电影的续集，在这一部故事中，唐顿庄园将迎来一个崭新的时代，与此同时，老伯爵夫人的一段神秘过往也将被揭晓。',
        '爱情', '唐顿庄园2', '2022-05-20中国大陆上映');


-- ----------------------
-- screenings data
-- ----------------------
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (1, 1, 4, '2022-07-04 14:05');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (2, 3, 4, '2022-07-04 12:30');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (3, 7, 4, '2022-07-04 17:30');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (4, 2, 5, '2022-07-04 14:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (5, 3, 5, '2022-07-04 11:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (6, 7, 5, '2022-07-04 09:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (7, 3, 6, '2022-07-04 18:50');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (8, 7, 6, '2022-07-04 13:45');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (9, 9, 6, '2022-07-04 22:40');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (10, 10, 7, '2022-07-04 16:15');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (11, 12, 7, '2022-07-04 08:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (12, 6, 7, '2022-07-04 09:30');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (13, 4, 8, '2022-07-04 15:20');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (14, 7, 8, '2022-07-04 19:40');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (15, 9, 8, '2022-07-04 20:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (16, 12, 9, '2022-07-04 23:30');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (17, 6, 9, '2022-07-04 17:35');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (18, 9, 9, '2022-07-04 16:15');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (19, 4, 10, '2022-07-04 19:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (20, 2, 10, '2022-07-04 09:35');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (21, 7, 10, '2022-07-04 11:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (22, 8, 11, '2022-07-04 10:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (23, 2, 11, '2022-07-04 16:45');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (24, 10, 11, '2022-07-04 18:15');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (25, 12, 12, '2022-07-04 17:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (26, 11, 12, '2022-07-04 10:05');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (27, 6, 12, '2022-07-04 13:35');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (28, 1, 13, '2022-07-04 14:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (29, 4, 13, '2022-07-04 18:55');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (30, 1, 13, '2022-07-04 09:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (31, 5, 14, '2022-07-04 22:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (32, 7, 14, '2022-07-04 00:50');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (33, 9, 14, '2022-07-04 23:05');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (34, 12, 15, '2022-07-04 17:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (35, 7, 15, '2022-07-04 14:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (36, 10, 15, '2022-07-04 19:20');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (37, 12, 16, '2022-07-04 20:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (38, 7, 16, '2022-07-04 18:55');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (39, 8, 16, '2022-07-04 11:05');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (40, 12, 17, '2022-07-04 09:45');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (41, 4, 17, '2022-07-04 10:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (42, 7, 17, '2022-07-04 17:30');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (43, 1, 18, '2022-07-04 18:45');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (44, 2, 18, '2022-07-04 19:00');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (45, 5, 18, '2022-07-04 21:25');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (46, 6, 19, '2022-07-04 21:15');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (47, 9, 19, '2022-07-04 18:05');
INSERT INTO movietogether.screenings (id, cinema_id, movie_id, time)
VALUES (48, 8, 19, '2022-07-04 09:00');

-- ----------------------
-- users data
-- ----------------------
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (1, '洪山区', 18, '恐怖', '爱情', '喜剧', '张三', '123', '111', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (2, '洪山区', 18, '爱情', null, null, '崔师滔', '123', '112', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (3, '洪山区', 18, '恐怖', null, null, '陆徐衍', '1234', '121', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (4, '洪山区', 18, '爱情', '恐怖', '喜剧', '王宇杰', '123', '123', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (5, '洪山区', 18, '喜剧', '悬疑', '爱情', '向晚', '123', '124', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (6, '洪山区', 15, '动作', '悬疑', null, '梁滔滔', '123', '125', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (7, '洪山区', 15, '科幻', '恐怖', '爱情', '兰舒涵', '123', '126', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (8, '洪山区', 15, '恐怖', null, null, '陆晶皓', '123', '127', 0, '女');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (11, '武昌区', 17, '剧情', '爱情', '科幻', '李怡凡', '123', '128', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (12, '武昌区', 19, '动作', '悬疑', null, '张文风', '123', '110', 0, '男');
INSERT INTO movietogether.users (id, address, age, label1, label2, label3, name, password, phone, role, sex)
VALUES (14, null, null, null, null, null, null, null, '13778106621', null, null);
