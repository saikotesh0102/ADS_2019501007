import java.util.*;

public class Selection{
	Student[] list;
	int vacancies;
	int open;
	int bcReserved;
	int scReserved;
    int stReserved;
    
	public Selection(int no_of_Students, int no_of_positions,int open, int bcReserved, int scReserved, int stReserved) {
		list = new Student[no_of_Students];
		vacancies = no_of_positions;
		this.open = open;
		this.bcReserved = bcReserved;
		this.scReserved = scReserved;
		this.stReserved = stReserved;
    }
    
    public void add(Student stu){
        list.add(stu);
    }

	public Student[] getSelectedList(){
        Arraylist<Student> studentsAlloted = new ArrayList<Student>();
        int count = 0;
        for(int i = 0; i < list.length && open > 0 && vacancies > 0; i++){
            studentsAlloted.add(list[i]);
            open--;
            vacancies--;
            count++;
        }

        for (int i = count; i < list.length && vacancies > 0; i++) {
            if (list[i].getStudentCategory().equals("BC") && bcReserved > 0) {
                studentsAlloted.add(list[i]);
                bcReserved--;
                count++;
                vacancies--;
            }
            
            if (list[i].getStudentCategory().equals("SC") && scReserved > 0) {
                studentsAlloted.add(list[i]);
                scReserved--;
                count++;
                vacancies--;
            }

            if (list[i].getStudentCategory().equals("ST") && stReserved > 0) {
                studentsAlloted.add(list[i]);
                stReserved--;
                count++;
                vacancies--;
            }
        }
        return studentsAlloted;
    }

    public Student[] sorted(){
        for(int i = 0; i < list.length ; i++){
            int max = i;
            for(int j = i; j < list.length; j++){
                if(list[j].compareTo(list[max]) == 1){
                    max = j;
                }
            }
            Student temp = list[i];
            list[i] = list[max];
            list[max] = temp;
        }
		return list;
    }
}