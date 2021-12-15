package Tests;

public class xPathSelectors {

    //1.
    private static String absolutePath = "/html/body/div";

    //2. Все элементы на странице начиная с html-тэга
    private static String allElementsInHTMLPath = "//*";

    //3. Элемент по тэгу
    private static String bodyPath = "//body";

    //4. Дочерний элемент относительно родителя
    private static String childPath = "//form/input";

    //5. Поиск элемента с аттрибутом и его значением
    private static String tagWithAttrPath = "//span[@id='access--1']";

    //6. Поиск родителя у элемента с аттрибутом и его значением
    private static String parentPath1 = "//span[@id='access--1']/..";
    private static String parentPath2 = "//*[@id='suite_mode_single']/parent::label";

    //7. Поиск элемента по индексу
    private static String elementByIndexPath = "(//form)[4]";

    //8. Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath = "//*[text() = 'New Widget']";
    private static String searchByTextPath1 = "//*[. = 'New Widget']";

    //9. Поиск элемента по подстроке в тексте
    private static String searchBySubstringPath = "//*[contains(text(),'Widget')]";

    //10. Поиск элемента по аттрибуту значение которого начинается с
    private static String searchByStartsWithPath = "//input[starts-with(@type, 'hi')]";

    //11. Использование логического оператора
    private static String searchByTwoAttrPath = "//*[@class=\"form-control \" and @type='text']";

    //12. Использование логического оператора
    private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";


    //Axes-оси
    //13. Использование ancestor - все предки текущего узла
    private static String path1 = "//*[@id='suite_mode_single_baseline']/ancestor::div";

    //14. Использование child - все предки текущего узла зависят от уровня
    private static String path2_1 = "//ul/child::li";
    private static String path2_2 = "//ul/li";           //аналог только проще

    //15. Использование descendant - все предки текущего узла не зависимо от уровня
    private static String path3_1 = "//ul/descendant::span";
    private static String path3_2 = "//ul//span";           //аналог только проще

    //16. Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//label[@for='announcement']/following::form";
    private static String path4_2 = "(//label[@for=\"announcement\"]/following::div/*[@class='checkbox'])[1]";

    //17. Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static String path5_1 = "//label[@for=\"announcement\"]/following-sibling::div";

     //18. Использование preceding - Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static String path6_1 = "//label[@for=\"announcement\"]/preceding::div";

    //19. Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    private static String path7_1 = "//label[@for=\"announcement\"]/preceding-sibling::div";










}
