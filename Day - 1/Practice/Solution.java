import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        int admissionCount = scan.nextInt();
        Student[] students = new Student[admissionCount];
        int i = 0;
        while(i < admissionCount){
            String name = scan.next();
            int hallTicket = scan.nextInt();
            double maths = scan.nextDouble();
            double genSci = scan.nextDouble();
            double eng = scan.nextDouble();
            double social = scan.nextDouble();
            double firstLang = scan.nextDouble();
            String dob = scan.next();
            students[i++] = new Student(name,hallTicket,maths,genSci,eng,social,firstLang,dob);
        }
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        for(int j = 0; j < count; j++){
            System.out.println(students[j]);
        }
    }
}