package com.example.trxy.bean;

import java.util.List;

public class ChatBean {

    /**
     * code : 410000
     * originquestion : 贵阳
     * chatlogcol : chatlog-mastermind-mastermind-2020-5
     * chatlogid : 5ec49e9dab4b6972f46a3c1d
     * contextid : e6a843c3-a0dd-4a99-acf7-c2d8819f43b1
     * inContext : 0
     * city : 贵阳
     * time : 周三 5月20日
     * minTemp : 19度
     * maxTemp : 28度
     * weather : 阴
     * weatherDescription : 西南风 2
     * currentTemp : 24℃
     * text : 贵阳:周三 5月20日,当前温度24℃,阴 西南风 2,最低气温19度,最高气温28度
     * url : https://news.qq.com/zt2020/page/feiyan.htm?from=timeline
     * repository : repo-glo-pneumonia
     * entitystate : cancel
     * source : tuling
     * image : http://xxx.com/xxx.jpg
     * question :
     * answers : [{"question":"","code":100000,"text":""},{"question":"","code":200000,"url":"","text":""}]
     * emotion : {"robotEmotion":{"a":0,"d":0,"emotionId":0,"p":0},"userEmotion":{"a":0,"d":0,"emotionId":0,"p":0}}
     * intent : {"actionName":"","code":10014,"intentName":""}
     * results : [{"groupType":1,"resultType":"url","values":{"url":"http://m.image.so.com/i?q=%E7%BE%8E%E5%A5%B3"}},{"groupType":1,"resultType":"text","values":{"text":"亲，已帮你找到图片"}}]
     */

    private int code;
    private String originquestion;
    private String chatlogcol;
    private String chatlogid;
    private String contextid;
    private int inContext;
    private String city;
    private String time;
    private String minTemp;
    private String maxTemp;
    private String weather;
    private String weatherDescription;
    private String currentTemp;
    private String text;
    private String url;
    private String repository;
    private String entitystate;
    private String source;
    private String image;
    private String question;
    private EmotionBean emotion;
    private IntentBean intent;
    private List<AnswersBean> answers;
    private List<ResultsBean> results;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getOriginquestion() {
        return originquestion;
    }

    public void setOriginquestion(String originquestion) {
        this.originquestion = originquestion;
    }

    public String getChatlogcol() {
        return chatlogcol;
    }

    public void setChatlogcol(String chatlogcol) {
        this.chatlogcol = chatlogcol;
    }

    public String getChatlogid() {
        return chatlogid;
    }

    public void setChatlogid(String chatlogid) {
        this.chatlogid = chatlogid;
    }

    public String getContextid() {
        return contextid;
    }

    public void setContextid(String contextid) {
        this.contextid = contextid;
    }

    public int getInContext() {
        return inContext;
    }

    public void setInContext(int inContext) {
        this.inContext = inContext;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getEntitystate() {
        return entitystate;
    }

    public void setEntitystate(String entitystate) {
        this.entitystate = entitystate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public EmotionBean getEmotion() {
        return emotion;
    }

    public void setEmotion(EmotionBean emotion) {
        this.emotion = emotion;
    }

    public IntentBean getIntent() {
        return intent;
    }

    public void setIntent(IntentBean intent) {
        this.intent = intent;
    }

    public List<AnswersBean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswersBean> answers) {
        this.answers = answers;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class EmotionBean {
        /**
         * robotEmotion : {"a":0,"d":0,"emotionId":0,"p":0}
         * userEmotion : {"a":0,"d":0,"emotionId":0,"p":0}
         */

        private RobotEmotionBean robotEmotion;
        private UserEmotionBean userEmotion;

        public RobotEmotionBean getRobotEmotion() {
            return robotEmotion;
        }

        public void setRobotEmotion(RobotEmotionBean robotEmotion) {
            this.robotEmotion = robotEmotion;
        }

        public UserEmotionBean getUserEmotion() {
            return userEmotion;
        }

        public void setUserEmotion(UserEmotionBean userEmotion) {
            this.userEmotion = userEmotion;
        }

        public static class RobotEmotionBean {
            /**
             * a : 0
             * d : 0
             * emotionId : 0
             * p : 0
             */

            private int a;
            private int d;
            private int emotionId;
            private int p;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getD() {
                return d;
            }

            public void setD(int d) {
                this.d = d;
            }

            public int getEmotionId() {
                return emotionId;
            }

            public void setEmotionId(int emotionId) {
                this.emotionId = emotionId;
            }

            public int getP() {
                return p;
            }

            public void setP(int p) {
                this.p = p;
            }
        }

        public static class UserEmotionBean {
            /**
             * a : 0
             * d : 0
             * emotionId : 0
             * p : 0
             */

            private int a;
            private int d;
            private int emotionId;
            private int p;

            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            public int getD() {
                return d;
            }

            public void setD(int d) {
                this.d = d;
            }

            public int getEmotionId() {
                return emotionId;
            }

            public void setEmotionId(int emotionId) {
                this.emotionId = emotionId;
            }

            public int getP() {
                return p;
            }

            public void setP(int p) {
                this.p = p;
            }
        }
    }

    public static class IntentBean {
        /**
         * actionName :
         * code : 10014
         * intentName :
         */

        private String actionName;
        private int code;
        private String intentName;

        public String getActionName() {
            return actionName;
        }

        public void setActionName(String actionName) {
            this.actionName = actionName;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getIntentName() {
            return intentName;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }
    }

    public static class AnswersBean {
        /**
         * question :
         * code : 100000
         * text :
         * url :
         */

        private String question;
        private int code;
        private String text;
        private String url;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ResultsBean {
        /**
         * groupType : 1
         * resultType : url
         * values : {"url":"http://m.image.so.com/i?q=%E7%BE%8E%E5%A5%B3"}
         */

        private int groupType;
        private String resultType;
        private ValuesBean values;

        public int getGroupType() {
            return groupType;
        }

        public void setGroupType(int groupType) {
            this.groupType = groupType;
        }

        public String getResultType() {
            return resultType;
        }

        public void setResultType(String resultType) {
            this.resultType = resultType;
        }

        public ValuesBean getValues() {
            return values;
        }

        public void setValues(ValuesBean values) {
            this.values = values;
        }

        public static class ValuesBean {
            /**
             * url : http://m.image.so.com/i?q=%E7%BE%8E%E5%A5%B3
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
