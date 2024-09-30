package srp;

class UserRepository {
    public void save(User user) {
        System.out.println("User " + user.getName() + " saved.");
    }
}
