<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup</title>
</head>

<body>
<h2>Sign Up</h2>
<form:form action="signup" method="post" modelAttribute="uploadBanner" enctype="multipart/form-data" onsubmit="return true;ValidateForm(this,event);">
<input id="SnapHostID" name="SnapHostID" type="hidden" value="JH3LDWRSL3RL" />
<script type="text/javascript">
function ValidateForm(frm,e) {
//if (frm.FirstName.value == "") {alert('First Name is required.');frm.FirstName.focus();return false;}
//if (frm.LastName.value == "") {alert('Last Name is required.');frm.LastName.focus();return false;}
//if (frm.Organization.value == "") {alert('Organization is required.');frm.Organization.focus();return false;}
//if (frm.FromEmailAddress.value == "") {alert('Email address is required.');frm.FromEmailAddress.focus();return false;}
//if (frm.FromEmailAddress.value.indexOf("@") < 1 || frm.FromEmailAddress.value.indexOf(".") < 1) {alert('Please enter a valid email address.');frm.FromEmailAddress.focus();return false;}
//if (frm.StreetAddress1.value == "") {alert('Address is required.');frm.StreetAddress1.focus();return false;}
//if (frm.City.value == "") {alert('City is required.');frm.City.focus();return false;}
//if (frm.Country.value == "") {alert('Country is required.');frm.Country.focus();return false;}
//if (frm.CaptchaCode.value == "") {alert('Enter web form code.');frm.CaptchaCode.focus();return false;}
Form = new FormData();
Form.append("FirstName",$("#FirstName").val());
Form.append("LastName",$("#LastName").val());
Form.append("FromEmailAddress",$("#FromEmailAddress").val());

$.ajax({
	url:'signup',
	method:'POST',
	contentType: false,
	dataType:'json',
	data:Form,
	processData:false,
	success:function(data){
		alert(data.msg);
		Form=new FormData();
	}
})

}
var Form = new FormData();
function triFile(event){
	Form = new FormData();
	console.log(event);
	event.target?Form.append("uploadBanner",event.target.files[0]):'';
}
function ReloadCaptchaImage(captchaImageId) {
var obj = document.getElementById(captchaImageId);
var src = obj.src;
var date = new Date();
var pos = src.indexOf('&rad=');
if (pos >= 0) { src = src.substr(0, pos); }
obj.src = src + '&rad=' + date.getTime();
return false; }
</script>
<table border="0" cellpadding="5" cellspacing="0" width="600">
<tr>
<td><b>First, Last Name*:</b></td>
<td>
<input id="FirstName" name="FirstName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
<input id="LastName" name="LastName" type="text" maxlength="60" style="width:146px; border:1px solid #999999" />
</td>
</tr><tr>
<td><b>Email address*:</b></td>
<td><input id="FromEmailAddress" name="FromEmailAddress" type="text" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
</tr>
<tr>
<td><b>Password*:</b></td>
<td><input id="Organization" name="password" type="password" maxlength="60" style="width:300px; border:1px solid #999999" /></td>
</tr><tr>
<td><b>Banner Image (Allow jpg,png,gif):</b></td>
<td><input id="banner" name="banner" type="file"  style="width:300px; border:1px solid #999999" onchange="triFile(event)" /></td>
</tr><tr>
<td colspan="2" align="center">
<br />
<table border="0" cellpadding="0" cellspacing="0">
<tr valign="top">
<td>
<i>Enter web form code*:</i>
<input id="CaptchaCode" name="CaptchaCode" type="text" style="width:80px; border:1px solid #999999;" maxlength="6" />
</td><td>
<a href="http://www.SnapHost.com"><img id="CaptchaImage" alt="Web Form Code" title="Anti-spam web forms"
style="margin-left:20px; border:1px solid #999999"
src="http://www.SnapHost.com/captcha/WebForm.aspx?id=JH3LDWRSL3RL&ImgType=2" /></a>
<br /><a href="#" onclick="return ReloadCaptchaImage('CaptchaImage');"><span style="font-size:12px;">reload image</span></a>
</td>
</tr>
</table>
<br />
* - required fields. &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<input id="skip_Submit" name="skip_Submit" type="submit" value="Submit" />
</td>
</tr>
</table>
<br />
</form:form>
</body>
</html>