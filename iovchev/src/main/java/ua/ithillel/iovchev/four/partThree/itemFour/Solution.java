package ua.ithillel.iovchev.four.partThree.itemFour;

    /*4. Определить класс `Reader`, хранящий такую информацию о пользователе библиотеки: `ФИО`,
            `номер читательского билета`, `факультет`, `дата рождения`, `телефон`. Методы `takeBook()`, `returnBook()`.
     - Перегрузить методы `takeBook()`, `returnBook()`:
     - `takeBook`, который будет принимать количество взятых книг. Выводит на консоль сообщение "Петров В. В. взял 3 книги".
     - `takeBook`, который будет принимать переменное количество названий книг.
            Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
     - `takeBook`, который будет принимать переменное количество объектов класса `Book`(создать новый класс, содержащий имя и автора книги).
            Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
    Аналогичным образом перегрузить метод `returnBook()`. Выводит на консоль сообщение
    "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия". Или  "Петров В. В. вернул 3 книги".*/

public class Solution {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.takeBook(3);
        reader.takeBook("Приключения", "Словарь", "Энциклопедия");
        reader.takeBook(new Book("Приключения","Киплинг"), new Book("Словарь", "Симпсон"), new Book("Энциклопедия", "Иванов"));

        reader.returnBook(2);
        reader.returnBook("Приключения", "Словарь");
        reader.returnBook(new Book("Приключения","Киплинг"), new Book("Словарь", "Симпсон"), new Book("Энциклопедия", "Иванов"));
    }
}
