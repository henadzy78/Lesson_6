package Tests;

public class xPathSelectors {

    //Переходим по ссылке - https://masterskayapola.ru/

    //1.
    private static String absolutePath1 = "/html/body/div";

    //2. Все элементы на странице начиная с html-тэга
    private static String allElementsInHTMLPath1 = "//*";

    //3. Элемент по тэгу
    private static String bodyPath1 = "//body";

    //4. Дочерний элемент относительно родителя
    private static String childPath1 = "//div/a";

    //5. Поиск элемента с аттрибутом и его значением
    private static String tagWithAttrPath1 = "//span[@class='progress-text']";

    //6. Поиск родителя у элемента с аттрибутом и его значением
    private static String parentPath11 = "//span[@class='progress-text']/..";
    private static String parentPath21 = "//*[@class='hamburger hamburger--slider']/parent::div";

    //7. Поиск элемента по индексу
    private static String elementByIndexPath1 = "(//div)[3]";

    //8. Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath11 = "//*[text()= 'Популярные записи']";
    private static String searchByTextPath12 = "//*[. = 'Популярные записи']";

    //9. Поиск элемента по подстроке в тексте
    private static String searchBySubstringPath1 = "//*[contains(text(), 'Популярные')]";

    //10. Поиск элемента по аттрибуту значение которого начинается с
    private static String searchByStartsWithPath1 = "//input[starts-with(@type, 'but')]";

    //11. Использование логического оператора
    private static String searchByTwoAttrPath1 = "//*[@rel='nofollow' and @class='inactive']";

    //12. Использование логического оператора
    private static String searchBySpecificAttrPath1 = "//*[@href='#popular-posts' and @class='selected' and text()!='Популярные записи']";

    // Использование ancestor - все предки текущего узла
    //13. Использование child - все потомки текущего узла зависят от уровня
    private static String path2_11 = "//*[@id='content_box']/child::div";
    private static String path2_21 = "//ul/span";           //аналог только проще

    //14. Использование descendant - все потомки текущего узла не зависимо от уровня
    private static String path3_11= "//*[@id='content_box']//descendant::span";
    private static String path3_21 = "//ul//span";           //аналог только проще

    //15. Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_11 = "//*[@class='hamburger hamburger--slider']/following::div";
    private static String path4_21 = "//*[@class='hamburger hamburger--slider']/following::div/*[@id='wprmenu_menu_ul']";

    //16. Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static String path5_11 = "//*[@class='hamburger hamburger--slider']/following-sibling::div";

    //17. Использование preceding - Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static String path6_11 = "//*[@class='hamburger hamburger--slider']/preceding::span";

    //18. Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    private static String path7_11 = "//*[@id='wprmenu_bar']/preceding-sibling::div";



}
