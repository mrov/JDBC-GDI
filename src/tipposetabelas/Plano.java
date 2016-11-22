package tipposetabelas;

public class Plano {

	private String descricao;
	private double preco;
	
	public Plano(String descricao, double preco){
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public String AddPlano(){
		String comando = "INSERT INTO tb_plano VALUES('"+ descricao +"', " + preco +")";
		return comando;
	}
}
