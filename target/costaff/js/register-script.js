$(document).ready(function(){
	$("#success").hide();
	$("#error").hide();
    $("#regFrom").validate({
        rules: {
        	fullName :{
        		required : true,
        		minlength : 10
        	},
        	userName :{
        		required : true,
        		minlength : 5,
        		maxlength : 10
        	},
        	email :{
        		required : true,
        		email : true,
        	},
        	phoneNumber :{
        		required : true,
        		number : true,
        		minlength : 10,
        		maxlength : 10
        	},
        	password :{
        		required : true,
        		minlength : 5,
        	},
        	confirmPassword :{
        		required : true,
        		equalTo: "#password"
        	},
        },
        messages: {
        	fullName: {
				required: "Please enter a fullname",
				minlength : "Fullname should have at least 10 charactors",
			},
			userName: {
				required: "Please enter a userName",
				minlength : "UserName should have at least 5 charactors",
				maxlength : "UserName should have max 10 charactors",
			},
			email: {
				required: "Please enter a email",
				email : "Invalid email address",
			},
			phoneNumber: {
				required: "Please enter a phone number",
				number: "Phone Number should have digits only",
				minlength : "Phone Number should have at least 10 charactors",
				maxlength : "Phone Number should have max 10 charactors",
			},
			password: {
				required: "Please enter a password",
				minlength : "Password should have at least 5 charactors",
			},
			confirmPassword :{
				required: "Please enter a confirm password",
				equalTo : "Confirm Password should match with password"
			}
        }
    });
    
});

function validateForm(){
	$("#success").hide();
	$("#error").hide();
    if($("#regFrom").valid()){
    	$.post( "registration",$("#regFrom").serialize(), function( data ) {
    		let restult=JSON.parse(data);
    		if(restult.success!=undefined){
    			$("#success").show();
    			$("#success").html(restult.success);
    			
    		}else{
    			$("#error").show();
    			$("#error").html(restult.error);
    		}
		});
    }else{
        return false;
    }
}