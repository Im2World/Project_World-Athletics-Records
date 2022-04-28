package worldathleticsPrj.NationSort_clean;
//���� ��� ī��Ʈ

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class NationSort_Comment {
	static String name = "crawlingData1";		//�������ֱ�
	static StringBuffer sb = new StringBuffer(); // StringBuffer ��ü����	
	static Map<String, Integer> nameMap = new HashMap<String, Integer>();

	
	public static void main(String[] args) throws IOException {
		FileRead();
		Filewriter();
	} // main

	public static void FileRead() throws IOException {

		//////// 1. HashMap �⺻����
		// map �� Ű�� ������ ����. => Ű�� �ߺ��� �ȵ�. ���� �ߺ�����.
		nameMap.get(nameMap); // ������ key�� value��ȯ. ��ã���� null��ȯ
		nameMap.containsKey("usa"); // ���ԵǾ����� true, �ƴϸ� false

		// ******���� a���� �����о ���� b�� ������ ���̹Ƿ� BufferedReader 1��, BufferedWriter 1��
		// ���� ��ü ���� �� �ش� ����� ���� �ҷ�����
		File file1 = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\" + name + ".csv");

		// br ���� BufferedReader ��ü ������ �б�
		BufferedReader br = new BufferedReader(new FileReader(file1));
		String readtxt;

		while ((readtxt = br.readLine()) != null) {
			// ���� �׸� ���� ���� ���ڿ� �迭 ����. => csv���� �������� ,�� �׸񳪴�
			String[] field = readtxt.split(","); // ���

			// USA��� ���� map�� ������ false
			if (nameMap.containsKey(field[4]) == false) {// Country�� ���� �ƴ϶��
				nameMap.put(field[4], 1); // �� �����̸��� ����
			} else {
				int count = nameMap.get(field[4]);
				nameMap.replace(field[4], count + 1); // �ش� ���� ������ ī��Ʈ 1 ������Ŵ.
			}
		} // while


		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(nameMap.entrySet());
		
		// Comparator�� ����Ͽ� HashMap �� ���� �������� ����
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
			// �� ��
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// �������� ����
//            return obj1.getValue().compareTo(obj2.getValue());
				// �������� ����
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});


		for (Entry<String, Integer> entry : entryList) {
			sb.append(entry.getKey() + ",");// �����̸��� ���
			sb.append(entry.getValue() + "," + "\n");// ī��Ʈ�� ���
		}
		br.close(); // ���۸��� close
		
		
		// ��� ���
		for (Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	} // FileRead

	
	public static void Filewriter() throws IOException {
		File file2 = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\SortResult\\" + name + "_Sort.csv"); // �ش� ���ϸ����� ������ ��.

		// BufferedWriter�� ���ο� ���� �����Ͽ� �� �ȿ� ���� �ۼ����ֱ�
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

		bw.write(sb.toString());
		bw.newLine(); // �ٹٲ�
		bw.flush();
		bw.close();// ���۶����� close
	}

} // class

