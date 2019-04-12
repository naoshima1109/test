$(function(){

    $("img").hover(
        function(){
            $(this).animate({width:"228px"});
        
        },
        function(){
            $(this).animate({width:"100px"});   
        });
});