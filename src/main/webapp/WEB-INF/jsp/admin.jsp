<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Admin</title>
        <jsp:directive.include file="commonHeaders.jsp" />
        <script src="webjars/chartjs/3.7.1/dist/chart.js"></script>
        <script src="webjars/momentjs/2.29.1/min/moment.min.js"></script>
	</head>
	<body>
		<div id="header">
			<h1>Admin</h1>
		</div>
		
		<canvas id="daily-stats-chart" width="100" height="20"></canvas>
		<script>
			const ctx = document.getElementById('daily-stats-chart').getContext('2d');
			const myChart = new Chart(ctx, {
			    type: 'line',
			    options: {
			    	scales: {
			    		y: {
			    			min: 0
			    		}
			    	}
			    }
			});
			
		    jQuery.ajax({
		        url: '/admin/dailystats',
		        success: function(result) {
		        	myChart.data = result;
		        	myChart.update();
		        }
		    });
		</script>
		
		
        <form action="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout"/>
        </form>		
	</body>
</html>
