package worldathleticsPrj.CrawlingComment_clean;
//Men Indoor

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class no4 {
	   // ũ�ҵ���̹� ����
	   public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	   public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe";

	   // main
	   public static void main(String[] args) throws IOException {
	      // ���� ������
		   File fileSave = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\crawlingData4.csv");

	      BufferedWriter bw = new BufferedWriter(new FileWriter(fileSave));
	      // ũ�ҵ���̹� ����
	      try {
	         System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	      } catch (Exception e) {
	      }
	      ChromeOptions options = new ChromeOptions();
	      WebDriver driver = new ChromeDriver(options);
	      String totalData = "";
	      String totaltitle = "";
	      
	      // ����Ʈ ����
	         driver.get("https://www.worldathletics.org/records/by-category/world-records"); // ������
	         
	         // ����Ʈ ���� �� cookies �˾� Ŭ���ؼ� �˾����ֱ�
	         try {
	            Thread.sleep(3000); // 3��
	            driver.findElement(By.xpath("/html/body/div[7]/div")).click();
	            Thread.sleep(3000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         // Men Indoor tab Ŭ��
	         try {
	               driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/ul/li[4]/a")).click();
	               Thread.sleep(2000);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         
	         // progression tr�� �ళ��_ tr�� ��
	         int progressionTrSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div[4]/table/tbody/tr")).size();
	         System.out.println(progressionTrSize);
	         
	         for(int k = 1; k < progressionTrSize; k++) {
	         
	        //back�������� �ʱ�ȭ���� tab1�� ����ǹǷ�	 
	        //Men Indoor tab ��Ŭ��
	         try {
	            driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/ul/li[4]/a")).click();
	            Thread.sleep(3000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         
	         // Progression ȭ��ǥ Ŭ��
	         driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div[4]/table/tbody/tr[" + k + "]/td[2]/a/i")).click();
	         
	         // ���� ��ư Ŭ�� �� �ε��ð� ����� ���
	         try {
	            Thread.sleep(3000); // 3��
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }

	         String tempRecordStart = "/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr[";
	         String tempRecordMiddle = "]/td[";
	         String tempRecordEnd = "]";
	         
	         //�ش� ���̺��� �� ����!!!!************************    ������ table/thead/tr/th �� ã�ƾ��Ѵ�.
	         int thSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/thead/tr/th")).size();
	         System.out.println("thSize => " + thSize);
	         
	         // �ش� ���� ���̺� �� ���� ȹ��
	         int innerRecordTableSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr")).size();
	         System.out.println(innerRecordTableSize);
	         
	         System.out.println("ũ�Ѹ� ����");
	         
	         //���� ���̺��� ���
	         if (thSize == 7) {
	            String mark = "";
	            String wind = "";
	            String competitor = "";
	            String dob = "";
	            String country = "";
	            String venue = "";
	            String date = "";
	            
	            for (int i = 1; i <= innerRecordTableSize; i++) {
	               mark = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 1 + tempRecordEnd))
	                     .getText();
	               wind = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 2 + tempRecordEnd))
	                     .getText();
	               competitor = driver
	                     .findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 3 + tempRecordEnd))
	                     .getText();
	               dob = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 4 + tempRecordEnd))
	                     .getText();
	               country = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 5 + tempRecordEnd))
	                     .getText();
	               venue = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 6 + tempRecordEnd))
	                     .getText();
	               date = driver.findElement(By.xpath(tempRecordStart + i + tempRecordMiddle + 7 + tempRecordEnd))
	                     .getText();

	               if (mark.contains(",")) {
	                  mark = mark.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (wind.contains(",")) {
	                  wind = wind.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (competitor.contains(",")) {
	                  competitor = competitor.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (dob.contains(",")) {
	                  dob = dob.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (country.contains(",")) {
	                  country = country.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (venue.contains(",")) {
	                  venue = venue.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (date.contains(",")) {
	                  date = date.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               // �ѹ��� �� �پ� �Է�
	               totalData = mark + "," + wind + "," + competitor + "," + dob + "," + country + "," + venue + ","
	                     + date;

	               // ���Ͼ���
	               bw.write(totalData);
	               bw.newLine(); // �� �� ���� �ٹٲ�
	            }
	         } else if (thSize == 6) { // ���������̺�
	            String tempRecordStart2 = "/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr[";
	            String tempRecordMiddle2 = "]/td[";
	            String tempRecordEnd2 = "]";

	            // �ش� ���� ���̺� �� ���� ȹ��
	            int innerRecordTableSize2 = driver
	                  .findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr"))
	                  .size();
	            System.out.println(innerRecordTableSize2);

	            System.out.println("ũ�Ѹ� ����");

	            String mark = "";
	            String wind = "";
	            String competitor = "";
	            String dob = "";
	            String country = "";
	            String venue = "";
	            String date = "";
	            
	            for (int i = 1; i <= innerRecordTableSize; i++) {
	               mark = driver.findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 1 + tempRecordEnd2))
	                     .getText();
	               wind = " ";
	               competitor = driver
	                     .findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 2 + tempRecordEnd2))
	                     .getText();
	               dob = driver.findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 3 + tempRecordEnd2))
	                     .getText();
	               country = driver
	                     .findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 4 + tempRecordEnd2))
	                     .getText();
	               venue = driver.findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 5 + tempRecordEnd2))
	                     .getText();
	               date = driver.findElement(By.xpath(tempRecordStart2 + i + tempRecordMiddle2 + 6 + tempRecordEnd2))
	                     .getText();

	               if (mark.contains(",")) {
	                  mark = mark.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (wind.contains(",")) {
	                  wind = wind.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (competitor.contains(",")) {
	                  competitor = competitor.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (dob.contains(",")) {
	                  dob = dob.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (country.contains(",")) {
	                  country = country.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (venue.contains(",")) {
	                  venue = venue.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               if (date.contains(",")) {
	                  date = date.replace(",", "*"); // ��Ͽ� �ִ� �޸� *�� ó��
	               }

	               // �ѹ��� �� �پ� �Է�
	               totalData = mark + "," + wind + "," + competitor + "," + dob + "," + country + "," + venue + ","
	                     + date;

	               // ���Ͼ���
	               bw.write(totalData);
	               bw.newLine(); // �� �� ���� �ٹٲ�
	            }
	         }
	         try {
	         driver.navigate().back();
	         Thread.sleep(3500); // �ڷΰ��� �� 3.5�� ���
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         }

	         bw.close();
	         System.out.println("ũ�Ѹ� ����");
	      } // main
	   } // class