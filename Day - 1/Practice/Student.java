import java.util.*;

public class Student implements Comparable<Student>{
    String name;
    private String dob;
    int hallticket;
    double maths;
    double genSci;
    double eng;
    double social;
    double firstLang;
    double gpa;
    
    public Student(String name, int hallticket, double maths, double genSci, double eng, double social, double firstLang, String dob){
        this.name = name;
        this.dob = dob;
        this.hallticket = hallticket;
        this.maths = maths;
        this.genSci = genSci;
        this.eng = eng;
        this.social = social;
        this.firstLang = firstLang;
        this.gpa = (maths + genSci + eng + social + firstLang)/5.0;
    }
    
    public void setStudentDOB(final String dob){
        this.dob = dob;
    }

    public int getStudentDOB(){
        String[] d = dob.split("/");
        return Integer.parseInt(d[0]);
    }

    public int getStudentDOB1(){
        String[] d = dob.split("/");
        return Integer.parseInt(d[1]);
    }

    public int getStudentDOB2(){
        String[] d = dob.split("/");
        return Integer.parseInt(d[2]);
    }
    
    public int compareTo(Student that){
        if(this.gpa > that.gpa){
            return 1;
        }else if(this.gpa < that.gpa){
            return -1;
        }else{
            if(this.maths > that.maths){
                return 1;
            }else if(this.maths < that.maths){
                return -1;
            }else{
                if(this.genSci > that.genSci){
                    return 1;
                }else if(this.genSci < that.genSci){
                    return -1;
                }else{
                    if(this.eng > that.eng){
                        return 1;
                    }else if(this.eng < that.eng){
                        return -1;
                    }else{
                        if(this.social > that.social){
                            return 1;
                        }else if(this.social < that.social){
                            return -1;
                        }else{
                            if(this.firstLang > that.firstLang){
                                return 1;
                            }else if(this.firstLang < that.firstLang){
                                return -1;
                            }else{
                                if(this.getStudentDOB2() < that.getStudentDOB2()){
                                    return 1;
                                }else if(this.getStudentDOB2() > that.getStudentDOB2()){
                                    return -1;
                                }else{
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
            }
        }
    }
    
    public String toString(){
        return this.name + "(" + this.gpa + ")" ;
    }
}