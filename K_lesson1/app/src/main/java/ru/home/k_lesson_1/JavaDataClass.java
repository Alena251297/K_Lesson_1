package ru.home.k_lesson_1;

import android.view.View;

public class JavaDataClass {
    private String field1 ;
    private String field2 ;
    private String field3 ;
    private String field4 ;
    private String field5 ;


//    public JavaDataClass(String field1, String field2, String field3, String field4, String field5) {
//        this.field1 = field1;
//        this.field2 = field2;
//        this.field3 = field3;
//        this.field4 = field4;
//        this.field5 = field5;
//
//    }

    private JavaDataClass copy(JavaDataClass javaDataClass) {
        JavaDataClass newJavaDataClass = new JavaDataClass();
        JavaSingleton.getInstance().field1="ffff";
        KotlinSingleton.INSTANCE.setField1("ffff");
        newJavaDataClass.field1 = field1;
        newJavaDataClass.field2 = field2;
        newJavaDataClass.field3 = field3;
        newJavaDataClass.field4 = field4;
        newJavaDataClass.field5 = field5;
        return newJavaDataClass;
    }


    @Override
    public String toString() {
        return "JavaDataClass{" +
                "field1='" + field1 + '\'' +  JavaSingleton.getInstance().field1 +
                KotlinSingleton.INSTANCE.getField1() +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                '}';
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }
}
