package student_project;

import java.util.*;

public class StudentMainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("1. Add Student\n2. View All\n3. Update\n4. Delete\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        Student s = new Student();
                        System.out.println("Enter Roll Number (int):");
                        s.setRnumber(sc.nextInt()); sc.nextLine();

                        System.out.println("Enter Name:");
                        s.setSname(sc.nextLine());

                        System.out.println("Enter Branch:");
                        s.setBranch(sc.nextLine());

                        System.out.println("Enter Year of Study (int):");
                        s.setYearOfstudy(sc.nextInt()); sc.nextLine();

                        System.out.println("Enter Grade:");
                        s.setGrade(sc.nextLine());

                        System.out.println("Enter Phone Number (long):");
                        s.setPhonenum(sc.nextLong()); sc.nextLine();

                        dao.addStudent(s);
                        break;

                    case 2:
                        List<Student> list = dao.getAllStudents();
                        for (Student st : list) {
                            System.out.println(
                                st.getRnumber() + " " + 
                                st.getSname() + " " +
                                st.getBranch() + " " +
                                st.getYearOfstudy() + " " +
                                st.getGrade() + " " +
                                st.getPhonenum()
                            );
                        }
                        break;

                    case 3:
                        System.out.println("Enter Roll Number to update:");
                        int rnum = sc.nextInt(); sc.nextLine();
                        Student u = new Student();
                        u.setRnumber(rnum);

                        System.out.println("Enter new Name:");
                        u.setSname(sc.nextLine());

                        System.out.println("Enter new Branch:");
                        u.setBranch(sc.nextLine());

                        System.out.println("Enter new Year of Study:");
                        u.setYearOfstudy(sc.nextInt()); sc.nextLine();

                        System.out.println("Enter new Grade:");
                        u.setGrade(sc.nextLine());

                        System.out.println("Enter new Phone Number:");
                        u.setPhonenum(sc.nextLong()); sc.nextLine();

                        dao.updateStudent(u);
                        break;

                    case 4:
                        System.out.println("Enter Roll Number to delete:");
                        int delRnum = sc.nextInt(); sc.nextLine();
                        dao.deleteStudent(delRnum);
                        break;

                    case 5:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
