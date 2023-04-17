package com.lanan.gulimallware.constant;

/**
 * @author LanAn
 * @date 2022/8/17-23:22
 */
public class WareConstant {
    /** 采购单状态枚举 */
    public enum PurchaseStatusEnum{
        /**
         * 新建 \已分配 \已领取 \已完成 \有异常
         **/
        CREATED(0,"新建"),ASSIGNED(1,"已分配"),
        RECEIVE(2,"已领取"),FINISH(3,"已完成"),
        HASERROR(4,"有异常");
        private final int code;
        private final String msg;
        PurchaseStatusEnum(int code, String msg){
            this.code = code;
            this.msg = msg;
        }
        public int getCode(){
            return code;
        }
        public String getMsg(){
            return msg;
        }
    }
    /** 采购需求枚举 */
    public enum  PurchaseDetailStatusEnum{
        /**
         * 新建 \已分配 \正在采购 \已完成 \采购失败
         **/
        CREATED(0,"新建"),ASSIGNED(1,"已分配"),
        BUYING(2,"正在采购"),FINISH(3,"已完成"),
        HASERROR(4,"采购失败");
        private final int code;
        private final String msg;

        PurchaseDetailStatusEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
