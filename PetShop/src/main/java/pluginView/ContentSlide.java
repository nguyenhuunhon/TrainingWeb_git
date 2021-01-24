package pluginView;

import DAO.NewsDAO;
import DAO.SliderDAO;
import Model.News;
import Model.Slider;

public class ContentSlide {
    public String getContent(String id){
        String result="";
        Slider sl= SliderDAO.mapSlider.get(id);
        result+="                    <div class=\"single-blog-post\">\n" +
                "                        <h2>"+sl.getTitle()+"</h2>\n" +
                "                        <div class=\"post-meta\">\n" +

                "                            <span>\n" +
                "\t\t\t\t\t\t\t\t</span>\n" +
                "                        </div>\n" +
                "                        <a href=\"\">\n" +
                "                            <img src=\"../../images/Slider/"+sl.getIDSlider()+".jpg\" alt=\"\">\n" +
                "                        </a>\n" +
                "                        <p>"+sl.getDescription()+"</p>\n" +
                "                    </div>\n";
        return result;
    }
}
