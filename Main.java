import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

       String[] operation = {"+","-","/","*"};
       String[] myOperation = {"\\+","-","/","\\*"};
       Scanner str = new Scanner(System.in);
       String exp = str.nextLine();
       exp = exp.replaceAll(" ","");
       int operatorIndex = -1;
       int x,y;

       for(int i = 0; i < operation.length; i++)
       {
         if(exp.contains(operation[i]))
         {
             operatorIndex = i;
             break;
         }
       }
       if(operatorIndex==-1)
       {
           System.out.println("Cтрока не является математической операцией");
           return;
       }
        String[] data = exp.split(myOperation[operatorIndex]);
        //int x,y;
        boolean isRoman = false;
        int a, b, result = 1;
       try
         {

             a = Integer.parseInt(data[0]);

           try
           {
               b = Integer.parseInt(data[1]);

           }
           catch (NumberFormatException e)
           {
               System.out.println("Ошибка ввода! Используются одновременно разные системы счисления число  " + data[1] +" неверно");
               return;
           }
         }
           catch (NumberFormatException e)
           {
               try
               {
                   a = Converter.romanToArabic(data[0]);

               }
               catch (IllegalArgumentException e1)
               {
                   System.out.println("Ошибка ввода! Используются одновременно разные системы счисления число  " + data[0] +" неверно");
                   return;
               }
               try
               {
                   b = Converter.romanToArabic(data[1]);

               }
                catch (IllegalArgumentException e1)
                {
                   System.out.println("Ошибка ввода! Используются одновременно разные системы счисления число  " + data[1] +" неверно");
                   return;
                }
               isRoman =true;
           }

       switch (operation[operatorIndex])
       {
           case "+": result = a+b;
                     break;
           case "-": result = a-b;
                     break;
           case "*": result = a*b;
                     break;
           case "/": result = a/b;
                     break;
       }
       if (isRoman)
       {
           System.out.println("Пример с римскими числами");
           System.out.println(data[0] + operation[operatorIndex] + data[1] + " = " + Converter.arabicToRoman(result));
       }
        else
       {
           System.out.println("Пример с арбскими числами");
           System.out.println(data[0] + operation[operatorIndex] + data[1] + " = " + result);
       }

       }


    }
