package cn.dawnland.websocketdemo.model.enums;

public enum ResultCode {

    SUCCESS("Success", 0, "成功"),
    FAIL("Fail", 1, "失败"),
    EXCEPTION("Exception", -1, "异常");

    private String code;

    private Integer intCode;

    private String msg;

    ResultCode(String code, Integer intCode, String msg) {
        this.code = code;
        this.intCode = intCode;
        this.msg = msg;
    }

    public Integer getIntCode() {
        return intCode;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
