package com.example.trxy.bean;

import java.util.List;

public class MemuOptionsBean {


    /**
     * code : 200
     * message : 获取成功
     * allList : [{"id":1001,"moduleName":"疫情查看","menuList":[{"id":1001,"name":"全国疫情"},{"id":1002,"name":"全球疫情"},{"id":1003,"name":"疫情分布"}]},{"id":1002,"moduleName":"疫情查看","menuList":[{"id":1004,"name":"同程查询"},{"id":1005,"name":"确诊地点"},{"id":1006,"name":"谣言鉴别"}]},{"id":1003,"moduleName":"疫情帮助","menuList":[{"id":1007,"name":"智多星"},{"id":1008,"name":"动态播报"}]},{"id":1004,"moduleName":"生活帮助","menuList":[{"id":1009,"name":"百度一下"},{"id":1010,"name":"丁香园"},{"id":1011,"name":"电费"},{"id":1012,"name":"水费"}]},{"id":1005,"moduleName":"我要缴费","menuList":[{"id":1013,"name":"确诊名人"},{"id":1014,"name":"乐视"},{"id":1015,"name":"旅游"},{"id":1016,"name":"火车票"}]}]
     */

    private String code;
    private String message;
    private List<AllListBean> allList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AllListBean> getAllList() {
        return allList;
    }

    public void setAllList(List<AllListBean> allList) {
        this.allList = allList;
    }

    public static class AllListBean {
        /**
         * id : 1001
         * moduleName : 疫情查看
         * menuList : [{"id":1001,"name":"全国疫情"},{"id":1002,"name":"全球疫情"},{"id":1003,"name":"疫情分布"}]
         */

        private int id;
        private String moduleName;
        private List<MenuListBean> menuList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getModuleName() {
            return moduleName;
        }

        public void setModuleName(String moduleName) {
            this.moduleName = moduleName;
        }

        public List<MenuListBean> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<MenuListBean> menuList) {
            this.menuList = menuList;
        }

        public static class MenuListBean {
            /**
             * id : 1001
             * name : 全国疫情
             */

            private int id;
            private String name;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
