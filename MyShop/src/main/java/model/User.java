package model;

public class User {
    private long id;                 //用户id
    private String username;         //用户名
    private String email;            //邮箱
    private String password;         //密码
    private String name;             //姓名
    private String phone;            //手机号
    private String address;          //住址
    private boolean admin = false;   //管理员权限
    private boolean validate = true; //可用性

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public User() {
        super();
    }

    public User(long id, String username, String email, String password, String name, String phone, String address,
                boolean admin, boolean validate) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.admin = admin;
        this.validate = validate;
    }

    public User(String username, String email, String password, String name, String phone, String address, boolean admin,
                boolean validate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.admin = admin;
        this.validate = validate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", name="
                + name + ", phone=" + phone + ", address=" + address + ", admin=" + admin + ", validate="
                + validate + "]";
    }

}
