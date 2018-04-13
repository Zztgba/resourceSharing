package priv.luruidi.bean;

/**
 * @author 卢瑞迪
 * @date 2017年11月28日 上午11:47:42
 * @version V1.0
 * @Description TODO
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String tel;
	private String email;
	private String image;
	private String birth;
	private String sex;
	private String nickname;

	public User() {
		
	}

	public User(Integer id, String name, String password, String tel, String email, String image, String birth) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.image = image;
		this.birth = birth;
	}

	public User(String name, String password, String tel, String email, String image, String birth) {
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.image = image;
		this.birth = birth;
	}

	public User(Integer id, String name, String password, String tel, String email, String image, String birth,
			String sex, String nickname) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.image = image;
		this.birth = birth;
		this.sex = sex;
		this.nickname = nickname;
	}

	public User(String name, String password, String tel, String email, String image, String birth, String sex,
			String nickname) {
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.image = image;
		this.birth = birth;
		this.sex = sex;
		this.nickname = nickname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + ", email=" + email
				+ ", image=" + image + ", birth=" + birth + ", sex=" + sex + ", nickname=" + nickname + "]";
	}
}
