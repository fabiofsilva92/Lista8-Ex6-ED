
public class QuickSort {

	private NoMedia inicio;
	
	public QuickSort() {
		this.inicio = null;
	}
	
	public NoMedia inicioQuick(NoMedia aux) {
		
		int listaLength = 0;
		NoMedia aux2 = aux;
		
		while(aux2!=null) {
			listaLength++;
			aux2 = aux2.prox;
		}
		aux2 = aux;
		System.out.println(listaLength + " de Tamanho");
		Media [] vetorMedia = new Media[listaLength];
		Media auxMedia = null;
		
		for(int i = 0; i< listaLength; i++) {
			auxMedia = new Media(aux.media.getAlunoId(), aux.media.getDisciplinaId(), aux.media.getMediaFinal());
			vetorMedia[i] = auxMedia;
			aux = aux.prox;
		}
		
		int ini = 0;
		int fim = vetorMedia.length-1;
		
		quicksort(vetorMedia, ini, fim);
		
		for(int i = 0; i<listaLength; i++) {
			adicionaFinal(vetorMedia[i]);
		}
		
		return inicio;
		
	}
	
	public void mergeSort(Media [] lista, int ini, int fim){
		
		int pos = (ini + fim) / 2, i = ini, j = pos+1, k=0;
		Media [] lista_aux = new Media [fim-ini+1];
		
		if (ini < fim) {
			mergeSort(lista, ini, pos);
			mergeSort(lista, pos + 1, fim);

			while (i <= pos || j <= fim) {

				if (i > pos) {
					lista_aux[k] = lista[j];
					j++;
				} else if (j > fim) {
					lista_aux[k] = lista[i];
					i++;
				} else if (lista[i].getMediaFinal() < lista[j].getMediaFinal()) {
					lista_aux[k] = lista[i];
					i++;
				} else {

					lista_aux[k] = lista[j];
					j++;
				}
				k++;
			}
			k = 0;
			for (int z = ini; z <= fim; z++) {

				lista[z] = lista_aux[k];
				k++;
			}

		}
	}
	
	public void quicksort(Media [] lista, int inicio, int fim) {
		
		int i = inicio;
		int j = fim;
		int pos = (inicio+fim)/2;
		Double pivo = lista[pos].getMediaFinal();
		Media aux;
		
		if(inicio < fim) { // se a lista for unitária
			while(i<j) {
				while(lista[i].getMediaFinal() < pivo) {
					i++;
				}
				while(lista[j].getMediaFinal() > pivo) {
					j--;
				}
				if(lista[i].getMediaFinal() == pivo) {
					pos = i;
				}
				else if(lista[j].getMediaFinal() == pivo) {
					pos = j;
				}
				aux = lista[i];
				lista[i] = lista[j];
				lista[j] = aux;
			}
			quicksort(lista, inicio, pos);
			quicksort(lista, pos+1, fim);

		}
		
	}
	
	public void adicionaFinal(Media n) {
		NoMedia c = new NoMedia(n);
		if (inicio == null) {
			inicio = c;
			c.anterior = null;
			c.prox = null;
		} else {
			NoMedia aux = inicio;
			while (aux.prox != null) {
				aux = aux.prox;
			}
			aux.prox = c;
			c.anterior = aux;
			c.prox = null;
		}
	}
	
}
