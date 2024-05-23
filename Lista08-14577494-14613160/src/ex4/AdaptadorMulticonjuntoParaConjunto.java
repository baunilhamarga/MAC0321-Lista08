package ex4;

import ex3.Multiconjunto;

public class AdaptadorMulticonjuntoParaConjunto<T> {
	    private Multiconjunto<T> multiconjunto;

	    public AdaptadorMulticonjuntoParaConjunto(Multiconjunto<T> multiconjunto) {
	        this.multiconjunto = multiconjunto;
	    }

}
