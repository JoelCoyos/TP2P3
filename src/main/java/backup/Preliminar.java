package backup;

import java.util.Random;

import modelo.IState;
import modelo.Util;

public class Preliminar implements IState {

	@Override
	public void realizarRonda(Batalla batalla) {
		batalla.getTorneo().agregarBatalla(batalla);
		System.out.println("Los entrenadores se presentan");
		Util.espera(2500); //Los entrenadores se presentan
		Random r = new Random();
		//Por ahora random
		batalla.setPoke1(batalla.getEntrenador1().getPokemones().get(r.nextInt(2))); 
		batalla.setPoke2(batalla.getEntrenador2().getPokemones().get(r.nextInt(2))); 
		batalla.setHechizo1(null);
		batalla.setHechizo2(null);
		System.out.println("Los entrenadores elijieron los pokemon");
		batalla.setEstado(new BatallaState());
		
	}


}
