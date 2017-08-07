package com.a.quarter.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: 陈春晖
 * 时间: 2017/8/2
 * 类的作用:
 * 实现思路:
 */

public class HotBean {

    /**
     * code : 200
     * media : [{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"ggg","mediaPictureSrc":"","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-07-26 19:38:25.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"5Mo25sa66MsF4oaFs7a7o1F1o162a254bad","redisMediaCommentKey":"5Mo25sa66MsF4oaFs7a7o1F1o162a254comment","redisMediaForwardKey":"5Mo25sa66MsF4oaFs7a7o1F1o162a254forward","redisMediaNiceKey":"5Mo25sa66MsF4oaFs7a7o1F1o162a254nice","redisMediaPlaytimesKey":"5Mo25sa66MsF4oaFs7a7o1F1o162a254play","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"aaa","mediaDictionaryValue":1,"mediaForwardNum":200,"mediaName":"guo.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/guo.mp4","mediaUptime":"2017-07-26 19:40:26.0","mediaUserId":1,"niceNum":0,"redisMediaBadKey":"FF5Fo5s80afF76o5fs3356f0oss176F7bad","redisMediaCommentKey":"FF5Fo5s80afF76o5fs3356f0oss176F7comment","redisMediaForwardKey":"FF5Fo5s80afF76o5fs3356f0oss176F7forward","redisMediaNiceKey":"FF5Fo5s80afF76o5fs3356f0oss176F7nice","redisMediaPlaytimesKey":"FF5Fo5s80afF76o5fs3356f0oss176F7play","user":{"userHead":"","userId":1,"userName":"aa","userPassword":"aaa","userPhone":"123456","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"haha","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 10:32:03.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"55MFs5658262oM864M5o35aa88M88aa7bad","redisMediaCommentKey":"55MFs5658262oM864M5o35aa88M88aa7comment","redisMediaForwardKey":"55MFs5658262oM864M5o35aa88M88aa7forward","redisMediaNiceKey":"55MFs5658262oM864M5o35aa88M88aa7nice","redisMediaPlaytimesKey":"55MFs5658262oM864M5o35aa88M88aa7play","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"haha","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 10:51:12.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"58F25F84s7oas1f1ff7ffs865f72505abad","redisMediaCommentKey":"58F25F84s7oas1f1ff7ffs865f72505acomment","redisMediaForwardKey":"58F25F84s7oas1f1ff7ffs865f72505aforward","redisMediaNiceKey":"58F25F84s7oas1f1ff7ffs865f72505anice","redisMediaPlaytimesKey":"58F25F84s7oas1f1ff7ffs865f72505aplay","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"haha","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 11:04:45.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"3fsaF162ooo1s4o74fa663sF8M258FMfbad","redisMediaCommentKey":"3fsaF162ooo1s4o74fa663sF8M258FMfcomment","redisMediaForwardKey":"3fsaF162ooo1s4o74fa663sF8M258FMfforward","redisMediaNiceKey":"3fsaF162ooo1s4o74fa663sF8M258FMfnice","redisMediaPlaytimesKey":"3fsaF162ooo1s4o74fa663sF8M258FMfplay","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"nihaoma","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 11:23:04.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"7s63sas5Maa1f0M44s125ff120411fs6bad","redisMediaCommentKey":"7s63sas5Maa1f0M44s125ff120411fs6comment","redisMediaForwardKey":"7s63sas5Maa1f0M44s125ff120411fs6forward","redisMediaNiceKey":"7s63sas5Maa1f0M44s125ff120411fs6nice","redisMediaPlaytimesKey":"7s63sas5Maa1f0M44s125ff120411fs6play","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"mini","mediaDictionaryValue":1,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/qw.jpeg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 11:51:31.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"f6081s7Fss7s05o7751014a578MoMs52bad","redisMediaCommentKey":"f6081s7Fss7s05o7751014a578MoMs52comment","redisMediaForwardKey":"f6081s7Fss7s05o7751014a578MoMs52forward","redisMediaNiceKey":"f6081s7Fss7s05o7751014a578MoMs52nice","redisMediaPlaytimesKey":"f6081s7Fss7s05o7751014a578MoMs52play","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}},{"list":[],"mediaBadNum":0,"mediaCommentNum":0,"mediaDescription":"上传视频啦","mediaDictionaryValue":2,"mediaForwardNum":0,"mediaName":"jiatao.mp4","mediaPictureSrc":"http://169.254.1.100/1501592731709.jpg","mediaPlaytimes":0,"mediaSrc":"http://169.254.1.100/jiatao.mp4","mediaUptime":"2017-08-01 21:05:31.0","mediaUserId":32,"niceNum":0,"redisMediaBadKey":"f63f20a2ss6oaa88s31ao3asf8a47a72bad","redisMediaCommentKey":"f63f20a2ss6oaa88s31ao3asf8a47a72comment","redisMediaForwardKey":"f63f20a2ss6oaa88s31ao3asf8a47a72forward","redisMediaNiceKey":"f63f20a2ss6oaa88s31ao3asf8a47a72nice","redisMediaPlaytimesKey":"f63f20a2ss6oaa88s31ao3asf8a47a72play","user":{"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}}]
     */

    private String code;
    private List<MediaBean> media;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MediaBean> getMedia() {
        return media;
    }

    public void setMedia(List<MediaBean> media) {
        this.media = media;
    }

    public static class MediaBean implements Serializable{
        /**
         * list : []
         * mediaBadNum : 0
         * mediaCommentNum : 0
         * mediaDescription :
         * mediaDictionaryValue : 1
         * mediaForwardNum : 0
         * mediaName : ggg
         * mediaPictureSrc :
         * mediaPlaytimes : 0
         * mediaSrc : http://169.254.1.100/jiatao.mp4
         * mediaUptime : 2017-07-26 19:38:25.0
         * mediaUserId : 32
         * niceNum : 0
         * redisMediaBadKey : 5Mo25sa66MsF4oaFs7a7o1F1o162a254bad
         * redisMediaCommentKey : 5Mo25sa66MsF4oaFs7a7o1F1o162a254comment
         * redisMediaForwardKey : 5Mo25sa66MsF4oaFs7a7o1F1o162a254forward
         * redisMediaNiceKey : 5Mo25sa66MsF4oaFs7a7o1F1o162a254nice
         * redisMediaPlaytimesKey : 5Mo25sa66MsF4oaFs7a7o1F1o162a254play
         * user : {"userHead":"http://169.254.1.100/ic_ss.jpg","userId":32,"userName":"baobao","userPassword":"123456","userPhone":"13484741060","userSex":"男"}
         */

        private int mediaBadNum;
        private int mediaCommentNum;
        private String mediaDescription;
        private int mediaDictionaryValue;
        private int mediaForwardNum;
        private String mediaName;
        private String mediaPictureSrc;
        private int mediaPlaytimes;
        private String mediaSrc;
        private String mediaUptime;
        private int mediaUserId;
        private int niceNum;
        private String redisMediaBadKey;
        private String redisMediaCommentKey;
        private String redisMediaForwardKey;
        private String redisMediaNiceKey;
        private String redisMediaPlaytimesKey;
        private UserBean user;
        private List<?> list;

        public int getMediaBadNum() {
            return mediaBadNum;
        }

        public void setMediaBadNum(int mediaBadNum) {
            this.mediaBadNum = mediaBadNum;
        }

        public int getMediaCommentNum() {
            return mediaCommentNum;
        }

        public void setMediaCommentNum(int mediaCommentNum) {
            this.mediaCommentNum = mediaCommentNum;
        }

        public String getMediaDescription() {
            return mediaDescription;
        }

        public void setMediaDescription(String mediaDescription) {
            this.mediaDescription = mediaDescription;
        }

        public int getMediaDictionaryValue() {
            return mediaDictionaryValue;
        }

        public void setMediaDictionaryValue(int mediaDictionaryValue) {
            this.mediaDictionaryValue = mediaDictionaryValue;
        }

        public int getMediaForwardNum() {
            return mediaForwardNum;
        }

        public void setMediaForwardNum(int mediaForwardNum) {
            this.mediaForwardNum = mediaForwardNum;
        }

        public String getMediaName() {
            return mediaName;
        }

        public void setMediaName(String mediaName) {
            this.mediaName = mediaName;
        }

        public String getMediaPictureSrc() {
            return mediaPictureSrc;
        }

        public void setMediaPictureSrc(String mediaPictureSrc) {
            this.mediaPictureSrc = mediaPictureSrc;
        }

        public int getMediaPlaytimes() {
            return mediaPlaytimes;
        }

        public void setMediaPlaytimes(int mediaPlaytimes) {
            this.mediaPlaytimes = mediaPlaytimes;
        }

        public String getMediaSrc() {
            return mediaSrc;
        }

        public void setMediaSrc(String mediaSrc) {
            this.mediaSrc = mediaSrc;
        }

        public String getMediaUptime() {
            return mediaUptime;
        }

        public void setMediaUptime(String mediaUptime) {
            this.mediaUptime = mediaUptime;
        }

        public int getMediaUserId() {
            return mediaUserId;
        }

        public void setMediaUserId(int mediaUserId) {
            this.mediaUserId = mediaUserId;
        }

        public int getNiceNum() {
            return niceNum;
        }

        public void setNiceNum(int niceNum) {
            this.niceNum = niceNum;
        }

        public String getRedisMediaBadKey() {
            return redisMediaBadKey;
        }

        public void setRedisMediaBadKey(String redisMediaBadKey) {
            this.redisMediaBadKey = redisMediaBadKey;
        }

        public String getRedisMediaCommentKey() {
            return redisMediaCommentKey;
        }

        public void setRedisMediaCommentKey(String redisMediaCommentKey) {
            this.redisMediaCommentKey = redisMediaCommentKey;
        }

        public String getRedisMediaForwardKey() {
            return redisMediaForwardKey;
        }

        public void setRedisMediaForwardKey(String redisMediaForwardKey) {
            this.redisMediaForwardKey = redisMediaForwardKey;
        }

        public String getRedisMediaNiceKey() {
            return redisMediaNiceKey;
        }

        public void setRedisMediaNiceKey(String redisMediaNiceKey) {
            this.redisMediaNiceKey = redisMediaNiceKey;
        }

        public String getRedisMediaPlaytimesKey() {
            return redisMediaPlaytimesKey;
        }

        public void setRedisMediaPlaytimesKey(String redisMediaPlaytimesKey) {
            this.redisMediaPlaytimesKey = redisMediaPlaytimesKey;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public static class UserBean {
            /**
             * userHead : http://169.254.1.100/ic_ss.jpg
             * userId : 32
             * userName : baobao
             * userPassword : 123456
             * userPhone : 13484741060
             * userSex : 男
             */

            private String userHead;
            private int userId;
            private String userName;
            private String userPassword;
            private String userPhone;
            private String userSex;

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
        }
    }
}
