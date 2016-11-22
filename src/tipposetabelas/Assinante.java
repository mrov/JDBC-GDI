package tipposetabelas;

public class Assinante {

	private String CPF;
	private String Nome;
	private String DataNasc;
	private char Sexo;
	private String Telefones;
	private String Endereco;
	private String Pacote;
	private String DataAssin;
	
	public Assinante(String CPF, String Nome,String DataNasc,char Sexo,String Telefones, String Endereco,String Pacote,String DataAssin){
		this.CPF = CPF;
		this.Nome = Nome;
		this.DataNasc = DataNasc;
		this.Sexo = Sexo;
		this.Telefones = Telefones;
		this.Endereco = Endereco;
		this.Pacote = Pacote;
		this.DataAssin = DataAssin;
	}
	
	public String AddAssinante(){
		//INSERT INTO tb_assinante VALUES('123456789-45', 'Leonardo Alves', TO_DATE('16/12/1996', 'dd/MM/yyyy'), 'M', varray_fones(tp_fone('081-982661311'), tp_fone('074-9818-9022'),tp_fone('074-999473373')), tp_endereco('44900000', 'Irecê','Bairro','Rua Aquela Mesma','16') ,(Select REF(p) from tb_plano p where p.descricao = 'Combo'),   TO_DATE('05/04/2013', 'dd/MM/yyyy'));
		
		String AdicionarCompleto = "INSERT INTO tb_assinante VALUES('"+ CPF + "', '" + Nome + "', TO_DATE('" + DataNasc + "', 'dd/MM/yyyy'), '" + Sexo + "', " + Telefones + ", " + Endereco + ", (Select REF(p) from tb_plano p where p.descricao = '" + Pacote + "'), TO_DATE('" + DataAssin + "', 'dd/MM/yyyy'))";
		return AdicionarCompleto;
	}
	
}
