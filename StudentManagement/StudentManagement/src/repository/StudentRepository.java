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

        // tim sinh vien theo id
        Student student = findById(id);

        // neu khong ton tai thi khong update duoc
        if (student == null) {
            throw new Exception(Message.STUDENT_NOT_EXIST);
        }

        // cap nhat ten sinh vien
        student.updateInfo(dto.getName());

        // neu mon hoc o ky nay chua co thi moi them vao
        if (!isCourseExist(student, dto.getSemester(), dto.getCourse())) {
            student.addCourse(new StudentCourse(dto.getSemester(), dto.getCourse()));
        }
    }

    // ================= CHECK DUPLICATE =================
    // Kiem tra trung du lieu khi tao moi
    public void checkDuplicate(Student student, StudentRequestDTO dto) throws Exception {

        // neu id trung nhung ten khac -> loi
        if (!student.getName().equalsIgnoreCase(dto.getName())) {
            throw new Exception(Message.DUPLICATE_ID);
        }

        // kiem tra trung semester + course
        // 1 semester co the hoc nhieu mon, nhung khong duoc hoc 1 mon 2 lan
        if (isCourseExist(student, dto.getSemester(), dto.getCourse())) {
            throw new Exception(Message.DUPLICATE_COURSE);
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
    public boolean deleteStudent(String id) {

        Student student = findById(id);

        // neu khong tim thay thi khong xoa duoc
        if (student == null) {
            return false;
        }

        studentList.remove(student);
        return true;
    }

    // ================= FIND =================
    // tim sinh vien theo id
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
