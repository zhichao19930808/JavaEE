package one;

/**
 * Created by Administrator on 2017/6/13.
 */
public class Students {
    private Integer id;
    private String name;
    private String gender;
    private  String date;

    public Students() {
    }

    public Students(Integer id, String name, String gender, String date) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDate() {
        return date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
