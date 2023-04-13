/*
6603. Silver 2 - 로또

    시간 제한       메모리 제한      제출      정답      맞힌 사람       정답 비율
    1초            128MB          49699    28086     19472         55.361%


    문제
        독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
        로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
            예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])

        집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.


    입력
        입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
        입력의 마지막 줄에는 0이 하나 주어진다.


    출력
        각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
        각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.


    예제 입력 1
        7 1 2 3 4 5 6 7
        8 1 2 3 5 8 13 21 34
        0
    예제 출력 1
        1 2 3 4 5 6
        1 2 3 4 5 7
        1 2 3 4 6 7
        1 2 3 5 6 7
        1 2 4 5 6 7
        1 3 4 5 6 7
        2 3 4 5 6 7

        1 2 3 5 8 13
        1 2 3 5 8 21
        1 2 3 5 8 34
        1 2 3 5 13 21
        1 2 3 5 13 34
        1 2 3 5 21 34
        1 2 3 8 13 21
        1 2 3 8 13 34
        1 2 3 8 21 34
        1 2 3 13 21 34
        1 2 5 8 13 21
        1 2 5 8 13 34
        1 2 5 8 21 34
        1 2 5 13 21 34
        1 2 8 13 21 34
        1 3 5 8 13 21
        1 3 5 8 13 34
        1 3 5 8 21 34
        1 3 5 13 21 34
        1 3 8 13 21 34
        1 5 8 13 21 34
        2 3 5 8 13 21
        2 3 5 8 13 34
        2 3 5 8 21 34
        2 3 5 13 21 34
        2 3 8 13 21 34
        2 5 8 13 21 34
        3 5 8 13 21 34


    알고리즘 분류
        수학
        조합론
        백트래킹
        재귀
*/


// 메모리 : 16272KB
// 시간 : 352ms
// 코드 길이 : 1801B
// 정답

package baekjoon.bruteforce._6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C0012S_6603 {
    static int k; // k 개의 수
    static int S[]; // k 개의 수만큼 로또 번호를 가지고 있는 집합 S
    static boolean isSelected[]; // 해당 인덱스의 선택 여부를 나타내는 리스트
    static int selection[]; // 선택된 인덱스

    static void combination(int num, int start) {
        if (num == 6) { // 로또 번호를 6 개 뽑았다면(독일 로또는 여러 개의 수 중 6 개를 뽑는다.)
            for (int r = 0; r < num; r++) {
                System.out.print(S[selection[r]] + " ");
            }
            System.out.println();

            return;
        }

        for (int s = start; s < k; s++) {
            if (isSelected[s]) {
                continue;
            }

            isSelected[s] = true;
            selection[num] = s;
            combination(num + 1, s);
            isSelected[s] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token;

        while (true) {
            token = new StringTokenizer(bf.readLine());
            k = Integer.parseInt(token.nextToken());

            if (k == 0) { // 입력의 마지막 줄에는 0이 하나 주어지므로 0일 경우 종료
                break;
            }

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(token.nextToken());
            }

            isSelected = new boolean[k];
            selection = new int[6];

            combination(0, 0);
            System.out.println();
        }
    }
}
