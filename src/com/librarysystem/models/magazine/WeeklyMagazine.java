package src.com.librarysystem.models.magazine;





public class WeeklyMagazine implements Magazine {
    private int id;
    private String title;
    private String editor;
    private boolean available;
    private String weekOfPublication;
    private final String url; 


   
    public WeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication,String url) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.available = available;
        this.weekOfPublication = weekOfPublication;
        this.url=url;
     
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getEditor() {
        return editor;
    }
    public String getWeekOfPublication() { // Метод для получения недели публикации
        return weekOfPublication;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String showInfo() {
        return "ID: " + id + ", Title: " + title + ", Editor: " + editor + ", Available: " + available + ", Issue Number: " + weekOfPublication;
    }

    @Override
    public void changeAvailability(boolean availability) {
        this.available = availability;
      
    }

    @Override
    public String getUrl() {
        return url;
    }

  
   
   
}
