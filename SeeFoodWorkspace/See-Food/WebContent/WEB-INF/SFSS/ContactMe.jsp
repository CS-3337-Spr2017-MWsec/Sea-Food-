<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<link href="${pageContext.request.contextPath}/assets/css/bootstrap.css"
	rel="stylesheet" type="text/css" />


<!-- Custom styles for this template -->
<link href="assets/css/main.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="assets/js/hover.zoom.js"></script>
<script src="assets/js/hover.zoom.conf.js"></script>
<title>Contact Me</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="SeeFoodController">SeeFood Service Supreme</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="ProductSelectionController">Market</a></li>
					<li><a href="#">About</a></li>
					<li><a href="ShoppingCartController">Shopping Cart</a></li>
				</ul>
			</div>
		</div>
	</div>




    <div class="container pt">
        <div class="row mt">
            <div class="col-lg-6 col-lg-offset-3 centered">
                 <h3>Problems? Concerns? Comments?<br/>Burning Desires?</h3>
                 <h4>We read'em all!</h4>
               
            </div>
        </div>
        <div class="row mt">
            <div class="col-lg-8 col-lg-offset-2">
                <form role="form">
                    <div class="form-group">
                        <input type="name" class="form-control" id="NameInputEmail1" placeholder="Your Name">
                        <br>
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                        <br>
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" id="subjectEmail1" placeholder="Subject">
                        <br>
                    </div>
                    <textarea class="form-control" rows="6" placeholder="Enter your text here"></textarea>
                    <br>
                    <button type="submit" class="btn btn-success">SUBMIT</button>
                </form>
            </div>
        </div>
        <!-- /row -->
    </div>






	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<h4>My Bunker</h4>
					<p>
						CSULA<br />
					</p>
				</div>

				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a><br /> <a href="#">Twitter</a><br /> <a
							href="#">Facebook</a>
					</p>
				</div>

				<div class="col-lg-4">
					<h4>About See-Food</h4>
					<p>
						Put your heart, mind, and soul into even your smallest acts. This
						is the secret of success.<br />-Swami Sivananda
					</p>
				</div>
			</div>
		</div>
	</div>

	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>