package cn.oy.pojo;

public class User {
    private  int id;
    private String username;
    private String lesson;
    private String score;

    public User(){}

    public User(int id, String username,String lesson, String score) {
        this.id = id;
        this.username = username;
        this.lesson = lesson;
        this.score=score;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLesson() {
        return lesson;
    }
}
