package repository;

import constants.CourseType;
import constants.Message;
import dto.StudentRequestDTO;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import model.StudentCourse;

public class StudentRepository {

    // danh sach luu tru toan bo sinh vien
    private List<Student> studentList;

    // khoi tao danh sach rong
    public StudentRepository() {
        studentList = new ArrayList<>();
    }

    // ================= ADD =================
    // Tao sinh vien moi va mon hoc tu DTO, them vao danh sach
    public void addStudent(StudentRequestDTO dto) {
        Student student = new Student(dto.getId(), dto.getName());
        StudentCourse newCourse = new StudentCourse(dto.getSemester(), dto.getCourse());
        student.addCourse(newCourse);
        studentList.add(student);
    }

    // Them mon hoc tu DTO vao sinh vien da ton tai
    public void addCourseToStudent(Student student, StudentRequestDTO dto) {
        student.addCourse(new StudentCourse(dto.getSemester(), dto.getCourse()));
    }

    // ================= UPDATE =================
    // cap nhat thong tin sinh vien
    public void updateStudent(String id, StudentRequestDTO dto) throws Exception {
        Student student = getStudentById(id);

        // neu mon hoc o ky nay chua co thi moi them vao
        if (!isCourseExist(student, dto.getSemester(), dto.getCourse())) {
            student.addCourse(new StudentCourse(dto.getSemester(), dto.getCourse()));
        }
    }

    // Kiem tra sinh vien da hoc mon nay o ky nay chua
    private boolean isCourseExist(Student student, String semester, CourseType course) {
        for (StudentCourse sc : student.getCourses()) {
            if (sc.getSemester().equalsIgnoreCase(semester) && sc.getCourse() == course) {
                return true;
            }
        }
        return false;
    }

    // ================= DELETE =================
    // xoa sinh vien khoi danh sach
    public void deleteStudent(String id) throws Exception {
        Student student = getStudentById(id);
        studentList.remove(student);
    }

    // ================= FIND =================
    // tim sinh vien theo id, neu khong thay thi nem loi
    public Student getStudentById(String id) throws Exception {
        Student student = findById(id);
        if (student == null) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }
        return student;
    }

    // tim sinh vien theo id (tra ve null neu khong thay)
    public Student findById(String id) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // lay toan bo danh sach sinh vien
    public List<Student> getAllStudents() {
        return studentList;
    }

    // kiem tra danh sach co rong hay khong
    public boolean isEmpty() {
        return studentList.isEmpty();
    }
}
