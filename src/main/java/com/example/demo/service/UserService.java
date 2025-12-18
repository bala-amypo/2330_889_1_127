public interface UserService{
    public void saveUser(User user);
    public User findByEmail(String email);
}