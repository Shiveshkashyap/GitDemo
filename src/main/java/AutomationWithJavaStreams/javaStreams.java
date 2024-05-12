package AutomationWithJavaStreams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import java.util.List;

public class javaStreams {
   // @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("aadiPurush");
        names.add("Amit");
        names.add("Anand");
        names.add("Amrit");
        names.add("Ram");
        names.add("Shyam");
        int count =0;
        for (int i = 0; i<names.size();i++){
            String actual = names.get(i);
            if (actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }


//*************Using JAVA_STREAM we can do it very easily ***********************
//    @Test
    public static void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("aadiPurush");
        names.add("Amit");
        names.add("Anand");
        names.add("Amrit");
        names.add("Ram");
        names.add("Shyam");

     Long nam =   names.stream().filter(a->a.startsWith("A")).count();
        System.out.println(nam);

// So for the below line we need to add terminal operation because filter method is give output as True and false, so we need terminal operation that is : count()
// So there is no use of terminal operation when intermediate operation return False.  it is applied on True return.
//  @Test      long a=   names.stream().filter(s -> s.startsWith("A")).count();
//        System.out.println(a);
// we can Here  directly be using "JAVA Stream" as an operation . Here count method is not needed.
//        Stream.of("aadiPurush","Amit","Anand","Amrit","Ram","Shyam").filter(s -> s.startsWith("A"));

// We can also write like below way incase if we get multiple letter for filter.

//      long z=  Stream.of("aadiPurush","Amit","Anand","Amrit","Ram","Shyam").filter(s ->
//        {
//            s.startsWith("A");
//            return true;
//        }
//        ).count();
//        System.out.println(z);

//        Printing all the array list value .
//        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));


    }

    @Test
    public void streamMap(){

        ArrayList<String>name = new ArrayList<String>();
        name.add("Home");
        name.add("aadiPurush");
        name.add("Amit");
        name.add("Anand");
        name.add("Amrit");
        name.add("Ram");
        name.add("Shyam");

//        print names end with "a"

//        Stream.of("RAMA","KARUNA","VARSHA","BOSS","PAPA").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
//                .forEach(s -> System.out.println(s));

        List<String>names = Arrays.asList("RAMA","KARUNA","VARSHA","BOSS","PAPA");
        names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));


//        So we have to concatenate these two List for merging

       Stream<String> newstream= Stream.concat(names.stream(),name.stream());
//       newstream.sorted().forEach(s -> System.out.println(s));
//      we can sort or filter the name also
       boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("Boss"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
      List<String> ls=  Stream.of("RAM","SHYAM","AAM","JAM").filter(s -> s.endsWith("M")).map(s -> s.toUpperCase()).collect(Collectors.toList());

//      If we want 1st index then how to get that.
//        ls.get(0);

//        System.out.println(ls.get(0));
//

/*     Suppose array = [2,2,4,5,3,4,9,5,3,7] and we have to print the unique number and then sort the array.

        Using Stream we can do it very quickly  : Below are the steps
        first change this array into list
 */
            List<Integer> array = Arrays.asList(2,2,4,5,3,4,9,5,3,7);
//         array.stream().distinct().forEach(s-> System.out.println(s));

//         How to sort the array then and how to print 3 on that.

       List<Integer> sortedList= array.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(sortedList.get(1));




    }




}

