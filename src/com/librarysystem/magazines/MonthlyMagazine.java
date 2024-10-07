package src.com.librarysystem.magazines;

public class MonthlyMagazine implements Magazine {
    private int id;
    private String title;
    private String editor;
    private boolean available;
    private int issueNumber;

    public MonthlyMagazine(int id, String title, String editor, boolean available, int issueNumber) {
        this.id = id;
        this.title = title;
        this.editor = editor;
        this.available = available;
        this.issueNumber = issueNumber;
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
    public void reserve() {
        if (available) {
            available = false;
            System.out.println("The magazine " + title + " has been reserved.");
        } else {
            System.out.println("The magazine " + title + " is not available for reservation.");
        }
    }

    @Override
    public void cancelReservation() {
        available = true;
        System.out.println("Reservation for the magazine " + title + " has been canceled.");
    }

    @Override
    public String showInfo() {
        return "ID: " + id + ", Title: " + title + ", Editor: " + editor + ", Available: " + available + ", Issue Number: " + issueNumber;
    }
}
