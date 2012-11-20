package laberintoraton;



public class Pila {

	private char v[];
	private int Tos;
	 
	public Pila(int n){
		v= new char[n];
		Tos = -1;
		
	}
	
	private void crecer(){
		char tmp[];
		if (Tos == v.length-1) {
			tmp = new char[v.length+5];
			for(int k =0;k<v.length;k++){
				tmp[k] = v[k];
			}
			v = tmp;
		}
	}

	public void push(char c){

		crecer();
		Tos++;
		v[Tos]= c;	
		
	}
	
	public char pop(){
		char c = '\0';
		if(Tos >=0)
			c = v[Tos];
		Tos--;
		
	return c;	
	}
	
	public boolean vacio(){
		
		
		return Tos==-1;
		
	}
}
