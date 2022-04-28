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
	   // 크롬드라이버 설정
	   public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	   public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe";

	   // main
	   public static void main(String[] args) throws IOException {
	      // 파일 저장경로
		   File fileSave = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\crawlingData4.csv");

	      BufferedWriter bw = new BufferedWriter(new FileWriter(fileSave));
	      // 크롬드라이버 설정
	      try {
	         System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	      } catch (Exception e) {
	      }
	      ChromeOptions options = new ChromeOptions();
	      WebDriver driver = new ChromeDriver(options);
	      String totalData = "";
	      String totaltitle = "";
	      
	      // 사이트 진입
	         driver.get("https://www.worldathletics.org/records/by-category/world-records"); // 육상기록
	         
	         // 사이트 진입 후 cookies 팝업 클릭해서 팝업없애기
	         try {
	            Thread.sleep(3000); // 3초
	            driver.findElement(By.xpath("/html/body/div[7]/div")).click();
	            Thread.sleep(3000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         // Men Indoor tab 클릭
	         try {
	               driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/ul/li[4]/a")).click();
	               Thread.sleep(2000);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         
	         // progression tr의 행개수_ tr은 열
	         int progressionTrSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div[4]/table/tbody/tr")).size();
	         System.out.println(progressionTrSize);
	         
	         for(int k = 1; k < progressionTrSize; k++) {
	         
	        //back실행으로 초기화면이 tab1로 실행되므로	 
	        //Men Indoor tab 재클릭
	         try {
	            driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/ul/li[4]/a")).click();
	            Thread.sleep(3000);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	         
	         // Progression 화살표 클릭
	         driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[1]/div[4]/table/tbody/tr[" + k + "]/td[2]/a/i")).click();
	         
	         // 진입 버튼 클릭 후 로딩시간 고려해 대기
	         try {
	            Thread.sleep(3000); // 3초
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }

	         String tempRecordStart = "/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr[";
	         String tempRecordMiddle = "]/td[";
	         String tempRecordEnd = "]";
	         
	         //해당 테이블의 열 개수!!!!************************    제목은 table/thead/tr/th 로 찾아야한다.
	         int thSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/thead/tr/th")).size();
	         System.out.println("thSize => " + thSize);
	         
	         // 해당 종목 테이블 행 개수 획득
	         int innerRecordTableSize = driver.findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr")).size();
	         System.out.println(innerRecordTableSize);
	         
	         System.out.println("크롤링 시작");
	         
	         //정상 테이블일 경우
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
	                  mark = mark.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (wind.contains(",")) {
	                  wind = wind.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (competitor.contains(",")) {
	                  competitor = competitor.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (dob.contains(",")) {
	                  dob = dob.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (country.contains(",")) {
	                  country = country.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (venue.contains(",")) {
	                  venue = venue.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (date.contains(",")) {
	                  date = date.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               // 한번에 한 줄씩 입력
	               totalData = mark + "," + wind + "," + competitor + "," + dob + "," + country + "," + venue + ","
	                     + date;

	               // 파일쓰기
	               bw.write(totalData);
	               bw.newLine(); // 한 줄 쓰고 줄바꿈
	            }
	         } else if (thSize == 6) { // 비정상테이블
	            String tempRecordStart2 = "/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr[";
	            String tempRecordMiddle2 = "]/td[";
	            String tempRecordEnd2 = "]";

	            // 해당 종목 테이블 행 개수 획득
	            int innerRecordTableSize2 = driver
	                  .findElements(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div/div/div[2]/div/table/tbody/tr"))
	                  .size();
	            System.out.println(innerRecordTableSize2);

	            System.out.println("크롤링 시작");

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
	                  mark = mark.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (wind.contains(",")) {
	                  wind = wind.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (competitor.contains(",")) {
	                  competitor = competitor.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (dob.contains(",")) {
	                  dob = dob.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (country.contains(",")) {
	                  country = country.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (venue.contains(",")) {
	                  venue = venue.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               if (date.contains(",")) {
	                  date = date.replace(",", "*"); // 기록에 있는 콤마 *로 처리
	               }

	               // 한번에 한 줄씩 입력
	               totalData = mark + "," + wind + "," + competitor + "," + dob + "," + country + "," + venue + ","
	                     + date;

	               // 파일쓰기
	               bw.write(totalData);
	               bw.newLine(); // 한 줄 쓰고 줄바꿈
	            }
	         }
	         try {
	         driver.navigate().back();
	         Thread.sleep(3500); // 뒤로가기 후 3.5초 대기
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         }

	         bw.close();
	         System.out.println("크롤링 종료");
	      } // main
	   } // class