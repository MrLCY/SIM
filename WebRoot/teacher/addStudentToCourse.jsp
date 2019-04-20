<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"  %>
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
   function deleteStudent(id){
   	if(confirm('您确定要删除该条记录吗?')){
     //var pathName = document.location.pathname; 

	//var index = pathName.substr(1).indexOf('/'); 

	//var result = pathName.substr(0,index+1); 
	//alert(pathName+' '+' '+index+' '+result);
    window.location.href = 'Student/studentmanager!deleteStudent?student.id='+id;
    }
   }
</script>
</head>
 <body><!--
 <a href="Student/studentmanager!deleteStudent">删除</a>    
--><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<span style="color:red"><s:property value="#attr.info1"/></span>
  <tr>
    <td height="30">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1001" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">维护学生信息</span></td>
        <td width="381" background="images/tab_05.gif">
        </td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
        <table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98">
        <s:iterator id="stu" var="stu" value="#attr.stulist">
        
          <tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1"><s:property value="#stu.studentno"/></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><s:property value="#stu.realname"/></div></td>            
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><s:property value="#stu.nativeplace"/></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><s:property value="#stu.tel"/></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="Student/studentmanager!getOneStudent?student.id=${stu.id}">查看</a></div></td> 
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="Student/studentmanager!getStudentToUpdate?student.id=${stu.id}">修改</a></div></td> 
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="Course/coursemanager!addStudentToCourse?student.id=${stu.id}">添加到课程班级</a></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="javascript:void(0)" onclick="deleteStudent(${stu.id})">删除</a>
		    </div></td> 
    		</tr>
    		</s:iterator>
          <!--<tr>
            <td width="11%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">学号</div></td>
            <td width="16%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">姓名</div></td>
             <td width="16%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">籍贯</div></td>
            <td width="16%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">电话</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">详细信息</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">操作1</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">操作2</div></td>
            <td width="10%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">操作3</div></td>
          </tr>
          
    		<tr>
    		<td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">20151343001</div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">王光宇</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">山东省牡丹区</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">13061561101</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="./admin/studentInfo.jsp">查看</a></div></td> 
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="./admin/studentModify.jsp">修改</a></div></td> 
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="./admin/studentAdd.jsp">添加</a></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">
            <a href="javascript:if(confirm('您确定要删除该条记录吗?'))">删除</a>
		    </div></td> 
    		</tr>
    	
    		-->
    	
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        
        <td background="images/tab_21.gif">
         
        <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
        
          <tr>
            <td width="25%" height="29" nowrap="nowrap">
            
            <span class="STYLE1"><%--共3条记录，当前第1/2页 --%></span></td>
            <td width="75%" valign="top" class="STYLE1"> 第${pagebean.currentPage }/${pagebean.totalPage }页
            &nbsp;&nbsp;  每页显示${pagebean.pageSize }
           &nbsp;&nbsp;总记录数${pagebean.totalSize }
           &nbsp;&nbsp;<c:if test="${pagebean.currentPage!=1}">
            <a href="Student/studentmanager!getAllStudent?pagebean.currentPage=1">首页</a>|<a href="Student/studentmanager!getAllStudent?pagebean.currentPage=${pagebean.currentPage-1 }">上一页</a>
           </c:if>
           
           &nbsp;&nbsp;<c:if test="${pagebean.currentPage!=pagebean.totalPage}">
            <a href="Student/studentmanager!getAllStudent?pagebean.currentPage=${pagebean.currentPage+1 }">下一页</a>| <a href="Student/studentmanager!getAllStudent?pagebean.currentPage=${pagebean.totalPage}">尾页</a>
           </c:if>
           
           
           <div align="right">
             
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
               <%-- 
                <tr>
                  <td width="62" height="22" valign="middle"><div align="right"><a href="user/user!findAll"><img src="images/first.gif" width="37" height="15" /></a> </div></td>
                  <td width="50" height="22" valign="middle"><div align="right"><a href="user/user?currentPage=0"><img src="images/back.gif" width="43" height="15" /></a></div></td>
                  <td width="54" height="22" valign="middle"><div align="right"><a href="user/user?currentPage=2"><img src="images/next.gif" width="43" height="15" /></a></div></td>
                  <td width="49" height="22" valign="middle"><div align="right"><a href="user/user?currentPage=2"><img src="images/last.gif" width="37" height="15" /></a></div></td>
                  
                </tr>
                 --%>
              </table>             
            </div></td>           
          </tr>
           
        </table>
       
         </td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
