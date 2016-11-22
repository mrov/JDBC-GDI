package tipposetabelas;

public class Telefone {
	
	private String[] numeros;

	
	
	public Telefone(String[] telefones) {
		numeros = telefones;
	}



	public String retornaVarray(){
		String varray = "varray_fones(";
		//varray_fones(tp_fone('081-982661311'), tp_fone('074-9818-9022'),tp_fone('074-999473373'))
		for (int i = 0; i < numeros.length; i++) {
			if(i == numeros.length-1 && !numeros[i].equalsIgnoreCase("")){varray = varray + "tp_fone('" + numeros[i] + "'))"; break;}
			if(i == numeros.length-1 && numeros[i].equalsIgnoreCase("")){varray = varray + ")";}
			if(numeros[i].equalsIgnoreCase("")){continue;}
			if(i==0){varray = varray + "tp_fone('" + numeros[i] + "')";}
			if(i>0){varray = varray + ",tp_fone('" + numeros[i] + "')";}
		}
		if(varray.equalsIgnoreCase("varray_fones()")){return "NULL";}
		return varray;
	}
	
}
