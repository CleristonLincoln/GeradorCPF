public class GerarListaCPF {

	public static void main(String[] args) throws FileNotFoundException {

		int cont = 0;
		
		File file = new File("F:\\resultado.txt");
			PrintWriter gerar = new PrintWriter(file);
	

		while (cont < 60000) {

			int soma1 = 0;
			int soma2 = 0;
			int peso1 = 10;
			int peso2 = 11;

			Random r = new Random();

			int[] numeros = new int[11];
			numeros[0] = r.nextInt(9);
			numeros[1] = r.nextInt(9);
			numeros[2] = r.nextInt(9);
			numeros[3] = r.nextInt(9);
			numeros[4] = r.nextInt(9);
			numeros[5] = r.nextInt(9);
			numeros[6] = r.nextInt(9);
			numeros[7] = r.nextInt(9);
			numeros[8] = r.nextInt(9);
			numeros[9] = r.nextInt(9);
			numeros[10] = r.nextInt(9);
			

			for (int i = 0; i < 9; i++) {
			
				soma1 += numeros[i] * peso1;
				peso1--;
			}

			int verificar = (soma1 * 10) % 11;

			Boolean validar1 = validarDigito(numeros, verificar, 9);

			for (int i = 0; i < 10; i++) {

				soma2 += numeros[i] * peso2;
				peso2--;
			}

			int verificar2 = (soma2 * 10) % 11;

			Boolean validar2 = validarDigito(numeros, verificar2, 10);

			System.out.println(validar1 +" - "+ validar2);
			if (validar1 == true && validar2 == true) {

				gerar.println(Arrays.toString(numeros));
//				System.out.println(Arrays.toString(numeros) );
						cont++;
			}
		}
		gerar.close();
	}

	private static Boolean validarDigito(int[] numeros, int verificar, int digito) {
		return verificar != numeros[digito] ? false : true;
	}

}
