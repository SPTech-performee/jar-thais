package API;

import Dao.DaoDados;
import modelo.Componentes;
import modelo.Leituras;
import java.util.Scanner;

public class ApiLooca {
    public static void main(String[] args) {

        DaoDados dao = new DaoDados();
        Scanner leitor = new Scanner(System.in);

        Integer opcao;

        System.out.println("""
                +-------------------------------+
                |   Bem vindo ao performee.     |""");
        while (true) {



            System.out.println("""
                    +-------------------------------+
                    | 1) Cadastrar componentes      |
                    | 2) Atualizar componentes      |
                    | 3) Inserir dados de leitura   |
                    | 4) Ver Componentes            |
                    | 5) Ver Leituras               |
                    | 6) Saiba mais                 |
                    | 7) Sair                       |
                    +-------------------------------+""");

            opcao = leitor.nextInt();


            switch (opcao) {
                case 1: {
                    dao.inserirComponente();
                    break;
                }
                case 2: {
                    Integer opcaoAtualizar;
                    do {
                            System.out.println("""
                            +--------------------------------------+
                            | Qual componente deseja atualizar?    |
                            +--------------------------------------+
                            | 1) Atualizar CPU                     |
                            | 2) Atualizar RAM                     |
                            | 3) Atualizar Tudo                    |
                            | 4) Cancelar                          |
                            +--------------------------------------+""");
                            opcaoAtualizar = leitor.nextInt();

                            dao.atualizarComponete(opcaoAtualizar);
                    } while (opcaoAtualizar != 4);
                    break;
                }
                case 3: {
                    Integer opcaoComponente;
                    do {
                        System.out.println("""
                            +-------------------------+
                            | Enviar dados Leitura    |
                            +-------------------------+
                            | 1) CPU                  |
                            | 2) RAM                  |
                            | 3) Disco                |
                            | 4) Rede                 |
                            | 5) Voltar               |
                            +-------------------------+""");

                        opcaoComponente = leitor.nextInt();

                        switch (opcaoComponente) {
                            case 1: {
                                System.out.println("Enviando dados da CPU....");
                                dao.inserirLeitura(1);
                                break;
                            }
                            case 2: {
                                System.out.println("Enviando dados da RAM....");
                                dao.inserirLeitura(2);
                                break;
                            }
                            case 3: {
                                dao.inserirLeitura(3);
                                break;
                            }
                            case 4: {
                                dao.inserirLeitura(4);
                                break;
                            }
                            case 5: {
                                System.out.println("Voltando para o inicio...");
                                break;
                            }
                            default: {
                                System.out.println("Opção inválida! digite novamente");
                                break;
                            }
                        }
                    } while (opcaoComponente != 5);
                    break;
                }
                case 4: {
                    System.out.println("""
                            +----------------------------+
                            | Componentes:               |
                            +----------------------------+""");
                    for (Componentes comp : dao.exibirComponentes()) {
                        System.out.println(comp);
                    }
                    break;
                }
                case 5: {
                    System.out.println("""
                            +----------------------------+
                            | Leituras:                  |
                            +----------------------------+""");
                    for (Leituras leit : dao.exibirLeituras()) {
                        System.out.println("-".repeat(30));
                        System.out.println(leit);
                    }
                    break;
                }
                case 6: {
                    System.out.println("""
                            +-------------------------------------------------------+
                            A solução de monitoramento de servidor da Performee 
                            é uma ferramenta robusta e eficaz projetada para 
                            garantir o desempenho e a disponibilidade contínuos 
                            dos servidores de sua empresa. Com recursos avançados 
                            de monitoramento em tempo real, alertas proativos e 
                            uma interface intuitiva, a Performee oferece um 
                            controle completo sobre o estado e a saúde de 
                            seus servidores. Com essa solução, você pode 
                            detectar problemas antes que eles afetem os 
                            negócios, reduzir o tempo de inatividade e 
                            otimizar o uso dos recursos de servidor. Mantenha 
                            seus sistemas funcionando de maneira confiável 
                            e eficiente com a solução de monitoramento 
                            de servidor da Performee. Saiba mais para obter 
                            detalhes sobre como a Performee pode fortalecer 
                            a infraestrutura de sua empresa.
                            +-------------------------------------------------------+
                            """);
                }
                break;

                case 7: {
                    System.out.println("""
                            Saindo...""");
                    System.exit(0);
                }


                default: {
                    System.out.println("Opção inválida! digite novamente");
                }
            }
        }

    }
}

