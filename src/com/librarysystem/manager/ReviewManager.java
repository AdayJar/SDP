package src.com.librarysystem.manager;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    private List<String> reviews = new ArrayList<>();

    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Added review: " + review);
    }

    public String removeReview(int index) {
        if (index >= 0 && index < reviews.size()) {
            String removedReview = reviews.remove(index);
            System.out.println("Removed review: " + removedReview);
            return removedReview;
        }
        return null;
    }

    public void removeLastReview() {
        if (!reviews.isEmpty()) {
            String lastReview = reviews.remove(reviews.size() - 1);
            System.out.println("Removed last review: " + lastReview);
        }
    }

    public void showReviews() {
        System.out.println("Current Reviews:");
        for (String review : reviews) {
            System.out.println("- " + review);
        }
    }
}
