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

	public Student[] getSelectedList(){
        getSortedList(list);

		Student[] selected = new Student[vacancies];
		int position = 0;
		// int open = this.open;
		// int bc = this.bcReserved;
		// int sc = this.scReserved;
		// int st = this.stReserved;
		// int vac = this.vacancies;

		for (int i = 0; i < open; i++) {
			selected[position++] = list[i];
			list[i] = null;
			open--;
			vacancies--;
		}

		for (int j = 0; j < list.length; j++) {
			if (list[j] == null) {
				continue;
			}
			if (list[j].getStudentCategory().equals("BC")) {
				if (bcReserved > 0) {
					selected[position++] = list[j];
					list[j] = null;
					bcReserved--;
					vacancies--;
				}
			} else if (list[j].getStudentCategory().equals("SC")) {
				if (scReserved > 0) {
					selected[position++] = list[j];
					list[j] = null;
					scReserved--;
					vacancies--;
				}
			} else if (list[j].getStudentCategory().equals("ST")) {
				if (stReserved > 0) {
					selected[position++] = list[j];
					list[j] = null;
					stReserved--;
					vacancies--;
				}
			}
		}
		
		if (vacancies > 0) {
			for (int j = 0; j < list.length; j++) {
				if (list[j] == null) {
					continue;
				}
 				selected[position++] = list[j];
				vacancies--;
				if (vacancies == 0) {
					break;
				}
			}
        }
        
        getSortedList(selected);
        return selected;
    }

    public Student[] getSortedList(Student[] Students){

        for(int i = 0; i < Students.length ; i++){
            int max = i;
            for(int j = i; j < Students.length; j++){
                if(Students[j].compareTo(Students[max]) == 1){
                    max = j;
                }
            }
            Student temp = Students[i];
            Students[i] = Students[max];
            Students[max] = temp;
        }
		return Students;
    }
}