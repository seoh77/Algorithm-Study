package BOJ12015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        LIS(arr);


        System.out.println(answer);
    }

    static void LIS(int[] arr) {

        List<Integer> lis = new ArrayList<>();

        for (int num : arr) {
            int pos = binarySearch(lis, num);

            if (pos < lis.size()) {
                lis.set(pos, num);
            } else {
                lis.add(num);
            }
        }

        answer = lis.size();


    }

    static int binarySearch(List<Integer> list, int r) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < r) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
