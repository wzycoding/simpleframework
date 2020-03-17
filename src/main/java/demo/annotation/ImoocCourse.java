package demo.annotation;
@CourseInfoAnnotation(courseName = "剑指java面试", courseTag = "面试", courseProfile = "就是流皮")
public class ImoocCourse {
    @PersonInfoAnnotation(name = "翔仔", language = {"Java", "C++"})
    private String author;

    @CourseInfoAnnotation(courseName = "校园商铺", courseTag = "实战", courseProfile = "可以用于毕设", courseIndex = 144)
    public void getCourseInfo() {


    }
}
