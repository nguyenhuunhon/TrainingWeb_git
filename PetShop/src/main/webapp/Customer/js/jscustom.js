$(document).ready(function () {

    var searchBox = document.querySelector('.search_box');
    var headerBottom = document.querySelector('.header-bottom');
    var showSearch = document.querySelector('#eventSearch #showSearch');
    var closeSearch = document.querySelector('#eventSearch #closeSearch');
    var eventSearch = document.querySelector('#eventSearch');
    var check = false;
    eventSearch.addEventListener('click', () => {
        if (check == false) {
            searchBox.style.display = 'block';
            headerBottom.style.display = 'none';
            showSearch.style.display = 'none';
            closeSearch.style.display = 'block';
            document.querySelector('.search_box input').focus();
            check = true;
        } else {
            searchBox.style.display = 'none';
            headerBottom.style.display = 'block';
            closeSearch.style.display = 'none';
            showSearch.style.display = 'block';
            check = false;
        }
    });

    $('#BTBars').click(function (event) {
        $('#menuMB').addClass('in');
    });

    $('#menuMB #Close').click(function (event) {
        $('#menuMB').removeClass('in');
    });

    var showSubmenu = document.querySelectorAll(".showSubmenu .drop");
    var contenSubmenu = document.querySelectorAll(".showSubmenu .contenSubmenu");
    var checkP = false;
    for (let i = 0; i < showSubmenu.length; i++) {
        showSubmenu[i].addEventListener("click", () => {
            if (checkP == false) {
                contenSubmenu[i].style.height = "auto";
                var height = contenSubmenu[i].offsetHeight;
                contenSubmenu[i].style.height = "0px";
                contenSubmenu[i].style.height = height + "px";
                checkP = true;
            } else {
                contenSubmenu[i].style.height = "0px";
                checkP = false;
            }
        });
    }


    var ups = document.querySelectorAll('.cart_quantity_up');
    var updateAmount = document.querySelectorAll('.cart_quantity_input');
    var downs = document.querySelectorAll('.cart_quantity_down');
    for (let i = 0; i < ups.length; i++) {
        ups[i].addEventListener('click', () => {
            var quanUp = parseInt(updateAmount[i].value) + 1;
            updateAmount[i].value = quanUp;
        })
        downs[i].addEventListener('click', () => {
            var quanDow = parseInt(updateAmount[i].value) - 1;
            updateAmount[i].value = quanDow;
        })
    }
    $('.cart').click(function () {
        var id = $(this).data('id');
        var amount=document.querySelector("#amountPro").value;
        $.ajax({
            type: 'POST',
            data: {
                id: id,
                amount:amount
            },
            url: '/PetShop_war/AddItemCart',
            success: function (data) {
                swal({
                        title: "Đã thêm vào giỏ hàng",
                        text: "Bạn có thể mua hàng tiếp tục tới giỏ hàng để đặt hàng",
                        showCancelButton: true,
                        cancelButtonText: "xem tiếp",
                        confirmButtonClass: "btn-success",
                        confirmButtonText: "Đi đến giỏ hàng",
                        closeOnConfirm: false

                    },
                    function () {
                        window.location.href = "/PetShop_war/Cart";
                    }
                );
            }
        });
    });
    $('.add-to-cart').click(function () {
        var id = $(this).data('id');
        $.ajax({
            type: 'POST',
            data: {
                id: id,
            },
            url: '/PetShop_war/AddItemCart',
            success: function (data) {
                swal({
                        title: "Đã thêm vào giỏ hàng",
                        text: "Bạn có thể mua hàng tiếp tục tới giỏ hàng để đặt hàng",
                        showCancelButton: true,
                        cancelButtonText: "xem tiếp",
                        confirmButtonClass: "btn-success",
                        confirmButtonText: "Đi đến giỏ hàng",
                        closeOnConfirm: false

                    },
                    function () {
                        window.location.href = "/PetShop_war/Cart";
                    }
                );
            }
        });
    });




    // $(".buttonSearch").click(function () {
    //     var ser = document.querySelector(" .inpSearch");
    //     var valSer = ser.value;
    //     var valEdit = valSer.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
    //     document.querySelector(".inpSearch").value = valEdit;
    // });


});
