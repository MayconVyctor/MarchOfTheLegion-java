# ️ March of the Legion - Battle Simulator

Este projeto é um simulador de estratégia e formação militar desenvolvido como parte dos estudos de **Programação **. O sistema utiliza conceitos avançados de Programação Orientada a Objetos (POO) e análise de algoritmos para organizar tropas em um campo de batalha dinâmico.

## 🚀 Funcionalidades

- **Múltiplos Motores de Ordenação**: Escolha entre 5 algoritmos clássicos para organizar as tropas.
- **Renderização Gráfica em Console**: Exibição de matrizes dinâmicas que se adaptam ao tamanho do campo (`f`).
- **Configuração via CLI**: Totalmente controlado por argumentos de linha de comando.
- **Estratégia de Posicionamento**: Organização baseada na hierarquia militar (Prioridade) e orientação geográfica (N, S, E, W).

## 📊 Algoritmos de Ordenação

O projeto demonstra a diferença de performance e estratégia entre algoritmos de complexidade quadrática e logarítmica:

| Algoritmo | Sigla | Complexidade | Característica |
| :--- | :---: | :---: | :--- |
| **Insertion Sort** | `i` | $O(n^2)$ | Ótimo para conjuntos pequenos ou quase ordenados. |
| **Selection Sort** | `s` | $O(n^2)$ | Minimiza o número de trocas de memória. |
| **Bubble Sort** | `b` | $O(n^2)$ | Didático e focado em trocas adjacentes. |
| **Quick Sort** | `q` | $O(n \log n)$ | Dividir para conquistar; alta performance. |
| **Merge Sort** | `m` | $O(n \log n)$ | Algoritmo estável com tempo de execução garantido. |

## 🛠️ Conceitos de Programação Aplicados

1. **Abstração**: Uso da classe abstrata `Tropa` para definir comportamentos base.
2. **Herança e Polimorfismo**: Subclasses (`Tanque`, `Medico`, etc.) que herdam de `Tropa` e são tratadas de forma genérica nas listas de ordenação.
3. **Encapsulamento**: Uso rigoroso de modificadores de acesso (`private`, `protected`, `public`).
4. **Tratamento de Exceções**: Validação robusta de entradas para evitar erros em tempo de execução.
5. **Arquitetura em Camadas**: Separação clara entre modelos, lógica de negócio (sort) e utilitários de impressão.

## 🕹️ Como Usar

Compile o projeto e execute via terminal utilizando o seguinte padrão de parâmetros:

```bash
java Main a=q t=c u=2,2,4,2,2 f=12 o=n