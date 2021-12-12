package Tests;

import org.openqa.selenium.By;

public class HW_CSS {

    //1. Перейти по ссылке https://masterskayapola.ru/kalkulyator/laminata.html

    By classSelector2 = By.cssSelector(".post-single"); // Поиск по классу post-single

    By idSelector2 = By.id("#interstitial-mega-wrapper"); //Поиск по id

    By tagSelector2 = By.cssSelector("input"); //Поиск по tag

    By tagAttributeSelector2 = By.cssSelector("optgroup[label='Черновой пол »']"); //Поиск по tag и атрибуту с значениями

    By tagAttributeSelector3 = By.cssSelector("optgroup[label]"); //Поиск по tag и присутствием атрибута

    By multipleClassesSelector1 = By.cssSelector(".ya-site-form.ya-site-form_inited_yes"); //Поиск по двум классам в элементе

    By simpleHierarchicalSelector1 = By.cssSelector(".comment-form .comment-notes"); //Поиск простого дочернего элемента

    By fullHierarchicalSelector1 = By.cssSelector("body .comment-form .comment-notes"); //Использование трехуровненвой иерархии для поиска дочернего элемента

    By searchLikeContainsSelector1 = By.cssSelector("form[action*='masterskayapola']"); //Поиск c вхождением подстроки в значении аттрибута

    By searchByWordSelector1 = By.cssSelector("input[class~='change_bias']"); //Поиск с вхождением слова в значении аттрибута

    By valueStartsFromSelector1 = By.cssSelector("a[href^='http://']"); //Поиск элемента с аттрибутом значение которго начинается со значения указанного

    By valueEndsWithSelector1 = By.cssSelector("a[href$='l7n']"); // Поиск элемента с аттрибутом значение которго заканчивается на

    By childRightAfterParentSelector1 = By.cssSelector("ul>li>a"); //Поиск дочернего "a"

    By elementRightAfterElementSelector1 = By.cssSelector(".main-container+ins"); //Поиск элемента ins который идет сразу после элемента main-container

    By elementOnTheSameLevelSelector1 = By.cssSelector(".main-container~div"); //Поиск элементов div которым предшевствует элемент main-container

    By firstChildSelector1 = By.cssSelector("ul:first-child"); //Поиск первого дочернего элемента

    By lastChildSelector1 = By.cssSelector("ul:last-child"); //Поиск последнего дочернего элемента

    By nthChildFromBeginSelector1 = By.cssSelector("li:nth-child(2)"); //Поиск н-го дочернего элемента с начала

    By nthChildFromEndSelector1 = By.cssSelector("li:nth-last-child(3)"); //Поиск н-го дочернего элемента с конца


}
