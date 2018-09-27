/**
 * Copyright (C), 2018-2018,xxx有限公司
 * FileName: UserAction
 * Author: haoc
 * Date: 2018/9/8 16:52
 * Description: useraction
 * History:
 * <author>        <time>        <Version>
 * 作者姓名         修改时间         版本号
 */
package com.csic.bos.web.action;

import com.csic.bos.domain.User;
import com.csic.bos.service.IUserService;
import com.csic.bos.utils.BOSUtils;
import com.csic.bos.web.action.base.BaseAction;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * <一句话功能简述><br>
 * <useraction>
 *
 *@author haoc
 *@date 2018/9/8
 *@since 1.0.0
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {


    /**
     * 属性驱动，接收也i按输入的验证码
     */
    private String checkcode;

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     * @return
     */
    public String login() {

	    //从session中获取生成的验证码
        String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        //校验验证码是否输入正确
        if (StringUtils.isNotBlank(checkcode) &&  checkcode.equals(validatecode)) {
            //输入的验证码正确
            User user = userService.login(model);
            if (user != null) {
                //登录成功，将user对象放入session，跳转到首页
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
                return HOME;
            }else {
                //登录失败，设置提示信息，跳转到登录页面
                //输入的验证码错误，设置提示信息，跳转到登录页面
                this.addActionError("用户名或密码输入错误！");
                return LOGIN;
            }
        }else {
            //输入的验证码错误，设置提示信息，跳转到登录页面
            this.addActionError("输入的验证码错误！");
            return LOGIN;
        }
    }

    /**
     * 用户注销
     */
    public String logout() {
        //销毁session
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }
    /**
     * 修改当前用户的密码
     */
    public String editPassword() throws IOException{
	    String f = "1";
	    //获取当前登录用户
	    User user = BOSUtils.getLoginUser();
	    try{
		    userService.editPassword(user.getId(),model.getPassword());
	    }catch(Exception e){
		    f = "0";
		    e.printStackTrace();
	    }
	    ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
	    ServletActionContext.getResponse().getWriter().print(f);
	    return NONE;
    }
}