import java.util.*;

public class ReviewManager {
    private Map<User, List<Review>> userReviews;

    public ReviewManager() {
        this.userReviews = new HashMap<>();
    }

    public void addReview(Review review) {
        userReviews.computeIfAbsent(review.getUser(), k -> new ArrayList<>()).add(review);
    }

    // Lấy danh sách đánh giá của một người dùng
    public List<Review> getReviewsByUser(User user) {
        return userReviews.getOrDefault(user, new ArrayList<>());
    }

    // Hiển thị tất cả đánh giá của mọi người dùng
    public void displayAllReviews() {
        if (userReviews.isEmpty()) {
            System.out.println("Don't have any reviews");
            return;
        }

        System.out.println("List of reviews:");
        for (Map.Entry<User, List<Review>> entry : userReviews.entrySet()) {
            for (Review review : entry.getValue()) {
                System.out.println("   ➝ 👤" + review);
            }
        }
    }
}
