package vn.iotstar.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int id;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String userName;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String fullName;

    @Column(nullable = false, length = 255)
    private String passWord;

    @Column(columnDefinition = "NVARCHAR(1000)")
    private String avatar;

    private int roleid;

    @Column(length = 20)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    // ====== Getters & Setters ======
    // 👇 Constructor mặc định bắt buộc
    public User() {
    }
	public User(int id, String email, String userName, String fullName, String passWord, String avatar,
			int roleid, String phone, Date createdDate) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.passWord = passWord;
		this.avatar = avatar;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
