package worldathleticsPrj.NationSort_clean;
//국가 목록 카운트

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
	static String name = "crawlingData1";		//변경해주기
	static StringBuffer sb = new StringBuffer(); // StringBuffer 객체생성	
	static Map<String, Integer> nameMap = new HashMap<String, Integer>();

	
	public static void main(String[] args) throws IOException {
		FileRead();
		Filewriter();
	} // main

	public static void FileRead() throws IOException {

		//////// 1. HashMap 기본설정
		// map 은 키와 값으로 저장. => 키는 중복이 안됨. 값은 중복가능.
		nameMap.get(nameMap); // 지정된 key의 value반환. 못찾으면 null반환
		nameMap.containsKey("usa"); // 포함되었으면 true, 아니면 false

		// ******파일 a에서 정보읽어서 파일 b에 저장할 것이므로 BufferedReader 1개, BufferedWriter 1개
		// 파일 객체 생성 후 해당 경로의 파일 불러오기
		File file1 = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\" + name + ".csv");

		// br 파일 BufferedReader 객체 생성해 읽기
		BufferedReader br = new BufferedReader(new FileReader(file1));
		String readtxt;

		while ((readtxt = br.readLine()) != null) {
			// 실제 항목 값들 담을 문자열 배열 선언. => csv파일 구분자인 ,로 항목나눔
			String[] field = readtxt.split(","); // 담기

			// USA라는 값이 map에 없으면 false
			if (nameMap.containsKey(field[4]) == false) {// Country가 빈값이 아니라면
				nameMap.put(field[4], 1); // 그 나라이름을 넣음
			} else {
				int count = nameMap.get(field[4]);
				nameMap.replace(field[4], count + 1); // 해당 값이 있으면 카운트 1 증가시킴.
			}
		} // while


		List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(nameMap.entrySet());
		
		// Comparator를 사용하여 HashMap 값 기준 내림차순 정렬
		Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
			// 값 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름차순 정렬
//            return obj1.getValue().compareTo(obj2.getValue());
				// 내림차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});


		for (Entry<String, Integer> entry : entryList) {
			sb.append(entry.getKey() + ",");// 나라이름만 출력
			sb.append(entry.getValue() + "," + "\n");// 카운트만 출력
		}
		br.close(); // 버퍼리더 close
		
		
		// 결과 출력
		for (Entry<String, Integer> entry : entryList) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	} // FileRead

	
	public static void Filewriter() throws IOException {
		File file2 = new File("C:\\Users\\IM\\Desktop\\javaBasicPrj\\worldathleticsPrj\\SortResult\\" + name + "_Sort.csv"); // 해당 파일명으로 저장할 것.

		// BufferedWriter로 새로운 파일 생성하여 그 안에 내용 작성해주기
		BufferedWriter bw = new BufferedWriter(new FileWriter(file2));

		bw.write(sb.toString());
		bw.newLine(); // 줄바꿈
		bw.flush();
		bw.close();// 버퍼라이터 close
	}

} // class

