package beans;

import java.util.ArrayList;
import java.util.List;

public class ratings {
    private int userid;
    private String isbn;
    public ratings(){}
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private int rating;

    @Override
    public String toString() {
        return "ratings{" +
                "userid=" + userid +
                ", isbn='" + isbn + '\'' +
                ", rating=" + rating +
                '}';
    }

}
