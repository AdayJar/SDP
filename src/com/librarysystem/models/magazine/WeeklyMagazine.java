package src.com.librarysystem.models.magazine;

public class WeeklyMagazine implements Magazine {
    private int id;
    private String title;
    private String editor;
    private boolean available;
    private String weekOfPublication;

    public WeeklyMagazine(int id, String title, String editor, boolean available, String weekOfPublication) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.available = available;
        this.weekOfPublication = weekOfPublication;
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

    @Override
    public boolean isAvailable() {
        return available;
    }

    

    @Override
    public String showInfo() {
        return "ID: " + id + ", Title: " + title + ", Editor: " + editor + ", Available: " + available + ", Week of Publication: " + weekOfPublication;
    }

    @Override
    public void changeAvailability(boolean availability) {
        this.available=availability;
    }
}
