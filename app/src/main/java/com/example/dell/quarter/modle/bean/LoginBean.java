package com.example.dell.quarter.modle.bean;

/**
 * Created by dell on 2017/10/19.
 */

public class LoginBean {

    /**
     * code : 200
     * user : {"userHead":"","userId":140,"userPassword":"nyb123","userPhone":"17601627041","userRole":0,"userSignature":"编辑个性签名"}
     */

    private String code;
    private UserBean user;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * userHead :
         * userId : 140
         * userPassword : nyb123
         * userPhone : 17601627041
         * userRole : 0
         * userSignature : 编辑个性签名
         */

        private String userHead;
        private int userId;
        private String userPassword;
        private String userPhone;
        private int userRole;
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

        public int getUserRole() {
            return userRole;
        }

        public void setUserRole(int userRole) {
            this.userRole = userRole;
        }

        public String getUserSignature() {
            return userSignature;
        }

        public void setUserSignature(String userSignature) {
            this.userSignature = userSignature;
        }
    }
}
