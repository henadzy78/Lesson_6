package Tests;

import org.openqa.selenium.By;

public class CssSelectors {

    private void cssSelectors(){
        By classSelector = By.cssSelector(".radio"); // Поиск по классу radio
        By classSelector1 = By.className(".radio"); // Поиск по классу radio

        By idSelector = By.cssSelector("#suite_mode_single"); //Поиск по id
        By idSelector1 = By.id("#suite_mode_single"); //Поиск по id

        By tagSelector = By.cssSelector("label"); //Поиск по tag
        By tagSelector1 = By.tagName("label"); //Поиск по tag

        By tagAttributeSelector = By.cssSelector("label[for='name']"); //Поиск по tag и атрибуту с значениями
        By tagAttributeSelector1 = By.cssSelector("label[for]"); //Поиск по tag и присутствием атрибута

        By multipleClassesSelector = By.cssSelector(".column.overflow-content"); //Поиск по двум классам в элементе

        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); //Поиск простого дочернего элемента

        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner"); //Использование трехуровненвой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); //Поиск c вхождением подстроки в значении аттрибута

        By searchByWordSelector = By.cssSelector("form[action~='admin']"); //Поиск с вхождением слова в значчении аттрибута

        By valueStartsFromSelector = By.cssSelector("a[href^='https://']"); //Поиск элемента с аттрибутом значение которго начинается со значения указанного

        By valueEndsWithSelector = By.cssSelector("a[href$='@gmail.com']"); // Поиск элемента с аттрибутом значение которго заканчивается на











    }
}

