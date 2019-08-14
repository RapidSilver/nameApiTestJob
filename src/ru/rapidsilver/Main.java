package ru.rapidsilver;

import java.util.Scanner;
// делал с целыми числами, в целом можно инты заменить на бигинты или даблы, смысл никак не поменяется

public class Main {

    static Scanner scanner = new Scanner(System.in);
//    const
    private static final String WELCOME = "Добро пожаловать в программу THING(с) - мы обрабатываем для вас числа со времен 32го президента США";
    private static final String MENU = "Чего изволите? \nВведите 1 чтобы посмотреть минимальное значение вашей коллекции \n" +
                                        "Введите 2 чтобы посмотреть максимальное значение вашей коллекции \n" +
                                        "Введите 3 чтобы посмотреть среднее арифметическое значение всех чисел вашей коллекции \n" +
                                        "Введите 4 чтобы посмотреть все параметры \n" +
                                        "Введите 5 чтобы добавить еще одно одно значение к вашей коллекчии \n" +
                                        "Введите 0 для окончания работы с приложением (внимание, данные не сохраняются) \n";
    private static final String MIN = "Минимальное значение коллекции - ";
    private static final String MAX = "Максимальное значение коллекции - ";
    private static final String AVERAGE = "Среднее арифметическое значение всех чисел вашей коллекции - ";
    private static final String BY = "Спасибо что пользуетесь нашим приложением. Возвращайтесь :)";
    private static final String SET_NUMBER = "Введите число: ";
    private static final String COLLECTION = "В вашей коллекции ";
    private static final String NUMBERS = " чисел(ла)\n";
    private static final String EX_MENU = "Придерживайтесь меню!";
    private static final String EX_NUMBER = "Вы ввели не целое число.... или вообще не число.... или исключительно большое(малое) число, " +
                                            "\nне надо нас обманывать и старайтесь придерживаться разумных пределов. Попробуйте еще раз: ";
    private static final String DECORATOR_UP = "---------------------------------------------------------\n";
    private static final String DECORATOR_DOWN = "\n---------------------------------------------------------";


    public static void main(String[] args) {
        Thing thing = new Thing();
        System.out.println(WELCOME);
        thing.setNumber(validateNumber());
        boolean accept = true;
        while (accept) {
            System.out.println(COLLECTION + thing.getNumbers().size() + NUMBERS);
            System.out.println(DECORATOR_UP + MENU + DECORATOR_DOWN);
            String value = scanner.nextLine();
            if (value.equals("1")) System.out.println(DECORATOR_UP + MIN + thing.getMinNumber()+ DECORATOR_DOWN);
            else if (value.equals("2"))
                System.out.println(DECORATOR_UP + MAX + thing.getMaxNumber()+ DECORATOR_DOWN);
            else if (value.equals("3"))
                System.out.println(DECORATOR_UP + AVERAGE + thing.getAverageNumber()+ DECORATOR_DOWN);
            else if (value.equals("4"))
                System.out.println(DECORATOR_UP + MIN + thing.getMinNumber() + ". " + MAX + thing.getMaxNumber() + ". " + AVERAGE + thing.getAverageNumber() + ". " + DECORATOR_DOWN);
            else if (value.equals("5")) thing.setNumber(validateNumber());

            else if (value.equals("0"))  {
                System.out.println(DECORATOR_UP + BY + DECORATOR_DOWN);
                break;
            }
            else System.out.println(DECORATOR_UP + EX_MENU+ DECORATOR_DOWN);
        }
    }

    private static Integer validateNumber() {
        System.out.println(SET_NUMBER);
        boolean accept = true;
        int numberValue = 0;
        while (accept) {
            accept = false;
            String textValue = scanner.nextLine();
            try {
                numberValue = Integer.parseInt(textValue);
            }catch (NumberFormatException e) {
                System.out.println(EX_NUMBER);
                accept = true;
            }
        }
        return numberValue;
    }
}
