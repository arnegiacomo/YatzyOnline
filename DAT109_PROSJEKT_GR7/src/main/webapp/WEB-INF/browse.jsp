<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
<title>Browse</title>
</head>
<body>
	<div class="browser">
        
        <h2>Join or create a game</h2><br>
        
        <hr><br>
        
        <table>
        
       		 <c:forEach items='${requestScope["spill"]}' var="spill">
       		 
	        	<tr class="browserUnit">
		        	<td>
		        		<h3> Spill ID : ${spill.getID()} </h3>
		        		
		            	<p>Players: ${spill.getSpillere().size()}/6</p>
		            
		            	<button type="submit">Join game</button>
		            
		            	<button type="submit">Spectate game</button>
		        	</td>
	        	</tr>
	        	
        	</c:forEach>
        </table>

        <button type="submit">New game</button>
        
        
        
    </div>
</body>
</html>