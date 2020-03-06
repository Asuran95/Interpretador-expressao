import java.util.ArrayList;
import java.util.List;

public class Calculadora {
		
	public int executar(String codigo) {
		
		Pilha<Operandos> pilha = new Pilha<>();
		
		int resultado = 0;
		
		for(char c : codigo.toCharArray()) {
			
			if(c == 40) {
				pilha.push(new Operandos());
				
			} else if(c >= 48 && c <= 57) {
				int numero = c - 48;
				
				pilha.peek().addNumero(numero);
					
			} else if(c != ' ' && c != 41) {
				
				if(c == '*') { 
					resultado = pilha.peek().calcular(numeros -> {
						int r = 1;
						
						for(int n : numeros) {
							r *= n;
						}
						return r;
					});

				} else if(c == '+') {
					resultado = pilha.peek().calcular(numeros -> {
						int r = 0;
						
						for(int n : numeros) {
							r += n;
						}
						return r;
					});
					
				} else if(c == '/') {
					resultado = pilha.peek().calcular(numeros -> {
						int r = numeros[0];
						
						for(int a=1; a<numeros.length; a++) {
							r /= numeros[a];
						}
						return r;
					});
				}
						
				pilha.pop();
				
				if(pilha.size() > 0) {
					pilha.peek().addNumero(resultado);
				}
			}
		}
		return resultado;
	}
	
	class Operandos {
		
		private List<Integer> numeros = new ArrayList<>();
		
		public void addNumero(int num) {
			numeros.add(num);
		}
		
		public int calcular(Operacao calc) {
			return calc.calcular(numeros.toArray(new Integer[numeros.size()-1]));
		}	
	}
}
