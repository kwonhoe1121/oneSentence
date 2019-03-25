<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
String searchValue = request.getParameter("query");
JSONArray arrayObj=new JSONArray();
JSONObject jsonObj = null;

List<ShowOnesentence> oneSentenceList = new ArrayList<ShowOnesentence>();
List<String> resultlist = new ArrayList<String>();

oneSentenceList.add(sentence);	

     for(String str : oneSentenceList {
      if(str.toLowerCase().startsWith(searchValue)) {
       resultlist.add(str);
        } 
       } 
//뽑은 후 json파싱
for(String str : resultlist) { 
	jsonObj = new JSONObject(); 
	jsonObj.put("data", str);
	arrayObj.add(jsonObj);
		} PrintWriter pw = response.getWriter();
		 pw.print(arrayObj);
		 pw.flush(); 
		 pw.close();

</body>
</html>