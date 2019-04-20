<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html><head>
<base href="<%=basePath%>" target="_self">
<sx:head parseContent="true" extraLocales="utf-8"/>
<link rel="stylesheet" href="css/comm.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
//alert("你好")
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
   
   function load(){
   var v = document.getElementById("studentno").value;
 $("#studentno").load("Student/studentmanager!deajax?student.studentno="+v,function(responseTxt,statusTxt,xhr){
 //alert(" "+xhr.status+": "+xhr.statusText);
 //alert("External content 11!"+responseTxt);
    if(statusTxt=="success")
      //alert("External content loaded successfully!"+responseTxt);
      document.getElementById("status").innerHTML=responseTxt;
    
    if(statusTxt=="error")
      alert("Error: "+xhr.status+": "+xhr.statusText+"======="+responseTxt);
  });
}
</script>

</head>
 <body>   
 <s:fielderror></s:fielderror>
 <s:form action="Teacher/teachermanager!addTeacher" method="post" enctype ="multipart/form-data">  
<table width="50%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1001" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">添加学生信息</span></td>
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
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
          <tr>
            <td width="100%" height="26" background="images/tab_14.gif" class="STYLE1" colspan="2">
                <div align="center" class="STYLE2 STYLE1">请填写教师信息</div>
            </td>
          </tr>
          
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">编号</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<input type="text" onblur="load()" id="studentno" name="teacher.teacherid" ><span id="status"></span>
            </div></td>           
    		</tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">姓名</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="text" name="teacher.realname" value="">
              </div>
             </td>          
    		</tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">用户名</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="text" name="teacher.username" value="">
              </div>
             </td>          
    		</tr>
    		    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">登录密码</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="text" name="teacher.password" value="">
              </div>
             </td>          
    		</tr>
    		
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
    		    <input type="reset" name="reset" value="重置"/></div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<input type="submit" name="submit" value="提交"/>
              </div>
             </td>          
    		</tr>
        </table>
        </td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table>
    </td>
   
  </tr>
  <tr>
    <td height="29">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap"></td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
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
</table>  </s:form>
  </body>
</html>
