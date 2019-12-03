package test;
public class DoubleMatrix extends GenericMatrix<Double> {
	@Override /** Aduna doi intregi */
	
	protected Double add(Double o1, Double o2) {
		return o1 + o2;
	}

	@Override 
	protected Double multiply(Double o1, Double o2) {
		return o1 * o2;
	}

	@Override 
	protected Double zero() {
		return 0.0;
	}

	@Override
	protected Double subtract(Double o1, Double o2) {
		return o1-o2;
	}
}
