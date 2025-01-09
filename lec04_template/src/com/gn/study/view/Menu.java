package com.gn.study.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

// 사용자가 보게될 화면
// - 사용자에게 정보 입력받기
// - 결과 화면 출력
public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertCarOne(); break;
				case 2 : selectCarAll(); break;
				case 3 : selectCarOne(); break;
				case 4 : updateCarOne(); break;
				case 5 : deleteCarOne(); break;
			}	
		}
	}
	
	public void updateCarOne() {
		System.out.println("*** 수정 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("어떤 모델의 정보를 수정하시겠습니까?");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		sc.nextLine();
		Map<String,Object> map = new HashMap<String,Object>();
		
		System.out.print("모델명을 수정하시겠습니까? ");
		char modelFlag = sc.nextLine().charAt(0);
		if(modelFlag == 'Y') {
			System.out.print("모델명 : ");
			String modelName = sc.nextLine();
			map.put("car_model", modelName);
		}
		
		System.out.print("가격을 수정하시겠습니까? ");
		char priceFlag = sc.nextLine().charAt(0);
		if(priceFlag == 'Y') {
			System.out.print("가격 : ");
			int price = sc.nextInt();
			map.put("car_price", price);
			sc.nextLine();
		}
		
		System.out.print("출시일을 수정하시겠습니까? ");
		char dateFlag = sc.nextLine().charAt(0);
		if(dateFlag == 'Y') {
			System.out.print("출시일 : ");
			String date = sc.nextLine();
			map.put("car_date", date);
		}
		
		if(map.size() == 0) {
			System.out.println("수정 사항을 선택하지 않으셨습니다.");
		} else {
			int result = controller.updateCarOne(carNo,map);
			dmlResultPrint(result,"수정");	
		}
	}
	
	public void deleteCarOne() {
		System.out.println("*** 삭제 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
		System.out.println("삭제하고자 하는 자동차 번호를 입력하세요.");
		System.out.print("번호 : ");
		int carNo = sc.nextInt();
		int result = controller.deleteCarOne(carNo);
		dmlResultPrint(result,"삭제");
	}
	
	public void selectCarOne() {
		System.out.println("*** 단일 조회 ***");
		System.out.println("검색 기준으로 삼고 싶은 항목을 선택하세요.");
		System.out.println("1. 번호 / 2. 모델명 / 3. 가격 / 4. 출시일 ");
		System.out.print("선택 : ");
		int option = sc.nextInt();
		Object obj = new Object();
		
		List<Car> list = new ArrayList<Car>();
		switch(option) {
			case 1 : // 번호
				System.out.print("번호 : ");
				obj = sc.nextInt();break;
			case 2 : // 모델명
				sc.nextLine();
				System.out.print("모델명 : ");
				obj = sc.nextLine();break;
			case 3 : // 가격
				System.out.print("가격 : ");
				obj = sc.nextInt();break;
			case 4 : // 출시일
				sc.nextLine();
				System.out.print("출시일 : ");
				obj = sc.nextLine();break;
		}
		list = controller.searchCarList(option,obj);
		printList(list);
	}
	
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);
	}
	
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
	
	public void insertCarOne() {
		System.out.println("*** 추가 ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("다만, 출시일은 반드시 OOOO-OO-OO 형식으로 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.println("출시일 정보를 입력하시겠습니까?(Y/N)");
		String dateFlag = sc.nextLine();
		String date = null;
		if("Y".equals(dateFlag)) {
			System.out.print("출시일 : ");
			date = sc.nextLine();
		}
		int result = controller.insertCarOne(modelName,price,date);
		dmlResultPrint(result,"추가");
	}
	
	public void dmlResultPrint(int result, String menuName) {
		if(result > 0) System.out.println(menuName+"이(가) 정상 수행되었습니다.");
		else System.out.println(menuName+"중 오류가 발생하였습니다.");
	}
	
	
	
	
	
	
}
