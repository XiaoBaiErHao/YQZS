package com.example.trxy.bean;

import java.util.List;

public class GlobalOutbreakBean {

    /**
     * code : 200
     * msg :
     * data : {"region":"全球","confirmedCount":4679352,"deadCount":315251,"curedCount":1711497,"updateTime":"2020-05-18 16:28:51","sourceDesc":"数据来自官方通报，全国与各省通报数据可能存在差异","continent":[{"continentName":"亚洲","confirmedCount":801115,"curedCount":455235,"deadCount":24788,"country":[{"provinceName":"印度","confirmedCount":96169,"curedCount":36824,"deadCount":3029},{"provinceName":"土耳其","confirmedCount":149435,"curedCount":109962,"deadCount":4140},{"provinceName":"巴基斯坦","confirmedCount":42125,"curedCount":11922,"deadCount":903},{"provinceName":"沙特阿拉伯","confirmedCount":54752,"curedCount":25722,"deadCount":312},{"provinceName":"卡塔尔","confirmedCount":32604,"curedCount":4370,"deadCount":15},{"provinceName":"新加坡","confirmedCount":28038,"curedCount":8342,"deadCount":22},{"provinceName":"伊朗","confirmedCount":120198,"curedCount":94464,"deadCount":6988},{"provinceName":"孟加拉国","confirmedCount":22268,"curedCount":4373,"deadCount":328},{"provinceName":"阿联酋","confirmedCount":23358,"curedCount":8512,"deadCount":220},{"provinceName":"印度尼西亚","confirmedCount":17520,"curedCount":4129,"deadCount":1148},{"provinceName":"科威特","confirmedCount":14850,"curedCount":3843,"deadCount":112},{"provinceName":"菲律宾","confirmedCount":12513,"curedCount":2635,"deadCount":824},{"provinceName":"日本","confirmedCount":16337,"curedCount":8920,"deadCount":756},{"provinceName":"阿富汗","confirmedCount":6664,"curedCount":784,"deadCount":169},{"provinceName":"巴林","confirmedCount":6930,"curedCount":2774,"deadCount":12},{"provinceName":"阿曼","confirmedCount":5186,"curedCount":1465,"deadCount":22},{"provinceName":"以色列","confirmedCount":16608,"curedCount":12855,"deadCount":268},{"provinceName":"哈萨克斯坦","confirmedCount":6440,"curedCount":3256,"deadCount":34},{"provinceName":"亚美尼亚","confirmedCount":4472,"curedCount":1925,"deadCount":60},{"provinceName":"塔吉克斯坦","confirmedCount":1322,"curedCount":0,"deadCount":41},{"provinceName":"阿塞拜疆","confirmedCount":3274,"curedCount":2015,"deadCount":39},{"provinceName":"马来西亚","confirmedCount":6894,"curedCount":5571,"deadCount":113},{"provinceName":"伊拉克","confirmedCount":3404,"curedCount":2218,"deadCount":123},{"provinceName":"马尔代夫","confirmedCount":1078,"curedCount":58,"deadCount":4},{"provinceName":"韩国","confirmedCount":11065,"curedCount":9904,"deadCount":263},{"provinceName":"黎巴嫩","confirmedCount":928,"curedCount":247,"deadCount":26},{"provinceName":"乌兹别克斯坦","confirmedCount":2741,"curedCount":2213,"deadCount":11},{"provinceName":"斯里兰卡","confirmedCount":981,"curedCount":538,"deadCount":9},{"provinceName":"塞浦路斯","confirmedCount":914,"curedCount":504,"deadCount":26},{"provinceName":"吉尔吉斯斯坦","confirmedCount":1216,"curedCount":827,"deadCount":14},{"provinceName":"巴勒斯坦","confirmedCount":560,"curedCount":263,"deadCount":4},{"provinceName":"尼泊尔","confirmedCount":295,"curedCount":22,"deadCount":2},{"provinceName":"格鲁吉亚","confirmedCount":695,"curedCount":425,"deadCount":12},{"provinceName":"约旦","confirmedCount":613,"curedCount":390,"deadCount":9},{"provinceName":"泰国","confirmedCount":3028,"curedCount":2798,"deadCount":56},{"provinceName":"越南","confirmedCount":318,"curedCount":169,"deadCount":0},{"provinceName":"中国","confirmedCount":84494,"curedCount":79701,"deadCount":4645},{"provinceName":"缅甸","confirmedCount":184,"curedCount":62,"deadCount":6},{"provinceName":"蒙古","confirmedCount":140,"curedCount":24,"deadCount":0},{"provinceName":"也门共和国","confirmedCount":126,"curedCount":1,"deadCount":19},{"provinceName":"柬埔寨","confirmedCount":122,"curedCount":50,"deadCount":0},{"provinceName":"东帝汶","confirmedCount":24,"curedCount":0,"deadCount":0},{"provinceName":"叙利亚","confirmedCount":51,"curedCount":27,"deadCount":3},{"provinceName":"不丹","confirmedCount":21,"curedCount":0,"deadCount":0},{"provinceName":"老挝","confirmedCount":19,"curedCount":0,"deadCount":0},{"provinceName":"文莱","confirmedCount":141,"curedCount":131,"deadCount":1}]},{"continentName":"欧洲","confirmedCount":1695383,"curedCount":719063,"deadCount":162418,"country":[{"provinceName":"俄罗斯","confirmedCount":281752,"curedCount":67373,"deadCount":2631},{"provinceName":"英国","confirmedCount":243695,"curedCount":539,"deadCount":34636},{"provinceName":"意大利","confirmedCount":225435,"curedCount":125176,"deadCount":31908},{"provinceName":"西班牙","confirmedCount":231350,"curedCount":149576,"deadCount":27650},{"provinceName":"法国","confirmedCount":142411,"curedCount":61213,"deadCount":28108},{"provinceName":"荷兰","confirmedCount":43995,"curedCount":291,"deadCount":5680},{"provinceName":"比利时","confirmedCount":55280,"curedCount":14630,"deadCount":9052},{"provinceName":"葡萄牙","confirmedCount":28810,"curedCount":3198,"deadCount":1203},{"provinceName":"瑞典","confirmedCount":30143,"curedCount":4971,"deadCount":3679},{"provinceName":"白俄罗斯","confirmedCount":29650,"curedCount":9932,"deadCount":165},{"provinceName":"乌克兰","confirmedCount":18291,"curedCount":4143,"deadCount":514},{"provinceName":"德国","confirmedCount":174697,"curedCount":154600,"deadCount":7935},{"provinceName":"波兰","confirmedCount":18257,"curedCount":7175,"deadCount":915},{"provinceName":"爱尔兰","confirmedCount":24048,"curedCount":13386,"deadCount":1533},{"provinceName":"塞尔维亚","confirmedCount":11565,"curedCount":5404,"deadCount":259},{"provinceName":"罗马尼亚","confirmedCount":16871,"curedCount":9890,"deadCount":1097},{"provinceName":"摩尔多瓦","confirmedCount":6060,"curedCount":2408,"deadCount":211},{"provinceName":"捷克","confirmedCount":8460,"curedCount":5435,"deadCount":298},{"provinceName":"奥地利","confirmedCount":16140,"curedCount":13228,"deadCount":628},{"provinceName":"芬兰","confirmedCount":6347,"curedCount":4300,"deadCount":298},{"provinceName":"瑞士","confirmedCount":30489,"curedCount":27145,"deadCount":1601},{"provinceName":"匈牙利","confirmedCount":3509,"curedCount":1396,"deadCount":451},{"provinceName":"保加利亚","confirmedCount":2211,"curedCount":499,"deadCount":108},{"provinceName":"丹麦","confirmedCount":10927,"curedCount":9107,"deadCount":547},{"provinceName":"希腊","confirmedCount":2834,"curedCount":1473,"deadCount":163},{"provinceName":"斯洛文尼亚","confirmedCount":1465,"curedCount":270,"deadCount":103},{"provinceName":"挪威","confirmedCount":8244,"curedCount":7114,"deadCount":232},{"provinceName":"波黑","confirmedCount":2265,"curedCount":1261,"deadCount":131},{"provinceName":"斯洛伐克","confirmedCount":1493,"curedCount":806,"deadCount":28},{"provinceName":"圣马力诺","confirmedCount":652,"curedCount":2,"deadCount":41},{"provinceName":"拉脱维亚","confirmedCount":997,"curedCount":464,"deadCount":19},{"provinceName":"立陶宛","confirmedCount":1534,"curedCount":988,"deadCount":55},{"provinceName":"爱沙尼亚","confirmedCount":1770,"curedCount":1275,"deadCount":63},{"provinceName":"北马其顿","confirmedCount":1792,"curedCount":1293,"deadCount":101},{"provinceName":"马恩岛","confirmedCount":334,"curedCount":0,"deadCount":24},{"provinceName":"泽西岛","confirmedCount":297,"curedCount":0,"deadCount":27},{"provinceName":"克罗地亚","confirmedCount":2224,"curedCount":1869,"deadCount":95},{"provinceName":"根西岛","confirmedCount":252,"curedCount":0,"deadCount":13},{"provinceName":"安道尔","confirmedCount":761,"curedCount":472,"deadCount":51},{"provinceName":"卢森堡","confirmedCount":3930,"curedCount":3602,"deadCount":104},{"provinceName":"阿尔巴尼亚","confirmedCount":946,"curedCount":714,"deadCount":31},{"provinceName":"法罗群岛","confirmedCount":187,"curedCount":0,"deadCount":0},{"provinceName":"马耳他","confirmedCount":546,"curedCount":367,"deadCount":6},{"provinceName":"直布罗陀","confirmedCount":147,"curedCount":0,"deadCount":1},{"provinceName":"摩纳哥","confirmedCount":98,"curedCount":3,"deadCount":3},{"provinceName":"黑山","confirmedCount":325,"curedCount":265,"deadCount":9},{"provinceName":"冰岛","confirmedCount":1802,"curedCount":1755,"deadCount":10},{"provinceName":"列支敦士登","confirmedCount":83,"curedCount":55,"deadCount":1},{"provinceName":"梵蒂冈","confirmedCount":12,"curedCount":0,"deadCount":0}]},{"continentName":"北美洲","confirmedCount":1647571,"curedCount":346117,"deadCount":101750,"country":[{"provinceName":"美国","confirmedCount":1486757,"curedCount":272265,"deadCount":89562},{"provinceName":"加拿大","confirmedCount":77002,"curedCount":38550,"deadCount":5782},{"provinceName":"墨西哥","confirmedCount":49219,"curedCount":33329,"deadCount":5177},{"provinceName":"多米尼加","confirmedCount":12110,"curedCount":993,"deadCount":428},{"provinceName":"巴拿马","confirmedCount":9628,"curedCount":455,"deadCount":266},{"provinceName":"波多黎各","confirmedCount":2589,"curedCount":0,"deadCount":122},{"provinceName":"洪都拉斯","confirmedCount":2460,"curedCount":0,"deadCount":134},{"provinceName":"危地马拉","confirmedCount":1643,"curedCount":0,"deadCount":30},{"provinceName":"古巴","confirmedCount":1862,"curedCount":525,"deadCount":79},{"provinceName":"萨尔瓦多","confirmedCount":1265,"curedCount":0,"deadCount":25},{"provinceName":"哥斯达黎加","confirmedCount":843,"curedCount":0,"deadCount":8},{"provinceName":"牙买加","confirmedCount":511,"curedCount":0,"deadCount":9},{"provinceName":"海地","confirmedCount":310,"curedCount":0,"deadCount":20},{"provinceName":"马提尼克","confirmedCount":192,"curedCount":0,"deadCount":14},{"provinceName":"瓜德罗普岛","confirmedCount":155,"curedCount":0,"deadCount":13},{"provinceName":"百慕大","confirmedCount":123,"curedCount":0,"deadCount":9},{"provinceName":"特立尼达和多巴哥","confirmedCount":116,"curedCount":0,"deadCount":8},{"provinceName":"阿鲁巴","confirmedCount":101,"curedCount":0,"deadCount":3},{"provinceName":"开曼群岛","confirmedCount":94,"curedCount":0,"deadCount":2},{"provinceName":"巴哈马","confirmedCount":96,"curedCount":0,"deadCount":11},{"provinceName":"巴巴多斯","confirmedCount":85,"curedCount":0,"deadCount":7},{"provinceName":"荷属圣马丁","confirmedCount":78,"curedCount":0,"deadCount":15},{"provinceName":"美属维尔京群岛","confirmedCount":69,"curedCount":0,"deadCount":6},{"provinceName":"圣马丁岛","confirmedCount":39,"curedCount":0,"deadCount":3},{"provinceName":"安提瓜和巴布达","confirmedCount":25,"curedCount":0,"deadCount":3},{"provinceName":"格林那达","confirmedCount":22,"curedCount":0,"deadCount":0},{"provinceName":"圣卢西亚","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"尼加拉瓜","confirmedCount":25,"curedCount":0,"deadCount":8},{"provinceName":"圣文森特和格林纳丁斯","confirmedCount":17,"curedCount":0,"deadCount":0},{"provinceName":"伯利兹","confirmedCount":18,"curedCount":0,"deadCount":2},{"provinceName":"多米尼克","confirmedCount":16,"curedCount":0,"deadCount":0},{"provinceName":"库拉索岛","confirmedCount":16,"curedCount":0,"deadCount":1},{"provinceName":"圣其茨和尼维斯","confirmedCount":15,"curedCount":0,"deadCount":0},{"provinceName":"特克斯和凯科斯群岛","confirmedCount":12,"curedCount":0,"deadCount":1},{"provinceName":"格陵兰","confirmedCount":11,"curedCount":0,"deadCount":0},{"provinceName":"蒙特塞拉特","confirmedCount":11,"curedCount":0,"deadCount":1},{"provinceName":"英属维尔京群岛","confirmedCount":8,"curedCount":0,"deadCount":1},{"provinceName":"圣巴泰勒米岛","confirmedCount":6,"curedCount":0,"deadCount":0},{"provinceName":"安圭拉","confirmedCount":3,"curedCount":0,"deadCount":0},{"provinceName":"圣皮埃尔和密克隆群岛","confirmedCount":1,"curedCount":0,"deadCount":0}]},{"continentName":"南洋洲","confirmedCount":0,"curedCount":0,"deadCount":0,"country":[]},{"continentName":"非洲","confirmedCount":86483,"curedCount":31779,"deadCount":2778,"country":[{"provinceName":"埃及","confirmedCount":12229,"curedCount":3172,"deadCount":630},{"provinceName":"南非","confirmedCount":15515,"curedCount":7006,"deadCount":264},{"provinceName":"尼日利亚","confirmedCount":5959,"curedCount":1594,"deadCount":182},{"provinceName":"加纳","confirmedCount":5735,"curedCount":1754,"deadCount":29},{"provinceName":"摩洛哥","confirmedCount":6870,"curedCount":3660,"deadCount":192},{"provinceName":"阿尔及利亚","confirmedCount":7019,"curedCount":3507,"deadCount":548},{"provinceName":"苏丹","confirmedCount":2591,"curedCount":247,"deadCount":105},{"provinceName":"几内亚","confirmedCount":2658,"curedCount":895,"deadCount":16},{"provinceName":"塞内加尔","confirmedCount":2480,"curedCount":973,"deadCount":25},{"provinceName":"喀麦隆","confirmedCount":3047,"curedCount":1553,"deadCount":139},{"provinceName":"马约特","confirmedCount":1258,"curedCount":0,"deadCount":16},{"provinceName":"索马里","confirmedCount":1421,"curedCount":152,"deadCount":56},{"provinceName":"刚果（金）","confirmedCount":1455,"curedCount":270,"deadCount":61},{"provinceName":"科特迪瓦","confirmedCount":2109,"curedCount":1004,"deadCount":27},{"provinceName":"加蓬","confirmedCount":1320,"curedCount":244,"deadCount":11},{"provinceName":"几内亚比绍","confirmedCount":969,"curedCount":26,"deadCount":4},{"provinceName":"赤道几内亚","confirmedCount":690,"curedCount":22,"deadCount":7},{"provinceName":"赞比亚共和国","confirmedCount":753,"curedCount":188,"deadCount":7},{"provinceName":"肯尼亚","confirmedCount":887,"curedCount":313,"deadCount":50},{"provinceName":"吉布提","confirmedCount":1401,"curedCount":935,"deadCount":4},{"provinceName":"留尼旺","confirmedCount":443,"curedCount":0,"deadCount":0},{"provinceName":"乍得","confirmedCount":474,"curedCount":0,"deadCount":50},{"provinceName":"塞拉利昂","confirmedCount":505,"curedCount":141,"deadCount":32},{"provinceName":"坦桑尼亚","confirmedCount":509,"curedCount":167,"deadCount":21},{"provinceName":"马里","confirmedCount":860,"curedCount":494,"deadCount":52},{"provinceName":"中非共和国","confirmedCount":301,"curedCount":12,"deadCount":0},{"provinceName":"刚果（布）","confirmedCount":412,"curedCount":110,"deadCount":15},{"provinceName":"南苏丹","confirmedCount":290,"curedCount":4,"deadCount":4},{"provinceName":"佛得角","confirmedCount":328,"curedCount":44,"deadCount":3},{"provinceName":"贝宁","confirmedCount":339,"curedCount":62,"deadCount":2},{"provinceName":"圣多美和普林西比","confirmedCount":208,"curedCount":0,"deadCount":7},{"provinceName":"突尼斯","confirmedCount":1037,"curedCount":802,"deadCount":45},{"provinceName":"埃塞俄比亚","confirmedCount":306,"curedCount":112,"deadCount":5},{"provinceName":"马达加斯加","confirmedCount":304,"curedCount":114,"deadCount":1},{"provinceName":"多哥","confirmedCount":298,"curedCount":99,"deadCount":11},{"provinceName":"斯威士兰","confirmedCount":202,"curedCount":13,"deadCount":2},{"provinceName":"乌干达","confirmedCount":227,"curedCount":63,"deadCount":0},{"provinceName":"尼日尔","confirmedCount":904,"curedCount":698,"deadCount":54},{"provinceName":"布基纳法索","confirmedCount":782,"curedCount":592,"deadCount":51},{"provinceName":"利比里亚","confirmedCount":223,"curedCount":85,"deadCount":20},{"provinceName":"卢旺达","confirmedCount":289,"curedCount":178,"deadCount":0},{"provinceName":"莫桑比克","confirmedCount":129,"curedCount":34,"deadCount":0},{"provinceName":"利比亚","confirmedCount":65,"curedCount":24,"deadCount":3},{"provinceName":"马拉维","confirmedCount":65,"curedCount":24,"deadCount":3},{"provinceName":"安哥拉","confirmedCount":48,"curedCount":11,"deadCount":2},{"provinceName":"津巴布韦","confirmedCount":44,"curedCount":5,"deadCount":4},{"provinceName":"毛里塔尼亚","confirmedCount":40,"curedCount":6,"deadCount":4},{"provinceName":"博茨瓦纳","confirmedCount":25,"curedCount":0,"deadCount":1},{"provinceName":"布隆迪共和国","confirmedCount":27,"curedCount":4,"deadCount":1},{"provinceName":"冈比亚","confirmedCount":23,"curedCount":2,"deadCount":1},{"provinceName":"纳米比亚","confirmedCount":16,"curedCount":3,"deadCount":0},{"provinceName":"塞舌尔","confirmedCount":11,"curedCount":0,"deadCount":0},{"provinceName":"科摩罗","confirmedCount":11,"curedCount":0,"deadCount":1},{"provinceName":"莱索托","confirmedCount":1,"curedCount":0,"deadCount":0},{"provinceName":"毛里求斯","confirmedCount":332,"curedCount":322,"deadCount":10},{"provinceName":"厄立特里亚","confirmedCount":39,"curedCount":39,"deadCount":0}]},{"continentName":"大洋洲","confirmedCount":8468,"curedCount":7714,"deadCount":126,"country":[{"provinceName":"澳大利亚","confirmedCount":7045,"curedCount":6367,"deadCount":98},{"provinceName":"关岛","confirmedCount":149,"curedCount":0,"deadCount":5},{"provinceName":"法属波利尼西亚","confirmedCount":60,"curedCount":0,"deadCount":0},{"provinceName":"北马里亚纳群岛联邦","confirmedCount":21,"curedCount":0,"deadCount":2},{"provinceName":"斐济","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"新喀里多尼亚","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"巴布亚新几内亚","confirmedCount":8,"curedCount":0,"deadCount":0},{"provinceName":"新西兰","confirmedCount":1149,"curedCount":1347,"deadCount":21}]},{"continentName":"其他","confirmedCount":712,"curedCount":574,"deadCount":13,"country":[{"provinceName":"钻石公主号邮轮","confirmedCount":712,"curedCount":574,"deadCount":13}]}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * region : 全球
         * confirmedCount : 4679352
         * deadCount : 315251
         * curedCount : 1711497
         * updateTime : 2020-05-18 16:28:51
         * sourceDesc : 数据来自官方通报，全国与各省通报数据可能存在差异
         * continent : [{"continentName":"亚洲","confirmedCount":801115,"curedCount":455235,"deadCount":24788,"country":[{"provinceName":"印度","confirmedCount":96169,"curedCount":36824,"deadCount":3029},{"provinceName":"土耳其","confirmedCount":149435,"curedCount":109962,"deadCount":4140},{"provinceName":"巴基斯坦","confirmedCount":42125,"curedCount":11922,"deadCount":903},{"provinceName":"沙特阿拉伯","confirmedCount":54752,"curedCount":25722,"deadCount":312},{"provinceName":"卡塔尔","confirmedCount":32604,"curedCount":4370,"deadCount":15},{"provinceName":"新加坡","confirmedCount":28038,"curedCount":8342,"deadCount":22},{"provinceName":"伊朗","confirmedCount":120198,"curedCount":94464,"deadCount":6988},{"provinceName":"孟加拉国","confirmedCount":22268,"curedCount":4373,"deadCount":328},{"provinceName":"阿联酋","confirmedCount":23358,"curedCount":8512,"deadCount":220},{"provinceName":"印度尼西亚","confirmedCount":17520,"curedCount":4129,"deadCount":1148},{"provinceName":"科威特","confirmedCount":14850,"curedCount":3843,"deadCount":112},{"provinceName":"菲律宾","confirmedCount":12513,"curedCount":2635,"deadCount":824},{"provinceName":"日本","confirmedCount":16337,"curedCount":8920,"deadCount":756},{"provinceName":"阿富汗","confirmedCount":6664,"curedCount":784,"deadCount":169},{"provinceName":"巴林","confirmedCount":6930,"curedCount":2774,"deadCount":12},{"provinceName":"阿曼","confirmedCount":5186,"curedCount":1465,"deadCount":22},{"provinceName":"以色列","confirmedCount":16608,"curedCount":12855,"deadCount":268},{"provinceName":"哈萨克斯坦","confirmedCount":6440,"curedCount":3256,"deadCount":34},{"provinceName":"亚美尼亚","confirmedCount":4472,"curedCount":1925,"deadCount":60},{"provinceName":"塔吉克斯坦","confirmedCount":1322,"curedCount":0,"deadCount":41},{"provinceName":"阿塞拜疆","confirmedCount":3274,"curedCount":2015,"deadCount":39},{"provinceName":"马来西亚","confirmedCount":6894,"curedCount":5571,"deadCount":113},{"provinceName":"伊拉克","confirmedCount":3404,"curedCount":2218,"deadCount":123},{"provinceName":"马尔代夫","confirmedCount":1078,"curedCount":58,"deadCount":4},{"provinceName":"韩国","confirmedCount":11065,"curedCount":9904,"deadCount":263},{"provinceName":"黎巴嫩","confirmedCount":928,"curedCount":247,"deadCount":26},{"provinceName":"乌兹别克斯坦","confirmedCount":2741,"curedCount":2213,"deadCount":11},{"provinceName":"斯里兰卡","confirmedCount":981,"curedCount":538,"deadCount":9},{"provinceName":"塞浦路斯","confirmedCount":914,"curedCount":504,"deadCount":26},{"provinceName":"吉尔吉斯斯坦","confirmedCount":1216,"curedCount":827,"deadCount":14},{"provinceName":"巴勒斯坦","confirmedCount":560,"curedCount":263,"deadCount":4},{"provinceName":"尼泊尔","confirmedCount":295,"curedCount":22,"deadCount":2},{"provinceName":"格鲁吉亚","confirmedCount":695,"curedCount":425,"deadCount":12},{"provinceName":"约旦","confirmedCount":613,"curedCount":390,"deadCount":9},{"provinceName":"泰国","confirmedCount":3028,"curedCount":2798,"deadCount":56},{"provinceName":"越南","confirmedCount":318,"curedCount":169,"deadCount":0},{"provinceName":"中国","confirmedCount":84494,"curedCount":79701,"deadCount":4645},{"provinceName":"缅甸","confirmedCount":184,"curedCount":62,"deadCount":6},{"provinceName":"蒙古","confirmedCount":140,"curedCount":24,"deadCount":0},{"provinceName":"也门共和国","confirmedCount":126,"curedCount":1,"deadCount":19},{"provinceName":"柬埔寨","confirmedCount":122,"curedCount":50,"deadCount":0},{"provinceName":"东帝汶","confirmedCount":24,"curedCount":0,"deadCount":0},{"provinceName":"叙利亚","confirmedCount":51,"curedCount":27,"deadCount":3},{"provinceName":"不丹","confirmedCount":21,"curedCount":0,"deadCount":0},{"provinceName":"老挝","confirmedCount":19,"curedCount":0,"deadCount":0},{"provinceName":"文莱","confirmedCount":141,"curedCount":131,"deadCount":1}]},{"continentName":"欧洲","confirmedCount":1695383,"curedCount":719063,"deadCount":162418,"country":[{"provinceName":"俄罗斯","confirmedCount":281752,"curedCount":67373,"deadCount":2631},{"provinceName":"英国","confirmedCount":243695,"curedCount":539,"deadCount":34636},{"provinceName":"意大利","confirmedCount":225435,"curedCount":125176,"deadCount":31908},{"provinceName":"西班牙","confirmedCount":231350,"curedCount":149576,"deadCount":27650},{"provinceName":"法国","confirmedCount":142411,"curedCount":61213,"deadCount":28108},{"provinceName":"荷兰","confirmedCount":43995,"curedCount":291,"deadCount":5680},{"provinceName":"比利时","confirmedCount":55280,"curedCount":14630,"deadCount":9052},{"provinceName":"葡萄牙","confirmedCount":28810,"curedCount":3198,"deadCount":1203},{"provinceName":"瑞典","confirmedCount":30143,"curedCount":4971,"deadCount":3679},{"provinceName":"白俄罗斯","confirmedCount":29650,"curedCount":9932,"deadCount":165},{"provinceName":"乌克兰","confirmedCount":18291,"curedCount":4143,"deadCount":514},{"provinceName":"德国","confirmedCount":174697,"curedCount":154600,"deadCount":7935},{"provinceName":"波兰","confirmedCount":18257,"curedCount":7175,"deadCount":915},{"provinceName":"爱尔兰","confirmedCount":24048,"curedCount":13386,"deadCount":1533},{"provinceName":"塞尔维亚","confirmedCount":11565,"curedCount":5404,"deadCount":259},{"provinceName":"罗马尼亚","confirmedCount":16871,"curedCount":9890,"deadCount":1097},{"provinceName":"摩尔多瓦","confirmedCount":6060,"curedCount":2408,"deadCount":211},{"provinceName":"捷克","confirmedCount":8460,"curedCount":5435,"deadCount":298},{"provinceName":"奥地利","confirmedCount":16140,"curedCount":13228,"deadCount":628},{"provinceName":"芬兰","confirmedCount":6347,"curedCount":4300,"deadCount":298},{"provinceName":"瑞士","confirmedCount":30489,"curedCount":27145,"deadCount":1601},{"provinceName":"匈牙利","confirmedCount":3509,"curedCount":1396,"deadCount":451},{"provinceName":"保加利亚","confirmedCount":2211,"curedCount":499,"deadCount":108},{"provinceName":"丹麦","confirmedCount":10927,"curedCount":9107,"deadCount":547},{"provinceName":"希腊","confirmedCount":2834,"curedCount":1473,"deadCount":163},{"provinceName":"斯洛文尼亚","confirmedCount":1465,"curedCount":270,"deadCount":103},{"provinceName":"挪威","confirmedCount":8244,"curedCount":7114,"deadCount":232},{"provinceName":"波黑","confirmedCount":2265,"curedCount":1261,"deadCount":131},{"provinceName":"斯洛伐克","confirmedCount":1493,"curedCount":806,"deadCount":28},{"provinceName":"圣马力诺","confirmedCount":652,"curedCount":2,"deadCount":41},{"provinceName":"拉脱维亚","confirmedCount":997,"curedCount":464,"deadCount":19},{"provinceName":"立陶宛","confirmedCount":1534,"curedCount":988,"deadCount":55},{"provinceName":"爱沙尼亚","confirmedCount":1770,"curedCount":1275,"deadCount":63},{"provinceName":"北马其顿","confirmedCount":1792,"curedCount":1293,"deadCount":101},{"provinceName":"马恩岛","confirmedCount":334,"curedCount":0,"deadCount":24},{"provinceName":"泽西岛","confirmedCount":297,"curedCount":0,"deadCount":27},{"provinceName":"克罗地亚","confirmedCount":2224,"curedCount":1869,"deadCount":95},{"provinceName":"根西岛","confirmedCount":252,"curedCount":0,"deadCount":13},{"provinceName":"安道尔","confirmedCount":761,"curedCount":472,"deadCount":51},{"provinceName":"卢森堡","confirmedCount":3930,"curedCount":3602,"deadCount":104},{"provinceName":"阿尔巴尼亚","confirmedCount":946,"curedCount":714,"deadCount":31},{"provinceName":"法罗群岛","confirmedCount":187,"curedCount":0,"deadCount":0},{"provinceName":"马耳他","confirmedCount":546,"curedCount":367,"deadCount":6},{"provinceName":"直布罗陀","confirmedCount":147,"curedCount":0,"deadCount":1},{"provinceName":"摩纳哥","confirmedCount":98,"curedCount":3,"deadCount":3},{"provinceName":"黑山","confirmedCount":325,"curedCount":265,"deadCount":9},{"provinceName":"冰岛","confirmedCount":1802,"curedCount":1755,"deadCount":10},{"provinceName":"列支敦士登","confirmedCount":83,"curedCount":55,"deadCount":1},{"provinceName":"梵蒂冈","confirmedCount":12,"curedCount":0,"deadCount":0}]},{"continentName":"北美洲","confirmedCount":1647571,"curedCount":346117,"deadCount":101750,"country":[{"provinceName":"美国","confirmedCount":1486757,"curedCount":272265,"deadCount":89562},{"provinceName":"加拿大","confirmedCount":77002,"curedCount":38550,"deadCount":5782},{"provinceName":"墨西哥","confirmedCount":49219,"curedCount":33329,"deadCount":5177},{"provinceName":"多米尼加","confirmedCount":12110,"curedCount":993,"deadCount":428},{"provinceName":"巴拿马","confirmedCount":9628,"curedCount":455,"deadCount":266},{"provinceName":"波多黎各","confirmedCount":2589,"curedCount":0,"deadCount":122},{"provinceName":"洪都拉斯","confirmedCount":2460,"curedCount":0,"deadCount":134},{"provinceName":"危地马拉","confirmedCount":1643,"curedCount":0,"deadCount":30},{"provinceName":"古巴","confirmedCount":1862,"curedCount":525,"deadCount":79},{"provinceName":"萨尔瓦多","confirmedCount":1265,"curedCount":0,"deadCount":25},{"provinceName":"哥斯达黎加","confirmedCount":843,"curedCount":0,"deadCount":8},{"provinceName":"牙买加","confirmedCount":511,"curedCount":0,"deadCount":9},{"provinceName":"海地","confirmedCount":310,"curedCount":0,"deadCount":20},{"provinceName":"马提尼克","confirmedCount":192,"curedCount":0,"deadCount":14},{"provinceName":"瓜德罗普岛","confirmedCount":155,"curedCount":0,"deadCount":13},{"provinceName":"百慕大","confirmedCount":123,"curedCount":0,"deadCount":9},{"provinceName":"特立尼达和多巴哥","confirmedCount":116,"curedCount":0,"deadCount":8},{"provinceName":"阿鲁巴","confirmedCount":101,"curedCount":0,"deadCount":3},{"provinceName":"开曼群岛","confirmedCount":94,"curedCount":0,"deadCount":2},{"provinceName":"巴哈马","confirmedCount":96,"curedCount":0,"deadCount":11},{"provinceName":"巴巴多斯","confirmedCount":85,"curedCount":0,"deadCount":7},{"provinceName":"荷属圣马丁","confirmedCount":78,"curedCount":0,"deadCount":15},{"provinceName":"美属维尔京群岛","confirmedCount":69,"curedCount":0,"deadCount":6},{"provinceName":"圣马丁岛","confirmedCount":39,"curedCount":0,"deadCount":3},{"provinceName":"安提瓜和巴布达","confirmedCount":25,"curedCount":0,"deadCount":3},{"provinceName":"格林那达","confirmedCount":22,"curedCount":0,"deadCount":0},{"provinceName":"圣卢西亚","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"尼加拉瓜","confirmedCount":25,"curedCount":0,"deadCount":8},{"provinceName":"圣文森特和格林纳丁斯","confirmedCount":17,"curedCount":0,"deadCount":0},{"provinceName":"伯利兹","confirmedCount":18,"curedCount":0,"deadCount":2},{"provinceName":"多米尼克","confirmedCount":16,"curedCount":0,"deadCount":0},{"provinceName":"库拉索岛","confirmedCount":16,"curedCount":0,"deadCount":1},{"provinceName":"圣其茨和尼维斯","confirmedCount":15,"curedCount":0,"deadCount":0},{"provinceName":"特克斯和凯科斯群岛","confirmedCount":12,"curedCount":0,"deadCount":1},{"provinceName":"格陵兰","confirmedCount":11,"curedCount":0,"deadCount":0},{"provinceName":"蒙特塞拉特","confirmedCount":11,"curedCount":0,"deadCount":1},{"provinceName":"英属维尔京群岛","confirmedCount":8,"curedCount":0,"deadCount":1},{"provinceName":"圣巴泰勒米岛","confirmedCount":6,"curedCount":0,"deadCount":0},{"provinceName":"安圭拉","confirmedCount":3,"curedCount":0,"deadCount":0},{"provinceName":"圣皮埃尔和密克隆群岛","confirmedCount":1,"curedCount":0,"deadCount":0}]},{"continentName":"南洋洲","confirmedCount":0,"curedCount":0,"deadCount":0,"country":[]},{"continentName":"非洲","confirmedCount":86483,"curedCount":31779,"deadCount":2778,"country":[{"provinceName":"埃及","confirmedCount":12229,"curedCount":3172,"deadCount":630},{"provinceName":"南非","confirmedCount":15515,"curedCount":7006,"deadCount":264},{"provinceName":"尼日利亚","confirmedCount":5959,"curedCount":1594,"deadCount":182},{"provinceName":"加纳","confirmedCount":5735,"curedCount":1754,"deadCount":29},{"provinceName":"摩洛哥","confirmedCount":6870,"curedCount":3660,"deadCount":192},{"provinceName":"阿尔及利亚","confirmedCount":7019,"curedCount":3507,"deadCount":548},{"provinceName":"苏丹","confirmedCount":2591,"curedCount":247,"deadCount":105},{"provinceName":"几内亚","confirmedCount":2658,"curedCount":895,"deadCount":16},{"provinceName":"塞内加尔","confirmedCount":2480,"curedCount":973,"deadCount":25},{"provinceName":"喀麦隆","confirmedCount":3047,"curedCount":1553,"deadCount":139},{"provinceName":"马约特","confirmedCount":1258,"curedCount":0,"deadCount":16},{"provinceName":"索马里","confirmedCount":1421,"curedCount":152,"deadCount":56},{"provinceName":"刚果（金）","confirmedCount":1455,"curedCount":270,"deadCount":61},{"provinceName":"科特迪瓦","confirmedCount":2109,"curedCount":1004,"deadCount":27},{"provinceName":"加蓬","confirmedCount":1320,"curedCount":244,"deadCount":11},{"provinceName":"几内亚比绍","confirmedCount":969,"curedCount":26,"deadCount":4},{"provinceName":"赤道几内亚","confirmedCount":690,"curedCount":22,"deadCount":7},{"provinceName":"赞比亚共和国","confirmedCount":753,"curedCount":188,"deadCount":7},{"provinceName":"肯尼亚","confirmedCount":887,"curedCount":313,"deadCount":50},{"provinceName":"吉布提","confirmedCount":1401,"curedCount":935,"deadCount":4},{"provinceName":"留尼旺","confirmedCount":443,"curedCount":0,"deadCount":0},{"provinceName":"乍得","confirmedCount":474,"curedCount":0,"deadCount":50},{"provinceName":"塞拉利昂","confirmedCount":505,"curedCount":141,"deadCount":32},{"provinceName":"坦桑尼亚","confirmedCount":509,"curedCount":167,"deadCount":21},{"provinceName":"马里","confirmedCount":860,"curedCount":494,"deadCount":52},{"provinceName":"中非共和国","confirmedCount":301,"curedCount":12,"deadCount":0},{"provinceName":"刚果（布）","confirmedCount":412,"curedCount":110,"deadCount":15},{"provinceName":"南苏丹","confirmedCount":290,"curedCount":4,"deadCount":4},{"provinceName":"佛得角","confirmedCount":328,"curedCount":44,"deadCount":3},{"provinceName":"贝宁","confirmedCount":339,"curedCount":62,"deadCount":2},{"provinceName":"圣多美和普林西比","confirmedCount":208,"curedCount":0,"deadCount":7},{"provinceName":"突尼斯","confirmedCount":1037,"curedCount":802,"deadCount":45},{"provinceName":"埃塞俄比亚","confirmedCount":306,"curedCount":112,"deadCount":5},{"provinceName":"马达加斯加","confirmedCount":304,"curedCount":114,"deadCount":1},{"provinceName":"多哥","confirmedCount":298,"curedCount":99,"deadCount":11},{"provinceName":"斯威士兰","confirmedCount":202,"curedCount":13,"deadCount":2},{"provinceName":"乌干达","confirmedCount":227,"curedCount":63,"deadCount":0},{"provinceName":"尼日尔","confirmedCount":904,"curedCount":698,"deadCount":54},{"provinceName":"布基纳法索","confirmedCount":782,"curedCount":592,"deadCount":51},{"provinceName":"利比里亚","confirmedCount":223,"curedCount":85,"deadCount":20},{"provinceName":"卢旺达","confirmedCount":289,"curedCount":178,"deadCount":0},{"provinceName":"莫桑比克","confirmedCount":129,"curedCount":34,"deadCount":0},{"provinceName":"利比亚","confirmedCount":65,"curedCount":24,"deadCount":3},{"provinceName":"马拉维","confirmedCount":65,"curedCount":24,"deadCount":3},{"provinceName":"安哥拉","confirmedCount":48,"curedCount":11,"deadCount":2},{"provinceName":"津巴布韦","confirmedCount":44,"curedCount":5,"deadCount":4},{"provinceName":"毛里塔尼亚","confirmedCount":40,"curedCount":6,"deadCount":4},{"provinceName":"博茨瓦纳","confirmedCount":25,"curedCount":0,"deadCount":1},{"provinceName":"布隆迪共和国","confirmedCount":27,"curedCount":4,"deadCount":1},{"provinceName":"冈比亚","confirmedCount":23,"curedCount":2,"deadCount":1},{"provinceName":"纳米比亚","confirmedCount":16,"curedCount":3,"deadCount":0},{"provinceName":"塞舌尔","confirmedCount":11,"curedCount":0,"deadCount":0},{"provinceName":"科摩罗","confirmedCount":11,"curedCount":0,"deadCount":1},{"provinceName":"莱索托","confirmedCount":1,"curedCount":0,"deadCount":0},{"provinceName":"毛里求斯","confirmedCount":332,"curedCount":322,"deadCount":10},{"provinceName":"厄立特里亚","confirmedCount":39,"curedCount":39,"deadCount":0}]},{"continentName":"大洋洲","confirmedCount":8468,"curedCount":7714,"deadCount":126,"country":[{"provinceName":"澳大利亚","confirmedCount":7045,"curedCount":6367,"deadCount":98},{"provinceName":"关岛","confirmedCount":149,"curedCount":0,"deadCount":5},{"provinceName":"法属波利尼西亚","confirmedCount":60,"curedCount":0,"deadCount":0},{"provinceName":"北马里亚纳群岛联邦","confirmedCount":21,"curedCount":0,"deadCount":2},{"provinceName":"斐济","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"新喀里多尼亚","confirmedCount":18,"curedCount":0,"deadCount":0},{"provinceName":"巴布亚新几内亚","confirmedCount":8,"curedCount":0,"deadCount":0},{"provinceName":"新西兰","confirmedCount":1149,"curedCount":1347,"deadCount":21}]},{"continentName":"其他","confirmedCount":712,"curedCount":574,"deadCount":13,"country":[{"provinceName":"钻石公主号邮轮","confirmedCount":712,"curedCount":574,"deadCount":13}]}]
         */

        private String region;
        private int confirmedCount;
        private int deadCount;
        private int curedCount;
        private String updateTime;
        private String sourceDesc;
        private List<ContinentBean> continent;

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public int getConfirmedCount() {
            return confirmedCount;
        }

        public void setConfirmedCount(int confirmedCount) {
            this.confirmedCount = confirmedCount;
        }

        public int getDeadCount() {
            return deadCount;
        }

        public void setDeadCount(int deadCount) {
            this.deadCount = deadCount;
        }

        public int getCuredCount() {
            return curedCount;
        }

        public void setCuredCount(int curedCount) {
            this.curedCount = curedCount;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getSourceDesc() {
            return sourceDesc;
        }

        public void setSourceDesc(String sourceDesc) {
            this.sourceDesc = sourceDesc;
        }

        public List<ContinentBean> getContinent() {
            return continent;
        }

        public void setContinent(List<ContinentBean> continent) {
            this.continent = continent;
        }

        public static class ContinentBean {
            /**
             * continentName : 亚洲
             * confirmedCount : 801115
             * curedCount : 455235
             * deadCount : 24788
             * country : [{"provinceName":"印度","confirmedCount":96169,"curedCount":36824,"deadCount":3029},{"provinceName":"土耳其","confirmedCount":149435,"curedCount":109962,"deadCount":4140},{"provinceName":"巴基斯坦","confirmedCount":42125,"curedCount":11922,"deadCount":903},{"provinceName":"沙特阿拉伯","confirmedCount":54752,"curedCount":25722,"deadCount":312},{"provinceName":"卡塔尔","confirmedCount":32604,"curedCount":4370,"deadCount":15},{"provinceName":"新加坡","confirmedCount":28038,"curedCount":8342,"deadCount":22},{"provinceName":"伊朗","confirmedCount":120198,"curedCount":94464,"deadCount":6988},{"provinceName":"孟加拉国","confirmedCount":22268,"curedCount":4373,"deadCount":328},{"provinceName":"阿联酋","confirmedCount":23358,"curedCount":8512,"deadCount":220},{"provinceName":"印度尼西亚","confirmedCount":17520,"curedCount":4129,"deadCount":1148},{"provinceName":"科威特","confirmedCount":14850,"curedCount":3843,"deadCount":112},{"provinceName":"菲律宾","confirmedCount":12513,"curedCount":2635,"deadCount":824},{"provinceName":"日本","confirmedCount":16337,"curedCount":8920,"deadCount":756},{"provinceName":"阿富汗","confirmedCount":6664,"curedCount":784,"deadCount":169},{"provinceName":"巴林","confirmedCount":6930,"curedCount":2774,"deadCount":12},{"provinceName":"阿曼","confirmedCount":5186,"curedCount":1465,"deadCount":22},{"provinceName":"以色列","confirmedCount":16608,"curedCount":12855,"deadCount":268},{"provinceName":"哈萨克斯坦","confirmedCount":6440,"curedCount":3256,"deadCount":34},{"provinceName":"亚美尼亚","confirmedCount":4472,"curedCount":1925,"deadCount":60},{"provinceName":"塔吉克斯坦","confirmedCount":1322,"curedCount":0,"deadCount":41},{"provinceName":"阿塞拜疆","confirmedCount":3274,"curedCount":2015,"deadCount":39},{"provinceName":"马来西亚","confirmedCount":6894,"curedCount":5571,"deadCount":113},{"provinceName":"伊拉克","confirmedCount":3404,"curedCount":2218,"deadCount":123},{"provinceName":"马尔代夫","confirmedCount":1078,"curedCount":58,"deadCount":4},{"provinceName":"韩国","confirmedCount":11065,"curedCount":9904,"deadCount":263},{"provinceName":"黎巴嫩","confirmedCount":928,"curedCount":247,"deadCount":26},{"provinceName":"乌兹别克斯坦","confirmedCount":2741,"curedCount":2213,"deadCount":11},{"provinceName":"斯里兰卡","confirmedCount":981,"curedCount":538,"deadCount":9},{"provinceName":"塞浦路斯","confirmedCount":914,"curedCount":504,"deadCount":26},{"provinceName":"吉尔吉斯斯坦","confirmedCount":1216,"curedCount":827,"deadCount":14},{"provinceName":"巴勒斯坦","confirmedCount":560,"curedCount":263,"deadCount":4},{"provinceName":"尼泊尔","confirmedCount":295,"curedCount":22,"deadCount":2},{"provinceName":"格鲁吉亚","confirmedCount":695,"curedCount":425,"deadCount":12},{"provinceName":"约旦","confirmedCount":613,"curedCount":390,"deadCount":9},{"provinceName":"泰国","confirmedCount":3028,"curedCount":2798,"deadCount":56},{"provinceName":"越南","confirmedCount":318,"curedCount":169,"deadCount":0},{"provinceName":"中国","confirmedCount":84494,"curedCount":79701,"deadCount":4645},{"provinceName":"缅甸","confirmedCount":184,"curedCount":62,"deadCount":6},{"provinceName":"蒙古","confirmedCount":140,"curedCount":24,"deadCount":0},{"provinceName":"也门共和国","confirmedCount":126,"curedCount":1,"deadCount":19},{"provinceName":"柬埔寨","confirmedCount":122,"curedCount":50,"deadCount":0},{"provinceName":"东帝汶","confirmedCount":24,"curedCount":0,"deadCount":0},{"provinceName":"叙利亚","confirmedCount":51,"curedCount":27,"deadCount":3},{"provinceName":"不丹","confirmedCount":21,"curedCount":0,"deadCount":0},{"provinceName":"老挝","confirmedCount":19,"curedCount":0,"deadCount":0},{"provinceName":"文莱","confirmedCount":141,"curedCount":131,"deadCount":1}]
             */

            private String continentName;
            private int confirmedCount;
            private int curedCount;
            private int deadCount;
            private List<CountryBean> country;

            public String getContinentName() {
                return continentName;
            }

            public void setContinentName(String continentName) {
                this.continentName = continentName;
            }

            public int getConfirmedCount() {
                return confirmedCount;
            }

            public void setConfirmedCount(int confirmedCount) {
                this.confirmedCount = confirmedCount;
            }

            public int getCuredCount() {
                return curedCount;
            }

            public void setCuredCount(int curedCount) {
                this.curedCount = curedCount;
            }

            public int getDeadCount() {
                return deadCount;
            }

            public void setDeadCount(int deadCount) {
                this.deadCount = deadCount;
            }

            public List<CountryBean> getCountry() {
                return country;
            }

            public void setCountry(List<CountryBean> country) {
                this.country = country;
            }

            public static class CountryBean {
                /**
                 * provinceName : 印度
                 * confirmedCount : 96169
                 * curedCount : 36824
                 * deadCount : 3029
                 */

                private String provinceName;
                private int confirmedCount;
                private int curedCount;
                private int deadCount;

                public String getProvinceName() {
                    return provinceName;
                }

                public void setProvinceName(String provinceName) {
                    this.provinceName = provinceName;
                }

                public int getConfirmedCount() {
                    return confirmedCount;
                }

                public void setConfirmedCount(int confirmedCount) {
                    this.confirmedCount = confirmedCount;
                }

                public int getCuredCount() {
                    return curedCount;
                }

                public void setCuredCount(int curedCount) {
                    this.curedCount = curedCount;
                }

                public int getDeadCount() {
                    return deadCount;
                }

                public void setDeadCount(int deadCount) {
                    this.deadCount = deadCount;
                }
            }
        }
    }
}
