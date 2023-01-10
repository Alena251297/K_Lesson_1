package ru.home.k_lesson_1;

public class JavaSingleton {
      public String field1=" ";


    private  static JavaSingleton INSTANCE=null;

 public static JavaSingleton getInstance(){
if (INSTANCE==null)
{
    INSTANCE=new JavaSingleton();
}
return INSTANCE;
 }

}
