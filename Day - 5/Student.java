import java.util.*;
import java.lang.*;
import java.text.*;

public class Student implements Comparable<Student>{
	String name;
	String dob;
	int sub1;
	int sub2;
	int sub3;
	int marks;
    String category;
    boolean flag;
    
	public Student(final String name,final String dob,final int sub1,final int sub2,final int sub3,final int marks,final String category) throws ParseException{
        //your code goes here.
        this.name = name;
        this.dob = dob;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.marks = marks;
        this.category = category;
    }
    
    // public void setStudentName(final String name){
    //     this.name = name;
    // }

    // public String getStudentName(){
    //     return name;
    // }

    // public void setStudentDOB(final String dob){
    //     this.dob = dob;
    // }

    // public String getStudentDOB(){
    //     return dob;
    // }

    // public void setStudentSub1(final int sub1){
    //     this.sub1 = sub1;
    // }

    // public int getStudentSub1(){
    //     return sub1;
    // }

    // public void setStudentSub2(final int sub2){
    //     this.sub2 = sub2;
    // }

    // public int getStudentSub2(){
    //     return sub2;
    // }

    // public void setStudentSub3(final int sub3){
    //     this.sub3 = sub3;
    // }

    // public int getStudentSub3(){
    //     return sub3;
    // }

    // public void setStudentMarks(final int marks){
    //     this.marks = marks;
    // }

    // public int getStudentMarks(){
    //     return marks;
    // }

    // public void setStudentCategory(final String category){
    //     this.category = category;
    // }

    // public int getStudentCategory(){
    //     return category;
    // }

	public int compareTo(Student that) {
        if(this.marks > that.marks){
            return 1;
        }else if (this.marks < that.marks){
            return -1;
        }else{
            if(this.sub3 > that.sub3){
                return 1;
            }else if(this.sub3 < that.sub3){
                return -1;
            }else{
                if(this.sub2 > that.sub2){
                    return 1;
                }else if(this.sub2 < that.sub2){
                    return -1;
                }else{
                    if (this.dob.compareTo(that.dob) > 0){
                        return 1;
                    }else if(this.dob.compareTo(that.dob) < 0){
                        return -1;
                    }
                }
            }
        }
        return 0;
    } 
}