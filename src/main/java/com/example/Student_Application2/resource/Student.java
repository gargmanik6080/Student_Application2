import com.example.Student_Application2.model.StudentDataModel;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class Student {

    final public Map<String, StudentDataModel> idToStudent = new HashMap<>();
    final public Map<String, StudentDataModel> universityToStudents = new HashMap<>();

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody String name,
                             @RequestBody String university,
                             @RequestBody String aadhaar,
                             @RequestBody Integer age){

        String id = UUID.randomUUID().toString();
        StudentDataModel student = new StudentDataModel(id, name, university, aadhaar, age);
        idToStudent.put(id, student);
        List<StudentDataModel> students = universityToStudents.getOrDefault(university, new ArrayList<>());
        students.add(student);
        universityToStudents.put(university, students);

        return id;
    }

    @GetMapping("/getStudentsByUniversity")
    public List<String> getStudentsByUniversity(String university){
        return universityToStudents.getOrDefault(university, null);
    }

    @GetMapping("/getStudentByID")
    public String getStudentByID(){
        return idToStudent.getOrDefault(id, null);
    }
}
