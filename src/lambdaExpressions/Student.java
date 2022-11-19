package lambdaExpressions;

public class Student {
    String name;
    int age;
    String indexNumber;

    public Student(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.indexNumber = indexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
}
