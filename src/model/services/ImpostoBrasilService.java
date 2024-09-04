package model.services;

public class ImpostoBrasilService implements ImpostoService {
	
	public double imposto(double montante) {
		if (montante < 100) {
			return montante * 0.2;
		} else {
			return montante * 0.15;
		}
	}

}
