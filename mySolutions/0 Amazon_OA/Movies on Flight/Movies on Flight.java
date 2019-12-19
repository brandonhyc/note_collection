public class Main {
	public static void main(String[] args) {
		int[] movie_duration1 = {90, 85, 75, 60, 120, 150, 125};
		int d1 = 250;
		int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
		int d2 = 250;
		int[] movie_duration3 = {90, 85, 75, 60, 120,110,110, 150, 125};
		int d3 = 250;
		System.out.println(Arrays.toString(get2SumClosest(movie_duration1, d1-30))); // [0, 6]
		System.out.println(Arrays.toString(get2SumClosest(movie_duration2, d2-30))); // [3, 4]
		System.out.println(Arrays.toString(get2SumClosest(movie_duration3, d3-30))); // [5, 6]
	}

	private static int[] get2SumClosest(int[] movie_duration, int d) {
		
		int[] result = new int[]{-1, -1};
		Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
		int maxD = -1; 
		int maxM = -1;

		for (int i = 0; i < movie_duration.length; i++) {
			if (!numIndexMap.containsKey(movie_duration[i])) {
				numIndexMap.put(movie_duration[i], new ArrayList<>());
			}
			numIndexMap.get(movie_duration[i]).add(i);
		}

		Arrays.sort(movie_duration);
		int left = 0;
		int right = movie_duration.length - 1;
		
		while (left < right) {
			int sum = movie_duration[left] + movie_duration[right];

			if (sum <= d 
				&& (sum > maxD || (sum == maxD && Math.max(movie_duration[left], movie_duration[right]) > maxM))) {
				
				if (movie_duration[left] == movie_duration[right]) {
					result[0] = numIndexMap.get(movie_duration[left]).get(0);
					result[1] = numIndexMap.get(movie_duration[left]).get(1);
				} else {
					result[0] = numIndexMap.get(movie_duration[left]).get(0);
					result[1] = numIndexMap.get(movie_duration[right]).get(0);
				}
				maxD = sum;
				maxM = Math.max(movie_duration[left], movie_duration[right]);
			}
			
			if (sum > d) {
				right -= 1;
			} else {
				left += 1;
			}
		}

		return result;
	}
}