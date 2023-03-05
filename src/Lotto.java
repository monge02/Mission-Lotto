import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {

        //입력 클래스, 랜덤 클래스 생성
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("구입금액을 입력해 주세요.");

        //구입 금액 입력 값 만큼 rand 배열 행 생성
        int price = sc.nextInt() / 1000;
        int[][] rand = new int[price][6];

        System.out.println();
        System.out.println(price + "개를 구매했습니다.");

        // 랜덤 값 셋팅 후 중복 값이 있는지 체크
        for (int i = 0; i < rand.length; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                rand[i][j] = random.nextInt(45) + 1;
                // 중복 값 체크
                for (int k = 0; k < j; k++)
                {
                    if (rand[i][j] == rand[i][k])
                    {
                        j--;
                    }
                }
            }
            //rand 배열 오름차순 정렬
            Arrays.sort(rand[i]);
        }
        // 2차원배열 요소 값 출력 (향상된 for 문으로 바꾸면 가독성이 좋을거 같음)
        for (int i = 0; i < rand.length; i++)
        {
            System.out.print("[");
            int[] inRand = rand[i];
            for (int j = 0; j < inRand.length; j++)
            {
                // 마지막 인덱스 출력에 ", "가 붙지 않게 하기 위해서 if문 사용
                if (j != 5)
                {
                    System.out.print(inRand[j] + ", ");
                } else
                {
                    System.out.print(inRand[5]);
                }
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        //개행문자 제거로 버퍼 비우고 당첨 번호 입력한 다음 ","로 문자열 구분
        sc.nextLine();
        String lottoNum = sc.nextLine();
        String[] lottoNumArr = lottoNum.split(",");

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        //보너스 번호 입력
        int bonus = sc.nextInt();

        //String 타입의 숫자를 int 타입으로 변환
        int[] lottoNumber = new int[6];

        for (int i = 0; i < 6; i++)
        {
            lottoNumber[i] = Integer.parseInt(lottoNumArr[i]);
        }

        //구입한 로또와 당첨 번호가 몇 개 일치하는지 체크
        int ck3, ck4, ck5, ck5B, ck6, count, countB; // ex) ck3 : 3개 일치
        ck3 = ck4 = ck5 = ck5B = ck6 = count = countB = 0;
        for (int i = 0; i < rand.length; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                for (int k = 0; k < 6; k++)
                {
                    //rand[i][j] : 구입한 로또 랜덤 번호 == lottoNumber[k] : 당첨 번호
                    if (rand[i][j] == lottoNumber[k])
                    {
                        count++;
                    }
                    //구입한 로또 랜덤 번호와 보너스 번호 일치 체크
                    if (rand[i][j] == bonus)
                    {
                        countB++;
                    }
                }
            }
            //번호가 3개 이상 일치하면 ck++하면서 count를 다시 0으로 초기화하고 다음 rand[i]행 반복
            switch (count)
            {
                case 3: ck3++;
                        count = 0;
                        countB = 0;
                        break;
                case 4: ck4++;
                        count = 0;
                        countB = 0;
                        break;
                case 5: if (countB > 0)
                {
                    ck5B++;
                    count = 0;
                    countB = 0;
                } else
                {
                    ck5++;
                    count = 0;
                    countB = 0;
                }
                        break;
                case 6: ck6++;
                        count = 0;
                        break;
                default: count =0;
            }
        }

        //수익률
        long rateOfReturn = (ck3*5+ck4*50+ck5*1500+ck5B*30000+ck6*2000000)/price;

        //당첨 통계 출력
        System.out.println("\n" + "당첨 통계" + "\n---");
        System.out.println("3개 일치 (5,000원) - "+ck3+"개");
        System.out.println("4개 일치 (50,000원) - "+ck4+"개");
        System.out.println("5개 일치 (1,500,000원) - "+ck5+"개");
        System.out.println("5개, 보너스 볼 일치 (30,000,000원) - "+ck5B+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+ck6+"개");
        System.out.println("총 수익률은 "+rateOfReturn*100+"%입니다.");
    }
}