<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: -10px;
	margin-right: 0px;
	margin-bottom: 0px; 
}
.STYLE1 {
	color: #43860c;
	font-size: 12px;
}
-->
</style></head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
  <tr>
    <td height="9" style="line-height:9px; background-image:url(../images/main_04.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="97" height="9" background="../images/main_01.gif">&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="47" background="../images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="38" height="47" background="../images/main_06.gif">&nbsp;</td>
        <td width="59"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="29" background="../images/main_07.gif">&nbsp;</td>
          </tr>
          <tr>
            <td height="18" background="../images/main_14.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
              <tr>
                <td  style="width:1px;">&nbsp;</td>
                <td ><span class="STYLE1">admin</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="155" background="../images/main_08.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" valign="bottom"><img src="../images/main_12.gif" width="367" height="23" border="0" usemap="#Map" /></td>
          </tr>
        </table></td>
        <td width="200" background="../images/main_11.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="11%" height="23">&nbsp;</td>
            <td width="89%" valign="bottom"><span class="STYLE1">
            <!--显示时间的div-->
            <SCRIPT language=JavaScript>
			   var 	enabled = 0;   today = new Date();
			   var 	day;   var date;
			   if(today.getDay()==0)     day = "星期日"
			   if(today.getDay()==1)     day = "星期一"
			   if(today.getDay()==2)     day = "星期二"
			   if(today.getDay()==3)     day = "星期三"
			   if(today.getDay()==4)     day = "星期四"
			   if(today.getDay()==5)     day = "星期五"
			   if(today.getDay()==6)     day = "星期六"
			   document.fgColor = "";
			   date1 = "" + (today.getYear()) + "年" + (today.getMonth() + 1 ) + "月" + today.getDate() + "日 " + "";
			   date2 = "" + day + "";
			   document.write("<center>" + date1.fontsize(2) + date2.fontsize(2) + "</center>");
			   </SCRIPT>
           </span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="5" style="line-height:5px; background-image:url(../images/main_18.gif)"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="180" background="../images/main_16.gif"  style="line-height:5px;">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
<map name="Map" id="Map">
<area shape="rect" coords="3,1,49,22" href="center1.jsp" target="_top"/>
<area shape="rect" coords="52,2,95,21" href="javascript:history.go(-1);" />
<area shape="rect" coords="102,2,144,21" href="javascript:history.go(1);" />
<area shape="rect" coords="150,1,197,22" href="" onclick="location.reload()" />
<area shape="rect" coords="210,2,304,20" href="../admin/modifyMyInfo.jsp" target="I1" />
<area shape="rect" coords="314,1,361,23" href="../exit.jsp"/></map></body>
</html>
