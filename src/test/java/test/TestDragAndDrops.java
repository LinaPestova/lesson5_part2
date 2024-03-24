package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class TestDragAndDrops {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void changeDragAndDrops(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void theSecondOptionOfChangeDragAndDropsTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }
}
