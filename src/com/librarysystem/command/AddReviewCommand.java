package src.com.librarysystem.command;

import src.com.librarysystem.manager.ReviewManager;

public class AddReviewCommand implements Command {
    private ReviewManager reviewManager;
    private String reviewText;

    public AddReviewCommand(ReviewManager reviewManager, String reviewText) {
        this.reviewManager = reviewManager;
        this.reviewText = reviewText;
    }

    @Override
    public void execute() {
        reviewManager.addReview(reviewText);
    }

    @Override
    public void undo() {
        reviewManager.removeLastReview();
    }
}

