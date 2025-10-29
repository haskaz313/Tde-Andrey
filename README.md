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
=== VETOR 1 ===
Algoritmo       Trocas          Iterações      
BubbleSort flag 78              180            
SelectionSort   18              190            
CocktailSort    78              154            
CombSort        22              129            
GnomeSort       78              176            
BucketSort      19              39   

# Resultados – Vetor 2 (Já Ordenado)
=== VETOR 2 ===
Algoritmo       Trocas          Iterações      
BubbleSort flag 0               19             
SelectionSort   0               190            
CocktailSort    0               19             
CombSort        0               110            
GnomeSort       0               20             
BucketSort      0               20      

# Resultados – Vetor 3 (Invertido)
=== VETOR 3 ===
Algoritmo       Trocas          Iterações      
BubbleSort flag 190             190            
SelectionSort   10              190            
CocktailSort    190             190            
CombSort        18              129            
GnomeSort       190             400            
BucketSort      63              83     
# Ranking Geral – Desempenho dos Algoritmos de Ordenação

## Cálculo
O ranking abaixo foi obtido somando o total de **trocas** e **iterações** realizadas por cada algoritmo nos três vetores de teste.  
Quanto menor o valor total, melhor o desempenho geral do algoritmo.

---

## Soma Total (Trocas + Iterações)

| Posição | Algoritmo        | Total Trocas | Total Iterações | Soma Geral |
|----------|------------------|---------------|------------------|-------------|
| 1 | **Bucket Sort**      | 82  | 142 | **224** |
| 2 | **Comb Sort**        | 40  | 368 | **408** |
| 3 | **Cocktail Sort**    | 268 | 363 | **631** |
| 4 | **Bubble Sort Flag** | 268 | 389 | **657** |
| 5 | **Selection Sort**   | 28  | 570 | **598** |
| 6 | **Gnome Sort**       | 268 | 596 | **864** |

---

## Ranking Final

| Classificação | Algoritmo | Desempenho Geral |
|----------------|------------|------------------|
| 1º | Bucket Sort | Melhor resultado geral (menor soma total) |
| 2º | Comb Sort | Equilíbrio entre trocas e iterações |
| 3º | Cocktail Sort | Desempenho razoável, mas mais custoso |
| 4º | Bubble Sort Flag | Bom em vetores ordenados, mas fraco em outros |
| 5º | Selection Sort | Poucas trocas, mas muitas iterações |
| 6º | Gnome Sort | Pior desempenho geral, principalmente em vetores invertidos |

# Conclusao
De modo geral, o algoritmo Comb Sort apresentou o melhor equilíbrio entre trocas e iterações, superando os demais na maioria dos cenários.
O Bubble Sort com flag se destacou em vetores já ordenados, pois encerra precocemente.
O Bucket Sort mostrou bom desempenho em vetores com distribuição uniforme, embora possua sobrecarga de estruturação.

