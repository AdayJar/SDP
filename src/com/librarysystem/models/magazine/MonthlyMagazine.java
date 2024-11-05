package src.com.librarysystem.models.magazine;



public class MonthlyMagazine implements Magazine {
    private int id;
    private String title;
    private String editor;
    private boolean available;
    private int issueNumber;
    private final String url;
  


    public MonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber,String url) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.available = available;
        this.issueNumber = issueNumber;
        this.url = url;

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
    
    public int getIssueNumber() { // Метод для получения номера выпуска
        return issueNumber;
    }
    
    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String showInfo() {
        return "ID: " + id + ", Title: " + title + ", Editor: " + editor + ", Available: " + available + ", Issue Number: " + issueNumber;
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
