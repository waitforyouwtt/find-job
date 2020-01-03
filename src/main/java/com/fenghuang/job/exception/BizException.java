package com.fenghuang.job.exception;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/1/3 13:52
 * @Email: 15290810931@163.com
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer code;
    /**
     * 错误信息
     */
    protected String msg;

    public BizException() {
        super();
    }

    public BizException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getCode().toString());
        this.code = errorInfoInterface.getCode();
        this.msg = errorInfoInterface.getMsg();
    }

    public BizException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getCode().toString(), cause);
        this.code = errorInfoInterface.getCode();
        this.msg = errorInfoInterface.getMsg();
    }

    public BizException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BizException(Integer code, String msg) {
        super(code.toString());
        this.code = code;
        this.msg = msg;
    }

    public BizException(Integer code, String msg, Throwable cause) {
        super(code.toString(), cause);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
