import java.util.Scanner;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(true) {
            System.out.println("1 Простые числа; 2 Калькулятор; 3 Палиндром; 4 Температура; 0 Выход");
            if (!input.hasNextLine()) break;
            String choice=input.nextLine().trim(); if(choice.equals("0")) break;
            try {
                switch(choice) {
                    case "1" -> { System.out.print("N: ");System.out.println(Primes.upTo(Integer.parseInt(input.nextLine()))); }
                    case "2" -> {
                        System.out.print("Первое число: ");BigDecimal a=new BigDecimal(input.nextLine().replace(',','.'));
                        System.out.print("Операция: ");String op=input.nextLine();
                        System.out.print("Второе число: ");BigDecimal b=new BigDecimal(input.nextLine().replace(',','.'));
                        System.out.println(Calculator.calculate(a,op,b));
                    }
                    case "3" -> { System.out.print("Строка: ");System.out.println(Palindrome.check(input.nextLine())?"Палиндром":"Не палиндром"); }
                    case "4" -> {
                        System.out.print("1 C → F; 2 F → C: ");String direction=input.nextLine();
                        if(!direction.equals("1") && !direction.equals("2")) throw new IllegalArgumentException("Нет такого направления");
                        System.out.print("Температура: ");double value=Double.parseDouble(input.nextLine().replace(',','.'));
                        System.out.println(direction.equals("1")?Temperature.toFahrenheit(value):Temperature.toCelsius(value));
                    }
                    default -> System.out.println("Нет такого пункта");
                }
            } catch(IllegalArgumentException e) { System.out.println("Ошибка: "+e.getMessage()); }
            catch(java.util.NoSuchElementException e) { break; }
        }
        System.out.println("Работа завершена");
    }
}
