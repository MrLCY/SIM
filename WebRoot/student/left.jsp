<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/dtree.css" type="text/css"></link>
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
<script type="text/javascript" src="js/dtree.js"></script>
<style type="text/css"> 
.STYLE2 {font-size: 14px}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.dtree a 
{
	font-size: 14px;
}
p{
   font-size: 14px;
   line-height:16px
}
 
</style>
</head>
 
<body>
<table width="177" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="173" border="0" cellspacing="0" cellpadding="0" style="table-layout: fixed;" height="87">
      <tr>
        <td height="26" background="images/main_21.gif">&nbsp;</td>
      </tr>      
      <tr>
        <td  style="line-height:4px; background:url(images/main_38.gif)"></td>
      </tr>
      <tr>
        <td>
        <div class="dtree">
        	 <p><a href="javascript: d.openAll();">打开所有</a>|<a href="javascript: d.closeAll();">关闭所有</a></p>					
				<p>
				<script type="text/javascript">					
					d = new dTree('d');
					d.add(0,-1,'管理选项');	
					
					d.add(1,0,'个人信息','','I1','I1');
					d.add(11,1,'查看个人信息','Admin/adminmanager!seePersonInfo','I1','I1');
					d.add(12,1,'修改个人信息','Admin/adminmanager!getMyInfoToUpdate','I1','I1');
					d.add(13,1,'修改密码','admin/modifyMyPwd.jsp','I1','I1');					
										
					d.add(2,0,'课程管理','','I1','I1');
					d.add(21,2,'已选课程','Student/studentmanager!getHasSelectedCourseByStudent','I1','I1');
					d.add(22,2,'未选课程','Student/studentmanager!getNoSelectedCourseByStudent','I1','I1');
					
					d.add(10,0,'退出系统','exit.jsp','I1','I1');
					document.write(d);
				</script>
				</p>
			</div>	
        </td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>