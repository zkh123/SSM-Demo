import com.ssm.demo.Entity.Student;
import com.ssm.demo.Service.StudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//指定bean注入的配置文件
@ContextConfiguration(locations = {"classpath:spring/spring.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Autowired
    private StudentService studentService;

    @org.junit.Test
    public void test() {
        Student student=new Student();
        student.setClassid(1);
        for (Student student1 : studentService.selectByCondition(student)) {
            System.out.println(student1.getName());
        }
    }
}