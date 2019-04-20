package cn.edu.hezeu.jsj.Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac = actionInvocation.getInvocationContext();
		Object flag = null;
		if(ac.getSession().get("admin")!=null){
			flag = ac.getSession().get("admin");
		}else if(ac.getSession().get("teacher")!=null){
			flag = ac.getSession().get("teacher");
		}else if(ac.getSession().get("student")!=null){
			flag = ac.getSession().get("student");
		}
		
		if(flag!=null){
			actionInvocation.invoke();
		}else{
			ac.getSession().put("relog","ÇëµÇÂ¼¡£¡£¡£");
			return "input";
		}
		return null;
	}

}
