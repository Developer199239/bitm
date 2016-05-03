package bitm.com.joy.fragmentwithdatabase;

/**
 * Created by Mobile App Develop on 16-3-16.
 */
public class StudentList {
    private String userName;
    private String userEmail;

    public StudentList() {
    }

    public StudentList(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
