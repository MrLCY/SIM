<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
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
</script>
</head>
 <body>    
<table width="50%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1001" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">查看学生信息</span></td>
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
            <td height="26" background="images/tab_14.gif" class="STYLE1" colspan="3"><div align="center" class="STYLE2 STYLE1">学生详细信息</div></td>
          </tr>          
         
    		<tr>
    		<td width="32%" height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">学号 </div></td>
            <td width="45%" height="18" bgcolor="#FFFFFF" class="STYLE2">
            <div align="left" class="STYLE2 STYLE1">
                &nbsp;&nbsp;<s:property value="#student.studentno"/>      </div></td>    
            <td rowspan="6"><img  src="File/<s:property value='#student.image'/>" width="130" height="135"></td>        
    		</tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">姓名</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<s:property value="#student.realname"/>             </div>             </td> 
             </tr>
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">籍贯</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<s:property value="#student.nativeplace"/>              </div>             </td>
             </tr>    
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">出生日期</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<s:property value="#student.birthday"/>           </div>             </td> 
            </tr> 
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">信箱</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<s:property value="#student.email"/>              </div>             </td>  
              </tr> 
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF" ><div align="center" class="STYLE1">电话</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;<s:property value="#student.tel"/>               </div>             </td>    
              </tr>   
    		<tr>
    		 <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">其它...</div></td>
             <td height="18" bgcolor="#FFFFFF" class="STYLE2" colspan="2">
              <div align="left" class="STYLE2 STYLE1">
                 &nbsp;&nbsp;可自己扩展              </div>             </td>          
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
</table>
  </body>
</html>
