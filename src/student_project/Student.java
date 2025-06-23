package student_project;

public class Student {
    private int rnumber;
    private String sname;
    private String branch;
    private int yearOfstudy;
    private String grade;
    private long phonenum;

    // Constructor
    public Student() {}

    // Getters
    public int getRnumber() { return rnumber; }
    public String getSname() { return sname; }
    public String getBranch() { return branch; }
    public int getYearOfstudy() { return yearOfstudy; }
    public String getGrade() { return grade; }
    public long getPhonenum() { return phonenum; }

    // Setters
    public void setRnumber(int rnumber ) { this.rnumber= rnumber; }
    public void setSname(String sname) { this.sname = sname; }
    public void setBranch(String branch) { this.branch = branch; }
    public void setYearOfstudy(int yearOfstudy) { this.yearOfstudy = yearOfstudy; }
    public void setGrade(String grade) { this.grade = grade; }
    public void setPhonenum(long phonenum ) { this.phonenum= phonenum; }
}


