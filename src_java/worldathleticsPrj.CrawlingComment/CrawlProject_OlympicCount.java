package worldathleticsPrj.CrawlingComment_clean;
//대륙별로 대분류 종목(Women Outdoor, Women Indoor ...) 의 국가 카운트
//해당국가가 어느 대륙에 속하나 카운트한다.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class CrawlProject_OlympicCount {
	static String name = "crawlingData5";		//변경해주기
	

	public static void main(String[] args) throws IOException {
		// 처리전 시간 획득
		long start = System.currentTimeMillis();
		System.out.print("시작시간 : ");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(start));

		Count(); // 메서드 호출

		// 처리후 시간 획득
		long end = System.currentTimeMillis();
		System.out.print("종료 후 시간 : ");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(end));

		// 시간차이 출력_숫자입력까지 실제로 걸린시간
		System.out.println("소요시간 : " + (end - start) / 1000.0 + " seconds\n");
	}

	public static void Count() throws IOException {
		String[] ASIA = {"URS", "JPN", "RUS", "QAT", "TPE", "CHN", "BRN", "PRK", "TUR"};
		String[] EUROPE = {"SWE", "FIN", "FRA", "GBR", "FRG", "GDR", "HUN", "GER", "ITA", "NOR", "TCH", "POL", "UKR", "MAR", "BEL", "DEN", "CZE", "NED","GRE", "ESP", "SUI", "POR", "IRL, ROU", "BUL", "AUT", "BLR", "LTU", "YUG", "ISL", "SLO"};
		String[] NORTHAMERICA = {"USA", "MEX", "CUB", "CAN", "HAI", "PAN"};
		String[] SOUTHTHAMERICA = {"BRA", "ECU", "VEN"};
		String[] OCEANIA = {"AUS","NZL"};
		String[] AFRICA = {"KEN", "JAM", "ETH", "RSA", "UGA", "ALG", "TAN", "ERI", "DJI", "BUR", "NAM", "BDI", "MOZ"};
		int countASIA = 0, countEUROPE = 0, countNORTHAMERICA = 0, countSOUTHTHAMERICA = 0, countOCEANIA = 0, countAFRICA = 0;	//카운트변수들 선언
		
		// 파일을 연다.
		File file = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\SortResult\\" + name + "_Sort.csv");

		// 파일 저장 메소드 _ 종목이 5개니까 파일도 5개 생성
		PrintWriter pw = new PrintWriter("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\output\\" + name + "_continent.csv");

		// 사용자 확인용 콘솔창 출력
		System.out.println("Reading from " + file); // 콘솔창에 파일 이름 출력

		// 파일을 읽기 위해 - BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;

		// 한 줄씩 읽는다.
		while ((line = br.readLine()) != null) {
			// 콤마 분리하여 배열에 넣는다
			String[] data = line.split(",");

			// 각각의 데이터를 비교하여 카운트한다.
			for (int i = 0; i < ASIA.length; i++) {
				if (data[0].equals(ASIA[i])) {
					countASIA = countASIA + Integer.parseInt(data[1]);		//이미 파일이 USA, 159 형식임 => 159라는 숫자만 더해주면 됨.
				}
			}
			for (int i = 0; i < EUROPE.length; i++) {
				if (data[0].equals(EUROPE[i])) {
					countEUROPE = countEUROPE + Integer.parseInt(data[1]);
				}
			}
			for (int i = 0; i < NORTHAMERICA.length; i++) {
				if (data[0].equals(NORTHAMERICA[i])) {
					countNORTHAMERICA = countNORTHAMERICA + Integer.parseInt(data[1]);
				}
			}
			for (int i = 0; i < SOUTHTHAMERICA.length; i++) {
				if (data[0].equals(SOUTHTHAMERICA[i])) {
					countSOUTHTHAMERICA = countSOUTHTHAMERICA + Integer.parseInt(data[1]);
				}
			}
			for (int i = 0; i < OCEANIA.length; i++) {
				if (data[0].equals(OCEANIA[i])) {
					countOCEANIA = countOCEANIA + Integer.parseInt(data[1]);
				}
			}
			for (int i = 0; i < AFRICA.length; i++) {
				if (data[0].equals(AFRICA[i])) {
					countAFRICA = countAFRICA + Integer.parseInt(data[1]);
				}
			}
		}

		pw.write("ASIA," + countASIA + "\n");
		pw.write("EUROPE," + countEUROPE + "\n");
		pw.write("NORTHAMERICA," + countNORTHAMERICA + "\n");
		pw.write("SOUTHTHAMERICA," + countSOUTHTHAMERICA + "\n");
		pw.write("OCEANIA," + countOCEANIA + "\n");
		pw.write("AFRICA," + countAFRICA + "\n");
		pw.flush(); // flush로 털어주고
		pw.close(); // 닫음
		
		// 작업 완료시 콘솔창에 표시
		System.out.println("Reading from all files" + " in directory " + file + " Completed");
	}
}
