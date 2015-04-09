<%@page import="com.lxy.util.StringUtils"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body{
	white-space: nowrap;
}
table{
	border-collapse: collapse;
	font-family: monospace;
}
.dc{
	padding-right: 10px;
	border-right: 1px solid gray;
}
.dc2{
	padding-left: 10px;
}
</style>
<title>Show File</title>
</head>
<body>
	<script type="text/javascript">
		var previous = function(){
			var index = <%=request.getParameter("index")%> || 0;
			location.href = location.href.replace(/index=[0-9]+/g,"index=" + (--index));
		};
		var next = function(){
			var index = <%=request.getParameter("index")%> || 0;
			if( location.href.indexOf( "index=" ) == -1 )
				location.href = location.href + "&index=1";
			else
				location.href = location.href.replace(/index=[0-9]+/g,"index=" + (++index));
		};
	</script>
	<%
		String fileName = request.getParameter("fileName");
		String suffix = request.getParameter("suffix");
		String isx = request.getParameter("index");
		if( isx == null || isx.length() < 1 )
			isx = "0";
		int total = Integer.valueOf( isx );
		String rd = null;
		if( fileName == null ){
			out.println("no filename input!");
		}else if(StringUtils.isEmpty(suffix) 
				|| !("TXT".equals(suffix.trim().toUpperCase())
					|| "LOG".equals(suffix.trim().toUpperCase())
					|| "CSV".equals(suffix.trim().toUpperCase())
					|| "HTML".equals(suffix.trim().toUpperCase())
					|| "HTM".equals(suffix.trim().toUpperCase())
					|| "JSP".equals(suffix.trim().toUpperCase())
					|| "JS".equals(suffix.trim().toUpperCase())
					|| "CSS".equals(suffix.trim().toUpperCase())
					|| "JS".equals(suffix.trim().toUpperCase())
					|| "SQL".equals(suffix.trim().toUpperCase())
				)){
			out.println("no content show");
		}else{
			String path = request.getParameter("filePath");
			java.io.File file = new java.io.File(path + "/" + fileName);
			InputStreamReader reader = new InputStreamReader(new FileInputStream( file ), "UTF-8");
			BufferedReader br = new BufferedReader( reader );
			int ix = 0;
			%>
			<table>
				<tbody>
				
			<%
			while( (rd = br.readLine()) != null){
				if( ix++ < (total * 20000 + 20000) && ix > (total * 20000) ){
					out.print( "<tr><td class='dc'>" + ix + "</td><td class='dc2'>" + rd + "</td></tr>" );
				} else if( ix >= (total * 20000 + 20000) )
					break;
			}
			br.close();
		}
	%></tbody>
			</table><br>
			<button <%=( total <= 0 ? "disabled" : "" ) %> onclick="previous()">前一页</button>&nbsp;&nbsp;&nbsp;<button <%=( rd == null ? "disabled" : "" ) %> onclick="next()">后一页</button>
	</body>
</html>