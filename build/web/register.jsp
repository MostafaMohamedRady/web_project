<!DOCTYPE html>
        <!--header-->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- grow -->
            <div class="grow">
                <div class="container">
                    <h2>Register</h2>
                </div>
            </div>
            <!-- grow -->
            <!--content-->
            <div class=" container">
                <div class=" register">
                    <form action="RegisterController" method="post">
                        <div class="col-md-6 register-top-grid">
                            <h3>Personal infomation</h3>
                            <div>
                                <span>First Name</span>                       
                                <input type="text" name="userName" id="userName" onblur="checkName()" > 
                                <font color="red" id="error_userName" ></font>
                            </div>
                            <div>
                                <span>Email Address</span>
                                <input type="email" name="userEmail" id="userEmail" onblur="checkEmail()" > 
                                <font color="red" id="error_userEmail" ></font>
                            </div>
                            <div>
                                <span>SSN</span>
                                <input type="text" name="userSsn" id="userSsn" required>
                            </div>
                            <div>
                                <span>Charge</span>
                                <input type="text" name="userCharge" id="userCharge">
                            </div>
                            <a class="news-letter" href="#">
                                <label class="checkbox"><input type="checkbox" checked="" ><i> </i>Sign Up for Newsletter</label>
                            </a>
                        </div>
                        <div class="col-md-6 register-bottom-grid">
                            <h3>Login information</h3>
                            <div>
                                <span>Password</span>
                                <input type="password" name="userPassword" id="userPassword" required>
                            </div>
                            <div>
                                <span>Confirm Password</span>
                                <input type="password" id="userPasswordConfirm" onblur="checkPassword()" required>
                                <font color="red" id="error_userPassword" ></font>
                            </div>


                            <input type="submit" value="submit" id="submitLogin" onclick="return check()">
                        </div>
                        <div class="clearfix"> </div>
                    </form>
                </div>
            </div>
            <!--//content-->
        <jsp:include page="footer.jsp"></jsp:include>


        <script type="text/javascript">

            var flag_userName = 0;
            var flag_userEmail = 0;
            var flag_userSsn = 0;
            var flag_userCharge = 0;
            var flag_userPassword = 0;
            var flag_userPasswordConfirm = 0;
            function checkName()
            {
                var v_name = document.getElementById("userName").value;
                if (v_name == "")
                    document.getElementById("error_userName").innerHTML = "You shoud enter your name";
                else
                    fName = 1;

            }
            function checkEmail()
            {
                var v_email = document.getElementById("userEmail").value;
                var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

                if (!filter.test(userEmail.value)) {
                    document.getElementById("error_userEmail").innerHTML = "Please enter correct e-mail";
                    email.focus;
                }
                else
                    flag_userEmail = 1;
            }
            function checkPassword() {
                var v_password = document.getElementById("userPassword").value;
                var v_passwordConfirm = document.getElementById("userPasswordConfirm").value;
                if (v_password != v_passwordConfirm)
                    document.getElementById("error_userPassword").innerHTML = "Not Matched";
            }
            function check()
            {
                if (fName == 1 && fEmail == 1 && fGender == 1 && fTelephone == 1 && fProduct == 1) {
                    return true;
                }
                else {
                    checkName();
                    checkEmail();
                    checkPassword();

                    return false;
                }
            }
        </script>
    