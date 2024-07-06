package com.ll;

import java.util.Scanner;

class App {
    void run() {
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");
        int lastQuotatinId = 0;
        while (true) {
            System.out.print("명령) ");
            
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine().trim(); // 명령어 입력 시에 공백 제거

            if (cmd.equals("종료")) {
                break;
            }
            else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine().trim(); // 명언 입력 시 공백 제거

                System.out.print("작가 : ");
                String authorName = scanner.nextLine().trim();// 작가 입력 시 공백 제거

                lastQuotatinId++;
                System.out.printf("%d번 명언이 등록되었습니다.\n",lastQuotatinId);
            }
        }
    }
}
