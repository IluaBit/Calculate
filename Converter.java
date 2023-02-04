import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Converter {
    I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
    private int number;
    Converter(int number)
    {
        this.number =number;
    }
       public int getNumber()
       {
           return number;
       }
       public static List<Converter> getReverseSortedValues()
       {
           return Arrays.stream(values()).sorted(Comparator.comparing((Converter e) -> e.number).reversed()).collect(Collectors.toList());
       }
       public static String  arabicToRoman(int num)
       {
         if((num <= 0) ||(num > 4000))
         {
             System.out.println(num + " значение вне интервала  римских чисел[0 .. 4000]");
         }
         List<Converter> romanNumerals = Converter.getReverseSortedValues();
         int i = 0;
         StringBuilder sb = new StringBuilder();
         while ((num > 0) && (i < romanNumerals.size()))
         {
             Converter currentSymbol = romanNumerals.get(i);
             if (currentSymbol.getNumber() <= num)
             {
                 sb.append(currentSymbol.name());
                 num -= currentSymbol.getNumber();
             }
             else
             {
                 i++;
             }
         }
         return sb.toString();
       }

       public static int romanToArabic(String input)
       {
           String romanNumeral = input.toUpperCase();
           int result = 0;
           List<Converter> romanNumerals = Converter.getReverseSortedValues();
           int i = 0;
           while ((romanNumeral.length()>0) && (i < romanNumerals.size()))
           {
               Converter symbol = romanNumerals.get(i);
               if (romanNumeral.startsWith(symbol.name()))
               {
                   result += symbol.getNumber();
                   romanNumeral = romanNumeral.substring(symbol.name().length());
               }
               else
               {
                   i++;
               }
           }
           if (romanNumeral.length() > 0)
           {
               throw new IllegalArgumentException(input + " нельзя конвертировать в римское число");
           }
           return result;
       }


}
