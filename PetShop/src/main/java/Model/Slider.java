package Model;

public class Slider {
    private String IDSlider;
    private String title;
    private String description;

    public Slider(String IDSlider, String title, String description) {
        this.IDSlider = IDSlider;
        this.title = title;
        this.description = description;
    }

    public String getIDSlider() {
        return IDSlider;
    }

    public void setIDSlider(String IDSlider) {
        this.IDSlider = IDSlider;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
