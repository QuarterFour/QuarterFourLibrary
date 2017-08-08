package com.a.quarter.model.bean;

import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/7 21
 */

public class MyworksBean {


    /**
     * badKey : FF5Fo5s80afF76o5fs3356f0oss176F7bad
     * badNum : 0
     * commentKey : FF5Fo5s80afF76o5fs3356f0oss176F7comment
     * commentList : [{"commentCharacterPictureMediaId":10,"commentContent":"视频很好看","commentDate":"2017-07-31 10:44:08.0","commentDictionaryValue":1,"commentId":1,"commentPid":0,"commentUserId":32,"nicenum":234,"redisnicekey":"adfaerra","type":0,"user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"}}]
     * commentNum : 0
     * content :
     * description : aaa
     * dictionaryValue : 1
     * forwardKey : FF5Fo5s80afF76o5fs3356f0oss176F7forward
     * forwardNum : 0
     * id : 10
     * name : guo.mp4
     * niceKey : FF5Fo5s80afF76o5fs3356f0oss176F7nice
     * niceNum : 235
     * pictureSrc : http://192.168.1.100/qw.jpeg
     * playTimeKey :
     * playtimes : 0
     * src : http://192.168.1.100/oppo.mp4
     * uptime : 2017-07-26 19:40:26.0
     * user : {"userHead":"","userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男","userSignature":"仇海涛"}
     * userId : 1
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
    private List<CommentListBean> commentList;

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

    public List<CommentListBean> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListBean> commentList) {
        this.commentList = commentList;
    }

    public static class UserBean {
        /**
         * userHead :
         * userId : 1
         * userName : aa
         * userPassword : aaa
         * userPhone : 123456
         * userSex : 男
         * userSignature : 仇海涛
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

    public static class CommentListBean {
        /**
         * commentCharacterPictureMediaId : 10
         * commentContent : 视频很好看
         * commentDate : 2017-07-31 10:44:08.0
         * commentDictionaryValue : 1
         * commentId : 1
         * commentPid : 0
         * commentUserId : 32
         * nicenum : 234
         * redisnicekey : adfaerra
         * type : 0
         * user : {"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男","userSignature":"编辑个性签名"}
         */

        private int commentCharacterPictureMediaId;
        private String commentContent;
        private String commentDate;
        private int commentDictionaryValue;
        private int commentId;
        private int commentPid;
        private int commentUserId;
        private int nicenum;
        private String redisnicekey;
        private int type;
        private UserBeanX user;

        public int getCommentCharacterPictureMediaId() {
            return commentCharacterPictureMediaId;
        }

        public void setCommentCharacterPictureMediaId(int commentCharacterPictureMediaId) {
            this.commentCharacterPictureMediaId = commentCharacterPictureMediaId;
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentDate() {
            return commentDate;
        }

        public void setCommentDate(String commentDate) {
            this.commentDate = commentDate;
        }

        public int getCommentDictionaryValue() {
            return commentDictionaryValue;
        }

        public void setCommentDictionaryValue(int commentDictionaryValue) {
            this.commentDictionaryValue = commentDictionaryValue;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public int getCommentPid() {
            return commentPid;
        }

        public void setCommentPid(int commentPid) {
            this.commentPid = commentPid;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public int getNicenum() {
            return nicenum;
        }

        public void setNicenum(int nicenum) {
            this.nicenum = nicenum;
        }

        public String getRedisnicekey() {
            return redisnicekey;
        }

        public void setRedisnicekey(String redisnicekey) {
            this.redisnicekey = redisnicekey;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public UserBeanX getUser() {
            return user;
        }

        public void setUser(UserBeanX user) {
            this.user = user;
        }

        public static class UserBeanX {
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
