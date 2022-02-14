/*********************************************************************/
/**   ACH2001 - Introdução à Programação                            **/
/**   EACH-USP - Primeiro Semestre de 2020                          **/
/**   <2020194> - <Norton Trevisan Roman>                           **/
/**                                                                 **/
/**   Segundo Exercício-Programa                                    **/
/**                                                                 **/
/**   <HEITOR LOPES BIANCHI>                   <10258730>           **/
/**                                                                 **/
/**   <07/05/2020>         		                                    **/
/*********************************************************************/

/*
	Cálculo para raiz quadrada
*/
public class Raiz {
	
	/*
		Calcula a raiz quadrada de um valor, com uma determinada
		precisão a partir do método de Newton. Retorna esse valor, ou -1 quando:
		
		* a < 0
		* epsilon <= 0
		* epsilon >= 1
		
		Parâmetro:
			a - valor cuja raiz quadrada será calculada
			epsilon - precisão do cálculo
	*/
	static double raizQuadrada(double a, double epsilon) {
		
		/*
			Declaramos e inicializamos aqui duas váriaveis que o método usará para calcular
			a raiz conforme o método de Newton.
		*/
		double x0 = a/2;
		double xi = 0.5*(x0+a/x0);
		
		/*
			Caso as condições para os valores de a ou epsilon não sejam atendidas o método retorna 
			o código de erro "-1".
		*/
		if (a < 0 || epsilon <= 0 || epsilon >= 1){
			return(-1);
		}
		
		/*
			Atendidas as especificações das variáveis o laço while calculará valores para
			para a raiz, tendo como método auxiliar "absoluto" que recebe x1 e x0 como parâmetros.
		*/
		else{		
			while (absoluto(xi, x0)>= epsilon){
				x0 = xi;
				xi = 0.5*(x0+a/x0);
			}
			return(x0);
		}
	}
		/*
			o método absoluto retorna o "módulo" da subtração que norteia a precisão dos
			cálculos do método raizQuadrada.
		*/
	public static double absoluto (double i, double zero){
		if (i - zero < 0){
			return((i-zero)*(-1));
		}
		else{
			return(i-zero);
		}
	}
	
	/*
		no main chamamos o método raizQuadrada para testar a efetividade de sua execução.
	*/
	public static void main(String[] args) {
	
		double valor = 63;
		double precisao = 0.001;
		System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, precisao));
	}
}