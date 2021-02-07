import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.w3c.dom.html.HTMLInputElement;

import java.nio.channels.InterruptedByTimeoutException;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class Email {
    @Test
    public void UserCanLogin(){
        open("https://mail.yandex.by/");
        $(By.xpath("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]")).click();
        $(By.xpath("//input[@id='passp-field-login']")).setValue("novik.vesta").pressEnter();
        $(By.xpath("//input[@id='passp-field-passwd']")).setValue("BrestMinsk").pressEnter();

        sleep(1000);
        $(By.xpath("//a[contains(@class,'mail-ComposeButton')]")).click();
        sleep(1000);
        $(By.xpath("//div[@class='composeYabbles']")).setValue("novik.vesta@yandex.by").pressEnter();
        $(By.xpath("//input[@name='subject']")).setValue("AutoTest1234");
        $(By.xpath("//div[contains(@class,'ComposeSendButton')]/button")).click();
        sleep(1000);

        Selenide.refresh();

        $(By.xpath("//span[contains(@class, 'mail-MessageSnippet-Item mail-MessageSnippet-Item_subject')]"))
                .find(withText("AutoTest1234")).shouldBe(visible);





    }


}
