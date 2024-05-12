package TestNGTutorial;

import org.testng.annotations.Test;

public class lecture1 {
//when we will write like this(below) then it means it is running in JAVA, But TestNG we can run the programme to create method
//    public static void main(String[]args){
//        System.out.println("Hello Using Java run");
//    }

//    Below way we can write testcase , for that same we have to create a method as Demo
@Test
    public void Demo(){
        System.out.println("Hello using TestNG run");// automation steps

    }
    @Test
    public void seconTest(){
        System.out.println("This is the 2nd test case in single class");
    }

}


