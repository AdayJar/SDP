package src.com.librarysystem.command;
import src.com.librarysystem.manager.ReviewManager;


public class RemoveReviewCommand implements Command {
    private ReviewManager reviewManager;
    private int reviewIndex;
    private String removedReview;

    public RemoveReviewCommand(ReviewManager reviewManager, int reviewIndex) {
        this.reviewManager = reviewManager;
        this.reviewIndex = reviewIndex;
    }

    @Override
    public void execute() {
        removedReview = reviewManager.removeReview(reviewIndex);
    }

    @Override
    public void undo() {
        if (removedReview != null) {
            reviewManager.addReview(removedReview);
        }
    }
}
