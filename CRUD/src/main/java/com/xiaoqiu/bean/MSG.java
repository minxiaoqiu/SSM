package com.xiaoqiu.bean;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 小邱
 * @version 0.0.1
 * @description MSG
 * @since 2021/10/21 18:47
 */
public class MSG {
    //状态码   200-成功    400-失败
    private int code;
    //提示信息
    private String msg;

    //用户要返回给浏览器的数据
    private Map<String, Object> extend = new HashMap<String, Object>();

    public MSG add(String key, Object value) {
        this.getExtend().put(key,value);
        return this;
    }

    public static MSG success(){
        MSG msg = new MSG();
        msg.setCode(200);
        msg.setMsg("处理成功！");
        return msg;
    }

    public static MSG fail(){
        MSG msg = new MSG();
        msg.setCode(400);
        msg.setMsg("处理失败！");
        return msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}
