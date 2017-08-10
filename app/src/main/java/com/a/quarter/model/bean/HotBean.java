package com.a.quarter.model.bean;

import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/28 10
 */

public class HotBean {


    /**
     * code : 200
     * resource : [{"badKey":"55MFs5658262oM864M5o35aa88M88aa7bad","badNum":0,"commentKey":"55MFs5658262oM864M5o35aa88M88aa7comment","commentList":[],"commentNum":0,"content":"","description":"haha","dictionaryValue":"1","forwardKey":"55MFs5658262oM864M5o35aa88M88aa7forward","forwardNum":0,"id":11,"name":"jiatao.mp4","niceKey":"55MFs5658262oM864M5o35aa88M88aa7nice","niceNum":285,"pictureSrc":"http://192.168.1.100/qw.jpeg","playTimeKey":"","playtimes":"0","src":"http://192.168.1.100/jiatao.mp4","uptime":"2017-08-01 10:32:03.0","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"},"userId":32},{"badKey":"FF5Fo5s80afF76o5fs3356f0oss176F7bad","badNum":0,"commentKey":"FF5Fo5s80afF76o5fs3356f0oss176F7comment","commentList":[{"commentCharacterPictureMediaId":10,"commentContent":"视频很好看","commentDate":"2017-07-31 10:44:08.0","commentDictionaryValue":1,"commentId":1,"commentPid":0,"commentUserId":32,"nicenum":234,"redisnicekey":"adfaerra","type":0,"user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"}}],"commentNum":0,"content":"","description":"aaa","dictionaryValue":"1","forwardKey":"FF5Fo5s80afF76o5fs3356f0oss176F7forward","forwardNum":0,"id":10,"name":"guo.mp4","niceKey":"FF5Fo5s80afF76o5fs3356f0oss176F7nice","niceNum":235,"pictureSrc":"http://192.168.1.100/qw.jpeg","playTimeKey":"","playtimes":"0","src":"http://192.168.1.100/oppo.mp4","uptime":"2017-07-26 19:40:26.0","user":{"userHead":"","userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男","userSignature":"仇海涛"},"userId":1},{"badKey":"0o8F571ssoM7ss70287183oo75s82s6o","badNum":0,"commentKey":"0o8F571ssoM7ss70287183oo75s82s6o","commentList":[],"commentNum":0,"content":"高考前一天的晚上我妈帮我减压：\u201c放轻松，别给自己太大的压力，考差了又怎么样，不能读好的大学又怎么样呢?大不了我没你这个儿子。\u201d","description":"","dictionaryValue":"2","forwardKey":"787777Ms4F07607f70o05s5Ms352fF43","forwardNum":0,"id":1,"name":"","niceKey":"787777Ms4F07607f70o05s5Ms352fF43","niceNum":546,"pictureSrc":"","playTimeKey":"","playtimes":"","src":"","uptime":"2017-07-20 21:56:33.0","user":{"userHead":"","userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男","userSignature":"仇海涛"},"userId":1},{"badKey":"0o8F571ssoM7ss70287183o","badNum":0,"commentKey":"0o8F571ssoM7ss70287183oo","commentList":[],"commentNum":0,"content":"很多考生有考前焦虑，影响发挥，最简单的方法就是心理暗示法：考前大声诵读\u201c我一定能考好\u201d、\u201c我对自己充满信心\u201d或者\u201c条条道路通蓝翔\u201d、\u201c大不了去新东方\u201d用以缓解压力，鼓舞斗志，发挥水平。","description":"","dictionaryValue":"2","forwardKey":"787777Ms4F07607","forwardNum":0,"id":2,"name":"","niceKey":"787777Ms4F07607f70o05s5Ms","niceNum":756,"pictureSrc":"","playTimeKey":"","playtimes":"","src":"","uptime":"2017-07-15 22:25:17.0","user":{"userHead":"","userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男","userSignature":"仇海涛"},"userId":1},{"badKey":"3fsaF162ooo1s4o74fa663sF8M258FMfbad","badNum":0,"commentKey":"3fsaF162ooo1s4o74fa663sF8M258FMfcomment","commentList":[],"commentNum":0,"content":"","description":"haha","dictionaryValue":"1","forwardKey":"3fsaF162ooo1s4o74fa663sF8M258FMfforward","forwardNum":0,"id":13,"name":"jiatao.mp4","niceKey":"3fsaF162ooo1s4o74fa663sF8M258FMfnice","niceNum":685,"pictureSrc":"http://192.168.1.100/qw.jpeg","playTimeKey":"","playtimes":"0","src":"http://192.168.1.100/oppo.mp4","uptime":"2017-08-01 11:04:45.0","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"},"userId":32}]
     */

    private String code;
    private List<ResourceBean> resource;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ResourceBean> getResource() {
        return resource;
    }

    public void setResource(List<ResourceBean> resource) {
        this.resource = resource;
    }

    public static class ResourceBean {
        /**
         * badKey : 55MFs5658262oM864M5o35aa88M88aa7bad
         * badNum : 0
         * commentKey : 55MFs5658262oM864M5o35aa88M88aa7comment
         * commentList : []
         * commentNum : 0
         * content :
         * description : haha
         * dictionaryValue : 1
         * forwardKey : 55MFs5658262oM864M5o35aa88M88aa7forward
         * forwardNum : 0
         * id : 11
         * name : jiatao.mp4
         * niceKey : 55MFs5658262oM864M5o35aa88M88aa7nice
         * niceNum : 285
         * pictureSrc : http://192.168.1.100/qw.jpeg
         * playTimeKey :
         * playtimes : 0
         * src : http://192.168.1.100/jiatao.mp4
         * uptime : 2017-08-01 10:32:03.0
         * user : {"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"}
         * userId : 32
         */

        private String badKey;
        private int badNum;
        private String commentKey;
        private int commentNum;
        private String content;
        private String description;
        private String dictionaryValue;
        private String forwardKey;
        private int forwardNum;
        private int id;
        private String name;
        private String niceKey;
        private int niceNum;
        private String pictureSrc;
        private String playTimeKey;
        private String playtimes;
        private String src;
        private String uptime;
        private UserBean user;
        private int userId;
        private List<?> commentList;

        public String getBadKey() {
            return badKey;
        }

        public void setBadKey(String badKey) {
            this.badKey = badKey;
        }

        public int getBadNum() {
            return badNum;
        }

        public void setBadNum(int badNum) {
            this.badNum = badNum;
        }

        public String getCommentKey() {
            return commentKey;
        }

        public void setCommentKey(String commentKey) {
            this.commentKey = commentKey;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDictionaryValue() {
            return dictionaryValue;
        }

        public void setDictionaryValue(String dictionaryValue) {
            this.dictionaryValue = dictionaryValue;
        }

        public String getForwardKey() {
            return forwardKey;
        }

        public void setForwardKey(String forwardKey) {
            this.forwardKey = forwardKey;
        }

        public int getForwardNum() {
            return forwardNum;
        }

        public void setForwardNum(int forwardNum) {
            this.forwardNum = forwardNum;
        }

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

        public String getNiceKey() {
            return niceKey;
        }

        public void setNiceKey(String niceKey) {
            this.niceKey = niceKey;
        }

        public int getNiceNum() {
            return niceNum;
        }

        public void setNiceNum(int niceNum) {
            this.niceNum = niceNum;
        }

        public String getPictureSrc() {
            return pictureSrc;
        }

        public void setPictureSrc(String pictureSrc) {
            this.pictureSrc = pictureSrc;
        }

        public String getPlayTimeKey() {
            return playTimeKey;
        }

        public void setPlayTimeKey(String playTimeKey) {
            this.playTimeKey = playTimeKey;
        }

        public String getPlaytimes() {
            return playtimes;
        }

        public void setPlaytimes(String playtimes) {
            this.playtimes = playtimes;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getUptime() {
            return uptime;
        }

        public void setUptime(String uptime) {
            this.uptime = uptime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<?> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<?> commentList) {
            this.commentList = commentList;
        }

        public static class UserBean {
            /**
             * userHead : http://169.254.1.100/ic_ss.jpg
             * userId : 32
             * userName : baobao
             * userPassword : 123456
             * userPhone : 13484741060
             * userSex : 男
             * userSignature : 编辑个性签名
             */

            private String userHead;
            private int userId;
            private String userName;
            private String userPassword;
            private String userPhone;
            private String userSex;
            private String userSignature;

            public String getUserHead() {
                return userHead;
            }

            public void setUserHead(String userHead) {
                this.userHead = userHead;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPassword() {
                return userPassword;
            }

            public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserSex() {
                return userSex;
            }

            public void setUserSex(String userSex) {
                this.userSex = userSex;
            }

            public String getUserSignature() {
                return userSignature;
            }

            public void setUserSignature(String userSignature) {
                this.userSignature = userSignature;
            }
        }
    }
}
