import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class Main 
{
    public static char WhatKindOfGender(String patronymic)
    {
        char endChar = patronymic.charAt(patronymic.length() - 1);
        return endChar == 'а' ? 'Ж' : 'М';
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Введите Фамилию:");
        String surname = s.nextLine();

        System.out.println("Введите Имя:");
        String name = s.nextLine();

        System.out.println("Введите Отчество:");
        String patronymic = s.nextLine();
        
        LocalDate birth = null;
        while (birth == null)
        {
            System.out.println("Введите дату рождения (гггг-мм-дд):");
            String Birthday = s.nextLine();
            try {
                birth = LocalDate.parse(Birthday);
            } catch (DateTimeParseException e) {
                System.out.println("Неверный формат даты. Попробуйте снова.");
            }
        }

        LocalDate currentage = LocalDate.now();
        int age = Period.between(birth, currentage).getYears();

        String initial1 = Character.toString(name.charAt(0));
        String initial2 = Character.toString(patronymic.charAt(0));
        char gender = WhatKindOfGender(patronymic);

        System.out.println("Фамилия: " + surname);
        System.out.println("Инициалы: " + initial1 + "." + initial2 + ".");
        System.out.println("Пол: " + (gender == 'М' ? "Мужской" : "Женский"));
        System.out.println("Возраст: " + age + " лет");
    }
}
