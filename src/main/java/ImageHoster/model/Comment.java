package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name="createDate")
    private Date createDate;

    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User commentUser;


    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "image_id")
    private Image imageCommenter;

    public Image getImageCommenter() {
        return imageCommenter;
    }

    public void setImageCommenter(Image imageUser) {
        this.imageCommenter = imageUser;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
