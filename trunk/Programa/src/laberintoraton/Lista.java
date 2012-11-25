package laberintoraton;

public class Lista {
	Nodo head;
	Nodo tail;

	Lista() {
		head = tail = null;
	}

	boolean vacia() {
		return head == null;
	}

	Nodo cabeza() {
		return head;
	}

	Nodo borrarInicio() {
		Nodo temp;
		if (vacia())
			return null;
		temp = head;
		head = head.sig;
		if (head == null)
			tail = null;
		temp.sig = null;
		return temp;
	}

	Nodo borrarFinal() {
		Nodo temp, q;
		if (vacia())
			return null;
		if (head == tail) {
			temp = head;
			head = tail = null;
			return temp;
		}
		temp = head;
		while (temp.sig != tail) {
			temp = temp.sig;
		}
		temp.sig = null;
		q = tail;
		tail = temp;
		return q;

	}

	void agregaInicio(int f, int c) {
		Nodo p = new Nodo(f, c);
		p.sig = head;
		head = p;
		if (tail == null) {
			tail = head;
		}
	}

	void agregaFinal(int f, int c) {
		Nodo p = new Nodo(f, c);
		tail.sig = p;
		tail = p;
		if (head == null) {
			head = tail;
		}

	}

	void recorreLista() {
		Nodo p;
		if (head == null) {
			System.out.println("Lista vacia");
			return;
		}
		p = head;
		while (p != null) {
			System.out.println(p);
			p = p.sig;
		}
	}

	boolean buscarNodo(int f, int c) {
		Nodo p;

		if (head == null) {
			System.out.println("Lista vacia");
			return false;
		}
		p = head;
		while (p != null) {
			if (p.fila==f && c== p.columna) {
				return true;
			}
			p = p.sig;
		}
		return false;

	}

}