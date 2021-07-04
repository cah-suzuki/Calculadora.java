package calculadora;
import java.util.Scanner;


public class Calculadora {
	public static void main(String[] args) {
	
   	 
	
	
	  double valorInvestido= lerValor();
	  double pessoasPorInvestimento = 30;
	  double visualizacaoInicial = pessoasPorInvestimento * valorInvestido;
	  double visualizacaoTotal = visualizacaoInicial;
	 
	   
//Testa se valor investido é maior que zero, se maior que zero, enquanto número de compartilhamentos menor que número máximo de
//Compartilhamentos (que é igual a 4) regra de negócio é somada a visualização total do anúncio
//se valor investido é igual a zero,programa encerra e mostra mensagem de erro
	  
	  
	  //TODO incluir esse teste junto ao loop de testes da função lerValor 
	  if (valorInvestido <=0) {
			System.out.println("Por favor entre com valor de investimento para ter acesso a simulação de alcance");
		} else {
			
			 //Loop se repete sempre as 4 vezes máximas de compartilhamentos, mesmo que compartilhamento seja menor que 1 inteiro 
			 for (int i=0;i<=3;i++) {
					
				 double visualizacaoNovaLoop = visualizacaoNova(visualizacaoInicial);
				 visualizacaoTotal += visualizacaoNovaLoop;
				 visualizacaoInicial = visualizacaoNovaLoop;
				 							 
			 }
             //Resultado considera apenas número sem casas decimais para resultado mais concreto ao cliente final			 
			    System.out.printf("Seu anuncio obteve: %.0f visualizações",visualizacaoTotal);
								 
		}
				
  }
		// Função recebe visualizações iniciais e retorna projeção de novas visualizações baseado em regras de negócio
	    // Todos os cálculos consideram o valor double resultante sem restrição de casa decimais (exceto por resultado de visualizaçãoTotal que é mostrado na tela ao cliente)
	    
		public static double visualizacaoNova(double visualizacaoInicial) {
			double baseVisualizacaoNova = 40;
			double baseCompartilha = 3;
			double baseClicks = 20;
			double baseVisualizacao = 12;
			double baseVisualizacaoPorClick = 100;
			 
			double totalClicks = (visualizacaoInicial * baseVisualizacao)/baseVisualizacaoPorClick;
			double totalCompartilha = (totalClicks * baseCompartilha) / baseClicks;
			double visualizacaoNova = totalCompartilha*baseVisualizacaoNova;
		
			return visualizacaoNova;
			
		}
		
		//Função para ler valor digitado pelo cliente, tratar exceções de input inválido e caso o input for inválido repetir a entrada do input
		
		public static double lerValor() {
			
			
			  Double valorInvestido = null;
			  Scanner sc = new Scanner(System.in);

			  while (valorInvestido == null) {
				  try {
				     System.out.print("Entre com valor de investimento: R$ ");
				     valorInvestido = sc.nextDouble();
			      }catch(Exception e){
					 System.out.println("Valor Inválido.Por favor digite valor numérico");
					 sc.nextLine();
					                                            
				  } 
			 }
			  sc.close();
			  return valorInvestido;
			
		}
		

}
