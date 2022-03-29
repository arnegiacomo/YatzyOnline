<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="refresh" content="3">
<link rel="stylesheet" href="styles.css">
<title>Yatzy</title>
</head>
<body>
	<div class="game">
        
        <h2>Yatzy</h2><br>
        <h5> Spill ID : ${spill.getID()} </h5>
        <p>Admin: ${spill.getAdmin().getBrukernavn()}</p>
        <p>Runder Spilt: ${spill.getRunderSpilt()}</p>
        
        <hr><br>
        
        <button type="submit">Roll Dice</button>
        
        <h4>Click the dice you want to keep</h4>
        
        <img src="img/face1.png">
        <img src="img/face2.png">
        <img src="img/face3.png">
        <img src="img/face4.png">
        <img src="img/face5.png">
        
        
        <table width="482">
        <tbody>
        
        <tr>
        <td width="98"><strong>Players:</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getBrukernavn()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Aces</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getEnere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Twos</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getToere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Threes</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getTrere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Fours</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getFirere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Fives</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getFemmere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Sixes</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSeksere()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>SUM</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSum1()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>BONUS</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getBonus()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>One pair</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get1Par()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Two pair</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get2Par()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>3 of a kind</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get3Like()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>4 of a kind</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().get4Like()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Small straight</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getLiten()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Large straight</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getStor()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Full house</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getHus()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Chance</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSjanse()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td>Yatzy</td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getYatzy()}</td>
        </c:forEach>
        </tr>
        
        <tr>
        <td><strong>TOTAL</strong></td>
        <c:forEach items='${spill.getSpillere()}' var="spiller">
	        <td width="64">${spiller.getTabell().getSum()}</td>
        </c:forEach>
        </tr>
        
        </tbody>
        </table>

        
    </div>
</body>
</html>