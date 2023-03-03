import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] arr = new int[6];

        System.out.println("구입금액을 입력해 주세요.");
        int price = sc.nextInt() / 1000;
        System.out.print("\n");

        System.out.println(price + "개를 구매했습니다.");

        for (int i = 0; i < price; i++) {
            for (int j = 0; j < 6; j++) {
                arr[j] = random.nextInt(45) + 1;

                for (int k = 0; k < j; k++) {
                    if (arr[j] == arr[k]) {
                        j--;
                    }
                }
            }
            Arrays.sort(arr);
            System.out.print("[");
            for (int l = 0; l < 6; l++) {
                if (l != 5) {
                    System.out.print(arr[l] + ", ");
                } else {
                    System.out.print(arr[5]);
                }
            }
            System.out.println("]");
        }
        System.out.print("\n");

        System.out.println("당첨 번호를 입력해 주세요.");

        sc.nextLine();
        String num = sc.nextLine();
        String[] numArr = num.split(",");

        System.out.print("\n");

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = sc.nextInt();

        System.out.println("\n"+"당첨 통계"+"\n---");

        int[] newArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            newArr[i] = Integer.parseInt(numArr[i]);
        }

        int i = 0;
        int j = 0;
        int count = 0;


        System.out.println(Arrays.toString(arr));
    }
}

// 새로운 2차 배열 int [price] [6] 에 결과값 저장 후 newArr[i]와 비교를 해보거나 ArrayList 배열 생성으로 바꿔서 값을 꺼내오는 방법을 시도해 봐야겠다...

