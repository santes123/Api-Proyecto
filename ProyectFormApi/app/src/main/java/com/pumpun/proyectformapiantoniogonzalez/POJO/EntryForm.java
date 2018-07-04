package com.pumpun.proyectformapiantoniogonzalez.POJO;


import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntryForm {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("response")
    @Expose
    public Response response;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }


    public static class Entry {

        @SerializedName("1")
        @Expose
        private String _1;
        @SerializedName("2")
        @Expose
        private String _2;
        @SerializedName("3")
        @Expose
        private String _3;
        @SerializedName("4")
        @Expose
        private String _4;
        @SerializedName("5")
        @Expose
        private String _5;
        @SerializedName("6")
        @Expose
        private String _6;
        @SerializedName("7")
        @Expose
        private String _7;
        @SerializedName("8")
        @Expose
        private String _8;
        @SerializedName("9")
        @Expose
        private String _9;
        @SerializedName("10")
        @Expose
        private String _10;
        @SerializedName("11")
        @Expose
        private String _11;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("form_id")
        @Expose
        private String formId;
        @SerializedName("date_created")
        @Expose
        private String dateCreated;
        @SerializedName("is_starred")
        @Expose
        private Integer isStarred;
        @SerializedName("is_read")
        @Expose
        private Integer isRead;
        @SerializedName("ip")
        @Expose
        private String ip;
        @SerializedName("source_url")
        @Expose
        private String sourceUrl;
        @SerializedName("post_id")
        @Expose
        private Object postId;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("payment_status")
        @Expose
        private Object paymentStatus;
        @SerializedName("payment_date")
        @Expose
        private Object paymentDate;
        @SerializedName("transaction_id")
        @Expose
        private Object transactionId;
        @SerializedName("payment_amount")
        @Expose
        private Object paymentAmount;
        @SerializedName("payment_method")
        @Expose
        private Object paymentMethod;
        @SerializedName("is_fulfilled")
        @Expose
        private Object isFulfilled;
        @SerializedName("created_by")
        @Expose
        private String createdBy;
        @SerializedName("transaction_type")
        @Expose
        private Object transactionType;
        @SerializedName("user_agent")
        @Expose
        private String userAgent;
        @SerializedName("status")
        @Expose
        private String status;

        public String get1() {
            return _1;
        }

        public void set1(String _1) {
            this._1 = _1;
        }

        public String get2() {
            return _2;
        }

        public void set2(String _2) {
            this._2 = _2;
        }

        public String get3() {
            return _3;
        }

        public void set3(String _3) {
            this._3 = _3;
        }

        public String get4() {
            return _4;
        }

        public void set4(String _4) {
            this._4 = _4;
        }

        public String get5() {
            return _5;
        }

        public void set5(String _5) {
            this._5 = _5;
        }

        public String get6() {
            return _6;
        }

        public void set6(String _6) {
            this._6 = _6;
        }

        public String get7() {
            return _7;
        }

        public void set7(String _7) {
            this._7 = _7;
        }

        public String get8() {
            return _8;
        }

        public void set8(String _8) {
            this._8 = _8;
        }

        public String get9() {
            return _9;
        }

        public void set9(String _9) {
            this._9 = _9;
        }

        public String get10() {
            return _10;
        }

        public void set10(String _10) {
            this._10 = _10;
        }

        public String get11() {
            return _11;
        }

        public void set11(String _11) {
            this._11 = _11;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFormId() {
            return formId;
        }

        public void setFormId(String formId) {
            this.formId = formId;
        }

        public String getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
        }

        public Integer getIsStarred() {
            return isStarred;
        }

        public void setIsStarred(Integer isStarred) {
            this.isStarred = isStarred;
        }

        public Integer getIsRead() {
            return isRead;
        }

        public void setIsRead(Integer isRead) {
            this.isRead = isRead;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getSourceUrl() {
            return sourceUrl;
        }

        public void setSourceUrl(String sourceUrl) {
            this.sourceUrl = sourceUrl;
        }

        public Object getPostId() {
            return postId;
        }

        public void setPostId(Object postId) {
            this.postId = postId;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Object getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(Object paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public Object getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(Object paymentDate) {
            this.paymentDate = paymentDate;
        }

        public Object getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(Object transactionId) {
            this.transactionId = transactionId;
        }

        public Object getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(Object paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public Object getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(Object paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public Object getIsFulfilled() {
            return isFulfilled;
        }

        public void setIsFulfilled(Object isFulfilled) {
            this.isFulfilled = isFulfilled;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public Object getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(Object transactionType) {
            this.transactionType = transactionType;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }


    public static class Response {

        @SerializedName("total_count")
        @Expose
        private String totalCount;
        @SerializedName("entries")
        @Expose
        public List<Entry> entries = null;

        public String getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

    }

}