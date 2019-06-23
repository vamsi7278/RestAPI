package vamsi.com.restapi;

public class ListItem {
    private String firstname;
    private String lastname;
    private String imgURL;


    public ListItem(String firstname, String lastname, String imgURL) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.imgURL = imgURL;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getImgURL() {
        return imgURL;
    }
}
