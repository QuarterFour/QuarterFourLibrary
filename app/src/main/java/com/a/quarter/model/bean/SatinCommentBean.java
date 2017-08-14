package com.a.quarter.model.bean;

import java.util.List;

/**
 * 姓名：孙盼盼
 * 时间：2017/8/11
 * 类用途：段子评论数
 * 思路：
 */

public class SatinCommentBean {


    /**
     * timestamp : 1502457832740
     * status : 400
     * error : Bad Request
     * exception : org.springframework.validation.BindException
     * errors : [{"codes":["typeMismatch.comment.commentCharacterPictureMediaId","typeMismatch.commentCharacterPictureMediaId","typeMismatch.int","typeMismatch"],"arguments":[{"codes":["comment.commentCharacterPictureMediaId","commentCharacterPictureMediaId"],"arguments":null,"defaultMessage":"commentCharacterPictureMediaId","code":"commentCharacterPictureMediaId"}],"defaultMessage":"Failed to convert property value of type 'java.lang.String' to required type 'int' for property 'commentCharacterPictureMediaId'; nested exception is java.lang.NumberFormatException: For input string: \"1?commentDictionaryValue=1\"","objectName":"comment","field":"commentCharacterPictureMediaId","rejectedValue":"1?commentDictionaryValue=1","bindingFailure":true,"code":"typeMismatch"}]
     * message : Validation failed for object='comment'. Error count: 1
     * path : /quarter/comment/selectAllComment
     */

    private long timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;
    private List<ErrorsBean> errors;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<ErrorsBean> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorsBean> errors) {
        this.errors = errors;
    }

    public static class ErrorsBean {
        /**
         * codes : ["typeMismatch.comment.commentCharacterPictureMediaId","typeMismatch.commentCharacterPictureMediaId","typeMismatch.int","typeMismatch"]
         * arguments : [{"codes":["comment.commentCharacterPictureMediaId","commentCharacterPictureMediaId"],"arguments":null,"defaultMessage":"commentCharacterPictureMediaId","code":"commentCharacterPictureMediaId"}]
         * defaultMessage : Failed to convert property value of type 'java.lang.String' to required type 'int' for property 'commentCharacterPictureMediaId'; nested exception is java.lang.NumberFormatException: For input string: "1?commentDictionaryValue=1"
         * objectName : comment
         * field : commentCharacterPictureMediaId
         * rejectedValue : 1?commentDictionaryValue=1
         * bindingFailure : true
         * code : typeMismatch
         */

        private String defaultMessage;
        private String objectName;
        private String field;
        private String rejectedValue;
        private boolean bindingFailure;
        private String code;
        private List<String> codes;
        private List<ArgumentsBean> arguments;

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }

        public String getObjectName() {
            return objectName;
        }

        public void setObjectName(String objectName) {
            this.objectName = objectName;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getRejectedValue() {
            return rejectedValue;
        }

        public void setRejectedValue(String rejectedValue) {
            this.rejectedValue = rejectedValue;
        }

        public boolean isBindingFailure() {
            return bindingFailure;
        }

        public void setBindingFailure(boolean bindingFailure) {
            this.bindingFailure = bindingFailure;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public List<String> getCodes() {
            return codes;
        }

        public void setCodes(List<String> codes) {
            this.codes = codes;
        }

        public List<ArgumentsBean> getArguments() {
            return arguments;
        }

        public void setArguments(List<ArgumentsBean> arguments) {
            this.arguments = arguments;
        }

        public static class ArgumentsBean {
            /**
             * codes : ["comment.commentCharacterPictureMediaId","commentCharacterPictureMediaId"]
             * arguments : null
             * defaultMessage : commentCharacterPictureMediaId
             * code : commentCharacterPictureMediaId
             */

            private Object arguments;
            private String defaultMessage;
            private String code;
            private List<String> codes;

            public Object getArguments() {
                return arguments;
            }

            public void setArguments(Object arguments) {
                this.arguments = arguments;
            }

            public String getDefaultMessage() {
                return defaultMessage;
            }

            public void setDefaultMessage(String defaultMessage) {
                this.defaultMessage = defaultMessage;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public List<String> getCodes() {
                return codes;
            }

            public void setCodes(List<String> codes) {
                this.codes = codes;
            }
        }
    }
}
