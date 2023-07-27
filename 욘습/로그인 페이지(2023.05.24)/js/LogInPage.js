let flag = 0;


$(".signin").on("click", function(){
  if(flag == 0){
    $(".move").addClass("moving");
    $(".move").removeClass("start");
    
    $(".form").addClass("movingForm");
    $(".form").removeClass("startForm");
    
    $(".hello").show();
    $(".welcome").hide();
    
    
    $(".move").css("background-position", "right");
    
    setTimeout(function(){
      $(".title").text("Match Get It");
      $(".light").text("Or use your email account");
      $(".name").hide();
      $(".p-button").text("회원가입");
      $(".b-button").text("회원가입");
      $(".forgot").show();
      $(".form").css("border-radius","10px 10px 10px 10px");
      $(".move").css("border-radius","10px 10px 10px 10px");
    }, 200);
    
    flag=1;
  }else{
    $(".move").removeClass("moving");
    $(".move").addClass("start");
    
    $(".form").removeClass("movingForm");
    $(".form").addClass("startForm");
    
    
    $(".hello").hide();
    $(".welcome").show();
    
    $(".move").css("background-position", "left");
    
    setTimeout(function(){
      $(".title").text("Create Account");
      $(".light").text("Or use your email for registration");
      $(".name").show();
      $(".p-button").text("로그인");
      $(".b-button").text("로그인");
      $(".forgot").hide();
      $(".form").css("border-radius","10px 10px 10px 10px");
      $(".move").css("border-radius","10px 10px 10px 10px");
    }, 200);
    
    flag=0;
  }
});

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});
