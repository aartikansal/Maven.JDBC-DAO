package daos;

public class Player implements DTO {
    private Integer id;
    private String name;
    private String country;
    private Integer age;
    private Integer points;
    private Integer tourn_played;

    public Player(Integer id, String name, String country, Integer age, Integer points, Integer tourn_played) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.age = age;
        this.points = points;
        this.tourn_played = tourn_played;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getTourn_played() {
        return tourn_played;
    }

    public void setTourn_played(Integer tourn_played) {
        this.tourn_played = tourn_played;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", points=" + points +
                ", tourn_played=" + tourn_played +
                '}';
    }
}

