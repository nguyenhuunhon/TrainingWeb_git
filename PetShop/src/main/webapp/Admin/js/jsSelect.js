$(document).ready(function() {

        $('#selectObjectPro').change(function (){
                $('#selectCategoryPro').find('option').remove();
                $('#selectCategoryPro').append('<option selected disabled hidden>Chọn thể loại</option>');
                $('#selectPortfolioPro').find('option').remove();
                $('#selectPortfolioPro').append('<option selected disabled hidden>Chọn danh mục</option>');
                let ObId=$('#selectObjectPro').val();
                let data={
                        type:"category",
                        id:ObId
                };
                $.ajax({
                        url:"/PetShop_war/Select",
                        method:"GET",
                        data:data,
                        success:function (data,textStatus,jqXHR){
                                console.log(data);
                                let obj=$.parseJSON(data);
                                $.each(obj,function (key,value){
                                        $('#selectCategoryPro').append('<option value="'+value.IDCategoryProduct+'">'+value.nameCategoryProduct+'</option>')
                                });
                        },
                        error:function (jqXHR,textStatus,errorThown){
                                $('#selectCategoryPro').append('<option>Thể loại không tồn tại</option>');
                        },
                        cache:false

                });
        });
        $('#selectCategoryPro').change(function (){
                $('#selectPortfolioPro').find('option').remove();
                $('#selectPortfolioPro').append('<option selected disabled hidden>Chọn thể loại</option>');
                let CaId=$('#selectCategoryPro').val();
                let data={
                        type:"portfolio",
                        id:CaId
                };
                $.ajax({
                        url:"/PetShop_war/Select",
                        method:"GET",
                        data:data,
                        success:function (data,textStatus,jqXHR){
                                console.log(data);
                                let obj=$.parseJSON(data);
                                $.each(obj,function (key,value){
                                        $('#selectPortfolioPro').append('<option value="'+value.IDPortfolioProduct+'">'+value.namePortfolioProduct+'</option>')
                                });
                        },
                        error:function (jqXHR,textStatus,errorThown){
                                $('#selectPortfolioPro').append('<option>Danh mục không tồn tại</option>');
                        },
                        cache:false

                });
        });

});
