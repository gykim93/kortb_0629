package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int lastQuotatinId;
    List<Quotation> quotations;

    App() {
        scanner = new Scanner(System.in);
        lastQuotatinId = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("프로그램 실행");
        System.out.println("== 명언 앱 ==");


        while (true) {
            System.out.print("명령) ");

            String cmd = scanner.nextLine().trim(); // 명령어 입력 시에 공백 제거

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();
                System.out.printf("%d번 명언이 등록되었습니다.\n", lastQuotatinId);

            } else if (cmd.equals("목록")) {
                actionList();
            } else if (cmd.startsWith("삭제?")) { // "삭제?"로 시작 하는지 삭제?id=1
                actionRemove(cmd);
            }
        }
    }

    void actionWrite() { // 등록
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim(); // 명언 입력 시 공백 제거

        System.out.print("작가 : ");
        String authorName = scanner.nextLine().trim();// 작가 입력 시 공백 제거

        lastQuotatinId++;

        int id = lastQuotatinId;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);
    }

    void actionList() { // 목록
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");

        if (quotations.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        }
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printf("%d / %s/ %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    void actionRemove(String cmd) {
        String[] cmdBits = cmd.split("\\?", 2);
        String action = cmdBits[0];
        String queryString = cmdBits[1];

        String[] queryStringBits = queryString.split("&");
        //queryStringBits[0] id=1
        //queryStringBits[1] archive=true

        int id = 0;
        for (int i = 0; i < queryStringBits.length; i++) {
            String queryParamStr = queryStringBits[i];

            String[] queryParamStrBits = queryParamStr.split("=", 2);

            String paramName = queryParamStrBits[0];
            String paramValue = queryParamStrBits[1];

            if (paramName.equals("id")) {
                id = Integer.parseInt(paramValue);
            }
        }
        System.out.printf("%d번 명언을 삭제합니다\n", id);
    }
}
