package pluginView;

import DAO.CategoryNewsDAO;
import DAO.NewsDAO;
import Model.News;

import java.util.ArrayList;

public class ContentNews {
    public String getContent(String id){
        String result="";
        ArrayList<News> listNews=new NewsDAO().getListNews(id);
        for(News n:listNews){
            result+="                    <div class=\"single-blog-post\">\n" +
                    "                        <h3>"+n.getTitleNews()+"</h3>\n" +
                    "                        <div class=\"post-meta\">\n" +
                    "                            <ul>\n" +
                    "                                <li><i class=\"fa fa-user\">"+n.getPoster()+"</i></li>\n" +
                    "                                <li><i class=\"fa fa-calendar\"></i>"+n.getDate()+"</li>\n" +
                    "                            </ul>\n" +
                    "                            <span>\n" +
                    "\t\t\t\t\t\t\t\t\t<i>Lượt xem: "+n.getView()+"</i>\n" +
                    "\t\t\t\t\t\t\t\t</span>\n" +
                    "                        </div>\n" +
                    "                        <a href=\"\">\n" +
                    "                            <img src=\"../../images/news/"+n.getIDNews()+".jpg\" alt=\"\">\n" +
                    "                        </a>\n" +
                    "                        <p>"+n.getRepresentative()+"</p> <a\n" +
                    "                            class=\"btn btn-primary\" href=\"/PetShop_war/Filter?Type=GetNews&id="+n.getIDNews()+"\">Xem Thêm</a>\n" +
                    "                    </div>\n";
        }
        return result;
    }
    public String getNews(String id){
        String result="";
        News news=NewsDAO.mapNews.get(id);
        result+="                    <div class=\"single-blog-post\">\n" +
                "                        <h2>"+news.getTitleNews()+"</h2>\n" +
                "                        <div class=\"post-meta\">\n" +
                "                            <ul>\n" +
                "                                <li><i class=\"fa fa-user\"></i> "+news.getPoster()+"</li>\n" +
                "                                <li><i class=\"fa fa-calendar\"></i> "+news.getDate()+"</li>\n" +
                "                            </ul>\n" +
                "                            <span>\n" +
                "\t\t\t\t\t\t\t\t\t<i>Lượt xem: "+news.getView()+"</i>\n" +
                "\t\t\t\t\t\t\t\t</span>\n" +
                "                        </div>\n" +
                "                        <a href=\"\">\n" +
                "                            <img src=\"../../images/News/"+news.getIDNews()+".jpg\" alt=\"\">\n" +
                "                        </a>\n" +
                "                        <p>"+news.getContentNews()+"</p>\n" +
                "                    </div>\n";
        return result;
    }
    public String getTitlePage(String id){
        if(id.equals("All")){
            return "Tin tức về thú cưng";
        }
        String result= NewsDAO.mapNews.get(id).getCategoryNews().getNameCategoryNews();
        return result;
    }
}
