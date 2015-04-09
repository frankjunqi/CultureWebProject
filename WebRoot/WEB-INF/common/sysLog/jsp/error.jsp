<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
iframe{
	border-top: 1px dashed;
	border-left: 1px dashed;
	border-left: 1px dashed;
	border-right: 1px dashed;
	border-bottom: 1px dashed;
}
</style>
<title>Log4J</title>
</head>
<body>
	<%
		java.io.File file = new java.io.File("logs");
		java.io.File[] fs = file.listFiles(new java.io.FilenameFilter(){
			public boolean accept(java.io.File dir, String name){
				if( name.matches( "error\\.log" ) ){
					return true;
				}
				return false;
			}
		});
		int i = 0;
	%>
	<b style="font-family: monospace;">Please select log file:&nbsp;&nbsp;&nbsp;</b>
	<select title="Log file name" style="cursor: hand;width : 100px" onchange="showFile(this)">
		<option title="Please Select"></option>
		<%
			for( java.io.File f : fs ){
				%>
				<option title="<%=f.getName() %>" value="<%=f.getName() %>"><%=f.getName() %></option>
				<%
			}
		%>
	</select>
	<script type="text/javascript">
		function showFile(obj){
			if( obj.value )
				document.getElementById("ifm").src="../jsp/showFile.jsp?xxsdepc=" + obj.value + "&date=" + new Date() + "&path=logs";
		}
	</script>
	<br>
	<iframe id="ifm" frameborder="0" style="margin-top: 20px" scrolling="auto" width="100%" height="90%"></iframe>
</body>
</html>