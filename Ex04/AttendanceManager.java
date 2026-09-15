package Ex04;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {

    private ArrayList<Student> students;

    public AttendanceManager() {
        students = new ArrayList<>();
    }

    @Override
    public void add(Student item) {
        students.add(item);
    }

    @Override
    public void update(int index, Student item) {
        students.set(index, item);
    }

    @Override
    public void delete(int index) {
        students.remove(index);
    }

    @Override
    public void display() {

        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên đang trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");

        for (int i = 0; i < students.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + students.get(i).getName()
            );
        }
    }

    public int size() {
        return students.size();
    }
}
