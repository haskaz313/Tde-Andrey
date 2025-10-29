# TDE Andrey 
Descrição

Este projeto tem como objetivo comparar o desempenho de seis algoritmos de ordenação:

Bubble Sort (com flag de parada)

Selection Sort

Cocktail Sort

Comb Sort

Gnome Sort

Bucket Sort

A análise considera dois critérios principais:

Quantidade de trocas entre elementos.

Quantidade de iterações (número de vezes que o laço foi executado).

Todas as implementações foram feitas em Java, sem utilização de funções prontas de ordenação.

# Resultados

Os testes foram realizados com os três vetores propostos, e os resultados foram registrados considerando o número de trocas e de iterações realizadas por cada algoritmo.

# Resultados – Vetor 1 (Desordenado Aleatoriamente)
Posição	Algoritmo	Trocas	Iterações
1	Comb Sort	Poucas	Poucas
2	Cocktail Sort	Média	Média
3	Gnome Sort	Alta	Alta
4	Selection Sort	Média	Alta
5	Bubble Sort Flag	Alta	Alta
6	Bucket Sort	Variável (depende da distribuição)	Média

# Resultados – Vetor 2 (Já Ordenado)
Posição	Algoritmo	Trocas	Iterações
1	Bubble Sort Flag	0 trocas	Poucas iterações (encerra cedo)
2	Cocktail Sort	0 trocas	Média
3	Comb Sort	0 trocas	Média
4	Selection Sort	Nenhuma troca, mas muitas comparações	Alta
5	Gnome Sort	Média	Alta
6	Bucket Sort	Boa, mas com overhead de distribuição	Média

# Resultados – Vetor 3 (Invertido)
Posição	Algoritmo	Trocas	Iterações
1	Comb Sort	Melhor eficiência geral	Menos iterações
2	Cocktail Sort	Média	Média
3	Bucket Sort	Boa	Média
4	Selection Sort	Média	Alta
5	Bubble Sort Flag	Alta	Alta
6	Gnome Sort	Muito ruim neste caso	Muitas iterações

# Conclusao
De modo geral, o algoritmo Comb Sort apresentou o melhor equilíbrio entre trocas e iterações, superando os demais na maioria dos cenários.
O Bubble Sort com flag se destacou em vetores já ordenados, pois encerra precocemente.
O Bucket Sort mostrou bom desempenho em vetores com distribuição uniforme, embora possua sobrecarga de estruturação.

