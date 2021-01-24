package Model;

import java.util.Date;

public class News {
    private String IDNews;
    private String titleNews;
    private String contentNews;
    private CategoryNews categoryNews;
    private Date date;
    private int view;
    private String poster;

    public News(String IDNews, String titleNews, String contentNews, CategoryNews categoryNews, Date date, int view,String poster) {
        this.IDNews = IDNews;
        this.titleNews = titleNews;
        this.contentNews = contentNews;
        this.categoryNews = categoryNews;
        this.date = date;
        this.view = view;
        this.poster=poster;
    }

    public String getIDNews() {
        return IDNews;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public CategoryNews getCategoryNews() {
        return categoryNews;
    }

    public Date getDate() {
        return date;
    }

    public int getView() {
        return view;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPoster() {
        return poster;
    }
    public String getRepresentative(){
        return String.copyValueOf(this.contentNews.toCharArray(),0,400)+".....";
    }
}
