window.onload = function () {
    var ContentHeadRight = document.querySelectorAll(".header .right div ul");
    var BtHeadRight = document.querySelectorAll(".header .right div button");
    var checkH = false;
    for (let i = 0; i < BtHeadRight.length; i++) {
        BtHeadRight[i].addEventListener("click", () => {
            ContentHeadRight.forEach(e => {
                e.style.display = "none";
            });
            if (checkH == false) {
                ContentHeadRight[i].style.display = "block";
                ContentHeadRight[i].style.zindex ="5";
                checkH=true;
            } else {
                ContentHeadRight[i].style.display = "none";
                checkH=false
            }
        });
    }




    var product=document.querySelector(".product");
    var powerProduct=document.querySelector(".product .powerProduct");
    var checkP=false;
    product.addEventListener("click",()=>{
        if(checkP==false){
            product.style.height="200px";
            powerProduct.style.height="150px";
            checkP=true;
        }else{
            product.style.height="50px";
            powerProduct.style.height="0px";
            checkP=false;
        }
    })
    var portfioloProduct=document.querySelector(".portfioloProduct");
    var powerPortfioloProduct=document.querySelector(".portfioloProduct .powerPortfioloProduct");
    var checkPP=false;
    portfioloProduct.addEventListener("click",()=>{
        if(checkPP==false){
            portfioloProduct.style.height="200px";
            powerPortfioloProduct.style.height="150px";
            checkPP=true;
        }else{
            portfioloProduct.style.height="50px";
            powerPortfioloProduct.style.height="0px";
            checkPP=false;
        }
    });

}
