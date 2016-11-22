package tipposetabelas;

public class Endereco {

	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;

	public Endereco(String cep,String cidade,String bairro,String rua,String numero){
		this.cep = cep;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
	}
	
	public String to_string(){
		//Ja vou retornar nesta forma tp_endereco('44900000', 'Irec?','Bairro','Rua Aquela Mesma','16')
		String EnderecoCompleto = "tp_endereco('" + cep + "', '" + cidade + "', '" + bairro + "', '" + rua + "', '" + numero +"')";
		return EnderecoCompleto;
		
	}
}
