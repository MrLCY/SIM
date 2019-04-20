<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%    out.print("<script language='javascript'>if(confirm('您确认要退出系统吗?'))javascript:top.location.href='login.jsp';history.go(-1);</script>");	
      if(session.getAttribute("user")!=null){
        session.removeAttribute("user");
        session.invalidate();	
      }
      if(session.getAttribute("admin")!=null){
        session.removeAttribute("admin");
        session.invalidate();	
      }
      if(session.getAttribute("teacher")!=null){
        session.removeAttribute("teacher");
        session.invalidate();	
      }
%>
