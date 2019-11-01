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
        //your code goes here.
        for(int i = 0; i < list.length ; i++){
            int max = i;
            for(int j = i; j < list.length; j++){
                if(list[j].compareTo(list[max]) > 1){
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