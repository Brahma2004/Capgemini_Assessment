package TestScripts;
import java.io.IOException;
import org.testng.annotations.Test;
import Base_Class.BaseTest;
import Orange_POM.AddVacancyPage;
import Orange_POM.Login_Page;
import Orange_POM.RecruitmentPage;
import Orange_POM.Vacancies_Page;
import Utilities.ExcelUtility;

public class OrangeHRM_Test extends BaseTest {
    @Test
    public void createVacancyTest() throws IOException {
        String vacancyName = ExcelUtility.getData("Sheet1", 1, 0);
        String jobTitle = ExcelUtility.getData("Sheet1", 1, 1);
        String description = ExcelUtility.getData("Sheet1", 1, 2);
        String hiringManager = ExcelUtility.getData("Sheet1", 1, 3);
        String positions = ExcelUtility.getData("Sheet1", 1, 4);

        Login_Page loginPage = new Login_Page(driver, wait);
        loginPage.login(username, password);

        RecruitmentPage recruitmentPage = new RecruitmentPage(driver, wait);
        recruitmentPage.clickRecruitment();
        recruitmentPage.clickVacancies();

        Vacancies_Page vacanciesPage = new Vacancies_Page(driver, wait);
        vacanciesPage.clickAdd();

        AddVacancyPage addVacancyPage = new AddVacancyPage(driver, wait);
        addVacancyPage.enterVacancyName(vacancyName);
        addVacancyPage.selectJobTitle(jobTitle);
        addVacancyPage.enterDescription(description);
        addVacancyPage.selectHiringManager(hiringManager);
        addVacancyPage.enterNumberOfPositions(positions);
        addVacancyPage.clickSave();
    }
}