import java.util.HashMap;
import java.util.Map;

import com.example.Student_Application2.model.StudentDataModel;

public class StudentDataRepo {
        private Map<String, StudentDataModel> StudentDataMap;

    public StudentDataRepo() {
        StudentDataMap = new HashMap<>();
    }

    public StudentDataModel getStudentById(final String id) {
        return StudentDataMap.getOrDefault(id, null);
    }

    public void deleteStudent(final String id) {
        StudentDataMap.remove(id);
    }

    public StudentDataModel updateStudent(final String id, final String name, final String age) {
        StudentDataModel newStudentDataModel = getStudentById(id);
        newStudentDataModel.setAge(age);
        newStudentDataModel.setName(name);
        return newStudentDataModel;
    }

    public StudentDataModel createStudent(final String id, final String name, final String age) {
        StudentDataModel newStudentDataModel = new StudentDataModel(id, name, age);
        StudentDataMap.put(id, newStudentDataModel);
        return newStudentDataModel;
    }
}
