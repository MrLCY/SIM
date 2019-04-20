<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html><head>
<base href="<%=basePath%>" target="_self">
<link rel="stylesheet" href="css/comm.css" type="text/css"></link>
<script type="text/javascript">
   function userDetail(file){
	   var o=document.getElementById("detail");
	   var tops=file.offsetTop-80;
	   o.offsetTop=tops;
	   var str=tops+"px;"
	   o.style.visibility="visible"; 
   }
   function closed(){
	    var o=document.getElementById("detail");
	    o.style.visibility="hidden";
   }
   var xmlHttp;
   function createXMLHttpRequest(){
   	if(window.XMLHttpRequest){
   		xmlHttp = new ActiveXObject();
   	}else if(window.ActiveXObject){
   		xmlHttp = new ActiveObject("Microsoft.XMLHTTP");
   	}
   }
   function validate(field){
     if(field.value.length!=0){
     	createXMLHttpRequest();
     	var url="";
     	xmlHttp.open("post",url,true);
     	xmlHttp.onreadystatechange = callback;
     	xmlHttp.send(null);
     }
     }
  function callback(){
   if(xmlHttp.readyState==4){
   	if(xmlHttp.status==200){
   	
   	 document.getElementById("status").innerHTML="<font color='red'>"+xmlHttp.responseText+"</font>";
   	}else{
   	alert("请求失败,status="+xmlHttp.status);
   	}
   }
  }
  
  //判断两次密码是否相同
 function determinePwd(){
 var newpwd = document.getElementById("newpwd").value;
 var renewpwd = document.getElementById("renewpwd").value;
 var oldpwd = document.getElementById("oldpwd").value;
 if(newpwd.length==0||renewpwd.length==0||oldpwd.length==0){
   alert("内容不允许为空");
 }else if(newpwd!=renewpwd){
 	alert("密码不相同，请重新输入！");
 }else{
document.form1.submit();
 }
 }
</script>
</head>
 <body>    <form id="form1" name="form1" action="Admin/adminmanager!updateMyInfo" method="post">
<table width="50%" border="0" align="left" cellpadding="0" cellspacing="0">
<h4 sytle="color: red;"><s:property value="#info"/> </h4>
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1001" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">修改密码</span></td>
        <td width="381" background="images/tab_05.gif"></td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr><tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        <table width="100%" border="0" align="l" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
          <tr>
            <td width="100%" height="26" background="images/tab_14.gif" class="STYLE1" colspan="2"><div align="center" class="STYLE2 STYLE1">请修改自己密码</div></td>
          </tr>
          
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">旧密码</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="password" name="oldPwd" id="oldpwd">
            </div></td>           
    		</tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">新密码</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="password" name="admin.password" id="newpwd">
              </div>
             </td>          
    		</tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">确认新密码</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                    &nbsp;&nbsp;<input type="password" name="confirmNewPwd" id="renewpwd">
              </div>
             </td>          
    		</tr>
    	    <tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
    		    <input type="reset" name="reset" value="重置"/></div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="button" onclick="determinePwd()"  value="保存"/>
                 
              </div>
             </td>          
    		</tr>
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
   
  </tr>
  <tr>
    <td height="29">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"></td>
            <td width="75%" valign="top" class="STYLE1">&quot;<div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle"></td>
                  <td width="50" height="22" valign="middle"></td>
                  <td width="54" height="22" valign="middle"></td>
                  <td width="49" height="22" valign="middle"></td>
                  
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table></form>
  </body>
</html>
