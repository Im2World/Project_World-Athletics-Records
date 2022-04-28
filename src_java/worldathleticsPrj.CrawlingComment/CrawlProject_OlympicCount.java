package worldathleticsPrj.CrawlingComment_clean;
//������� ��з� ����(Women Outdoor, Women Indoor ...) �� ���� ī��Ʈ
//�ش籹���� ��� ����� ���ϳ� ī��Ʈ�Ѵ�.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class CrawlProject_OlympicCount {
	static String name = "crawlingData5";		//�������ֱ�
	

	public static void main(String[] args) throws IOException {
		// ó���� �ð� ȹ��
		long start = System.currentTimeMillis();
		System.out.print("���۽ð� : ");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(start));

		Count(); // �޼��� ȣ��

		// ó���� �ð� ȹ��
		long end = System.currentTimeMillis();
		System.out.print("���� �� �ð� : ");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(end));

		// �ð����� ���_�����Է±��� ������ �ɸ��ð�
		System.out.println("�ҿ�ð� : " + (end - start) / 1000.0 + " seconds\n");
	}

	public static void Count() throws IOException {
		String[] ASIA = {"URS", "JPN", "RUS", "QAT", "TPE", "CHN", "BRN", "PRK", "TUR"};
		String[] EUROPE = {"SWE", "FIN", "FRA", "GBR", "FRG", "GDR", "HUN", "GER", "ITA", "NOR", "TCH", "POL", "UKR", "MAR", "BEL", "DEN", "CZE", "NED","GRE", "ESP", "SUI", "POR", "IRL, ROU", "BUL", "AUT", "BLR", "LTU", "YUG", "ISL", "SLO"};
		String[] NORTHAMERICA = {"USA", "MEX", "CUB", "CAN", "HAI", "PAN"};
		String[] SOUTHTHAMERICA = {"BRA", "ECU", "VEN"};
		String[] OCEANIA = {"AUS","NZL"};
		String[] AFRICA = {"KEN", "JAM", "ETH", "RSA", "UGA", "ALG", "TAN", "ERI", "DJI", "BUR", "NAM", "BDI", "MOZ"};
		int countASIA = 0, countEUROPE = 0, countNORTHAMERICA = 0, countSOUTHTHAMERICA = 0, countOCEANIA = 0, countAFRICA = 0;	//ī��Ʈ������ ����
		
		// ������ ����.
		File file = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\SortResult\\" + name + "_Sort.csv");

		// ���� ���� �޼ҵ� _ ������ 5���ϱ� ���ϵ� 5�� ����
		PrintWriter pw = new PrintWriter("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\output\\" + name + "_continent.csv");

		// ����� Ȯ�ο� �ܼ�â ���
		System.out.println("Reading from " + file); // �ܼ�â�� ���� �̸� ���

		// ������ �б� ���� - BufferedReader ��ü ����
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;

		// �� �پ� �д´�.
		while ((line = br.readLine()) != null) {
			// �޸� �и��Ͽ� �迭�� �ִ´�
			String[] data = line.split(",");

			// ������ �����͸� ���Ͽ� ī��Ʈ�Ѵ�.
			for (int i = 0; i < ASIA.length; i++) {
				if (data[0].equals(ASIA[i])) {
					countASIA = countASIA + Integer.parseInt(data[1]);		//�̹� ������ USA, 159 ������ => 159��� ���ڸ� �����ָ� ��.
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
		pw.flush(); // flush�� �о��ְ�
		pw.close(); // ����
		
		// �۾� �Ϸ�� �ܼ�â�� ǥ��
		System.out.println("Reading from all files" + " in directory " + file + " Completed");
	}
}
