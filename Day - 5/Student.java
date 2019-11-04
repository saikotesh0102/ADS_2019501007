import java.util.*;
import java.lang.*;
import java.text.*;

public class Student implements Comparable<Student>{
	private String name;
    private String dob;
	private int sub1;
	private int sub2;
	private int sub3;
	private int marks;
    private String category;
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
    
    public void setStudentName(final String name){
        this.name = name;
    }

    public String getStudentName(){
        return name;
    }

    public void setStudentDOB(final String dob){
        this.dob = dob;
    }

    public int getStudentDOB(){
        String[] d = dob.split("-");
        return Integer.parseInt(d[0]);
    }

    public int getStudentDOB1(){
        String[] d = dob.split("-");
        return Integer.parseInt(d[1]);
    }

    public int getStudentDOB2(){
        String[] d = dob.split("-");
        return Integer.parseInt(d[2]);
    }

    public void setStudentSub1(final int sub1){
        this.sub1 = sub1;
    }

    public int getStudentSub1(){
        return sub1;
    }

    public void setStudentSub2(final int sub2){
        this.sub2 = sub2;
    }

    public int getStudentSub2(){
        return sub2;
    }

    public void setStudentSub3(final int sub3){
        this.sub3 = sub3;
    }

    public int getStudentSub3(){
        return sub3;
    }

    public void setStudentMarks(final int marks){
        this.marks = marks;
    }

    public int getStudentMarks(){
        return marks;
    }

    public void setStudentCategory(final String category){
        this.category = category;
    }

    public String getStudentCategory(){
        return category;
    }

	public int compareTo(Student that) {
        if(this.getStudentMarks() > that.getStudentMarks()){
            return 1;
        }else if (this.getStudentMarks() < that.getStudentMarks()){
            return -1;
        }else{
            if(this.getStudentSub3() > that.getStudentSub3()){
                return 1;
            }else if(this.getStudentSub3() < that.getStudentSub3()){
                return -1;
            }else{
                if(this.getStudentSub2() > that.getStudentSub2()){
                    return 1;
                }else if(this.getStudentSub2() < that.getStudentSub2()){
                    return -1;
                }else{
                    if(this.getStudentDOB2() < that.getStudentDOB2()){
                        return 1;
                    }else if(this.getStudentDOB2() > that.getStudentDOB2()){
                        return -1;
                    }else {
                        if(this.getStudentDOB1() < that.getStudentDOB1()){
                            return 1;
                        }else if(this.getStudentDOB1() > that.getStudentDOB1()){
                            return -1;
                        }else{
                            if(this.getStudentDOB() < that.getStudentDOB()){
                                return 1;
                            }else if(this.getStudentDOB() > that.getStudentDOB()){
                                return -1;
                            }else{
                                return 0;
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString(){
        return this.getStudentName();
    }
}