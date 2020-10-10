import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NOD {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());

        if (num1 <= 0 || num2 <= 0)
            throw new Exception();

        findNOD(num1, num2);
    }

    public static void findNOD (int num1, int num2) {
        int remOfDivFirst;
        int remOfDivSecond;
        int nod;

        if (num1 == num2) {
            nod = num1;
            System.out.println(nod);
        } else {
            int biggerNum = Math.max(num1, num2);
            int smallerNum = Math.min(num1, num2);

            remOfDivFirst = biggerNum % smallerNum;
            if (remOfDivFirst == 0) {
                nod = smallerNum;
                System.out.println(nod);
            } else if (smallerNum % remOfDivFirst == 0) {
                nod = remOfDivFirst;
                System.out.println(nod);
            } else if (smallerNum % remOfDivFirst != 0) {
                remOfDivSecond = smallerNum % remOfDivFirst;

                while (true) {
                    remOfDivFirst %= remOfDivSecond;
                    nod = remOfDivSecond;
                    if (remOfDivFirst == 0) {
                        System.out.println(nod);
                        break;
                    }

                    remOfDivSecond %= remOfDivFirst;
                    nod = remOfDivFirst;
                    if (remOfDivSecond == 0) {
                        System.out.println(nod);
                        break;
                    }
                }
            }
        }
    }
}
