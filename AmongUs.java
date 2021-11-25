import java.util.*;

public class AmongUs {
    /**
     * Find out the imposter in the spaceship,
     * which each crew-mate suspect one other person,
     * while the imposter suspect nobody.
     *
     * @param n       number of people
     * @param suspect list of sus
     *                i.e. n = 2, suspect = [[1,2]] -> 1 suspect 2, and 2 suspect no one
     *                therefore 2 is the imposter
     * @return the label of the imposter or -1 if the imposter does not exist
     */
    public int findImposter(int n, int[][] suspect) {
        int[] imposter = new int[n];

        for(int[] ints: suspect){
            imposter[ints[0] - 1] = -1;
            imposter[ints[1] - 1]++;
        }

        for(int i = 0; i < n; i++){
            if(imposter[i] == n - 1) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        AmongUs au = new AmongUs();
        List<int[][]> tests = List.of(
                new int[][]{{1,2}},
                new int[][]{{1,3}, {2,3}},
                new int[][]{{1,3}, {2,3}, {3,2}},
                new int[][]{{1,2}, {2,3}},
                new int[][]{{1,3}, {1,4}, {2,3}, {2,4}, {4,3}});

        for (int[][] t : tests){
            Set<Integer> s = new HashSet<>();
            for (int[] ints : t) {
                s.add(ints[0]);
                s.add(ints[1]);
            }
            System.out.println(au.findImposter(s.size(), t));
        }
    }
}
