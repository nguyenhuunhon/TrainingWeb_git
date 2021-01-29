package pluginViewAdmin;

public class MoldalDelete {
    public String getModalDelete(String type,String id){
        String result="";
        result+="<div class=\"modal\" id=\"modalDelete"+id+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\n" +
                "     aria-hidden=\"true\">\n" +
                "    <div class=\"modal-dialog\" role=\"document\">\n" +
                "        <div class=\"modal-content\">\n" +
                "            <div class=\"modal-header\">\n" +
                "                <h5 class=\"modal-title\">Thông báo xóa</h5>\n" +
                "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                    <span aria-hidden=\"true\">&times;</span>\n" +
                "                </button>\n" +
                "            </div>\n" +
                "            <div class=\"modal-body\">\n" +
                "                <p>Bạn có chắt muốn xóa mục có mã "+id+".</p><br>\n" +
                "                <p>Lưu ý: Khi đã xóa không thể khôi phục lại dữ liệu.</p>\n" +
                "            </div>\n" +
                "            <div class=\"modal-footer\">\n" +

                "                <form action=\"/PetShop_war/Crud?crud=delete&type="+type+"&id="+id+"\" method=\"POST\">" +
                "                <button type=\"submit\" class=\"btn btn-primary\">Đồng ý xóa</button>\n" +
                "                </form>" +
                "                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Đóng</button>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";
        return result;
    }
}
